package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import net.minecraft.client.render.entity.EvokerIllagerEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class TryRenderer extends EvokerIllagerEntityRenderer<Try> {

    public TryRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    protected Identifier getTexture(Try trye) {
        return new Identifier("mobz:textures/entity/try.png");
    }

}