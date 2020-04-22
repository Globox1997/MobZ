package net.mobz.Entity;

import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.Config.configz;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.Soundinit;
import net.mobz.Inits.SwordItems;

public class skeli4 extends SkeletonEntity {

    public skeli4(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                .setBaseValue(Configinit.CONFIGZ.LostSkeletonLife * Configinit.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(1.0D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
                .setBaseValue(Configinit.CONFIGZ.LostSkeletonAttack * Configinit.CONFIGZ.DamageMultiplicatorMob);
    }

    @Override
    protected void initEquipment(LocalDifficulty difficulty) {
        super.initEquipment(difficulty);
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.VSword));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return Soundinit.SKELASAYEVENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return Soundinit.SKELAHURTEVENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return Soundinit.SKELADEATHEVENT;
    }

    protected SoundEvent getStepSound() {
        return Soundinit.SKELASTEPEVENT;
    }

    @Override
    public boolean canSpawn(WorldView view) {
        BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
        return view.intersectsEntities(this)
                && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.getLightLevel(posentity) <= 7
                && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
                && this.world.getBlockState(blockunderentity).getBlock().allowsSpawning(
                        world.getBlockState(blockunderentity), view, blockunderentity, Entityinit.SKELI4)
                && AutoConfig.getConfigHolder(configz.class).getConfig().LostSkeletonSpawn;

    }
}