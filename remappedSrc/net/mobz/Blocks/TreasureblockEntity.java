package net.mobz.Blocks;

import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Tickable;
import net.mobz.Inits.Blockinit;

public class TreasureblockEntity extends BlockEntity implements Tickable {
  public boolean unlocked = false;
  private int unsealCounter = 80;

  public TreasureblockEntity() {
    super(Blockinit.TREASUREBLOCKENTITY);
  }

  @Override
  public void tick() {
    this.update();
  }

  public void update() {
    if (!world.isClient) {
      if (unlocked == true) {
        if (world.getBlockState(pos.north()).getBlock().equals(Blockinit.TREASURE_BLOCK)) {
          Blockinit.TREASUREBLOCKENTITY.get(world, pos.north()).unlocked = true;
        }
        if (world.getBlockState(pos.east()).getBlock().equals(Blockinit.TREASURE_BLOCK)) {
          Blockinit.TREASUREBLOCKENTITY.get(world, pos.east()).unlocked = true;
        }
        if (world.getBlockState(pos.south()).getBlock().equals(Blockinit.TREASURE_BLOCK)) {
          Blockinit.TREASUREBLOCKENTITY.get(world, pos.south()).unlocked = true;
        }
        if (world.getBlockState(pos.west()).getBlock().equals(Blockinit.TREASURE_BLOCK)) {
          Blockinit.TREASUREBLOCKENTITY.get(world, pos.west()).unlocked = true;
        }
        if (world.getBlockState(pos.up()).getBlock().equals(Blockinit.TREASURE_BLOCK)) {
          Blockinit.TREASUREBLOCKENTITY.get(world, pos.up()).unlocked = true;
        }
        if (world.getBlockState(pos.down()).getBlock().equals(Blockinit.TREASURE_BLOCK)) {
          Blockinit.TREASUREBLOCKENTITY.get(world, pos.down()).unlocked = true;
        }
        unsealCounter--;
      }

      if (unsealCounter < 80) {
        unsealCounter--;
        if (unsealCounter <= 0) {
          world.setBlockState(pos, Blocks.STONE_BRICKS.getDefaultState(), 3);
        }
      }
    }
  }
}
