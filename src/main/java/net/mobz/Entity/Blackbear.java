package net.mobz.Entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.mobz.Inits.Soundinit;

public class Blackbear extends PandaEntity {

   public Blackbear(EntityType<? extends PandaEntity> entityType, World world) {
      super(entityType, world);
   }

   public static DefaultAttributeContainer.Builder createBlackbearAttributes() {
      return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.17D)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0D);
   }

   @Override
	public boolean canPickupItem(ItemStack stack) {
      return false;
   }

   @Override
   public boolean isSneezing() {
      return false;
   }

   @Override
   public boolean isScared() {
      return false;
   }

   @Override
   public boolean isLyingOnBack() {
      return false;
   }

   @Override
   public boolean isEating() {
      return false;
   }

   @Override
   public boolean isPlaying() {
      return false;
   }

   @Override
   public boolean isLazy() {
      return false;
   }

   @Override
   public boolean isWorried() {
      return false;
   }

   @Override
   public boolean isPlayful() {
      return false;
   }

   @Override
   public boolean isWeak() {
      return false;
   }

   @Override
   public boolean isAttacking() {
      return false;
   }

   @Override
   public boolean tryAttack(Entity target) {
      this.playSound(Soundinit.PBITEEVENT, 1.0F, 1.0F);
      return super.tryAttack(target);
   }

   @Override
   public boolean isScaredByThunderstorm() {
      return false;
   }

   @Override
   public boolean isBreedingItem(ItemStack stack) {
      return false;
   }

   @Override
   protected SoundEvent getAmbientSound() {
      return SoundEvents.ENTITY_POLAR_BEAR_AMBIENT;

   }

   @Override
   protected void playStepSound(BlockPos pos, BlockState state) {
      this.playSound(SoundEvents.ENTITY_POLAR_BEAR_STEP, 0.15F, 1.0F);
   }

   @Override
   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_POLAR_BEAR_DEATH;
   }

   @Override
   protected SoundEvent getHurtSound(DamageSource source) {
      return SoundEvents.ENTITY_POLAR_BEAR_HURT;
   }

}