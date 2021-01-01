package RWAPI.Character.monster.render;

import RWAPI.Character.monster.entity.EntityDragon;
import RWAPI.Character.monster.model.ModelDragon;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

public class RenderDragon extends RenderLiving<EntityDragon> {

    private static final ResourceLocation DRAGON_TEXTURES = new ResourceLocation("textures/entity/enderdragon/dragon.png");
    private static final ResourceLocation DRAGON_EXPLODING_TEXTURES = new ResourceLocation("textures/entity/enderdragon/dragon_exploding.png");

    public RenderDragon(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelDragon(0.0f), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDragon entity) {
        return DRAGON_TEXTURES;
    }

    protected void renderModel(EntityDragon entitylivingbaseIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
    {

        this.bindEntityTexture(entitylivingbaseIn);
        GL11.glScalef(0.5f,0.5f,0.5f);
        this.mainModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
        GL11.glScalef(2,2,2);


        if (entitylivingbaseIn.hurtTime > 0)
        {
            GlStateManager.depthFunc(514);
            GlStateManager.disableTexture2D();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            GlStateManager.color(1.0F, 0.0F, 0.0F, 0.5F);
            this.mainModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.depthFunc(515);
        }
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    
    public static class Factory implements IRenderFactory<EntityDragon> {
		@Override
		public Render<? super EntityDragon> createRenderFor(RenderManager manager) {
			return new RenderDragon(manager);
		}	
	}
}
