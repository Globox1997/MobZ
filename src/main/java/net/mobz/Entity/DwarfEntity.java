package net.mobz.Entity;

import net.minecraft.entity.mob.VindicatorEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;
import net.mobz.glomod;
import net.mobz.Items.SwordItems;

public class DwarfEntity extends VindicatorEntity {

    public DwarfEntity(EntityType<? extends VindicatorEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initEquipment(LocalDifficulty localDifficulty_1) {
        super.initEquipment(localDifficulty_1);
        if (this.world.getDifficulty() != Difficulty.PEACEFUL) {
            this.setEquippedStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.Axe));
            this.setEquippedStack(EquipmentSlot.OFFHAND, new ItemStack(glomod.SHIELD));
        }
    }

    public boolean canSpawn(ViewableWorld viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.x, this.y - 1, this.z);
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.intersectsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.isDaylight();
    }

    @Override
    protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
        return;
    }

    protected SoundEvent getAmbientSound() {
        return glomod.NOTHINGEVENT;
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
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(70.0D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
    }
}
