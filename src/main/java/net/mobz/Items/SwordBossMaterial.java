package net.mobz.Items;

import net.mobz.glomod;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SwordBossMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 561;
    }

    @Override
    public float getMiningSpeed() {
        return 1.0F;
    }

    @Override
    public float getAttackDamage() {
        return 8;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(glomod.BOSSBARREN);
    }

}