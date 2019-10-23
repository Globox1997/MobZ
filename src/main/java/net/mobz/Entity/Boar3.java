package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import net.mobz.glomod;

public class Boar3 extends PigEntity {
    private static final Ingredient BREEDING_INGREDIENT;

    public Boar3(EntityType<? extends PigEntity> entityType, World world) {
        super(entityType, world);
    }

    public boolean canBeControlledByRider() {
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return glomod.BOARSAYEVENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return glomod.BOARSAYEVENT;
    }

    protected SoundEvent getDeathSound() {
        return glomod.BOARDEATHEVENT;
    }

    public boolean isSaddled() {
        return false;
    }

    public Boar3 method_6574(PassiveEntity passiveEntity_1) {
        return (Boar3) glomod.BOAR3.create(this.world);
    }

    public boolean isBreedingItem(ItemStack itemStack_1) {
        return BREEDING_INGREDIENT.method_8093(itemStack_1);
    }

    // $FF: synthetic method
    public PassiveEntity createChild(PassiveEntity var1) {
        return this.method_6574(var1);
    }

    static {

        BREEDING_INGREDIENT = Ingredient.ofItems(Items.CARROT, Items.POTATO, Items.BEETROOT);
    }

}
