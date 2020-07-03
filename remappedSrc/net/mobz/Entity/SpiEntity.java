package net.mobz.Entity;

import java.util.Random;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
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

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                .setBaseValue(Configinit.CONFIGZ.BlueSpiderLife * Configinit.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.31D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
                .setBaseValue(Configinit.CONFIGZ.BlueSpiderAttack * Configinit.CONFIGZ.DamageMultiplicatorMob);
    }

    @Override
    protected void dealDamage(LivingEntity attacker, Entity target) {
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
                && this.world.getBlockState(blockunderentity).getBlock()
                        .allowsSpawning(world.getBlockState(blockunderentity), view, blockunderentity, Entityinit.SPI)
                && AutoConfig.getConfigHolder(configz.class).getConfig().BlueSpiderSpawn;

    }
}
