package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Soundinit;

public class BabyravagerEntity extends RavagerEntity {

  public BabyravagerEntity(EntityType<? extends RavagerEntity> type, World world) {
    super(type, world);
  }

  public static DefaultAttributeContainer.Builder createBabyRavagerEntityAttributes() {
    return HostileEntity.createHostileAttributes()
        .add(EntityAttributes.GENERIC_MAX_HEALTH,
            Configinit.CONFIGZ.BabyRavagerLife * Configinit.CONFIGZ.LifeMultiplicatorMob)
        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D)
        .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
            Configinit.CONFIGZ.BabyRavagerAttack * Configinit.CONFIGZ.DamageMultiplicatorMob)
        .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0D).add(EntityAttributes.GENERIC_ARMOR, 1.5D)
        .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.5D).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.5D);
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