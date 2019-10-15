package net.mobz.Items;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.mobz.glomod;
import java.util.Random;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.FoodComponent;

public class Rottenflesh extends Item {
  public static final FoodComponent FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(5).saturationModifier(0.8F)
      .meat().build();

  public Rottenflesh() {
    super(new Item.Settings().food(FOOD_COMPONENT).group(glomod.MOBZ_GROUP));
  }

  @Override
  public ItemStack finishUsing(ItemStack stack, World world, LivingEntity entity) {
    Random random = new Random();
    int randomNumber = random.nextInt() % 2;
    if (!world.isClient && randomNumber == 0) {
      StatusEffectInstance hunger = new StatusEffectInstance(StatusEffect.byRawId(17), 600, 0, true, false);
      entity.addPotionEffect(hunger);
    } else {

    }

    return super.finishUsing(stack, world, entity);
  }
}
