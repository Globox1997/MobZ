package net.mobz.mixin;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BeachBiome;
import net.mobz.glomod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeachBiome.class)
public class beachglo extends Biome {
	
	protected beachglo(Settings settings) {
		super(settings);
	}
	
	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.FAST, 15, 2, 3));
	}
	
}