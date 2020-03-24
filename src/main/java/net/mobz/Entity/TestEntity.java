/*package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TestEntity extends HostileEntity implements RangedAttackMob
{
    private int currentProjectileCooldown = 0;
    private final int requiredProjectileCooldown = 100;

    public TestEntity(EntityType<TestEntity> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }
    @Override
    protected void initGoals()
    {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 9.0F));
        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        this.targetSelector.add(2, new FollowTargetGoal(this, PlayerEntity.class, false));
    }
    @Override
    protected void initAttributes()
    {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(20D);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        this.getAttributeInstance(EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(10.0D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(BattleTowers.CONFIG.bossDamageScale);
    }
    @Override
    protected void mobTick()
    {
        if(getTarget() != null && !world.isClient)
        {
            currentProjectileCooldown++;
            if (currentProjectileCooldown >= requiredProjectileCooldown)
            {
                currentProjectileCooldown = 0;
                attack(getTarget(), 1);
            }
        }
        else currentProjectileCooldown = 0;
    }
    @Override
    protected Identifier getLootTableId()
    {
        return new Identifier(BattleTowers.CONFIG.bossLootTable);
    }
    @Override
    public boolean cannotDespawn()
    {
        return true;
    }
    @Override
    public int getSafeFallDistance()
    {
        return 1000;
    }
    @Override
    public void attack(LivingEntity livingEntity, float v)
    {
        Vec3d vec3d_1 = this.getRotationVec(1.0F);
        double double_3 = livingEntity.x - (this.x + vec3d_1.x * 4.0D);
        double double_4 = livingEntity.getBoundingBox().minY + (double)(livingEntity.getHeight() / 2.0F) - (0.5D + this.y + (double)(this.getHeight() / 2.0F));
        double double_5 = livingEntity.z - (this.z + vec3d_1.z * 4.0D);
        FireballEntity fireballEntity_1 = new FireballEntity(world, this, double_3, double_4, double_5);
        fireballEntity_1.explosionPower = 1;
        fireballEntity_1.x = this.x + vec3d_1.x * 4.0D;
        fireballEntity_1.y = this.y + (double)(this.getHeight() / 2.0F) + 0.5D;
        fireballEntity_1.z = this.z + vec3d_1.z * 4.0D;
        world.spawnEntity(fireballEntity_1);
    }

}*/

package net.mobz.Entity;

import net.mobz.glomod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class TestEntity extends ZombieEntity {

    public TestEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 15;
    }


}
