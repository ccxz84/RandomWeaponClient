package RWAPI.items.gameItem;

import RWAPI.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;

public class Duskbladeofdraktharr extends ItemBase {

	public Duskbladeofdraktharr(String name) {
		super(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
		down_item = new ItemBase[2];
		down_item[0] =ModItems.Serrateddirk;
		down_item[1] =ModItems.Caulfieldswarhammer;
		
		phase = 1;
		// TODO Auto-generated constructor stub
	}

}
