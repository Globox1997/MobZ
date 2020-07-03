package net.mobz.Items.Item;

import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import java.util.List;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;

public class AmatIngot extends Item {
  public AmatIngot(Settings settings) {
    super(settings);
  }

  @Override
  public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
    tooltip.add(new TranslatableText("item.mobz.amat_ingot.tooltip"));
  }
}