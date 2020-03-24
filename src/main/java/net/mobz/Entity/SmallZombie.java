package net.mobz.Entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.mobz.Inits.Soundinit;

public class SmallZombie extends ZombieEntity {

    public SmallZombie(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(6D);
        this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(15.0D);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.24D);
    }

    public boolean isConvertingInWater() {
        return false;
    }

    protected boolean burnsInDaylight() {
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return Soundinit.SAYSPEEDEVENT;
    }

    protected SoundEvent getStepSound() {
        return Soundinit.STEPSPEEDEVENT;
    }

    protected boolean canDropLootAndXp() {
        return false;
    }

    public void setLifeTicks(int i) {
        i = 2000;
    }

    public boolean isBaby() {
        return false;
    }

    public void setOwner(Mage2Entity mage2Entity) {
    }

    public void setBounds(BlockPos blockPos_1) {
    }

	public Entity getOwner() {
		return null;
	}
}
