package RWAPI.Character.Leesin.render;

import RWAPI.Character.Leesin.entity.EntityTempest;
import RWAPI.Character.Leesin.entity.EntityResonating;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTempest extends  Render<EntityTempest>{

	protected RenderTempest(RenderManager renderManager) {
		super(renderManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityTempest entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void doRender(EntityTempest entity, double x, double y, double z, float entityYaw, float partialTicks) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<720;i++) {
			double y1 = Math.sin(Math.toRadians(0.5*i));
			double x1 = Math.cos(Math.toRadians(0.5*i));
			Minecraft.getMinecraft().effectRenderer.spawnEffectParticle(200, entity.posX + (x1 * 0.3 * entity.i), entity.posY, (y1 * 0.3 * entity.i)+ entity.posZ, 0, 0, 0, 1);
			Minecraft.getMinecraft().effectRenderer.spawnEffectParticle(200, entity.posX + (x1 * 0.3 * entity.k), entity.posY+1-(0.2*entity.k), (y1 * 0.3 * entity.k)+ entity.posZ, 0, 0, 0, 1);
			Minecraft.getMinecraft().effectRenderer.spawnEffectParticle(200, entity.posX + (x1 * 0.3 * entity.j), entity.posY+1-(0.3*entity.j), (y1 * 0.3 * entity.j)+ entity.posZ, 0, 0, 0, 1);
		}
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	public static class Factory implements IRenderFactory<EntityTempest> {
		@Override
		public Render<? super EntityTempest> createRenderFor(RenderManager manager) {
			return new RenderTempest(manager);
		}
	}

}
