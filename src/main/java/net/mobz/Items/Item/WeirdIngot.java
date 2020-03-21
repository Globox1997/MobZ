package net.mobz.Items.Item;

import java.util.List;
import java.util.Random;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class WeirdIngot extends Item {

    int bb;
    int aa;

    public WeirdIngot(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.mobz.weird_ingot.tooltip"));
    }

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        StatusEffectInstance slow = new StatusEffectInstance(StatusEffect.byRawId(2), 0, 0, false, false);
        StatusEffectInstance gain = new StatusEffectInstance(StatusEffect.byRawId(22), 0, 1, false, false);
        LivingEntity bob = (LivingEntity) entity;
        Random random = new Random();
        Random random2 = new Random();
        Random random3 = new Random();
        double z1 = (random.nextInt() % 50);
        double z2 = z1 / 100;
        double z3 = random2.nextInt() % 50;
        double z4 = z3 / 100;
        double z5 = random3.nextInt() % 180;
        double z6 = z5 / 100;
        if (selected == true) {
            bob.addStatusEffect(slow);
            bob.addStatusEffect(gain);
            world.addParticle(ParticleTypes.DRAGON_BREATH, bob.getX() + z2, bob.getY() + z6, bob.getZ() + z4, 0.0D,
                    0.0D, 0.0D);
                 
        }

    }

}