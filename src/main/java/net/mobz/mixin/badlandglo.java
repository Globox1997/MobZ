package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.BadlandsBiome;
import net.minecraft.world.biome.Biome;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;

@Mixin(BadlandsBiome.class)
public class badlandglo extends Biome {

	protected badlandglo(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.TANK, Configinit.CONFIGZ.TankSpawnRate, 1, 2));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.FAST, Configinit.CONFIGZ.SpeedyZombieSpawnRate, 2, 3));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.ARMORED, Configinit.CONFIGZ.ArmoredZombieSpawnRate, 1, 2));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.BOSS, Configinit.CONFIGZ.BossZombieSpawnRate, 1, 2));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.SPI, Configinit.CONFIGZ.BlueSpiderSpawnRate, 1, 3));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.SKELI1, Configinit.CONFIGZ.BossSkeletonSpawnRate, 1, 1));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.KNIGHT2ENTITY, Configinit.CONFIGZ.WarriorSpawnRate, 1, 2));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.ARCHERENTITY, Configinit.CONFIGZ.BowmanSpawnRate, 1, 1));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.MAGEENTITY, Configinit.CONFIGZ.SpiderMageSpawnRate, 1, 1));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.MAGE2ENTITY, Configinit.CONFIGZ.ZombieMageSpawnRate, 1, 1));
	}
}