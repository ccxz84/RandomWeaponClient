package RWAPI.items.weapon;

import RWAPI.main;
import RWAPI.util.IHasModel;
import net.minecraft.item.Item;

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
}
