package RWAPI.Character;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;	

public class ClientData implements Serializable{

	private static final long serialVersionUID = 1L;

	public boolean start = false;

	public boolean EnemyStat = false;

	public double MaxHealth = 100;
	public double CurrentHealth= 100;

	public double MaxMana= 100;
	public double CurrentMana= 100;

	public double ad = 0;
	public double ap= 0;
	public double move = 100;
	public int level = 0;
	public double exp = 0;
	public double expmax = 0;

	public double regenHealth = 0;
	public double regenMana = 0;

	public double armor;
	public double magicresistance;

	public double armorpenetration;
	public double magicpenetration;

	public double armorpenetrationper;
	public double magicpenetrationper;

	public double attackSpeed;

	public int Gold = 0;

	public String timerFlag = "";
	public int timer = 0;
	public  double[] cool = new double[14];

	public int[] skillSet = new int[5];

	public String Enemy;

	public double total_score;
	public int kill;
	public int death;
	public int cs;

	public ClientData() {
		this.EnemyStat = false;
		this.start = false;
	}
}
