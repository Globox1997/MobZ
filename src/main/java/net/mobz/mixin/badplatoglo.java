package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.BadlandsPlateauBiome;
import net.minecraft.world.biome.Biome;
import net.mobz.glomod;

@Mixin(BadlandsPlateauBiome.class)
public class badplatoglo extends Biome {

    protected badplatoglo(Settings settings) {
        super(settings);
    }

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.TANK, 20, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.FAST, 20, 2, 3));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.ARMORED, 10, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.BOSS, 6, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.SPI, 20, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.SKELI1, 10, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.KNIGHT2ENTITY, 15, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.ARCHERENTITY, 15, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.ILLUSIONER, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.KNIGHT3ENTITY, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.WITHENDER, 1, 1, 1));
}
}