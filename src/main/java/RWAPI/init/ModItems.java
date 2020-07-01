 package RWAPI.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import RWAPI.items.*;
import RWAPI.items.gameItem.Bilgewatercutlass;
import RWAPI.items.gameItem.Bladeoftheruinedking;
import RWAPI.items.gameItem.Dagger;
import RWAPI.items.gameItem.ItemBase;
import RWAPI.items.gameItem.LongSword;
import RWAPI.items.gameItem.Recurvebow;
import RWAPI.items.gameItem.VampiricScepter;
import RWAPI.items.skillItem.SkillBase;
import RWAPI.items.weapon.WeaponBase;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	public static final List<ItemBase> temp = new ArrayList<ItemBase>();
	public static final List<Item> skill = new ArrayList<Item>();
	public static final List<Item> weapon = new ArrayList<Item>();
	
	public static final ItemBase RUBY = new Ruby("ruby");
	public static final ItemBase LongSword = new LongSword("longsword");
	public static final ItemBase Dagger = new Dagger("dagger");
	public static final ItemBase Recurvebow = new Recurvebow("recurvebow");
	public static final ItemBase VampiricScepter = new VampiricScepter("vampiricscepter");
	public static final ItemBase Bilgewatercutlass = new Bilgewatercutlass("bilgewatercutlass");
	public static final ItemBase Bladeoftheruinedking = new Bladeoftheruinedking("bladeoftheruinedking");
	
	/*
	 * 리신
	 */
	public static final SkillBase SonicWave = new SkillBase("sonicwave");
	public static final SkillBase dragonsRage = new SkillBase("dragonsrage");
	public static final SkillBase flurry = new SkillBase("flurry");
	public static final SkillBase resonatingstrike = new SkillBase("resonatingstrike");
	public static final SkillBase safeguard = new SkillBase("safeguard");
	public static final SkillBase tempest = new SkillBase("tempest");
	
	/*
	 * 마이
	 */
	public static final SkillBase doublestrike = new SkillBase("doublestrike");
	public static final SkillBase alphastrike = new SkillBase("alphastrike");
	public static final SkillBase meditation = new SkillBase("meditation");
	public static final SkillBase wujustyle = new SkillBase("wujustyle");
	public static final SkillBase highlander = new SkillBase("highlander");
	
	public static final WeaponBase leesin = new RWAPI.items.weapon.leesin("leesin");
	
}
