package net.mobz.Entity;

import net.mobz.glomod;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;

public class SmallZombie extends ZombieEntity {

    public SmallZombie(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(6D);
        this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(15.0D);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.27600000417232513D);
    }

    @Override
    public boolean isConvertingInWater() {
        return false;
    }

    @Override
    protected boolean burnsInDaylight() {
        return false;
    }

    public boolean canSpawn(ViewableWorld viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.x, this.y - 1, this.z);
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.intersectsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos);

    }

    @Override
    protected SoundEvent getAmbientSound() {
        return glomod.SAYSPEEDEVENT;
    }

    @Override
    protected SoundEvent getStepSound() {
        return glomod.STEPSPEEDEVENT;
    }

	public void setLifeTicks(int i) {
    }
    @Override
    protected boolean canDropLootAndXp() {
        return false;
     }
}
