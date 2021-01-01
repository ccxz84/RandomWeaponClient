package RWAPI.Character.monster.render;

import RWAPI.Character.monster.entity.EntityMinion;
import RWAPI.Character.monster.entity.EntityWitch;
import net.minecraft.client.model.ModelWitch;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWitch extends RenderLiving<EntityWitch> {

    private static final ResourceLocation WITCH_TEXTURES = new ResourceLocation("textures/entity/witch.png");

    public RenderWitch(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelWitch(0f), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWitch entity) {
        return WITCH_TEXTURES;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    
    public static class Factory implements IRenderFactory<EntityWitch> {
		@Override
		public Render<? super EntityWitch> createRenderFor(RenderManager manager) {
			return new RenderWitch(manager);
		}	
	}
}
