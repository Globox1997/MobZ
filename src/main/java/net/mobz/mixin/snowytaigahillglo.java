package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SnowyTaigaHillsBiome;
import net.mobz.Inits.Entityinit;

@Mixin(SnowyTaigaHillsBiome.class)
public class snowytaigahillglo extends Biome {
	protected snowytaigahillglo(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.CREEP, 10, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.ARCHER2ENTITY, 10, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.FROSTENTITY, 10, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new Biome.SpawnEntry(Entityinit.FULLIRONENTITY, 5, 1, 1));
		this.addSpawn(EntityCategory.AMBIENT, new Biome.SpawnEntry(Entityinit.BOAR3, 1, 2, 4));
	}
}