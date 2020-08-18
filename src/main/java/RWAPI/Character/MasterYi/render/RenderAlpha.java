package RWAPI.Character.MasterYi.render;

import RWAPI.Character.MasterYi.entity.EntityAlpha;
import RWAPI.util.NetworkUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderAlpha extends Render<EntityAlpha> {

    EntityAlpha.message data;

    protected RenderAlpha(RenderManager renderManager) {
        super(renderManager);;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityAlpha entity) {
        return null;
    }

    @Override
    public void doRender(EntityAlpha entity, double x, double y, double z, float entityYaw, float partialTicks) {
        data = (EntityAlpha.message) NetworkUtil.receive("alphastrike");
        if(data != null){
            for(int i = 1; i < data.data.size();i++){
                double vx,vy,vz,dx,dy,dz,d;
                vx = data.data.get(i-1)[0] - data.data.get(i)[0];
                vy = data.data.get(i-1)[1] - data.data.get(i)[1];
                vz = data.data.get(i-1)[2] - data.data.get(i)[2];
                d = Math.sqrt(vx*vx + vy*vy + vz*vz);
                dx = vx/d;
                dy = vy/d;
                dz = vz/d;
                for(double j = 0; j < d;j = j + (d/20)){
                    Minecraft.getMinecraft().effectRenderer.spawnEffectParticle(200, data.data.get(i-1)[0] - dx * j, data.data.get(i-1)[1] - dy * j, data.data.get(i-1)[2] - dz * j, 0, 0, 0, 1);
                }
            }
        }
    }

    public static class Factory implements IRenderFactory<EntityAlpha> {
        @Override
        public Render<? super EntityAlpha> createRenderFor(RenderManager manager) {
            return new RenderAlpha(manager);
        }
    }
}
