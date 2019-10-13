package net.mobz.Entity;

import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.EvokerFangsEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SpellcastingIllagerEntity;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.entity.passive.AbstractTraderEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.mobz.glomod;

public class Try extends SpellcastingIllagerEntity {
   private SheepEntity wololoTarget;

   public Try(EntityType<? extends Try> entityType_1, World world_1) {
      super(entityType_1, world_1);
      this.experiencePoints = 10;
   }

   protected void initGoals() {
      super.initGoals();
      this.goalSelector.add(4, new Try.SummonZombieGoal());
      this.goalSelector.add(0, new SwimGoal(this));
      this.goalSelector.add(1, new Try.LookAtTargetOrWololoTarget());
      this.goalSelector.add(2, new FleeEntityGoal(this, PlayerEntity.class, 8.0F, 0.6D, 1.0D));
      this.goalSelector.add(5, new Try.ConjureFangsGoal());
      this.goalSelector.add(6, new Try.WololoGoal());
      this.goalSelector.add(8, new WanderAroundGoal(this, 0.6D));
      this.goalSelector.add(9, new LookAtEntityGoal(this, PlayerEntity.class, 3.0F, 1.0F));
      this.goalSelector.add(10, new LookAtEntityGoal(this, MobEntity.class, 8.0F));
      this.targetSelector.add(1, (new RevengeGoal(this, new Class[]{RaiderEntity.class})).setGroupRevenge());
      this.targetSelector.add(2, (new FollowTargetGoal(this, PlayerEntity.class, true)).setMaxTimeWithoutVisibility(300));
      this.targetSelector.add(3, (new FollowTargetGoal(this, AbstractTraderEntity.class, false)).setMaxTimeWithoutVisibility(300));
      this.targetSelector.add(3, new FollowTargetGoal(this, IronGolemEntity.class, false));
   }

   protected void initAttributes() {
      super.initAttributes();
      this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
      this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(12.0D);
      this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(24.0D);
   }

   protected void initDataTracker() {
      super.initDataTracker();
   }

   public void readCustomDataFromTag(CompoundTag compoundTag_1) {
      super.readCustomDataFromTag(compoundTag_1);
   }

   public SoundEvent getCelebratingSound() {
      return SoundEvents.ENTITY_EVOKER_CELEBRATE;
   }

   public void writeCustomDataToTag(CompoundTag compoundTag_1) {
      super.writeCustomDataToTag(compoundTag_1);
   }

   protected void mobTick() {
      super.mobTick();
   }

   public void tick() {
      super.tick();
   }

   public boolean isTeammate(Entity entity_1) {
      if (entity_1 == null) {
         return false;
      } else if (entity_1 == this) {
         return true;
      } else if (super.isTeammate(entity_1)) {
         return true;
      } else if (entity_1 instanceof VexEntity) {
         return this.isTeammate(((VexEntity)entity_1).getOwner());
      } else if (entity_1 instanceof LivingEntity && ((LivingEntity)entity_1).getGroup() == EntityGroup.ILLAGER) {
         return this.getScoreboardTeam() == null && entity_1.getScoreboardTeam() == null;
      } else {
         return false;
      }
   }

   protected SoundEvent getAmbientSound() {
      return SoundEvents.ENTITY_EVOKER_AMBIENT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_EVOKER_DEATH;
   }

   protected SoundEvent getHurtSound(DamageSource damageSource_1) {
      return SoundEvents.ENTITY_EVOKER_HURT;
   }

   private void setWololoTarget(@Nullable SheepEntity sheepEntity_1) {
      this.wololoTarget = sheepEntity_1;
   }

   @Nullable
   private SheepEntity getWololoTarget() {
      return this.wololoTarget;
   }

   protected SoundEvent getCastSpellSound() {
      return SoundEvents.ENTITY_EVOKER_CAST_SPELL;
   }

   public void addBonusForWave(int int_1, boolean boolean_1) {
   }

   public class WololoGoal extends SpellcastingIllagerEntity.CastSpellGoal {
      private final TargetPredicate purpleSheepPredicate = (new TargetPredicate()).setBaseMaxDistance(16.0D).includeInvulnerable().setPredicate((livingEntity_1) -> {
         return ((SheepEntity)livingEntity_1).getColor() == DyeColor.BLUE;
      });

