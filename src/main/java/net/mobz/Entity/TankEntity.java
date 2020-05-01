package net.mobz.Entity;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
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
import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.Soundinit;

public class TankEntity extends ZombieEntity {

    public TankEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 10;
    }

    @Override
    public boolean canPickUpLoot() {
        return false;
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                .setBaseValue(Configinit.CONFIGZ.TankLife * Configinit.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(3.0D);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
        this.getAttributeInstance(EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20.0D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
                .setBaseValue(Configinit.CONFIGZ.TankAttack * Configinit.CONFIGZ.DamageMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
    }

    @Override
    public boolean isConvertingInWater() {
        return false;
    }

    @Override
    protected boolean burnsInDaylight() {
        return false;
    }

    @Override
    public boolean canSpawn(WorldView view) {
        BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
        return view.intersectsEntities(this)
                && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.getLightLevel(posentity) <= 7
                && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
                && this.world.getBlockState(blockunderentity).getBlock()
                        .allowsSpawning(world.getBlockState(blockunderentity), view, blockunderentity, Entityinit.TANK)
                && AutoConfig.getConfigHolder(configz.class).getConfig().TankSpawn;

    }

    @Override
    protected void dealDamage(LivingEntity attacker, Entity target) {
        LivingEntity bob = (LivingEntity) target;
        StatusEffectInstance weakness = new StatusEffectInstance(StatusEffect.byRawId(18), 100, 0, false, false);
        if (target instanceof LivingEntity && !world.isClient) {
            bob.addStatusEffect(weakness);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return Soundinit.AMBIENTTANKEVENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return Soundinit.HURTTANKEVENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return Soundinit.DEATHTANKEVENT;
    }

    protected SoundEvent getStepSound() {
        return Soundinit.STEPTANKEVENT;
    }

    @Override
    public boolean isBaby() {
        return false;
    }

}
