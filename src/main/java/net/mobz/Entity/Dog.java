package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import net.mobz.Inits.Soundinit;

public class Dog extends WolfEntity {

    public Dog(EntityType<? extends WolfEntity> entityType, World world) {
        super(entityType, world);
    }

    public boolean isBreedingItem(ItemStack itemStack_1) {
        return false;
    }

    public boolean isAngry() {
        return true;
    }

    protected SoundEvent getAmbientSound() {
        return Soundinit.WGROWLEVENT;
     }

    protected SoundEvent getHurtSound(DamageSource source) {
        return Soundinit.WHURTEVENT;
    }

    protected SoundEvent getDeathSound() {
        return Soundinit.WDEATHEVENT;
    }
}
