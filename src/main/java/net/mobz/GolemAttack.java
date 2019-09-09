package net.mobz;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.passive.IronGolemEntity;

public class GolemAttack extends MeleeAttackGoal {
   private final IronGolemEntity golem;
   private int field_6627;

   public GolemAttack(IronGolemEntity golem_1, double double_1, boolean boolean_1) {
      super(golem_1, double_1, boolean_1);
      this.golem = golem_1;
   }

   public void start() {
      super.start();
      this.field_6627 = 0;
   }

   public void stop() {
      super.stop();
      this.golem.setAttacking(false);
   }

   public void tick() {
      super.tick();
      ++this.field_6627;
      if (this.field_6627 >= 5 && this.ticksUntilAttack < 10) {
         this.golem.setAttacking(true);
      } else {
         this.golem.setAttacking(false);
      }

   }
}
