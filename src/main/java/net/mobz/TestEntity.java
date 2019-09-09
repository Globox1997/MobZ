package net.mobz;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.Item;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class TestEntity extends ZombieEntity {

    public TestEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(15D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(4D);
        this.getAttributeInstance(SPAWN_REINFORCEMENTS).setBaseValue(0.6D);
    }

    @Override
    public boolean hasNoGravity() {
        return true;
    }

    @Override
    public boolean canSpawn(IWorld world, SpawnType spawnType) {
        return !this.world.isDaylight();
    }

    /*
     * @Override protected void dropEquipment(DamageSource damageSource_1, int
     * int_1, boolean boolean_1) { super.dropEquipment(damageSource_1, int_1,
     * boolean_1); this.dropItem(Item.byRawId(1)); this.dropItem(Items.GRAY_DYE);
     * super.getDropChance(null); }
     */
    @Override
    protected float getDropChance(EquipmentSlot equipmentSlot_1) {
        float float_3;
        this.dropItem(Item.byRawId(1));
        return float_3 = 0.5f;

    }

    /*
     * this.setEquippedStack(EquipmentSlot.FEET,new ItemStack(Items.DIAMOND_BOOTS));
     * Entity entity_1 = damageSource_1.getAttacker(); if (entity_1 instanceof
     * CreeperEntity) { CreeperEntity creeperEntity_1 = (CreeperEntity)entity_1; if
     * (creeperEntity_1.shouldDropHead()) { creeperEntity_1.onHeadDropped();
     * ItemStack itemStack_1 = this.getSkull(); if (!itemStack_1.isEmpty()) {
     * this.dropStack(itemStack_1); }
     */

}
