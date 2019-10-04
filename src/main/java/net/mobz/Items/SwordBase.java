package net.mobz.Items;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import net.mobz.glomod;

public class SwordBase extends SwordItem {
    public SwordBase(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, 100, -2.4f, new Item.Settings().group(glomod.MOBZ_GROUP));
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.mobz.sword.tooltip"));
    }
}
