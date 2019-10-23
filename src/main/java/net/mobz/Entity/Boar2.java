package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.World;
import net.mobz.glomod;

public class Boar2 extends PigEntity {
    private static final Ingredient BREEDING_INGREDIENT;

    public Boar2(EntityType<? extends PigEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(16.0D);
    }

    public boolean canBeControlledByRider() {
        return false;
    }

    public boolean isSaddled() {
        return false;
    }

    public Boar2 method_6574(PassiveEntity passiveEntity_1) {
        return (Boar2) glomod.BOAR2.create(this.world);
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
