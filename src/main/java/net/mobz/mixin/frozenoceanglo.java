package net.mobz.mixin;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.FrozenOceanBiome;
import net.mobz.glomod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
@Mixin(FrozenOceanBiome.class)
public class frozenoceanglo extends Biome {
	protected frozenoceanglo(Settings settings) {
		super(settings);
	}
	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.CREEP, 10, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.ICEGOLEM, 3, 1, 1));
	}
}