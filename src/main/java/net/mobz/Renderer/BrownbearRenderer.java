package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.PolarBearEntityModel;
import net.minecraft.util.Identifier;
import net.mobz.Entity.Brownbear;

@Environment(EnvType.CLIENT)
public class BrownbearRenderer extends MobEntityRenderer<Brownbear, PolarBearEntityModel<Brownbear>> {
    public BrownbearRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new PolarBearEntityModel(), 0.8F);

    }

    @Override
    public Identifier getTexture(Brownbear brownbear) {
        return new Identifier("mobz:textures/entity/brownbear.png");
    }

}