package net.mobz.Blocks;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.BlockView;

public class HardenedMetalblock extends Block implements BlockEntityProvider {

  public HardenedMetalblock(Settings settings) {
    super(settings);
  }

  @Override
  @Environment(EnvType.CLIENT)
  public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
    tooltip.add(new TranslatableText("block.mobz.hardenedmetal_block.tooltip"));
  }

  @Override
  public BlockEntity createBlockEntity(BlockView view) {
    return new HardenedMetalblockEntity();
  }

}
