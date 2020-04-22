package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class skeli1renderer extends BipedEntityRenderer<skeli1, SkeletonEntityModel<skeli1>> {

    public skeli1renderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new SkeletonEntityModel<>(), 0.5F);
    }

    @Override
    public Identifier getTexture(skeli1 skeliiiiii) {
        return new Identifier("mobz:textures/entity/skeli1.png");
    }
}