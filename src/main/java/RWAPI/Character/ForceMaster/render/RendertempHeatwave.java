package RWAPI.Character.ForceMaster.render;

import RWAPI.Character.ForceMaster.entity.EntityHeatwave;
import RWAPI.Character.ForceMaster.entity.EntitytempHeatwave;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RendertempHeatwave extends Render<EntitytempHeatwave>{

    protected RendertempHeatwave(RenderManager renderManager) {
        super(renderManager);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitytempHeatwave entity) {
        // TODO Auto-generated method stub
        return null;
    }

    public static class Factory implements IRenderFactory<EntitytempHeatwave> {
        @Override
        public Render<? super EntitytempHeatwave> createRenderFor(RenderManager manager) {
            return new RendertempHeatwave(manager);
        }
    }
}
