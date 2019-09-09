package net.mobz;

import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;

public class skeli3 extends SkeletonEntity {

    public skeli3(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean canSpawn(ViewableWorld viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.x, this.y - 1, this.z);
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.intersectsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL;
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(30D);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.26D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return glomod.SKELISAYEVENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return glomod.SKELIHURTEVENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return glomod.SKELIDEATHEVENT;
    }

    protected SoundEvent getStepSound() {
        return glomod.SKELISTEPEVENT;
    }

}