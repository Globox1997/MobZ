package net.mobz.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class Bosstrophy extends Block {
  public static final DirectionProperty FACING;
  protected static final VoxelShape SHAPE;

  public Bosstrophy(Settings settings) {
    super(settings);

  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return SHAPE;
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

  static {
    FACING = HorizontalFacingBlock.FACING;
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
