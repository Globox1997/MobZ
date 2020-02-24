package net.mobz.Entity;

import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class skeli2 extends SkeletonEntity {

    public skeli2(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(24D);
        this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(1.0D);
    }

    public boolean canSpawn(WorldView viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos lighto = new BlockPos(this.getX(), this.getY(), this.getZ());
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.getLightLevel(lighto) <= 7;

    }

}