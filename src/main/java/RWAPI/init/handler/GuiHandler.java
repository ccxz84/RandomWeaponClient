package RWAPI.init.handler;

import RWAPI.gui.InventoryGui;
import RWAPI.gui.InventoryUI;
import RWAPI.gui.ShopGui;
import RWAPI.items.inventory.Inventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	public static final int MOD_INVENTORY_GUI = 1;
	public static final int MOD_SHOP_GUI = 2;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		if(ID == MOD_INVENTORY_GUI) {
			return new InventoryUI(player.inventory);
		}
		if(ID == MOD_SHOP_GUI) {
			
			return null;
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		if(ID == MOD_INVENTORY_GUI) {
			return new InventoryGui(new InventoryUI(player.inventory));
		}
		if(ID == MOD_SHOP_GUI) {
			return new ShopGui(new ShopGui.ShopUI(player.inventory));
		}
		
		
		return null;
	}

}
