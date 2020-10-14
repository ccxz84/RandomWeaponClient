package RWAPI.items.gameItem;

import RWAPI.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class Voidstaff extends ItemBase {

	private final double magicper = 40;

	public Voidstaff(String name) {
		super(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
		down_item = new ItemBase[2];
		down_item[0] =ModItems.Blastingwand;
		down_item[1] =ModItems.Amplifyingtome;
		
		phase = 2;
		// TODO Auto-generated constructor stub
	}
}
