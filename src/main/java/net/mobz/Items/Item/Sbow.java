package net.mobz.Items.Item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Sbow extends BowItem {
   public Sbow(Settings settings) {
      super(settings);
   }

   @Override
   public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
      StatusEffectInstance spd = new StatusEffectInstance(StatusEffect.byRawId(1), 0, 0, false, false);
      if (selected == true) {
         LivingEntity bob = (LivingEntity) entity;
         bob.addStatusEffect(spd);
      }
   }
}
