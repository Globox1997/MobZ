package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.Inits.Soundinit;
import net.mobz.Inits.Entityinit;

public class Boar3 extends PigEntity {
    private static final Ingredient BREEDING_INGREDIENT;

    public Boar3(EntityType<? extends PigEntity> entityType, World world) {
        super(entityType, world);
    }

    public boolean canBeControlledByRider() {
        return false;
    }

    public boolean canSpawn(WorldView viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && !this.world.isWater(entityPos);

    }

    protected SoundEvent getAmbientSound() {
        return Soundinit.BOARSAYEVENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return Soundinit.BOARSAYEVENT;
    }

    protected SoundEvent getDeathSound() {
        return Soundinit.BOARDEATHEVENT;
    }

    public boolean isSaddled() {
        return false;
    }

    public Boar3 method_6574(PassiveEntity passiveEntity_1) {
        return (Boar3) Entityinit.BOAR3.create(this.world);
    }

    public Boar3 createChild(PassiveEntity passiveEntity) {
        return (Boar3) Entityinit.BOAR3.create(this.world);
    }

    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_INGREDIENT.test(stack);
    }

    static {

        BREEDING_INGREDIENT = Ingredient.ofItems(Items.CARROT, Items.POTATO, Items.BEETROOT);
    }

}
