package net.mobz;

import net.minecraft.client.render.entity.model.IronGolemEntityModel;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class IceGolemRenderer extends MobEntityRenderer<IceGolem, IronGolemEntityModel<IceGolem>> {
    public IceGolemRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new IronGolemEntityModel(), 0.7F);
    }

    @Override
    protected Identifier getTexture(IceGolem ice) {
        return new Identifier("mobz:textures/entity/icegolem.png");
    }
}