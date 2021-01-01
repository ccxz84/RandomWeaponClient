package RWAPI.Character.monster.render;

import RWAPI.Character.ForceMaster.entity.EntitytempHeatwave;
import RWAPI.Character.monster.entity.EntityWitch;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class Rendereffect extends Render<EntityWitch.effect>{

    private static final ResourceLocation[] EFFECT_TEXTURES = new ResourceLocation[3];

    protected Rendereffect(RenderManager renderManager) {
        super(renderManager);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWitch.effect entity) {
        // TODO Auto-generated method stub
        return null;
    }

    public static class Factory implements IRenderFactory<EntityWitch.effect> {
        @Override
        public Render<? super EntityWitch.effect> createRenderFor(RenderManager manager) {
            return new Rendereffect(manager);
        }
    }
}
