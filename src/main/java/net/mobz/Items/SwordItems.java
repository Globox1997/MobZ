package net.mobz.Items;

import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.mobz.Items.Sword.*;

public class SwordItems {

    public static final ToolMaterial BOSS_MATERIAL = new SwordBossMaterial();
    public static final ToolMaterial ARMORED_MATERIAL = new ArmoredSwordMaterial();
    public static final Item BossSword = register("boss_sword", new SwordGloBase((BOSS_MATERIAL)));
    public static final Item ArmoredSword = register("armored_sword", new SwordGloBase((ARMORED_MATERIAL)));
    public static final ToolMaterial AXEMATERIAL = new AxeMaterial();
    public static final Item Axe = register("axe", new AxeBase((AXEMATERIAL)));
    public static final ToolMaterial POISONSWORDMATERIAL = new PoisonSwordMaterial();
    public static final Item PoisonSword = register("poison_sword", new PoisonSwordBase((POISONSWORDMATERIAL)));
    public static final ToolMaterial SWORDMATERIAL = new SwordMaterial();
    public static final Item Sword = register("sword", new SwordBase((SWORDMATERIAL)));
    public static final Item FrozenSword = register("frozen_sword", new FrozenSwordBase((POISONSWORDMATERIAL)));

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