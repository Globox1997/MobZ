package net.mobz.World;

import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.structure.*;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.mobz.Inits.Worldinit;

import java.util.List;
import java.util.Random;

public class FloatingCastleGenerator {

  private static final Identifier X1Y1Z1 = new Identifier("mobz:x1y1z1");
  private static final Identifier X2Y1Z1 = new Identifier("mobz:x2y1z1");
  private static final Identifier X1Y1Z2 = new Identifier("mobz:x1y1z2");
  private static final Identifier X2Y1Z2 = new Identifier("mobz:x2y1z2");
  private static final Identifier X1Y2Z1 = new Identifier("mobz:x1y2z1");
  private static final Identifier X2Y2Z1 = new Identifier("mobz:x2y2z1");
  private static final Identifier X1Y2Z2 = new Identifier("mobz:x1y2z2");
  private static final Identifier X2Y2Z2 = new Identifier("mobz:x2y2z2");
  private static final Identifier X1Y3Z1 = new Identifier("mobz:x1y3z1");
  private static final Identifier X2Y3Z1 = new Identifier("mobz:x2y3z1");
  private static final Identifier X1Y3Z2 = new Identifier("mobz:x1y3z2");
  private static final Identifier X2Y3Z2 = new Identifier("mobz:x2y3z2");
  private static final Identifier X1Y4Z1 = new Identifier("mobz:x1y4z1");
  private static final Identifier X2Y4Z1 = new Identifier("mobz:x2y4z1");
  private static final Identifier X1Y4Z2 = new Identifier("mobz:x1y4z2");

  private static final Identifier XXX = new Identifier("mobz:xxx");
  private static final Identifier XXXX = new Identifier("mobz:yyy");
  private static final Identifier TTTTT = new Identifier("mobz:testx");
  private static final Identifier OK2 = new Identifier("mobz:testy");
  private static final Identifier OK3 = new Identifier("mobz:testy2");

  private static final Identifier towerloot = new Identifier("mobz:island_loot");

