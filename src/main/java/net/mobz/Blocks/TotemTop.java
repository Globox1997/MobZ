package net.mobz.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class TotemTop extends Block {

  protected static final VoxelShape SHAPE;

  public TotemTop(Settings settings) {
    super(settings);

  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
    return SHAPE;
  }

  static {
    SHAPE = createCuboidShape(4D, 0, 4D, 12D, 10D, 12D);
  }
}
