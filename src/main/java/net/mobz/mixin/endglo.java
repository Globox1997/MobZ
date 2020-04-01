package net.mobz.mixin;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.EndBiome;
import net.mobz.Inits.Entityinit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EndBiome.class)
public class endglo extends Biome {

	protected endglo(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.ENDER, 15, 1, 3));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.ENDERZOMBIE, 10, 1, 4));

	}

}