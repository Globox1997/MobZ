package net.mobz.Entity;

import java.util.List;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.EvokerFangsEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SpellcastingIllagerEntity;
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
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;

public class Mage2Entity extends SpellcastingIllagerEntity {
   private SheepEntity wololoTarget;

   public Mage2Entity(EntityType<? extends Mage2Entity> entityType, World world) {
      super(entityType, world);
      this.experiencePoints = 20;
   }

   public static DefaultAttributeContainer.Builder createMage2EntityAttributes() {
      return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH,
                  Configinit.CONFIGZ.ZombieMageLife * Configinit.CONFIGZ.LifeMultiplicatorMob)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5D)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                  Configinit.CONFIGZ.ZombieMageAttack * Configinit.CONFIGZ.DamageMultiplicatorMob)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20.0D);
   }

   @Override
   protected void initGoals() {
      super.initGoals();
      this.goalSelector.add(0, new SwimGoal(this));
      this.goalSelector.add(1, new Mage2Entity.LookAtTargetOrWololoTarget());
      this.goalSelector.add(2, new FleeEntityGoal<>(this, PlayerEntity.class, 8.0F, 0.6D, 1.0D));
      this.goalSelector.add(4, new Mage2Entity.SummonVexGoal());
      this.goalSelector.add(5, new Mage2Entity.ConjureFangsGoal());
      this.goalSelector.add(6, new Mage2Entity.WololoGoal());
      this.goalSelector.add(8, new WanderAroundGoal(this, 0.6D));
      this.goalSelector.add(9, new LookAtEntityGoal(this, PlayerEntity.class, 3.0F, 1.0F));
      this.goalSelector.add(10, new LookAtEntityGoal(this, MobEntity.class, 8.0F));
      this.targetSelector.add(1, (new RevengeGoal(this, new Class[] { RaiderEntity.class })).setGroupRevenge());
      this.targetSelector.add(2,
            (new FollowTargetGoal<>(this, PlayerEntity.class, true)).setMaxTimeWithoutVisibility(300));
      this.targetSelector.add(3,
            (new FollowTargetGoal<>(this, AbstractTraderEntity.class, false)).setMaxTimeWithoutVisibility(300));
      this.targetSelector.add(4, new FollowTargetGoal<>(this, IronGolemEntity.class, false));
   }

   @Override
   public boolean canSpawn(WorldView view) {
      BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
      BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
      return view.intersectsEntities(this) && !this.isPatrolLeader()
            && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
            && this.world.isDay() && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
            && this.world.getBlockState(blockunderentity).allowsSpawning(view, blockunderentity, Entityinit.MAGE2ENTITY)
            && AutoConfig.getConfigHolder(configz.class).getConfig().ZombieMageSpawn;

   }

   @Override
   protected void initDataTracker() {
      super.initDataTracker();
   }

   @Override
   public void readCustomDataFromTag(CompoundTag tag) {
      super.readCustomDataFromTag(tag);
   }

   @Override
   public SoundEvent getCelebratingSound() {
      return SoundEvents.ENTITY_EVOKER_CELEBRATE;
   }

   @Override
   public void writeCustomDataToTag(CompoundTag tag) {
      super.writeCustomDataToTag(tag);
   }

   @Override
   protected void mobTick() {
      super.mobTick();
   }

   @Override
   public boolean isTeammate(Entity other) {
      if (other == null) {
         return false;
      } else if (other == this) {
         return true;
      } else if (super.isTeammate(other)) {
         return true;
      } else if (other instanceof SmallZombie) {
         return this.isTeammate(((SmallZombie) other).getOwner());
      } else if (other instanceof LivingEntity && ((LivingEntity) other).getGroup() == EntityGroup.ILLAGER) {
         return this.getScoreboardTeam() == null && other.getScoreboardTeam() == null;
      } else {
         return false;
      }
   }

   @Override
   protected SoundEvent getAmbientSound() {
      return SoundEvents.ENTITY_EVOKER_AMBIENT;
   }

   @Override
   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_EVOKER_DEATH;
   }

   @Override
   protected SoundEvent getHurtSound(DamageSource source) {
      return SoundEvents.ENTITY_EVOKER_HURT;
   }

   private void setWololoTarget(@Nullable SheepEntity sheep) {
      this.wololoTarget = sheep;
   }

   @Nullable
   private SheepEntity getWololoTarget() {
      return this.wololoTarget;
   }

   @Override
   protected SoundEvent getCastSpellSound() {
      return SoundEvents.ENTITY_EVOKER_CAST_SPELL;
   }

   @Override
   public void addBonusForWave(int wave, boolean unused) {
   }

   public class WololoGoal extends SpellcastingIllagerEntity.CastSpellGoal {
      private final TargetPredicate purpleSheepPredicate = (new TargetPredicate()).setBaseMaxDistance(16.0D)
            .includeInvulnerable().setPredicate((livingEntity) -> {
               return ((SheepEntity) livingEntity).getColor() == DyeColor.BLUE;
            });

      public WololoGoal() {
         super();
      }

      public boolean canStart() {
         if (Mage2Entity.this.getTarget() != null) {
            return false;
         } else if (Mage2Entity.this.isSpellcasting()) {
            return false;
         } else if (Mage2Entity.this.age < this.startTime) {
            return false;
         } else if (!Mage2Entity.this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            return false;
         } else {
            List<SheepEntity> list = Mage2Entity.this.world.getTargets(SheepEntity.class, this.purpleSheepPredicate,
                  Mage2Entity.this, Mage2Entity.this.getBoundingBox().expand(16.0D, 4.0D, 16.0D));
            if (list.isEmpty()) {
               return false;
            } else {
               Mage2Entity.this.setWololoTarget((SheepEntity) list.get(Mage2Entity.this.random.nextInt(list.size())));
               return true;
            }
         }
      }

      public boolean shouldContinue() {
         return Mage2Entity.this.getWololoTarget() != null && this.spellCooldown > 0;
      }

      public void stop() {
         super.stop();
         Mage2Entity.this.setWololoTarget((SheepEntity) null);
      }

      protected void castSpell() {
         SheepEntity sheepEntity = Mage2Entity.this.getWololoTarget();
         if (sheepEntity != null && sheepEntity.isAlive()) {
            sheepEntity.setColor(DyeColor.RED);
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

   class SummonVexGoal extends SpellcastingIllagerEntity.CastSpellGoal {
      private final TargetPredicate closeVexPredicate;

      private SummonVexGoal() {
         super();
         this.closeVexPredicate = (new TargetPredicate()).setBaseMaxDistance(16.0D).includeHidden()
               .ignoreDistanceScalingFactor().includeInvulnerable().includeTeammates();
      }

      public boolean canStart() {
         if (!super.canStart()) {
            return false;
         } else {
            int i = Mage2Entity.this.world.getTargets(SmallZombie.class, this.closeVexPredicate, Mage2Entity.this,
                  Mage2Entity.this.getBoundingBox().expand(16.0D)).size();
            return Mage2Entity.this.random.nextInt(8) + 1 > i;
         }
      }

      protected int getSpellTicks() {
         return 100;
      }

      protected int startTimeDelay() {
         return 340;
      }

      protected void castSpell() {
         for (int i = 0; i < 3; ++i) {
            BlockPos blockPos = Mage2Entity.this.getBlockPos().add(-2 + Mage2Entity.this.random.nextInt(5), 1,
                  -2 + Mage2Entity.this.random.nextInt(5));
            SmallZombie SmallZombie = (SmallZombie) Entityinit.SMALLZOMBIE.create(Mage2Entity.this.world);
            SmallZombie.refreshPositionAndAngles(blockPos, 0.0F, 0.0F);
            SmallZombie.initialize(Mage2Entity.this.world, Mage2Entity.this.world.getLocalDifficulty(blockPos),
                  SpawnReason.MOB_SUMMONED, (EntityData) null, (CompoundTag) null);
            SmallZombie.setOwner(Mage2Entity.this);
            SmallZombie.setBounds(blockPos);
            SmallZombie.setLifeTicks(20 * (30 + Mage2Entity.this.random.nextInt(90)));
            Mage2Entity.this.world.spawnEntity(SmallZombie);
         }

      }

      protected SoundEvent getSoundPrepare() {
         return SoundEvents.ENTITY_EVOKER_PREPARE_SUMMON;
      }

      protected SpellcastingIllagerEntity.Spell getSpell() {
         return SpellcastingIllagerEntity.Spell.SUMMON_VEX;
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
         LivingEntity livingEntity = Mage2Entity.this.getTarget();
         double d = Math.min(livingEntity.getY(), Mage2Entity.this.getY());
         double e = Math.max(livingEntity.getY(), Mage2Entity.this.getY()) + 1.0D;
         float f = (float) MathHelper.atan2(livingEntity.getZ() - Mage2Entity.this.getZ(),
               livingEntity.getX() - Mage2Entity.this.getX());
         int j;
         if (Mage2Entity.this.squaredDistanceTo(livingEntity) < 9.0D) {
            float h;
            for (j = 0; j < 5; ++j) {
               h = f + (float) j * 3.1415927F * 0.4F;
               this.conjureFangs(Mage2Entity.this.getX() + (double) MathHelper.cos(h) * 1.5D,
                     Mage2Entity.this.getZ() + (double) MathHelper.sin(h) * 1.5D, d, e, h, 0);
            }

            for (j = 0; j < 8; ++j) {
               h = f + (float) j * 3.1415927F * 2.0F / 8.0F + 1.2566371F;
               this.conjureFangs(Mage2Entity.this.getX() + (double) MathHelper.cos(h) * 2.5D,
                     Mage2Entity.this.getZ() + (double) MathHelper.sin(h) * 2.5D, d, e, h, 3);
            }
         } else {
            for (j = 0; j < 16; ++j) {
               double l = 1.25D * (double) (j + 1);
               int m = 1 * j;
               this.conjureFangs(Mage2Entity.this.getX() + (double) MathHelper.cos(f) * l,
                     Mage2Entity.this.getZ() + (double) MathHelper.sin(f) * l, d, e, f, m);
            }
         }

      }

      private void conjureFangs(double x, double z, double maxY, double y, float f, int warmup) {
         BlockPos blockPos = new BlockPos(x, y, z);
         boolean bl = false;
         double d = 0.0D;

         do {
            BlockPos blockPos2 = blockPos.down();
            BlockState blockState = Mage2Entity.this.world.getBlockState(blockPos2);
            if (blockState.isSideSolidFullSquare(Mage2Entity.this.world, blockPos2, Direction.UP)) {
               if (!Mage2Entity.this.world.isAir(blockPos)) {
                  BlockState blockState2 = Mage2Entity.this.world.getBlockState(blockPos);
                  VoxelShape voxelShape = blockState2.getCollisionShape(Mage2Entity.this.world, blockPos);
                  if (!voxelShape.isEmpty()) {
                     d = voxelShape.getMax(Direction.Axis.Y);
                  }
               }

               bl = true;
               break;
            }

            blockPos = blockPos.down();
         } while (blockPos.getY() >= MathHelper.floor(maxY) - 1);

         if (bl) {
            Mage2Entity.this.world.spawnEntity(new EvokerFangsEntity(Mage2Entity.this.world, x,
                  (double) blockPos.getY() + d, z, f, warmup, Mage2Entity.this));
         }

      }

      protected SoundEvent getSoundPrepare() {
         return SoundEvents.ENTITY_EVOKER_PREPARE_ATTACK;
      }

      protected SpellcastingIllagerEntity.Spell getSpell() {
         return SpellcastingIllagerEntity.Spell.FANGS;
      }
   }

   class LookAtTargetOrWololoTarget extends SpellcastingIllagerEntity.LookAtTargetGoal {
      private LookAtTargetOrWololoTarget() {
         super();
      }

      public void tick() {
         if (Mage2Entity.this.getTarget() != null) {
            Mage2Entity.this.getLookControl().lookAt(Mage2Entity.this.getTarget(),
                  (float) Mage2Entity.this.getBodyYawSpeed(), (float) Mage2Entity.this.getLookPitchSpeed());
         } else if (Mage2Entity.this.getWololoTarget() != null) {
            Mage2Entity.this.getLookControl().lookAt(Mage2Entity.this.getWololoTarget(),
                  (float) Mage2Entity.this.getBodyYawSpeed(), (float) Mage2Entity.this.getLookPitchSpeed());
         }

      }
   }

}
