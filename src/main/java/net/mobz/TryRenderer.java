package net.mobz;


import net.minecraft.client.render.entity.model.StrayEntityModel;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;

import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class TryRenderer extends BipedEntityRenderer<Try, StrayEntityModel<Try>> {

    public TryRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new StrayEntityModel(), 0.0F);
    }

    @Override
    protected Identifier getTexture(Try Trye) {
        return new Identifier("mobz:textures/entity/try.png");
    }
}