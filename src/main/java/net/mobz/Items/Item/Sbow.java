package net.mobz.Items.Item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class Sbow extends BowItem {
   public Sbow(Settings settings) {
      super(settings);
      this.addPropertyGetter(new Identifier("pull"), (stack, world, entity) -> {
         if (entity == null) {
            return 0.0F;
         } else {
            return entity.getActiveItem().getItem() != this ? 0.0F
                  : (float) (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0F;
         }
      });
      this.addPropertyGetter(new Identifier("pulling"), (stack, world, entity) -> {
         return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;
      });
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
