package RWAPI.gui.button;

import org.lwjgl.opengl.GL11;

import RWAPI.init.ModItems;
import RWAPI.items.gameItem.ItemBase;
import RWAPI.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemButton extends GuiButton{
	private static final ResourceLocation item = new ResourceLocation(Reference.MODID + ":textures/gui/vampiricscepter.png");
	private static ResourceLocation test_item;
	private ItemStack stack;
	private Minecraft mc;
	private RenderItem itemRenderer;
	
	public ItemButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, ItemStack stack) {
		super(buttonId, x, y, widthIn, heightIn, buttonText);
		this.stack = stack;
		this.mc = Minecraft.getMinecraft();
		itemRenderer = mc.getRenderItem();
		
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
		this.renderHotbarItem(this.x, this.y, partialTicks, mc.player, stack);
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
	
	
}
