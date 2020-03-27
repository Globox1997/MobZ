package net.mobz.Items.Item;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class Orb extends Item {
    public Orb(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.mobz.orb.tooltip"));
    }

    StatusEffectInstance life = new StatusEffectInstance(StatusEffect.byRawId(8), 20, 1, false, false);

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        LivingEntity bob = (LivingEntity) entity;
        if (slot == 0 || slot == 1 || slot == 2 || slot == 3 || slot == 4 || slot == 5 || slot == 6 || slot == 7
                || slot == 8) {

            bob.addStatusEffect(life);
        }

    }

    @Override
    public boolean hasEnchantmentGlint(ItemStack stack) {
        return true;
    }

}