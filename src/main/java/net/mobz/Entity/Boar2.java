package net.mobz.Entity;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.Config.configz;
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

    public boolean canSpawn(WorldView viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos) && !this.world.isWater(entityPos)
                && AutoConfig.getConfigHolder(configz.class).getConfig().BoarSpawn;

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
