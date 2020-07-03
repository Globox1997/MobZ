package net.mobz.Mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.UseAction;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
  public ItemStack shield;

  @Redirect(method = "damageShield(F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"))
  private Item damageshieldmixin(ItemStack shield) {
    Item item = shield.getItem();
    if (item.getUseAction(shield) == UseAction.BLOCK) {
      return Items.SHIELD;
    } else
      return Items.AIR;
  }

}