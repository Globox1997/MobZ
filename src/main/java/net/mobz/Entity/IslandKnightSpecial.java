package net.mobz.Entity;

import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Iteminit;
import net.mobz.Inits.Soundinit;
import net.mobz.Inits.SwordItems;

public class IslandKnightSpecial extends ZombieEntity {

  public IslandKnightSpecial(EntityType<? extends ZombieEntity> entityType, World world) {
    super(entityType, world);
    this.experiencePoints = 30;
  }

  public static DefaultAttributeContainer.Builder createIslandKnightSpecialAttributes() {
    return HostileEntity.createHostileAttributes()
        .add(EntityAttributes.GENERIC_MAX_HEALTH,
            Configinit.CONFIGZ.WilliamLife * Configinit.CONFIGZ.LifeMultiplicatorMob)
        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.32D)
        .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
            Configinit.CONFIGZ.WilliamAttack * Configinit.CONFIGZ.DamageMultiplicatorMob)
        .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 18.0D).add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, 0D);
  }

  @Override
  public boolean canPickUpLoot() {
    return false;
  }

  @Override
  protected void initGoals() {
    this.goalSelector.add(0, new SwimGoal(this));
    this.goalSelector.add(2, new ZombieAttackGoal(this, 1.0D, false));
    this.targetSelector.add(1, new FollowTargetGoal<>(this, PlayerEntity.class, true));
    this.goalSelector.add(8, new WanderAroundFarGoal(this, 0.9D));
    this.goalSelector.add(9, new LookAtEntityGoal(this, PlayerEntity.class, 3.0F, 1.0F));
    this.goalSelector.add(10, new LookAtEntityGoal(this, MobEntity.class, 8.0F));
  }

  @Override
  protected void initEquipment(LocalDifficulty localDifficulty_1) {
    super.initEquipment(localDifficulty_1);
    if (this.world.getDifficulty() != Difficulty.PEACEFUL) {
      this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.ArmoredSword));
      this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Iteminit.SHIELD));
    }
  }

  @Override
  public EntityGroup getGroup() {
    return EntityGroup.DEFAULT;
  }

  @Override
  protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
    return;
  }

  @Override
  public boolean cannotDespawn() {
    return true;
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
  protected boolean burnsInDaylight() {
    return false;
  }

  @Override
  protected SoundEvent getStepSound() {
    return Soundinit.ARMORWALKEVENT;
  }

  @Override
  public void dealDamage(LivingEntity attacker, Entity target) {
    LivingEntity bob = (LivingEntity) target;
    StatusEffectInstance weakness = new StatusEffectInstance(StatusEffect.byRawId(18), 140, 0, false, false);
    if (target instanceof LivingEntity && !world.isClient) {
      bob.addStatusEffect(weakness);
    }
  }

  @Override
  public boolean isBaby() {
    return false;
  }

  @Override
  public boolean isConvertingInWater() {
    return false;
  }
}
