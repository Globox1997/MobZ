package net.mobz;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.ZombiePigmanEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;

public class PigmanEntity extends ZombiePigmanEntity {

    public PigmanEntity(EntityType<? extends ZombiePigmanEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(24D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(6D);
    }

    @Override
    public boolean canSpawn(ViewableWorld viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.x, this.y - 1, this.z);
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.intersectsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return glomod.SAYPIGEVENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return glomod.HURTPIGEVENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return glomod.DEATHPIGEVENT;
    }

}
