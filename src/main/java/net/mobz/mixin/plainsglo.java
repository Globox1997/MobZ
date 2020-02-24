package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.PlainsBiome;
import net.mobz.glomod;

@Mixin(PlainsBiome.class)
public class plainsglo extends Biome {

	protected plainsglo(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.TANK, 20, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.FAST, 15, 2, 3));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.ARMORED, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.SPI, 15, 1, 3));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.SKELI2, 15, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.KNIGHT2ENTITY, 10, 1, 1));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(glomod.BOAR, 5, 2, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(glomod.BOAR3, 2, 2, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(glomod.BOAR2, 2, 2, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(glomod.BROWNBEAR, 2, 1, 2));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(glomod.BLACKBEAR, 2, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.KNIGHT3ENTITY, 1, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.SLIMO, 1, 1, 2));

	}

}