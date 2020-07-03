package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.SwordItems;

public class IslandVexEntity extends VexEntity {

  public IslandVexEntity(EntityType<? extends VexEntity> entityType, World world) {
    super(entityType, world);

  }

  public static DefaultAttributeContainer.Builder createIslandVexEntityAttributes() {
    return HostileEntity.createHostileAttributes()
        .add(EntityAttributes.GENERIC_MAX_HEALTH,
            Configinit.CONFIGZ.DeathSpiritLife * Configinit.CONFIGZ.LifeMultiplicatorMob)
        .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
            Configinit.CONFIGZ.DeathSpiritAttack * Configinit.CONFIGZ.DamageMultiplicatorMob)
        .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 18.0D);
  }

  @Override
  protected void initEquipment(LocalDifficulty difficulty) {
    this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.ArmoredSword));
    this.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0.0F);
  }

}