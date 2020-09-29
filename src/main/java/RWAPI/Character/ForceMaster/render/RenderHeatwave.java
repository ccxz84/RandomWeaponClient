package RWAPI.Character.ForceMaster.render;

import RWAPI.Character.ForceMaster.entity.EntityFirestorm;
import RWAPI.Character.ForceMaster.entity.EntityFrostpalm;
import RWAPI.Character.ForceMaster.entity.EntityHeatwave;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHeatwave extends Render<EntityHeatwave> {

    protected RenderHeatwave(RenderManager renderManager) {
        super(renderManager);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityHeatwave entity) {
        // TODO Auto-generated method stub
        return null;
    }

    public static class Factory implements IRenderFactory<EntityHeatwave> {
        @Override
        public Render<? super EntityHeatwave> createRenderFor(RenderManager manager) {
            return new RenderHeatwave(manager);
        }
    }
}
