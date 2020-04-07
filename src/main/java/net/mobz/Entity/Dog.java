package net.mobz.Entity;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.Soundinit;

public class Dog extends WolfEntity {

    public Dog(EntityType<? extends WolfEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                .setBaseValue(Configinit.CONFIGZ.NetherWolfLife * Configinit.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
                .setBaseValue(Configinit.CONFIGZ.NetherWolfAttack * Configinit.CONFIGZ.DamageMultiplicatorMob);
    }

    public boolean isBreedingItem(ItemStack itemStack_1) {
        return false;
    }

    public boolean isAngry() {
        return true;
    }

    protected SoundEvent getAmbientSound() {
        return Soundinit.WGROWLEVENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return Soundinit.WHURTEVENT;
    }

    protected SoundEvent getDeathSound() {
        return Soundinit.WDEATHEVENT;
    }

    public boolean canSpawn(WorldView view) {
        BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
        return view.intersectsEntities(this)
                && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.getLightLevel(posentity) <= 10
                && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
                && this.world.getBlockState(blockunderentity).getBlock()
                        .allowsSpawning(world.getBlockState(blockunderentity), view, blockunderentity, Entityinit.DOG)
                && AutoConfig.getConfigHolder(configz.class).getConfig().NetherWolfSpawn;

    }
}
