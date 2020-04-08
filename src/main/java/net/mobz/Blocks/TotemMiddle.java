package net.mobz.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class TotemMiddle extends Block {

  protected static final VoxelShape SHAPE;

  public TotemMiddle(Settings settings) {
    super(settings);

  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
    return SHAPE;
  }

  static {
    SHAPE = VoxelShapes.union(createCuboidShape(4D, 0, 4D, 12D, 2D, 12D), createCuboidShape(5D, 2D, 5D, 11D, 3D, 11D),
        createCuboidShape(4D, 3D, 4D, 12D, 13D, 12D), createCuboidShape(5D, 13D, 5D, 11D, 14D, 11D),
        createCuboidShape(4D, 14D, 4D, 12D, 16D, 12D), createCuboidShape(3D, 4D, 5D, 4D, 12D, 6D),
        createCuboidShape(3D, 4D, 10D, 4D, 12D, 11D), createCuboidShape(3D, 5D, 9D, 4D, 11D, 10D),
        createCuboidShape(3D, 5D, 6D, 4D, 11D, 7D), createCuboidShape(3D, 6D, 7D, 4D, 10D, 8D),
        createCuboidShape(3D, 6D, 8D, 4D, 10D, 9D), createCuboidShape(5D, 4D, 12D, 6D, 12D, 13D),
        createCuboidShape(6D, 5D, 12D, 7D, 11D, 13D), createCuboidShape(7D, 6D, 12D, 8D, 10D, 13D),
        createCuboidShape(8D, 6D, 12D, 9D, 10D, 13D), createCuboidShape(9D, 5D, 12D, 10D, 11D, 13D),
        createCuboidShape(10D, 4D, 12D, 11D, 12D, 13D), createCuboidShape(12D, 4D, 10D, 13D, 12D, 11D),
        createCuboidShape(12D, 5D, 9D, 13D, 11D, 10D), createCuboidShape(12D, 6D, 8D, 13D, 10D, 9D),
        createCuboidShape(12D, 6D, 7D, 13D, 10D, 8D), createCuboidShape(12D, 5D, 6D, 13D, 11D, 7D),
        createCuboidShape(12D, 4D, 5D, 13D, 12D, 6D), createCuboidShape(10D, 4D, 3D, 11D, 12D, 4D),
        createCuboidShape(9D, 5D, 3D, 10D, 11D, 4D), createCuboidShape(8D, 6D, 3D, 9D, 10D, 4D),
        createCuboidShape(7D, 6D, 3D, 8D, 10D, 4D), createCuboidShape(6D, 5D, 3D, 7D, 11D, 4D),
        createCuboidShape(5D, 4D, 3D, 6D, 12D, 4D), createCuboidShape(3D, 0, 3D, 5D, 2D, 5D),
        createCuboidShape(3D, 0, 11D, 5D, 2D, 13D), createCuboidShape(11D, 0, 11D, 13D, 2D, 13D),
        createCuboidShape(11D, 0, 3D, 13D, 2D, 5D));
  }
}
