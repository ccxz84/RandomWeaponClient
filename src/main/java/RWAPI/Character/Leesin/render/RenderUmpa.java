package RWAPI.Character.Leesin.render;

import org.lwjgl.opengl.GL11;

import RWAPI.Character.Leesin.entity.EntityUmpa;
import RWAPI.Character.Leesin.model.ModelUmpa;
import RWAPI.util.Reference;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderUmpa extends Render<EntityUmpa> {
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/umpa.png");
	
	private ModelUmpa model = new ModelUmpa();
	@Override
	public void doRender(EntityUmpa entity, double x, double y, double z, float entityYaw, float partialTicks) {
		
		/*GlStateManager.pushMatrix();
	    GlStateManager.translate((float)x, (float)y, (float)z);
	    GL11.glScalef(2.0f,2.0f,2.0f);
	    float mSize = (float)Math.pow(2.0f,-1);
	    this.bindEntityTexture(entity);
	    GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
	    model.render(entity, partialTicks, 0f, -1f, 0f, 0f, 0.05f);
	    GL11.glScalef(mSize,mSize,mSize);
	    GlStateManager.popMatrix();
	    super.doRender(entity, x, y, z, entityYaw, partialTicks);*/
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
		GlStateManager.rotate(-90.0F - getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(-getRenderManager().playerViewX, 1.0F, 0.0F, 0.0F);
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

	protected RenderUmpa(RenderManager renderManager) {
		super(renderManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityUmpa entity) {
		// TODO Auto-generated method stub
		return TEXTURE;
	}
	
	public static class Factory implements IRenderFactory<EntityUmpa> {
		@Override
		public Render<? super EntityUmpa> createRenderFor(RenderManager manager) {
			return new RenderUmpa(manager);
		}
	}

}
