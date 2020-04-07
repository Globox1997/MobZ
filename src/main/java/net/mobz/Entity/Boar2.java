package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.World;
import net.mobz.Inits.Entityinit;

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
        return (Boar2) Entityinit.BOAR2.create(this.world);
    }

    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_INGREDIENT.test(stack);
    }

    public Boar2 createChild(PassiveEntity passiveEntity) {
        return (Boar2) Entityinit.BOAR2.create(this.world);
    }

    static {

        BREEDING_INGREDIENT = Ingredient.ofItems(Items.CARROT, Items.POTATO, Items.BEETROOT);
    }

}
