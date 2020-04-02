package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.EndHighlandsBiome;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.minecraft.world.biome.Biome;

@Mixin(EndHighlandsBiome.class)
public class endhighglo extends Biome {

	protected endhighglo(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.ENDER, Configinit.CONFIGZ.EndermanSpawnRate, 1, 3));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.ENDERZOMBIE, Configinit.CONFIGZ.EnderzombieSpawnRate, 1, 3));
		this.addSpawn(EntityCategory.MONSTER,
				new Biome.SpawnEntry(Entityinit.KNIGHT3ENTITY, Configinit.CONFIGZ.EnderKnightSpawnRate, 1, 1));
	}
}