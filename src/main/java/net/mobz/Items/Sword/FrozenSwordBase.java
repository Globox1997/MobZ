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

public class FrozenSwordBase extends SwordItem {
    public FrozenSwordBase(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, 1, -2.4f, new Item.Settings());
    }

    StatusEffectInstance slow1 = new StatusEffectInstance(StatusEffect.byRawId(2), 50, 1, false, false, false);
    StatusEffectInstance slow3 = new StatusEffectInstance(StatusEffect.byRawId(2), 100, 1, false, false, false);
    StatusEffectInstance slow4 = new StatusEffectInstance(StatusEffect.byRawId(2), 150, 1, false, false, false);

    public boolean postHit(ItemStack itemStack_1, LivingEntity livingEntity_1, LivingEntity livingEntity_2) {
        itemStack_1.damage(1, (LivingEntity) livingEntity_2, (Consumer) ((livingEntity_1x) -> {
            ((LivingEntity) livingEntity_1x).sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        }));

        Random random = new Random();
        int randomNumber = random.nextInt() % 3;
        if (randomNumber < 0) {
            randomNumber = randomNumber * (-1);
        }

        switch (randomNumber) {
            case 0:

                livingEntity_1.addStatusEffect(slow1);
                return true;
            case 1:

                livingEntity_1.addStatusEffect(slow3);
                return true;
            case 2:

                livingEntity_1.addStatusEffect(slow4);
                return true;
            default:
                return true;
        }
    }

}
