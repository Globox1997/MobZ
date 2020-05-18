package net.mobz.Inits;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.mobz.Blocks.*;

public class Blockinit {

        public static final Enderheader ENDERHEADER = new Enderheader(
                        FabricBlockSettings.copy(Blocks.ZOMBIE_HEAD).build());
        public static final TotemBase TOTEM_BASE = new TotemBase(FabricBlockSettings.copy(Blocks.OAK_LOG).build());
        public static final TotemMiddle TOTEM_MIDDLE = new TotemMiddle(
                        FabricBlockSettings.copy(Blocks.OAK_LOG).build());
        public static final TotemTop TOTEM_TOP = new TotemTop(FabricBlockSettings.copy(Blocks.OAK_LOG).build());
        public static final Bosstrophy BOSS_TROPHY = new Bosstrophy(
                        FabricBlockSettings.copy(Blocks.ZOMBIE_HEAD).build());
        public static final Spawnblock SPAWN_BLOCK = new Spawnblock(FabricBlockSettings.copy(Blocks.SPAWNER).build());
        public static final Reddblock REDD_BLOCK = new Reddblock(
                        FabricBlockSettings.copy(Blocks.DIAMOND_BLOCK).build());
        public static final HardenedMetalblock HARDENED_METALBLOCK = new HardenedMetalblock(
                        FabricBlockSettings.copy(Blocks.GOLD_BLOCK).build());
        public static BlockEntityType<SpawnblockEntity> SPAWNBLOCKENTITY;
        public static BlockEntityType<TotemMiddleEntity> TOTEMMIDDLEENTITY;
        public static BlockEntityType<HardenedMetalblockEntity> HARDENEDMETALBLOCKENTITY;

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
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawnblock"),
                                new BlockItem(SPAWN_BLOCK, new Item.Settings()));
                Registry.register(Registry.BLOCK, new Identifier("mobz", "spawnblock"), SPAWN_BLOCK);
                SPAWNBLOCKENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "mobz:spawnblockentity",
                                BlockEntityType.Builder.create(SpawnblockEntity::new, SPAWN_BLOCK).build(null));
                Registry.register(Registry.ITEM, new Identifier("mobz", "reddblock"),
                                new BlockItem(REDD_BLOCK, new Item.Settings()));
                Registry.register(Registry.BLOCK, new Identifier("mobz", "reddblock"), REDD_BLOCK);
                Registry.register(Registry.ITEM, new Identifier("mobz", "hardenedmetal_block"),
                                new BlockItem(HARDENED_METALBLOCK, new Item.Settings()));
                Registry.register(Registry.BLOCK, new Identifier("mobz", "hardenedmetal_block"), HARDENED_METALBLOCK);
                HARDENEDMETALBLOCKENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                                "mobz:hardenedmetalblockentity",
                                BlockEntityType.Builder.create(HardenedMetalblockEntity::new, HARDENED_METALBLOCK)
                                                .build(null));
        }
}