package net.mobz.Entity;

import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.Soundinit;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class ArcherEntity extends SkeletonEntity {

    public ArcherEntity(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 20;
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.33D);
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                .setBaseValue(Configinit.CONFIGZ.BowmanLife * Configinit.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
                .setBaseValue(Configinit.CONFIGZ.BowmanAttack * Configinit.CONFIGZ.DamageMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return Soundinit.NOTHINGEVENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.BLOCK_GRASS_STEP;
    }

    @Override
    protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
        return;
    }

    @Override
    protected void initEquipment(LocalDifficulty localDifficulty_1) {
        super.initEquipment(localDifficulty_1);
        this.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.CHAINMAIL_HELMET));
    }

    @Override
    public EntityGroup getGroup() {
        return EntityGroup.DEFAULT;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(3, new LookAroundGoal(this));
        this.targetSelector.add(1, new FollowTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new FollowTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(3, (new RevengeGoal(this, new Class[0])).setGroupRevenge(VillagerEntity.class));
        this.targetSelector.add(4, (new RevengeGoal(this, new Class[0])).setGroupRevenge(IronGolemEntity.class));
    }

    @Override
    public boolean canSpawn(WorldView view) {
        BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
        return view.intersectsEntities(this) && this.world.isDay()
                && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
                && this.world.getBlockState(blockunderentity).getBlock().allowsSpawning(
                        world.getBlockState(blockunderentity), view, blockunderentity, Entityinit.ARCHERENTITY)
                && AutoConfig.getConfigHolder(configz.class).getConfig().BowmanSpawn;

    }

}