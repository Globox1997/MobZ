package net.mobz.Entity;

import java.util.Random;
import java.util.UUID;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.Soundinit;

public class FullIronEntity extends ZombieEntity {
   private static final UUID ATTACKING_SPEED_BOOST_UUID = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
   private static final EntityAttributeModifier ATTACKING_SPEED_BOOST;
   private int anger;
   private int angrySoundDelay;
   private UUID angerTarget;

   public FullIronEntity(EntityType<? extends FullIronEntity> entityType_1, World world_1) {
      super(entityType_1, world_1);
      this.experiencePoints = 20;
   }

   public boolean canSpawn(WorldView view) {
      BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
      BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
      return view.intersectsEntities(this) && this.world.isDay()
            && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
            && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
            && this.world.getBlockState(blockunderentity).getBlock().allowsSpawning(
                  world.getBlockState(blockunderentity), view, blockunderentity, Entityinit.FULLIRONENTITY)
            && AutoConfig.getConfigHolder(configz.class).getConfig().SteveSpawn;

   }

   protected void initEquipment(LocalDifficulty localDifficulty_1) {
      super.initEquipment(localDifficulty_1);
      if (this.world.getDifficulty() != Difficulty.PEACEFUL) {
         this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
         this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
         this.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
         this.equipStack(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
         this.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
         this.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
      }
   }

   public void setAttacker(@Nullable LivingEntity livingEntity_1) {
      super.setAttacker(livingEntity_1);
      if (livingEntity_1 != null) {
         this.angerTarget = livingEntity_1.getUuid();
      }

   }

   protected void initGoals() {
      this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
      this.goalSelector.add(5, new LookAroundGoal(this));
      this.initCustomGoals();
   }

   protected void initCustomGoals() {
      this.goalSelector.add(2, new ZombieAttackGoal(this, 1.0D, false));
      this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.0D));
      this.targetSelector.add(1, new FullIronEntity.AvoidZombiesGoal(this));
      this.targetSelector.add(2, new FullIronEntity.FollowPlayerIfAngryGoal(this));
   }

   protected void initAttributes() {
      super.initAttributes();
      this.getAttributeInstance(SPAWN_REINFORCEMENTS).setBaseValue(0.0D);
      this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
      this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
            .setBaseValue(Configinit.CONFIGZ.SteveLife * Configinit.CONFIGZ.DamageMultiplicatorMob);
      this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
            .setBaseValue(Configinit.CONFIGZ.SteveAttack * Configinit.CONFIGZ.LifeMultiplicatorMob);
   }

   protected boolean canConvertInWater() {
      return false;
   }

   protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
      return;
   }

   protected SoundEvent getAmbientSound() {
      return Soundinit.NOTHINGEVENT;
   }

   protected SoundEvent getHurtSound(DamageSource damageSource_1) {
      return SoundEvents.ENTITY_PLAYER_HURT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_PLAYER_DEATH;
   }

   protected SoundEvent getStepSound() {
      return SoundEvents.BLOCK_GRASS_STEP;
   }

   protected void mobTick() {
      EntityAttributeInstance entityAttributeInstance_1 = this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED);
      LivingEntity livingEntity_1 = this.getAttacker();
      if (this.isAngry()) {
         if (!this.isBaby() && !entityAttributeInstance_1.hasModifier(ATTACKING_SPEED_BOOST)) {
            entityAttributeInstance_1.addModifier(ATTACKING_SPEED_BOOST);
         }

         --this.anger;
         LivingEntity livingEntity_2 = livingEntity_1 != null ? livingEntity_1 : this.getTarget();
         if (!this.isAngry() && livingEntity_2 != null) {
            if (!this.canSee(livingEntity_2)) {
               this.setAttacker((LivingEntity) null);
               this.setTarget((LivingEntity) null);
            } else {
               this.anger = this.method_20806();
            }
         }
      } else if (entityAttributeInstance_1.hasModifier(ATTACKING_SPEED_BOOST)) {
         entityAttributeInstance_1.removeModifier(ATTACKING_SPEED_BOOST);
      }

      if (this.angrySoundDelay > 0 && --this.angrySoundDelay == 0) {
         this.playSound(Soundinit.ANGRYBATTLEHORNEVENT, this.getSoundVolume() * 2.0F,
               ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) * 1.8F);
      }

      if (this.isAngry() && this.angerTarget != null && livingEntity_1 == null) {
         PlayerEntity playerEntity_1 = this.world.getPlayerByUuid(this.angerTarget);
         this.setAttacker(playerEntity_1);
         this.attackingPlayer = playerEntity_1;
         this.playerHitTimer = this.getLastAttackedTime();
      }

      super.mobTick();
   }

   public static boolean method_20682(EntityType<FullIronEntity> entityType_1, IWorld iWorld_1, SpawnType spawnType_1,
         BlockPos blockPos_1, Random random_1) {
      return iWorld_1.getDifficulty() != Difficulty.PEACEFUL;
   }

   public void writeCustomDataToTag(CompoundTag compoundTag_1) {
      super.writeCustomDataToTag(compoundTag_1);
      compoundTag_1.putShort("Anger", (short) this.anger);
      if (this.angerTarget != null) {
         compoundTag_1.putString("HurtBy", this.angerTarget.toString());
      } else {
         compoundTag_1.putString("HurtBy", "");
      }

   }

   public void readCustomDataFromTag(CompoundTag compoundTag_1) {
      super.readCustomDataFromTag(compoundTag_1);
      this.anger = compoundTag_1.getShort("Anger");
      String string_1 = compoundTag_1.getString("HurtBy");
      if (!string_1.isEmpty()) {
         this.angerTarget = UUID.fromString(string_1);
         PlayerEntity playerEntity_1 = this.world.getPlayerByUuid(this.angerTarget);
         this.setAttacker(playerEntity_1);
         if (playerEntity_1 != null) {
            this.attackingPlayer = playerEntity_1;
            this.playerHitTimer = this.getLastAttackedTime();
         }
      }

   }

   public boolean damage(DamageSource damageSource_1, float float_1) {
      if (this.isInvulnerableTo(damageSource_1)) {
         return false;
      } else {
         Entity entity_1 = damageSource_1.getAttacker();
         if (entity_1 instanceof PlayerEntity && !((PlayerEntity) entity_1).isCreative() && this.canSee(entity_1)) {
            this.method_20804(entity_1);
         }

         return super.damage(damageSource_1, float_1);
      }
   }

   private boolean method_20804(Entity entity_1) {
      this.anger = this.method_20806();
      this.angrySoundDelay = this.random.nextInt(40);
      if (entity_1 instanceof LivingEntity) {
         this.setAttacker((LivingEntity) entity_1);
      }

      return true;
   }

   private int method_20806() {
      return 400 + this.random.nextInt(400);
   }

   private boolean isAngry() {
      return this.anger > 0;
   }

   public boolean interactMob(PlayerEntity playerEntity_1, Hand hand_1) {
      return false;
   }

   protected ItemStack getSkull() {
      return ItemStack.EMPTY;
   }

   public boolean isAngryAt(PlayerEntity playerEntity_1) {
      return this.isAngry();
   }

   static {
      ATTACKING_SPEED_BOOST = (new EntityAttributeModifier(ATTACKING_SPEED_BOOST_UUID, "Attacking speed boost", 0.05D,
            EntityAttributeModifier.Operation.ADDITION)).setSerialize(false);
   }

   static class FollowPlayerIfAngryGoal extends FollowTargetGoal<PlayerEntity> {
      public FollowPlayerIfAngryGoal(FullIronEntity FullIronEntity_1) {
         super(FullIronEntity_1, PlayerEntity.class, true);
      }

      public boolean canStart() {
         return ((FullIronEntity) this.mob).isAngry() && super.canStart();
      }
   }

   static class AvoidZombiesGoal extends RevengeGoal {
      public AvoidZombiesGoal(FullIronEntity FullIronEntity_1) {
         super(FullIronEntity_1);
         this.setGroupRevenge(new Class[] { ZombieEntity.class });
      }

      protected void setMobEntityTarget(MobEntity mobEntity_1, LivingEntity livingEntity_1) {
         if (mobEntity_1 instanceof FullIronEntity && this.mob.canSee(livingEntity_1)
               && ((FullIronEntity) mobEntity_1).method_20804(livingEntity_1)) {
            mobEntity_1.setTarget(livingEntity_1);
         }

      }
   }
}
