package RWAPI.items;

import RWAPI.init.ModItems;
import RWAPI.items.gameItem.ItemBase;
import RWAPI.main;
import RWAPI.util.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Ruby extends Item implements IHasModel {

	public Ruby (String name)
	{

		setUnlocalizedName(name);
		setRegistryName(name);
		this.maxStackSize = 1;
		setCreativeTab(CreativeTabs.MATERIALS);
	}

	@Override
	public void registerModels() {
		// TODO Auto-generated method stub
		main.proxy.registerItemRenderer(this, 0 ,"inventory");
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.clear();
	}

}
