package net.mobz.Entity;

import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.mobz.Config.configz;
import net.mobz.Inits.ArmorItems;
import net.mobz.Inits.SwordItems;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.entity.Entity;
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
        this.experiencePoints = 60;
    }

    @Override
    public boolean canPickUpLoot() {
        return false;
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                .setBaseValue(Configinit.CONFIGZ.BossZombieLife * Configinit.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(4.0D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
                .setBaseValue(Configinit.CONFIGZ.BossZombieAttack * Configinit.CONFIGZ.DamageMultiplicatorMob);
        this.getAttributeInstance(SPAWN_REINFORCEMENTS).setBaseValue(0.0D);
        this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(-4.0D);
        this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(36.0D);
    }

    @Override
    public boolean isConvertingInWater() {
        return false;
    }

    @Override
    protected boolean burnsInDaylight() {
        return false;
    }

    @Override
    public boolean isBaby() {
        return false;
    }

    @Override
    protected void initEquipment(LocalDifficulty localDifficulty_1) {
        super.initEquipment(localDifficulty_1);
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(SwordItems.BossSword));
        this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
        this.equipStack(EquipmentSlot.CHEST, new ItemStack(ArmorItems.boss_chestplate));
        this.equipStack(EquipmentSlot.FEET, new ItemStack(ArmorItems.boss_boots));
        this.equipStack(EquipmentSlot.LEGS, new ItemStack(ArmorItems.boss_leggings));
        this.equipStack(EquipmentSlot.HEAD, new ItemStack(ArmorItems.boss_helmet));
    }

    @Override
    protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
        return;
    }

    @Override
    public boolean canImmediatelyDespawn(double double_1) {
        return false;
    }

    @Override
    public boolean canSpawn(WorldView view) {
        BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
        return view.intersectsEntities(this) && this.world.isNight()
                && this.world.getLocalDifficulty(posentity).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.getLightLevel(posentity) <= 5
                && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
                && this.world.getBlockState(blockunderentity).getBlock()
                        .allowsSpawning(world.getBlockState(blockunderentity), view, blockunderentity, Entityinit.BOSS)
                && AutoConfig.getConfigHolder(configz.class).getConfig().BossZombieSpawn;
    }

    @Override
    protected void dealDamage(LivingEntity attacker, Entity target) {
        LivingEntity bob = (LivingEntity) target;
        StatusEffectInstance fatigue = new StatusEffectInstance(StatusEffect.byRawId(4), 120, 0, false, false);
        if (target instanceof LivingEntity) {
            bob.addStatusEffect(fatigue);
        }
    }
}
