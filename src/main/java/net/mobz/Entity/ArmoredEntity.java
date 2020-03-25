package net.mobz.Entity;

import net.mobz.glomod;
import net.mobz.Inits.SwordItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class ArmoredEntity extends ZombieEntity {
   public ArmoredEntity(EntityType<? extends ZombieEntity> entityType, World world) {
      super(entityType, world);
      this.experiencePoints = 20;
   }

   protected void initAttributes() {
      super.initAttributes();
      this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(20D * glomod.CONFIGZ.LifeMultiplicatorMob);
      this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
      this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(7D * glomod.CONFIGZ.DamageMultiplicatorMob);
      this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(3.0D);

   }

   protected void initEquipment(LocalDifficulty localDifficulty_1) {
      super.initEquipment(localDifficulty_1);
      if (this.world.getDifficulty() == Difficulty.NORMAL) {
         this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.ArmoredSword));
         this.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
         this.equipStack(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
      } else {
         if (this.world.getDifficulty() == Difficulty.EASY) {
            this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.ArmoredSword));
            this.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.LEATHER_CHESTPLATE));
            this.equipStack(EquipmentSlot.FEET, new ItemStack(Items.LEATHER_BOOTS));
         } else {
            if (this.world.getDifficulty() == Difficulty.HARD) {
               this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.ArmoredSword));
               this.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
               this.equipStack(EquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
            } else {
            }
         }
      }
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
            && this.world.isNight() && this.world.getLightLevel(lighto) <= 7
            && !this.world.isWater(entityPos)
            && glomod.CONFIGZ.ArmoredZombieSpawn == true;

   }

   public boolean isBaby() {
      return false;
   }
}
