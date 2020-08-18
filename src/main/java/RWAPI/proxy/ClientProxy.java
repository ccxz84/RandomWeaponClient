package RWAPI.proxy;

import org.lwjgl.input.Keyboard;

import RWAPI.main;
import RWAPI.Character.Leesin.particle.ParticleFlame;
import RWAPI.Character.Player.RenderPlayer;
import RWAPI.event.ContainerEvent;
import RWAPI.event.SkillKeyEvent;
import RWAPI.event.joinEvent;
import RWAPI.gui.StatusOverlay;
import RWAPI.init.ModItems;
import RWAPI.init.handler.GuiHandler;
import RWAPI.init.handler.RegistryHandler;
import RWAPI.util.Reference;
import api.player.render.RenderPlayerAPI;
import api.player.render.RenderPlayerBaseSorting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy implements IProxy {
	public static KeyBinding[] keyBindings;
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		System.out.println("item : " + item.getRegistryName());
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
		System.out.println("item path : " +new ModelResourceLocation(item.getRegistryName(),id).getResourcePath());
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(Reference.MODID + "client :preinit");
		RegistryHandler.preInitRegistries();
		MinecraftForge.EVENT_BUS.register(new StatusOverlay());
		MinecraftForge.EVENT_BUS.register(new ContainerEvent());
		MinecraftForge.EVENT_BUS.register(new joinEvent());
		
		
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		System.out.println(Reference.MODID + "client :init");	
		RenderPlayerBaseSorting renderSorting = new RenderPlayerBaseSorting();
		RenderPlayerAPI.register(Reference.MODID, RenderPlayer.class, renderSorting);
		NetworkRegistry.INSTANCE.registerGuiHandler(main.instance, new GuiHandler());
		for(int i = 0; i<72; i++) {
			if(i==0) {
				ModItems.temp.add(ModItems.Dagger);
				continue;
			}
			if(i==1) {
				ModItems.temp.add(ModItems.Recurvebow);
				continue;
			}
			if(i==2) {
				ModItems.temp.add(ModItems.Bladeoftheruinedking);
				continue;
			}
			if(i==4) {
				ModItems.temp.add(ModItems.Bilgewatercutlass);
				continue;
			}
			
			
			if(i==71) {
				ModItems.temp.add(ModItems.LongSword);
				continue;
			}
			ModItems.temp.add(ModItems.VampiricScepter);
		}
		
		keyBindings = new KeyBinding[5];
		keyBindings[0] = new KeyBinding("key.skill1", Keyboard.KEY_Z, "key.skill.category");
		keyBindings[1] = new KeyBinding("key.skill2", Keyboard.KEY_X, "key.skill.category");
		keyBindings[2] = new KeyBinding("key.skill3", Keyboard.KEY_C, "key.skill.category");
		keyBindings[3] = new KeyBinding("key.skill4", Keyboard.KEY_V, "key.skill.category");
		//keyBindings[4] = new KeyBinding("key.inventory", Keyboard.KEY_E, "key.inventory.category");
		
		for (int i = 0; i < keyBindings.length; i++) 
		{
		    ClientRegistry.registerKeyBinding(keyBindings[i]);
		}
		Minecraft.getMinecraft().effectRenderer.registerParticle(200, new ParticleFlame.Factory());
	}


	@Override
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println(Reference.MODID + "client :postinit");
		StatusOverlay.InitItemRender();
		MinecraftForge.EVENT_BUS.register(new SkillKeyEvent());
	}

	@Override
	public void serverStarting(FMLServerStartingEvent event) {
		// TODO Auto-generated method stub
		
	}

}
