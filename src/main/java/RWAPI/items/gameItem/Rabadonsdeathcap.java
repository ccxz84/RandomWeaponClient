package RWAPI.items.gameItem;

import RWAPI.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;

public class Rabadonsdeathcap extends ItemBase {

	public Rabadonsdeathcap(String name) {
		super(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
		down_item = new ItemBase[2];
		down_item[0] =ModItems.Needlesslylargerod;
		down_item[1] =ModItems.Needlesslylargerod;
		
		phase = 2;
		// TODO Auto-generated constructor stub
	}

}
