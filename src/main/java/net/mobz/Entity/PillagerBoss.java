package net.mobz.Entity;

import java.util.Map;
import java.util.Random;

import com.google.common.collect.Maps;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.mobz.Inits.Configinit;
import net.mobz.Inits.Entityinit;
import net.minecraft.item.ElytraItem;
import net.minecraft.entity.mob.GhastEntity;
public class PillagerBoss extends PillagerEntity {
    private int cooldown = 0;
    private int cooldown2 = 0;
    private int show = 0;
    private final int requiredcooldown = 120;

    public PillagerBoss(EntityType<PillagerBoss> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 9.0F));
        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        this.targetSelector.add(2, new FollowTargetGoal(this, PlayerEntity.class, false));
      //  this.targetSelector.add(1, new RevengeGoal(this, new Class[] { SmallZombie.class }).setGroupRevenge());
    }

    protected void initEquipment(LocalDifficulty difficulty) {
        ItemStack itemStack = new ItemStack(Items.CROSSBOW);
        ItemStack itemStack2 = new ItemStack(Items.STICK);
        
           Map<Enchantment, Integer> map = Maps.newHashMap();
           map.put(Enchantments.PUNCH, 1);
           EnchantmentHelper.set(map, itemStack);
        
  
        this.equipStack(EquipmentSlot.MAINHAND, itemStack);
        this.equipStack(EquipmentSlot.OFFHAND, itemStack2);
     }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                .setBaseValue(200D * Configinit.CONFIGZ.LifeMultiplicatorMob);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        this.getAttributeInstance(EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
        this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)
                .setBaseValue(1 * Configinit.CONFIGZ.DamageMultiplicatorMob);
    }

    

    @Override

    protected void mobTick() {
        World world = this.world;
        PillagerBoss boss = this;
        StatusEffectInstance slow = new StatusEffectInstance(StatusEffect.byRawId(2), 80, 0, false, false);
        StatusEffectInstance blend = new StatusEffectInstance(StatusEffect.byRawId(15), 20, 0, false, false);
        if (getTarget() != null && !world.isClient && squaredDistanceTo(getTarget()) < 4096D && canSee(getTarget())) {
            cooldown2++;
            cooldown++;
            if (cooldown >= requiredcooldown) {
                cooldown = 0;
                attack(getTarget(), 1);
          /*      LivingEntity target = boss.getTarget();
                Vec3d vec3d = boss.getRotationVec(1.0F);
                //    World world = this.world;
                    double i = target.getX() - (boss.getX() + vec3d.x * 4.0D);
                    double g = target.getBodyY(0.5D) - (0.5D + boss.getBodyY(0.5D));
                    double h = target.getZ() - (boss.getZ() + vec3d.z * 4.0D);
                    WitherSkullEntity fireballEntity = new WitherSkullEntity(world, target, i, g, h);
                  //  fireballEntity.explosionPower = 0;
                    fireballEntity.updatePosition(boss.getX() + vec3d.x * 4.0D, boss.getBodyY(0.5D) + 0.5D,
                            fireballEntity.getZ() + vec3d.z * 4.0D);
                    world.spawnEntity(fireballEntity);*/
            }
            if (cooldown2 >= 200) {

                getTarget().addStatusEffect(slow);
                shower();
                cooldown2 = 0;
            }

        } else {
            cooldown = 0;
            cooldown2 = 0;
        }

    }

    public void shower() {
        World world = this.world;
        Random random = new Random();
        Random random2 = new Random();
        Random random3 = new Random();
        double z1 = (random.nextInt() % 190);
        double z2 = z1 / 100;
        double z3 = random2.nextInt() % 190;
        double z4 = z3 / 100;
        double z5 = random3.nextInt() % 190;
        double z6 = z5 / 100;
        while (show < 40) {

            world.addParticle(ParticleTypes.FLAME, this.getTarget().getX() + z2, this.getTarget().getY() + z4,
                    this.getTarget().getZ() + z6, 0.0D, 0.0D, 0.0D);
                    show++;
        }
        
    }

    @Override
    public boolean cannotDespawn() {
        return true;
    }

    @Override
    public void attack(LivingEntity target, float f) {
        shower();
        Vec3d vec3d_1 = this.getRotationVec(1.0F);
        double double_3 = target.getX() - (this.getX() + vec3d_1.x * 4.0D);
        double double_4 = target.getBoundingBox().getYLength() + (double)(target.getHeight() / 2.0F) - (0.5D + this.getY() + (double)(this.getHeight() / 2.0F));
        double double_5 = target.getZ() - (this.getZ() + vec3d_1.z * 4.0D);
        WitherSkullEntity fireballEntity_1 = new WitherSkullEntity(world, this, double_3, double_4, double_5);
       // fireballEntity_1.explosionPower = 1;
        double double_6 = this.getX() + vec3d_1.x * 4.0D;
        double double_7 = this.getY() + (double)(this.getHeight() / 2.0F) - 0.5D;
        double double_8 = this.getZ() + vec3d_1.z * 4.0D;
        fireballEntity_1.updatePosition(double_6, double_7, double_8);
        world.spawnEntity(fireballEntity_1);
      
       

/*
        Vec3d vec3d = this.boss.getRotationVec(1.0F);
    //    World world = this.world;
        double i = target.getX() - (this.boss.getX() + vec3d.x * 4.0D);
        double g = target.getBodyY(0.5D) - (0.5D + this.boss.getBodyY(0.5D));
        double h = target.getZ() - (this.boss.getZ() + vec3d.z * 4.0D);
        WitherSkullEntity fireballEntity = new WitherSkullEntity(world, target, i, g, h);
      //  fireballEntity.explosionPower = 0;
        fireballEntity.updatePosition(this.boss.getX() + vec3d.x * 4.0D, this.boss.getBodyY(0.5D) + 0.5D,
                fireballEntity.getZ() + vec3d.z * 4.0D);
        world.spawnEntity(fireballEntity);
      

        
/*
        BlockPos blockPos = (new BlockPos(PillagerBoss.this)).add(-2 + PillagerBoss.this.random.nextInt(5), 1,
                -2 + PillagerBoss.this.random.nextInt(5));
        SmallZombie SmallZombie = (SmallZombie) Entityinit.SMALLZOMBIE.create(PillagerBoss.this.world);
        SmallZombie.refreshPositionAndAngles(blockPos, 0.0F, 0.0F);
        SmallZombie.initialize(PillagerBoss.this.world, PillagerBoss.this.world.getLocalDifficulty(blockPos),
                SpawnType.MOB_SUMMONED, (EntityData) null, (CompoundTag) null);
        SmallZombie.setBounds(blockPos);
        SmallZombie.setLifeTicks(20 * (30 + PillagerBoss.this.random.nextInt(90)));
        PillagerBoss.this.world.spawnEntity(SmallZombie); */

    }

}
