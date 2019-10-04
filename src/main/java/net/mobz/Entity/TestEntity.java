package net.mobz.Entity;

import net.mobz.glomod;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;

public class TestEntity extends ZombieEntity {

    public TestEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(60D);
        this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(3.0D);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000417232513D);
        this.getAttributeInstance(EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(20.0D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(8D);
        this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
    }

    public boolean isConvertingInWater() {
        return false;
    }

    protected boolean burnsInDaylight() {
        return false;
    }

    public boolean canSpawn(ViewableWorld viewableWorld_1, SpawnType spawnType_1) {
        BlockPos entityPos = new BlockPos(this.x, this.y - 1, this.z);
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.intersectsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && !this.world.isDaylight()
                && spawnType_1 == SpawnType.SPAWNER;

    }

    protected SoundEvent getAmbientSound() {
        return glomod.AMBIENTTANKEVENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return glomod.HURTTANKEVENT;
    }

    protected SoundEvent getDeathSound() {
        return glomod.DEATHTANKEVENT;
    }

    protected SoundEvent getStepSound() {
        return glomod.STEPTANKEVENT;
    }

    protected void initEquipment(LocalDifficulty localDifficulty_1) {
        if ((double)this.random.nextFloat() > 0.9D) {
           int int_1 = this.random.nextInt(16);
           if (int_1 < 10) {
              this.setEquippedStack(EquipmentSlot.MAINHAND, new ItemStack(Items.TRIDENT));
           } else {
              this.setEquippedStack(EquipmentSlot.MAINHAND, new ItemStack(Items.FISHING_ROD));
           }
        }
  
     }

}
