package net.mobz.Items.Armor;

import java.util.List;
import java.util.UUID;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
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

public class ArmorBase3 extends ArmorItem {
    double attackSpeedBonus = 0.1D;
    private static final UUID[] MODIFIERS = new UUID[] { UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"),
            UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"),
            UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"),
            UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150") };
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    private final int protection;
    private final float toughness;

    public ArmorBase3(ArmorMaterial material, EquipmentSlot slot) {
        super(material, slot, new Item.Settings());
        this.protection = material.getProtectionAmount(slot);
        this.toughness = material.getToughness();
        Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        UUID uUID = MODIFIERS[slot.getEntitySlotId()];
        builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(uUID, "Armor modifier",
                (double) this.protection, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(uUID, "Armor toughness",
                (double) this.toughness, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(uUID, "AD",
                (double) this.toughness, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.mobz.amat_armor.tooltip"));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        LivingEntity bob = (LivingEntity) entity;
        StatusEffectInstance fire = new StatusEffectInstance(StatusEffect.byRawId(12), 9, 0, false, false);
        if (bob.getEquippedStack(EquipmentSlot.FEET).isItemEqual(new ItemStack(ArmorItems.amat_boots))
                && bob.getEquippedStack(EquipmentSlot.LEGS).isItemEqual(new ItemStack(ArmorItems.amat_leggings))
                && bob.getEquippedStack(EquipmentSlot.CHEST).isItemEqual(new ItemStack(ArmorItems.amat_chestplate))
                && bob.getEquippedStack(EquipmentSlot.HEAD).isItemEqual(new ItemStack(ArmorItems.amat_helmet))
                && !world.isClient) {
            bob.addStatusEffect(fire);
        }
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot) {
        return equipmentSlot == this.slot ? this.attributeModifiers : super.getAttributeModifiers(equipmentSlot);
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    @Override
    public float method_26353() {
        return this.toughness;
    }
}
