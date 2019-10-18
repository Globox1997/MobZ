package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.util.Identifier;
import net.mobz.Entity.Boar2;

@Environment(EnvType.CLIENT)
public class Boar2Renderer extends MobEntityRenderer<Boar2, PigEntityModel<Boar2>> {
    public Boar2Renderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new PigEntityModel(), 0.7F);

    }

    @Override
    protected Identifier getTexture(Boar2 boared) {
        return new Identifier("mobz:textures/entity/badboar.png");
    }

}