package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SwampHillsBiome;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;

@Mixin(SwampHillsBiome.class)
public class swamphillglo extends Biome {
        protected swamphillglo(Settings settings) {
                super(settings);
        }

        @Inject(at = @At("RETURN"), method = "<init>()V")
        private void init(CallbackInfo info) {
                this.addSpawn(EntityCategory.MONSTER,
                                new Biome.SpawnEntry(Entityinit.CREEP, Configinit.CONFIGZ.FrostCreeperSpawnRate, 1, 1));
                this.addSpawn(EntityCategory.MONSTER,
                                new Biome.SpawnEntry(Entityinit.SPO, Configinit.CONFIGZ.PurpleSpiderSpawnRate, 1, 2));
                this.addSpawn(EntityCategory.MONSTER,
                                new Biome.SpawnEntry(Entityinit.FAST, Configinit.CONFIGZ.SpeedyZombieSpawnRate, 1, 1));
                this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.SKELI2,
                                Configinit.CONFIGZ.OvergrownSkeletonSpawnRate, 1, 2));
                this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.ARCHER2ENTITY,
                                Configinit.CONFIGZ.ArcherSpawnRate, 1, 1));
                this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.FULLIRONENTITY,
                                Configinit.CONFIGZ.SteveSpawnRate, 1, 1));
                this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.KNIGHT4ENTITY,
                                Configinit.CONFIGZ.FioraSpawnRate, 1, 1));

                this.addSpawn(EntityCategory.MONSTER,
                                new Biome.SpawnEntry(Entityinit.BOAR3, Configinit.CONFIGZ.DirtyBoarSpawnRate, 1, 2));
        }
}