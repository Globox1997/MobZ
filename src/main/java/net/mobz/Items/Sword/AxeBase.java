package net.mobz.Items.Sword;

import java.util.Random;
import java.util.function.Consumer;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

import net.mobz.glomod;

public class AxeBase extends SwordItem {
    public AxeBase(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, 1, -3.4f, new Item.Settings().group(glomod.MOBZ_GROUP));
    }

    public boolean postHit(ItemStack itemStack_1, LivingEntity livingEntity_1, LivingEntity livingEntity_2) {
        itemStack_1.damage(1, (LivingEntity) livingEntity_2, (Consumer) ((livingEntity_1x) -> {
            ((LivingEntity) livingEntity_1x).sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        }));
        Random random = new Random();
        int randomNumber = random.nextInt() % 4;
        switch (randomNumber) {
        case 0:
            StatusEffectInstance slow1 = new StatusEffectInstance(StatusEffect.byRawId(2), 40, 0, false, false, false);
            livingEntity_1.addStatusEffect(slow1);
            StatusEffectInstance blind = new StatusEffectInstance(StatusEffect.byRawId(15), 20, 0, false, false, false);
            livingEntity_1.addStatusEffect(blind);
            StatusEffectInstance strength = new StatusEffectInstance(StatusEffect.byRawId(5), 70, 0, false, false,
                    false);
            livingEntity_2.addStatusEffect(strength);
            StatusEffectInstance defense = new StatusEffectInstance(StatusEffect.byRawId(11), 40, 0, false, false,
                    false);
            livingEntity_2.addStatusEffect(defense);
            return true;
        case 1:
            StatusEffectInstance slow2 = new StatusEffectInstance(StatusEffect.byRawId(2), 30, 0, false, false, false);
            livingEntity_1.addStatusEffect(slow2);
            StatusEffectInstance blind2 = new StatusEffectInstance(StatusEffect.byRawId(15), 20, 0, false, false,
                    false);
            livingEntity_1.addStatusEffect(blind2);
            StatusEffectInstance strength2 = new StatusEffectInstance(StatusEffect.byRawId(5), 70, 0, false, false,
                    false);
            livingEntity_2.addStatusEffect(strength2);
            StatusEffectInstance defense2 = new StatusEffectInstance(StatusEffect.byRawId(11), 40, 0, false, false,
                    false);
            livingEntity_2.addStatusEffect(defense2);
            return true;
        case 2:
            StatusEffectInstance slow3 = new StatusEffectInstance(StatusEffect.byRawId(2), 60, 0, false, false, false);
            livingEntity_1.addStatusEffect(slow3);
            StatusEffectInstance blind3 = new StatusEffectInstance(StatusEffect.byRawId(15), 20, 0, false, false,
                    false);
            livingEntity_1.addStatusEffect(blind3);
            StatusEffectInstance strength3 = new StatusEffectInstance(StatusEffect.byRawId(5), 70, 0, false, false,
                    false);
            livingEntity_2.addStatusEffect(strength3);
            StatusEffectInstance defense3 = new StatusEffectInstance(StatusEffect.byRawId(11), 40, 0, false, false,
                    false);
            livingEntity_2.addStatusEffect(defense3);
            return true;
        case 3:
            StatusEffectInstance slow4 = new StatusEffectInstance(StatusEffect.byRawId(2), 80, 0, false, false, false);
            livingEntity_1.addStatusEffect(slow4);
            StatusEffectInstance blind4 = new StatusEffectInstance(StatusEffect.byRawId(15), 20, 0, false, false,
                    false);
            livingEntity_1.addStatusEffect(blind4);
            StatusEffectInstance strength4 = new StatusEffectInstance(StatusEffect.byRawId(5), 70, 0, false, false,
                    false);
            livingEntity_2.addStatusEffect(strength4);
            StatusEffectInstance defense4 = new StatusEffectInstance(StatusEffect.byRawId(11), 40, 0, false, false,
                    false);
            livingEntity_2.addStatusEffect(defense4);
            return true;
        default:
            return true;
        }

    }

}
