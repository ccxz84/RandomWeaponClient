package RWAPI;

import RWAPI.Character.ClientData;
import RWAPI.packet.EnemyStatPacket;
import RWAPI.packet.EnemyStatPacket.EnemyStatHandler;
import RWAPI.packet.InventoryOpenPacket;
import RWAPI.packet.InventoryOpenPacket.InventoryOpenHandler;
import RWAPI.packet.KeyInputPacket;
import RWAPI.packet.KeyInputPacket.KeyInputHandler;
import RWAPI.packet.PlayerHealthStatMessage;
import RWAPI.packet.PlayerHealthStatMessage.HealthStatusHandler;
import RWAPI.proxy.IProxy;
import RWAPI.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid=Reference.MODID, name=Reference.MODNAME, version=Reference.VERSION, acceptedMinecraftVersions=Reference.ACCEPTED_MINECRAFT_VERSIONS)
public class main {
	@Instance
	public static main instance;
	
	public static SimpleNetworkWrapper network;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static IProxy proxy;
	
	public static boolean gameStart = false;
	
	public static ClientData data = new ClientData();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(Reference.MODID + ":preInit");
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println(Reference.MODID + ":init");
		
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println(Reference.MODID + ":postInit");
		proxy.postInit(event);
	}
	
	@EventHandler
	public void ServerLoad(FMLServerStartingEvent event) {
		proxy.serverStarting(event);
	}
}
