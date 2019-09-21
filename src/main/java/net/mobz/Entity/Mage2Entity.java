package net.mobz.Entity;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.mob.EvokerEntity;
import net.minecraft.entity.mob.SpellcastingIllagerEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;
import net.mobz.glomod;

public class Mage2Entity extends EvokerEntity {

    public Mage2Entity(EntityType<? extends EvokerEntity> entityType, World world) {
        super(entityType, world);

    }
    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(4, new Mage2Entity.SummonZombieGoal());
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[]{PassiveEntity.class})).setGroupRevenge());

     }

    public boolean canSpawn(ViewableWorld viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.x, this.y - 1, this.z);
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.intersectsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.isDaylight();
    }

     class SummonZombieGoal extends SpellcastingIllagerEntity.CastSpellGoal {
        private final TargetPredicate zombiepredicate;
  
        private SummonZombieGoal() {
           super();
           this.zombiepredicate = (new TargetPredicate()).setBaseMaxDistance(16.0D).includeHidden().ignoreDistanceScalingFactor().includeInvulnerable().includeTeammates();
        }
  
        public boolean canStart() {
           if (!super.canStart()) {
              return false;
           } else {
              int int_1 = Mage2Entity.this.world.getTargets(SmallZombie.class, this.zombiepredicate, Mage2Entity.this, Mage2Entity.this.getBoundingBox().expand(16.0D)).size();
              return Mage2Entity.this.random.nextInt(8) + 1 > int_1;
           }
        }
  
        protected int getSpellTicks() {
           return 100;
        }
  
        protected int startTimeDelay() {
           return 340;
        }
  
        protected void castSpell() {
           for(int int_1 = 0; int_1 < 3; ++int_1) {
              BlockPos blockPos_1 = (new BlockPos(Mage2Entity.this)).add(-2 + Mage2Entity.this.random.nextInt(5), 1, -2 + Mage2Entity.this.random.nextInt(5));
              SmallZombie SmallZombie_1 = (SmallZombie)glomod.SMALLZOMBIE.create(Mage2Entity.this.world);
              SmallZombie_1.setPositionAndAngles(blockPos_1, 0.0F, 0.0F);
              SmallZombie_1.initialize(Mage2Entity.this.world, Mage2Entity.this.world.getLocalDifficulty(blockPos_1), SpawnType.MOB_SUMMONED, (EntityData)null, (CompoundTag)null);


             // vexEntity_1.setOwner(EvokerEntity.this);
              // vexEntity_1.setBounds(blockPos_1);
              SmallZombie_1.setLifeTicks(20 * (30 + Mage2Entity.this.random.nextInt(90)));

              Mage2Entity.this.world.spawnEntity(SmallZombie_1);
           }
  
        }
  
        protected SoundEvent getSoundPrepare() {
           return SoundEvents.ENTITY_EVOKER_PREPARE_SUMMON;
        }
  
        protected SpellcastingIllagerEntity.Spell getSpell() {
           return SpellcastingIllagerEntity.Spell.SUMMON_VEX;
        }
  
        SummonZombieGoal(Object evokerEntity$1_1) {
           this();
        }
     }

     
    
}
