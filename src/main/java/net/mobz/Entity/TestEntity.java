package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.world.World;

public class TestEntity extends VexEntity {

    public TestEntity(EntityType<? extends VexEntity> entityType, World world) {
        super(entityType, world);

    }

}