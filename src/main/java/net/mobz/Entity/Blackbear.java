package net.mobz.Entity;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.mobz.glomod;

public class Blackbear extends PandaEntity {
   private static final TrackedData<Integer> ASK_FOR_BAMBOO_TICKS;
   private static final TrackedData<Integer> SNEEZE_PROGRESS;
   private static final TrackedData<Integer> EATING_TICKS;
   private static final TrackedData<Byte> MAIN_GENE;
   private static final TrackedData<Byte> HIDDEN_GENE;
   private static final TrackedData<Byte> PANDA_FLAGS;
   private boolean shouldGetRevenge;
   private boolean shouldAttack;
   public int playingTicks;
   private Vec3d playingJump;
   private float scaredAnimationProgress;
   private float lastScaredAnimationProgress;
   private float lieOnBackAnimationProgress;
   private float lastLieOnBackAnimationProgress;
   private float rollOverAnimationProgress;
   private float lastRollOverAnimationProgress;
   private static final Predicate<ItemEntity> IS_FOOD;

   public Blackbear(EntityType<? extends PandaEntity> entityType_1, World world_1) {
      super(entityType_1, world_1);
      this.moveControl = new Blackbear.PandaMoveControl(this);
      if (!this.isBaby()) {
         this.setCanPickUpLoot(true);
      }

   }

   public boolean canPickUp(ItemStack itemStack_1) {
      EquipmentSlot equipmentSlot_1 = MobEntity.getPreferredEquipmentSlot(itemStack_1);
      if (!this.getEquippedStack(equipmentSlot_1).isEmpty()) {
         return false;
      } else {
         return equipmentSlot_1 == EquipmentSlot.MAINHAND && super.canPickUp(itemStack_1);
      }
   }

   public int getAskForBambooTicks() {
      return (Integer) this.dataTracker.get(ASK_FOR_BAMBOO_TICKS);
   }

   public void setAskForBambooTicks(int int_1) {
      this.dataTracker.set(ASK_FOR_BAMBOO_TICKS, int_1);
   }

   public boolean isSneezing() {
      return this.hasPandaFlag(2);
   }

   public boolean isScared() {
      return this.hasPandaFlag(8);
   }

   public void setScared(boolean boolean_1) {
      this.setPandaFlag(8, boolean_1);
   }

   public boolean isLyingOnBack() {
      return this.hasPandaFlag(16);
   }

   public void setLyingOnBack(boolean boolean_1) {
      this.setPandaFlag(16, boolean_1);
   }

   public boolean isEating() {
      return (Integer) this.dataTracker.get(EATING_TICKS) > 0;
   }

   public void setEating(boolean boolean_1) {
      this.dataTracker.set(EATING_TICKS, boolean_1 ? 1 : 0);
   }

   private int getEatingTicks() {
      return (Integer) this.dataTracker.get(EATING_TICKS);
   }

   private void setEatingTicks(int int_1) {
      this.dataTracker.set(EATING_TICKS, int_1);
   }

   public void setSneezing(boolean boolean_1) {
      this.setPandaFlag(2, boolean_1);
      if (!boolean_1) {
         this.setSneezeProgress(0);
      }

   }

   public int getSneezeProgress() {
      return (Integer) this.dataTracker.get(SNEEZE_PROGRESS);
   }

   public void setSneezeProgress(int int_1) {
      this.dataTracker.set(SNEEZE_PROGRESS, int_1);
   }

   public void setMainGene(Blackbear.Gene Blackbear$Gene_1) {
      if (Blackbear$Gene_1.getId() > 6) {
         Blackbear$Gene_1 = Blackbear.Gene.createRandom(this.random);
      }

      this.dataTracker.set(MAIN_GENE, (byte) Blackbear$Gene_1.getId());
   }

   public void setHiddenGene(Blackbear.Gene Blackbear$Gene_1) {
      if (Blackbear$Gene_1.getId() > 6) {
         Blackbear$Gene_1 = Blackbear.Gene.createRandom(this.random);
      }

      this.dataTracker.set(HIDDEN_GENE, (byte) Blackbear$Gene_1.getId());
   }

   public boolean isPlaying() {
      return this.hasPandaFlag(4);
   }

   public void setPlaying(boolean boolean_1) {
      this.setPandaFlag(4, boolean_1);
   }

