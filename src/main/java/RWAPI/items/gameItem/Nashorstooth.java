package RWAPI.items.gameItem;

import RWAPI.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;

public class Nashorstooth extends ItemBase {


	public Nashorstooth(String name) {
		super(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
		down_item = new ItemBase[2];
		down_item[0] =ModItems.Stinger;
		down_item[1] =ModItems.Fiendishcodex;
		
		phase = 1;
		// TODO Auto-generated constructor stub
	}
}