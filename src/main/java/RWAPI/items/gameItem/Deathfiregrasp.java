package RWAPI.items.gameItem;

import RWAPI.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;

public class Deathfiregrasp extends ItemBase {

	public Deathfiregrasp(String name) {
		super(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
		down_item = new ItemBase[2];
		down_item[0] =ModItems.Amplifyingtome;
		down_item[1] =ModItems.Lostchapter;
		
		phase = 3;
		// TODO Auto-generated constructor stub
	}
}
