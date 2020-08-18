package RWAPI.Character.Leesin.render;

import org.lwjgl.opengl.GL11;

import RWAPI.Character.Leesin.entity.EntityResonating;
import RWAPI.Character.Leesin.entity.EntityStrike;
import RWAPI.Character.Leesin.entity.EntityUmpa;
import RWAPI.util.Reference;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderStrike extends Render<EntityStrike>{
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/crriple.png");
	
	public static float playerViewY;
	public static float playerViewX;

	protected RenderStrike(RenderManager renderManager) {
		super(renderManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doRender(EntityStrike entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(x, y, z);
		GlStateManager.pushAttrib();
		GlStateManager.enableBlend();
		GlStateManager.enableLighting();
		GlStateManager.enableTexture2D();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.scale(1.5F, 0.5F, 1.5F);
		this.bindTexture(this.getEntityTexture(entity));
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder buffer = tessellator.getBuffer();
		GlStateManager.rotate(playerViewY, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(-90f - playerViewX, 1.0F, 0.0F, 0.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F);
		buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_NORMAL);
		buffer.pos(-0.5D, -0.25D, 0.0D).tex(0, 1).normal(0.0F, 1.0F, 0.0F).endVertex();
		buffer.pos(0.5D, -0.25D, 0.0D).tex(1, 1).normal(0.0F, 1.0F, 0.0F).endVertex();
		buffer.pos(0.5D, 0.75D, 0.0D).tex(1, 0).normal(0.0F, 1.0F, 0.0F).endVertex();
		buffer.pos(-0.5D, 0.75D, 0.0D).tex(0, 0).normal(0.0F, 1.0F, 0.0F).endVertex();
		tessellator.draw();
		GlStateManager.pushMatrix();
		GlStateManager.translate(0, 0.5, 0);
		GlStateManager.pushAttrib();
		GlStateManager.rotate(-playerViewY, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(180f, 1.0F, 0.0F, 0.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F);
		buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_NORMAL);
		buffer.pos(-0.5D, -0.25D, 0.0D).tex(0, 1).normal(0.0F, 1.0F, 0.0F).endVertex();
		buffer.pos(0.5D, -0.25D, 0.0D).tex(1, 1).normal(0.0F, 1.0F, 0.0F).endVertex();
		buffer.pos(0.5D, 0.75D, 0.0D).tex(1, 0).normal(0.0F, 1.0F, 0.0F).endVertex();
		buffer.pos(-0.5D, 0.75D, 0.0D).tex(0, 0).normal(0.0F, 1.0F, 0.0F).endVertex();
		tessellator.draw();
		GlStateManager.popMatrix();
		GlStateManager.popAttrib();
		GlStateManager.popAttrib();
		GlStateManager.popMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityStrike entity) {
		// TODO Auto-generated method stub
		return TEXTURE;
	}
	
	public static class Factory implements IRenderFactory<EntityStrike> {
		@Override
		public Render<? super EntityStrike> createRenderFor(RenderManager manager) {
			return new RenderStrike(manager);
		}
	}

}
