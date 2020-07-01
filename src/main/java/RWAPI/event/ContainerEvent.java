package RWAPI.event;

import RWAPI.main;
import RWAPI.init.handler.GuiHandler;
import RWAPI.packet.InventoryOpenPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ContainerEvent {
	
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event)
	{
		GuiScreen screen = Minecraft.getMinecraft().currentScreen;
		
		if (screen instanceof GuiInventory)
		{
			Minecraft.getMinecraft().displayGuiScreen((GuiScreen) null);
			main.network.sendToServer(new InventoryOpenPacket(Minecraft.getMinecraft().player.getUniqueID().toString()));
			
		}
	}
}
