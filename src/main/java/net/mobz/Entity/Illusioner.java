package net.mobz.Entity;

import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.IllusionerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.Soundinit;

public class Illusioner extends IllusionerEntity {

   public Illusioner(EntityType<? extends IllusionerEntity> entityType, World world) {
      super(entityType, world);
      this.experiencePoints = 20;
   }

   public static DefaultAttributeContainer.Builder createIllusionerAttributes() {
      return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH,
                  Configinit.CONFIGZ.IllusionerLife * Configinit.CONFIGZ.LifeMultiplicatorMob)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4D)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                  Configinit.CONFIGZ.IllusionerAttack * Configinit.CONFIGZ.DamageMultiplicatorMob)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 24.0D);
   }

   @Override
   protected SoundEvent getAmbientSound() {
      return Soundinit.ILLUIDLEEVENT;
   }

   @Override
   protected SoundEvent getDeathSound() {
      return Soundinit.ILLUDEATHEVENT;
   }

   @Override
   protected SoundEvent getHurtSound(DamageSource damageSource_1) {
      return Soundinit.ILLUHURTEVENT;
   }

   @Override
   public boolean canSpawn(WorldView view) {
      BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
      BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
      return view.intersectsEntities(this)
            && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
            && this.world.isDay() && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
            && this.world.getBlockState(blockunderentity).allowsSpawning(view, blockunderentity, Entityinit.ILLUSIONER)
            && AutoConfig.getConfigHolder(configz.class).getConfig().IllusionerSpawn;

   }
}
