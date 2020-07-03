package net.mobz.Items.Sword;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class WitherSwordMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 516;
    }

    @Override
    public float getMiningSpeed() {
        return 1.0F;
    }

    @Override
    public float getAttackDamage() {
        return 5;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 12;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.EMPTY;
    }
}