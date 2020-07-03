package net.mobz.Blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.mobz.Entity.PillagerBoss;
import net.mobz.Inits.Blockinit;
import net.mobz.Inits.Entityinit;

public class TotemMiddleEntity extends BlockEntity implements Tickable {
  public int spawnTimer = 0;
  private int needspawnTime = 200;
  public boolean startTimer;

  public TotemMiddleEntity() {
    super(Blockinit.TOTEMMIDDLEENTITY);
  }

  public boolean isValid(World world, BlockPos pos, BlockState state) {
    if (state.getBlock() != Blockinit.TOTEM_MIDDLE) {
      return false;
    }
    BlockState bottom = world.getBlockState(pos.down());
    BlockState middle = world.getBlockState(pos);
    BlockState top = world.getBlockState(pos.up());
    if (bottom.getBlock() == Blockinit.TOTEM_BASE) {
      if (middle.getBlock() == Blockinit.TOTEM_MIDDLE) {
        if (top.getBlock() == Blockinit.TOTEM_TOP) {
          return true;
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
    BlockPos blockPos = this.getPos();
    BlockState state = this.getCachedState();

    if (isValid(world, pos, state)) {
      if (world.isClient && startTimer) {
        double d = (double) blockPos.getX() + (double) world.random.nextFloat();
        double e = (double) blockPos.getY() + (double) world.random.nextFloat();
        double f = (double) blockPos.getZ() + (double) world.random.nextFloat();
        double o = (double) blockPos.getY() + ((double) world.random.nextFloat() + 1);
        double r = (double) blockPos.getY() - ((double) world.random.nextFloat());
        world.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0D, 0.0D, 0.0D);
        world.addParticle(ParticleTypes.SMOKE, d, o, f, 0.0D, 0.0D, 0.0D);
        world.addParticle(ParticleTypes.SMOKE, d, r, f, 0.0D, 0.0D, 0.0D);
      } else if (startTimer) {
        spawnTimer++;
      }
    }
    if (spawnTimer == needspawnTime) {
      world.breakBlock(pos.down(), false);
      world.breakBlock(pos, false);
      world.breakBlock(pos.up(), false);
      PillagerBoss pillager = (PillagerBoss) Entityinit.PILLAGERBOSS.create(world);
      BlockPos spawnPos = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
      pillager.refreshPositionAndAngles(spawnPos, 0.0F, 0.0F);
      world.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.HOSTILE, 1F, 1F);
      world.spawnEntity(pillager);
    }
  }
}
