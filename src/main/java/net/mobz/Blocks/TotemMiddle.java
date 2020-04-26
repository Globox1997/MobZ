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
import net.minecraft.world.World;
import net.mobz.Inits.Blockinit;

public class TotemMiddle extends Block {
  public static final IntProperty ROTATION;
  protected static final VoxelShape SHAPE;

  public TotemMiddle(Settings settings) {
    super(settings);

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

  public static boolean isValid(World world, BlockPos pos, BlockState state) {
    if (state.getBlock() != Blockinit.TOTEM_MIDDLE) {
      return false;
    }

    BlockState bottom = world.getBlockState(pos.down());
    BlockState middle = world.getBlockState(pos);
    BlockState top = world.getBlockState(pos.up());
    if (bottom.getBlock() == Blockinit.TOTEM_BASE) {
      if (middle.getBlock() == Blockinit.TOTEM_MIDDLE) {
        if (top.getBlock() == Blockinit.TOTEM_TOP) {
          world.breakBlock(pos, false);
          world.breakBlock(pos.down(), false);
          world.breakBlock(pos.up(), false);
          return true;
        }
      }
    }

    return false;

  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
    return SHAPE;
  }

  static {
    ROTATION = Properties.ROTATION;
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
