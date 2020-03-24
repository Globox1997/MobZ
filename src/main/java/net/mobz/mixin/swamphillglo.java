package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SwampHillsBiome;
import net.mobz.Inits.Entityinit;

@Mixin(SwampHillsBiome.class)
public class swamphillglo extends Biome {
    protected swamphillglo(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("RETURN"), method = "<init>()V")
    private void init(CallbackInfo info) {
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.CREEP, 10, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.SPO, 10, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.FAST, 10, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.SKELI2, 15, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.ARCHER2ENTITY, 10, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.FULLIRONENTITY, 5, 1, 1));
        this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(Entityinit.BOAR3, 5, 2, 4));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.KNIGHT4ENTITY, 5, 1, 1));
    }
}