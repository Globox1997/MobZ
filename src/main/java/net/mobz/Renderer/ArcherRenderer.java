package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.util.Identifier;

import net.minecraft.client.render.entity.PillagerEntityRenderer;

@Environment(EnvType.CLIENT)

public class ArcherRenderer extends BipedEntityRenderer<ArcherEntity, PlayerEntityModel<ArcherEntity>> {

    public ArcherRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new PlayerEntityModel<>(0.0F, false), 0.5F);
    }

    @Override
    public Identifier getTexture(ArcherEntity archer) {
        return new Identifier("mobz:textures/entity/archer.png");
    }
}