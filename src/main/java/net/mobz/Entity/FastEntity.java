package net.mobz.Entity;

import net.mobz.glomod;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class FastEntity extends ZombieEntity {

    public FastEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);

    }

    public boolean canSpawn(WorldView viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos lighto = new BlockPos(this.getX(), this.getY(), this.getZ());
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.getLightLevel(lighto) <= 7;

    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(15D);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(4D);
    }

    public boolean canBreakDoors() {
        return false;
    }

    protected SoundEvent getStepSound() {
        return glomod.STEPSPEEDEVENT;
    }

    protected SoundEvent getAmbientSound() {
        return glomod.SAYSPEEDEVENT;
    }

    public boolean isBaby() {
        return false;
    }

}
