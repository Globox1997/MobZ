package net.mobz.Entity;

import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.SwordItems;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
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

   public static DefaultAttributeContainer.Builder createArmoredEntityAttributes() {
      return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH,
                  Configinit.CONFIGZ.ArmoredZombieLife * Configinit.CONFIGZ.LifeMultiplicatorMob)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23D)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                  Configinit.CONFIGZ.ArmoredZombieAttack * Configinit.CONFIGZ.DamageMultiplicatorMob)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0D).add(EntityAttributes.GENERIC_ARMOR, 3D)
            .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, 0D);
   }

   @Override
   public boolean canPickUpLoot() {
      return false;
   }

   @Override
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

   @Override
   protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
      return;
   }

   @Override
   public boolean canSpawn(WorldView view) {
      BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
      BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
      return view.intersectsEntities(this)
            && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
            && this.world.getLightLevel(posentity) <= 7
            && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
            && this.world.getBlockState(blockunderentity).allowsSpawning(view, blockunderentity, Entityinit.ARMORED)
            && AutoConfig.getConfigHolder(configz.class).getConfig().ArmoredZombieSpawn;

   }

   @Override
   public boolean isBaby() {
      return false;
   }
}
