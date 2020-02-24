package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class Slimo extends SlimeEntity {

    public Slimo(EntityType<? extends SlimeEntity> entityType, World world) {
        super(entityType, world);
    }

    public boolean canSpawn(WorldView viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos lighto = new BlockPos(this.getX(), this.getY(), this.getZ());
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.getLightLevel(lighto) >= 7;

    }

}
