package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.fabricmc.api.Environment;

import com.mojang.blaze3d.platform.GlStateManager;

import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.SpiderEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SpiSmallRenderer extends SpiderEntityRenderer<SpiSmall> {

    public SpiSmallRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
        this.field_4673 *= 0.7F;

    }

    protected void method_3886(SpiSmall caveSpiderEntity_1, float float_1) {
        GlStateManager.scalef(0.7F, 0.7F, 0.7F);
    }

    protected Identifier getTexture(SpiSmall SpiSmalll) {
        return new Identifier("mobz:textures/entity/spismall.png");
    }

}
