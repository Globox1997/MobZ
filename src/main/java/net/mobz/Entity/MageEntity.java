package net.mobz.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.mob.EvokerEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;

public class MageEntity extends EvokerEntity {

    public MageEntity(EntityType<? extends EvokerEntity> entityType, World world) {
        super(entityType, world);

    }

    public boolean canSpawn(ViewableWorld viewableWorld_1) {
        BlockPos entityPos = new BlockPos(this.x, this.y - 1, this.z);
        return viewableWorld_1.intersectsEntities(this) && !viewableWorld_1.intersectsFluid(this.getBoundingBox())
                && !viewableWorld_1.isAir(entityPos)
                && this.world.getLocalDifficulty(entityPos).getGlobalDifficulty() != Difficulty.PEACEFUL
                && this.world.isDaylight();
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[]{Knight2Entity.class})).setGroupRevenge());
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[]{PassiveEntity.class})).setGroupRevenge());
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[]{KnightEntity.class})).setGroupRevenge());

     }
}
