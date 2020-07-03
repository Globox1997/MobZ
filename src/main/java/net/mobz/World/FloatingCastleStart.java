package net.mobz.World;

import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.math.BlockBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class FloatingCastleStart extends StructureStart {

  public FloatingCastleStart(StructureFeature<?> feature, int chunkX, int chunkZ, BlockBox box, int references,
      long l) {
    super(feature, chunkX, chunkZ, box, references, l);
  }

  @Override
  public void init(ChunkGenerator chunkGenerator, StructureManager structureManager, int x, int z, Biome biome,
      FeatureConfig featureConfig) {

  }
}