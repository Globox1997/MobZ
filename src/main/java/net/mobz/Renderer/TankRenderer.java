package net.mobz;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class TankRenderer extends BipedEntityRenderer<TankEntity, ZombieEntityModel<TankEntity>> {

    public TankRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new ZombieEntityModel<>(), 0.5F);

    }

    @Override
    protected Identifier getTexture(TankEntity tankEntity) {
        return new Identifier("mobz:textures/entity/tank.png");
    }

}