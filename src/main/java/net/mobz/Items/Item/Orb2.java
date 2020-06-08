package net.mobz.Items.Item;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Orb2 extends Item {
    private int sam = 0;

    public Orb2(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.mobz.orb2.tooltip"));
        tooltip.add(new TranslatableText("item.mobz.orb2.tooltip2"));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user instanceof PlayerEntity) {
            if (world.isClient) {
                if (sam == 0) {
                    sam++;
                    return TypedActionResult.success(user.getStackInHand(hand));
                } else {
                    return TypedActionResult.pass(user.getStackInHand(hand));
                }
            }
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        StatusEffectInstance lev = new StatusEffectInstance(StatusEffect.byRawId(25), 9, 1, false, false);
        LivingEntity bob = (LivingEntity) entity;
        PlayerEntity player = (PlayerEntity) bob;
        if (!world.isClient) {
            if (sam <= 160 && sam > 0 && selected == true) {
                bob.addStatusEffect(lev);
                sam++;
            } else {
                if (sam > 160) {
                    player.getItemCooldownManager().set(this, 80);
                    sam = -80;
                } else {
                    if (selected == false && sam >= 1) {
                        sam = sam - 1;
                    } else {
                        if (sam < 0) {
                            sam++;
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean hasEnchantmentGlint(ItemStack stack) {
        return true;
    }

}