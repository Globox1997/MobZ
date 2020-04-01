package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.FlowerForestBiome;
import net.mobz.Inits.Entityinit;

@Mixin(FlowerForestBiome.class)
public class flowerglo extends Biome {

	protected flowerglo(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.TANK, 15, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.FAST, 15, 2, 3));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.SPO, 10, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.SKELI2, 12, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.ARCHER2ENTITY, 12, 1, 1));
		this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(Entityinit.BOAR, 1, 2, 4));
		this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(Entityinit.BOAR3, 1, 2, 4));
		this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(Entityinit.BROWNBEAR, 1, 1, 2));
		this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(Entityinit.GCHICKEN, 1, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.SLIMO, 3, 1, 2));
	}

}