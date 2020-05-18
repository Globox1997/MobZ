package net.mobz.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class HardenedMetalblock extends Block implements BlockEntityProvider {

  public HardenedMetalblock(Settings settings) {
    super(settings);
  }

  @Override
  public BlockEntity createBlockEntity(BlockView view) {

    return new HardenedMetalblockEntity();
  }

}
