package RWAPI.items.gameItem;

import RWAPI.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Serrateddirk extends ItemBase {

	public Serrateddirk(String name) {
		super(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
		down_item = new ItemBase[2];
		down_item[0] = ModItems.LongSword;
		down_item[1] = ModItems.LongSword;
		
		phase = 2;
		// TODO Auto-generated constructor stub
	}
}
