package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import net.minecraft.client.render.entity.EvokerIllagerEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class IllusionerRenderer extends EvokerIllagerEntityRenderer<Illusioner> {

    public IllusionerRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public Identifier getTexture(Illusioner illusioner) {
        return new Identifier("mobz:textures/entity/illusioner.png");
    }

}