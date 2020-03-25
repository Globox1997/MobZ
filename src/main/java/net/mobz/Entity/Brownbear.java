package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.glomod;

public class Brownbear extends PolarBearEntity {

    public Brownbear(EntityType<? extends PolarBearEntity> entityType, World world) {
        super(entityType, world);
    }

    public boolean canSpawn(WorldView viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && !this.world.isWater(entityPos)
                && glomod.CONFIGZ.BrownBearSpawn == true;

    }

}
