package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class DwarfEntityRenderer extends BipedEntityRenderer<DwarfEntity, PlayerEntityModel<DwarfEntity>> {

    public DwarfEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new PlayerEntityModel<>(0.0F, false), 0.5F);
        this.addFeature(new ArmorFeatureRenderer<>(this, new PlayerEntityModel<>(0.5F, true),
                new PlayerEntityModel<>(1.0F, true)));
    }

    @Override
    public Identifier getTexture(DwarfEntity dwarfentitye) {
        return new Identifier("mobz:textures/entity/dwarf.png");
    }
}