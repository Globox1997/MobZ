package net.mobz.Entity;

import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.VillagerEntity;

import net.minecraft.entity.mob.IllusionerEntity;
import net.minecraft.entity.mob.DrownedEntity;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.mobz.Items.SwordItems;

public class Try extends IllusionerEntity {

    public Try(EntityType<? extends IllusionerEntity> entityType, World world) {
        super(entityType, world);
    }


}
