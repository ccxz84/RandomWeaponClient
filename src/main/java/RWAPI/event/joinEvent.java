package RWAPI.event;

import RWAPI.main;
import RWAPI.packet.*;
import RWAPI.packet.EnemyStatPacket.EnemyStatHandler;
import RWAPI.packet.InventoryOpenPacket.InventoryOpenHandler;
import RWAPI.packet.KeyInputPacket.KeyInputHandler;
import RWAPI.packet.PlayerHealthStatMessage.HealthStatusHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class joinEvent {
	@SubscribeEvent
	public void attackEvent(EntityJoinWorldEvent event)
	{
		if(event.getEntity() instanceof EntityPlayer && main.network == null) {
			main.network = NetworkRegistry.INSTANCE.newSimpleChannel(event.getEntity().getName());
			int channel = 1;
			//main.network.registerMessage(HealthStatusHandler.class, PlayerHealthStatMessage.class, channel++, Side.CLIENT);
			//main.network.registerMessage(HealthStatusHandler.class, PlayerHealthStatMessage.class, channel++, Side.SERVER);
			main.network.registerMessage(KeyInputHandler.class, KeyInputPacket.class, channel++, Side.SERVER);
			main.network.registerMessage(InventoryOpenHandler.class, InventoryOpenPacket.class, channel++, Side.SERVER);
			main.network.registerMessage(EnemyStatHandler.class, EnemyStatPacket.class, channel++, Side.CLIENT);
			main.network.registerMessage(EnemyStatHandler.class, EnemyStatPacket.class, channel++, Side.SERVER);
			main.network.registerMessage(ShopScrollPacket.ShopScrollHandler.class, ShopScrollPacket.class, channel++, Side.SERVER);
			main.network.registerMessage(ShopPurchasePacket.ShopPurchaseHandler.class, ShopPurchasePacket.class, channel++, Side.SERVER);
		}
		
	}
}
