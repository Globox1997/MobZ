package net.mobz.mixin;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.WoodedMountainsBiome;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WoodedMountainsBiome.class)
public class woodedmountainglo extends Biome {
    protected woodedmountainglo(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("RETURN"), method = "<init>()V")
    private void init(CallbackInfo info) {
        this.addSpawn(EntityCategory.MONSTER,
                new Biome.SpawnEntry(Entityinit.TANK, Configinit.CONFIGZ.TankSpawnRate, 1, 2));
        this.addSpawn(EntityCategory.MONSTER,
                new Biome.SpawnEntry(Entityinit.FAST, Configinit.CONFIGZ.SpeedyZombieSpawnRate, 2, 3));
        this.addSpawn(EntityCategory.MONSTER,
                new Biome.SpawnEntry(Entityinit.ARMORED, Configinit.CONFIGZ.ArmoredZombieSpawnRate, 1, 1));
        this.addSpawn(EntityCategory.MONSTER,
                new Biome.SpawnEntry(Entityinit.SPO, Configinit.CONFIGZ.PurpleSpiderSpawnRate, 1, 2));
        this.addSpawn(EntityCategory.MONSTER,
                new Biome.SpawnEntry(Entityinit.SKELI2, Configinit.CONFIGZ.OvergrownSkeletonSpawnRate, 1, 2));
        this.addSpawn(EntityCategory.MONSTER,
                new Biome.SpawnEntry(Entityinit.KNIGHT2ENTITY, Configinit.CONFIGZ.WarriorSpawnRate, 1, 1));
        this.addSpawn(EntityCategory.MONSTER,
                new Biome.SpawnEntry(Entityinit.MAGEENTITY, Configinit.CONFIGZ.SpiderMageSpawnRate, 1, 1));
        this.addSpawn(EntityCategory.MONSTER,
                new Biome.SpawnEntry(Entityinit.MAGE2ENTITY, Configinit.CONFIGZ.ZombieMageSpawnRate, 1, 1));
        this.addSpawn(EntityCategory.MONSTER,
                new Biome.SpawnEntry(Entityinit.FULLIRONENTITY, Configinit.CONFIGZ.SteveSpawnRate, 1, 1));
    }
}