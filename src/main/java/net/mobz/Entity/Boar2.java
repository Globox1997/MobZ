package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.mobz.Inits.Entityinit;

public class Boar2 extends PigEntity {
    private static final Ingredient BREEDING_INGREDIENT;

    public Boar2(EntityType<? extends PigEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createBoar2Attributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 16.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D);
    }

    @Override
    public boolean canBeControlledByRider() {
        return false;
    }

    @Override
    public boolean isSaddled() {
        return false;
    }

    public Boar2 method_6574(PassiveEntity passiveEntity_1) {
        return (Boar2) Entityinit.BOAR2.create(this.world);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_INGREDIENT.test(stack);
    }

    @Override
	public Boar2 createChild(ServerWorld world, PassiveEntity passiveEntity) {
        return (Boar2) Entityinit.BOAR2.create(this.world);
    }

    static {

        BREEDING_INGREDIENT = Ingredient.ofItems(Items.CARROT, Items.POTATO, Items.BEETROOT);
    }

}
