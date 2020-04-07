package net.mobz.Entity;

import net.minecraft.entity.mob.VindicatorEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
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
import net.mobz.Inits.Iteminit;
import net.mobz.Inits.Soundinit;
import net.mobz.Inits.SwordItems;

public class DwarfEntity extends VindicatorEntity {

    public DwarfEntity(EntityType<? extends VindicatorEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 20;
    }

    protected void initEquipment(LocalDifficulty localDifficulty_1) {
        super.initEquipment(localDifficulty_1);
        if (this.world.getDifficulty() != Difficulty.PEACEFUL) {
            this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.Axe));
            this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Iteminit.SHIELD));
        }
    }

    protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
        return;
    }

    protected SoundEvent getAmbientSound() {
        return Soundinit.NOTHINGEVENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(16.0D);
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                .setBaseValue(Configinit.CONFIGZ.DwarfLife * Configinit.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
                .setBaseValue(Configinit.CONFIGZ.DwarfAttack * Configinit.CONFIGZ.DamageMultiplicatorMob);
    }

    public boolean canSpawn(WorldView view) {
        BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
        return view.intersectsEntities(this)
                && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.getLightLevel(posentity) <= 10 && posentity.getY() < view.getSeaLevel() - 10
                && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
                && this.world.getBlockState(blockunderentity).getBlock().allowsSpawning(
                        world.getBlockState(blockunderentity), view, blockunderentity, Entityinit.DWARFENTITY)
                && AutoConfig.getConfigHolder(configz.class).getConfig().DwarfSpawn;

    }
}
