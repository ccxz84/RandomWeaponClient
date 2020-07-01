package RWAPI.Character.Leesin.entity;

import RWAPI.Character.Leesin.render.RenderUmpa;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityResonating extends EntityThrowable{

	public EntityResonating(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		super.entityInit();
	}



	@Override
	protected void onImpact(RayTraceResult result) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		return 0xf000f0;
	}

}
