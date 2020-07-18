package net.mobz.Entity;

import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Config.configz;
import net.mobz.Entity.Attack.*;
import net.mobz.Inits.Soundinit;
import net.minecraft.entity.passive.IronGolemEntity;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.IronGolemLookGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.ai.goal.WanderNearTargetGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
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
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class IceGolem extends IronGolemEntity {

    public IceGolem(EntityType<? extends IronGolemEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 20;
    }

    public static DefaultAttributeContainer.Builder createIceGolemAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH,
                        Configinit.CONFIGZ.IceGolemLife * Configinit.CONFIGZ.LifeMultiplicatorMob)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.26D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                        Configinit.CONFIGZ.IceGolemAttack * Configinit.CONFIGZ.DamageMultiplicatorMob)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30.0D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.5D);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new GolemAttack(this, 1.0D, true));
        this.goalSelector.add(2, new WanderNearTargetGoal(this, 0.9D, 32.0F));
        this.goalSelector.add(5, new IronGolemLookGoal(this));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 0.8D));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new FollowTargetGoal<>(this, PlayerEntity.class, true));
        this.initCustomGoals();
    }

    @Override
    public boolean canSpawn(WorldView view) {
        BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
        return view.intersectsEntities(this) && !world.containsFluid(this.getBoundingBox())
                && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.isDay() && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
                && this.world.getBlockState(blockunderentity).allowsSpawning(view, blockunderentity,
                        Entityinit.ICEGOLEM)
                && AutoConfig.getConfigHolder(configz.class).getConfig().IceGolemSpawn;

    }

    protected void initCustomGoals() {
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge(ZombieEntity.class));
        this.targetSelector.add(2, (new RevengeGoal(this, new Class[0])).setGroupRevenge(SkeletonEntity.class));
        this.targetSelector.add(3, (new RevengeGoal(this, new Class[0])).setGroupRevenge(SpiderEntity.class));
        this.targetSelector.add(4, (new RevengeGoal(this, new Class[0])).setGroupRevenge(CreeperEntity.class));
        this.targetSelector.add(5, (new RevengeGoal(this, new Class[0])).setGroupRevenge(SlimeEntity.class));
        this.targetSelector.add(6, (new RevengeGoal(this, new Class[0])).setGroupRevenge(FrostEntity.class));
        this.targetSelector.add(7, (new RevengeGoal(this, new Class[0])).setGroupRevenge(CreepEntity.class));
        this.targetSelector.add(8, (new RevengeGoal(this, new Class[0])).setGroupRevenge(Boar2.class));
        this.targetSelector.add(9, (new RevengeGoal(this, new Class[0])).setGroupRevenge(Blackbear.class));
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return Soundinit.GOLEMHITEVENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return Soundinit.GOLEMDEATHEVENT;
    }

    @Override
    protected void playStepSound(BlockPos blockPos_1, BlockState blockState_1) {
        this.playSound(Soundinit.GOLEMWALKEVENT, 1.0F, 1.0F);
    }

    @Override
    public boolean canImmediatelyDespawn(double double_1) {
        return true;
    }

}