package RWAPI.Character.ForceMaster.entity;

import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityIcerain extends EntityThrowable {
    public EntityIcerain(World worldIn) {
        super(worldIn);
    }

    @Override
    protected void onImpact(RayTraceResult result) {

    }
}
