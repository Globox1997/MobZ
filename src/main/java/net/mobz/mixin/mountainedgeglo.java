package net.mobz.mixin;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MountainEdgeBiome;
import net.mobz.Inits.Entityinit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MountainEdgeBiome.class)
public class mountainedgeglo extends Biome {

    protected mountainedgeglo(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("RETURN"), method = "<init>()V")
    private void init(CallbackInfo info) {
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.TANK, 15, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.FAST, 15, 2, 3));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.ARMORED, 5, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.SPI, 10, 1, 3));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.KNIGHTENTITY, 10, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.STONEGOLEM, 10, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.DWARFENTITY, 4, 1, 1));
    }

}