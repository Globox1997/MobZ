// package net.mobz.World;

// import com.mojang.datafixers.Dynamic;
// import net.minecraft.structure.StructureManager;
// import net.minecraft.structure.StructureStart;
// import net.minecraft.structure.pool.StructurePoolBasedGenerator;
// import net.minecraft.util.BlockRotation;
// import net.minecraft.util.Identifier;
// import net.minecraft.util.math.BlockBox;
// import net.minecraft.util.math.BlockPos;
// import net.minecraft.util.math.ChunkPos;
// import net.minecraft.world.biome.Biome;
// import net.minecraft.world.biome.source.BiomeAccess;
// import net.minecraft.world.gen.chunk.ChunkGenerator;
// import net.minecraft.world.gen.feature.DefaultFeatureConfig;
// import net.minecraft.world.gen.feature.StructureFeature;
// import net.minecraft.world.Heightmap;

// import java.util.Random;
// import java.util.function.Function;

// public class FloatingCastleFeature extends StructureFeature<DefaultFeatureConfig> {
//   public FloatingCastleFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> configFactory) {
//     super(configFactory);
//   }

//   @Override
//   public boolean shouldStartAt(BiomeAccess biomeAccess, ChunkGenerator<?> chunkGenerator, Random random, int chunkX,
//       int chunkZ, Biome biome) {
//     ChunkPos chunkPos = this.getStart(chunkGenerator, random, chunkX, chunkZ, 0, 0);
//     return chunkX == chunkPos.x && chunkZ == chunkPos.z ? chunkGenerator.hasStructure(biome, this) : false;
//   }

//   @Override
//   public StructureStartFactory getStructureStartFactory() {
//     return FloatingCastleFeature.Start::new;
//   }

//   @Override
//   public String getName() {
//     return "mobz:floatingcastlefeature";
//   }

//   @Override
//   public int getRadius() {
//     return 8;
//   }

//   public static class Start extends StructureStart {
//     public Start(StructureFeature<?> structureFeature, int chunkX, int chunkZ, BlockBox blockBox, int references,
//         long seed) {
//       super(structureFeature, chunkX, chunkZ, blockBox, references, seed);
//     }

//     @Override
//     public void initialize(ChunkGenerator<?> chunkGenerator, StructureManager structureManager, int x, int z,
//         Biome biome) {
//       BlockPos blockPos = new BlockPos(x * 16, 0// chunkGenerator.getHeightOnGround(x * 16 + 15, z * 16 + 15,
//                                                 // Heightmap.Type.WORLD_SURFACE)
//           , z * 16);
//       BlockRotation blockRotation = BlockRotation.NONE;
//       // StructurePoolBasedGenerator.addPieces(X1Y1Z1, 5,
//       // FloatingCastleGenerator.Piece., chunkGenerator, structureManager, blockPos,
//       // children,
//       // random);
//       FloatingCastleGenerator.addPieces(structureManager, blockPos, blockRotation, this.children, this.random);
//       this.setBoundingBoxFromChildren();
//     }
//   }
// }

// // @Override
// // public void initialize(ChunkGenerator<?> chunkGenerator, StructureManager
// // structureManager, int x, int z,
// // Biome biome) {
// // BlockPos blockPos = new BlockPos(x * 16, 100//
// // chunkGenerator.getHeightOnGround(x * 16 + 15, z * 16 + 15,
// // // Heightmap.Type.WORLD_SURFACE)
// // , z * 16);
// // BlockRotation blockRotation = BlockRotation.NONE;
// // FloatingCastleGenerator.addPieces(chunkGenerator, structureManager, blockPos,
// // this.children, this.random);
// // this.setBoundingBoxFromChildren();
// // }

package net.mobz.World;

import java.util.Random;
import java.util.function.Function;

import com.mojang.serialization.Codec;

import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.Heightmap;

public class FloatingCastleFeature extends StructureFeature<DefaultFeatureConfig> {
  public FloatingCastleFeature(Codec<DefaultFeatureConfig> codec) {
    super(codec);
  }

  // @Override
  // public boolean shouldStartAt(BiomeAccess biomeAccess, ChunkGenerator<?> chunkGenerator, Random random, int chunkX,
  //     int chunkZ, Biome biome) {
  //   ChunkPos chunkPos = this.getStart(chunkGenerator, random, chunkX, chunkZ, 0, 0);
  //   return chunkX == chunkPos.x && chunkZ == chunkPos.z ? chunkGenerator.hasStructure(biome, this) : false;
  // }

