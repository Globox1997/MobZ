package net.mobz.Entity;

import net.mobz.glomod;

import java.util.Collection;
import java.util.Iterator;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;

public class CripEntity extends CreeperEntity {

   public CripEntity(EntityType<? extends CreeperEntity> entityType, World world) {
      super(entityType, world);
   }

   protected void initAttributes() {
      super.initAttributes();
      this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
      this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(27D);
   }

   public boolean canSpawn(ViewableWorld viewableWorld_1) {
      BlockPos entityPos = new BlockPos(this.x, this.y - 1, this.z);
      return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.intersectsFluid(this.getBoundingBox())
            && !viewableWorld_1.isAir(entityPos)
            && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
            && !this.world.isDaylight();
   }

   private void spawnEffectsCloud() {
      Collection<StatusEffectInstance> collection_1 = this.getStatusEffects();
      if (!collection_1.isEmpty()) {
         AreaEffectCloudEntity areaEffectCloudEntity_1 = new AreaEffectCloudEntity(this.world, this.x, this.y, this.z);
         areaEffectCloudEntity_1.setRadius(2.5F);
         areaEffectCloudEntity_1.setRadiusOnUse(-0.5F);
         areaEffectCloudEntity_1.setWaitTime(10);
         areaEffectCloudEntity_1.setDuration(areaEffectCloudEntity_1.getDuration() / 2);
         areaEffectCloudEntity_1
               .setRadiusGrowth(-areaEffectCloudEntity_1.getRadius() / (float) areaEffectCloudEntity_1.getDuration());
         Iterator var3 = collection_1.iterator();

         while (var3.hasNext()) {
            StatusEffectInstance statusEffectInstance_1 = (StatusEffectInstance) var3.next();
            areaEffectCloudEntity_1.addEffect(new StatusEffectInstance(statusEffectInstance_1));
         }

         this.world.spawnEntity(areaEffectCloudEntity_1);
      }
   }

   protected SoundEvent getHurtSound(DamageSource damageSource_1) {
      return glomod.SAYCRIPEVENT;
   }

   protected SoundEvent getDeathSound() {
      return glomod.DEATHCRIPEVENT;
   }
}

