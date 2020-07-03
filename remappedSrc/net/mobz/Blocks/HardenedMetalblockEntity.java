package net.mobz.Blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.mobz.Entity.MetalGolem;
import net.mobz.Inits.Blockinit;
import net.mobz.Inits.Entityinit;

public class HardenedMetalblockEntity extends BlockEntity implements Tickable {
  private boolean eastORwest;

  public HardenedMetalblockEntity() {
    super(Blockinit.HARDENEDMETALBLOCKENTITY);
  }

  public boolean isValid(World world, BlockPos pos, BlockState state) {
    if (state.getBlock() != Blockinit.HARDENED_METALBLOCK) {
      return false;
    }
    BlockState bottom = world.getBlockState(pos.down());
    BlockState middle = world.getBlockState(pos);
    BlockState top = world.getBlockState(pos.up());
    BlockState left = world.getBlockState(pos.north());
    BlockState right = world.getBlockState(pos.south());
    BlockState left2 = world.getBlockState(pos.east());
    BlockState right2 = world.getBlockState(pos.west());
    if (bottom.getBlock() == Blockinit.HARDENED_METALBLOCK) {
      if (middle.getBlock() == Blockinit.HARDENED_METALBLOCK) {
        if (top.getBlock() == Blocks.CARVED_PUMPKIN) {
          if (left.getBlock() == Blockinit.HARDENED_METALBLOCK && right.getBlock() == Blockinit.HARDENED_METALBLOCK) {
            eastORwest = true;
            return true;
          } else {
            if (left2.getBlock() == Blockinit.HARDENED_METALBLOCK
                && right2.getBlock() == Blockinit.HARDENED_METALBLOCK) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  @Override
  public void tick() {
    this.update();
  }

  public void update() {
    World world = this.getWorld();
    BlockState state = this.getCachedState();
    if (isValid(world, pos, state) && !world.isClient) {
      world.breakBlock(pos.down(), false);
      world.breakBlock(pos, false);
      world.breakBlock(pos.up(), false);
      if (eastORwest == true) {
        world.breakBlock(pos.north(), false);
        world.breakBlock(pos.south(), false);
      } else {
        world.breakBlock(pos.east(), false);
        world.breakBlock(pos.west(), false);
      }
      MetalGolem golem = (MetalGolem) Entityinit.METALGOLEM.create(world);
      BlockPos spawnPos = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
      golem.refreshPositionAndAngles(spawnPos, 0.0F, 0.0F);
      world.spawnEntity(golem);
    }
  }
}
