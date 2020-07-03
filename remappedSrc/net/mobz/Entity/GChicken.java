package net.mobz.Entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.mobz.Inits.Entityinit;

public class GChicken extends ChickenEntity {
   private static final Ingredient BREEDING_INGREDIENT;
   public float field_6741;
   public float field_6743;
   public float field_6738;
   public float field_6736;
   public float field_6737 = 1.0F;
   public int eggLayTime;
   public boolean jockey;

   public GChicken(EntityType<? extends GChicken> entityType_1, World world_1) {
      super(entityType_1, world_1);
      this.eggLayTime = this.random.nextInt(6000) + 6000;
      this.setPathNodeTypeWeight(PathNodeType.WATER, 0.0F);
   }

   private void setPathNodeTypeWeight(PathNodeType water, float f) {
   }

   @Override
   protected void initGoals() {
      this.goalSelector.add(0, new SwimGoal(this));
      this.goalSelector.add(1, new EscapeDangerGoal(this, 1.4D));
      this.goalSelector.add(2, new AnimalMateGoal(this, 1.0D));
      this.goalSelector.add(3, new TemptGoal(this, 1.0D, false, BREEDING_INGREDIENT));
      this.goalSelector.add(4, new FollowParentGoal(this, 1.1D));
      this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
      this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.add(7, new LookAroundGoal(this));
   }

   @Override
   protected float getActiveEyeHeight(EntityPose entityPose_1, EntityDimensions entityDimensions_1) {
      return this.isBaby() ? entityDimensions_1.height * 0.85F : entityDimensions_1.height * 0.92F;
   }

   @Override
   protected void initAttributes() {
      super.initAttributes();
      this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(4.0D);
      this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
   }

   @Override
   public void tickMovement() {
      super.tickMovement();
      this.field_6736 = this.field_6741;
      this.field_6738 = this.field_6743;
      this.field_6743 = (float) ((double) this.field_6743 + (double) (this.onGround ? -1 : 4) * 0.3D);
      this.field_6743 = MathHelper.clamp(this.field_6743, 0.0F, 1.0F);
      if (!this.onGround && this.field_6737 < 1.0F) {
         this.field_6737 = 1.0F;
      }

      this.field_6737 = (float) ((double) this.field_6737 * 0.9D);
      Vec3d vec3d_1 = this.getVelocity();
      if (!this.onGround && vec3d_1.y < 0.0D) {
         this.setVelocity(vec3d_1.multiply(1.0D, 0.6D, 1.0D));
      }

      this.field_6741 += this.field_6737 * 2.0F;
      if (!this.world.isClient && this.isAlive() && !this.isBaby() && !this.hasJockey() && --this.eggLayTime <= 0) {
         this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F,
               (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
         this.dropItem(Items.GOLD_NUGGET);
         this.eggLayTime = this.random.nextInt(6000) + 6000;
      }

   }

   @Override
   protected SoundEvent getAmbientSound() {
      return SoundEvents.ENTITY_CHICKEN_AMBIENT;
   }

   @Override
   protected SoundEvent getHurtSound(DamageSource damageSource_1) {
      return SoundEvents.ENTITY_CHICKEN_HURT;
   }

   @Override
   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_CHICKEN_DEATH;
   }

   @Override
   protected void playStepSound(BlockPos blockPos_1, BlockState blockState_1) {
      this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
   }

   @Override
   public GChicken createChild(PassiveEntity passiveEntity_1) {
      return (GChicken) Entityinit.GCHICKEN.create(this.world);
   }

   @Override
   public boolean isBreedingItem(ItemStack stack) {
      return BREEDING_INGREDIENT.test(stack);
   }

   protected int getCurrentExperience(PlayerEntity playerEntity_1) {
      return this.hasJockey() ? 10 : super.getCurrentExperience(playerEntity_1);
   }

   @Override
   public void writeCustomDataToTag(CompoundTag compoundTag_1) {
      super.writeCustomDataToTag(compoundTag_1);
      compoundTag_1.putBoolean("IsChickenJockey", this.jockey);
      compoundTag_1.putInt("EggLayTime", this.eggLayTime);
   }

   @Override
   public boolean canImmediatelyDespawn(double double_1) {
      return true;
   }

   @Override
   public boolean hasJockey() {
      return false;
   }

   @Override
   public void setHasJockey(boolean boolean_1) {
      this.jockey = boolean_1;
   }

   static {
      BREEDING_INGREDIENT = Ingredient.ofItems(Items.GOLD_NUGGET);
   }
}
