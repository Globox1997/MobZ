package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.minecraft.client.render.entity.model.StrayEntityModel;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class skeli2renderer extends BipedEntityRenderer<skeli2, StrayEntityModel<skeli2>> {

    public skeli2renderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new StrayEntityModel(), 0.5F);
    }

    @Override
    protected Identifier getTexture(skeli2 skeliii) {
        return new Identifier("mobz:textures/entity/skeli2.png");
    }
}