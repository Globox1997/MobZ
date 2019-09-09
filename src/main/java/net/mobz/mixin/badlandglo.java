package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.BadlandsBiome;
import net.minecraft.world.biome.Biome;
import net.mobz.glomod;

@Mixin(BadlandsBiome.class)
public class badlandglo extends Biome {

    protected badlandglo(Settings settings) {
        super(settings);
    }

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.TANK, 15, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.FAST, 15, 2, 3));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.ARMORED, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.BOSS, 3, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.SPI, 15, 1, 2));
}
}