package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.EndHighlandsBiome;
import net.mobz.Inits.Entityinit;
import net.minecraft.world.biome.Biome;

@Mixin(EndHighlandsBiome.class)
public class endhighglo extends Biome {

    protected endhighglo(Settings settings) {
        super(settings);
    }

	@Inject(at = @At("RETURN"), method = "<init>()V")
	private void init(CallbackInfo info) {
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.ENDER, 15, 1, 3));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.ENDERZOMBIE, 15, 1, 3));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.KNIGHT3ENTITY, 2, 1, 1));
}
}