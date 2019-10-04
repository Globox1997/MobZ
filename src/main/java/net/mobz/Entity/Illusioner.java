package net.mobz.Entity;

import net.minecraft.entity.mob.IllusionerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.World;
import net.mobz.glomod;

public class Illusioner extends IllusionerEntity {

   public Illusioner(EntityType<? extends IllusionerEntity> entityType, World world) {
      super(entityType, world);
   }

   protected SoundEvent getAmbientSound() {
      return glomod.ILLUIDLEEVENT;
   }

   protected SoundEvent getDeathSound() {
      return glomod.ILLUDEATHEVENT;
   }

   protected SoundEvent getHurtSound(DamageSource damageSource_1) {
      return glomod.ILLUHURTEVENT;
   }

   protected void initAttributes() {
      super.initAttributes();
      this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(14.0D);
      this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(16.0D);
   }
}
