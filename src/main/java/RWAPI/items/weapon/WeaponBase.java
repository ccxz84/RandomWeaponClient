package RWAPI.items.weapon;

import RWAPI.main;
import RWAPI.util.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.List;

public class WeaponBase extends Item implements IHasModel{
	
	public WeaponBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		this.maxStackSize = 1;
	}
	
	@Override
	public void registerModels() {
		// TODO Auto-generated method stub
		main.proxy.registerItemRenderer(this, 0 ,"inventory");
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.clear();
		NBTTagCompound nbt = stack.getTagCompound();
		if(nbt == null){
			tooltip.add("없음");
			return;
		}
		String name = nbt.getString("name");
		tooltip.add(name);
	}
}
