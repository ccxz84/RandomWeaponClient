package RWAPI.items.inventory;


import RWAPI.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Inventory extends TileEntity implements IInventory{
	
	private final NonNullList<ItemStack> inventoryContents;
	private String CusName;
	
	

	public Inventory() {
		this.inventoryContents = NonNullList.<ItemStack>withSize(getSizeInventory(), ItemStack.EMPTY);
		
		
	}


	public String getCusName() {
		return CusName;
	}


	public void setCusName(String cusName) {
		CusName = cusName;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.hasCustomName() ? this.CusName : "container.tutorial_tile_entity";
	}

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return this.CusName != null && !this.CusName.equals("");
	}

	@Override
	public ITextComponent getDisplayName() {
		// TODO Auto-generated method stub
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 30;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index >= this.getSizeInventory()) {
			
	        return null;
		}
	    return this.inventoryContents.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		
		// TODO Auto-generated method stub
		if (this.getStackInSlot(index) != null) {
	        ItemStack itemstack;
	        
	        if (this.getStackInSlot(index).getMaxStackSize() <= count) {
	            itemstack = this.getStackInSlot(index);
	            this.setInventorySlotContents(index, ItemStack.EMPTY);
	            this.markDirty();
	            return itemstack;
	        } else {
	            itemstack = this.getStackInSlot(index).splitStack(count);

	            if (this.getStackInSlot(index).getMaxStackSize() <= 0) {
	                this.setInventorySlotContents(index, ItemStack.EMPTY);
	            } else {
	                //Just to show that changes happened
	                this.setInventorySlotContents(index, this.getStackInSlot(index));
	            }

	            this.markDirty();
	            return itemstack;
	        }
	    } else {
	        return null;
	    }
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		int stacksize = stack.getMaxStackSize();
		if (index < 0 || index >= this.getSizeInventory())
	        return;

	    if (stack != null && stack.getMaxStackSize() > this.getInventoryStackLimit())
	    	
	    	stacksize = this.getInventoryStackLimit();
	        
	    if (stack != null && stack.getMaxStackSize() == 0)
	        stack = null;

	    this.inventoryContents.set(index, stack);
	    this.markDirty();
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i <this.getSizeInventory (); i ++) 
	        this.setInventorySlotContents (i, null); 
	}
	
	public void setLowerLimit(int lim) {
		this.inventoryContents.clear();
		int x = 0;
		for(int i = lim; i<lim+30;i++) {
			if(i >=ModItems.ITEMS.size()){
				this.inventoryContents.set(x++,ItemStack.EMPTY);
			}
			else{
				this.inventoryContents.set(x++, new ItemStack(ModItems.ITEMS.get(i))); //수정
			}
		}
		
	}
	
	
}
