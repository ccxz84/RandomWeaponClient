package RWAPI.items.gameItem;

import java.util.ArrayList;
import java.util.List;

import RWAPI.main;
import RWAPI.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{
	public ItemBase[] down_item;
	public int phase;
	
	public ItemBase(String name) {
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
