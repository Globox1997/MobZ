package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributes;
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

  @Override
  protected void initAttributes() {
    super.initAttributes();
    this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
        .setBaseValue(Configinit.CONFIGZ.DeathSpiritLife * Configinit.CONFIGZ.DamageMultiplicatorMob);
    this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
        .setBaseValue(Configinit.CONFIGZ.DeathSpiritAttack * Configinit.CONFIGZ.DamageMultiplicatorMob);
  }

  @Override
  protected void initEquipment(LocalDifficulty difficulty) {
    this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.ArmoredSword));
    this.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0.0F);
  }

}