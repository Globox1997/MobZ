package net.mobz.Items.Armor;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import net.mobz.Inits.ArmorItems;

public class ArmorBase extends ArmorItem {

    public ArmorBase(ArmorMaterial material, EquipmentSlot slot) {
        super(material, slot, new Item.Settings());
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.mobz.boss_armor.tooltip"));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        LivingEntity bob = (LivingEntity) entity;
        StatusEffectInstance spd = new StatusEffectInstance(StatusEffect.byRawId(1), 9, 0, false, false);
        StatusEffectInstance str = new StatusEffectInstance(StatusEffect.byRawId(5), 9, 0, false, false);
        if (bob.getEquippedStack(EquipmentSlot.FEET).isItemEqual(new ItemStack(ArmorItems.boss_boots))
                && bob.getEquippedStack(EquipmentSlot.LEGS).isItemEqual(new ItemStack(ArmorItems.boss_leggings))
                && bob.getEquippedStack(EquipmentSlot.CHEST).isItemEqual(new ItemStack(ArmorItems.boss_chestplate))
                && bob.getEquippedStack(EquipmentSlot.HEAD).isItemEqual(new ItemStack(ArmorItems.boss_helmet))
                && !world.isClient) {
            bob.addStatusEffect(str);
            if (bob.isSprinting()) {
                bob.addStatusEffect(spd);
            }

        }
    }

}
