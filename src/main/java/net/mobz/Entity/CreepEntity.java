package net.mobz.Entity;

import net.mobz.Inits.Soundinit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class CreepEntity extends CreeperEntity {

   public CreepEntity(EntityType<? extends CreeperEntity> entityType, World world) {
      super(entityType, world);
   }

   protected void initAttributes() {
      super.initAttributes();
      this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.27D);
      this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(25D);
   }

   protected SoundEvent getHurtSound(DamageSource damageSource_1) {
      return Soundinit.SAYCREEPEVENT;
   }

   protected SoundEvent getDeathSound() {
      return Soundinit.DEATHCREEPEVENT;
   }

   public boolean canSpawn(WorldView viewableWorld_1) {
      BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
      BlockPos lighto = new BlockPos(this.getX(), this.getY(), this.getZ());
      return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
            && !viewableWorld_1.isAir(entityPos)
            && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
            && this.world.getLightLevel(lighto) <= 7 && !this.world.isWater(entityPos);

   }
}
