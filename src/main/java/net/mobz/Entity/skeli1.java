package net.mobz.Entity;

import net.mobz.glomod;

import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;

public class skeli1 extends SkeletonEntity {

    public skeli1(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean canSpawn(ViewableWorld viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.x, this.y - 1, this.z);
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.intersectsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && !this.world.isDaylight();
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(40D);
        this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(2.0D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return glomod.SKELASAYEVENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return glomod.SKELAHURTEVENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return glomod.SKELADEATHEVENT;
    }

    protected SoundEvent getStepSound() {
        return glomod.SKELASTEPEVENT;
    }

}