package net.mobz.Entity;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.Soundinit;

public class FullIronEntity extends ZombieEntity {

   public FullIronEntity(EntityType<? extends FullIronEntity> entityType_1, World world_1) {
      super(entityType_1, world_1);
      this.experiencePoints = 20;
   }

   public static DefaultAttributeContainer.Builder createFullIronEntityAttributes() {
      return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH,
                  Configinit.CONFIGZ.SteveLife * Configinit.CONFIGZ.LifeMultiplicatorMob)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.26D)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                  Configinit.CONFIGZ.SteveAttack * Configinit.CONFIGZ.DamageMultiplicatorMob)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0D);
   }

   @Override
   public boolean canPickUpLoot() {
      return false;
   }

   @Override
   public boolean canSpawn(WorldView view) {
      BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
      BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
      return view.intersectsEntities(this) && this.world.isDay()
            && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
            && this.world.getBlockState(posentity).getBlock().canMobSpawnInside() && this.world
                  .getBlockState(blockunderentity).allowsSpawning(view, blockunderentity, Entityinit.FULLIRONENTITY)
            && AutoConfig.getConfigHolder(configz.class).getConfig().SteveSpawn;

   }

   @Override
   protected void initEquipment(LocalDifficulty localDifficulty_1) {
      super.initEquipment(localDifficulty_1);
      if (this.world.getDifficulty() != Difficulty.PEACEFUL) {
         this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
         this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
         this.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
         this.equipStack(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
         this.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
         this.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
      }
   }

   @Override
   protected void initGoals() {
      this.goalSelector.add(0, new SwimGoal(this));
      this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false));
      this.goalSelector.add(7, new WanderAroundFarGoal(this, 0.9D));
      this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 3.0F, 1.0F));
      this.goalSelector.add(8, new LookAroundGoal(this));
      this.goalSelector.add(10, new LookAtEntityGoal(this, MobEntity.class, 8.0F));
      this.targetSelector.add(1, new FollowTargetGoal<>(this, PlayerEntity.class, true));
   }

   @Override
   protected boolean canConvertInWater() {
      return false;
   }

   @Override
   protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
      return;
   }

   @Override
   protected SoundEvent getAmbientSound() {
      return Soundinit.NOTHINGEVENT;
   }

   @Override
   protected SoundEvent getHurtSound(DamageSource damageSource_1) {
      return SoundEvents.ENTITY_PLAYER_HURT;
   }

   @Override
   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_PLAYER_DEATH;
   }

   @Override
   protected SoundEvent getStepSound() {
      return Soundinit.LIGHTERARMORWALKEVENT;
   }

}
