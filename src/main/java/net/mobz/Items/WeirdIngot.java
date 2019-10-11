package net.mobz.Items;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WeirdIngot extends Item {
    public WeirdIngot(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.mobz.weird_ingot.tooltip"));
    }

    public TypedActionResult<ItemStack> use(World world_1, PlayerEntity playerEntity_1, Hand hand_1) {

        ItemStack itemStack_1 = playerEntity_1.getStackInHand(hand_1);
        if (playerEntity_1.isHandSwinging) {
            playerEntity_1.setCurrentHand(hand_1);
            StatusEffectInstance defense = new StatusEffectInstance(StatusEffect.byRawId(9), 200, 0, true, false,
                    false);
            playerEntity_1.addPotionEffect(defense);
            return new TypedActionResult(ActionResult.SUCCESS, itemStack_1);
        } else {
            StatusEffectInstance defense = new StatusEffectInstance(StatusEffect.byRawId(9), 200, 0, true, false,
                    false);
            playerEntity_1.addPotionEffect(defense);
            return new TypedActionResult(ActionResult.FAIL, itemStack_1);
        }

    }

}