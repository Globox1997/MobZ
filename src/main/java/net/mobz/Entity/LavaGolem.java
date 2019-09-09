package net.mobz.Entity;

import net.mobz.glomod;
import net.mobz.Entity.Attack.*;

import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.ZombiePigmanEntity;
import net.minecraft.entity.passive.AbstractTraderEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;

public class LavaGolem extends IronGolemEntity {

   public LavaGolem(EntityType<? extends IronGolemEntity> entityType, World world) {
      super(entityType, world);
   }

   @Override
   protected void initGoals() {
      this.goalSelector.add(2, new GolemAttack(this, 1.0D, false));
      this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
      this.goalSelector.add(8, new LookAroundGoal(this));
      this.initCustomGoals();
   }

   protected void initCustomGoals() {
      this.goalSelector.add(2, new GolemAttack(this, 1.0D, false));
      this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D));
      this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge(ZombiePigmanEntity.class));
      this.targetSelector.add(2, new FollowTargetGoal(this, PlayerEntity.class, true));
      this.targetSelector.add(3, new FollowTargetGoal(this, AbstractTraderEntity.class, false));
      this.targetSelector.add(3, new FollowTargetGoal(this, IronGolemEntity.class, true));
      this.targetSelector.add(5,
            new FollowTargetGoal(this, TurtleEntity.class, 10, true, false, TurtleEntity.BABY_TURTLE_ON_LAND_FILTER));
   }

   @Override
   protected SoundEvent getHurtSound(DamageSource damageSource_1) {
      return glomod.GOLEMHITEVENT;
   }

   @Override
   protected SoundEvent getDeathSound() {
      return glomod.GOLEMDEATHEVENT;
   }

   @Override
   protected void playStepSound(BlockPos blockPos_1, BlockState blockState_1) {
      this.playSound(glomod.GOLEMWALKEVENT, 1.0F, 1.0F);
   }

   @Override
   public boolean canSpawn(ViewableWorld viewableWorld_1) {
      BlockPos entityPos = new BlockPos(this.x, this.y - 1, this.z);
      return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.intersectsFluid(this.getBoundingBox())
            && !viewableWorld_1.isAir(entityPos)
            && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL;
   }
   @Override
   public boolean canImmediatelyDespawn(double double_1) {
      return true;
   }
   @Override
   protected void initAttributes() {
       super.initAttributes();
       this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(48.0D);
       this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
       this.getAttributeInstance(EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.5D);
    }

}