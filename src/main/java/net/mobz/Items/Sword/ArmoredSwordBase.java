package net.mobz.Items.Sword;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class ArmoredSwordBase extends SwordItem {
  public ArmoredSwordBase(ToolMaterial toolMaterial_1) {
    super(toolMaterial_1, 1, -2.4f, new Item.Settings());
  }

  @Override
  public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
    tooltip.add(new TranslatableText("item.mobz.armored_sword.tooltip"));
  }
}
