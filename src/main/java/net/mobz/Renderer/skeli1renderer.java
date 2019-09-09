package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.minecraft.client.render.entity.model.StrayEntityModel;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class skeli1renderer extends BipedEntityRenderer<skeli1, StrayEntityModel<skeli1>> {

    public skeli1renderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new StrayEntityModel(), 0.5F);
    }

    @Override
    protected Identifier getTexture(skeli1 skeliiiiii) {
        return new Identifier("mobz:textures/entity/skeli1.png");
    }
}