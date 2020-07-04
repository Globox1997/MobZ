package net.mobz.Blocks;

import java.util.List;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.mobz.Entity.Nullable;

public class TotemTop extends Block {
  public static final DirectionProperty FACING;
  protected static final VoxelShape SHAPE;

  public TotemTop(Settings settings) {
    super(settings);
  }

  @Override
  @Environment(EnvType.CLIENT)
  public void buildTooltip(ItemStack stack, @Nullable BlockView view, List<Text> tooltip, TooltipContext options) {
    tooltip.add(new TranslatableText("block.mobz.totemtop.tooltip"));
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
    SHAPE = createCuboidShape(4D, 0, 4D, 12D, 10D, 12D);
  }
}
