package net.mobz.Items.Sword;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
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

public class VSwordBase extends SwordItem {
    public VSwordBase(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, -1, -2.4f, new Item.Settings());
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.mobz.v_sword.tooltip"));
    }

    StatusEffectInstance weakness = new StatusEffectInstance(StatusEffect.byRawId(18), 120, 0, false, false, false);

    public boolean postHit(ItemStack itemStack_1, LivingEntity livingEntity_1, LivingEntity livingEntity_2) {
        itemStack_1.damage(1, livingEntity_2, (p) -> p.sendToolBreakStatus(p.getActiveHand()));

        livingEntity_1.addStatusEffect(weakness);

        return true;
    }

}
