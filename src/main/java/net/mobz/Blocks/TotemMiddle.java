package net.mobz.Blocks;

import java.util.List;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.mobz.Entity.Nullable;

public class TotemMiddle extends Block implements BlockEntityProvider {
  public static final IntProperty ROTATION;
  protected static final VoxelShape SHAPE;

  public TotemMiddle(Settings settings) {
    super(settings);

  }

  @Override
  @Environment(EnvType.CLIENT)
  public void buildTooltip(ItemStack stack, @Nullable BlockView view, List<Text> tooltip, TooltipContext options) {
    tooltip.add(new TranslatableText("block.mobz.totemmiddle.tooltip"));
  }

  @Override
  public BlockEntity createBlockEntity(BlockView view) {
    return new TotemMiddleEntity();
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

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
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
