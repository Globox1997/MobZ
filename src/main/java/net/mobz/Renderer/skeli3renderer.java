package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class skeli3renderer extends BipedEntityRenderer<skeli3, SkeletonEntityModel<skeli3>> {

    public skeli3renderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new SkeletonEntityModel<>(), 0.5F);
    }

    @Override
    public Identifier getTexture(skeli3 skeliiii) {
        return new Identifier("mobz:textures/entity/skeli3.png");
    }
}