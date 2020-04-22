package net.mobz.Entity;

import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.SwordItems;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
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

   @Override
   protected void initAttributes() {
      super.initAttributes();
      this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
      this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
      this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
            .setBaseValue(Configinit.CONFIGZ.ArmoredZombieLife * Configinit.CONFIGZ.LifeMultiplicatorMob);
      this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
      this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
            .setBaseValue(Configinit.CONFIGZ.ArmoredZombieAttack * Configinit.CONFIGZ.DamageMultiplicatorMob);
      this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(3.0D);
      this.getAttributeInstance(SPAWN_REINFORCEMENTS).setBaseValue(0.0D);

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
            && this.world.getBlockState(blockunderentity).getBlock()
                  .allowsSpawning(world.getBlockState(blockunderentity), view, blockunderentity, Entityinit.ARMORED)
            && AutoConfig.getConfigHolder(configz.class).getConfig().ArmoredZombieSpawn;

   }

   @Override
   public boolean isBaby() {
      return false;
   }
}
