package net.mobz.Blocks;

import java.util.List;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.BlockView;
import net.mobz.Entity.Nullable;

public class Bossblock extends Block {

  public Bossblock(Settings block) {
    super(block);
  }

  @Override
  @Environment(EnvType.CLIENT)
  public void buildTooltip(ItemStack stack, @Nullable BlockView view, List<Text> tooltip, TooltipContext options) {
    tooltip.add(new TranslatableText("block.mobz.boss_block.tooltip"));
  }

}
