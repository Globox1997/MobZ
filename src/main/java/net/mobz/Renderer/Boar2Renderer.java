package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.util.Identifier;
import net.mobz.Entity.Boar;

@Environment(EnvType.CLIENT)
public class Boar2Renderer extends MobEntityRenderer<Boar, PigEntityModel<Boar>> {
    public Boar2Renderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new PigEntityModel(), 0.7F);

    }

    @Override
    protected Identifier getTexture(Boar boar) {
        return new Identifier("mobz:textures/entity/boar2.png");
    }

}