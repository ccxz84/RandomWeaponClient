package RWAPI.items.gameItem;

import RWAPI.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;

public class Bladeoftheruinedking extends ItemBase {

	public Bladeoftheruinedking(String name) {
		super(name);
		
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
		down_item = new ItemBase[3];
		down_item[0] = ModItems.Bilgewatercutlass;
		down_item[1] = ModItems.Recurvebow;
		down_item[2] = ModItems.Bilgewatercutlass;
		
		phase = 1;
		// TODO Auto-generated constructor stub
	}

}
