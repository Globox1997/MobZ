package net.mobz.Items.Item;

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
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.mobz.boss_ingot.tooltip"));
    }
}