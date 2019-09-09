package net.mobz.mixin;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.EndBiome;
import net.mobz.glomod;
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
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.ENDER, 20, 1, 3));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.ENDERZOMBIE, 20, 1, 2));

	}
	
}