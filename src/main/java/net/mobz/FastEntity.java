package net.mobz;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class FastEntity extends ZombieEntity {

    public FastEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);

    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(15D);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(4D);
    }

    public boolean canSpawn(IWorld iWorld_1, SpawnType spawnType_1) {
        BlockPos entityPos = new BlockPos(this.x, this.y - 1, this.z);
        return iWorld_1.intersectsEntities(this) && !iWorld_1.intersectsFluid(this.getBoundingBox())
                && !iWorld_1.isAir(entityPos) && this.getPathfindingFavor(entityPos) >= 0.0F;
    }

    @Override
    public boolean canBreakDoors() {
        return false;
    }

    @Override
    protected SoundEvent getStepSound() {
        return glomod.STEPSPEEDEVENT;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return glomod.SAYSPEEDEVENT;
    }

}
