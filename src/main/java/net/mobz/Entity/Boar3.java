package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import net.mobz.glomod;

public class Boar3 extends PigEntity {

    public Boar3(EntityType<? extends PigEntity> entityType, World world) {
        super(entityType, world);
    }

    public boolean canBeControlledByRider() {
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return glomod.BOARSAYEVENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return glomod.BOARSAYEVENT;
    }

    protected SoundEvent getDeathSound() {
        return glomod.BOARDEATHEVENT;
    }

    public boolean isSaddled() {
        return false;
    }

}
