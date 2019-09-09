package net.mobz;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BossArmorItems {
    public static final ArmorMaterial BOSSAPPARE = new BossArmorMaterial();

    public static final Item boss_helmet = register("boss_helmet", new ArmorBase(BOSSAPPARE, EquipmentSlot.HEAD));
    public static final Item boss_chestplate = register("boss_chestplate",
            new ArmorBase(BOSSAPPARE, EquipmentSlot.CHEST));
    public static final Item boss_leggings = register("boss_leggings", new ArmorBase(BOSSAPPARE, EquipmentSlot.LEGS));
    public static final Item boss_boots = register("boss_boots", new ArmorBase(BOSSAPPARE, EquipmentSlot.FEET));

    private static Item register(String id, Item item) {
        return register(new Identifier("mobz", id), item);
    }

    private static Item register(Identifier id, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registry.ITEM, id, item);
    }

    public static void init() {
    }
}