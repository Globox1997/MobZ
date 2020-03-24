package net.mobz.Items.Armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.mobz.glomod;

public class LifeArmorMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] { 16, 18, 20, 14 };
    private static final int[] PROTECTION_AMOUNTS = new int[] { 2, 4, 5, 2 };

    @Override
    public int getDurability(EquipmentSlot equipmentSlot) {
        return BASE_DURABILITY[equipmentSlot.getEntitySlotId()] * 25;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot equipmentSlot) {
        return PROTECTION_AMOUNTS[equipmentSlot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(glomod.HARDENEDMETAL);
    }

    @Override
    public String getName() {
        return "life";
    }

    @Override
    public float getToughness() {
        return 0;
    }

}