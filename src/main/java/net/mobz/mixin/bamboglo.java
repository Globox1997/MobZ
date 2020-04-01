package net.mobz.mixin;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.mobz.Inits.Entityinit;
import net.minecraft.world.biome.BambooJungleBiome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BambooJungleBiome.class)
public class bamboglo extends Biome {

	protected bamboglo(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.CRIP, 20, 1, 3));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.ARCHER2ENTITY, 12, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.ARCHERENTITY, 12, 1, 1));
	}

}