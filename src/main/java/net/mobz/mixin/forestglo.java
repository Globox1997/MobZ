package net.mobz.mixin;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.ForestBiome;
import net.mobz.glomod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ForestBiome.class)
public class forestglo extends Biome {
	
	protected forestglo(Settings settings) {
		super(settings);
	}
	
	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.TANK, 15, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.FAST, 15, 2, 3));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.ARMORED, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.SPO, 10, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.SKELI2, 15, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.KNIGHT2ENTITY, 10, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.MAGEENTITY, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.MAGE2ENTITY, 1, 1, 1));
	}
	
}