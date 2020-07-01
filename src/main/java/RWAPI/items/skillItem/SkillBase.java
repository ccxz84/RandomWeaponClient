package RWAPI.items.skillItem;

import java.util.ArrayList;
import java.util.List;

import RWAPI.main;
import RWAPI.init.ModItems;
import RWAPI.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SkillBase extends Item implements IHasModel{
	int ItemCode;
	
	public SkillBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		this.maxStackSize = 1;
		ModItems.skill.add(this);
		ItemCode = Item.getIdFromItem(this);
	}

	@Override
	public void registerModels() {
		// TODO Auto-generated method stub
		main.proxy.registerItemRenderer(this, 0 ,"inventory");
	}

}
