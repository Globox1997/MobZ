package net.mobz.Entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Soundinit;

public class SmallZombie extends ZombieEntity {
    private MobEntity owner;

    public SmallZombie(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createSmallZombieAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 6D * Configinit.CONFIGZ.LifeMultiplicatorMob)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.24D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3D * Configinit.CONFIGZ.DamageMultiplicatorMob)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 15.0D);
    }

    @Override
    public boolean canPickUpLoot() {
        return false;
    }

    @Override
    public boolean isConvertingInWater() {
        return false;
    }

    @Override
    protected boolean burnsInDaylight() {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return Soundinit.SAYSPEEDEVENT;
    }

    @Override
    protected SoundEvent getStepSound() {
        return Soundinit.STEPSPEEDEVENT;
    }

    @Override
    protected boolean canDropLootAndXp() {
        return false;
    }

    public void setLifeTicks(int i) {
        i = 2000;
    }

    @Override
    public boolean isBaby() {
        return false;
    }

    public void setOwner(Mage2Entity mage2Entity) {
    }

    public void setBounds(BlockPos blockPos_1) {

    }

    public void setOwner(MobEntity owner) {
        MobEntity.class.equals(Mage2Entity.class);
    }

    public Entity getOwner() {
        return this.owner;
    }
}
