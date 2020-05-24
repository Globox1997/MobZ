package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.world.World;
import net.mobz.Inits.Configinit;

public class IslandVexEntity extends VexEntity {

  public IslandVexEntity(EntityType<? extends VexEntity> entityType, World world) {
    super(entityType, world);

  }

  protected void initAttributes() {
    super.initAttributes();
    this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
        .setBaseValue(Configinit.CONFIGZ.DeathSpiritLife * Configinit.CONFIGZ.DamageMultiplicatorMob);
    this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
        .setBaseValue(Configinit.CONFIGZ.DeathSpiritAttack * Configinit.CONFIGZ.DamageMultiplicatorMob);
  }

}