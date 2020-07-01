package RWAPI.Character.shop.render;

import RWAPI.Character.Leesin.entity.EntityUmpa;
import RWAPI.Character.Leesin.render.RenderUmpa;
import RWAPI.Character.shop.entity.EntityMerchant;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMerchant extends RenderLiving<EntityMerchant> {

	private static final ResourceLocation VILLAGER_TEXTURES = new ResourceLocation("textures/entity/villager/villager.png");
    private static final ResourceLocation FARMER_VILLAGER_TEXTURES = new ResourceLocation("textures/entity/villager/farmer.png");
    private static final ResourceLocation LIBRARIAN_VILLAGER_TEXTURES = new ResourceLocation("textures/entity/villager/librarian.png");
    private static final ResourceLocation PRIEST_VILLAGER_TEXTURES = new ResourceLocation("textures/entity/villager/priest.png");
    private static final ResourceLocation SMITH_VILLAGER_TEXTURES = new ResourceLocation("textures/entity/villager/smith.png");
    private static final ResourceLocation BUTCHER_VILLAGER_TEXTURES = new ResourceLocation("textures/entity/villager/butcher.png");
    
    private static final ModelVillager model = new ModelVillager(0.0F);

	public RenderMerchant(RenderManager renderManagerIn) {
		super(renderManagerIn, model, 0.5F);
        this.addLayer(new LayerCustomHead(this.getMainModel().villagerHead));
		// TODO Auto-generated constructor stub
	}
	
	public ModelVillager getMainModel()
    {
		return model;
    }
	
	
	
	public static class Factory implements IRenderFactory<EntityMerchant> {
		@Override
		public Render<? super EntityMerchant> createRenderFor(RenderManager manager) {
			return new RenderMerchant(manager);
		}	
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMerchant entity) {
		// TODO Auto-generated method stub
		return FARMER_VILLAGER_TEXTURES;
	}
	
	
}
