package net.mobz.Blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class Reddblock extends Block {

  public Reddblock(Settings block) {
    super(block);
  }

  @Override
  @Environment(EnvType.CLIENT)
  public boolean hasEmissiveLighting(BlockState state) {
    return true;
  }

}
