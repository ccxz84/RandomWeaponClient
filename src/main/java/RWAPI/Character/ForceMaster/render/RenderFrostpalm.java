package RWAPI.Character.ForceMaster.render;

import RWAPI.Character.ForceMaster.entity.EntityBlazingpalm;
import RWAPI.Character.ForceMaster.entity.EntityFirestorm;
import RWAPI.Character.ForceMaster.entity.EntityFrostpalm;
import RWAPI.util.Reference;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

public class RenderFrostpalm extends Render<EntityFrostpalm>{

	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/frostpalm.png");

	protected RenderFrostpalm(RenderManager renderManager) {
		super(renderManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityFrostpalm entity) {
		// TODO Auto-generated method stub
		return TEXTURE;
	}

	@Override
	public void doRender(EntityFrostpalm entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(x, y, z);
		GlStateManager.pushAttrib();
		GlStateManager.enableBlend();
		GlStateManager.enableLighting();
		GlStateManager.enableTexture2D();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.scale(1F, 1F, 1F);
		this.bindTexture(this.getEntityTexture(entity));
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder buffer = tessellator.getBuffer();
		GlStateManager.rotate(180f - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(-75f, 1.0F, 0.0F, 0.0F);
		//GlStateManager.rotate(45f, 1.0F, 0.0F, 1.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F);
		buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_NORMAL);
		buffer.pos(-0.5D, -0.25D, 0.0D).tex(0, 1).normal(0.0F, 1.0F, 0.0F).endVertex();
		buffer.pos(0.5D, -0.25D, 0.0D).tex(1, 1).normal(0.0F, 1.0F, 0.0F).endVertex();
		buffer.pos(0.5D, 0.75D, 0.0D).tex(1, 0).normal(0.0F, 1.0F, 0.0F).endVertex();
		buffer.pos(-0.5D, 0.75D, 0.0D).tex(0, 0).normal(0.0F, 1.0F, 0.0F).endVertex();
		tessellator.draw();
		GlStateManager.popAttrib();
		GlStateManager.popMatrix();
	}
	
	public static class Factory implements IRenderFactory<EntityFrostpalm> {
		@Override
		public Render<? super EntityFrostpalm> createRenderFor(RenderManager manager) {
			return new RenderFrostpalm(manager);
		}
	}

}
