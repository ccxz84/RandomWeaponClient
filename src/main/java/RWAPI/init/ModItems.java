 package RWAPI.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import RWAPI.items.*;
import RWAPI.items.gameItem.*;
import RWAPI.items.skillItem.SkillBase;
import RWAPI.items.weapon.WeaponBase;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class ModItems {
	public static final List<ItemBase> ITEMS = new ArrayList<ItemBase>();
	public static final List<Item> skill = new ArrayList<Item>();
	public static final List<Item> weapon = new ArrayList<Item>();
	
	public static final Item RUBY = new Ruby("baseitem");
	public static final ItemBase LongSword = new LongSword("longsword");
	public static final ItemBase Dagger = new Dagger("dagger");
	public static final ItemBase Recurvebow = new Recurvebow("recurvebow");
	public static final ItemBase VampiricScepter = new VampiricScepter("vampiricscepter");
	public static final ItemBase Bilgewatercutlass = new Bilgewatercutlass("bilgewatercutlass");
	public static final ItemBase Bladeoftheruinedking = new Bladeoftheruinedking("bladeoftheruinedking");
	public static final ItemBase Serrateddirk = new Serrateddirk("serrateddirk");
	public static final ItemBase Caulfieldswarhammer = new Caulfieldswarhammer("caulfield'swarhammer");
	public static final ItemBase Youmuusghostblade = new Youmuusghostblade("youmuu'sghostblade");
	public static final ItemBase Rubycrystal = new Rubycrystal("rubycrystal");
	public static final ItemBase Kindlegem = new Kindlegem("kindlegem");
	public static final ItemBase Rejuvenationbead = new Rejuvenationbead("rejuvenationbead");
	public static final ItemBase Spectrescowl = new Spectrescowl("spectre'scowl");
	public static final ItemBase Spiritvisage = new Spiritvisage("spiritvisage");
	public static final ItemBase Giantsbelt = new Giantsbelt("giant'sbelt");
	public static final ItemBase Crystallinebracer = new Crystallinebracer("crystallinebracer");
	public static final ItemBase Warmogsarmor = new Warmogsarmor("warmog'sarmor");
	public static final ItemBase Amplifyingtome = new Amplifyingtome("amplifyingtome");
	public static final ItemBase Sapphirecrystal = new Sapphirecrystal("sapphirecrystal");
	public static final ItemBase Lostchapter = new Lostchapter("lostchapter");
	public static final ItemBase Deathfiregrasp = new Deathfiregrasp("deathfiregrasp");
	public static final ItemBase Needlesslylargerod = new Needlesslylargerod("needlesslylargerod");
	public static final ItemBase Rabadonsdeathcap = new Rabadonsdeathcap("rabadon'sdeathcap");
	public static final ItemBase Bootsofspeed = new Bootsofspeed("bootsofspeed");
	public static final ItemBase Bootsofswiftness = new Bootsofswiftness("bootsofswiftness");
	public static final ItemBase Berserkersgreaves = new Berserkersgreaves("berserker'sgreaves");
	public static final ItemBase Ninjatabi = new Ninjatabi("ninjatabi");
	public static final ItemBase Doransblade = new Doransblade("doran'sblade");
	public static final ItemBase Doransring = new Doransring("doran'sring");
	public static final ItemBase Huntersmachete = new Huntersmachete("hunter'smachete");
	public static final ItemBase Hunterstalisman = new Hunterstalisman("hunter'stalisman");
	
	/*
	 * 리신
	 */
	public static final SkillBase SonicWave = new SkillBase("leesin","sonicwave");
	public static final SkillBase dragonsRage = new SkillBase("leesin","dragonsrage");
	public static final SkillBase flurry = new SkillBase("leesin","flurry");
	public static final SkillBase resonatingstrike = new SkillBase("leesin","resonatingstrike");
	public static final SkillBase safeguard = new SkillBase("leesin","safeguard");
	public static final SkillBase tempest = new SkillBase("leesin","tempest");
	
	/*
	 * 마이
	 */
	public static final SkillBase doublestrike = new SkillBase("masteryi","doublestrike");
	public static final SkillBase alphastrike = new SkillBase("masteryi","alphastrike");
	public static final SkillBase meditation = new SkillBase("masteryi","meditation");
	public static final SkillBase wujustyle = new SkillBase("masteryi","wujustyle");
	public static final SkillBase highlander = new SkillBase("masteryi","highlander");

	public static final SkillBase blazingpalm = new SkillBase("forcemaster","blazingpalm");
	public static final SkillBase frostpalm = new SkillBase("forcemaster","frostpalm");
	public static final SkillBase firestorm = new SkillBase("forcemaster","firestorm");
	public static final SkillBase icecoil = new SkillBase("forcemaster","icecoil");
	public static final SkillBase blazingbeam = new SkillBase("forcemaster","blazingbeam");
	public static final SkillBase snowball = new SkillBase("forcemaster","snowball");
	public static final SkillBase heatwave = new SkillBase("forcemaster","heatwave");
	public static final SkillBase heatwave2 = new SkillBase("forcemaster","heatwave2");
	public static final SkillBase icerain = new SkillBase("forcemaster","icerain");
	public static final SkillBase inferno = new SkillBase("forcemaster","inferno");
	public static final SkillBase frostarmor = new SkillBase("forcemaster","frostarmor");
	public static final SkillBase frostarmor2 = new SkillBase("forcemaster","frostarmor2");
	
	public static final WeaponBase leesin = new RWAPI.items.weapon.leesin("leesin");
	public static final WeaponBase masteryi = new RWAPI.items.weapon.masteryi("masteryi");
	public static final WeaponBase formaster = new RWAPI.items.weapon.formaster("formaster");
	
}
