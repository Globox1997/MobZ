package net.mobz.Items.Item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Orb2 extends Item {
    public Orb2(Settings settings) {
        super(settings);
    }

    int sam = 0;
    StatusEffectInstance lev = new StatusEffectInstance(StatusEffect.byRawId(25), 1, 0, false, false);

    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        LivingEntity bob = (LivingEntity) entity;

        if (sam <= 200 && selected == true) {
            bob.addStatusEffect(lev);
            sam++;
        } else {
            if (sam > 200 && sam < 300) {
                sam++;
            } else {
                if (sam == 300) {
                    sam = 0;
                } else {
                    if (selected == false && sam >= 1) {
                        sam = sam - 2;
                    } else {
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