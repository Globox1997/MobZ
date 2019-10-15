package net.mobz.Renderer.Model.TestModels;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.mob.ZombieEntity;

@Environment(EnvType.CLIENT)
public class EntityModel<T extends ZombieEntity> extends AbstractModel<T> {
    public EntityModel() {
        this(0.0F, false);
    }

    public EntityModel(float float_1, boolean boolean_1) {
        super(float_1, 0.0F, 64, boolean_1 ? 32 : 64);
    }

    protected EntityModel(float float_1, float float_2, int int_1, int int_2) {
        super(float_1, float_2, int_1, int_2);
    }

    public boolean method_17793(T zombieEntity_1) {
        return zombieEntity_1.isAttacking();
    }

    public boolean method_17790(T var1) {
        // TODO Auto-generated method stub
        return false;
    }
}
