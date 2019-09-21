package net.mobz.Renderer;

import net.mobz.Entity.*;
import net.mobz.Renderer.Model.*;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BigBossRenderer extends MobEntityRenderer<BigBossEntity, BigBipedModel<BigBossEntity>> {
    public BigBossRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new BigBipedModel(0.0F, false), 1.0F);
        /* this.addFeature(new ArmorBipedFeatureRenderer(this, new ZombieEntityModel(6.5F, true),
                new ZombieEntityModel(5.0F, true)));*/
    }

    @Override
    protected Identifier getTexture(BigBossEntity bigbossentity) {
        return new Identifier("mobz:textures/entity/bigbossentity.png");
    }

}