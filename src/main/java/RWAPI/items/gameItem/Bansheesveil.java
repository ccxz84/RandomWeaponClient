package RWAPI.items.gameItem;

import RWAPI.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Bansheesveil extends ItemBase {

	public Bansheesveil(String name) {
		super(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
		down_item = new ItemBase[3];

		down_item[0] =ModItems.Fiendishcodex;
		down_item[1] =ModItems.Nullmagicmantle;
		down_item[2] =ModItems.Blastingwand;

		phase = 1;
		// TODO Auto-generated constructor stub
	}
}
