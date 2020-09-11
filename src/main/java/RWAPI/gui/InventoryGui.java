package RWAPI.gui;

import RWAPI.Character.ClientData;
import RWAPI.util.NetworkUtil;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Slot;
import net.minecraft.nbt.NBTTagCompound;
import org.lwjgl.opengl.GL11;

import RWAPI.main;
import RWAPI.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InventoryGui extends GuiContainer {
	
	private static final ResourceLocation base_gui = new ResourceLocation(Reference.MODID + ":textures/gui/item_inventory.png");

	public InventoryGui(Container inventorySlotsIn) {
		super(inventorySlotsIn);
		// TODO Auto-generated constructor stub
		this.mc = Minecraft.getMinecraft();
		this.xSize = 176; 
        this.ySize = 166; 
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		GlStateManager.disableLighting();
		GlStateManager.disableDepth();
		GlStateManager.disableBlend();
		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 9; ++x) {
				double dcool = NetworkUtil.receiveItemCool(3*y+x);
				String cool = dcool < 1 ? String.format("%.2f", dcool) : String.format("%d", (int)dcool);

				if(dcool <= 0)
					continue;
				drawText(cool,8 + x * 18+ 4 , 51+y * 18 + 3,0xffffff);
			}
		}

		for (int x = 0; x < 9; ++x) {
			double dcool = NetworkUtil.receiveItemCool(x);
			String cool = dcool < 1 ? String.format("%.2f", dcool) : String.format("%d", (int)dcool);

			if(dcool <= 0)
				continue;
			drawText(cool,8 + x * 18 + 4, 108 + 3,0xffffff);
		}

		GlStateManager.enableLighting();
		GlStateManager.enableDepth();
		GlStateManager.enableBlend();

	}



	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		GL11.glColor4f(1, 1, 1, 1);
		this.mc.renderEngine.bindTexture(base_gui);
		drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		drawText("공격력", this.guiLeft + 10,this.guiTop + 10, 0xab1a1a);//빨간색
		drawText("" + (int)main.data.ad, this.guiLeft + 55,this.guiTop + 10, 0xffffff);
		
		drawText("주문력", this.guiLeft + 10,this.guiTop + 20, 0x254adb);//파란색
		drawText("" + (int)main.data.ap, this.guiLeft + 55,this.guiTop + 20, 0xffffff);
		
		drawText("이동속도", this.guiLeft + 10,this.guiTop + 30, 0x00000);//검은색
		drawText("" + (int)main.data.move, this.guiLeft + 55,this.guiTop + 30, 0xffffff);
		
		
		
		drawText("체력 재생", this.guiLeft + 100,this.guiTop + 10, 0x16c925);//빨간색
		drawText("" + String.format("%.2f",main.data.regenHealth), this.guiLeft + 145,this.guiTop + 10, 0xffffff);
		
		drawText("마나 재생", this.guiLeft + 100,this.guiTop + 20, 0xa816c9);//파란색
		drawText("" + String.format("%.2f",main.data.regenMana), this.guiLeft + 145,this.guiTop + 20, 0xffffff);
		
		drawText("공격 속도", this.guiLeft + 100,this.guiTop + 30, 0x0);//파란색
		drawText("" + String.format("%.2f",main.data.attackSpeed), this.guiLeft + 145,this.guiTop + 30, 0xffffff);
		
		drawText("경험치", this.guiLeft + 55,this.guiTop + 42, 0xffcf00);//파란색
		drawText((int)main.data.exp + " / " + (int)main.data.expmax, this.guiLeft + 90,this.guiTop + 42, 0xffffff);


	}



	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		// TODO Auto-generated method stub
		super.drawScreen(mouseX, mouseY, partialTicks);

		renderHoveredToolTip(mouseX,mouseY);
		
	}
	
	private void drawText(String text, int x, int y, int hexColor)
	{
		this.mc.fontRenderer.drawStringWithShadow(text, x, y, hexColor);
	}

	@Override
	protected void renderHoveredToolTip(int p_191948_1_, int p_191948_2_) {
		super.renderHoveredToolTip(p_191948_1_, p_191948_2_);
	}
}
