package net.mobz.Inits;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.BinomialLootTableRange;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class Lootinit {

    public static final Identifier[] LONE = new Identifier[] { LootTables.BURIED_TREASURE_CHEST };
    public static final Identifier[] LTWO = new Identifier[] { LootTables.VILLAGE_ARMORER_CHEST,
            LootTables.SHIPWRECK_TREASURE_CHEST, LootTables.ABANDONED_MINESHAFT_CHEST,
            LootTables.VILLAGE_FLETCHER_CHEST, LootTables.VILLAGE_WEAPONSMITH_CHEST,
            LootTables.VILLAGE_TOOLSMITH_CHEST };
    public static final Identifier[] LTHREE = new Identifier[] { LootTables.NETHER_BRIDGE_CHEST };

    private static boolean isone(Identifier lootTable) {
        for (Identifier id : LONE) {
            if (id.equals(lootTable)) {
                return true;
            }
        }
        return false;
    }

    private static boolean istwo(Identifier lootTable) {
        for (Identifier id : LTWO) {
            if (id.equals(lootTable)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isthree(Identifier lootTable) {
        for (Identifier id : LTHREE) {
            if (id.equals(lootTable)) {
                return true;
            }
        }
        return false;
    }

    public static void init() {

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (isone(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(new BinomialLootTableRange(1, 0.3f)).with(ItemEntry.builder(Iteminit.WHITEBAG));

                supplier.pool(poolBuilder);
            }
        });

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (istwo(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(new BinomialLootTableRange(5, 0.3f))
                        .with(ItemEntry.builder(Iteminit.HARDENEDMETAL_INGOT));

                supplier.pool(poolBuilder);
            }
        });

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (istwo(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(new BinomialLootTableRange(2, 0.1f)).with(ItemEntry.builder(Iteminit.BOSS_INGOT));

                supplier.pool(poolBuilder);
            }
        });

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (istwo(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(new BinomialLootTableRange(1, 0.05f)).with(ItemEntry.builder(Iteminit.AMAT_INGOT));

                supplier.pool(poolBuilder);
            }
        });

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (isthree(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(new BinomialLootTableRange(2, 0.2f)).with(ItemEntry.builder(Iteminit.WITHERMEAL));

                supplier.pool(poolBuilder);
            }
        });

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if ("minecraft:entities/wither_skeleton".equals(id.toString())) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(BinomialLootTableRange.create(1, 0.1f)).with(ItemEntry.builder(Iteminit.WITHERMEAL));

                supplier.pool(poolBuilder);
            }
        });

    }
}