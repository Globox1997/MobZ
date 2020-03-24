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

public class PoisonSwordBase extends SwordItem {
    public PoisonSwordBase(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, 1, -2.4f, new Item.Settings());
    }

    StatusEffectInstance pois1 = new StatusEffectInstance(StatusEffect.byRawId(19), 80, 0, false, false, false);
    StatusEffectInstance pois2 = new StatusEffectInstance(StatusEffect.byRawId(19), 160, 0, false, false, false);
    StatusEffectInstance pois3 = new StatusEffectInstance(StatusEffect.byRawId(19), 200, 0, false, false, false);

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

                livingEntity_1.addStatusEffect(pois1);
                return true;
            case 1:

                livingEntity_1.addStatusEffect(pois2);
                return true;
            case 2:

                livingEntity_1.addStatusEffect(pois3);
                return true;
            default:
                return true;
        }

    }

}
