package RWAPI.Character;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;	

public class ClientData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public boolean start = false;
	
	public boolean EnemyStat = false;
	
	public float MaxHealth = 100; 
	public float CurrentHealth= 100;
	
	public float MaxMana= 100;
	public float CurrentMana= 100;
	
	public float ad = 0;
	public float ap= 0;
	public float move = 100;
	public int level = 0;
	public float exp = 0;
	public float expmax = 0;
	
	public float regenHealth = 0;
	public float regenMana = 0;
	
	public float attackSpeed;
	
	public int Gold = 0;
	
	public String timerFlag = "";
	public int timer = 0;
	public  float[] cool = new float[14];
	
	public int[] skillSet = new int[5];
	
	public String Enemy;
	
	public ClientData() {
		this.EnemyStat = false;
		this.start = false;
	}
}
