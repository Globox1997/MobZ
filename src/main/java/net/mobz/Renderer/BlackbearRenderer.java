package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.PandaEntityModel;
import net.minecraft.util.Identifier;
import net.mobz.Entity.Blackbear;

@Environment(EnvType.CLIENT)
public class BlackbearRenderer extends MobEntityRenderer<Blackbear, PandaEntityModel<Blackbear>> {
    public BlackbearRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new PandaEntityModel(0, 0.0F), 0.8F);

    }

    @Override
    public Identifier getTexture(Blackbear Blackbear) {
        return new Identifier("mobz:textures/entity/blackbear.png");
    }

}