package net.mobz.Entity;

import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Soundinit;

public class skeli3 extends SkeletonEntity {

    public skeli3(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                .setBaseValue(30D * Configinit.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.26D);
    }

    protected SoundEvent getAmbientSound() {
        return Soundinit.SKELISAYEVENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return Soundinit.SKELIHURTEVENT;
    }

    protected SoundEvent getDeathSound() {
        return Soundinit.SKELIDEATHEVENT;
    }

    protected SoundEvent getStepSound() {
        return Soundinit.SKELISTEPEVENT;
    }

    protected void initGoals() {
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge(LavaGolem.class));
    }

    public boolean canSpawn(WorldView viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && !this.world.isWater(entityPos)
                && AutoConfig.getConfigHolder(configz.class).getConfig().NetherSkeletonSpawn;

    }

}