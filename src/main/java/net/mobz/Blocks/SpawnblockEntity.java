package net.mobz.Blocks;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.mobz.Inits.Blockinit;

import net.minecraft.block.SpawnerBlock;
import net.minecraft.world.MobSpawnerLogic;

public class SpawnblockEntity extends BlockEntity implements Tickable {
  private int requiredPlayerRange = 16;
  private int spawndelay = 40;
  private int spawntimecounter = 0;
  private int maxcapofspawns = 10;
  private int spawnRange = 4;
  private int maxNearbyEntities = 4;

  public SpawnblockEntity() {
    super(Blockinit.SPAWNBLOCKENTITY);
  }

  @Override
  public void tick() {
    this.update();
  }

  private boolean isPlayerInRange() {
    BlockPos blockPos = this.getPos();
    return this.getWorld().isPlayerInRange((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D,
        (double) blockPos.getZ() + 0.5D, (double) this.requiredPlayerRange);
  }

  public void update() {
    if (this.isPlayerInRange()) {
      World world = this.getWorld();
      BlockPos blockPos = this.getPos();
      if (world.isClient) {
        double d = (double) blockPos.getX() + (double) world.random.nextFloat();
        double e = (double) blockPos.getY() + (double) world.random.nextFloat();
        double f = (double) blockPos.getZ() + (double) world.random.nextFloat();
        world.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0D, 0.0D, 0.0D);
        world.addParticle(ParticleTypes.FLAME, d, e, f, 0.0D, 0.0D, 0.0D);
      } else {
        CowEntity entity = new CowEntity(EntityType.COW, world);
        int currentmobcount = world.getNonSpectatingEntities(entity.getClass(),
            (new Box((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ(),
                (double) (blockPos.getX() + 1), (double) (blockPos.getY() + 1), (double) (blockPos.getZ() + 1)))
                    .expand((double) this.spawnRange))
            .size();
        spawntimecounter++;
        if (currentmobcount >= this.maxNearbyEntities) {
          return;
        } else {
          if (spawntimecounter >= spawndelay) {
            double g = (double) blockPos.getX()
                + (world.random.nextDouble() - world.random.nextDouble()) * (double) this.spawnRange + 0.5D;
            double h = (double) (blockPos.getY() + world.random.nextInt(3) - 1);
            double k = (double) blockPos.getZ()
                + (world.random.nextDouble() - world.random.nextDouble()) * (double) this.spawnRange + 0.5D;
            if (world.doesNotCollide((EntityType.COW.createSimpleBoundingBox(g, h, k))) && SpawnRestriction.canSpawn(
                EntityType.COW, world.getWorld(), SpawnType.SPAWNER, new BlockPos(g, h, k), world.getRandom())) {

              // CowEntity entity = new CowEntity(EntityType.COW, world);
              entity.updatePosition(g, h, k);
              world.playLevelEvent(2004, blockPos, 0);
              entity.playSpawnEffects();

              world.spawnEntity(entity);
              maxcapofspawns--;
              spawntimecounter = 0;
            }
          }
          if (maxcapofspawns == 0) {
            world.removeBlock(pos, false);
          }
        }
      }
    }
  }
}