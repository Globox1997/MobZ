package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BirchForestHillsBiome;
import net.mobz.glomod;

@Mixin(BirchForestHillsBiome.class)
public class birchhillglo extends Biome {

    protected birchhillglo(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("RETURN"), method = "<init>()V")
    private void init(CallbackInfo info) {
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.TANK, 15, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.FAST, 15, 2, 3));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.SPI, 15, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.SKELI2, 15, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.MAGEENTITY, 5, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.FULLIRONENTITY, 5, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.ILLUSIONER, 5, 1, 1));
        this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(glomod.BOAR2, 5, 2, 4));
        this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(glomod.BROWNBEAR, 10, 1, 2));
        this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(glomod.BLACKBEAR, 10, 1, 2));

    }

}