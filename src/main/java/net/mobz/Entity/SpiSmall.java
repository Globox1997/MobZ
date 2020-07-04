package net.mobz.Entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CaveSpiderEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import net.mobz.Inits.Configinit;

public class SpiSmall extends CaveSpiderEntity {

    private int lifeTicks;
    private boolean alive;

    public SpiSmall(EntityType<? extends CaveSpiderEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createSpiSmallAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5D * Configinit.CONFIGZ.LifeMultiplicatorMob)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.24D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3D * Configinit.CONFIGZ.DamageMultiplicatorMob)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 15.0D);
    }

    public void setLifeTicks(int lifeTicks) {
        this.alive = true;
        this.lifeTicks = lifeTicks;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.alive && --this.lifeTicks <= 0) {
            this.lifeTicks = 20;
            this.damage(DamageSource.STARVE, 1.0F);
        }

    }

    @Override
    public boolean tryAttack(Entity target) {
        return true;
    }

}
