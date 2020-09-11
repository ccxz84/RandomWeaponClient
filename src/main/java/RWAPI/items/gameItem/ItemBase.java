package RWAPI.items.gameItem;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import RWAPI.main;
import RWAPI.util.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemBase extends Item implements IHasModel{
	public ItemBase[] down_item;
	public int phase;
	public String name;
	public String gold;
	
	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName("item/"+name);
		this.maxStackSize = 1;
	}

	@Override
	public void registerModels() {
		// TODO Auto-generated method stub
		main.proxy.registerItemRenderer(this, 0 ,"inventory");
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.clear();
		NBTTagCompound nbt = stack.getTagCompound();
		if(nbt == null){
			tooltip.add("없음");
			return;
		}
		name = nbt.getString("name");
		tooltip.add(name);
		gold = nbt.getString("gold");
		tooltip.add(gold + " Gold");tooltip.add("");
		byte[] bs = nbt.getByteArray("stat");
		double[] stat = new double[0];
		ByteArrayInputStream bis = new ByteArrayInputStream(bs);
		try {
			ObjectInputStream ois = new ObjectInputStream(bis);
			stat = (double[])ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		if(stat[0] != 0){
			tooltip.add(TextFormatting.DARK_RED +"공격력 + " + stat[0]);
		}
		if(stat[1] != 0){
			tooltip.add(TextFormatting.BLUE +"주문력 + " + stat[1]);
		}
		if(stat[2] != 0){
			tooltip.add(TextFormatting.GREEN +"체력 + " + stat[2]);
		}
		if(stat[3] != 0){
			tooltip.add(TextFormatting.AQUA +"마나 + " + stat[3]);
		}
		if(stat[4] != 0){
			tooltip.add(TextFormatting.WHITE +"이동속도 + " + stat[4]);
		}
		if(stat[5] != 0){
			tooltip.add(TextFormatting.BOLD+"공격속도 + " + stat[5]);
		}
		if(stat[6] != 0){
			tooltip.add(TextFormatting.DARK_GREEN +"체력재생 + " + stat[6]);
		}
		if(stat[7] != 0){
			tooltip.add(TextFormatting.DARK_AQUA +"마나재생 +" + stat[7]);
		}

		String basic_effect, usage_effect;
		basic_effect = nbt.getString("basic");
		usage_effect = nbt.getString("usage");
		if(basic_effect.length() != 0){
			tooltip.add("");
			tooltip.add(TextFormatting.YELLOW + "고유 지속 효과 : "+TextFormatting.GRAY + basic_effect);
		}


		if(usage_effect.length() != 0){
			tooltip.add("");
			tooltip.add(TextFormatting.YELLOW + "고유 사용 효과 : " +TextFormatting.GRAY + usage_effect);
		}

	}


}
