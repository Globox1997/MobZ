package net.mobz.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class Spawnblock extends Block implements BlockEntityProvider {

  public Spawnblock(Block.Settings settings) {
    super(settings);
  }

  @Override
  public BlockEntity createBlockEntity(BlockView view) {
    return new SpawnblockEntity();
  }

}