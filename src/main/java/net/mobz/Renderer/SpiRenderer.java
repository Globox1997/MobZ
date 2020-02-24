package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.SpiderEntityRenderer;
import net.mobz.Renderer.Model.*;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SpiRenderer extends SpiderEntityRenderer<SpiEntity> {

    public SpiRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
        this.addFeature(new SpiEye(this));
    }

    public Identifier getTexture(SpiEntity spiEntity) {
        return new Identifier("mobz:textures/entity/spi.png");
    }

}