package RWAPI.Character.Player;

import api.player.render.RenderPlayerAPI;
import api.player.render.RenderPlayerBase;

public class RenderPlayer extends RenderPlayerBase{

	public RenderPlayer(RenderPlayerAPI renderPlayerAPI) {
		super(renderPlayerAPI);
		// TODO Auto-generated constructor stub
		
		for (Object layerrenderer : this.renderPlayerAPI.getLayerRenderersField()) {
			if(layerrenderer instanceof net.minecraft.client.renderer.entity.layers.LayerHeldItem) {
				this.renderPlayerAPI.getLayerRenderersField().remove(layerrenderer);
				break;
			}
		}
		
		this.renderPlayer.addLayer(new LayerHeldItem(this.renderPlayer));
	}

	

	
	
	
	
}
