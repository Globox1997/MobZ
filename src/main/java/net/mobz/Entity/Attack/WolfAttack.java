package net.mobz.Entity.Attack;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.passive.TameableEntity;

public class WolfAttack extends MeleeAttackGoal {
  private final TameableEntity wolf;
  private int ticks;

  public WolfAttack(TameableEntity wolf, double speed, boolean pauseWhenMobIdle) {
    super(wolf, speed, pauseWhenMobIdle);
    this.wolf = wolf;
  }

  public void start() {
    super.start();
    this.ticks = 0;
  }

  public void stop() {
    super.stop();
    this.wolf.setAttacking(false);
  }

  public void tick() {
    super.tick();
    ++this.ticks;
    if (this.ticks >= 5 && this.ticks < 10) {
      this.wolf.setAttacking(true);
    } else {
      this.wolf.setAttacking(false);
    }

  }
}