      public WololoGoal() {
         super();
      }

      public boolean canStart() {
         if (Try.this.getTarget() != null) {
            return false;
         } else if (Try.this.isSpellcasting()) {
            return false;
         } else if (Try.this.age < this.startTime) {
            return false;
         } else if (!Try.this.world.getGameRules().getBoolean(GameRules.MOB_GRIEFING)) {
            return false;
         } else {
            List<SheepEntity> list_1 = Try.this.world.getTargets(SheepEntity.class, this.purpleSheepPredicate, Try.this, Try.this.getBoundingBox().expand(16.0D, 4.0D, 16.0D));
            if (list_1.isEmpty()) {
               return false;
            } else {
               Try.this.setWololoTarget((SheepEntity)list_1.get(Try.this.random.nextInt(list_1.size())));
               return true;
            }
         }
      }

      public boolean shouldContinue() {
         return Try.this.getWololoTarget() != null && this.spellCooldown > 0;
      }

      public void stop() {
         super.stop();
         Try.this.setWololoTarget((SheepEntity)null);
      }

      protected void castSpell() {
         SheepEntity sheepEntity_1 = Try.this.getWololoTarget();
         if (sheepEntity_1 != null && sheepEntity_1.isAlive()) {
            sheepEntity_1.setColor(DyeColor.RED);
         }

      }

      protected int getInitialCooldown() {
         return 40;
      }

      protected int getSpellTicks() {
         return 60;
      }

      protected int startTimeDelay() {
         return 140;
      }

      protected SoundEvent getSoundPrepare() {
         return SoundEvents.ENTITY_EVOKER_PREPARE_WOLOLO;
      }

      protected SpellcastingIllagerEntity.Spell getSpell() {
         return SpellcastingIllagerEntity.Spell.WOLOLO;
      }
   }
   class SummonZombieGoal extends SpellcastingIllagerEntity.CastSpellGoal {
    private final TargetPredicate zombiepredicate;

    private SummonZombieGoal() {
       super();
       this.zombiepredicate = (new TargetPredicate()).setBaseMaxDistance(16.0D).includeHidden()
             .ignoreDistanceScalingFactor().includeInvulnerable().includeTeammates();
    }

    public boolean canStart() {
       if (!super.canStart()) {
          return false;
       } else {
          int int_1 = Try.this.world.getTargets(SmallZombie.class, this.zombiepredicate, Try.this,
                Try.this.getBoundingBox().expand(16.0D)).size();
          return Try.this.random.nextInt(8) + 1 > int_1;
       }
    }

    protected int getSpellTicks() {
       return 100;
    }

    protected int startTimeDelay() {
       return 340;
    }

    protected void castSpell() {
       for (int int_1 = 0; int_1 < 3; ++int_1) {
          BlockPos blockPos_1 = (new BlockPos(Try.this)).add(-2 + Try.this.random.nextInt(5), 1,
                -2 + Try.this.random.nextInt(5));
          SmallZombie SmallZombie_1 = (SmallZombie) glomod.SMALLZOMBIE.create(Try.this.world);
          SmallZombie_1.setPositionAndAngles(blockPos_1, 0.0F, 0.0F);
          SmallZombie_1.initialize(Try.this.world, Try.this.world.getLocalDifficulty(blockPos_1),
                SpawnType.MOB_SUMMONED, (EntityData) null, (CompoundTag) null);

          // vexEntity_1.setOwner(EvokerEntity.this);
          // vexEntity_1.setBounds(blockPos_1);
          SmallZombie_1.setLifeTicks(20 * (30 + Try.this.random.nextInt(90)));

          Try.this.world.spawnEntity(SmallZombie_1);
       }

    }

    protected SoundEvent getSoundPrepare() {
       return SoundEvents.ENTITY_EVOKER_PREPARE_SUMMON;
    }

    protected SpellcastingIllagerEntity.Spell getSpell() {
       return SpellcastingIllagerEntity.Spell.SUMMON_VEX;
    }

    SummonZombieGoal(Object evokerEntity$1_1) {
       this();
    }
 }

   class ConjureFangsGoal extends SpellcastingIllagerEntity.CastSpellGoal {
      private ConjureFangsGoal() {
         super();
      }

      protected int getSpellTicks() {
         return 40;
      }