  // public class FloatingCastleFeature extends
  // AbstractTempleFeature<DefaultFeatureConfig> {
  // public FloatingCastleFeature() {
  // super(DefaultFeatureConfig::deserialize);
  // }

  // @Override
  // public StructureStartFactory getStructureStartFactory() {
  //   return FloatingCastleFeature.Start::new;
  // }

  @Override
  public String getName() {
    return "floatingcastlefeature";
  }

  @Override
  public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
    return FloatingCastleStart::new;
  }

  // @Override
  // public int getRadius() {
  //   return 8;
  // }

  // @Override
  // protected int getSeedModifier() {
  // return 0;
  // }

  // public static class Start extends StructureStart {
  //   public Start(StructureFeature<?> feature, int chunkX, int chunkZ, BlockBox box, int references, long seed) {
  //     super(feature, chunkX, chunkZ, box, references, seed);
  //   }

  //   @Override
  //   public void initialize(ChunkGenerator<?> chunkGenerator, StructureManager structureManager, int x, int z,
  //       Biome biome) {
  //     FloatingCastleGenerator.addPieces(chunkGenerator, structureManager, new BlockPos(x * 16, 60, z * 16), children,
  //         random);
  //     this.setBoundingBoxFromChildren();
  //   }
  // }

} // chunkGenerator.getHeightOnGround(x * 16 + 15, z * 16 + 15,
  // Heightmap.Type.WORLD_SURFACE) + 100

// package net.mobz.World;

// import com.mojang.datafixers.Dynamic;
// import net.minecraft.structure.StructureManager;
// import net.minecraft.structure.StructureStart;
// import net.minecraft.structure.pool.StructurePoolBasedGenerator;
// import net.minecraft.util.BlockRotation;
// import net.minecraft.util.Identifier;
// import net.minecraft.util.math.BlockBox;
// import net.minecraft.util.math.BlockPos;
// import net.minecraft.util.math.ChunkPos;
// import net.minecraft.world.biome.Biome;
// import net.minecraft.world.biome.source.BiomeAccess;
// import net.minecraft.world.gen.chunk.ChunkGenerator;
// import net.minecraft.world.gen.feature.DefaultFeatureConfig;
// import net.minecraft.world.gen.feature.StructureFeature;
// import net.minecraft.world.Heightmap;

// import java.util.Random;
// import java.util.function.Function;

// public class FloatingCastleFeature extends
// StructureFeature<DefaultFeatureConfig> {
// public FloatingCastleFeature(Function<Dynamic<?>, ? extends
// DefaultFeatureConfig> configFactory) {
// super(configFactory);
// }

// @Override
// public boolean shouldStartAt(BiomeAccess biomeAccess, ChunkGenerator<?>
// chunkGenerator, Random random, int chunkX,
// int chunkZ, Biome biome) {
// ChunkPos chunkPos = this.getStart(chunkGenerator, random, chunkX, chunkZ, 0,
// 0);
// return chunkX == chunkPos.x && chunkZ == chunkPos.z ?
// chunkGenerator.hasStructure(biome, this) : false;
// }

// @Override
// public StructureStartFactory getStructureStartFactory() {
// return FloatingCastleFeature.Start::new;
// }

// @Override
// public String getName() {
// return "mobz:floatingcastlefeature";
// }

// @Override
// public int getRadius() {
// return 8;
// }

// public static class Start extends StructureStart {
// public Start(StructureFeature<?> structureFeature, int chunkX, int chunkZ,
// BlockBox blockBox, int references,
// long seed) {
// super(structureFeature, chunkX, chunkZ, blockBox, references, seed);
// }

// @Override
// public void initialize(ChunkGenerator<?> chunkGenerator, StructureManager
// structureManager, int x, int z,
// Biome biome) {
// BlockPos blockPos = new BlockPos(x * 16, 120//
// chunkGenerator.getHeightOnGround(x * 16 + 15, z * 16 + 15,
// // Heightmap.Type.WORLD_SURFACE)
// , z * 16);

// FloatingCastleGenerator.addPieces(chunkGenerator, structureManager, blockPos,
// children,
// random);
// this.setBoundingBoxFromChildren();
// }
// }
// }