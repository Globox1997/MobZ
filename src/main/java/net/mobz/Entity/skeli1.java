package net.mobz.Entity;

import net.mobz.glomod;

import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class skeli1 extends SkeletonEntity {

    public skeli1(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(40D);
        this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(2.0D);
    }

    protected SoundEvent getAmbientSound() {
        return glomod.SKELASAYEVENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return glomod.SKELAHURTEVENT;
    }

    protected SoundEvent getDeathSound() {
        return glomod.SKELADEATHEVENT;
    }

    protected SoundEvent getStepSound() {
        return glomod.SKELASTEPEVENT;
    }

    public boolean canSpawn(WorldView viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos lighto = new BlockPos(this.getX(), this.getY(), this.getZ());
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.isNight() && this.world.getLightLevel(lighto) <= 7
                && !this.world.isWater(entityPos);

    }
}