package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.util.Identifier;
import net.mobz.Entity.Boar3;

@Environment(EnvType.CLIENT)
public class Boar3Renderer extends MobEntityRenderer<Boar3, PigEntityModel<Boar3>> {
    public Boar3Renderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new PigEntityModel(), 0.7F);

    }

    @Override
    public Identifier getTexture(Boar3 boar3) {
        return new Identifier("mobz:textures/entity/boar3.png");
    }

}