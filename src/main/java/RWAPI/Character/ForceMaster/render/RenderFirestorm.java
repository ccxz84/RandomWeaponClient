package RWAPI.Character.ForceMaster.render;

import RWAPI.Character.ForceMaster.entity.EntityBlazingpalm;
import RWAPI.Character.ForceMaster.entity.EntityFirestorm;
import RWAPI.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

public class RenderFirestorm extends Render<EntityFirestorm>{

	//private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/firestorm.png");

	protected RenderFirestorm(RenderManager renderManager) {
		super(renderManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityFirestorm entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doRender(EntityFirestorm entity, double x, double y, double z, float entityYaw, float partialTicks) {

		
	}
	
	public static class Factory implements IRenderFactory<EntityFirestorm> {
		@Override
		public Render<? super EntityFirestorm> createRenderFor(RenderManager manager) {
			return new RenderFirestorm(manager);
		}
	}

}