      protected int startTimeDelay() {
         return 100;
      }

      protected void castSpell() {
         LivingEntity livingEntity_1 = Try.this.getTarget();
         double double_1 = Math.min(livingEntity_1.y, Try.this.y);
         double double_2 = Math.max(livingEntity_1.y, Try.this.y) + 1.0D;
         float float_1 = (float)MathHelper.atan2(livingEntity_1.z - Try.this.z, livingEntity_1.x - Try.this.x);
         int int_2;
         if (Try.this.squaredDistanceTo(livingEntity_1) < 9.0D) {
            float float_3;
            for(int_2 = 0; int_2 < 5; ++int_2) {
               float_3 = float_1 + (float)int_2 * 3.1415927F * 0.4F;
               this.conjureFangs(Try.this.x + (double)MathHelper.cos(float_3) * 1.5D, Try.this.z + (double)MathHelper.sin(float_3) * 1.5D, double_1, double_2, float_3, 0);
            }

            for(int_2 = 0; int_2 < 8; ++int_2) {
               float_3 = float_1 + (float)int_2 * 3.1415927F * 2.0F / 8.0F + 1.2566371F;
               this.conjureFangs(Try.this.x + (double)MathHelper.cos(float_3) * 2.5D, Try.this.z + (double)MathHelper.sin(float_3) * 2.5D, double_1, double_2, float_3, 3);
            }
         } else {
            for(int_2 = 0; int_2 < 16; ++int_2) {
               double double_3 = 1.25D * (double)(int_2 + 1);
               int int_4 = 1 * int_2;
               this.conjureFangs(Try.this.x + (double)MathHelper.cos(float_1) * double_3, Try.this.z + (double)MathHelper.sin(float_1) * double_3, double_1, double_2, float_1, int_4);
            }
         }

      }

      private void conjureFangs(double double_1, double double_2, double double_3, double double_4, float float_1, int int_1) {
         BlockPos blockPos_1 = new BlockPos(double_1, double_4, double_2);
         boolean boolean_1 = false;
         double double_5 = 0.0D;

         do {
            BlockPos blockPos_2 = blockPos_1.down();
            BlockState blockState_1 = Try.this.world.getBlockState(blockPos_2);
            if (blockState_1.isSideSolidFullSquare(Try.this.world, blockPos_2, Direction.UP)) {
               if (!Try.this.world.isAir(blockPos_1)) {
                  BlockState blockState_2 = Try.this.world.getBlockState(blockPos_1);
                  VoxelShape voxelShape_1 = blockState_2.getCollisionShape(Try.this.world, blockPos_1);
                  if (!voxelShape_1.isEmpty()) {
                     double_5 = voxelShape_1.getMaximum(Direction.Axis.Y);
                  }
               }

               boolean_1 = true;
               break;
            }

            blockPos_1 = blockPos_1.down();
         } while(blockPos_1.getY() >= MathHelper.floor(double_3) - 1);

         if (boolean_1) {
            Try.this.world.spawnEntity(new EvokerFangsEntity(Try.this.world, double_1, (double)blockPos_1.getY() + double_5, double_2, float_1, int_1, Try.this));
         }

      }

      protected SoundEvent getSoundPrepare() {
         return SoundEvents.ENTITY_EVOKER_PREPARE_ATTACK;
      }

      protected SpellcastingIllagerEntity.Spell getSpell() {
         return SpellcastingIllagerEntity.Spell.FANGS;
      }

      // $FF: synthetic method
      ConjureFangsGoal(Object Try$1_1) {
         this();
      }
   }

   class LookAtTargetOrWololoTarget extends SpellcastingIllagerEntity.LookAtTargetGoal {
      private LookAtTargetOrWololoTarget() {
         super();
      }

      public void tick() {
         if (Try.this.getTarget() != null) {
            Try.this.getLookControl().lookAt(Try.this.getTarget(), (float)Try.this.method_5986(), (float)Try.this.getLookPitchSpeed());
         } else if (Try.this.getWololoTarget() != null) {
            Try.this.getLookControl().lookAt(Try.this.getWololoTarget(), (float)Try.this.method_5986(), (float)Try.this.getLookPitchSpeed());
         }

      }

      // $FF: synthetic method
      LookAtTargetOrWololoTarget(Object Try$1_1) {
         this();
      }
   }
}
