package RWAPI.Character.Leesin.entity;

import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityTempest extends EntityThrowable{
	
	public int k = 0;
	public int i = 0;
	public int j = 0;

	public EntityTempest(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		//this.setEntityBoundingBox(new AxisAlignedBB(this.posX, this.posY, this.posZ, this.posX-20, this.posY-20, this.posZ-20));
		super.entityInit();
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onUpdate() {
		if(this.ticksExisted > 3) {
			i++;
		}
		if(this.ticksExisted > 5) {
			k++;
		}
		if(this.ticksExisted > 7) {
			j++;
		}
		super.onUpdate();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		return 0xf000f0;
	}
}
