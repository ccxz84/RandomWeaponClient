package RWAPI.items.weapon;

import RWAPI.main;
import RWAPI.init.ModItems;
import RWAPI.util.IHasModel;
import RWAPI.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class leesin extends WeaponBase{

	public leesin(String name) {
		super(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.weapon.add(this);
		// TODO Auto-generated constructor stub
	}

}