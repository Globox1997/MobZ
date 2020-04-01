package net.mobz.Entity;

import net.mobz.Inits.Configinit;
import net.mobz.Config.configz;
import net.mobz.Inits.ArmorItems;
import net.mobz.Inits.SwordItems;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class BossEntity extends ZombieEntity {

    public BossEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 100;
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                .setBaseValue(400D * Configinit.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(30.0D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
                .setBaseValue(10D * Configinit.CONFIGZ.DamageMultiplicatorMob);
        this.getAttributeInstance(SPAWN_REINFORCEMENTS).setBaseValue(0.0D);
        this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(-4.0D);
    }

    public boolean isConvertingInWater() {
        return false;
    }

    protected boolean burnsInDaylight() {
        return false;
    }

    public boolean Damage(LivingEntity entity) {

        if (isGlowing() == true) {
            StatusEffectInstance wither = new StatusEffectInstance(StatusEffect.byRawId(20), 200, 2, false, false);
            this.addStatusEffect(wither);
        }
        ;
        return true;
    }

    public boolean isBaby() {
        return false;
    }

    protected void initEquipment(LocalDifficulty localDifficulty_1) {
        super.initEquipment(localDifficulty_1);
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.BossSword));
        this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
        this.equipStack(EquipmentSlot.CHEST, new ItemStack(ArmorItems.boss_chestplate));
        this.equipStack(EquipmentSlot.FEET, new ItemStack(ArmorItems.boss_boots));
        this.equipStack(EquipmentSlot.LEGS, new ItemStack(ArmorItems.boss_leggings));
        this.equipStack(EquipmentSlot.HEAD, new ItemStack(ArmorItems.boss_helmet));
    }

    protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
        return;
    }

    public boolean canImmediatelyDespawn(double double_1) {
        return false;
    }

    public boolean canSpawn(WorldView viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos lighto = new BlockPos(this.getX(), this.getY(), this.getZ());
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.containsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.isNight() && this.world.getLightLevel(lighto) <= 5 && !this.world.isWater(entityPos)
                && AutoConfig.getConfigHolder(configz.class).getConfig().BossZombieSpawn;

    }
}
