package RWAPI.gui;

import org.lwjgl.opengl.GL11;

import com.google.common.base.MoreObjects;

import RWAPI.main;
import RWAPI.Character.ClientData;
import RWAPI.init.ModItems;
import RWAPI.packet.EnemyStatPacket;
import RWAPI.packet.PlayerHealthStatMessage;
import RWAPI.util.Reference;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SPacketCustomPayload;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.Int;

public class StatusOverlay extends Gui {
	
	private static boolean EnemyStat;
	
	int halfWidth, defaultY;
	
	private final Minecraft mc;
	private static RenderItem itemRenderer;
	private static final ResourceLocation healthTexture = new ResourceLocation(Reference.MODID + ":textures/gui/interface.png");
	private static final ResourceLocation skill = new ResourceLocation(Reference.MODID + ":textures/gui/skillgui.png");
	private static final ResourceLocation Itemgui = new ResourceLocation(Reference.MODID + ":textures/gui/itemgui.png");
	protected static final ResourceLocation WIDGETS_TEX_PATH = new ResourceLocation(Reference.MODID + ":textures/gui/widgets.png");
	protected static final ResourceLocation gold = new ResourceLocation(Reference.MODID + ":textures/gui/gold.png");
	protected static final ResourceLocation icons = new ResourceLocation(Reference.MODID + ":textures/gui/icons.png");
	
	private int status_textureX = 181, status_textureY = 30;
	private int skill_textureX = 101, skill_textureY = 23;
	private int item_textureX = 64, item_textureY = 64;
	private int gold_textureX = 13, gold_textureY = 10;
	private int exp_textureX = 182, expTextureY = 5;
	
	public static String timerFlag = "";
	public static int timer = 0;
	
	public static int[] skillSet = {0,0,0,0,0};
	
	
	public static float PlayerMaxMana = 100, PlayerCurrentMana = 100;
	
	public static float PlayerMaxHealth = 100, PlayerCurrentHealth = 100;
	
	public static int Gold = 100;
	
	public static int level = 0;
	public static double expPer = 0;
	
	public static int Height;
	public static int Width;
	
	public static ClientData Enemydata = new ClientData();
	
	public static float[] cool = new float[14];
	
