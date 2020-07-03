package net.mobz.Entity.Attack;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.passive.IronGolemEntity;

public class GolemAttack extends MeleeAttackGoal {
   private final IronGolemEntity golem;
   private int ticks;

   public GolemAttack(IronGolemEntity golem, double speed, boolean pauseWhenMobIdle) {
      super(golem, speed, pauseWhenMobIdle);
      this.golem = golem;
   }

   public void start() {
      super.start();
      this.ticks = 0;
   }

   public void stop() {
      super.stop();
      this.golem.setAttacking(false);
   }

   public void tick() {
      super.tick();
      ++this.ticks;
      if (this.ticks >= 5 && this.ticksUntilAttack < 10) {
         this.golem.setAttacking(true);
      } else {
         this.golem.setAttacking(false);
      }

   }
}
