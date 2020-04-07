package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.world.World;

public class Brownbear extends PolarBearEntity {

    public Brownbear(EntityType<? extends PolarBearEntity> entityType, World world) {
        super(entityType, world);
    }

}

/*
 * public boolean canSpawn(WorldView viewableWorld_1) { BlockPos entityPos = new
 * BlockPos(this.getX(), this.getY() - 1, this.getZ()); return
 * viewableWorld_1.intersectsEntities(this) &&
 * !viewableWorld_1.containsFluid(this.getBoundingBox()) &&
 * !viewableWorld_1.isAir(entityPos) && !this.world.isWater(entityPos); // &&
 * AutoConfig.getConfigHolder(configz.class).getConfig().BrownBearSpawn;
 * 
 * } public boolean canSpawn(WorldView viewableWorld_1) {
 * 
 * BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
 * BlockPos lighto = new BlockPos(this.getX(), this.getY(), this.getZ()); return
 * viewableWorld_1.intersectsEntities(this) &&
 * !viewableWorld_1.containsFluid(this.getBoundingBox()) &&
 * !viewableWorld_1.isAir(entityPos) &&
 * this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() !=
 * Difficulty.PEACEFUL && this.world.getLightLevel(lighto) <= 7 &&
 * !this.world.isWater(entityPos) &&
 * AutoConfig.getConfigHolder(configz.class).getConfig().TankSpawn;
 * 
 * }
 */
