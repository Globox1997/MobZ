package net.mobz.Items.Armor;

import java.util.List;
import java.util.UUID;

import com.google.common.collect.Multimap;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
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

    public ArmorBase3(ArmorMaterial material, EquipmentSlot slot) {
        super(material, slot, new Item.Settings());
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.mobz.amat_armor.tooltip"));
    }

    @Override
    public Multimap<String, EntityAttributeModifier> getModifiers(EquipmentSlot equipmentSlot_1) {
        Multimap<String, EntityAttributeModifier> multimap_1 = super.getModifiers(equipmentSlot_1);
        if (equipmentSlot_1 == this.slot) {
            multimap_1.put(EntityAttributes.ATTACK_DAMAGE.getId(),
                    new EntityAttributeModifier(MODIFIERS[equipmentSlot_1.getEntitySlotId()], "amatattackbonus",
                            (double) this.toughness, EntityAttributeModifier.Operation.ADDITION));
        }

        return multimap_1;
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
}
