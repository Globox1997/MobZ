package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.ChickenEntityModel;
import net.minecraft.client.render.entity.ChickenEntityRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.mobz.Entity.GChicken;
import net.mobz.Renderer.Model.GChick;
import net.minecraft.client.render.entity.ChickenEntityRenderer;

@Environment(EnvType.CLIENT)

public class GChickenRenderer extends MobEntityRenderer<GChicken, GChick<GChicken>> {

    public GChickenRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new GChick(), 0.3F);

    }



    @Override
    protected Identifier getTexture(GChicken GChickene) {
        return new Identifier("mobz:textures/entity/gchicken.png");
    }

}
