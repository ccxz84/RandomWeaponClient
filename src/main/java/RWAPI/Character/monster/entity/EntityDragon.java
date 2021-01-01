package RWAPI.Character.monster.entity;

import RWAPI.Character.ai.PlayerAIHurtByTarget;
import RWAPI.Character.ai.PlayerAIHurtByTargetObject;
import RWAPI.Character.ai.PlayerAIZombieAttack;
import RWAPI.Character.ai.PlayerAIZombieAttackObject;
import RWAPI.main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.boss.dragon.phase.IPhase;
import net.minecraft.entity.boss.dragon.phase.PhaseList;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathHeap;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.end.DragonFightManager;
import net.minecraft.world.gen.feature.WorldGenEndPodium;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.List;

public class EntityDragon extends EntityLiving implements IEntityMultiPart, IMob {

    public MultiPartEntityPart[] dragonPartArray;
    public MultiPartEntityPart dragonPartHead = new MultiPartEntityPart(this, "head", (float)Math.sqrt(3.0F), (float)Math.sqrt(3.0F));
    public MultiPartEntityPart dragonPartNeck = new MultiPartEntityPart(this, "neck", (float)Math.sqrt(6.0F), (float)Math.sqrt(6.0F));
    public MultiPartEntityPart dragonPartBody = new MultiPartEntityPart(this, "body", (float)Math.sqrt(8.0F), (float)Math.sqrt(8.0F));
    public MultiPartEntityPart dragonPartTail1 = new MultiPartEntityPart(this, "tail", (float)Math.sqrt(4.0F), (float)Math.sqrt(4.0F));
    public MultiPartEntityPart dragonPartTail2 = new MultiPartEntityPart(this, "tail", (float)Math.sqrt(4.0F), (float)Math.sqrt(4.0F));
    public MultiPartEntityPart dragonPartTail3 = new MultiPartEntityPart(this, "tail", (float)Math.sqrt(4.0F), (float)Math.sqrt(4.0F));
    public MultiPartEntityPart dragonPartWing1 = new MultiPartEntityPart(this, "wing", (float)Math.sqrt(4.0F), (float)Math.sqrt(4.0F));
    public MultiPartEntityPart dragonPartWing2 = new MultiPartEntityPart(this, "wing", (float)Math.sqrt(4.0F), (float)Math.sqrt(4.0F));
    public boolean slowed;
    public int deathTicks;
    public float prevAnimTime;
    public float animTime;
    public double[][] ringBuffer = new double[64][3];
    public int ringBufferIndex = -1;

