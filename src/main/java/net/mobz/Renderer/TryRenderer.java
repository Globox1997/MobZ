package net.mobz.Renderer;

import net.mobz.Entity.*;
import net.mobz.Renderer.Model.SmallModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.ArmorBipedFeatureRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)



    public class TryRenderer extends MobEntityRenderer<Try, SmallModel<Try>> {
        public TryRenderer(EntityRenderDispatcher dispatcher) {
            super(dispatcher, new SmallModel(0.0F), 1.0F);
        }

    @Override
    protected Identifier getTexture(Try Trye) {
        return new Identifier("mobz:textures/entity/try.png");
    }


}