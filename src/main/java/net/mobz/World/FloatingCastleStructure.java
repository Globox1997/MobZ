// package net.mobz.World;

// import net.minecraft.structure.StructureManager;
// import net.minecraft.structure.VillageStructureStart;
// import net.minecraft.util.math.BlockBox;
// import net.minecraft.util.math.BlockPos;
// import net.minecraft.world.biome.Biome;
// import net.minecraft.world.gen.chunk.ChunkGenerator;
// import net.minecraft.world.gen.feature.DefaultFeatureConfig;
// import net.minecraft.world.gen.feature.StructureFeature;

// public class FloatingCastleStructure extends StructureFeature<DefaultFeatureConfig> {
//   public FloatingCastleStructure() {
//     super(DefaultFeatureConfig.CODEC);
//   }

//   @Override
//   public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
//     return FloatingCastleStructure.Start::new;
//   }

//   public static class Start extends VillageStructureStart<DefaultFeatureConfig> {

//     public Start(StructureFeature<DefaultFeatureConfig> feature, int chunkX, int chunkZ, BlockBox box, int references,
//         long seed) {
//       super(feature, chunkX, chunkZ, box, references, seed);
//     }

//     @Override
//     public void init(ChunkGenerator chunkGenerator, StructureManager structureManager, int x, int z, Biome biome,
//         DefaultFeatureConfig config) {
//       FloatingCastleGenerator.addPieces(chunkGenerator, structureManager, new BlockPos(x << 4, 60, z << 4), children,
//           random);
//       this.setBoundingBoxFromChildren();
//     }
//   }
// }