  public static void addPieces(StructureManager manager, BlockPos pos, BlockRotation rotation,
      List<StructurePiece> pieces, Random random) {
    BlockPos x1y1z1 = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
    BlockPos x2y1z1 = new BlockPos(x1y1z1.getX() + 32, x1y1z1.getY(), x1y1z1.getZ());
    BlockPos x1y1z2 = new BlockPos(x1y1z1.getX(), x1y1z1.getY(), x1y1z1.getZ() + 32);
    BlockPos x2y1z2 = new BlockPos(x1y1z1.getX() + 32, x1y1z1.getY(), x1y1z1.getZ() + 32);
    BlockPos x1y2z1 = new BlockPos(pos.getX(), pos.getY() + 32, pos.getZ());
    BlockPos x2y2z1 = new BlockPos(pos.getX() + 32, pos.getY() + 32, pos.getZ());
    BlockPos x1y2z2 = new BlockPos(pos.getX(), pos.getY() + 32, pos.getZ() + 32);
    BlockPos x2y2z2 = new BlockPos(pos.getX() + 32, pos.getY() + 32, pos.getZ() + 32);
    BlockPos x1y3z1 = new BlockPos(pos.getX(), pos.getY() + 64, pos.getZ());
    BlockPos x2y3z1 = new BlockPos(pos.getX() + 32, pos.getY() + 64, pos.getZ());
    BlockPos x1y3z2 = new BlockPos(pos.getX(), pos.getY() + 64, pos.getZ() + 32);
    BlockPos x2y3z2 = new BlockPos(pos.getX() + 32, pos.getY() + 64, pos.getZ() + 32);
    BlockPos x1y4z1 = new BlockPos(pos.getX(), pos.getY() + 96, pos.getZ());
    BlockPos x2y4z1 = new BlockPos(pos.getX() + 32, pos.getY() + 96, pos.getZ());
    BlockPos x1y4z2 = new BlockPos(pos.getX(), pos.getY() + 96, pos.getZ() + 32);

    BlockPos s1 = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
    BlockPos s2 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 16);
    // pieces.add(new FloatingCastleGenerator.Piece(manager, X1Y1Z1, x1y1z1,
    // rotation));
    // TTTT
    // pieces.add(new FloatingCastleGenerator.Piece(manager, X2Y1Z1, x2y1z1,
    // rotation));
    // pieces.add(new FloatingCastleGenerator.Piece(manager, X1Y1Z2, x1y1z2,
    // rotation));
    // pieces.add(new FloatingCastleGenerator.Piece(manager, X2Y1Z2, x2y1z2,
    // rotation));
    // pieces.add(new FloatingCastleGenerator.Piece(manager, XXX, s1, rotation));
    // pieces.add(new FloatingCastleGenerator.Piece(manager, XXXX, s2, rotation));
    // pieces.add(new FloatingCastleGenerator.Piece(manager, TTTTT, pos, rotation));
    pieces.add(new FloatingCastleGenerator.Piece(manager, OK2, pos, rotation));
    pieces.add(new FloatingCastleGenerator.Piece(manager, OK3, pos, rotation));
    // TTTT
    // pieces.add(new FloatingCastleGenerator.Piece(manager, X2Y1Z1, x2y1z1,
    // rotation));
    // pieces.add(new FloatingCastleGenerator.Piece(manager, X1Y1Z2, x1y1z2,
    // rotation));
    // pieces.add(new FloatingCastleGenerator.Piece(manager, X2Y1Z2, x2y1z2,
    // rotation));
    // pieces.add(new FloatingCastleGenerator.Piece(manager, X1Y2Z1, x1y2z1,
    // rotation));
    // pieces.add(new FloatingCastleGenerator.Piece(manager, X2Y2Z1, x2y2z1,
    // rotation));
    // pieces.add(new FloatingCastleGenerator.Piece(manager, X1Y2Z2, x1y2z2,
    // rotation));
    // pieces.add(new FloatingCastleGenerator.Piece(manager, X2Y2Z2, x2y2z2,
    // rotation));
    // pieces.add(new FloatingCastleGenerator.Piece(manager, X1Y3Z1, x1y3z1,
    // rotation));
    // pieces.add(new FloatingCastleGenerator.Piece(manager, X2Y3Z1, x2y3z1,
    // rotation));
    // pieces.add(new FloatingCastleGenerator.Piece(manager, X1Y3Z2, x1y3z2,
    // rotation));
    // pieces.add(new FloatingCastleGenerator.Piece(manager, X2Y3Z2, x2y3z2,
    // rotation));
    // pieces.add(new FloatingCastleGenerator.Piece(manager, X1Y4Z1, x1y4z1,
    // rotation));
    // pieces.add(new FloatingCastleGenerator.Piece(manager, X2Y4Z1, x2y4z1,
    // rotation));
    // pieces.add(new FloatingCastleGenerator.Piece(manager, X1Y4Z2, x1y4z2,
    // rotation));

  }

  public static class Piece extends SimpleStructurePiece {
    private final Identifier template;
    private final BlockRotation rotation;

    public Piece(StructureManager manager, Identifier identifier, BlockPos pos, BlockRotation rotation) {
      super(Worldinit.FLOATING_CASTLE_PIECES, 0);
      this.template = identifier;
      this.rotation = rotation;
      this.pos = pos;

      this.initializeStructureData(manager);
    }

    public Piece(StructureManager manager, CompoundTag tag) {
      super(Worldinit.FLOATING_CASTLE_PIECES, tag);
      this.template = new Identifier(tag.getString("Template"));
      this.rotation = BlockRotation.valueOf(tag.getString("Rot"));
      this.initializeStructureData(manager);
    }

    private void initializeStructureData(StructureManager manager) {
      Structure structure = manager.getStructureOrBlank(this.template);
      StructurePlacementData structurePlacementData = (new StructurePlacementData()).setRotation(this.rotation)
          .setMirrored(BlockMirror.NONE).setPosition(pos);
      this.setStructureData(structure, this.pos, structurePlacementData);
    }

    @Override
    protected void toNbt(CompoundTag tag) {
      super.toNbt(tag);
      tag.putString("Template", this.template.toString());
      tag.putString("Rot", this.rotation.name());
    }

    @Override
    protected void handleMetadata(String metadata, BlockPos pos, IWorld world, Random random, BlockBox boundingBox) {

      if (metadata.contains("island_loot")) {
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        BlockEntity blockEntity = world.getBlockEntity(pos.down());

        if (blockEntity instanceof ChestBlockEntity) {
          ((ChestBlockEntity) blockEntity).setLootTable(towerloot, random.nextLong());
        }
      }
    }

    @Override
    public boolean generate(IWorld world, ChunkGenerator<?> generator, Random random, BlockBox box, ChunkPos pos) {
      this.placementData.addProcessor(BlockIgnoreStructureProcessor.IGNORE_AIR_AND_STRUCTURE_BLOCKS);
      BlockPos dirt = new BlockPos(this.pos.getX(), this.pos.getY(), this.pos.getZ());

      // // if (world.getBlockState(dirt.down(15)).isAir() &&
      // // world.getBlockState(dirt.down(15).east(10).west(10)).isAir()
      // // && world.getBlockState(dirt.down(45).east(10).west(10)).isAir()
      // // && world.getBlockState(dirt.down(40).east(10).west(10)).isAir()
      // // && world.getBlockState(dirt.down(35).east(10).west(10)).isAir()
      // // && world.getBlockState(dirt.down(30).east(10).west(10)).isAir()
      // // && world.getBlockState(dirt.down(25).east(10).west(10)).isAir()
      // // && world.getBlockState(dirt.down(20).east(10).west(10)).isAir()
      // // && world.getBlockState(dirt.down(15).east(10).west(10)).isAir()
      // // && world.getBlockState(dirt.up(10).east(10).west(10)).isAir()
      // // &&
      // //
      // (world.getBlockState(dirt.down(21).east(10).west(10)).getBlock().equals(Blocks.WATER)
      // // ||
      // //
      // world.getBlockState(dirt.down(21).east(10).west(10)).getBlock().equals(Blocks.LILY_PAD))
      // // ) {
      boolean success = super.generate(world, generator, random, box, pos);
      return success;
      // // } else
      // // return false;

      // int yHeight = world.getTopY(Heightmap.Type.WORLD_SURFACE_WG, this.pos.getX()
      // + 8, this.pos.getZ() + 8);
      // this.pos = this.pos.add(0, yHeight - 1, 0);
      // return super.generate(world, generator, random, box, pos);
    }
  }
}

