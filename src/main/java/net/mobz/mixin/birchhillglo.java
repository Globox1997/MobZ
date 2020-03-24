package net.mobz.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BirchForestHillsBiome;
import net.mobz.Inits.Entityinit;

@Mixin(BirchForestHillsBiome.class)
public class birchhillglo extends Biome {

    protected birchhillglo(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("RETURN"), method = "<init>()V")
    private void init(CallbackInfo info) {
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.TANK, 15, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.FAST, 15, 2, 3));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.SPI, 15, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.SKELI2, 15, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.MAGEENTITY, 5, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.FULLIRONENTITY, 5, 1, 1));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.ILLUSIONER, 5, 1, 1));
        this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(Entityinit.BOAR2, 5, 2, 4));
        this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(Entityinit.BROWNBEAR, 10, 1, 2));
        this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(Entityinit.BLACKBEAR, 10, 1, 2));
        this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(Entityinit.KNIGHT4ENTITY, 5, 1, 1));

    }

}