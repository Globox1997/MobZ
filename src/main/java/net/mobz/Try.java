package net.mobz;

import net.minecraft.entity.mob.SkeletonEntity;

import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class Try extends SkeletonEntity {

    public Try(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

}