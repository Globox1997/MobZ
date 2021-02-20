package net.mobz.Inits;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.mobz.Blocks.*;

public class Blockinit {

        public static final Enderheader ENDERHEADER = new Enderheader(FabricBlockSettings.copy(Blocks.ZOMBIE_HEAD));
        public static final TotemBase TOTEM_BASE = new TotemBase(FabricBlockSettings.copy(Blocks.OAK_WOOD));
        public static final TotemMiddle TOTEM_MIDDLE = new TotemMiddle(FabricBlockSettings.copy(Blocks.OAK_WOOD));
        public static final TotemTop TOTEM_TOP = new TotemTop(FabricBlockSettings.copy(Blocks.OAK_WOOD));
        public static final Bosstrophy BOSS_TROPHY = new Bosstrophy(FabricBlockSettings.copy(Blocks.ZOMBIE_HEAD));
        public static final Spawnblock SPAWN_BLOCK = new Spawnblock(FabricBlockSettings.copy(Blocks.SPAWNER));
        // public static final Bossblock BOSS_BLOCK = new Bossblock(
        // ((FabricBlockSettings)
        // FabricBlockSettings.copy(Blocks.IRON_BLOCK)).lightLevel((state) -> {
        // return 5;
        // }));
        public static final Bossblock BOSS_BLOCK = new Bossblock(
                        ((FabricBlockSettings) FabricBlockSettings.copy(Blocks.IRON_BLOCK)).luminance(5));
        // public static final Amatblock AMAT_BLOCK = new Amatblock(
        // FabricBlockSettings.copy(Blocks.IRON_BLOCK).lightLevel((state) -> {
        // return 4;
        // }));
        public static final Amatblock AMAT_BLOCK = new Amatblock(
                        ((FabricBlockSettings) FabricBlockSettings.copy(Blocks.IRON_BLOCK)).luminance(5));
        public static final HardenedMetalblock HARDENED_METALBLOCK = new HardenedMetalblock(
                        FabricBlockSettings.copy(Blocks.IRON_BLOCK));
        public static final Treasureblock TREASURE_BLOCK = new Treasureblock(FabricBlockSettings.copy(Blocks.BEDROCK));
        public static BlockEntityType<SpawnblockEntity> SPAWNBLOCKENTITY;
        public static BlockEntityType<TotemMiddleEntity> TOTEMMIDDLEENTITY;
        public static BlockEntityType<HardenedMetalblockEntity> HARDENEDMETALBLOCKENTITY;
        public static BlockEntityType<TreasureblockEntity> TREASUREBLOCKENTITY;

        public static void init() {

                Registry.register(Registry.ITEM, new Identifier("mobz", "enderheader"),
                                new BlockItem(ENDERHEADER, new Item.Settings()));
                Registry.register(Registry.BLOCK, new Identifier("mobz", "enderheader"), ENDERHEADER);
                Registry.register(Registry.ITEM, new Identifier("mobz", "totembase"),
                                new BlockItem(TOTEM_BASE, new Item.Settings()));
                Registry.register(Registry.BLOCK, new Identifier("mobz", "totembase"), TOTEM_BASE);
                Registry.register(Registry.ITEM, new Identifier("mobz", "totemmiddle"),
                                new BlockItem(TOTEM_MIDDLE, new Item.Settings()));
                Registry.register(Registry.BLOCK, new Identifier("mobz", "totemmiddle"), TOTEM_MIDDLE);
                TOTEMMIDDLEENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "mobz:totemmiddleentity",
                                BlockEntityType.Builder.create(TotemMiddleEntity::new, TOTEM_MIDDLE).build(null));
                Registry.register(Registry.ITEM, new Identifier("mobz", "totemtop"),
                                new BlockItem(TOTEM_TOP, new Item.Settings()));
                Registry.register(Registry.BLOCK, new Identifier("mobz", "totemtop"), TOTEM_TOP);
                Registry.register(Registry.ITEM, new Identifier("mobz", "bosstrophy"),
                                new BlockItem(BOSS_TROPHY, new Item.Settings()));
                Registry.register(Registry.BLOCK, new Identifier("mobz", "bosstrophy"), BOSS_TROPHY);
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_block"),
                                new BlockItem(SPAWN_BLOCK, new Item.Settings()));
                Registry.register(Registry.BLOCK, new Identifier("mobz", "spawn_block"), SPAWN_BLOCK);
                SPAWNBLOCKENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "mobz:spawnblockentity",
                                BlockEntityType.Builder.create(SpawnblockEntity::new, SPAWN_BLOCK).build(null));
                Registry.register(Registry.ITEM, new Identifier("mobz", "boss_block"),
                                new BlockItem(BOSS_BLOCK, new Item.Settings()));
                Registry.register(Registry.BLOCK, new Identifier("mobz", "boss_block"), BOSS_BLOCK);
                Registry.register(Registry.ITEM, new Identifier("mobz", "amat_block"),
                                new BlockItem(AMAT_BLOCK, new Item.Settings()));
                Registry.register(Registry.BLOCK, new Identifier("mobz", "amat_block"), AMAT_BLOCK);
                Registry.register(Registry.ITEM, new Identifier("mobz", "hardenedmetal_block"),
                                new BlockItem(HARDENED_METALBLOCK, new Item.Settings()));
                Registry.register(Registry.BLOCK, new Identifier("mobz", "hardenedmetal_block"), HARDENED_METALBLOCK);
                HARDENEDMETALBLOCKENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                                "mobz:hardenedmetalblockentity",
                                BlockEntityType.Builder.create(HardenedMetalblockEntity::new, HARDENED_METALBLOCK)
                                                .build(null));
                Registry.register(Registry.ITEM, new Identifier("mobz", "treasure_block"),
                                new BlockItem(TREASURE_BLOCK, new Item.Settings()));
                Registry.register(Registry.BLOCK, new Identifier("mobz", "treasure_block"), TREASURE_BLOCK);
                TREASUREBLOCKENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "mobz:treasureblockentity",
                                BlockEntityType.Builder.create(TreasureblockEntity::new, TREASURE_BLOCK).build(null));
        }
}