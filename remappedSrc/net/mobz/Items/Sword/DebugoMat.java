package net.mobz.Items.Sword;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class DebugoMat implements ToolMaterial {
    @Override
    public int getDurability() {
        return 2020;
    }

    @Override
    public float getMiningSpeed() {
        return 5.0F;
    }

    @Override
    public float getAttackDamage() {
        return 1995;
    }

    @Override
    public int getMiningLevel() {
        return 10;
    }

    @Override
    public int getEnchantability() {
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.DRAGON_EGG);
    }

}