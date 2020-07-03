package net.mobz.Items.Sword;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class WitherSwordBase extends SwordItem {
    public WitherSwordBase(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, 1, -2.4f, new Item.Settings());
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.mobz.wither_sword.tooltip"));
    }

    StatusEffectInstance with1 = new StatusEffectInstance(StatusEffect.byRawId(20), 60, 0, false, false, false);
    StatusEffectInstance with2 = new StatusEffectInstance(StatusEffect.byRawId(20), 120, 0, false, false, false);
    StatusEffectInstance with3 = new StatusEffectInstance(StatusEffect.byRawId(20), 180, 0, false, false, false);
    StatusEffectInstance with4 = new StatusEffectInstance(StatusEffect.byRawId(20), 240, 0, false, false, false);

    @Override
    public boolean postHit(ItemStack itemStack_1, LivingEntity livingEntity_1, LivingEntity livingEntity_2) {
        itemStack_1.damage(1, (LivingEntity) livingEntity_2, (Consumer) ((livingEntity_1x) -> {
            ((LivingEntity) livingEntity_1x).sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        }));

        Random random = new Random();
        int randomNumber = random.nextInt() % 4;
        if (randomNumber < 0) {
            randomNumber = randomNumber * (-1);
        }

        switch (randomNumber) {
            case 0:
                livingEntity_1.addStatusEffect(with1);
                return true;
            case 1:
                livingEntity_1.addStatusEffect(with2);
                return true;
            case 2:
                livingEntity_1.addStatusEffect(with3);
                return true;
            case 3:
                livingEntity_1.addStatusEffect(with4);
                return true;
            default:
                return true;
        }
    }

}
