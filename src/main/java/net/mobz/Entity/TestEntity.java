package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.World;


public class TestEntity extends RavagerEntity {

    public TestEntity(EntityType<? extends RavagerEntity> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(200.0D);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(44.0D);
        this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(2.0D);
    }

    protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
        return;

    }

}
