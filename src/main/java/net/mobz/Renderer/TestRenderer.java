package net.mobz.Renderer;

import net.mobz.Entity.*;
import net.mobz.Renderer.Model.SmallModel;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.BipedEntityRenderer;

import net.minecraft.client.render.entity.EvokerIllagerEntityRenderer;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EvilVillagerEntityModel;
import net.minecraft.client.render.entity.model.EvokerFangsEntityModel;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.feature.ArmorBipedFeatureRenderer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class TestRenderer extends BipedEntityRenderer<TestEntity, ZombieEntityModel<TestEntity>> {

    public TestRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new ZombieEntityModel<>(), 0.5F);

    }

    @Override
    protected Identifier getTexture(TestEntity testEntity) {
        return new Identifier("mobz:textures/entity/test.png");
    }


}