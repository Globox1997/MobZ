package net.mobz.mixin;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.NetherBiome;
import net.mobz.Inits.Entityinit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetherBiome.class)
public class netherglo extends Biome {
	protected netherglo(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.PIG, 12, 2, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.LAVAGOLEM, 6, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.SKELI3, 10, 1, 3));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.WITHENTITY, 5, 1, 3));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.DOG, 1, 1, 3));
	}
}