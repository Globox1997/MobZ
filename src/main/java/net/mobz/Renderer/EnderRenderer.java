package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EndermanEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class EnderRenderer extends MobEntityRenderer<EnderEntity, EndermanEntityModel<EnderEntity>> {
    public EnderRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new EndermanEntityModel(0.0F), 0.5F);
    }

    @Override
    protected Identifier getTexture(EnderEntity enderEntity) {
        return new Identifier("mobz:textures/entity/ender.png");
    }
}