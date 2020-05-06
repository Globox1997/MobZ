package net.mobz.Entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.mobz.Inits.Soundinit;

public class BabyravagerEntity extends RavagerEntity {

  public BabyravagerEntity(EntityType<? extends RavagerEntity> type, World world) {
    super(type, world);
  }

  protected void initAttributes() {
    super.initAttributes();
    this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(40.0D);
    this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
    this.getAttributeInstance(EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.5D);
    this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
    this.getAttributeInstance(EntityAttributes.ATTACK_KNOCKBACK).setBaseValue(1.5D);
    this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
  }

  public boolean tryAttack(Entity target) {
    this.world.sendEntityStatus(this, (byte) 4);
    this.playSound(Soundinit.NOTHINGEVENT, 1.0F, 1.0F);
    return super.tryAttack(target);
  }

  protected SoundEvent getHurtSound(DamageSource source) {
    return Soundinit.NOTHINGEVENT;
  }

}