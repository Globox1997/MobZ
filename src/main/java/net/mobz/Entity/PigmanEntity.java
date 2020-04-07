package net.mobz.Entity;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.ZombiePigmanEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.Soundinit;

public class PigmanEntity extends ZombiePigmanEntity {

    public PigmanEntity(EntityType<? extends ZombiePigmanEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                .setBaseValue(Configinit.CONFIGZ.PigmanLife * Configinit.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
                .setBaseValue(Configinit.CONFIGZ.PigmanAttack * Configinit.CONFIGZ.DamageMultiplicatorMob);
    }

    protected SoundEvent getAmbientSound() {
        return Soundinit.SAYPIGEVENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return Soundinit.HURTPIGEVENT;
    }

    protected SoundEvent getDeathSound() {
        return Soundinit.DEATHPIGEVENT;
    }

    public boolean canSpawn(WorldView view) {
        BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
        return view.intersectsEntities(this)
                && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
                && this.world.getBlockState(blockunderentity).getBlock()
                        .allowsSpawning(world.getBlockState(blockunderentity), view, blockunderentity, Entityinit.PIG)
                && AutoConfig.getConfigHolder(configz.class).getConfig().PigmanSpawn;

    }

}
