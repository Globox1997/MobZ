package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.ZombieEntity;

import net.minecraft.entity.mob.EvokerEntity;

import net.minecraft.entity.passive.WolfEntity;

import net.minecraft.item.Item;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class TestEntity extends EvokerEntity {

    public TestEntity(EntityType<? extends EvokerEntity> entityType, World world) {
        super(entityType, world);

    }
}
