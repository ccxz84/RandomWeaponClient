package RWAPI.init.handler;

import RWAPI.init.EntityInit;
import RWAPI.init.ModItems;
import RWAPI.init.ModPotion;
import RWAPI.util.IHasModel;
import RWAPI.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler {
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
		event.getRegistry().registerAll(ModItems.skill.toArray(new Item[0]));
		event.getRegistry().registerAll(ModItems.weapon.toArray(new Item[0]));
		event.getRegistry().register(ModItems.RUBY);
	}

	@SubscribeEvent
	public static void onPotionRegister(RegistryEvent.Register<Potion> event) {
		ForgeRegistries.POTIONS.registerAll(ModPotion.POTIONS.toArray(new Potion[0]));
		ForgeRegistries.POTION_TYPES.registerAll(ModPotion.POTIONTYPES.toArray(new PotionType[0]));
		//event.getRegistry().registerAll(ModPotion.ITEMS.toArray(new Potion[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for (Item item : ModItems.ITEMS) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		for (Item item : ModItems.skill) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		
		for (Item item : ModItems.weapon) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		((IHasModel)ModItems.RUBY).registerModels();
	}

	public static void preInitRegistries() {
		RenderHandler.registerEntityRenders();
		EntityInit.addRegist();
		EntityInit.registerEntities();
	}
}