	public StatusOverlay() {
		this.mc = Minecraft.getMinecraft();
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent event)
	{
		if (event.getType() == ElementType.FOOD)
		{
			event.setCanceled(true);
			return;
		}
		if (event.getType() == ElementType.HEALTH)
		{
			event.setCanceled(true);
			return;
		}
		if (event.getType() == ElementType.EXPERIENCE)
		{
			event.setCanceled(true);
			return;
		}
		
		if(event.getType() == ElementType.HOTBAR) {
			event.setCanceled(true);
			return;
		}
		
		
		
		ScaledResolution res = event.getResolution();
		Width = res.getScaledWidth();
		halfWidth = Width/ 2;
		Height = res.getScaledHeight();
		
		float partialTicks = event.getPartialTicks();
		EntityPlayer player = (EntityPlayer)mc.getRenderViewEntity();
		defaultY =  Height - 22 + 22;
		// Draw Health Bar
		if(main.network != null) {
			main.network.sendToServer(new PlayerHealthStatMessage());
			main.network.sendToServer(new EnemyStatPacket());
		}
		//Level Bar
		float expper = main.data.exp / main.data.expmax;
		this.mc.getTextureManager().bindTexture(Gui.ICONS);
		this.drawTexturedModalRect(halfWidth - status_textureX/2, defaultY-5, 0, 64, exp_textureX, expTextureY);
		this.drawTexturedModalRect(halfWidth - status_textureX/2, defaultY-5, 0, 69, (int)(exp_textureX*expper), expTextureY);
		
		//Level Text
		
		drawTextShadow("LV. " + main.data.level, halfWidth - status_textureX/2 - "LV. 10".length() - 14, defaultY-8, 0xffffff, 1);
		
		
		float ManaPercent = main.data.CurrentMana / main.data.MaxMana;
		float HealthPercent = main.data.CurrentHealth / main.data.MaxHealth;
		
		this.mc.getTextureManager().bindTexture(healthTexture);
		
		String Health = (int)main.data.CurrentHealth + " / " + (int)main.data.MaxHealth;
		
		GL11.glColor4f(1, 1, 1, 1);
		this.drawTexturedModalRect(halfWidth - status_textureX/2, defaultY-status_textureY-expTextureY, 0,2, status_textureX, status_textureY);
		this.drawTexturedModalRect(halfWidth - status_textureX/2, defaultY-status_textureY+2-expTextureY, 0,31, (int)(HealthPercent * status_textureX), status_textureY/2-1);
		drawTextShadow(Health, halfWidth-Health.length()-4, defaultY-26-expTextureY, 0xffffff, 1);
		
		//Draw Mana Bar
		
		
		String Mana = (int)main.data.CurrentMana + " / " + (int)main.data.MaxMana;
		
		this.mc.getTextureManager().bindTexture(healthTexture);
		GL11.glColor4f(1, 1, 1,1);
		this.drawTexturedModalRect(halfWidth - status_textureX/2, defaultY-(status_textureY/2)-expTextureY, 0,43, (int)(ManaPercent * status_textureX), status_textureY/2-1);
		drawTextShadow(Mana, halfWidth-Mana.length()-4, defaultY-13-expTextureY, 0xffffff, 1);
		
		
		
		
		
		
		
		//Draw Enemy Bar		
		if(Enemydata.EnemyStat) {
			float EnemyPercent = Enemydata.CurrentHealth / Enemydata.MaxHealth;
			
			String EnemyHP = (int)Enemydata.CurrentHealth + " / " + (int)Enemydata.MaxHealth;
			
			this.mc.getTextureManager().bindTexture(healthTexture);
			this.drawTexturedModalRect(halfWidth - status_textureX/2,15,0,2,status_textureX, (status_textureY/2));
			drawTextShadow(Enemydata.Enemy, halfWidth - status_textureX/2, 6, 0xffffff , 1);
			
			this.mc.getTextureManager().bindTexture(healthTexture);
			GL11.glColor4f(1, 1, 1,1);
			this.drawTexturedModalRect(halfWidth - status_textureX/2, 17, 0,32, (int)(EnemyPercent * status_textureX), status_textureY/2-3);
			drawTextShadow(EnemyHP, halfWidth-EnemyHP.length()-4, 18, 0xffffff , 1);
		}
		
		//Draw Timer
		if(!(main.data.timerFlag.equals(""))) {
			drawTextShadow(main.data.timerFlag, 3, 4, 0xffffff , (float)1);
			drawTextShadow(main.data.timer/60 + ":" +String.format("%02d", main.data.timer%60), 12, 12, 0xffffff , (float)1.001);
		}
		
		
		//Draw ItemUI
		this.mc.getTextureManager().bindTexture(Itemgui);
		GL11.glColor4f(1, 1, 1,1);
		this.drawTexturedModalRect(res.getScaledWidth()-item_textureX, Height-item_textureY - gold_textureY, 0,0, item_textureX, item_textureY);
		
		//Draw SkillUI
		this.mc.getTextureManager().bindTexture(skill);
		GL11.glColor4f(1, 1, 1,1);
		this.drawTexturedModalRect(0, Height-skill_textureY, 0,0, skill_textureX,skill_textureY);
		
		//Draw item
		GlStateManager.enableRescaleNormal();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderHelper.enableGUIStandardItemLighting();
        
        for(int i=0;i<3;i++) {
        	for(int j=0;j<3;j++) {
        		this.renderHotbarItem(res.getScaledWidth()-item_textureX + 3 + 20*j, Height - gold_textureY-item_textureY + 3 + 21*i, partialTicks, player, player.inventory.mainInventory.get(i*3+j));
        	}
        }
        
        
        
        
        
        //Draw ItemGold
        this.mc.getTextureManager().bindTexture(gold);
		GL11.glColor4f(1, 1, 1,1);
		this.drawTexturedModalRect(res.getScaledWidth()-item_textureX, Height-gold_textureY, 0,0, gold_textureX, gold_textureY);
		
		
		drawTextShadow(""+main.data.Gold, res.getScaledWidth()-item_textureX + gold_textureX + 8 + "100".length()-4, Height-gold_textureY, 0xffffff, (float)1.2);
        
        
        //this.renderHotbarItem(3 + 20, res.getScaledHeight()-skill_textureY + 3, partialTicks, player, player.inventory.mainInventory.get(1));
		
		//Draw ItemBox
		this.mc.getTextureManager().bindTexture(WIDGETS_TEX_PATH);
		GL11.glColor4f(1, 1, 1,1);
		int i = player.inventory.currentItem/3, j = player.inventory.currentItem % 3;
		this.drawTexturedModalRect(res.getScaledWidth()-item_textureX + 20*j, Height-item_textureY- gold_textureY + 21*i, 0, 22, 22, 22);
		RenderSkillIcon(res,partialTicks,player);
		
		
		//drawSkillCool
		for(int x = 0;x<14;x++) {
			if(main.data.cool[x] > 0) {
				if(x < 5) {
					GlStateManager.disableLighting();
	                GlStateManager.disableDepth();
	                GlStateManager.disableBlend();
					if(main.data.cool[x] < 1) {
						drawTextShadow(""+String.format("%.2f", main.data.cool[x]),2+20*x+2,Height-20+3,0xffffff , (float)1);
					}
					else {
						
						String text = ""+String.format("%d", (int)main.data.cool[x]);
						drawTextShadow(text,2+20*x+9-text.length()*2,Height-20+3,0xffffff , (float)1);
					}
					GlStateManager.enableLighting();
	                GlStateManager.enableDepth();
	                GlStateManager.enableBlend();
				}
			}
		}
		
	}
	
	
	
	
	public void DrawHpMpBar() {
		
	}
	
