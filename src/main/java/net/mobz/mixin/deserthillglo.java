package net.mobz.mixin;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DesertHillsBiome;
import net.mobz.Inits.Entityinit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DesertHillsBiome.class)
public class deserthillglo extends Biome {

	protected deserthillglo(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.TANK, 15, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.FAST, 15, 2, 3));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.ARMORED, 10, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.SPI, 15, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.ARCHER2ENTITY, 10, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.MAGE2ENTITY, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.SKELI4, 15, 1, 4));
	}

}