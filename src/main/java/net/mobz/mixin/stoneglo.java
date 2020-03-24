package net.mobz.mixin;

import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.StoneShoreBiome;
import net.mobz.Inits.Entityinit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(StoneShoreBiome.class)
public class stoneglo extends Biome {
	protected stoneglo(Settings settings) {
		super(settings);
	}
	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.SPO, 10, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.FAST, 20, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.SKELI1, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.KNIGHTENTITY, 20, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.DWARFENTITY, 4, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.TSPIDER, 8, 1, 1));
	}
}