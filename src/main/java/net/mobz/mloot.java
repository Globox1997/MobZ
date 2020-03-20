package net.mobz;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.BinomialLootTableRange;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class mloot {

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
                        .withRolls(new BinomialLootTableRange(1, 0.3f)).withEntry(ItemEntry.builder(glomod.WHITEBAG));

                supplier.withPool(poolBuilder);
            }
        });

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (istwo(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .withRolls(new BinomialLootTableRange(5, 0.3f))
                        .withEntry(ItemEntry.builder(glomod.HARDENEDMETAL));

                supplier.withPool(poolBuilder);
            }
        });

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (istwo(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .withRolls(new BinomialLootTableRange(2, 0.1f)).withEntry(ItemEntry.builder(glomod.BOSSBARREN));

                supplier.withPool(poolBuilder);
            }
        });

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (istwo(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .withRolls(new BinomialLootTableRange(1, 0.05f)).withEntry(ItemEntry.builder(glomod.REDD));

                supplier.withPool(poolBuilder);
            }
        });

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (isthree(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .withRolls(new BinomialLootTableRange(2, 0.2f)).withEntry(ItemEntry.builder(glomod.WITHERMEAL));

                supplier.withPool(poolBuilder);
            }
        });

    }
}