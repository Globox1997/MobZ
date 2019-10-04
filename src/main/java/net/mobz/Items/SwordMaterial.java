package net.mobz.Items;

import net.mobz.glomod;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SwordMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 10000;
    }

    @Override
    public float getMiningSpeed() {
        return 1.0F;
    }

    @Override
    public float getAttackDamage() {
        return 1896;
    }

    @Override
    public int getMiningLevel() {
        return 1;
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