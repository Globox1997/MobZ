package net.mobz.Items;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class WeirdIngot extends Item {
    public WeirdIngot(Settings settings) {
        super(settings);
    }
 
    public ActionResult useOnBlock(ItemUsageContext itemUsageContext_1, PlayerEntity player) {
        StatusEffectInstance defense = new StatusEffectInstance(StatusEffect.byRawId(19), 30, 0, false, false, false);
        player.addPotionEffect(defense);
        return ActionResult.PASS;
     }
     @Override
     public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
         tooltip.add(new TranslatableText("item.mobz.weird_ingot.tooltip"));
     }

}