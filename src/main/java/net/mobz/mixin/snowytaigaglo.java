package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SnowyTaigaBiome;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;

@Mixin(SnowyTaigaBiome.class)
public class snowytaigaglo extends Biome {
    protected snowytaigaglo(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("RETURN"), method = "<init>()V")
    private void init(CallbackInfo info) {
        this.addSpawn(EntityCategory.MONSTER,
                new Biome.SpawnEntry(Entityinit.CREEP, Configinit.CONFIGZ.FrostCreeperSpawnRate, 1, 2));
        this.addSpawn(EntityCategory.MONSTER,
                new Biome.SpawnEntry(Entityinit.ARCHERENTITY, Configinit.CONFIGZ.BowmanSpawnRate, 1, 1));
        this.addSpawn(EntityCategory.MONSTER,
                new Biome.SpawnEntry(Entityinit.FROSTENTITY, Configinit.CONFIGZ.FrostBlazeSpawnRate, 1, 2));
    }
}