package RWAPI.Character.monster.entity;

import RWAPI.Character.ai.PlayerAIHurtByTarget;
import RWAPI.Character.ai.PlayerAIZombieAttack;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIZombieAttack;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityMinion extends EntityMob{
	
	private static final DataParameter<Boolean> ARMS_RAISED = EntityDataManager.<Boolean>createKey(EntityMinion.class, DataSerializers.BOOLEAN);

	public EntityMinion(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	
	protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(ARMS_RAISED, Boolean.valueOf(false));
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

	public void setArmsRaised(boolean b) {
		// TODO Auto-generated method stub
		 this.getDataManager().set(ARMS_RAISED, Boolean.valueOf(b));
	}
	
}
