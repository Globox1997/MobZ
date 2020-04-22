package net.mobz.Entity;

import java.util.EnumSet;
import java.util.function.Predicate;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.ProjectileAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Soundinit;

public class Withender extends WitherEntity {
    private static final Predicate<LivingEntity> CAN_ATTACK_PREDICATE;

    public Withender(EntityType<? extends WitherEntity> entityType_1, World world_1) {
        super(entityType_1, world_1);
        this.experiencePoints = 50;
    }

    protected void initGoals() {
        this.goalSelector.add(0, new Withender.DescendAtHalfHealthGoal());
        this.goalSelector.add(2, new ProjectileAttackGoal(this, 1.0D, 40, 20.0F));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge(EndermanEntity.class));
        this.targetSelector.add(2, (new RevengeGoal(this, new Class[0])).setGroupRevenge(EnderEntity.class));
        this.targetSelector.add(3, new FollowTargetGoal(this, MobEntity.class, 0, false, false, CAN_ATTACK_PREDICATE));
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                .setBaseValue(Configinit.CONFIGZ.WithenderLife * Configinit.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(44D);
        this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(4.0D);
    }

    protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
        return;

    }

    protected SoundEvent getAmbientSound() {
        return Soundinit.WITHIDLEEVENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return Soundinit.WITHHURTEVENT;
    }

    protected SoundEvent getDeathSound() {
        return Soundinit.WITHDEATHEVENT;
    }

    public boolean canSpawn(WorldView viewableWorld_1) {
        return viewableWorld_1.intersectsEntities(this)
                && AutoConfig.getConfigHolder(configz.class).getConfig().WithenderSpawn;

    }

    class DescendAtHalfHealthGoal extends Goal {
        public DescendAtHalfHealthGoal() {
            this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.JUMP, Goal.Control.LOOK));
        }

        @Override
        public boolean canStart() {
            return true;
        }
    }

    static {

        CAN_ATTACK_PREDICATE = (livingEntity) -> {
            return livingEntity.getGroup() != EntityGroup.UNDEAD && livingEntity.method_6102();
        };

    }

}
