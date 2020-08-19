package RWAPI.items.gameItem;

import RWAPI.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;

public class Berserkersgreaves extends ItemBase {

	public Berserkersgreaves(String name) {
		super(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
		down_item = new ItemBase[2];
		down_item[0] =ModItems.Bootsofspeed;
		down_item[1] =ModItems.Dagger;
		
		phase = 2;
		// TODO Auto-generated constructor stub
	}
}
