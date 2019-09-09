package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CripRenderer extends MobEntityRenderer<CripEntity, CreeperEntityModel<CripEntity>> {
    public CripRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new CreeperEntityModel<>(), 0.5F);
    }

    @Override
    protected Identifier getTexture(CripEntity cripEntity) {
        return new Identifier("mobz:textures/entity/crip.png");
    }
}