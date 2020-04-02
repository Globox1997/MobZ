package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BirchForestBiome;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;

@Mixin(BirchForestBiome.class)
public class birchglo extends Biome {

	protected birchglo(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.TANK, Configinit.CONFIGZ.TankSpawnRate, 1, 1));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.FAST, Configinit.CONFIGZ.SpeedyZombieSpawnRate, 2, 3));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.SPI, Configinit.CONFIGZ.BlueSpiderSpawnRate, 1, 3));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.SKELI2, Configinit.CONFIGZ.OvergrownSkeletonSpawnRate, 1, 3));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.MAGEENTITY, Configinit.CONFIGZ.SpiderMageSpawnRate, 1, 1));
		this.addSpawn(EntityCategory.AMBIENT,
				new Biome.SpawnEntry(Entityinit.BOAR3, Configinit.CONFIGZ.DirtyBoarSpawnRate, 1, 3));
		this.addSpawn(EntityCategory.AMBIENT,
				new Biome.SpawnEntry(Entityinit.BROWNBEAR, Configinit.CONFIGZ.BrownBearSpawnRate, 1, 2));
		this.addSpawn(EntityCategory.AMBIENT,
				new Biome.SpawnEntry(Entityinit.BLACKBEAR, Configinit.CONFIGZ.BlackBearSpawnRate, 1, 2));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.KNIGHT4ENTITY, Configinit.CONFIGZ.FioraSpawnRate, 1, 1));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.SKELI4, Configinit.CONFIGZ.LostSkeletonSpawnRate, 1, 4));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.TSPIDER, Configinit.CONFIGZ.TinySpiderSpawnRate, 1, 1));
	}

}