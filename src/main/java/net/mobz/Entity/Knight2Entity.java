package net.mobz.Entity;

import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.VindicatorEntity;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;
import net.mobz.glomod;
import net.mobz.Items.SwordItems;

public class Knight2Entity extends VindicatorEntity {

    public Knight2Entity(EntityType<? extends VindicatorEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initEquipment(LocalDifficulty localDifficulty_1) {
        super.initEquipment(localDifficulty_1);
        if (this.world.getDifficulty() != Difficulty.PEACEFUL) {
            this.setEquippedStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.ArmoredSword));
            this.setEquippedStack(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
        }
    }
    
    public boolean canSpawn(ViewableWorld viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.x, this.y - 1, this.z);
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.intersectsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.isDaylight();
    }
    @Override
    protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
        return;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return glomod.NOTHINGEVENT;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }
}
