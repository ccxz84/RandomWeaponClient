package RWAPI.Character.Leesin.entity;

import RWAPI.Character.Leesin.render.RenderResonating;
import RWAPI.Character.Leesin.render.RenderUmpa;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityUmpa extends EntityThrowable {
	public EntityUmpa(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}

	public EntityUmpa(World worldIn, EntityPlayer playerin) {
		super(worldIn,playerin);
	}

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		setSize(1f,1f);
	}

	@Override
	public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
		super.shoot(x, y, z, velocity, inaccuracy);
	}

	@Override
	public void shoot(Entity entityThrower, float rotationPitchIn, float rotationYawIn, float pitchOffset,
			float velocity, float inaccuracy) {
		super.shoot(entityThrower, rotationPitchIn, rotationYawIn, pitchOffset, velocity, inaccuracy);
	}
	
	@Override
	public void setVelocity(double x, double y, double z) {
		// TODO Auto-generated method stub
		super.setVelocity(x, y, z);
	}

	@Override
	public void onUpdate() {
		/*if(ticksExisted >60) {
			setDead();
		}*/
		super.onUpdate();
		
		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		return 0xf000f0;
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		// TODO Auto-generated method stub
		if(result.entityHit != null) {
			if(!(result.entityHit.equals(Minecraft.getMinecraft().player))) {
				setDead();
			}
		}
		
		
	}
}
