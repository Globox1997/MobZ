package net.mobz.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.mobz.Inits.Blockinit;

public class Enderheader extends Block {
  public static final DirectionProperty FACING;
  protected static final VoxelShape SHAPE;

  public Enderheader(Settings settings) {
    super(settings);
  }

  @Override
  public BlockState getPlacementState(ItemPlacementContext ctx) {
    return (BlockState) this.getDefaultState().with(FACING, ctx.getPlayerFacing().rotateYClockwise());
  }

  @Override
  public BlockState rotate(BlockState state, BlockRotation rotation) {
    return (BlockState) state.with(FACING, rotation.rotate((Direction) state.get(FACING)));
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return SHAPE;
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

  static {
    FACING = HorizontalFacingBlock.FACING;
    SHAPE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);
  }

}