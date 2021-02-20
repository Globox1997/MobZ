package net.mobz.Blocks;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.mobz.Inits.Blockinit;
import net.mobz.Inits.Iteminit;
import net.mobz.Inits.Soundinit;

public class Treasureblock extends Block implements BlockEntityProvider {

  public Treasureblock(Settings settings) {
    super(settings);
  }

  @Override
  public BlockEntity createBlockEntity(BlockView view) {

    return new TreasureblockEntity();
  }

  @Override
  @Environment(EnvType.CLIENT)
<<<<<<< HEAD
  public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
=======
	public void appendTooltip(ItemStack stack, @Nullable BlockView view, List<Text> tooltip, TooltipContext options) {
>>>>>>> e4784737f10a32cb71f6da23d8d9d14050286952
    tooltip.add(new TranslatableText("block.mobz.treasure_block.tooltip"));
  }

  @Override
  public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
      BlockHitResult hit) {
    ItemStack heldItem = player.getMainHandStack();
    if (heldItem.isItemEqual(new ItemStack(Iteminit.SEALITEM))) {
      if (!world.isClient) {
        heldItem.decrement(1);
        Blockinit.TREASUREBLOCKENTITY.get(world, pos).unlocked = true;
      }
      world.playSound(null, pos, Soundinit.UNSEALEVENT, SoundCategory.BLOCKS, 1F, 1F);
      return ActionResult.SUCCESS;
    }
    return ActionResult.PASS;
  }

}
