package net.mobz.Entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CaveSpiderEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.mobz.Inits.Configinit;

public class SpiSmall extends CaveSpiderEntity {

    private MobEntity owner;
    private BlockPos bounds;
    private int lifeTicks;
    private boolean alive;

    public SpiSmall(EntityType<? extends CaveSpiderEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                .setBaseValue(6.0D * Configinit.CONFIGZ.LifeMultiplicatorMob);
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

    public void setOwner(MobEntity owner) {
        this.owner = owner;
    }

    public void setBounds(@Nullable BlockPos pos) {
        this.bounds = pos;
    }

}
