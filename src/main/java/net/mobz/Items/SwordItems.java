package net.mobz.Items;

import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SwordItems {

    public static final ToolMaterial BOSS_MATERIAL = new SwordBossMaterial();
    public static final ToolMaterial ARMORED_MATERIAL = new ArmoredSwordMaterial();
    public static final Item BossSword = register("boss_sword", new SwordGloBase((BOSS_MATERIAL)));
    public static final Item ArmoredSword = register("armored_sword", new SwordGloBase((ARMORED_MATERIAL)));

    public static final ToolMaterial X_MATERIAL = new SwordXMaterial();
    public static final Item XSword = register("x_sword", new SwordGloBase2((X_MATERIAL)));

    public static final ToolMaterial SWORDMATERIAL = new SwordMaterial();
    public static final Item Sword = register("sword", new SwordBase((SWORDMATERIAL)));

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