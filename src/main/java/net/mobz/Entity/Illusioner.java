package net.mobz.Entity;

import net.minecraft.entity.mob.IllusionerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.Inits.Soundinit;

public class Illusioner extends IllusionerEntity {

   public Illusioner(EntityType<? extends IllusionerEntity> entityType, World world) {
      super(entityType, world);
   }

   protected SoundEvent getAmbientSound() {
      return Soundinit.ILLUIDLEEVENT;
   }

   protected SoundEvent getDeathSound() {
      return Soundinit.ILLUDEATHEVENT;
   }

   protected SoundEvent getHurtSound(DamageSource damageSource_1) {
      return Soundinit.ILLUHURTEVENT;
   }

   protected void initAttributes() {
      super.initAttributes();
      this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(14.0D);
      this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(16.0D);
   }

   public boolean canSpawn(WorldView viewableWorld_1) {
      BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
      return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
            && !viewableWorld_1.isAir(entityPos)
            && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
            && this.world.isDay() && !this.world.isWater(entityPos);

   }
}
