package net.mobz.Items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

import java.util.function.Consumer;
import java.util.function.Predicate;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.mobz.glomod;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;

public class SwordGloBase2 extends SwordItem {
   public SwordGloBase2(ToolMaterial toolMaterial_1) {
      super(toolMaterial_1, 1, -2.4f, new Item.Settings().group(glomod.MOBZ_GROUP));
      this.addPropertyGetter(new Identifier("cast"), (itemStack_1, world_1, livingEntity_1) -> {
         if (livingEntity_1 == null) {
            return 0.0F;
         } else {
            return livingEntity_1.getActiveItem().getItem() != Items.BOW ? 0.0F
                  : (float) (itemStack_1.getMaxUseTime() - livingEntity_1.getItemUseTimeLeft()) / 20.0F;
         }
      });
      this.addPropertyGetter(new Identifier("cast"), (itemStack_1, world_1, livingEntity_1) -> {

         return livingEntity_1 != null && livingEntity_1.isUsingItem() && livingEntity_1.getActiveItem() == itemStack_1
               ? 1.0F
               : 0.0F;
      });
   }

   public int getMaxUseTime(ItemStack itemStack_1) {
      return 40;
   }

   public UseAction getUseAction(ItemStack itemStack_1) {
      return UseAction.NONE;
   }

   public TypedActionResult<ItemStack> use(World world_1, PlayerEntity playerEntity_1, Hand hand_1) {
      ItemStack itemStack_1 = playerEntity_1.getStackInHand(hand_1);
      boolean boolean_1 = !playerEntity_1.getArrowType(itemStack_1).isEmpty();
      if (playerEntity_1.abilities.creativeMode && !boolean_1) {
         return boolean_1 ? new TypedActionResult(ActionResult.PASS, itemStack_1)
               : new TypedActionResult(ActionResult.FAIL, itemStack_1);
      } else {
         playerEntity_1.setCurrentHand(hand_1);
         StatusEffectInstance strength = new StatusEffectInstance(StatusEffect.byRawId(5), 40, 0, true, false);
         playerEntity_1.addPotionEffect(strength);
         return new TypedActionResult(ActionResult.SUCCESS, itemStack_1);
      }
   }

   public boolean postHit(ItemStack itemStack_1, LivingEntity livingEntity_1, LivingEntity livingEntity_2) {
      itemStack_1.damage(1, (LivingEntity)livingEntity_2, (Consumer)((livingEntity_1x) -> {
         ((LivingEntity) livingEntity_1x).sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
      }));
      StatusEffectInstance strength = new StatusEffectInstance(StatusEffect.byRawId(2), 1000, 3, true, false);
         livingEntity_1.addPotionEffect(strength);
      return true;
   }

}
