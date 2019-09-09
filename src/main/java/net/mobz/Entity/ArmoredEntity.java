package net.mobz.Entity;

import net.mobz.Items.*;

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
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;

public class ArmoredEntity extends ZombieEntity {
   public ArmoredEntity(EntityType<? extends ZombieEntity> entityType, World world) {
      super(entityType, world);
   }

   @Override
   protected void initAttributes() {
      super.initAttributes();
      this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(20D);
      this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
      this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(7D);
      this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(3.0D);

   }

   @Override
   protected void initEquipment(LocalDifficulty localDifficulty_1) {
      super.initEquipment(localDifficulty_1);
      if (this.world.getDifficulty() == Difficulty.NORMAL) {
         this.setEquippedStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.ArmoredSword));
         this.setEquippedStack(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
         this.setEquippedStack(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
      } else {
         if (this.world.getDifficulty() == Difficulty.EASY) {
            this.setEquippedStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.ArmoredSword));
            this.setEquippedStack(EquipmentSlot.CHEST, new ItemStack(Items.LEATHER_CHESTPLATE));
            this.setEquippedStack(EquipmentSlot.FEET, new ItemStack(Items.LEATHER_BOOTS));
         } else {
            if (this.world.getDifficulty() == Difficulty.HARD) {
               this.setEquippedStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.ArmoredSword));
               this.setEquippedStack(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
               this.setEquippedStack(EquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
            } else {
            }
         }
      }
   }

   @Override
   public boolean canSpawn(ViewableWorld viewableWorld_1) {
      BlockPos entityPos = new BlockPos(this.x, this.y - 1, this.z);
      return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.intersectsFluid(this.getBoundingBox())
            && !viewableWorld_1.isAir(entityPos)
            && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL;
   }

   @Override
   protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
      return;
   }
}
