package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.glomod;

public class SpoEntity extends SpiderEntity {
    public SpoEntity(EntityType<? extends SpiderEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(24.0D * glomod.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.31D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(5D * glomod.CONFIGZ.DamageMultiplicatorMob);
    }

    public boolean canSpawn(WorldView viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos lighto = new BlockPos(this.getX(), this.getY(), this.getZ());
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.isNight() && this.world.getLightLevel(lighto) <= 7
                && !this.world.isWater(entityPos)
                && glomod.CONFIGZ.PurpleSpiderSpawn == true;

    }

}
