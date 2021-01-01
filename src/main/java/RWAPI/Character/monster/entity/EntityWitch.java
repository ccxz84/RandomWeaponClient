package RWAPI.Character.monster.entity;

import RWAPI.Character.ai.PlayerAIHurtByTarget;
import RWAPI.Character.ai.PlayerAIZombieAttack;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityWitch extends EntityMob{


	public EntityWitch(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	
	protected void entityInit()
    {
        super.entityInit();
    }

	protected void initEntityAI()
    {
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(2, new PlayerAIZombieAttack(this, 1.0D, false));
        this.applyEntityAI();
    }

    protected void applyEntityAI()
    {
    	
        this.targetTasks.addTask(2, new PlayerAIHurtByTarget(this, true));
    }
	
	@Override
	public boolean getCanSpawnHere() {
		// TODO Auto-generated method stub
		return true;
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0d);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
    }

    public static class effect extends EntityThrowable {

        public effect(World worldIn) {
            super(worldIn);
        }

        @Override
        protected void onImpact(RayTraceResult result) {

        }
    }
	
}
