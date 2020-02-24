package net.mobz.Entity;

import net.mobz.glomod;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class TankEntity extends ZombieEntity {

    public TankEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 15;
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(60D);
        this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(3.0D);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
        this.getAttributeInstance(EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20.0D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(8D);
        this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
    }

    public boolean isConvertingInWater() {
        return false;
    }

    protected boolean burnsInDaylight() {
        return false;
    }

    public boolean canSpawn(WorldView viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos lighto = new BlockPos(this.getX(), this.getY(), this.getZ());
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.getLightLevel(lighto) <= 7;

    }

    protected SoundEvent getAmbientSound() {
        return glomod.AMBIENTTANKEVENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return glomod.HURTTANKEVENT;
    }

    protected SoundEvent getDeathSound() {
        return glomod.DEATHTANKEVENT;
    }

    protected SoundEvent getStepSound() {
        return glomod.STEPTANKEVENT;
    }

    public boolean isBaby() {
        return false;
    }

}
