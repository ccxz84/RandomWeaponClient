package RWAPI.items.gameItem;

import RWAPI.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;

public class Kindlegem extends ItemBase {

	public Kindlegem(String name) {
		super(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
		down_item = new ItemBase[1];
		down_item[0] =ModItems.Rubycrystal;
		
		phase = 2;
		// TODO Auto-generated constructor stub
	}

}