   protected void initDataTracker() {
      super.initDataTracker();
      this.dataTracker.startTracking(ASK_FOR_BAMBOO_TICKS, 0);
      this.dataTracker.startTracking(SNEEZE_PROGRESS, 0);
      this.dataTracker.startTracking(MAIN_GENE, (byte) 0);
      this.dataTracker.startTracking(HIDDEN_GENE, (byte) 0);
      this.dataTracker.startTracking(PANDA_FLAGS, (byte) 0);
      this.dataTracker.startTracking(EATING_TICKS, 0);
   }

   private boolean hasPandaFlag(int int_1) {
      return ((Byte) this.dataTracker.get(PANDA_FLAGS) & int_1) != 0;
   }

   private void setPandaFlag(int int_1, boolean boolean_1) {
      byte byte_1 = (Byte) this.dataTracker.get(PANDA_FLAGS);
      if (boolean_1) {
         this.dataTracker.set(PANDA_FLAGS, (byte) (byte_1 | int_1));
      } else {
         this.dataTracker.set(PANDA_FLAGS, (byte) (byte_1 & ~int_1));
      }

   }

   public void writeCustomDataToTag(CompoundTag compoundTag_1) {
      super.writeCustomDataToTag(compoundTag_1);
      compoundTag_1.putString("MainGene", this.getMainGene().getName());
      compoundTag_1.putString("HiddenGene", this.getHiddenGene().getName());
   }

   public void readCustomDataFromTag(CompoundTag compoundTag_1) {
      super.readCustomDataFromTag(compoundTag_1);
      this.setMainGene(Blackbear.Gene.byName(compoundTag_1.getString("MainGene")));
      this.setHiddenGene(Blackbear.Gene.byName(compoundTag_1.getString("HiddenGene")));
   }

