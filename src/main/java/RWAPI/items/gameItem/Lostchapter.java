package RWAPI.items.gameItem;

import RWAPI.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;

public class Lostchapter extends ItemBase {

	public Lostchapter(String name) {
		super(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
		down_item = new ItemBase[3];
		down_item[0] = ModItems.Amplifyingtome;
		down_item[1] = ModItems.Sapphirecrystal;
		down_item[2] = ModItems.Amplifyingtome;
		
		phase = 2;
		// TODO Auto-generated constructor stub
	}
}