package net.mobz.Entity;

import net.minecraft.entity.mob.ZombiePigmanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;

import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;
import net.mobz.glomod;

public class FullIronEntity extends ZombiePigmanEntity {

   private static final UUID ATTACKING_SPEED_BOOST_UUID = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
   private static final EntityAttributeModifier ATTACKING_SPEED_BOOST;
   private int anger;
   private int angrySoundDelay;
   private UUID angerTarget;

   public FullIronEntity(EntityType<? extends ZombiePigmanEntity> entityType_1, World world_1) {
      super(entityType_1, world_1);

   }

   protected void initEquipment(LocalDifficulty localDifficulty_1) {
      super.initEquipment(localDifficulty_1);
      if (this.world.getDifficulty() != Difficulty.PEACEFUL) {
         this.setEquippedStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
         this.setEquippedStack(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
         this.setEquippedStack(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
         this.setEquippedStack(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
         this.setEquippedStack(EquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
         this.setEquippedStack(EquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
      }
   }

   public boolean canSpawn(ViewableWorld viewableWorld_1) {
      BlockPos entityPos = new BlockPos(this.x, this.y - 1, this.z);
      return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.intersectsFluid(this.getBoundingBox())
            && !viewableWorld_1.isAir(entityPos)
            && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
            && this.world.isDaylight();
   }

   protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
      return;
   }

   protected SoundEvent getAmbientSound() {
      return glomod.NOTHINGEVENT;
   }

   protected SoundEvent getHurtSound(DamageSource damageSource_1) {
      return SoundEvents.ENTITY_PLAYER_HURT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_PLAYER_DEATH;
   }

   private boolean isAngry() {
      return this.anger > 0;
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

   static {
      ATTACKING_SPEED_BOOST = (new EntityAttributeModifier(ATTACKING_SPEED_BOOST_UUID, "Attacking speed boost", 0.05D,
            EntityAttributeModifier.Operation.ADDITION)).setSerialize(false);
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
         this.playSound(glomod.ANGRYBATTLEHORNEVENT, this.getSoundVolume() * 2.0F,
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

   @Override
   protected SoundEvent getStepSound() {
      return SoundEvents.BLOCK_GRASS_STEP;
   }

}
