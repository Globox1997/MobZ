package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.EndIslandsSmallBiome;
import net.minecraft.world.biome.Biome;
import net.mobz.glomod;

@Mixin(EndIslandsSmallBiome.class)
public class endislandsglo extends Biome {

    protected endislandsglo(Settings settings) {
        super(settings);
    }

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.ENDER, 20, 1, 3));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.ENDERZOMBIE, 20, 1, 2));
}
}