package net.mobz.Items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ArmorItems {
        public static final ArmorMaterial BOSSAPPARE = new BossArmorMaterial();
        public static final ArmorMaterial LIFEAPPARE = new LifeArmorMaterial();
        public static final ArmorMaterial SPEEDAPPARE = new SpeedShoeMaterial();
        public static final ArmorMaterial AMAT = new AMaterial();

        public static final Item boss_helmet = register("boss_helmet", new ArmorBase(BOSSAPPARE, EquipmentSlot.HEAD));
        public static final Item boss_chestplate = register("boss_chestplate",
                        new ArmorBase(BOSSAPPARE, EquipmentSlot.CHEST));
        public static final Item boss_leggings = register("boss_leggings",
                        new ArmorBase(BOSSAPPARE, EquipmentSlot.LEGS));
        public static final Item boss_boots = register("boss_boots", new ArmorBase(BOSSAPPARE, EquipmentSlot.FEET));
        public static final Item life_helmet = register("life_helmet", new ArmorBase2(LIFEAPPARE, EquipmentSlot.HEAD));
        public static final Item life_chestplate = register("life_chestplate",
                        new ArmorBase2(LIFEAPPARE, EquipmentSlot.CHEST));
        public static final Item life_leggings = register("life_leggings",
                        new ArmorBase2(LIFEAPPARE, EquipmentSlot.LEGS));
        public static final Item life_boots = register("life_boots", new ArmorBase2(LIFEAPPARE, EquipmentSlot.FEET));
        public static final Item speed_helmet = register("speed_helmet",
                        new SpeedShoeBase(SPEEDAPPARE, EquipmentSlot.HEAD));
        public static final Item speed_chestplate = register("speed_chestplate",
                        new SpeedShoeBase(SPEEDAPPARE, EquipmentSlot.CHEST));
        public static final Item speed_leggings = register("speed_leggings",
                        new SpeedShoeBase(SPEEDAPPARE, EquipmentSlot.LEGS));
        public static final Item speed_boots = register("speed_boots",
                        new SpeedShoeBase(SPEEDAPPARE, EquipmentSlot.FEET));
        public static final Item amat_helmet = register("amat_helmet", new SpeedShoeBase(AMAT, EquipmentSlot.HEAD));
        public static final Item amat_chestplate = register("amat_chestplate",
                        new SpeedShoeBase(AMAT, EquipmentSlot.CHEST));
        public static final Item amat_leggings = register("amat_leggings", new SpeedShoeBase(AMAT, EquipmentSlot.LEGS));
        public static final Item amat_boots = register("amat_boots", new SpeedShoeBase(AMAT, EquipmentSlot.FEET));

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