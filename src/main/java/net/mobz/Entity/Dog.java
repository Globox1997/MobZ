package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;

public class Dog extends WolfEntity {

    public Dog(EntityType<? extends WolfEntity> entityType, World world) {
        super(entityType, world);
    }

    public boolean canSpawn(ViewableWorld viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.x, this.y - 1, this.z);
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.intersectsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL;
    }
}
