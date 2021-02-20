package net.mobz.Mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.mobz.Inits.Iteminit;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
  public PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
    super(entityType, world);
  }

  @Inject(method = "damageShield(F)V", at = @At(value = "HEAD"))
  private void damageShieldMixin(float amount, CallbackInfo info) {
    if (this.activeItemStack.getItem() == Iteminit.SHIELD) {
      if (!this.world.isClient) {
        ((PlayerEntity) (Object) this).incrementStat(Stats.USED.getOrCreateStat(this.activeItemStack.getItem()));
      }

      if (amount >= 3.0F) {
        int i = 1 + MathHelper.floor(amount);
        Hand hand = this.getActiveHand();
        this.activeItemStack.damage(i, this, (p) -> p.sendToolBreakStatus(p.getActiveHand()));
        if (this.activeItemStack.isEmpty()) {
          if (hand == Hand.MAIN_HAND) {
            this.equipStack(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
          } else {
            this.equipStack(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
          }

          this.activeItemStack = ItemStack.EMPTY;
          this.playSound(SoundEvents.ITEM_SHIELD_BREAK, 0.8F, 0.8F + this.world.random.nextFloat() * 0.4F);
        }
      }

    }
  }

}