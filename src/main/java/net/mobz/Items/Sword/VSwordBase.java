package net.mobz.Items.Sword;

import java.util.function.Consumer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class VSwordBase extends SwordItem {
    public VSwordBase(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, -1, -2.4f, new Item.Settings());
    }

    StatusEffectInstance weakness = new StatusEffectInstance(StatusEffect.byRawId(18), 120, 0, false, false, false);

    public boolean postHit(ItemStack itemStack_1, LivingEntity livingEntity_1, LivingEntity livingEntity_2) {
        itemStack_1.damage(1, (LivingEntity) livingEntity_2, (Consumer) ((livingEntity_1x) -> {
            ((LivingEntity) livingEntity_1x).sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        }));

        livingEntity_1.addStatusEffect(weakness);

        return true;
    }

}
