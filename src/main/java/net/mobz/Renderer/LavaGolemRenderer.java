package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.minecraft.client.render.entity.model.IronGolemEntityModel;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class LavaGolemRenderer extends MobEntityRenderer<LavaGolem, IronGolemEntityModel<LavaGolem>> {
    public LavaGolemRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new IronGolemEntityModel(), 0.7F);
    }

    @Override
    protected Identifier getTexture(LavaGolem lava) {
        return new Identifier("mobz:textures/entity/lavagolem.png");
    }
}