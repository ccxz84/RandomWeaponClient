package RWAPI.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public interface IProxy {
	void preInit (FMLPreInitializationEvent event);
	void init (FMLInitializationEvent event);
    void postInit (FMLPostInitializationEvent event);
    void serverStarting (FMLServerStartingEvent event);
    public void registerItemRenderer(Item item, int meta, String id);
}
