package net.mobz.Entity;

import net.minecraft.entity.mob.VindicatorEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.glomod;
import net.mobz.Inits.Iteminit;
import net.mobz.Inits.Soundinit;
import net.mobz.Inits.SwordItems;

public class DwarfEntity extends VindicatorEntity {

    public DwarfEntity(EntityType<? extends VindicatorEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 30;
    }

    protected void initEquipment(LocalDifficulty localDifficulty_1) {
        super.initEquipment(localDifficulty_1);
        if (this.world.getDifficulty() != Difficulty.PEACEFUL) {
            this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.Axe));
            this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Iteminit.SHIELD));
        }
    }

    public EntityGroup getGroup() {
        return EntityGroup.DEFAULT;
    }

    protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
        return;
    }

    protected SoundEvent getAmbientSound() {
        return Soundinit.NOTHINGEVENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(16.0D);
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(70.0D * glomod.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(7.0D * glomod.CONFIGZ.DamageMultiplicatorMob);
    }

    public boolean canSpawn(WorldView viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && entityPos.getY() < viewableWorld_1.getSeaLevel() - 10
                && !this.world.isWater(entityPos)
                && glomod.CONFIGZ.DwarfSpawn == true;

    }
}
