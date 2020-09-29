package RWAPI.init;

import java.util.ArrayList;
import java.util.List;

import RWAPI.Character.ForceMaster.entity.*;
import RWAPI.Character.MasterYi.entity.EntityAlpha;
import RWAPI.main;
import RWAPI.Character.Leesin.entity.EntityTempest;
import RWAPI.Character.Leesin.entity.EntityResonating;
import RWAPI.Character.Leesin.entity.EntityStrike;
import RWAPI.Character.Leesin.entity.EntityUmpa;
import RWAPI.Character.monster.entity.EntityMinion;
import RWAPI.Character.shop.entity.EntityMerchant;
import RWAPI.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	
	private static List<registData> data = new ArrayList<registData>();
	
	public static void registerEntities() {
	
		for(registData regist_data : data) {
			registerEntity(regist_data.name,regist_data.cla, regist_data.id, 50, 11437146, 000000);
		}
	
		
	}
	private static void registerEntity(String name, Class<? extends Entity> entity,int id, int range,int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID+":"+name), entity, name, id, main.instance, range, 1, true,color1,color2);
		
	}
	
	static class registData{
		private String name;
		private Class cla;
		private int id;
		
		registData(String name, Class cla, int id){
			this.name = name;
			this.cla = cla;
			this.id = id;
		}
	}

	public static void addRegist() {
		data.add(new registData("umpa",EntityUmpa.class,Reference.ENTITY_SONICWAVE));
		data.add(new registData("resonating",EntityResonating.class,Reference.ENTITY_RESONATING));
		data.add(new registData("strike",EntityStrike.class,Reference.ENTITY_STRIKE));
		data.add(new registData("tempest",EntityTempest.class,Reference.ENTITY_TEMPEST));
		data.add(new registData("merchant",EntityMerchant.class,Reference.ENTITY_MERCHANT));
		data.add(new registData("minion",EntityMinion.class,Reference.ENTITY_MINION));
		data.add(new registData("alphastrike", EntityAlpha.class,Reference.ENTITY_ALPHA));
		data.add(new registData("blazingpalm", EntityBlazingpalm.class,Reference.ENTITY_BLAZINGPALM));
		data.add(new registData("firstorm", EntityBlazingbeam.class,Reference.ENTITY_FIRESTORM));
		data.add(new registData("blazingbeam", EntityFirestorm.class,Reference.ENTITY_BLAZINGBEAM));
		data.add(new registData("tempheatwave", EntitytempHeatwave.class,Reference.ENTITY_TEMPHEATWAVE));
		data.add(new registData("heatwave", EntityHeatwave.class,Reference.ENTITY_HEATWAVE));
		data.add(new registData("inferno", EntityFrostpalm.class,Reference.ENTITY_INFERNO));
		data.add(new registData("frostpalm", EntityInferno.class,Reference.ENTITY_FROSTPALM));
		data.add(new registData("snowball", EntitySnowball.class,Reference.ENTITY_SNOWBALL));
		data.add(new registData("icerain", EntityIcerain.class,Reference.ENTITY_ICERAIN));
	}
}
