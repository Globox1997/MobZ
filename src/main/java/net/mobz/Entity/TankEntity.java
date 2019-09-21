package net.mobz.Entity;

import net.mobz.glomod;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;

public class TankEntity extends ZombieEntity {

    public TankEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(60D);
        this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(3.0D);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000417232513D);
        this.getAttributeInstance(EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20.0D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(8D);
        this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
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
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && !this.world.isDaylight();
            
           
       
                
    } 

    @Override
    protected SoundEvent getAmbientSound() {
        return glomod.AMBIENTTANKEVENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return glomod.HURTTANKEVENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return glomod.DEATHTANKEVENT;
    }

    @Override
    protected SoundEvent getStepSound() {
        return glomod.STEPTANKEVENT;
    }
    
}
