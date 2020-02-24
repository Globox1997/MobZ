package net.mobz.Entity;

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
import net.mobz.glomod;

public class BigBossEntity extends ZombieEntity {

    public BigBossEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 100;
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(400D);
        this.getAttributeInstance(EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(30.0D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(6D);
        this.getAttributeInstance(SPAWN_REINFORCEMENTS).setBaseValue(0.0D);
        this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(-4.0D);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
    }

    public boolean isConvertingInWater() {
        return false;
    }

    protected boolean burnsInDaylight() {
        return false;
    }

    public boolean Damage(LivingEntity entity) {
        if (isGlowing() == true) {
            StatusEffectInstance poison = new StatusEffectInstance(StatusEffect.byRawId(19), 200, 1, true, false);
            entity.addStatusEffect(poison);
        }
        ;
        return true;
    }

    public boolean isBaby() {
        return false;
    }

    protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
        return;
    }

    public boolean canSpawn(WorldView viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos lighto = new BlockPos(this.getX(), this.getY(), this.getZ());
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.getLightLevel(lighto) <= 5;

    }

    protected SoundEvent getAmbientSound() {
        return glomod.AMBIENTTANKEVENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return glomod.HURTTANKEVENT;
    }

    protected SoundEvent getDeathSound() {
        return glomod.DEATHTANKEVENT;
    }

    protected SoundEvent getStepSound() {
        return glomod.STEPTANKEVENT;
    }

}
