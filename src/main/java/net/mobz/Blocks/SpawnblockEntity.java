package net.mobz.Blocks;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.mobz.Config.configz;
import net.mobz.Entity.BabyravagerEntity;
import net.mobz.Inits.Blockinit;
import net.mobz.Inits.Entityinit;
//import net.minecraft.block.SpawnerBlock;
//import net.minecraft.world.MobSpawnerLogic;

public class SpawnblockEntity extends BlockEntity implements Tickable {
  private int requiredPlayerRange = 16;
  private int spawnDelay = 200;
  private int spawnTimeCounter = 0;
  private int spawnRange = 5;
  private int maxNearbyEntities = 3;
  private int maxCapofSpawns = AutoConfig.getConfigHolder(configz.class).getConfig().SpawnCountBabyRavagerBlock;

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
      PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 16D, false);
      if (world.isClient) {
        double d = (double) blockPos.getX() + (double) world.random.nextFloat();
        double e = (double) blockPos.getY() + (double) world.random.nextFloat();
        double f = (double) blockPos.getZ() + (double) world.random.nextFloat();
        world.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0D, 0.0D, 0.0D);
        world.addParticle(ParticleTypes.FLAME, d, e, f, 0.0D, 0.0D, 0.0D);
      } else if (!player.isCreative()) {
        BabyravagerEntity entity = new BabyravagerEntity(Entityinit.BABYRAVAGERENTITY, world);
        int currentmobcount = world.getNonSpectatingEntities(entity.getClass(),
            (new Box((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ(),
                (double) (blockPos.getX() + 1), (double) (blockPos.getY() + 1), (double) (blockPos.getZ() + 1)))
                    .expand((double) this.spawnRange))
            .size();
        spawnTimeCounter++;
        if (currentmobcount >= this.maxNearbyEntities) {
          return;
        } else {
          if (spawnTimeCounter >= spawnDelay) {
            double g = (double) blockPos.getX()
                + (world.random.nextDouble() - world.random.nextDouble()) * (double) this.spawnRange + 0.5D;
            double h = (double) (blockPos.getY() + world.random.nextInt(3) - 1);
            double k = (double) blockPos.getZ()
                + (world.random.nextDouble() - world.random.nextDouble()) * (double) this.spawnRange + 0.5D;
            if (world.isSpaceEmpty((Entityinit.BABYRAVAGERENTITY.createSimpleBoundingBox(g, h, k)))
                && SpawnRestriction.canSpawn(Entityinit.BABYRAVAGERENTITY, (ServerWorld) world, SpawnReason.SPAWNER,
                    new BlockPos(g, h, k), world.getRandom())) {
              entity.updatePosition(g, h, k);
              world.syncWorldEvent(2004, blockPos, 0);
              entity.playSpawnEffects();
              world.spawnEntity(entity);
              maxCapofSpawns--;
              spawnTimeCounter = 0;
            }
          }
          if (maxCapofSpawns == 0) {
            world.removeBlock(pos, false);
          }
        }
      }
    }
  }
}
