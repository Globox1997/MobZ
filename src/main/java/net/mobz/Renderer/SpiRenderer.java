package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SpiRenderer extends MobEntityRenderer<SpiEntity, SpiderEntityModel<SpiEntity>> {
    public SpiRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new SpiderEntityModel(), 0.8F);
    }

    @Override
    protected Identifier getTexture(SpiEntity spiEntity) {
        return new Identifier("mobz:textures/entity/spi.png");
    }
}