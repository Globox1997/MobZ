package net.mobz.Entity;

import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.Soundinit;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class EnderZombieEntity extends ZombieEntity {
    public EnderZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                .setBaseValue(Configinit.CONFIGZ.EnderzombieLife * Configinit.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(10.0D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
                .setBaseValue(Configinit.CONFIGZ.EnderzombieAttack * Configinit.CONFIGZ.DamageMultiplicatorMob);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return Soundinit.SAYENDEVENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return Soundinit.ENDHURTEVENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return Soundinit.DEATHENDEVENT;
    }

    @Override
    protected SoundEvent getStepSound() {
        return Soundinit.STEPTANKEVENT;
    }

    @Override
    public boolean canSpawn(WorldView view) {
        BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
        return view.intersectsEntities(this)
                && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.getLightLevel(posentity) <= 10
                && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
                && this.world.getBlockState(blockunderentity).getBlock().allowsSpawning(
                        world.getBlockState(blockunderentity), view, blockunderentity, Entityinit.ENDERZOMBIE)
                && AutoConfig.getConfigHolder(configz.class).getConfig().EnderzombieSpawn;

    }

    @Override
    public boolean isBaby() {
        return false;
    }
}
