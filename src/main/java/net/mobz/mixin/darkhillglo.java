package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DarkForestHillsBiome;
import net.mobz.glomod;

@Mixin(DarkForestHillsBiome.class)
public class darkhillglo extends Biome {

    protected darkhillglo(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("RETURN"), method = "<init>()V")
    private void init(CallbackInfo info) {
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.TANK, 15, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.FAST, 15, 2, 3));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.ARMORED, 10, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.SKELI2, 15, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.KNIGHT2ENTITY, 15, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.FULLIRONENTITY, 5, 1, 1));
        this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(glomod.BOAR3, 10, 2, 4));
        this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(glomod.BROWNBEAR, 10, 1, 2));
        this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(glomod.BLACKBEAR, 10, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.KNIGHT5ENTITY, 5, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.TSPIDER, 8, 1, 1));
    }

}