package net.mobz.mixin;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.TallBirchForestBiome;
import net.mobz.Inits.Configinit;
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
        this.addSpawn(EntityCategory.MONSTER,
                new Biome.SpawnEntry(Entityinit.TANK, Configinit.CONFIGZ.TankSpawnRate, 1, 1));
        this.addSpawn(EntityCategory.MONSTER,
                new Biome.SpawnEntry(Entityinit.FAST, Configinit.CONFIGZ.SpeedyZombieSpawnRate, 2, 3));
        this.addSpawn(EntityCategory.MONSTER,
                new Biome.SpawnEntry(Entityinit.SPI, Configinit.CONFIGZ.BlueSpiderSpawnRate, 1, 2));
        this.addSpawn(EntityCategory.MONSTER,
                new Biome.SpawnEntry(Entityinit.SKELI2, Configinit.CONFIGZ.OvergrownSkeletonSpawnRate, 1, 2));
        this.addSpawn(EntityCategory.MONSTER,
                new Biome.SpawnEntry(Entityinit.MAGEENTITY, Configinit.CONFIGZ.SpiderMageSpawnRate, 1, 1));

    }

}