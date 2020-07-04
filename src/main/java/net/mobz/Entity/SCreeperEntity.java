package net.mobz.Entity;

import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.Soundinit;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class SCreeperEntity extends CreeperEntity {

  public SCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
    super(entityType, world);
  }

  public static DefaultAttributeContainer.Builder createSCreeperEntityAttributes() {
    return HostileEntity.createHostileAttributes()
        .add(EntityAttributes.GENERIC_MAX_HEALTH,
            Configinit.CONFIGZ.SoulCreeperLife * Configinit.CONFIGZ.LifeMultiplicatorMob)
        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0D);
  }

  @Override
  protected SoundEvent getHurtSound(DamageSource damageSource_1) {
    return Soundinit.SAYCREEPEVENT;
  }

  @Override
  protected SoundEvent getDeathSound() {
    return Soundinit.DEATHCREEPEVENT;
  }

  @Override
  public boolean canSpawn(WorldView view) {
    BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
    BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
    return view.intersectsEntities(this)
        && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
        && this.world.getLightLevel(posentity) <= 7
        && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
        && this.world.getBlockState(blockunderentity).allowsSpawning(view, blockunderentity, Entityinit.SCREEPER)
        && (this.world.getBlockState(blockunderentity).isOf(Blocks.SOUL_SAND)
            || this.world.getBlockState(blockunderentity).isOf(Blocks.SOUL_SOIL))
        && AutoConfig.getConfigHolder(configz.class).getConfig().SoulCreeperSpawn;

  }
}
