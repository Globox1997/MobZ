package net.mobz.Entity;

import net.minecraft.entity.mob.VindicatorEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.Soundinit;
import net.mobz.Inits.SwordItems;

public class IslandKing extends VindicatorEntity {
  private int cooldown = 0;
  private final int requiredCooldown = 200;

  public IslandKing(EntityType<? extends VindicatorEntity> entityType, World world) {
    super(entityType, world);
    this.experiencePoints = 50;

  }

  @Override
  protected void playStepSound(BlockPos pos, BlockState state) {
    if (!state.getMaterial().isLiquid()) {
      this.playSound(Soundinit.LEATHERWALKEVENT, 0.15F, 1F);
    }
  }

  @Override
  protected void initAttributes() {
    super.initAttributes();
    this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);
    this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(18.0D);
    this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
        .setBaseValue(Configinit.CONFIGZ.KingCharlesLife * Configinit.CONFIGZ.LifeMultiplicatorMob);
    this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
        .setBaseValue(Configinit.CONFIGZ.KingCharlesAttack * Configinit.CONFIGZ.DamageMultiplicatorMob);
  }

  @Override
  protected void initEquipment(LocalDifficulty localDifficulty_1) {
    super.initEquipment(localDifficulty_1);
    if (this.world.getDifficulty() != Difficulty.PEACEFUL) {
      this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.ArmoredSword));
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
  protected void mobTick() {
    StatusEffectInstance slow = new StatusEffectInstance(StatusEffect.byRawId(2), 100, 0, false, false);

    if (getTarget() != null && !world.isClient && squaredDistanceTo(getTarget()) < 4096D && canSee(getTarget())) {

      cooldown++;
      if (cooldown >= requiredCooldown) {
        cooldown = 0;
        attack(getTarget(), 1);
      }
      if (cooldown >= (requiredCooldown - 20)) {
        getTarget().addStatusEffect(slow);
      }
    } else {
      cooldown = 0;
    }
  }

  public void attack(LivingEntity target, float f) {
    BlockPos blockPos = (new BlockPos(IslandKing.this)).add(-2 + IslandKing.this.random.nextInt(5), 1,
        -2 + IslandKing.this.random.nextInt(5));
    IslandVexEntity vexEntity = (IslandVexEntity) Entityinit.ISLANDVEXENTITY.create(IslandKing.this.world);
    vexEntity.refreshPositionAndAngles(blockPos, 0.0F, 0.0F);
    vexEntity.initialize(IslandKing.this.world, IslandKing.this.world.getLocalDifficulty(blockPos),
        SpawnType.MOB_SUMMONED, (EntityData) null, (CompoundTag) null);
    IslandKing.this.world.spawnEntity(vexEntity);

  }

}
