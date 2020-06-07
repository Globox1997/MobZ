package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Soundinit;

public class BabyravagerEntity extends RavagerEntity {

  public BabyravagerEntity(EntityType<? extends RavagerEntity> type, World world) {
    super(type, world);
  }

  protected void initAttributes() {
    super.initAttributes();
    this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
        .setBaseValue(Configinit.CONFIGZ.BabyRavagerLife * Configinit.CONFIGZ.LifeMultiplicatorMob);
    this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
    this.getAttributeInstance(EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.5D);
    this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
        .setBaseValue(Configinit.CONFIGZ.BabyRavagerAttack * Configinit.CONFIGZ.DamageMultiplicatorMob);
    this.getAttributeInstance(EntityAttributes.ATTACK_KNOCKBACK).setBaseValue(1.5D);
    this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
  }

  @Override
  public SoundEvent getCelebratingSound() {
    return Soundinit.NOTHINGEVENT;
  }

  @Override
  protected SoundEvent getAmbientSound() {
    return Soundinit.RAVIDLEEVENT;
  }

  @Override
  protected SoundEvent getHurtSound(DamageSource source) {
    return Soundinit.RAVHURTEVENT;
  }

  @Override
  protected SoundEvent getDeathSound() {
    return Soundinit.RAVDEATHEVENT;
  }

  @Override
  public boolean canBeControlledByRider() {
    return false;
  }

}