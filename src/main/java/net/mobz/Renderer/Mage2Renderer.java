package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import net.minecraft.client.render.entity.EvokerEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class Mage2Renderer extends EvokerEntityRenderer<Mage2Entity> {

    public Mage2Renderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public Identifier getTexture(Mage2Entity mageent) {
        return new Identifier("mobz:textures/entity/mage2entity.png");
    }
}