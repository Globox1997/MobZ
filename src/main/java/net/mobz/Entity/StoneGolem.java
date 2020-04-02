package net.mobz.Entity;

import net.mobz.Inits.Configinit;
import net.mobz.Config.configz;
import net.mobz.Entity.Attack.*;
import net.mobz.Inits.Soundinit;
import net.minecraft.entity.passive.IronGolemEntity;
import java.util.Random;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class StoneGolem extends IronGolemEntity {

    public StoneGolem(EntityType<? extends IronGolemEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 20;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new GolemAttack(this, 1.0D, false));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge(ZombieEntity.class));
        this.targetSelector.add(2, (new RevengeGoal(this, new Class[0])).setGroupRevenge(SkeletonEntity.class));
        this.targetSelector.add(3, (new RevengeGoal(this, new Class[0])).setGroupRevenge(SpiderEntity.class));
        this.targetSelector.add(4, (new RevengeGoal(this, new Class[0])).setGroupRevenge(CreeperEntity.class));
        this.targetSelector.add(5, (new RevengeGoal(this, new Class[0])).setGroupRevenge(SlimeEntity.class));
    }

    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return Soundinit.GOLEMHITEVENT;
    }

    protected SoundEvent getDeathSound() {
        return Soundinit.GOLEMDEATHEVENT;
    }

    protected void playStepSound(BlockPos blockPos_1, BlockState blockState_1) {
        this.playSound(Soundinit.GOLEMWALKEVENT, 1.0F, 1.0F);
    }

    public static boolean canSpawnInDark(EntityType<? extends HostileEntity> entityType_1, IWorld iWorld_1,
            SpawnType spawnType_1, BlockPos blockPos_1, Random random_1) {
        return true;
    }

    @Override
    public boolean canImmediatelyDespawn(double double_1) {
        return true;
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                .setBaseValue(64.0D * Configinit.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
                .setBaseValue(15D * Configinit.CONFIGZ.DamageMultiplicatorMob);

    }

    public boolean canSpawn(WorldView viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.isDay() && entityPos.getY() < viewableWorld_1.getSeaLevel() - 10
                && !this.world.isWater(entityPos)
                && AutoConfig.getConfigHolder(configz.class).getConfig().StoneGolemSpawn;

    }
}