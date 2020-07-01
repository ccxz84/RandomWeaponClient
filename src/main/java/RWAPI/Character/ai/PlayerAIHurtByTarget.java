package RWAPI.Character.ai;

import RWAPI.Character.monster.entity.EntityMinion;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayerMP;

public class PlayerAIHurtByTarget extends EntityAITarget{
	
	private EntityLiving entity;

	public PlayerAIHurtByTarget(EntityLiving entityMinion, boolean checkSight) {
		super((EntityCreature) entityMinion, checkSight);
		this.entity =  entityMinion;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean shouldExecute() {
		// TODO Auto-generated method stub
		
		if(entity.getAttackingEntity() instanceof EntityPlayerMP) {
			entity.setAttackTarget(entity.getAttackingEntity());
		}
		if(entity.getAttackingEntity() == null) {
			entity.setAttackTarget(null);
		}
		return false;
	}

}
