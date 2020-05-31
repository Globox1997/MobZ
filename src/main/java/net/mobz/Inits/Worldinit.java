package net.mobz.Inits;

import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.registry.Registry;
//import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import net.mobz.World.FloatingCastleFeature;
import net.mobz.World.FloatingCastleGenerator;

public class Worldinit {

        public static StructureFeature<DefaultFeatureConfig> FLOATING_CASTLE = Registry.register(
                        Registry.STRUCTURE_FEATURE, "floatingcastlefeature",
                        new FloatingCastleFeature(DefaultFeatureConfig::deserialize));
        public static StructurePieceType FLOATING_CASTLE_PIECES = Registry.register(Registry.STRUCTURE_PIECE,
                        "floatingcastle_pieces", FloatingCastleGenerator.Piece::new);

        public static void init() {
                Feature.STRUCTURES.put("mobz:floatingcastlefeature", FLOATING_CASTLE);
                Registry.BIOME.forEach(biome -> biome
                                .addStructureFeature(Worldinit.FLOATING_CASTLE.configure(FeatureConfig.DEFAULT)));
                // Biomes.OCEAN.addFeature(GenerationStep.Feature.SURFACE_STRUCTURES,
                // Worldinit.FLOATING_CASTLE.configure(FeatureConfig.DEFAULT)
                // .createDecoratedFeature(Decorator.CHANCE_PASSTHROUGH.configure(new
                // ChanceDecoratorConfig(10))));
                Registry.BIOME.forEach(biome -> biome.addFeature(GenerationStep.Feature.SURFACE_STRUCTURES,
                                Worldinit.FLOATING_CASTLE.configure(FeatureConfig.DEFAULT).createDecoratedFeature(
                                                Decorator.CHANCE_PASSTHROUGH.configure(new ChanceDecoratorConfig(8)))));
        }

}