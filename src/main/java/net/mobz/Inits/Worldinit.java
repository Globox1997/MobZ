// package net.mobz.Inits;

// import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
// import net.minecraft.structure.StructurePieceType;
// import net.minecraft.util.Identifier;
// import net.minecraft.util.registry.Registry;
// import net.minecraft.world.biome.Biome;
// import net.minecraft.world.biome.Biomes;
// //import net.minecraft.world.biome.Biomes;
// import net.minecraft.world.gen.GenerationStep;
// import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
// import net.minecraft.world.gen.decorator.Decorator;
// import net.minecraft.world.gen.feature.*;
// import net.mobz.World.FloatingCastleGenerator;
// import net.mobz.World.FloatingCastleStructure;

// public class Worldinit {

//         // public static final ConfiguredStructureFeature<DefaultFeatureConfig, ?
//         // extends StructureFeature<DefaultFeatureConfig>> THE_CASTLE_IN_THE_SKY =
//         // register(
//         // "the_castle_in_the_sky", new FloatingCastleStructure(), 123474938, false);
//         // public static final StructurePieceType THE_CASTLE_IN_THE_SKY_PIECE =
//         // Registry.register(Registry.STRUCTURE_PIECE,
//         // new Identifier("mobz:the_castle_in_the_sky_piece"),
//         // FloatingCastleGenerator.Piece::new);

//         // public static final
//         // StructureFeature<DefaultFeatureConfig>THE_CASTLE_IN_THE_SKY =
//         // Registry.register(
//         // Registry.STRUCTURE_FEATURE, new Identifier("mobz", "floatingcastlefeature"),
//         // PRANK);
//         // public static final StructurePieceType THE_CASTLE_IN_THE_SKY_PIECE =
//         // Registry.register(Registry.STRUCTURE_PIECE,
//         // new Identifier("mobz:the_castle_in_the_sky_piece"),
//         // FloatingCastleGenerator.Piece::new);

//         // //// public static StructureFeature<DefaultFeatureConfig> FLOATING_CASTLE =
//         // //// Registry.register(
//         // // Registry.STRUCTURE_FEATURE, "floatingcastlefeature",
//         // // new FloatingCastleFeature(DefaultFeatureConfig::deserialize));
//         // // public static StructurePieceType FLOATING_CASTLE_PIECES =
//         // // Registry.register(Registry.STRUCTURE_PIECE,
//         // // "floatingcastle_pieces", FloatingCastleGenerator.Piece::new);
//         // public static final StructureFeature<DefaultFeatureConfig> FLOATING_CASTLE =
//         // Registry.register(Registry.FEATURE,
//         // new Identifier("mobz:floatingcastle"),
//         // new FloatingCastleStructure(DefaultFeatureConfig::deserialize));
//         // public static final StructureFeature<DefaultFeatureConfig>
//         // FLOATING_CASTLE_FEATURE = Registry.register(
//         // Registry.STRUCTURE_FEATURE, new Identifier("mobz", "floatingcastlefeature"),
//         // FLOATING_CASTLE);
//         // public static final StructurePieceType FLOATING_CASTLE_PIECES =
//         // Registry.register(Registry.STRUCTURE_PIECE,
//         // new Identifier("mobz:floatingcastlefeaturepiece"),
//         // FloatingCastleGenerator.Piece::new);

//         public static void init() {
//                 // Feature.STRUCTURES.put("mobz:floatingcastlefeature",
//                 // FLOATING_CASTLE_FEATURE);

//                 Registry.BIOME.forEach(biome -> biome.addStructureFeature(
//                                 Worldinit.FLOATING_CASTLE_FEATURE.configure(FeatureConfig.DEFAULT)));

//                 // Registry.BIOME.forEach(biome -> biome.addStructureFeature(
//                 // FLOATING_CASTLE_FEATURE));

//                 Registry.BIOME.forEach(Worldinit::handleBiome);
//                 RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> handleBiome(biome));

//                 // Biomes.OCEAN.addFeature(GenerationStep.Feature.SURFACE_STRUCTURES,
//                 // Worldinit.FLOATING_CASTLE_FEATURE.configure(FeatureConfig.DEFAULT)
//                 // .createDecoratedFeature(Decorator.CHANCE_PASSTHROUGH.configure(new
//                 // ChanceDecoratorConfig(10))));
//                 // Registry.BIOME.forEach(biome ->
//                 // biome.addFeature(GenerationStep.Feature.SURFACE_STRUCTURES,
//                 // Worldinit.FLOATING_CASTLE_FEATURE.configure(FeatureConfig.DEFAULT)
//                 // .createDecoratedFeature(Decorator.CHANCE_PASSTHROUGH
//                 // .configure(new ChanceDecoratorConfig(6)))));

//                 // Registry.BIOME.forEach(biome ->
//                 // biome.addStructureFeature(FLOATING_CASTLE_FEATURE));
//         }

//         //// public static StructureFeature<DefaultFeatureConfig> FLOATING_CASTLE =
//         //// Registry.register(
//         // Registry.STRUCTURE_FEATURE, "floatingcastlefeature",
//         // new FloatingCastleFeature(DefaultFeatureConfig::deserialize));
//         // public static StructurePieceType FLOATING_CASTLE_PIECES =
//         // Registry.register(Registry.STRUCTURE_PIECE,
//         // "floatingcastle_pieces", FloatingCastleGenerator.Piece::new);

//         // public static final StructureFeature<DefaultFeatureConfig> FLOATING_CASTLE =
//         // Registry.register(Registry.FEATURE,
//         // new Identifier("mobz:floatingcastle"),
//         // new FloatingCastleFeature(DefaultFeatureConfig::deserialize));

//         public static final StructureFeature<DefaultFeatureConfig> FLOATING_CASTLE_FEATURE = Registry.register(
//                         Registry.STRUCTURE_FEATURE, new Identifier("mobz", "floatingcastlefeature"),
//                         new FloatingCastleStructure());

//         // public static final ConfiguredStructureFeature<DefaultFeatureConfig, ?
//         // extends StructureFeature<DefaultFeatureConfig>> THE_CASTLE_IN_THE_SKY =
//         // register(
//         // "the_castle_in_the_sky", new FloatingCastleStructure(), 123474938, false);
//         public static final StructurePieceType THE_CASTLE_IN_THE_SKY_PIECE = Registry.register(Registry.STRUCTURE_PIECE,
//                         ("mobz:floatingcastlefeaturepiece"), FloatingCastleGenerator.Piece::new);

//         public static void handleBiome(Biome biome) {
//                 Biome.Category category = biome.getCategory();
//                 if (category != Biome.Category.NETHER && category != Biome.Category.THEEND) {
//                         biome.addStructureFeature(FLOATING_CASTLE_FEATURE);
//                 }
//                 // Registry.BIOME.forEach(biome ->
//                 biome.addFeature(GenerationStep.Feature.SURFACE_STRUCTURES, Worldinit.FLOATING_CASTLE_FEATURE
//                                 .configure(FeatureConfig.DEFAULT).createDecoratedFeature(
//                                                 Decorator.CHANCE_PASSTHROUGH.configure(new ChanceDecoratorConfig(6))));
//                 this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION,
//                                 Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG)
//                                                 .createDecoratedFeature(Decorator.CHANCE_RANGE.configure(
//                                                                 new ChanceRangeDecoratorConfig(0.5F, 0, 0, 128))));

//         }

// }