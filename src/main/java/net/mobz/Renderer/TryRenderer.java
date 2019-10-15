package net.mobz.Renderer;

import net.mobz.Entity.*;
import net.mobz.Renderer.Model.TestModels.*;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import net.minecraft.client.render.entity.EvokerIllagerEntityRenderer;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class TryRenderer extends BipedEntityRenderer1<Try, EntityModel<Try>> {

    public TryRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new EntityModel<>(),1.0F);
    }

    @Override
    protected Identifier getTexture(Try trye) {
        return new Identifier("mobz:textures/entity/try.png");
    }

}