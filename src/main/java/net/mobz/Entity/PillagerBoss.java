package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Iteminit;
import net.mobz.Inits.SwordItems;

public class PillagerBoss extends PillagerEntity {
    private int cooldown = 0;
    private final int requiredcooldown = 120;

    public PillagerBoss(EntityType<PillagerBoss> entityType_1, World world_1) {
        super(entityType_1, world_1);
        this.experiencePoints = 50;
        ItemStack itemStack = new ItemStack(SwordItems.ArmoredSword);
        ItemStack itemStack2 = new ItemStack(Iteminit.PILLAGERSTAFF);
        this.equipStack(EquipmentSlot.MAINHAND, itemStack2);
        this.equipStack(EquipmentSlot.OFFHAND, itemStack);
    }

    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 30.0F, 1.0F));
        this.goalSelector.add(3, new LookAtEntityGoal(this, MobEntity.class, 15.0F));
        this.goalSelector.add(4, new WanderAroundGoal(this, 1.0D));
        this.targetSelector.add(1, new FollowTargetGoal(this, PlayerEntity.class, true));
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                .setBaseValue(Configinit.CONFIGZ.PillagerBossLife * Configinit.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        this.getAttributeInstance(EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
                .setBaseValue(Configinit.CONFIGZ.PillagerBossAttack * Configinit.CONFIGZ.DamageMultiplicatorMob);
    }

    protected void initEquipment(LocalDifficulty difficulty) {

    }

    protected void mobTick() {
        StatusEffectInstance slow = new StatusEffectInstance(StatusEffect.byRawId(2), 60, 0, false, false);

        if (getTarget() != null && !world.isClient && squaredDistanceTo(getTarget()) < 4096D && canSee(getTarget())) {

            cooldown++;
            if (cooldown >= requiredcooldown) {
                cooldown = 0;
                attack(getTarget(), 1);
            }
            if (cooldown >= (requiredcooldown - 20)) {
                getTarget().addStatusEffect(slow);
            }
        } else {
            cooldown = 0;
        }
    }

    public boolean cannotDespawn() {
        return true;
    }

    public void attack(LivingEntity target, float f) {
        Vec3d vec3d_1 = this.getRotationVec(1.0F);
        double double_3 = target.getX() - (this.getX() + vec3d_1.x * 2.0D);
        double double_4 = target.getBoundingBox().getYLength() + (double) (target.getHeight() / 2.0F)
                - (0.5D + this.getY() + (double) (this.getHeight() / 2.0F)) + 1D;
        double double_5 = target.getZ() - (this.getZ() + vec3d_1.z * 2.0D);
        double double_9 = target.getBoundingBox().getYLength() + (double) (target.getHeight() / 2.0F)
                - (0.5D + this.getY() + (double) (this.getHeight() / 2.0F)) + 0.7D;
        double double_10 = target.getZ() - (this.getZ() + vec3d_1.z * 2.0D) + 0.7D;
        double double_11 = target.getZ() - (this.getZ() + vec3d_1.z * 2.0D) - 0.7D;
        WitherSkullEntity skull1 = new WitherSkullEntity(world, this, double_3, double_4, double_5);
        WitherSkullEntity skull2 = new WitherSkullEntity(world, this, double_3, double_9, double_10);
        WitherSkullEntity skull3 = new WitherSkullEntity(world, this, double_3, double_9, double_11);
        double double_6 = this.getX() + vec3d_1.x * 2.0D;
        double double_7 = this.getY() + (double) this.getHeight();
        double double_8 = this.getZ() + vec3d_1.z * 2.0D;
        skull1.updatePosition(double_6, double_7, double_8);
        skull2.updatePosition(double_6, double_7, double_8);
        skull3.updatePosition(double_6, double_7, double_8);
        world.spawnEntity(skull1);
        world.spawnEntity(skull2);
        world.spawnEntity(skull3);

    }

    protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
        return;
    }

}
