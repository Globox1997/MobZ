package net.mobz.Entity;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.PounceAtTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mobz.Config.configz;
import net.mobz.Entity.Attack.WolfAttack;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Inits.Soundinit;

public class Dog extends WolfEntity {

    public Dog(EntityType<? extends WolfEntity> entityType, World world) {
        super(entityType, world);
    }

    // @Override
    // protected void initGoals() {
    // this.goalSelector.add(1, new SwimGoal(this));
    // this.goalSelector.add(3, new PounceAtTargetGoal(this, 0.4F));
    // this.goalSelector.add(2, new WolfAttack(this, 1.0D, false));
    // this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D));
    // this.goalSelector.add(10, new LookAtEntityGoal(this, PlayerEntity.class,
    // 8.0F));
    // this.goalSelector.add(10, new LookAroundGoal(this));
    // }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                .setBaseValue(Configinit.CONFIGZ.NetherWolfLife * Configinit.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
                .setBaseValue(Configinit.CONFIGZ.NetherWolfAttack * Configinit.CONFIGZ.DamageMultiplicatorMob);
    }

    @Override
    public boolean isBreedingItem(ItemStack itemStack_1) {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return Soundinit.WGROWLEVENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return Soundinit.WHURTEVENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return Soundinit.WDEATHEVENT;
    }

    @Override
    public boolean canSpawn(WorldView view) {
        BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
        return view.intersectsEntities(this)
                && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.getLightLevel(posentity) <= 10
                && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
                && this.world.getBlockState(blockunderentity).getBlock()
                        .allowsSpawning(world.getBlockState(blockunderentity), view, blockunderentity, Entityinit.DOG)
                && AutoConfig.getConfigHolder(configz.class).getConfig().NetherWolfSpawn;

    }
}
