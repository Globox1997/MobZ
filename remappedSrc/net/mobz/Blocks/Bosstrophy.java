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

public class Bosstrophy extends Block {
  public static final IntProperty ROTATION;
  protected static final VoxelShape SHAPE;

  public Bosstrophy(Settings settings) {
    super(settings);

  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
    return SHAPE;
  }

  @Override
  public BlockState getPlacementState(ItemPlacementContext ctx) {
    return (BlockState) this.getDefaultState().with(ROTATION,
        MathHelper.floor((double) (ctx.getPlayerYaw() * 16.0F / 360.0F) + 0.5D) & 15);
  }

  @Override
  public BlockState rotate(BlockState state, BlockRotation rotation) {
    return (BlockState) state.with(ROTATION, rotation.rotate((Integer) state.get(ROTATION), 16));
  }

  @Override
  public BlockState mirror(BlockState state, BlockMirror mirror) {
    return (BlockState) state.with(ROTATION, mirror.mirror((Integer) state.get(ROTATION), 16));
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(ROTATION);
  }

  static {
    ROTATION = Properties.ROTATION;
    SHAPE = VoxelShapes.union(createCuboidShape(4D, 0, 4D, 12D, 8D, 12D), createCuboidShape(4D, 8D, 4D, 5D, 9D, 12D),
        createCuboidShape(11D, 8D, 4D, 12D, 9D, 12D), createCuboidShape(5D, 8D, 4D, 11D, 9D, 5D),
        createCuboidShape(5D, 8D, 11D, 11D, 9D, 12D), createCuboidShape(4D, 9D, 11D, 6D, 10D, 12D),
        createCuboidShape(10D, 9D, 11D, 12D, 10D, 12D), createCuboidShape(7D, 9D, 11D, 9D, 10D, 12D),
        createCuboidShape(7D, 9D, 4D, 9D, 10D, 5D), createCuboidShape(10D, 9D, 4D, 12D, 10D, 5D),
        createCuboidShape(4D, 9D, 4D, 6D, 10D, 5D), createCuboidShape(4D, 9D, 7D, 5D, 10D, 9D),
        createCuboidShape(11D, 9D, 7D, 12D, 10D, 9D), createCuboidShape(11D, 9D, 10D, 12D, 10D, 11D),
        createCuboidShape(4D, 9D, 10D, 5D, 10D, 11D), createCuboidShape(4D, 9D, 5D, 5D, 10D, 6D),
        createCuboidShape(11D, 9D, 5D, 12D, 10D, 6D));
  }
}
