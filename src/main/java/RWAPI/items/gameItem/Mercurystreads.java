package RWAPI.items.gameItem;

import RWAPI.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;

public class Mercurystreads extends ItemBase {

	public Mercurystreads(String name) {
		super(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
		down_item = new ItemBase[2];
		down_item[0] =ModItems.Bootsofspeed;
		down_item[1] =ModItems.Nullmagicmantle;
		
		phase = 2;
		// TODO Auto-generated constructor stub
	}

}