package net.mobz.Entity;

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
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Soundinit;

public class Dog extends WolfEntity {

    public Dog(EntityType<? extends WolfEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(20.0D * Configinit.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributes().register(EntityAttributes.ATTACK_DAMAGE).setBaseValue(2.0D * Configinit.CONFIGZ.DamageMultiplicatorMob);
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

    public boolean canSpawn(WorldView viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos lighto = new BlockPos(this.getX(), this.getY(), this.getZ());
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
              && !viewableWorld_1.isAir(entityPos)
              && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
              && this.world.getLightLevel(lighto) <= 7
              && !this.world.isWater(entityPos)
              && Configinit.CONFIGZ.NetherWolfSpawn == true;
  
     }
}
