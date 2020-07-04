package net.mobz.Entity;

import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.Soundinit;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
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

    public static DefaultAttributeContainer.Builder createEnderZombieEntityAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH,
                        Configinit.CONFIGZ.EnderzombieLife * Configinit.CONFIGZ.LifeMultiplicatorMob)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                        Configinit.CONFIGZ.EnderzombieAttack * Configinit.CONFIGZ.DamageMultiplicatorMob)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0D).add(EntityAttributes.GENERIC_ARMOR, 2D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 10D)
                .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, 0D);
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
                && this.world.getBlockState(blockunderentity).allowsSpawning(view, blockunderentity,
                        Entityinit.ENDERZOMBIE)
                && AutoConfig.getConfigHolder(configz.class).getConfig().EnderzombieSpawn;

    }

    @Override
    public boolean isBaby() {
        return false;
    }
}
