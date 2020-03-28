package net.mobz.Entity;

import java.util.UUID;
import java.util.function.Predicate;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.AttackWithOwnerGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.PounceAtTargetGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SitGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TrackOwnerAttackerGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.HorseBaseEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.SwordItems;

public class FriendEntity extends TameableEntity {
    private static final TrackedData<Float> ALEX_HEALTH;
    private static final TrackedData<Boolean> BEGGING;
    private static final TrackedData<Integer> COLLAR_COLOR;
    public static final Predicate<LivingEntity> FOLLOW_TAMED_PREDICATE;
    private float begAnimationProgress;
    private float lastBegAnimationProgress;

    public FriendEntity(EntityType<? extends FriendEntity> entityType_1, World world_1) {
        super(entityType_1, world_1);

        this.setTamed(false);
        this.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.LEATHER_HELMET));
        this.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.LEATHER_CHESTPLATE));
        this.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.LEATHER_LEGGINGS));
        this.equipStack(EquipmentSlot.FEET, new ItemStack(Items.LEATHER_BOOTS));
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.ArmoredSword));

    }

    public boolean canSpawn(WorldView viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.isDay()
                && !this.world.isWater(entityPos)
                && Configinit.CONFIGZ.AlexSpawn == true;

    }

    protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
        return;
    }

    protected void initGoals() {
        this.sitGoal = new SitGoal(this);
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, this.sitGoal);
        this.goalSelector.add(4, new PounceAtTargetGoal(this, 0.4F));
        this.goalSelector.add(5, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.add(7, new AnimalMateGoal(this, 1.0D));
        this.goalSelector.add(8, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(10, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(10, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.targetSelector.add(3, (new RevengeGoal(this, new Class[0])).setGroupRevenge());

    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
        if (this.isTamed()) {
            this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(30.0D * Configinit.CONFIGZ.LifeMultiplicatorMob);
        } else {
            this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(20.0D * Configinit.CONFIGZ.LifeMultiplicatorMob);
        }

        this.getAttributes().register(EntityAttributes.ATTACK_DAMAGE).setBaseValue(4.0D * Configinit.CONFIGZ.DamageMultiplicatorMob);
    }

    public void setTarget(@Nullable LivingEntity livingEntity_1) {
        super.setTarget(livingEntity_1);
        if (livingEntity_1 == null) {
            this.setAngry(false);
        } else if (!this.isTamed()) {
            this.setAngry(true);
        }

    }

    protected void mobTick() {
        this.dataTracker.set(ALEX_HEALTH, this.getHealth());
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ALEX_HEALTH, this.getHealth());
        this.dataTracker.startTracking(BEGGING, false);
        this.dataTracker.startTracking(COLLAR_COLOR, DyeColor.RED.getId());
    }

    protected void playStepSound(BlockPos blockPos_1, BlockState blockState_1) {
        this.playSound(SoundEvents.BLOCK_GRASS_STEP, 0.15F, 1.0F);
    }

    public void writeCustomDataToTag(CompoundTag compoundTag_1) {
        super.writeCustomDataToTag(compoundTag_1);
        compoundTag_1.putBoolean("Angry", this.isAngry());
        compoundTag_1.putByte("CollarColor", (byte) this.getCollarColor().getId());
    }

    public void readCustomDataFromTag(CompoundTag compoundTag_1) {
        super.readCustomDataFromTag(compoundTag_1);
        this.setAngry(compoundTag_1.getBoolean("Angry"));
        if (compoundTag_1.contains("CollarColor", 99)) {
            this.setCollarColor(DyeColor.byId(compoundTag_1.getInt("CollarColor")));
        }

    }

    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    public void setOwner(PlayerEntity playerEntity_1) {
        this.setTamed(true);
        this.setOwnerUuid(playerEntity_1.getUuid());

    }

    @Environment(EnvType.CLIENT)
    public float getBegAnimationProgress(float float_1) {
        return MathHelper.lerp(float_1, this.lastBegAnimationProgress, this.begAnimationProgress) * 0.15F * 3.1415927F;
    }

    protected float getActiveEyeHeight(EntityPose entityPose_1, EntityDimensions entityDimensions_1) {
        return entityDimensions_1.height * 0.8F;
    }

    public int getLookPitchSpeed() {
        return this.isSitting() ? 20 : super.getLookPitchSpeed();
    }

    public boolean damage(DamageSource damageSource_1, float float_1) {
        if (this.isInvulnerableTo(damageSource_1)) {
            return false;
        } else {
            Entity entity_1 = damageSource_1.getAttacker();
            if (this.sitGoal != null) {
                this.sitGoal.setEnabledWithOwner(false);
            }

            if (entity_1 != null && !(entity_1 instanceof PlayerEntity) && !(entity_1 instanceof ProjectileEntity)) {
                float_1 = (float_1 + 1.0F) / 2.0F;
            }

            return super.damage(damageSource_1, float_1);
        }
    }

    public boolean tryAttack(Entity entity_1) {
        boolean boolean_1 = entity_1.damage(DamageSource.mob(this),
                (float) ((int) this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).getValue()));
        if (boolean_1) {
            this.dealDamage(this, entity_1);
        }

        return boolean_1;
    }

    public void setTamed(boolean boolean_1) {
        super.setTamed(boolean_1);
        if (boolean_1) {
            this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(20.0D);
        } else {
            this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(8.0D);
        }

        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
    }

    public boolean interactMob(PlayerEntity playerEntity_1, Hand hand_1) {
        ItemStack itemStack_1 = playerEntity_1.getStackInHand(hand_1);
        Item item_1 = itemStack_1.getItem();
        if (this.isTamed()) {
            if (!itemStack_1.isEmpty()) {
                if (item_1.isFood()) {
                    if (item_1.getFoodComponent().isMeat() && (Float) this.dataTracker.get(ALEX_HEALTH) < 20.0F) {
                        if (!playerEntity_1.abilities.creativeMode) {
                            itemStack_1.decrement(1);
                        }

                        this.heal((float) item_1.getFoodComponent().getHunger());
                        return true;
                    }
                } else if (item_1 instanceof DyeItem) {
                    DyeColor dyeColor_1 = ((DyeItem) item_1).getColor();
                    if (dyeColor_1 != this.getCollarColor()) {
                        this.setCollarColor(dyeColor_1);
                        if (!playerEntity_1.abilities.creativeMode) {
                            itemStack_1.decrement(1);
                        }

                        return true;
                    }
                }
            }

            if (this.isOwner(playerEntity_1) && !this.world.isClient && !this.isBreedingItem(itemStack_1)) {
                this.sitGoal.setEnabledWithOwner(!this.isSitting());
                this.jumping = false;
                this.navigation.stop();
                this.setTarget((LivingEntity) null);
            }
        } else if (item_1 == Items.GOLD_NUGGET && !this.isAngry()) {
            if (!playerEntity_1.abilities.creativeMode) {
                itemStack_1.decrement(1);
            }

            if (!this.world.isClient) {
                if (this.random.nextInt(8) == 5) {
                    this.setOwner(playerEntity_1);
                    this.navigation.stop();
                    this.setTarget((LivingEntity) null);
                    this.sitGoal.setEnabledWithOwner(true);
                    this.setHealth(30.0F);
                    this.showEmoteParticle(true);
                    this.world.sendEntityStatus(this, (byte) 7);

                } else {
                    this.showEmoteParticle(false);
                    this.world.sendEntityStatus(this, (byte) 6);
                }
            }

            return true;
        }

        return super.interactMob(playerEntity_1, hand_1);
    }

    protected void showEmoteParticle(boolean boolean_1) {
        ParticleEffect particleEffect_1 = ParticleTypes.HAPPY_VILLAGER;
        if (!boolean_1) {
            particleEffect_1 = ParticleTypes.SMOKE;
        }

        for (int int_1 = 0; int_1 < 7; ++int_1) {
            double double_1 = this.random.nextGaussian() * 0.02D;
            double double_2 = this.random.nextGaussian() * 0.02D;
            double double_3 = this.random.nextGaussian() * 0.02D;
            this.world.addParticle(particleEffect_1,
                    this.getX() + (double) (this.random.nextFloat() * this.getWidth() * 2.0F)
                            - (double) this.getWidth(),
                    this.getY() + 0.5D + (double) (this.random.nextFloat() * this.getHeight()), this.getZ()
                            + (double) (this.random.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(),
                    double_1, double_2, double_3);
        }

    }

    @Environment(EnvType.CLIENT)
    public float method_6714() {
        if (this.isAngry()) {
            return 1.5393804F;
        } else {
            return this.isTamed()
                    ? (0.55F - (this.getHealth() - (Float) this.dataTracker.get(ALEX_HEALTH)) * 0.02F) * 3.1415927F
                    : 0.62831855F;
        }
    }

    public int getLimitPerChunk() {
        return 8;
    }

    public boolean isAngry() {
        return ((Byte) this.dataTracker.get(TAMEABLE_FLAGS) & 2) != 0;
    }

    public void setAngry(boolean boolean_1) {
        byte byte_1 = (Byte) this.dataTracker.get(TAMEABLE_FLAGS);
        if (boolean_1) {
            this.dataTracker.set(TAMEABLE_FLAGS, (byte) (byte_1 | 2));
        } else {
            this.dataTracker.set(TAMEABLE_FLAGS, (byte) (byte_1 & -3));
        }

    }

    public DyeColor getCollarColor() {
        return DyeColor.byId((Integer) this.dataTracker.get(COLLAR_COLOR));
    }

    public void setCollarColor(DyeColor dyeColor_1) {
        this.dataTracker.set(COLLAR_COLOR, dyeColor_1.getId());
    }

    public FriendEntity method_6717(PassiveEntity passiveEntity_1) {
        FriendEntity FriendEntity_1 = (FriendEntity) Entityinit.FRIEND.create(this.world);
        UUID uUID_1 = this.getOwnerUuid();
        if (uUID_1 != null) {
            FriendEntity_1.setOwnerUuid(uUID_1);
            FriendEntity_1.setTamed(true);
        }

        return FriendEntity_1;
    }

    public void setBegging(boolean boolean_1) {
        this.dataTracker.set(BEGGING, boolean_1);
    }

    public boolean isBegging() {
        return (Boolean) this.dataTracker.get(BEGGING);
    }

    public boolean canAttackWithOwner(LivingEntity livingEntity_1, LivingEntity livingEntity_2) {
        if (!(livingEntity_1 instanceof CreeperEntity) && !(livingEntity_1 instanceof GhastEntity)) {
            if (livingEntity_1 instanceof FriendEntity) {
                FriendEntity FriendEntity_1 = (FriendEntity) livingEntity_1;
                if (FriendEntity_1.isTamed() && FriendEntity_1.getOwner() == livingEntity_2) {
                    return false;
                }
            }

            if (livingEntity_1 instanceof PlayerEntity && livingEntity_2 instanceof PlayerEntity
                    && !((PlayerEntity) livingEntity_2).shouldDamagePlayer((PlayerEntity) livingEntity_1)) {
                return false;
            } else if (livingEntity_1 instanceof HorseBaseEntity && ((HorseBaseEntity) livingEntity_1).isTame()) {
                return false;
            } else {
                return !(livingEntity_1 instanceof CatEntity) || !((CatEntity) livingEntity_1).isTamed();
            }
        } else {
            return false;
        }
    }

    public boolean canBeLeashedBy(PlayerEntity playerEntity_1) {
        return !this.isAngry() && super.canBeLeashedBy(playerEntity_1);
    }

    public PassiveEntity createChild(PassiveEntity var1) {
        return this.method_6717(var1);
    }

    static {
        ALEX_HEALTH = DataTracker.registerData(FriendEntity.class, TrackedDataHandlerRegistry.FLOAT);
        BEGGING = DataTracker.registerData(FriendEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        COLLAR_COLOR = DataTracker.registerData(FriendEntity.class, TrackedDataHandlerRegistry.INTEGER);
        FOLLOW_TAMED_PREDICATE = (livingEntity_1) -> {
            EntityType<?> entityType_1 = livingEntity_1.getType();
            return entityType_1 == EntityType.SHEEP || entityType_1 == EntityType.RABBIT
                    || entityType_1 == EntityType.FOX;
        };
    }

}
