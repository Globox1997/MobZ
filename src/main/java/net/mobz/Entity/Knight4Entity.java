package net.mobz.Entity;

import java.util.UUID;
import java.util.function.Predicate;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.AttackWithOwnerGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.FollowTargetIfTamedGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SitGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TrackOwnerAttackerGoal;
import net.minecraft.entity.ai.goal.UniversalAngerGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.Soundinit;
import net.mobz.Inits.SwordItems;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.HorseBaseEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;

public class Knight4Entity extends TameableEntity implements Angerable {
    public static final Predicate<LivingEntity> FOLLOW_TAMED_PREDICATE;

    public Knight4Entity(EntityType<? extends Knight4Entity> entityType, World world) {
        super(entityType, world);
        this.setTamed(false);
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.ArmoredSword));
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new SitGoal(this));
        this.goalSelector.add(3, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(4, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.add(5, new AnimalMateGoal(this, 1.0D));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.targetSelector.add(3, (new RevengeGoal(this, new Class[0])).setGroupRevenge());
        this.targetSelector.add(4, new FollowTargetGoal<>(this, AbstractSkeletonEntity.class, false));
        this.targetSelector.add(5,
                new FollowTargetIfTamedGoal<>(this, AnimalEntity.class, false, FOLLOW_TAMED_PREDICATE));
        this.targetSelector.add(7, new FollowTargetGoal<>(this, AbstractSkeletonEntity.class, false));
        this.targetSelector.add(8, new UniversalAngerGoal<>(this, true));
    }

    public static DefaultAttributeContainer.Builder createKnight4EntityAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.27D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0D);
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(Soundinit.LEATHERWALKEVENT, 0.15F, 1.0F);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return Soundinit.NOTHINGEVENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            Entity entity = source.getAttacker();
            this.setSitting(false);
            if (entity != null && !(entity instanceof PlayerEntity)
                    && !(entity instanceof PersistentProjectileEntity)) {
                amount = (amount + 1.0F) / 2.0F;
            }

            return super.damage(source, amount);
        }
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean bl = target.damage(DamageSource.mob(this),
                (float) ((int) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE)));
        if (bl) {
            this.dealDamage(this, target);
        }

        return bl;
    }

    @Override
    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();
        if (this.world.isClient) {
            boolean bl = this.isOwner(player) || this.isTamed()
                    || item == Items.GOLD_NUGGET && !this.isTamed() && !this.hasAngerTime();
            return bl ? ActionResult.CONSUME : ActionResult.PASS;
        } else {
            if (this.isTamed()) {
                if (this.isBreedingItem(itemStack) && this.getHealth() < this.getMaxHealth()) {
                    if (!player.abilities.creativeMode) {
                        itemStack.decrement(1);
                    }

                    this.heal((float) item.getFoodComponent().getHunger());
                    return ActionResult.SUCCESS;
                }
                if (itemStack.isItemEqual(new ItemStack(Items.BLUE_ORCHID))) {
                    this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.BLUE_ORCHID));
                    return ActionResult.SUCCESS;
                }
                if (itemStack.isItemEqual(new ItemStack(Items.CORNFLOWER))) {
                    this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.CORNFLOWER));
                    return ActionResult.SUCCESS;
                }
                if (itemStack.isItemEqual(new ItemStack(Items.WHITE_TULIP))) {
                    this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.WHITE_TULIP));
                    return ActionResult.SUCCESS;
                }
                if (itemStack.isItemEqual(new ItemStack(Items.PINK_TULIP))) {
                    this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.PINK_TULIP));
                    return ActionResult.SUCCESS;
                }
                if (itemStack.isItemEqual(new ItemStack(Items.RED_TULIP))) {
                    this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.RED_TULIP));
                    return ActionResult.SUCCESS;
                }
                if (itemStack.isItemEqual(new ItemStack(Items.ORANGE_TULIP))) {
                    this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.ORANGE_TULIP));
                    return ActionResult.SUCCESS;
                }
                if (itemStack.isItemEqual(new ItemStack(Items.ALLIUM))) {
                    this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.ALLIUM));
                    return ActionResult.SUCCESS;
                }
                if (itemStack.isItemEqual(new ItemStack(Items.AZURE_BLUET))) {
                    this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.AZURE_BLUET));
                    return ActionResult.SUCCESS;
                }
                if (itemStack.isItemEqual(new ItemStack(Items.DANDELION))) {
                    this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.DANDELION));
                    return ActionResult.SUCCESS;
                }
                if (itemStack.isItemEqual(new ItemStack(Items.OXEYE_DAISY))) {
                    this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.OXEYE_DAISY));
                    return ActionResult.SUCCESS;
                }
                if (itemStack.isItemEqual(new ItemStack(Items.LILY_OF_THE_VALLEY))) {
                    this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.LILY_OF_THE_VALLEY));
                    return ActionResult.SUCCESS;
                }
                if (itemStack.isItemEqual(new ItemStack(Items.POPPY))) {
                    this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.POPPY));
                    return ActionResult.SUCCESS;
                }
                if (itemStack.isItemEqual(new ItemStack(Items.SHIELD))) {
                    this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
                    return ActionResult.SUCCESS;
                }

            } else if (item == Items.BONE && !this.hasAngerTime()) {
                if (!player.abilities.creativeMode) {
                    itemStack.decrement(1);
                }

                if (this.random.nextInt(3) == 0) {
                    this.setOwner(player);
                    this.navigation.stop();
                    this.setTarget((LivingEntity) null);
                    this.setSitting(true);
                    this.world.sendEntityStatus(this, (byte) 7);
                } else {
                    this.world.sendEntityStatus(this, (byte) 6);
                }

                return ActionResult.SUCCESS;
            }

            return super.interactMob(player, hand);
        }
    }

    @Override
    public Knight4Entity createChild(PassiveEntity passiveEntity) {
        Knight4Entity Knight4Entity = (Knight4Entity) Entityinit.KNIGHT4ENTITY.create(this.world);
        UUID uUID = this.getOwnerUuid();
        if (uUID != null) {
            Knight4Entity.setOwnerUuid(uUID);
            Knight4Entity.setTamed(true);
        }

        return Knight4Entity;
    }

    @Override
    public boolean canAttackWithOwner(LivingEntity target, LivingEntity owner) {
        if (!(target instanceof CreeperEntity) && !(target instanceof GhastEntity)) {
            if (target instanceof Knight4Entity) {
                Knight4Entity Knight4Entity = (Knight4Entity) target;
                return !Knight4Entity.isTamed() || Knight4Entity.getOwner() != owner;
            } else if (target instanceof PlayerEntity && owner instanceof PlayerEntity
                    && !((PlayerEntity) owner).shouldDamagePlayer((PlayerEntity) target)) {
                return false;
            } else if (target instanceof HorseBaseEntity && ((HorseBaseEntity) target).isTame()) {
                return false;
            } else {
                return !(target instanceof TameableEntity) || !((TameableEntity) target).isTamed();
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean canBeLeashedBy(PlayerEntity player) {
        return false;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == Items.MELON_SLICE;
    }

    static {

        FOLLOW_TAMED_PREDICATE = (livingEntity) -> {
            EntityType<?> entityType = livingEntity.getType();
            return entityType == EntityType.SHEEP || entityType == EntityType.RABBIT || entityType == EntityType.FOX;
        };
    }

    @Override
    public int getAngerTime() {

        return 0;
    }

    @Override
    public void setAngerTime(int ticks) {

    }

    @Override
    public UUID getAngryAt() {

        return null;
    }

    @Override
    public void setAngryAt(UUID uuid) {

    }

    @Override
    public void chooseRandomAngerTime() {

    }

}
