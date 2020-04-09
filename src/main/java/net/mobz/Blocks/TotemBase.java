package net.mobz.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class TotemBase extends Block {
  public static final IntProperty ROTATION;
  protected static final VoxelShape SHAPE;

  public TotemBase(Settings settings) {
    super(settings);

  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
    return SHAPE;
  }

  public BlockState getPlacementState(ItemPlacementContext ctx) {
    return (BlockState) this.getDefaultState().with(ROTATION,
        MathHelper.floor((double) (ctx.getPlayerYaw() * 16.0F / 360.0F) + 0.5D) & 15);
  }

  public BlockState rotate(BlockState state, BlockRotation rotation) {
    return (BlockState) state.with(ROTATION, rotation.rotate((Integer) state.get(ROTATION), 16));
  }

  public BlockState mirror(BlockState state, BlockMirror mirror) {
    return (BlockState) state.with(ROTATION, mirror.mirror((Integer) state.get(ROTATION), 16));
  }

  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(ROTATION);
  }

  static {
    ROTATION = Properties.ROTATION;
    SHAPE = VoxelShapes.union(createCuboidShape(1D, 0, 1D, 15D, 1D, 15D), createCuboidShape(2D, 1D, 2D, 14D, 2D, 14D),
        createCuboidShape(4D, 2D, 4D, 12D, 16D, 12D), createCuboidShape(3D, 5D, 4D, 4D, 8D, 5D),
        createCuboidShape(3D, 5D, 11D, 4D, 8D, 12D), createCuboidShape(2D, 6D, 4D, 3D, 9D, 5D),
        createCuboidShape(1D, 8D, 4D, 2D, 11D, 5D), createCuboidShape(2D, 6D, 11D, 3D, 9D, 12D),
        createCuboidShape(1D, 8D, 11D, 2D, 11D, 12D), createCuboidShape(4D, 5D, 3D, 5D, 8D, 4D),
        createCuboidShape(4D, 6D, 2D, 5D, 9D, 3D), createCuboidShape(4D, 8D, 1D, 5D, 11D, 2D),
        createCuboidShape(11D, 5D, 3D, 12D, 8D, 4D), createCuboidShape(11D, 6D, 2D, 12D, 9D, 3D),
        createCuboidShape(11D, 8D, 1D, 12D, 11D, 2D), createCuboidShape(11D, 5D, 12D, 12D, 8D, 13D),
        createCuboidShape(11D, 6D, 13D, 12D, 9D, 14D), createCuboidShape(11D, 8D, 14D, 12D, 11D, 15D),
        createCuboidShape(4D, 5D, 12D, 5D, 8D, 13D), createCuboidShape(4D, 6D, 13D, 5D, 9D, 14D),
        createCuboidShape(4D, 8D, 14D, 5D, 11D, 15D), createCuboidShape(12D, 5D, 11D, 13D, 8D, 12D),
        createCuboidShape(13D, 6D, 11D, 14D, 9D, 12D), createCuboidShape(14D, 8D, 11D, 15D, 11D, 12D),
        createCuboidShape(12D, 5D, 4D, 13D, 8D, 5D), createCuboidShape(13D, 6D, 4D, 14D, 9D, 5D),
        createCuboidShape(14D, 8D, 4D, 15D, 11D, 5D), createCuboidShape(4D, 14D, 3D, 5D, 16D, 4D),
        createCuboidShape(11D, 14D, 3D, 12D, 16D, 4D), createCuboidShape(12D, 14D, 4D, 13D, 16D, 5D),
        createCuboidShape(12D, 14D, 11D, 13D, 16D, 12D), createCuboidShape(11D, 14D, 12D, 12D, 16D, 13D),
        createCuboidShape(4D, 14D, 12D, 5D, 16D, 13D), createCuboidShape(3D, 14D, 11D, 4D, 16D, 12D),
        createCuboidShape(3D, 14D, 4D, 4D, 16D, 5D), createCuboidShape(3D, 15D, 3D, 4D, 16D, 4D),
        createCuboidShape(12D, 15D, 3D, 13D, 16D, 4D), createCuboidShape(12D, 15D, 12D, 13D, 16D, 13D),
        createCuboidShape(3D, 15D, 12D, 4D, 16D, 13D));
  }
}