	public void setEnemyStat(boolean stat) {
		this.EnemyStat = stat;
	}
	
	public static void InitItemRender() {
		itemRenderer = Minecraft.getMinecraft().getRenderItem();
	}
	
	
	
	private void drawText(String text, int x, int y, int hexColor , float size) {
		GL11.glScalef(size,size,size);
		float mSize = (float)Math.pow(size,-1);
		
		this.mc.fontRenderer.drawString(text, Math.round(x / size),Math.round(y / size), hexColor);
		GL11.glScalef(mSize,mSize,mSize);
	}
	
	private void drawTextShadow(String text, int x, int y, int hexColor , float size)
	{
		GL11.glScalef(size,size,size);
		float mSize = (float)Math.pow(size,-1);
		this.mc.fontRenderer.drawString(text, Math.round(x / size) + 1, Math.round(y / size), 0);
		this.mc.fontRenderer.drawString(text, Math.round(x / size) - 1, Math.round(y / size), 0);
		this.mc.fontRenderer.drawString(text, Math.round(x / size), Math.round(y / size) + 1, 0);
		this.mc.fontRenderer.drawString(text, Math.round(x / size), Math.round(y / size) - 1, 0);
		this.mc.fontRenderer.drawString(text, Math.round(x / size),Math.round(y / size), hexColor);
		GL11.glScalef(mSize,mSize,mSize);
	}
	
	protected void renderHotbarItem(int p_184044_1_, int p_184044_2_, float p_184044_3_, EntityPlayer player, ItemStack stack)
    {
        if (!stack.isEmpty())
        {
            float f = (float)stack.getAnimationsToGo() - p_184044_3_;

            if (f > 0.0F)
            {
                GlStateManager.pushMatrix();
                float f1 = 1.0F + f / 5.0F;
                GlStateManager.translate((float)(p_184044_1_ + 8), (float)(p_184044_2_ + 12), 0.0F);
                GlStateManager.scale(1.0F / f1, (f1 + 1.0F) / 2.0F, 1.0F);
                GlStateManager.translate((float)(-(p_184044_1_ + 8)), (float)(-(p_184044_2_ + 12)), 0.0F);
            }

            itemRenderer.renderItemAndEffectIntoGUI(player, stack, p_184044_1_, p_184044_2_);

            if (f > 0.0F)
            {
                GlStateManager.popMatrix();
            }

            itemRenderer.renderItemOverlays(this.mc.fontRenderer, stack, p_184044_1_, p_184044_2_);
        }
    }
	
	private void RenderSkillIcon(ScaledResolution res, float partialTicks ,EntityPlayer player) {
		for(int i = 0;i<5;i++) {
			this.renderHotbarItem(2+20*i, res.getScaledHeight()-20, partialTicks, player, new ItemStack(Item.getItemById(main.data.skillSet[i])));
		}
	}
}
