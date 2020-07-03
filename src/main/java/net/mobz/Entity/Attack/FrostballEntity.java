package net.mobz.Entity.Attack;

import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.block.SnowyBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import net.minecraft.entity.projectile.SmallFireballEntity;

public class FrostballEntity extends AbstractFireballEntity {
   public FrostballEntity(EntityType<? extends FrostballEntity> entityType_1, World world_1) {
      super(entityType_1, world_1);
   }

   public FrostballEntity(World world_1, LivingEntity livingEntity_1, double double_1, double double_2,
         double double_3) {
      super(EntityType.SMALL_FIREBALL, livingEntity_1, double_1, double_2, double_3, world_1);
   }

   public FrostballEntity(World world_1, double double_1, double double_2, double double_3, double double_4,
         double double_5, double double_6) {
      super(EntityType.SMALL_FIREBALL, double_1, double_2, double_3, double_4, double_5, double_6, world_1);
   }

   @Override
   protected void onEntityHit(EntityHitResult entityHitResult) {
      super.onEntityHit(entityHitResult);
      if (!this.world.isClient) {
         Entity entity = entityHitResult.getEntity();
         if (!entity.isFireImmune()) {
            Entity entity2 = this.getOwner();
            int i = entity.getFireTicks();
            entity.setOnFireFor(5);
            boolean bl = entity.damage(DamageSource.fireball(this, entity2), 5.0F);
            if (!bl) {
               entity.setFireTicks(i);
            } else if (entity2 instanceof LivingEntity) {
               this.dealDamage((LivingEntity) entity2, entity);
            }
         }

      }
   }

   @Override
   protected void onBlockHit(BlockHitResult blockHitResult) {
      super.onBlockHit(blockHitResult);
      if (!this.world.isClient) {
         Entity entity = this.getOwner();
         if (entity == null || !(entity instanceof MobEntity)
               || this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            BlockPos blockPos = blockHitResult.getBlockPos().offset(blockHitResult.getSide());
            if (this.world.isAir(blockPos)) {
               // this.world.setBlockState(blockPos, SnowBlock.def);
            }
         }

      }
   }

   @Override
   protected void onCollision(HitResult hitResult) {
      super.onCollision(hitResult);
      if (!this.world.isClient) {
         this.remove();
      }

   }

   @Override
   public boolean collides() {
      return false;
   }

   @Override
   public boolean damage(DamageSource damageSource_1, float float_1) {
      return false;
   }
}
