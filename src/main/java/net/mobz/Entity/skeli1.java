package net.mobz.Entity;

import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.Soundinit;

public class skeli1 extends SkeletonEntity {

    public skeli1(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 50;
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                .setBaseValue(Configinit.CONFIGZ.BossSkeletonLife * Configinit.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(2.0D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return Soundinit.SKELASAYEVENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return Soundinit.SKELAHURTEVENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return Soundinit.SKELADEATHEVENT;
    }

    protected SoundEvent getStepSound() {
        return Soundinit.SKELASTEPEVENT;
    }

    @Override
    public boolean canSpawn(WorldView view) {
        BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
        return view.intersectsEntities(this) && this.world.isNight()
                && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.getLightLevel(posentity) <= 7
                && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
                && this.world.getBlockState(blockunderentity).getBlock().allowsSpawning(
                        world.getBlockState(blockunderentity), view, blockunderentity, Entityinit.SKELI1)
                && AutoConfig.getConfigHolder(configz.class).getConfig().BossSkeletonSpawn;

    }
}