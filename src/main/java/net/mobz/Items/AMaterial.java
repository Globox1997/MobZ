package net.mobz.Items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class AMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] { 13, 15, 16, 11 };
    private static final int[] PROTECTION_AMOUNTS = new int[] { 2, 5, 6, 2 };

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
        return 15;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }

    @Override
    public String getName() {
        return "amat";
    }

    @Override
    public float getToughness() {
        return 1;
    }

}