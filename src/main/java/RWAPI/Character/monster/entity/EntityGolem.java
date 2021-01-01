package RWAPI.Character.monster.entity;

import RWAPI.Character.ai.PlayerAIHurtByTarget;
import RWAPI.Character.ai.PlayerAIHurtByTargetObject;
import RWAPI.Character.ai.PlayerAIZombieAttack;
import RWAPI.Character.ai.PlayerAIZombieAttackObject;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class EntityGolem extends EntityMob{

    private static final DataParameter<Integer> attacktimer = EntityDataManager.<Integer>createKey(EntityGolem.class, DataSerializers.VARINT);
    private int attackTimer;
    private int holdRoseTick;

	public EntityGolem(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(attacktimer, 0);
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(2, new PlayerAIZombieAttackObject(this, 1.0D, false));
        this.tasks.addTask(2, new PlayerAIHurtByTargetObject(this, true));
        //this.tasks.addTask(1, new EntityAISwimming(this));
        //this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        //this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        //this.tasks.addTask(6, new EntityAILookIdle(this));
        this.applyEntityAI();
    }

    protected void applyEntityAI()
    {

    }

    public static void registerFixesIronGolem(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntityGolem.class);
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return LootTableList.ENTITIES_IRON_GOLEM;
    }

    @SideOnly(Side.CLIENT)
    public int getAttackTimer()
    {
        return this.attackTimer;
    }

    public int getHoldRoseTick()
    {
        return this.holdRoseTick;
    }

    public void onLivingUpdate()
    {
        super.onLivingUpdate();


        this.attackTimer = this.dataManager.get(attacktimer);
        if (this.holdRoseTick > 0)
        {
            --this.holdRoseTick;
        }
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

    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 4)
        {
            this.attackTimer = 10;
        }
        else if (id == 11)
        {
            this.holdRoseTick = 400;
        }
        else if (id == 34)
        {
            this.holdRoseTick = 0;
        }
        else
        {
            super.handleStatusUpdate(id);
        }
    }

    public boolean attackEntityAsMob(Entity entityIn)
    {
        System.out.println("asdf");
        this.attackTimer = 10;
        this.world.setEntityState(this, (byte)4);
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(15)));

        if (flag)
        {
            entityIn.motionY += 0.4000000059604645D;
            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }
	
}
