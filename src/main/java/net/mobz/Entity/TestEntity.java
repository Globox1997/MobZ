package net.mobz.Entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.world.World;

import net.minecraft.entity.mob.GhastEntity;

public class TestEntity extends ZombieEntity {
    private static final TrackedData<Boolean> SHOOTING;
   private int fireballStrength = 1;

    public TestEntity(EntityType<? extends ZombieEntity> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }

    protected void initGoals() {
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        
        this.initCustomGoals();
     }
  
     protected void initCustomGoals() {
        this.goalSelector.add(2, new ZombieAttackGoal(this, 1.0D, false));
        this.goalSelector.add(3, new TestEntity.ShootFireballGoal(this));
     }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(200.0D);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(44.0D);
        this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(2.0D);
    }

    protected void dropEquipment(DamageSource damageSource_1, int int_1, boolean boolean_1) {
        return;

    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(SHOOTING, false);
     }

    @Environment(EnvType.CLIENT)
    public boolean isShooting() {
       return (Boolean)this.dataTracker.get(SHOOTING);
    }
 
    public void setShooting(boolean shooting) {
       this.dataTracker.set(SHOOTING, shooting);
    }
 
    public int getFireballStrength() {
       return this.fireballStrength;
    }

    static {
        SHOOTING = DataTracker.registerData(TestEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
     }

    
   static class ShootFireballGoal extends Goal {
    private final TestEntity ghast;
    public int cooldown;

    public ShootFireballGoal(TestEntity ghast) {
       this.ghast = ghast;
    }

    public boolean canStart() {
       return this.ghast.getTarget() != null;
    }

    public void start() {
       this.cooldown = 0;
    }

    public void stop() {
       this.ghast.setShooting(false);
    } 

    public void tick() {
       LivingEntity livingEntity = this.ghast.getTarget();
       double d = 64.0D;
       if (livingEntity.squaredDistanceTo(this.ghast) < 4096.0D && this.ghast.canSee(livingEntity)) {
          World world = this.ghast.world;
          ++this.cooldown;
          if (this.cooldown == 10) {
             world.playLevelEvent((PlayerEntity)null, 1015, new BlockPos(this.ghast), 0);
          }

          if (this.cooldown == 20) {
             double e = 4.0D;
             Vec3d vec3d = this.ghast.getRotationVec(1.0F);
             double f = livingEntity.getX() - (this.ghast.getX() + vec3d.x * 4.0D);
             double g = livingEntity.getBodyY(0.5D) - (0.5D + this.ghast.getBodyY(0.5D));
             double h = livingEntity.getZ() - (this.ghast.getZ() + vec3d.z * 4.0D);
             world.playLevelEvent((PlayerEntity)null, 1016, new BlockPos(this.ghast), 0);
             FireballEntity fireballEntity = new FireballEntity(world, this.ghast, f, g, h);
             fireballEntity.explosionPower = this.ghast.getFireballStrength();
             fireballEntity.updatePosition(this.ghast.getX() + vec3d.x * 4.0D, this.ghast.getBodyY(0.5D) + 0.5D, fireballEntity.getZ() + vec3d.z * 4.0D);
             world.spawnEntity(fireballEntity);
             this.cooldown = -40;
          }
       } else if (this.cooldown > 0) {
          --this.cooldown;
       }

       this.ghast.setShooting(this.cooldown > 10);
    }
 }

}
