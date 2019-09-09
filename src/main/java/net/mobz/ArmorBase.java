package net.mobz;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ArmorBase extends ArmorItem {
    public ArmorBase(ArmorMaterial material, EquipmentSlot slot) {
        super(material, slot, new Item.Settings().group(ItemGroup.COMBAT));
    }

}