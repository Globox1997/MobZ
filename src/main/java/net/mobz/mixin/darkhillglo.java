package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DarkForestHillsBiome;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;

@Mixin(DarkForestHillsBiome.class)
public class darkhillglo extends Biome {

        protected darkhillglo(Settings settings) {
                super(settings);
        }

        @Inject(at = @At("RETURN"), method = "<init>()V")
        private void init(CallbackInfo info) {
                this.addSpawn(EntityCategory.MONSTER,
                                new Biome.SpawnEntry(Entityinit.TANK, Configinit.CONFIGZ.TankSpawnRate, 1, 2));
                this.addSpawn(EntityCategory.MONSTER,
                                new Biome.SpawnEntry(Entityinit.FAST, Configinit.CONFIGZ.SpeedyZombieSpawnRate, 2, 4));
                this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.ARMORED,
                                Configinit.CONFIGZ.ArmoredZombieSpawnRate, 1, 1));
                this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.SKELI2,
                                Configinit.CONFIGZ.OvergrownSkeletonSpawnRate, 1, 2));
                this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.KNIGHT2ENTITY,
                                Configinit.CONFIGZ.WarriorSpawnRate, 1, 1));
                this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.ILLUSIONER,
                                Configinit.CONFIGZ.IllusionerSpawnRate, 1, 1));
                this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.KNIGHT5ENTITY,
                                Configinit.CONFIGZ.LordofDarknessSpawnRate, 1, 1));
                this.addSpawn(EntityCategory.MONSTER,
                                new Biome.SpawnEntry(Entityinit.TSPIDER, Configinit.CONFIGZ.TinySpiderSpawnRate, 1, 1));

                this.addSpawn(EntityCategory.MONSTER,
                                new Biome.SpawnEntry(Entityinit.BOAR3, Configinit.CONFIGZ.WildBoarSpawnRate, 1, 3));
                this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.BROWNBEAR,
                                Configinit.CONFIGZ.BrownBearSpawnRate, 1, 2));
                this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.BLACKBEAR,
                                Configinit.CONFIGZ.BlackBearSpawnRate, 1, 2));
        }

}