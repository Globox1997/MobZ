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

public class WitherSwordBase extends SwordItem {
    public WitherSwordBase(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, 1, -2.4f, new Item.Settings().group(glomod.MOBZ_GROUP));
    }

    public boolean postHit(ItemStack itemStack_1, LivingEntity livingEntity_1, LivingEntity livingEntity_2) {
        Random random = new Random();
        int randomNumber = random.nextInt() % 2;
        itemStack_1.damage(1, (LivingEntity) livingEntity_2, (Consumer) ((livingEntity_1x) -> {
            ((LivingEntity) livingEntity_1x).sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        }));
        switch (randomNumber) {
        case 0:
            StatusEffectInstance slow1 = new StatusEffectInstance(StatusEffect.byRawId(20), 60, 0, false, false, false);
            livingEntity_1.addStatusEffect(slow1);
            return true;
        case 1:
            StatusEffectInstance slow2 = new StatusEffectInstance(StatusEffect.byRawId(20), 80, 0, false, false, false);
            livingEntity_1.addStatusEffect(slow2);
            return true;
        case 2:
            StatusEffectInstance slow3 = new StatusEffectInstance(StatusEffect.byRawId(20), 100, 0, false, false,
                    false);
            livingEntity_1.addStatusEffect(slow3);
            return true;
        default:
            return true;
        }
    }

}
