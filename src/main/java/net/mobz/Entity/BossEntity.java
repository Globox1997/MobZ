package net.mobz.Entity;

import net.mobz.Items.*;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;

public class BossEntity extends ZombieEntity {

    public BossEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(400D);
        this.getAttributeInstance(EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(30.0D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(10D);
        this.getAttributeInstance(SPAWN_REINFORCEMENTS).setBaseValue(0.0D);
        this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(-4.0D);
    }

    @Override
    public boolean isConvertingInWater() {
        return false;
    }

    @Override
    protected boolean burnsInDaylight() {
        return false;
    }

    @Override
    public boolean canSpawn(ViewableWorld viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.x, this.y - 1, this.z);
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.intersectsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL;
    }

    @Override
    public boolean isBaby() {
        return false;
    }

    @Override
    protected int getCurrentExperience(PlayerEntity playerEntity_1) {

        return this.experiencePoints = 100;
    }

    @Override
    protected void initEquipment(LocalDifficulty localDifficulty_1) {
        super.initEquipment(localDifficulty_1);
        this.setEquippedStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.BossSword));
        this.setEquippedStack(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
        this.setEquippedStack(EquipmentSlot.CHEST, new ItemStack(BossArmorItems.boss_chestplate));
        this.setEquippedStack(EquipmentSlot.FEET, new ItemStack(BossArmorItems.boss_boots));
        this.setEquippedStack(EquipmentSlot.LEGS, new ItemStack(BossArmorItems.boss_leggings));
        this.setEquippedStack(EquipmentSlot.HEAD, new ItemStack(BossArmorItems.boss_helmet));
    }

    @Override
    protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
        return;
    }
}
