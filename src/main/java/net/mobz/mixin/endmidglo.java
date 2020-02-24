package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.EndMidlandsBiome;
import net.minecraft.world.biome.Biome;
import net.mobz.glomod;

@Mixin(EndMidlandsBiome.class)
public class endmidglo extends Biome {

    protected endmidglo(Settings settings) {
        super(settings);
    }

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.ENDER, 10, 1, 3));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.ENDERZOMBIE, 10, 1, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.KNIGHT3ENTITY, 2, 1, 1));
}
}