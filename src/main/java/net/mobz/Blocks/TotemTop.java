package net.mobz.Blocks;

import java.util.List;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityContext;
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
import net.minecraft.world.BlockView;
import net.mobz.Entity.Nullable;

public class TotemTop extends Block {
  public static final IntProperty ROTATION;
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
  public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
    return SHAPE;
  }

  static {
    ROTATION = Properties.ROTATION;
    SHAPE = createCuboidShape(4D, 0, 4D, 12D, 10D, 12D);
  }
}
