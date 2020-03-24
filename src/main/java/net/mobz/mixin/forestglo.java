package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.ForestBiome;
import net.mobz.Inits.Entityinit;

@Mixin(ForestBiome.class)
public class forestglo extends Biome {

	protected forestglo(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.TANK, 15, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.FAST, 15, 2, 3));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.ARMORED, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.SPO, 10, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.SKELI2, 15, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.KNIGHT2ENTITY, 10, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.MAGEENTITY, 10, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.MAGE2ENTITY, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.STONEGOLEM, 10, 1, 1));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(Entityinit.BOAR, 10, 2, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(Entityinit.BOAR3, 5, 2, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(Entityinit.BROWNBEAR, 10, 1, 2));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(Entityinit.BLACKBEAR, 10, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.SKELI4, 15, 1, 4));
	}

}