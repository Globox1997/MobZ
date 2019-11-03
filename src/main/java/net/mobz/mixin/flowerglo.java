package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.FlowerForestBiome;
import net.mobz.glomod;

@Mixin(FlowerForestBiome.class)
public class flowerglo extends Biome {

	protected flowerglo(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.TANK, 15, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.FAST, 15, 2, 3));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.SPO, 10, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.SKELI2, 15, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.ARCHER2ENTITY, 15, 1, 1));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(glomod.BOAR, 10, 2, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(glomod.BOAR3, 5, 2, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(glomod.BROWNBEAR, 10, 1, 2));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(glomod.GCHICKEN, 2, 1, 2));
	}

}