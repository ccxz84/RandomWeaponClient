package RWAPI.items.gameItem;

import RWAPI.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;

public class Spiritvisage extends ItemBase {

	public Spiritvisage(String name) {
		super(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
		down_item = new ItemBase[2];
		down_item[0] =ModItems.Spectrescowl;
		down_item[1] =ModItems.Kindlegem;
		
		phase = 3;
		// TODO Auto-generated constructor stub
	}
}
