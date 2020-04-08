package net.mobz.Blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.mobz.Inits.Blockinit;

public class Enderheader extends Block {
  protected static final VoxelShape SHAPE;

  public Enderheader(Settings settings) {
    super(settings);
  }

  public static boolean isValid(World world, BlockPos pos, BlockState state) {
    if (state.getBlock() != Blockinit.ENDERHEADER) {
      return false;
    }
    BlockState bottom = world.getBlockState(pos.down(2));
    BlockState top1 = world.getBlockState(pos.down().east());
    BlockState top2 = world.getBlockState(pos.down());
    BlockState top3 = world.getBlockState(pos.down().west());
    BlockState head1 = world.getBlockState(pos.east());
    BlockState head2 = world.getBlockState(pos);
    BlockState head3 = world.getBlockState(pos.west());

    if (bottom.getBlock() == Blocks.SOUL_SAND) {
      if (top1.getBlock() == Blocks.SOUL_SAND) {
        if (top2.getBlock() == Blocks.SOUL_SAND) {
          if (top3.getBlock() == Blocks.SOUL_SAND) {
            if (head1.getBlock() == Blockinit.ENDERHEADER) {
              if (head2.getBlock() == Blockinit.ENDERHEADER) {
                if (head3.getBlock() == Blockinit.ENDERHEADER) {
                  world.breakBlock(pos, false);
                  world.breakBlock(pos.east(), false);
                  world.breakBlock(pos.west(), false);
                  world.breakBlock(pos.down(2), false);
                  world.breakBlock(pos.down().east(), false);
                  world.breakBlock(pos.down(), false);
                  world.breakBlock(pos.down().west(), false);
                  return true;
                }
              }
            }
          }
        }
      }
    }

    BlockState top4 = world.getBlockState(pos.down().north());
    BlockState top5 = world.getBlockState(pos.down().south());
    BlockState head4 = world.getBlockState(pos.north());
    BlockState head5 = world.getBlockState(pos.south());

    if (bottom.getBlock() == Blocks.SOUL_SAND) {
      if (top4.getBlock() == Blocks.SOUL_SAND) {
        if (top2.getBlock() == Blocks.SOUL_SAND) {
          if (top5.getBlock() == Blocks.SOUL_SAND) {
            if (head4.getBlock() == Blockinit.ENDERHEADER) {
              if (head2.getBlock() == Blockinit.ENDERHEADER) {
                if (head5.getBlock() == Blockinit.ENDERHEADER) {
                  world.breakBlock(pos, false);
                  world.breakBlock(pos.north(), false);
                  world.breakBlock(pos.south(), false);
                  world.breakBlock(pos.down(2), false);
                  world.breakBlock(pos.down().north(), false);
                  world.breakBlock(pos.down(), false);
                  world.breakBlock(pos.down().south(), false);
                  return true;
                }
              }
            }
          }
        }
      }
    }

    return false;

  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
    return SHAPE;
  }

  @Environment(EnvType.CLIENT)
  public boolean hasEmissiveLighting(BlockState state) {
    return true;
  }

  static {
    SHAPE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);
  }

}

/*
 * public void onStacksDropped(BlockState state, World world, BlockPos pos,
 * ItemStack stack) { ItemStack headdrop = new ItemStack(Blockinit.ENDERHEADER);
 * super.onStacksDropped(state, world, pos, stack); if
 * (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 1) {
 * Block.dropStack(world, pos, headdrop); } }
 */