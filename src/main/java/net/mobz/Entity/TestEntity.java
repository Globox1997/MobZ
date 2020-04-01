package net.mobz.Entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnType;
import net.minecraft.world.gen.feature.VillageFeature;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;

public class TestEntity extends PillagerEntity {
    private int currentProjectileCooldown = 0;
    private final int requiredProjectileCooldown = 100;

    public TestEntity(EntityType<TestEntity> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }

    protected void initEquipment(LocalDifficulty difficulty) {

    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 9.0F));
        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        this.targetSelector.add(2, new FollowTargetGoal(this, PlayerEntity.class, false));
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(20D);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        this.getAttributeInstance(EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(10.0D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
                .setBaseValue(1 * Configinit.CONFIGZ.DamageMultiplicatorMob);
    }

    @Override

    protected void mobTick() {
        if (getTarget() != null && !world.isClient && squaredDistanceTo(getTarget()) < 100D && canSee(getTarget())) {
            currentProjectileCooldown++;
            if (currentProjectileCooldown >= requiredProjectileCooldown) {
                currentProjectileCooldown = 0;
                attack(getTarget(), 1);
            }
        } else
            currentProjectileCooldown = 0;

    }

    @Override
    public boolean cannotDespawn() {
        return true;
    }

    @Override
    public void attack(LivingEntity target, float f) {
        Vec3d vec3d = target.getRotationVec(1.0F);
        World world = this.world;
        double i = target.getX() - (target.getX() + vec3d.x * 4.0D);
        double g = target.getBodyY(0.5D) - (0.5D + target.getBodyY(0.5D));
        double h = target.getZ() - (target.getZ() + vec3d.z * 4.0D);
        FireballEntity fireballEntity = new FireballEntity(world, target, i, g, h);
        fireballEntity.explosionPower = 0;
        fireballEntity.updatePosition(target.getX() + vec3d.x * 4.0D, target.getBodyY(0.5D) + 0.5D,
                fireballEntity.getZ() + vec3d.z * 4.0D);
        world.spawnEntity(fireballEntity);

        BlockPos blockPos = (new BlockPos(TestEntity.this)).add(-2 + TestEntity.this.random.nextInt(5), 1,
                -2 + TestEntity.this.random.nextInt(5));
        SmallZombie SmallZombie = (SmallZombie) Entityinit.SMALLZOMBIE.create(TestEntity.this.world);
        SmallZombie.refreshPositionAndAngles(blockPos, 0.0F, 0.0F);
        SmallZombie.initialize(TestEntity.this.world, TestEntity.this.world.getLocalDifficulty(blockPos),
                SpawnType.MOB_SUMMONED, (EntityData) null, (CompoundTag) null);
        // SmallZombie.setOwner(TestEntity.this);
        SmallZombie.setBounds(blockPos);
        SmallZombie.setLifeTicks(20 * (30 + TestEntity.this.random.nextInt(90)));
        TestEntity.this.world.spawnEntity(SmallZombie);

    }

}

/*
 * package net.mobz.Entity; import net.minecraft.entity.EntityType; import
 * net.minecraft.entity.mob.ZombieEntity; import net.minecraft.world.World;
 * public class TestEntity extends ZombieEntity { public TestEntity(EntityType<?
 * extends ZombieEntity> entityType, World world) { super(entityType, world); }
 * }
 */

/*
 * world.addParticle(ParticleTypes.FLAME, bob.getX(), bob.getY() + z2,
 * bob.getZ(), 0.0D, 0.0D, 0.0D);
 * 
 * StatusEffectInstance spd = new StatusEffectInstance(StatusEffect.byRawId(1),
 * 0, 0, false, false); LivingEntity bob = (LivingEntity) entity; Random random
 * = new Random(); Random random2 = new Random(); double z1 = (random.nextInt()
 * % 25); double z2 = z1 / 100; double z3 = random2.nextInt() % 25; double z4 =
 * z3 / 100;
 * 
 * 
 * BlockPos blockPos = (new BlockPos(PillagerBoss.this)).add(-2 +
 * PillagerBoss.this.random.nextInt(5), 1, -2 +
 * PillagerBoss.this.random.nextInt(5)); SmallZombie SmallZombie = (SmallZombie)
 * Entityinit.SMALLZOMBIE.create(PillagerBoss.this.world);
 * SmallZombie.refreshPositionAndAngles(blockPos, 0.0F, 0.0F);
 * SmallZombie.initialize(PillagerBoss.this.world,
 * PillagerBoss.this.world.getLocalDifficulty(blockPos), SpawnType.MOB_SUMMONED,
 * (EntityData) null, (CompoundTag) null); SmallZombie.setBounds(blockPos);
 * SmallZombie.setLifeTicks(20 * (30 + PillagerBoss.this.random.nextInt(90)));
 * PillagerBoss.this.world.spawnEntity(SmallZombie);
 */