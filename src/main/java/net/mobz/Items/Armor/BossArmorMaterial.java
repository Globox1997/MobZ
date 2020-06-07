package net.mobz.Items.Armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.mobz.Inits.Iteminit;

public class BossArmorMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] { 18, 20, 22, 16 };
    private static final int[] PROTECTION_AMOUNTS = new int[] { 4, 7, 9, 4 };

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
        return 25;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_GOLD;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Iteminit.BOSS_INGOT);
    }

    @Override
    public String getName() {
        return "boss";
    }

    @Override
    public float getToughness() {
        return 2;
    }

}