    public EntityDragon(World worldIn)
    {
        super(worldIn);
        this.dragonPartArray = new MultiPartEntityPart[] {this.dragonPartHead, this.dragonPartNeck, this.dragonPartBody, this.dragonPartTail1, this.dragonPartTail2, this.dragonPartTail3, this.dragonPartWing1, this.dragonPartWing2};
        this.setHealth(this.getMaxHealth());
        this.setSize(16.0F, 8.0F);
        this.noClip = true;
        this.isImmuneToFire = true;
        this.ignoreFrustumCheck = true;

    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200.0D);
    }

    protected void entityInit()
    {
        super.entityInit();
    }

    @SideOnly(Side.CLIENT)
    public float getHeadPartYOffset(int p_184667_1_, double[] p_184667_2_, double[] p_184667_3_)
    {

        return (float)0d;
    }

    public double[] getMovementOffsets(int p_70974_1_, float p_70974_2_)
    {
        if (this.getHealth() <= 0.0F)
        {
            p_70974_2_ = 0.0F;
        }

        p_70974_2_ = 1.0F - p_70974_2_;
        int i = this.ringBufferIndex - p_70974_1_ & 63;
        int j = this.ringBufferIndex - p_70974_1_ - 1 & 63;
        double[] adouble = new double[3];
        double d0 = this.ringBuffer[i][0];
        double d1 = MathHelper.wrapDegrees(this.ringBuffer[j][0] - d0);
        adouble[0] = d0 + d1 * (double)p_70974_2_;
        d0 = this.ringBuffer[i][1];
        d1 = this.ringBuffer[j][1] - d0;
        adouble[1] = d0 + d1 * (double)p_70974_2_;
        adouble[2] = this.ringBuffer[i][2] + (this.ringBuffer[j][2] - this.ringBuffer[i][2]) * (double)p_70974_2_;
        return adouble;
    }

    private float getHeadYOffset(float p_184662_1_)
    {
        double d0;

        double[] adouble = this.getMovementOffsets(5, 1.0F);
        double[] adouble1 = this.getMovementOffsets(0, 1.0F);
        d0 = adouble[1] - adouble1[1];

        return (float)d0;
    }

    private float simplifyAngle(double p_70973_1_)
    {
        return (float)MathHelper.wrapDegrees(p_70973_1_);
    }

    public void onLivingUpdate()
    {

        if (this.world.isRemote)
        {
            if (!this.isSilent()) {
                float f = MathHelper.cos(this.animTime * ((float) Math.PI * 2F));
                float f1 = MathHelper.cos(this.prevAnimTime * ((float) Math.PI * 2F));
            }
        }

        this.prevAnimTime = this.animTime;

        float f11 = 0.2F / (MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ) * 10.0F + 1.0F);
        f11 = f11 * (float)Math.pow(2.0D, this.motionY);

        this.animTime += f11;

        this.rotationYaw = MathHelper.wrapDegrees(this.rotationYaw);

        if (this.isAIDisabled())
        {
            this.animTime = 0.5F;
        }
        else
        {
            if (this.ringBufferIndex < 0)
            {
                for (int i = 0; i < this.ringBuffer.length; ++i)
                {
                    this.ringBuffer[i][0] = (double)this.rotationYaw;
                    this.ringBuffer[i][1] = this.posY;
                }
            }

            if (++this.ringBufferIndex == this.ringBuffer.length)
            {
                this.ringBufferIndex = 0;
            }

            this.ringBuffer[this.ringBufferIndex][0] = (double)this.rotationYaw;
            this.ringBuffer[this.ringBufferIndex][1] = this.posY;

            if (this.world.isRemote)
            {
                if (this.newPosRotationIncrements > 0)
                {
                    double d5 = this.posX + (this.interpTargetX - this.posX) / (double)this.newPosRotationIncrements;
                    double d0 = this.posY + (this.interpTargetY - this.posY) / (double)this.newPosRotationIncrements;
                    double d1 = this.posZ + (this.interpTargetZ - this.posZ) / (double)this.newPosRotationIncrements;
                    double d2 = MathHelper.wrapDegrees(this.interpTargetYaw - (double)this.rotationYaw);
                    this.rotationYaw = (float)((double)this.rotationYaw + d2 / (double)this.newPosRotationIncrements);
                    this.rotationPitch = (float)((double)this.rotationPitch + (this.interpTargetPitch - (double)this.rotationPitch) / (double)this.newPosRotationIncrements);
                    --this.newPosRotationIncrements;
                    this.setPosition(d5, d0, d1);
                    this.setRotation(this.rotationYaw, this.rotationPitch);
                }
            }
            else
            {
                Vec3d vec3d = new Vec3d(this.posX,this.posY,this.posZ);

                if (vec3d != null)
                {
                    double d6 = vec3d.x - this.posX;
                    double d7 = vec3d.y - this.posY;
                    double d8 = vec3d.z - this.posZ;
                    float x = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ) + 1.0F;
                    float y = Math.min(x, 40.0F);
                    double d3 = d6 * d6 + d7 * d7 + d8 * d8;
                    float f5 = 1.5f;
                    d7 = MathHelper.clamp(d7 / (double)MathHelper.sqrt(d6 * d6 + d8 * d8), (double)(-f5), (double)f5);
                    this.motionY += d7 * 0.10000000149011612D;
                    this.rotationYaw = MathHelper.wrapDegrees(this.rotationYaw);
                    double d4 = MathHelper.clamp(MathHelper.wrapDegrees(180.0D - MathHelper.atan2(d6, d8) * (180D / Math.PI) - (double)this.rotationYaw), -50.0D, 50.0D);
                    Vec3d vec3d1 = (new Vec3d(vec3d.x - this.posX, vec3d.y - this.posY, vec3d.z - this.posZ)).normalize();
                    Vec3d vec3d2 = (new Vec3d((double)MathHelper.sin(this.rotationYaw * 0.017453292F), this.motionY, (double)(-MathHelper.cos(this.rotationYaw * 0.017453292F)))).normalize();
                    float f7 = Math.max(((float)vec3d2.dotProduct(vec3d1) + 0.5F) / 1.5F, 0.0F);
                    this.randomYawVelocity *= 0.8F;
                    this.randomYawVelocity = (float)((double)this.randomYawVelocity + d4 * (y/x));
                    this.rotationYaw += this.randomYawVelocity * 0.1F;
                    float f8 = (float)(2.0D / (d3 + 1.0D));
                    float f9 = 0.06F;
                    this.moveRelative(0.0F, 0.0F, -1.0F, 0.06F * (f7 * f8 + (1.0F - f8)));

                    if (this.slowed)
                    {
                        this.move(MoverType.SELF, this.motionX * 0.800000011920929D, this.motionY * 0.800000011920929D, this.motionZ * 0.800000011920929D);
                    }
                    else
                    {
                        this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
                    }

                    Vec3d vec3d3 = (new Vec3d(this.motionX, this.motionY, this.motionZ)).normalize();
                    float f10 = ((float)vec3d3.dotProduct(vec3d2) + 1.0F) / 2.0F;
                    f10 = 0.8F + 0.15F * f10;
                    this.motionX *= (double)f10;
                    this.motionZ *= (double)f10;
                    this.motionY *= 0.9100000262260437D;
                }
            }

            this.renderYawOffset = this.rotationYaw;
            this.dragonPartHead.width = 1.0F;
            this.dragonPartHead.height = 1.0F;
            this.dragonPartNeck.width = 3.0F;
            this.dragonPartNeck.height = 3.0F;
            this.dragonPartTail1.width = 2.0F;
            this.dragonPartTail1.height = 2.0F;
            this.dragonPartTail2.width = 2.0F;
            this.dragonPartTail2.height = 2.0F;
            this.dragonPartTail3.width = 2.0F;
            this.dragonPartTail3.height = 2.0F;
            this.dragonPartBody.height = 3.0F;
            this.dragonPartBody.width = 5.0F;
            this.dragonPartWing1.height = 2.0F;
            this.dragonPartWing1.width = 4.0F;
            this.dragonPartWing2.height = 3.0F;
            this.dragonPartWing2.width = 4.0F;
            Vec3d[] avec3d = new Vec3d[this.dragonPartArray.length];

            for (int j = 0; j < this.dragonPartArray.length; ++j)
            {
                avec3d[j] = new Vec3d(this.dragonPartArray[j].posX, this.dragonPartArray[j].posY, this.dragonPartArray[j].posZ);
            }

            float f14 = (float)(this.getMovementOffsets(5, 1.0F)[1] - this.getMovementOffsets(10, 1.0F)[1]) * 10.0F * 0.017453292F;
            float f16 = MathHelper.cos(f14);
            float f2 = MathHelper.sin(f14);
            float f17 = this.rotationYaw * 0.017453292F;
            float f3 = MathHelper.sin(f17);
            float f18 = MathHelper.cos(f17);
            this.dragonPartBody.onUpdate();
            this.dragonPartBody.setLocationAndAngles(this.posX + (double)(f3 * 0.5F), this.posY, this.posZ - (double)(f18 * 0.5F), 0.0F, 0.0F);
            this.dragonPartWing1.onUpdate();
            this.dragonPartWing1.setLocationAndAngles(this.posX + (double)(f18 * 4.5F), this.posY + 2.0D, this.posZ + (double)(f3 * 4.5F), 0.0F, 0.0F);
            this.dragonPartWing2.onUpdate();
            this.dragonPartWing2.setLocationAndAngles(this.posX - (double)(f18 * 4.5F), this.posY + 2.0D, this.posZ - (double)(f3 * 4.5F), 0.0F, 0.0F);


            double[] adouble = this.getMovementOffsets(5, 1.0F);
            float f19 = MathHelper.sin(this.rotationYaw * 0.017453292F - this.randomYawVelocity * 0.01F);
            float f4 = MathHelper.cos(this.rotationYaw * 0.017453292F - this.randomYawVelocity * 0.01F);
            this.dragonPartHead.onUpdate();
            this.dragonPartNeck.onUpdate();
            float f20 = this.getHeadYOffset(1.0F);
            this.dragonPartHead.setLocationAndAngles(this.posX + (double)(f19 * 6.5F * f16), this.posY + (double)f20 + (double)(f2 * 6.5F), this.posZ - (double)(f4 * 6.5F * f16), 0.0F, 0.0F);
            this.dragonPartNeck.setLocationAndAngles(this.posX + (double)(f19 * 5.5F * f16), this.posY + (double)f20 + (double)(f2 * 5.5F), this.posZ - (double)(f4 * 5.5F * f16), 0.0F, 0.0F);

            for (int k = 0; k < 3; ++k)
            {
                MultiPartEntityPart multipartentitypart = null;

                if (k == 0)
                {
                    multipartentitypart = this.dragonPartTail1;
                }

                if (k == 1)
                {
                    multipartentitypart = this.dragonPartTail2;
                }

                if (k == 2)
                {
                    multipartentitypart = this.dragonPartTail3;
                }

                double[] adouble1 = this.getMovementOffsets(12 + k * 2, 1.0F);
                float f21 = this.rotationYaw * 0.017453292F + this.simplifyAngle(adouble1[0] - adouble[0]) * 0.017453292F;
                float f6 = MathHelper.sin(f21);
                float f22 = MathHelper.cos(f21);
                float f23 = 1.5F;
                float f24 = (float)(k + 1) * 2.0F;
                multipartentitypart.onUpdate();
                multipartentitypart.setLocationAndAngles(this.posX - (double)((f3 * 1.5F + f6 * f24) * f16), this.posY + (adouble1[1] - adouble[1]) - (double)((f24 + 1.5F) * f2) + 1.5D, this.posZ + (double)((f18 * 1.5F + f22 * f24) * f16), 0.0F, 0.0F);
            }

            for (int l = 0; l < this.dragonPartArray.length; ++l)
            {
                this.dragonPartArray[l].prevPosX = avec3d[l].x;
                this.dragonPartArray[l].prevPosY = avec3d[l].y;
                this.dragonPartArray[l].prevPosZ = avec3d[l].z;
            }
        }
    }

    public boolean attackEntityFromPart(MultiPartEntityPart dragonPart, DamageSource source, float damage)
    {
        return super.attackEntityFrom(source, 0.1f);
    }

    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if(!(source instanceof EntityDamageSourceIndirect)) {
            //this.getLookHelper().setLookPositionWithEntity(source.getTrueSource(),this.getHorizontalFaceSpeed(),this.getVerticalFaceSpeed());
            // this.rotationPitch = 20f;
        }

        return false;
    }

    public void onKillCommand()
    {
        this.setDead();

    }

    protected void onDeathUpdate()
    {

        ++this.deathTicks;

        if (this.deathTicks >= 180 && this.deathTicks <= 200)
        {
            float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
            float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
            float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            this.world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX + (double)f, this.posY + 2.0D + (double)f1, this.posZ + (double)f2, 0.0D, 0.0D, 0.0D);
        }

        boolean flag = this.world.getGameRules().getBoolean("doMobLoot");
        int i = 500;

        if (!this.world.isRemote)
        {

            if (this.deathTicks == 200)
            {
                this.setDead();
            }
        }

        this.move(MoverType.SELF, 0.0D, 0.10000000149011612D, 0.0D);
        this.rotationYaw += 20.0F;
        this.renderYawOffset = this.rotationYaw;
    }

    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
    }

    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);

    }

    protected void despawnEntity()
    {
    }

    public Entity[] getParts()
    {
        return this.dragonPartArray;
    }

    public boolean canBeCollidedWith()
    {
        return false;
    }

    public World getWorld()
    {
        return this.world;
    }

    public SoundCategory getSoundCategory()
    {
        return SoundCategory.HOSTILE;
    }

    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_ENDERDRAGON_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_ENDERDRAGON_HURT;
    }

    protected float getSoundVolume()
    {
        return 5.0F;
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return LootTableList.ENTITIES_ENDER_DRAGON;
    }

    public void addPotionEffect(PotionEffect potioneffectIn)
    {
    }

    protected boolean canBeRidden(Entity entityIn)
    {
        return false;
    }

    public boolean isNonBoss()
    {
        return false;
    }
}
