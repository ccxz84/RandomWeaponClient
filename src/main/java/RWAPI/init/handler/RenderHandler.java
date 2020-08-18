package RWAPI.init.handler;

import RWAPI.Character.Leesin.entity.EntityTempest;
import RWAPI.Character.Leesin.entity.EntityResonating;
import RWAPI.Character.Leesin.entity.EntityStrike;
import RWAPI.Character.Leesin.entity.EntityUmpa;
import RWAPI.Character.Leesin.render.RenderTempest;
import RWAPI.Character.Leesin.render.RenderResonating;
import RWAPI.Character.Leesin.render.RenderStrike;
import RWAPI.Character.Leesin.render.RenderUmpa;
import RWAPI.Character.MasterYi.entity.EntityAlpha;
import RWAPI.Character.MasterYi.render.RenderAlpha;
import RWAPI.Character.monster.entity.EntityMinion;
import RWAPI.Character.monster.render.RenderMinion;
import RWAPI.Character.shop.entity.EntityMerchant;
import RWAPI.Character.shop.render.RenderMerchant;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityUmpa.class, new RenderUmpa.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityMerchant.class, new RenderMerchant.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityMinion.class, new RenderMinion.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityResonating.class, new RenderResonating.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityStrike.class, new RenderStrike.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityTempest.class, new RenderTempest.Factory());
		RenderingRegistry.registerEntityRenderingHandler(EntityAlpha.class, new RenderAlpha.Factory());
	}
}
