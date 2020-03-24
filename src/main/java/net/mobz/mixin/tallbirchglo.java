package net.mobz.mixin;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.TallBirchForestBiome;
import net.mobz.Inits.Entityinit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TallBirchForestBiome.class)
public class tallbirchglo extends Biome {

    protected tallbirchglo(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("RETURN"), method = "<init>()V")
    private void init(CallbackInfo info) {
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.TANK, 15, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.FAST, 15, 2, 3));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.SPI, 15, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.SKELI2, 15, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.MAGEENTITY, 5, 1, 1));

    }

}