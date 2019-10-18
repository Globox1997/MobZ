package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SnowyMountainsBiome;
import net.mobz.glomod;

@Mixin(SnowyMountainsBiome.class)
public class snowyglo extends Biome {
	protected snowyglo(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.CREEP, 10, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.ARCHER2ENTITY, 10, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.FROSTENTITY, 10, 1, 2));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(glomod.BOAR3, 5, 2, 4));
	}
}