   protected void initGoals() {
      this.goalSelector.add(0, new SwimGoal(this));
      this.goalSelector.add(2, new Blackbear.ExtinguishFireGoal(this, 2.0D));
      this.goalSelector.add(2, new Blackbear.PandaMateGoal(this, 1.0D));
      this.goalSelector.add(3, new Blackbear.AttackGoal(this, 1.2000000476837158D, true));
      this.goalSelector.add(4, new TemptGoal(this, 1.0D, Ingredient.ofItems(Blocks.BAMBOO.asItem()), false));
      this.goalSelector.add(8, new Blackbear.LieOnBackGoal(this));
      this.goalSelector.add(8, new Blackbear.SneezeGoal(this));
      this.goalSelector.add(9, new Blackbear.LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.add(10, new LookAroundGoal(this));
      this.goalSelector.add(12, new Blackbear.PlayGoal(this));
      this.goalSelector.add(13, new FollowParentGoal(this, 1.25D));
      this.goalSelector.add(14, new WanderAroundFarGoal(this, 1.0D));
      this.targetSelector.add(1, (new Blackbear.PandaRevengeGoal(this, new Class[0])).setGroupRevenge(new Class[0]));
   }



   public boolean canBeLeashedBy(PlayerEntity playerEntity_1) {
      return false;
   }

   public boolean tryAttack(Entity entity_1) {
      this.playSound(glomod.PBITEEVENT, 1.0F, 1.0F);
      if (!this.isAttacking()) {
         this.shouldAttack = true;
      }

      return super.tryAttack(entity_1);
   }

   public void tick() {
      super.tick();
      if (this.isWorried()) {
         if (this.world.isThundering() && !this.isInsideWater()) {
            this.setScared(true);
            this.setEating(false);
         } else if (!this.isEating()) {
            this.setScared(false);
         }
      }

      if (this.getTarget() == null) {
         this.shouldGetRevenge = false;
         this.shouldAttack = false;
      }

      if (this.getAskForBambooTicks() > 0) {
         if (this.getTarget() != null) {
            this.lookAtEntity(this.getTarget(), 90.0F, 90.0F);
         }

         if (this.getAskForBambooTicks() == 29 || this.getAskForBambooTicks() == 14) {
            this.playSound(glomod.NOTHINGEVENT, 1.0F, 1.0F);
         }

         this.setAskForBambooTicks(this.getAskForBambooTicks() - 1);
      }

      if (this.isSneezing()) {
         this.setSneezeProgress(this.getSneezeProgress() + 1);
         if (this.getSneezeProgress() > 20) {
            this.setSneezing(false);
            this.sneeze();
         } else if (this.getSneezeProgress() == 1) {
            this.playSound(glomod.NOTHINGEVENT, 1.0F, 1.0F);
         }
      }

      if (this.isPlaying()) {
         this.updatePlaying();
      } else {
         this.playingTicks = 0;
      }

      if (this.isScared()) {
         this.pitch = 0.0F;
      }

      this.updateScaredAnimation();
      this.updateEatingAnimation();
      this.updateLieOnBackAnimation();
      this.updateRollOverAnimation();
   }

   public boolean method_6524() {
      return this.isWorried() && this.world.isThundering();
   }

   private void updateEatingAnimation() {
      if (!this.isEating() && this.isScared() && !this.method_6524()
            && !this.getEquippedStack(EquipmentSlot.MAINHAND).isEmpty() && this.random.nextInt(80) == 1) {
         this.setEating(true);
      } else if (this.getEquippedStack(EquipmentSlot.MAINHAND).isEmpty() || !this.isScared()) {
         this.setEating(false);
      }

      if (this.isEating()) {
         this.playEatingAnimation();
         if (!this.world.isClient && this.getEatingTicks() > 80 && this.random.nextInt(20) == 1) {
            if (this.getEatingTicks() > 100 && this.canEat(this.getEquippedStack(EquipmentSlot.MAINHAND))) {
               if (!this.world.isClient) {
                  this.setEquippedStack(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
               }

               this.setScared(false);
            }

            this.setEating(false);
            return;
         }

         this.setEatingTicks(this.getEatingTicks() + 1);
      }

   }

   private void playEatingAnimation() {
      if (this.getEatingTicks() % 5 == 0) {
         this.playSound(SoundEvents.ENTITY_PANDA_EAT, 0.5F + 0.5F * (float) this.random.nextInt(2),
               (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);

         for (int int_1 = 0; int_1 < 6; ++int_1) {
            Vec3d vec3d_1 = new Vec3d(((double) this.random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D,
                  ((double) this.random.nextFloat() - 0.5D) * 0.1D);
            vec3d_1 = vec3d_1.rotateX(-this.pitch * 0.017453292F);
            vec3d_1 = vec3d_1.rotateY(-this.yaw * 0.017453292F);
            double double_1 = (double) (-this.random.nextFloat()) * 0.6D - 0.3D;
            Vec3d vec3d_2 = new Vec3d(((double) this.random.nextFloat() - 0.5D) * 0.8D, double_1,
                  1.0D + ((double) this.random.nextFloat() - 0.5D) * 0.4D);
            vec3d_2 = vec3d_2.rotateY(-this.field_6283 * 0.017453292F);
            vec3d_2 = vec3d_2.add(this.x, this.y + (double) this.getStandingEyeHeight() + 1.0D, this.z);
            this.world.addParticle(
                  new ItemStackParticleEffect(ParticleTypes.ITEM, this.getEquippedStack(EquipmentSlot.MAINHAND)),
                  vec3d_2.x, vec3d_2.y, vec3d_2.z, vec3d_1.x, vec3d_1.y + 0.05D, vec3d_1.z);
         }
      }

   }

   private void updateScaredAnimation() {
      this.lastScaredAnimationProgress = this.scaredAnimationProgress;
      if (this.isScared()) {
         this.scaredAnimationProgress = Math.min(1.0F, this.scaredAnimationProgress + 0.15F);
      } else {
         this.scaredAnimationProgress = Math.max(0.0F, this.scaredAnimationProgress - 0.19F);
      }

   }

   private void updateLieOnBackAnimation() {
      this.lastLieOnBackAnimationProgress = this.lieOnBackAnimationProgress;
      if (this.isLyingOnBack()) {
         this.lieOnBackAnimationProgress = Math.min(1.0F, this.lieOnBackAnimationProgress + 0.15F);
      } else {
         this.lieOnBackAnimationProgress = Math.max(0.0F, this.lieOnBackAnimationProgress - 0.19F);
      }

   }

   private void updateRollOverAnimation() {
      this.lastRollOverAnimationProgress = this.rollOverAnimationProgress;
      if (this.isPlaying()) {
         this.rollOverAnimationProgress = Math.min(1.0F, this.rollOverAnimationProgress + 0.15F);
      } else {
         this.rollOverAnimationProgress = Math.max(0.0F, this.rollOverAnimationProgress - 0.19F);
      }

   }

   @Environment(EnvType.CLIENT)
   public float getScaredAnimationProgress(float float_1) {
      return MathHelper.lerp(float_1, this.lastScaredAnimationProgress, this.scaredAnimationProgress);
   }

   @Environment(EnvType.CLIENT)
   public float getLieOnBackAnimationProgress(float float_1) {
      return MathHelper.lerp(float_1, this.lastLieOnBackAnimationProgress, this.lieOnBackAnimationProgress);
   }

   @Environment(EnvType.CLIENT)
   public float getRollOverAnimationProgress(float float_1) {
      return MathHelper.lerp(float_1, this.lastRollOverAnimationProgress, this.rollOverAnimationProgress);
   }

   private void updatePlaying() {
      ++this.playingTicks;
      if (this.playingTicks > 32) {
         this.setPlaying(false);
      } else {
         if (!this.world.isClient) {
            Vec3d vec3d_1 = this.getVelocity();
            if (this.playingTicks == 1) {
               float float_1 = this.yaw * 0.017453292F;
               float float_2 = this.isBaby() ? 0.1F : 0.2F;
               this.playingJump = new Vec3d(vec3d_1.x + (double) (-MathHelper.sin(float_1) * float_2), 0.0D,
                     vec3d_1.z + (double) (MathHelper.cos(float_1) * float_2));
               this.setVelocity(this.playingJump.add(0.0D, 0.27D, 0.0D));
            } else if ((float) this.playingTicks != 7.0F && (float) this.playingTicks != 15.0F
                  && (float) this.playingTicks != 23.0F) {
               this.setVelocity(this.playingJump.x, vec3d_1.y, this.playingJump.z);
            } else {
               this.setVelocity(0.0D, this.onGround ? 0.27D : vec3d_1.y, 0.0D);
            }
         }

      }
   }

   private void sneeze() {
      Vec3d vec3d_1 = this.getVelocity();
      this.world.addParticle(ParticleTypes.SNEEZE,
            this.x - (double) (this.getWidth() + 1.0F) * 0.5D * (double) MathHelper.sin(this.field_6283 * 0.017453292F),
            this.y + (double) this.getStandingEyeHeight() - 0.10000000149011612D,
            this.z + (double) (this.getWidth() + 1.0F) * 0.5D * (double) MathHelper.cos(this.field_6283 * 0.017453292F),
            vec3d_1.x, 0.0D, vec3d_1.z);
      this.playSound(glomod.NOTHINGEVENT, 1.0F, 1.0F);
      List<Blackbear> list_1 = this.world.getEntities(Blackbear.class, this.getBoundingBox().expand(10.0D));
      Iterator var3 = list_1.iterator();

      while (var3.hasNext()) {
         Blackbear Blackbear_1 = (Blackbear) var3.next();
         if (!Blackbear_1.isBaby() && Blackbear_1.onGround && !Blackbear_1.isInsideWater()
               && Blackbear_1.method_18442()) {
            Blackbear_1.jump();
         }
      }

      if (!this.world.isClient() && this.random.nextInt(700) == 0
            && this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
         this.dropItem(Items.SLIME_BALL);
      }

   }

   protected void loot(ItemEntity itemEntity_1) {
      if (this.getEquippedStack(EquipmentSlot.MAINHAND).isEmpty() && IS_FOOD.test(itemEntity_1)) {
         ItemStack itemStack_1 = itemEntity_1.getStack();
         this.setEquippedStack(EquipmentSlot.MAINHAND, itemStack_1);
         this.handDropChances[EquipmentSlot.MAINHAND.getEntitySlotId()] = 2.0F;
         this.sendPickup(itemEntity_1, itemStack_1.getCount());
         itemEntity_1.remove();
      }

   }

   public boolean damage(DamageSource damageSource_1, float float_1) {
      this.setScared(false);
      return super.damage(damageSource_1, float_1);
   }




   @Nullable
   protected SoundEvent getAmbientSound() {
      if (this.isAttacking()) {
         return SoundEvents.ENTITY_POLAR_BEAR_WARNING;
      } else {
         return this.isWorried() ? SoundEvents.ENTITY_POLAR_BEAR_WARNING : SoundEvents.ENTITY_POLAR_BEAR_AMBIENT;
      }
   }

   protected void playStepSound(BlockPos blockPos_1, BlockState blockState_1) {
      this.playSound(SoundEvents.ENTITY_POLAR_BEAR_STEP, 0.15F, 1.0F);
   }

   public boolean isBreedingItem(ItemStack itemStack_1) {
      return itemStack_1.getItem() == Blocks.BAMBOO.asItem();
   }

   private boolean canEat(ItemStack itemStack_1) {
      return this.isBreedingItem(itemStack_1) || itemStack_1.getItem() == Blocks.CAKE.asItem();
   }

   @Nullable
   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_POLAR_BEAR_DEATH;
   }

   @Nullable
   protected SoundEvent getHurtSound(DamageSource damageSource_1) {
      return SoundEvents.ENTITY_POLAR_BEAR_HURT;
   }

   public boolean method_18442() {
      return !this.isLyingOnBack() && !this.method_6524() && !this.isEating() && !this.isPlaying() && !this.isScared();
   }

   static {
      ASK_FOR_BAMBOO_TICKS = DataTracker.registerData(Blackbear.class, TrackedDataHandlerRegistry.INTEGER);
      SNEEZE_PROGRESS = DataTracker.registerData(Blackbear.class, TrackedDataHandlerRegistry.INTEGER);
      EATING_TICKS = DataTracker.registerData(Blackbear.class, TrackedDataHandlerRegistry.INTEGER);
      MAIN_GENE = DataTracker.registerData(Blackbear.class, TrackedDataHandlerRegistry.BYTE);
      HIDDEN_GENE = DataTracker.registerData(Blackbear.class, TrackedDataHandlerRegistry.BYTE);
      PANDA_FLAGS = DataTracker.registerData(Blackbear.class, TrackedDataHandlerRegistry.BYTE);
      IS_FOOD = (itemEntity_1) -> {
         Item item_1 = itemEntity_1.getStack().getItem();
         return (item_1 == Blocks.BAMBOO.asItem() || item_1 == Blocks.CAKE.asItem()) && itemEntity_1.isAlive()
               && !itemEntity_1.cannotPickup();
      };
   }

   static class ExtinguishFireGoal extends EscapeDangerGoal {
      private final Blackbear panda;

      public ExtinguishFireGoal(Blackbear Blackbear_1, double double_1) {
         super(Blackbear_1, double_1);
         this.panda = Blackbear_1;
      }

      public boolean canStart() {
         if (!this.panda.isOnFire()) {
            return false;
         } else {
            BlockPos blockPos_1 = this.locateClosestWater(this.mob.world, this.mob, 5, 4);
            if (blockPos_1 != null) {
               this.targetX = (double) blockPos_1.getX();
               this.targetY = (double) blockPos_1.getY();
               this.targetZ = (double) blockPos_1.getZ();
               return true;
            } else {
               return this.findTarget();
            }
         }
      }

      public boolean shouldContinue() {
         if (this.panda.isScared()) {
            this.panda.getNavigation().stop();
            return false;
         } else {
            return super.shouldContinue();
         }
      }
   }

   static class PandaRevengeGoal extends RevengeGoal {
      private final Blackbear panda;

      public PandaRevengeGoal(Blackbear Blackbear_1, Class<?>... classs_1) {
         super(Blackbear_1, classs_1);
         this.panda = Blackbear_1;
      }

      public boolean shouldContinue() {
         if (!this.panda.shouldGetRevenge && !this.panda.shouldAttack) {
            return super.shouldContinue();
         } else {
            this.panda.setTarget((LivingEntity) null);
            return false;
         }
      }

      protected void setMobEntityTarget(MobEntity mobEntity_1, LivingEntity livingEntity_1) {
         if (mobEntity_1 instanceof Blackbear && ((Blackbear) mobEntity_1).isAttacking()) {
            mobEntity_1.setTarget(livingEntity_1);
         }

      }
   }

   static class LieOnBackGoal extends Goal {
      private final Blackbear panda;
      private int nextLieOnBackAge;

      public LieOnBackGoal(Blackbear Blackbear_1) {
         this.panda = Blackbear_1;
      }

      public boolean canStart() {
         return this.nextLieOnBackAge < this.panda.age && this.panda.isLazy() && this.panda.method_18442()
               && this.panda.random.nextInt(400) == 1;
      }

      public boolean shouldContinue() {
         if (!this.panda.isInsideWater() && (this.panda.isLazy() || this.panda.random.nextInt(600) != 1)) {
            return this.panda.random.nextInt(2000) != 1;
         } else {
            return false;
         }
      }

      public void start() {
         this.panda.setLyingOnBack(true);
         this.nextLieOnBackAge = 0;
      }

      public void stop() {
         this.panda.setLyingOnBack(false);
         this.nextLieOnBackAge = this.panda.age + 200;
      }
   }


   static class PandaMateGoal extends AnimalMateGoal {
      private static final TargetPredicate CLOSE_PLAYER_PREDICATE = (new TargetPredicate()).setBaseMaxDistance(8.0D)
            .includeTeammates().includeInvulnerable();
      private final Blackbear panda;
      private int nextAskPlayerForBambooAge;

      public PandaMateGoal(Blackbear Blackbear_1, double double_1) {
         super(Blackbear_1, double_1);
         this.panda = Blackbear_1;
      }

      public boolean canStart() {
         if (super.canStart() && this.panda.getAskForBambooTicks() == 0) {
            if (!this.isBambooClose()) {
               if (this.nextAskPlayerForBambooAge <= this.panda.age) {
                  this.panda.setAskForBambooTicks(32);
                  this.nextAskPlayerForBambooAge = this.panda.age + 600;
                  if (this.panda.canMoveVoluntarily()) {
                     PlayerEntity playerEntity_1 = this.world.getClosestPlayer(CLOSE_PLAYER_PREDICATE, this.panda);
                     this.panda.setTarget(playerEntity_1);
                  }
               }

               return false;
            } else {
               return true;
            }
         } else {
            return false;
         }
      }

      private boolean isBambooClose() {
         BlockPos blockPos_1 = new BlockPos(this.panda);
         BlockPos.Mutable blockPos$Mutable_1 = new BlockPos.Mutable();

         for (int int_1 = 0; int_1 < 3; ++int_1) {
            for (int int_2 = 0; int_2 < 8; ++int_2) {
               for (int int_3 = 0; int_3 <= int_2; int_3 = int_3 > 0 ? -int_3 : 1 - int_3) {
                  for (int int_4 = int_3 < int_2 && int_3 > -int_2 ? int_2 : 0; int_4 <= int_2; int_4 = int_4 > 0
                        ? -int_4
                        : 1 - int_4) {
                     blockPos$Mutable_1.set((Vec3i) blockPos_1).setOffset(int_3, int_1, int_4);
                     if (this.world.getBlockState(blockPos$Mutable_1).getBlock() == Blocks.BAMBOO) {
                        return true;
                     }
                  }
               }
            }
         }

         return false;
      }
   }

   static class SneezeGoal extends Goal {
      private final Blackbear panda;

      public SneezeGoal(Blackbear Blackbear_1) {
         this.panda = Blackbear_1;
      }

      public boolean canStart() {
         if (this.panda.isBaby() && this.panda.method_18442()) {
            if (this.panda.isWeak() && this.panda.random.nextInt(500) == 1) {
               return true;
            } else {
               return this.panda.random.nextInt(6000) == 1;
            }
         } else {
            return false;
         }
      }

      public boolean shouldContinue() {
         return false;
      }

      public void start() {
         this.panda.setSneezing(true);
      }
   }

   static class PlayGoal extends Goal {
      private final Blackbear panda;

      public PlayGoal(Blackbear Blackbear_1) {
         this.panda = Blackbear_1;
         this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK, Goal.Control.JUMP));
      }

      public boolean canStart() {
         if ((this.panda.isBaby() || this.panda.isPlayful()) && this.panda.onGround) {
            if (!this.panda.method_18442()) {
               return false;
            } else {
               float float_1 = this.panda.yaw * 0.017453292F;
               int int_1 = 0;
               int int_2 = 0;
               float float_2 = -MathHelper.sin(float_1);
               float float_3 = MathHelper.cos(float_1);
               if ((double) Math.abs(float_2) > 0.5D) {
                  int_1 = (int) ((float) int_1 + float_2 / Math.abs(float_2));
               }

               if ((double) Math.abs(float_3) > 0.5D) {
                  int_2 = (int) ((float) int_2 + float_3 / Math.abs(float_3));
               }

               if (this.panda.world.getBlockState((new BlockPos(this.panda)).add(int_1, -1, int_2)).isAir()) {
                  return true;
               } else if (this.panda.isPlayful() && this.panda.random.nextInt(60) == 1) {
                  return true;
               } else {
                  return this.panda.random.nextInt(500) == 1;
               }
            }
         } else {
            return false;
         }
      }

      public boolean shouldContinue() {
         return false;
      }

      public void start() {
         this.panda.setPlaying(true);
      }

      public boolean canStop() {
         return false;
      }
   }

   static class LookAtEntityGoal extends net.minecraft.entity.ai.goal.LookAtEntityGoal {
      private final Blackbear panda;

      public LookAtEntityGoal(Blackbear Blackbear_1, Class<? extends LivingEntity> class_1, float float_1) {
         super(Blackbear_1, class_1, float_1);
         this.panda = Blackbear_1;
      }

      public boolean canStart() {
         return this.panda.method_18442() && super.canStart();
      }
   }

   static class AttackGoal extends MeleeAttackGoal {
      private final Blackbear panda;

      public AttackGoal(Blackbear Blackbear_1, double double_1, boolean boolean_1) {
         super(Blackbear_1, double_1, boolean_1);
         this.panda = Blackbear_1;
      }

      public boolean canStart() {
         return this.panda.method_18442() && super.canStart();
      }
   }

   static class SpawnData implements EntityData {
      private SpawnData() {
      }

      // $FF: synthetic method
      SpawnData(Object Blackbear$1_1) {
         this();
      }
   }

   static class PandaMoveControl extends MoveControl {
      private final Blackbear panda;

      public PandaMoveControl(Blackbear Blackbear_1) {
         super(Blackbear_1);
         this.panda = Blackbear_1;
      }

      public void tick() {
         if (this.panda.method_18442()) {
            super.tick();
         }
      }
   }

   public static enum Gene {
      NORMAL(0, "normal", false), LAZY(1, "lazy", false), WORRIED(2, "worried", false), PLAYFUL(3, "playful", false),
      BROWN(4, "brown", true), WEAK(5, "weak", true), AGGRESSIVE(6, "aggressive", false);

      private static final Blackbear.Gene[] VALUES = (Blackbear.Gene[]) Arrays.stream(values())
            .sorted(Comparator.comparingInt(Blackbear.Gene::getId)).toArray((int_1) -> {
               return new Blackbear.Gene[int_1];
            });
      private final int id;
      private final String name;
      private final boolean recessive;

      private Gene(int int_1, String string_1, boolean boolean_1) {
         this.id = int_1;
         this.name = string_1;
         this.recessive = boolean_1;
      }

      public int getId() {
         return this.id;
      }

      public String getName() {
         return this.name;
      }

      public boolean isRecessive() {
         return this.recessive;
      }

      private static Blackbear.Gene getProductGene(Blackbear.Gene Blackbear$Gene_1, Blackbear.Gene Blackbear$Gene_2) {
         if (Blackbear$Gene_1.isRecessive()) {
            return Blackbear$Gene_1 == Blackbear$Gene_2 ? Blackbear$Gene_1 : NORMAL;
         } else {
            return Blackbear$Gene_1;
         }
      }

      public static Blackbear.Gene byId(int int_1) {
         if (int_1 < 0 || int_1 >= VALUES.length) {
            int_1 = 0;
         }

         return VALUES[int_1];
      }

      public static Blackbear.Gene byName(String string_1) {
         Blackbear.Gene[] var1 = values();
         int var2 = var1.length;

         for (int var3 = 0; var3 < var2; ++var3) {
            Blackbear.Gene Blackbear$Gene_1 = var1[var3];
            if (Blackbear$Gene_1.name.equals(string_1)) {
               return Blackbear$Gene_1;
            }
         }

         return NORMAL;
      }

      public static Blackbear.Gene createRandom(Random random_1) {
         int int_1 = random_1.nextInt(16);
         if (int_1 == 0) {
            return LAZY;
         } else if (int_1 == 1) {
            return WORRIED;
         } else if (int_1 == 2) {
            return PLAYFUL;
         } else if (int_1 == 4) {
            return AGGRESSIVE;
         } else if (int_1 < 9) {
            return WEAK;
         } else {
            return int_1 < 11 ? BROWN : NORMAL;
         }
      }
   }
}