// package net.mobz.World;

// import com.google.common.collect.ImmutableList;
// import com.mojang.datafixers.util.Pair;
// import net.minecraft.nbt.CompoundTag;
// import net.minecraft.structure.PoolStructurePiece;
// import net.minecraft.structure.StructureManager;
// import net.minecraft.structure.StructurePiece;
// import net.minecraft.structure.pool.SinglePoolElement;
// import net.minecraft.structure.pool.StructurePool;
// import net.minecraft.structure.pool.StructurePoolBasedGenerator;
// import net.minecraft.structure.pool.StructurePoolElement;
// import net.minecraft.util.BlockRotation;
// import net.minecraft.util.Identifier;
// import net.minecraft.util.math.BlockBox;
// import net.minecraft.util.math.BlockPos;
// import net.minecraft.world.gen.ChunkRandom;
// import net.minecraft.world.gen.chunk.ChunkGenerator;
// import net.mobz.Inits.Worldinit;

// import java.util.List;

// public class FloatingCastleGenerator {
// private static final Identifier XXX = new Identifier("mobz:xxx");
// private static final Identifier XXXX = new Identifier("mobz:yyy");

// static {
// StructurePoolBasedGenerator.REGISTRY.add(new StructurePool(XXX, new
// Identifier("empty"),
// ImmutableList.of(new Pair<>(new SinglePoolElement("mobz:xxx"), 1)),
// StructurePool.Projection.RIGID));
// StructurePoolBasedGenerator.REGISTRY.add(new StructurePool(XXXX, new
// Identifier("empty"),
// ImmutableList.of(new Pair<>(new SinglePoolElement("mobz:yyy"), 1)

// ), StructurePool.Projection.RIGID));
// }

// public static void addPieces(ChunkGenerator<?> chunkGenerator,
// StructureManager structureManager, BlockPos pos,
// List<StructurePiece> pieces, ChunkRandom random) {
// StructurePoolBasedGenerator.addPieces(XXX, 16,
// FloatingCastleGenerator.Piece::new, chunkGenerator, structureManager,
// pos, pieces, random);
// }

// public static class Piece extends PoolStructurePiece {
// public Piece(StructureManager manager, CompoundTag tag) {
// super(manager, tag, Worldinit.FLOATING_CASTLE_PIECES);
// }

// public Piece(StructureManager structureManager, StructurePoolElement
// structurePoolElement, BlockPos blockPos, int i,
// BlockRotation blockRotation, BlockBox blockBox) {
// super(Worldinit.FLOATING_CASTLE_PIECES, structureManager,
// structurePoolElement, blockPos, i, BlockRotation.NONE,
// blockBox);
// }
// }
// }