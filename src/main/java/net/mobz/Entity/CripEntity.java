package net.mobz.Entity;

import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Soundinit;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class CripEntity extends CreeperEntity {

   public CripEntity(EntityType<? extends CreeperEntity> entityType, World world) {
      super(entityType, world);
   }

   protected void initAttributes() {
      super.initAttributes();
      this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
      this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
            .setBaseValue(Configinit.CONFIGZ.CookieCreeperLife * Configinit.CONFIGZ.LifeMultiplicatorMob);
   }

   protected SoundEvent getHurtSound(DamageSource damageSource_1) {
      return Soundinit.SAYCRIPEVENT;
   }

   protected SoundEvent getDeathSound() {
      return Soundinit.DEATHCRIPEVENT;
   }

   public boolean canSpawn(WorldView viewableWorld_1) {
      BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
      BlockPos lighto = new BlockPos(this.getX(), this.getY(), this.getZ());
      return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
            && !viewableWorld_1.isAir(entityPos)
            && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
            && this.world.getLightLevel(lighto) <= 7 && !this.world.isWater(entityPos)
            && AutoConfig.getConfigHolder(configz.class).getConfig().CookieCreeperSpawn;

   }
}
