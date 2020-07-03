package net.mobz.Entity;

import java.util.Random;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;

public class SpiEntity extends SpiderEntity {
    public SpiEntity(EntityType<? extends SpiderEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createSpiEntityAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH,
                        Configinit.CONFIGZ.BlueSpiderLife * Configinit.CONFIGZ.LifeMultiplicatorMob)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.31D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                        Configinit.CONFIGZ.BlueSpiderAttack * Configinit.CONFIGZ.DamageMultiplicatorMob);
    }

    @Override
    public void dealDamage(LivingEntity attacker, Entity target) {
        Random random = new Random();
        int randomNumber = (random.nextInt() + 7) % 5;
        if (randomNumber < 0) {
            randomNumber = randomNumber * (-1);
        }
        LivingEntity bob = (LivingEntity) target;
        StatusEffectInstance poison = new StatusEffectInstance(StatusEffect.byRawId(19), 120, 0, false, false);
        if (target instanceof LivingEntity && randomNumber == 3 && !world.isClient) {
            bob.addStatusEffect(poison);
        }
    }

    @Override
    public boolean canSpawn(WorldView view) {
        BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
        return view.intersectsEntities(this)
                && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.getLightLevel(posentity) <= 7
                && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
                && this.world.getBlockState(blockunderentity).allowsSpawning(view, blockunderentity, Entityinit.SPI)
                && AutoConfig.getConfigHolder(configz.class).getConfig().BlueSpiderSpawn;

    }
}
