package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.JungleBiome;
import net.mobz.Inits.Entityinit;

@Mixin(JungleBiome.class)
public class jungleglo extends Biome {

	protected jungleglo(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.FAST, 20, 2, 2));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.CRIP, 10, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.SKELI2, 15, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.KNIGHT2ENTITY, 15, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.STONEGOLEM, 10, 1, 1));
		this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(Entityinit.BOAR, 1, 2, 4));
		this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(Entityinit.BOAR3, 1, 2, 4));
		this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(Entityinit.BLACKBEAR, 1, 1, 2));
	}

}