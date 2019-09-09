package net.mobz.Items;

import net.mobz.glomod;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import java.util.List;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;

public class BossIngot extends Item {
    public BossIngot(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasEnchantmentGlint(ItemStack stack) {
        return stack.getItem() == glomod.BOSSBARREN;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.mobz.boss_ingot.tooltip"));
    }
}