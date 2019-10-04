package net.mobz.Items;

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

public class PoisonSwordBase extends SwordItem {
    public PoisonSwordBase(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, 1, -2.4f, new Item.Settings().group(glomod.MOBZ_GROUP));
    }

    public boolean postHit(ItemStack itemStack_1, LivingEntity livingEntity_1, LivingEntity livingEntity_2) {
        itemStack_1.damage(1, (LivingEntity) livingEntity_2, (Consumer) ((livingEntity_1x) -> {
            ((LivingEntity) livingEntity_1x).sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        }));
        StatusEffectInstance slowness = new StatusEffectInstance(StatusEffect.byRawId(19), 100, 0, false, false, false);
        livingEntity_1.addPotionEffect(slowness);

        return true;
    }

}
