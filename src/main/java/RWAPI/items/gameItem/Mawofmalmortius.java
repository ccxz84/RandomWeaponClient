package RWAPI.items.gameItem;

import RWAPI.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;

public class Mawofmalmortius extends ItemBase {

	public Mawofmalmortius(String name) {
		super(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
		down_item = new ItemBase[2];
		down_item[0] =ModItems.Hexdrinker;
		down_item[1] =ModItems.Caulfieldswarhammer;
		
		phase = 1;
		// TODO Auto-generated constructor stub
	}

}