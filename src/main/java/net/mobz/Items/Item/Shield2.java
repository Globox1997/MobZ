package net.mobz.Items.Item;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;

public class Shield2 extends ShieldItem {
  public Shield2(Settings settings) {
    super(settings);
  }

  @Override
  public boolean canRepair(ItemStack stack, ItemStack ingredient) {
    return false;
  }

}
