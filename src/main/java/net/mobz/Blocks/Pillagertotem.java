package net.mobz.Blocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Pillagertotem extends Block {

  protected static final VoxelShape SHAPE;

  public Pillagertotem(Settings settings) {
    super(settings);

  }

  public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
    world.playSound(player, pos, SoundEvents.ENTITY_WITHER_SPAWN, SoundCategory.AMBIENT, 1F, 0.3F);
  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
    return SHAPE;
  }

  static {
    SHAPE = VoxelShapes.union(createCuboidShape(1D, 0D, 1D, 15D, 1D, 15D), createCuboidShape(2D, 1D, 2D, 14D, 2D, 14D),
        createCuboidShape(4D, 2D, 4D, 12D, 1D, 12D), createCuboidShape(3D, 5D, 4D, 4D, 8D, 5D),
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
        createCuboidShape(14D, 8D, 4D, 15D, 11D, 5D));
  }
}
