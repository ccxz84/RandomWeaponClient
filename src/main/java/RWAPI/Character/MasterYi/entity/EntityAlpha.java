package RWAPI.Character.MasterYi.entity;

import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.io.Serializable;
import java.util.List;

public class EntityAlpha extends EntityThrowable {

    public EntityAlpha(World worldIn) {
        super(worldIn);
    }

    @Override
    protected void onImpact(RayTraceResult result) {

    }

    public static class message implements Serializable {
        private static final long serialVersionUID = 2L;
        public List<Double[]> data;
    }
}
