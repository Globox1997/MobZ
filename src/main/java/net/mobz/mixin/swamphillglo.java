package net.mobz.mixin;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SwampHillsBiome;
import net.mobz.glomod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SwampHillsBiome.class)
public class swamphillglo extends Biome {
    protected swamphillglo(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("RETURN"), method = "<init>()V")
    private void init(CallbackInfo info) {
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.CREEP, 10, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.SPO, 10, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.FAST, 10, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.SKELI2, 15, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.ARCHER2ENTITY, 10, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.FULLIRONENTITY, 5, 1, 1));
    }
}