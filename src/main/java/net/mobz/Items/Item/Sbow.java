package net.mobz.Items.Item;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class Sbow extends BowItem {

   public Sbow(Settings settings) {
      super(settings);
   }

   @Override
   public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
      tooltip.add(new TranslatableText("item.mobz.sbow.tooltip"));
   }

   @Override
   public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
      StatusEffectInstance spd = new StatusEffectInstance(StatusEffect.byRawId(1), 7, 1, false, false);
      LivingEntity bob = (LivingEntity) entity;
      if (selected == true) {
         if (bob.isUsingItem()) {
            bob.addStatusEffect(spd);
         }
      }
   }

}
