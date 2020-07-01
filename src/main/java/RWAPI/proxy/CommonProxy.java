package RWAPI.proxy;

import RWAPI.main;
import RWAPI.Character.monster.entity.EntityMinion;
import RWAPI.init.handler.GuiHandler;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CommonProxy implements IProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FMLInitializationEvent event) {
		// TODO Auto-generated method stub
		NetworkRegistry.INSTANCE.registerGuiHandler(main.instance, new GuiHandler());
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void serverStarting(FMLServerStartingEvent event) {
		
	}

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		// TODO Auto-generated method stub
		
	}

}
