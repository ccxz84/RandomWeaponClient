package RWAPI.Character.ai;

import RWAPI.Character.monster.entity.EntityMinion;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.monster.EntityZombie;

public class PlayerAIZombieAttack extends EntityAIAttackMelee{
	
	private final EntityMinion zombie;
    private int raiseArmTicks;

	public PlayerAIZombieAttack(EntityLiving zombieIn, double speedIn, boolean longMemoryIn) {
		super((EntityCreature) zombieIn, speedIn, longMemoryIn);
        this.zombie = (EntityMinion) zombieIn;
		// TODO Auto-generated constructor stub
	}

	
	public void startExecuting()
    {
        super.startExecuting();
        this.raiseArmTicks = 0;
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask()
    {
        super.resetTask();
        this.zombie.setArmsRaised(false);
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask()
    {
        super.updateTask();
        ++this.raiseArmTicks;

        if (this.raiseArmTicks >= 5 && this.attackTick < 10)
        {
            this.zombie.setArmsRaised(true);
        }
        else
        {
            this.zombie.setArmsRaised(false);
        }
    }
}
