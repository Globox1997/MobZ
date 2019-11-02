package net.mobz.Entity;

import net.mobz.glomod;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.SlimeEntity;

import net.minecraft.entity.mob.DrownedEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;

public class Try extends SlimeEntity {

    public Try(EntityType<? extends SlimeEntity> entityType, World world) {
        super(entityType, world);
    }

    public boolean canSpawn(ViewableWorld viewableWorld_1) {
        int light = this.getLightmapCoordinates();
        BlockPos entityPos = new BlockPos(this.x, this.y - 1, this.z);
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.intersectsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && !this.world.isDaylight()
                && light > 7;

    }

    protected void updateDespawnCounter() {
        float float_1 = this.getBrightnessAtEyes();
        
        if (float_1 > 0.5F) {
           this.despawnCounter += 2;
        }
  
     }


}
