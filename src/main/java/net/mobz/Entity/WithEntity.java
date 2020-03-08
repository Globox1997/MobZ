package net.mobz.Entity;

import java.util.EnumSet;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.GoToWalkTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.glomod;

public class WithEntity extends BlazeEntity {
   private float field_7214 = 0.5F;
   private int field_7215;
   private static final TrackedData<Byte> BLAZE_FLAGS;

   public WithEntity(EntityType<? extends WithEntity> entityType_1, World world_1) {
      super(entityType_1, world_1);
      this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
      this.setPathfindingPenalty(PathNodeType.LAVA, 8.0F);
      this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 0.0F);
      this.setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, 0.0F);
      this.experiencePoints = 14;
   }

   public boolean canSpawn(WorldView viewableWorld_1) {
    BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
    return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
            && !viewableWorld_1.isAir(entityPos)
            && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
            && !this.world.isWater(entityPos);

}

   protected void initGoals() {
      this.goalSelector.add(4, new WithEntity.ShootFireballGoal(this));
      this.goalSelector.add(5, new GoToWalkTargetGoal(this, 1.0D));
      this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D, 0.0F));
      this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
      this.goalSelector.add(8, new LookAroundGoal(this));
      this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge());
      this.targetSelector.add(2, new FollowTargetGoal(this, PlayerEntity.class, true));
   }

   protected void initAttributes() {
      super.initAttributes();
      this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
      this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
      this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(48.0D);
   }

   protected void initDataTracker() {
      super.initDataTracker();
      this.dataTracker.startTracking(BLAZE_FLAGS, (byte)0);
   }

   protected SoundEvent getAmbientSound() {
      return SoundEvents.ENTITY_BLAZE_AMBIENT;
   }

   protected SoundEvent getHurtSound(DamageSource damageSource_1) {
      return SoundEvents.ENTITY_BLAZE_HURT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_BLAZE_DEATH;
   }

   public float getBrightnessAtEyes() {
      return 1.0F;
   }

   public void tickMovement() {
      if (!this.onGround && this.getVelocity().y < 0.0D) {
         this.setVelocity(this.getVelocity().multiply(1.0D, 0.6D, 1.0D));
      }

      if (this.world.isClient) {
         if (this.random.nextInt(24) == 0 && !this.isSilent()) {
            this.world.playSound(this.getX() + 0.5D, this.getY() + 0.5D, this.getZ() + 0.5D, glomod.NOTHINGEVENT, this.getSoundCategory(), 1.0F + this.random.nextFloat(), this.random.nextFloat() * 0.7F + 0.3F, false);
         }

         for(int int_1 = 0; int_1 < 2; ++int_1) {
            this.world.addParticle(ParticleTypes.FALLING_LAVA, this.getParticleX(0.5D), this.getRandomBodyY(), this.getParticleZ(0.5D), 0.0D, 0.0D, 0.0D);
         }
      }

      super.tickMovement();
   }

   protected void mobTick() {
      if (this.isTouchingWater()) {
         this.damage(DamageSource.DROWN, 1.0F);
      }

      --this.field_7215;
      if (this.field_7215 <= 0) {
         this.field_7215 = 100;
         this.field_7214 = 0.5F + (float)this.random.nextGaussian() * 3.0F;
      }

      LivingEntity livingEntity_1 = this.getTarget();
      if (livingEntity_1 != null && livingEntity_1.getEyeY() > this.getEyeY() + (double)this.field_7214 && this.canTarget(livingEntity_1)) {
         Vec3d vec3d_1 = this.getVelocity();
         this.setVelocity(this.getVelocity().add(0.0D, (0.30000001192092896D - vec3d_1.y) * 0.30000001192092896D, 0.0D));
         this.velocityDirty = true;
      }

      super.mobTick();
   }

   public boolean handleFallDamage(float float_1, float float_2) {
      return false;
   }

   public boolean isOnFire() {
      return this.isFireActive();
   }

   private boolean isFireActive() {
      return ((Byte)this.dataTracker.get(BLAZE_FLAGS) & 1) != 0;
   }

   private void setFireActive(boolean boolean_1) {
      byte byte_1 = (Byte)this.dataTracker.get(BLAZE_FLAGS);
      if (boolean_1) {
         byte_1 = (byte)(byte_1 | 1);
      } else {
         byte_1 &= -2;
      }

      this.dataTracker.set(BLAZE_FLAGS, byte_1);
   }

   static {
      BLAZE_FLAGS = DataTracker.registerData(WithEntity.class, TrackedDataHandlerRegistry.BYTE);
   }

   static class ShootFireballGoal extends Goal {
      private final WithEntity blaze;
      private int field_7218;
      private int field_7217;
      private int field_19420;

      public ShootFireballGoal(WithEntity blazeEntity_1) {
         this.blaze = blazeEntity_1;
         this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
      }

      public boolean canStart() {
         LivingEntity livingEntity_1 = this.blaze.getTarget();
         return livingEntity_1 != null && livingEntity_1.isAlive() && this.blaze.canTarget(livingEntity_1);
      }

      public void start() {
         this.field_7218 = 0;
      }

      public void stop() {
         this.blaze.setFireActive(false);
         this.field_19420 = 0;
      }

      public void tick() {
         --this.field_7217;
         LivingEntity livingEntity_1 = this.blaze.getTarget();
         if (livingEntity_1 != null) {
            boolean boolean_1 = this.blaze.getVisibilityCache().canSee(livingEntity_1);
            if (boolean_1) {
               this.field_19420 = 0;
            } else {
               ++this.field_19420;
            }

            double double_1 = this.blaze.squaredDistanceTo(livingEntity_1);
            if (double_1 < 4.0D) {
               if (!boolean_1) {
                  return;
               }

               if (this.field_7217 <= 0) {
                  this.field_7217 = 20;
                  this.blaze.tryAttack(livingEntity_1);
               }

               this.blaze.getMoveControl().moveTo(livingEntity_1.getX(), livingEntity_1.getY(), livingEntity_1.getZ(), 1.0D);
            } else if (double_1 < this.method_6995() * this.method_6995() && boolean_1) {
               double double_2 = livingEntity_1.getX() - this.blaze.getX();
               double double_3 = livingEntity_1.getBodyY(0.5D) - this.blaze.getBodyY(0.5D);
               double double_4 = livingEntity_1.getZ() - this.blaze.getZ();
               if (this.field_7217 <= 0) {
                  ++this.field_7218;
                  if (this.field_7218 == 1) {
                     this.field_7217 = 60;
                     this.blaze.setFireActive(true);
                  } else if (this.field_7218 <= 4) {
                     this.field_7217 = 6;
                  } else {
                     this.field_7217 = 100;
                     this.field_7218 = 0;
                     this.blaze.setFireActive(false);
                  }

                  if (this.field_7218 > 1) {
                     float float_1 = MathHelper.sqrt(MathHelper.sqrt(double_1)) * 0.5F;
                     this.blaze.world.playLevelEvent((PlayerEntity)null, 1018, new BlockPos(this.blaze), 0);

                     for(int int_1 = 0; int_1 < 1; ++int_1) {
                        SmallFireballEntity smallFireballEntity_1 = new SmallFireballEntity(this.blaze.world, this.blaze, double_2 + this.blaze.getRandom().nextGaussian() * (double)float_1, double_3, double_4 + this.blaze.getRandom().nextGaussian() * (double)float_1);
                        smallFireballEntity_1.updatePosition(smallFireballEntity_1.getX(), this.blaze.getBodyY(0.5D) + 0.5D, smallFireballEntity_1.getZ());
                        this.blaze.world.spawnEntity(smallFireballEntity_1);
                     }
                  }
               }

               this.blaze.getLookControl().lookAt(livingEntity_1, 10.0F, 10.0F);
            } else if (this.field_19420 < 5) {
               this.blaze.getMoveControl().moveTo(livingEntity_1.getX(), livingEntity_1.getY(), livingEntity_1.getZ(), 1.0D);
            }

            super.tick();
         }
      }

      private double method_6995() {
         return this.blaze.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).getValue();
      }
   }
}

