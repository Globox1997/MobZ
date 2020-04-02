package net.mobz.Blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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

    for (int x = -1; x < 2; x++) {
      BlockState newState = world.getBlockState(pos.add(x, 0, 0));
      if (state.getBlock() == Blockinit.ENDERHEADER) {
        if (newState.getBlock() != Blockinit.ENDERHEADER) {
          return false;
        }
      }
    }
    /*
     * for (int z = -1; z < 2; z++) { BlockState newState2 =
     * world.getBlockState(pos.add(0, 0, z)); if (state.getBlock() ==
     * Blockinit.ENDERHEADER) { if (newState2.getBlock() != Blockinit.ENDERHEADER) {
     * return false; } } }
     */

    world.breakBlock(pos, false);
    world.breakBlock(pos.east(), false);
    world.breakBlock(pos.west(), false);

    return true;

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
