package net.mobz.mixin;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GiantSpruceTaigaBiome;
import net.mobz.Inits.Entityinit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GiantSpruceTaigaBiome.class)
public class giantglo extends Biome {

    protected giantglo(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("RETURN"), method = "<init>()V")
    private void init(CallbackInfo info) {
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.TANK, 20, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.FAST, 15, 2, 3));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.ARMORED, 5, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.SPI, 15, 1, 3));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.SKELI2, 15, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.KNIGHT2ENTITY, 15, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.FULLIRONENTITY, 5, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.KNIGHT3ENTITY, 5, 1, 1));
    }

}