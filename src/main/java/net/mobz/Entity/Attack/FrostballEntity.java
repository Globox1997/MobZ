package net.mobz.Entity.Attack;

import net.minecraft.block.Blocks;
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
   protected void onCollision(HitResult hitResult_1) {
      super.onCollision(hitResult_1);
      if (!this.world.isClient) {
         if (hitResult_1.getType() == HitResult.Type.ENTITY) {
            Entity entity_1 = ((EntityHitResult) hitResult_1).getEntity();
            if (!entity_1.isFireImmune()) {
               int int_1 = entity_1.getFireTicks();
               entity_1.setOnFireFor(0);
               boolean boolean_1 = entity_1.damage(DamageSource.explosiveProjectile(this, this.owner), 5.0F);
               if (boolean_1) {
                  this.dealDamage(this.owner, entity_1);
               } else {
                  entity_1.setFireTicks(int_1);
               }
            }
         } else if (this.owner == null || !(this.owner instanceof MobEntity)
               || this.world.getGameRules().getBoolean(GameRules.MOB_GRIEFING)) {
            BlockHitResult blockHitResult_1 = (BlockHitResult) hitResult_1;
            BlockPos blockPos_1 = blockHitResult_1.getBlockPos().offset(blockHitResult_1.getSide());
            if (this.world.isAir(blockPos_1)) {
               this.world.setBlockState(blockPos_1, Blocks.SNOW.getDefaultState());
            }
         }

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
