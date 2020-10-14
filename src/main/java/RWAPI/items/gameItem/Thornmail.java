package RWAPI.items.gameItem;

import RWAPI.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;

public class Thornmail extends ItemBase {

	public Thornmail(String name) {
		super(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
		down_item = new ItemBase[3];
		down_item[0] =ModItems.Bramblevest;
		down_item[1] =ModItems.Rubycrystal;
		down_item[2] =ModItems.Wardensmail;
		
		phase = 1;
		// TODO Auto-generated constructor stub
	}

}
