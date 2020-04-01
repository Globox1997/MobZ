package net.mobz.Blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class Enderhead extends Block {

  public Enderhead(Settings settings) {
    super(settings);
  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
    return VoxelShapes.cuboid(0.25D, 0D, 0.25D, 0.75D, 0.5D, 0.75D);
  }

  @Override
  public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
    return VoxelShapes.cuboid(0.25D, 0D, 0.25D, 0.75D, 0.5D, 0.75D);
  }

  @Environment(EnvType.CLIENT)
  public boolean hasEmissiveLighting(BlockState state) {
    return true;
  }

}
