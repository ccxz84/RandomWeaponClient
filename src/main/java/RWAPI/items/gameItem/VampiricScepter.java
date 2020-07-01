package RWAPI.items.gameItem;

import RWAPI.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;

public class VampiricScepter extends ItemBase {

	public VampiricScepter(String name) {
		super(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
		down_item = new ItemBase[1];
		down_item[0] = ModItems.LongSword;
		
		phase = 2;
		// TODO Auto-generated constructor stub
	}

}
