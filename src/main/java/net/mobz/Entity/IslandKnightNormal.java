package net.mobz.Entity;

import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.VindicatorEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Iteminit;
import net.mobz.Inits.Soundinit;

public class IslandKnightNormal extends VindicatorEntity {

  public IslandKnightNormal(EntityType<? extends VindicatorEntity> entityType, World world) {
    super(entityType, world);
  }

  public static DefaultAttributeContainer.Builder createIslandKnightNormalAttributes() {
    return HostileEntity.createHostileAttributes()
        .add(EntityAttributes.GENERIC_MAX_HEALTH,
            Configinit.CONFIGZ.IslandKnightLife * Configinit.CONFIGZ.LifeMultiplicatorMob)
        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.32D)
        .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
            Configinit.CONFIGZ.IslandKnightAttack * Configinit.CONFIGZ.DamageMultiplicatorMob)
        .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 18.0D);
  }

  @Override
  protected void playStepSound(BlockPos pos, BlockState state) {
    if (!state.getMaterial().isLiquid()) {
      this.playSound(Soundinit.LEATHERWALKEVENT, 0.15F, 1F);
    }
  }

  @Override
  protected void initEquipment(LocalDifficulty localDifficulty_1) {
    super.initEquipment(localDifficulty_1);
    if (this.world.getDifficulty() != Difficulty.PEACEFUL) {
      this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
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

}
