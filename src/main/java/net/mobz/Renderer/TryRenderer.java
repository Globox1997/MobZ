package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;

import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class TryRenderer extends BipedEntityRenderer<Try, PlayerEntityModel<Try>> {

    public TryRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new PlayerEntityModel(0.0F, true), 0.0F);
    }

    @Override
    protected Identifier getTexture(Try Trye) {
        return new Identifier("mobz:textures/entity/try.png");
    }
}