package net.mobz.Renderer;

import net.mobz.Entity.*;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.BlazeEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class FrostRenderer extends MobEntityRenderer<FrostEntity, BlazeEntityModel<FrostEntity>> {

    public FrostRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new BlazeEntityModel<>(), 0.5F);
    }

    @Override
    public Identifier getTexture(FrostEntity frostentity) {
        return new Identifier("mobz:textures/entity/frost.png");
    }

}
