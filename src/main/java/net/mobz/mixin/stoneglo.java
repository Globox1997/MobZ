package net.mobz.mixin;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.StoneShoreBiome;
import net.mobz.glomod;
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
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.SPO, 10, 1, 2));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.FAST, 20, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.SKELI1, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.KNIGHTENTITY, 20, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.DWARFENTITY, 4, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(glomod.TSPIDER, 8, 1, 1));
	}
}