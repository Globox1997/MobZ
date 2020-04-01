package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.WoodedBadlandsPlateauBiome;
import net.mobz.Inits.Entityinit;
import net.minecraft.world.biome.Biome;

@Mixin(WoodedBadlandsPlateauBiome.class)
public class woodedbadlandglo extends Biome {

    protected woodedbadlandglo(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("RETURN"), method = "<init>()V")
    private void init(CallbackInfo info) {
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.TANK, 20, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.FAST, 20, 2, 3));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.ARMORED, 10, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.BOSS, 6, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.SPI, 20, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.SKELI1, 10, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.KNIGHT2ENTITY, 15, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.ARCHERENTITY, 15, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.FULLIRONENTITY, 5, 1, 1));
    }
}