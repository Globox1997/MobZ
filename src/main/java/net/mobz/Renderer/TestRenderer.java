/*package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.feature.ArmorBipedFeatureRenderer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.mobz.Entity.*;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class TestRenderer extends BipedEntityRenderer<TestEntity, ZombieEntityModel<TestEntity>> {
   private static final Identifier SKIN = new Identifier("mobz:textures/entity/test.png");

   public TestRenderer(EntityRenderDispatcher entityRenderDispatcher) {
      super(entityRenderDispatcher, new ZombieEntityModel(0.0F, false), 0.5F);
      this.addFeature(
            new ArmorBipedFeatureRenderer(this, new ZombieEntityModel(0.5F, true), new ZombieEntityModel(1.0F, true)));
   }

   public Identifier getTexture(TestEntity Tanky) {
      return SKIN;
   }
}

/*
import net.minecraft.client.render.entity.EntityRenderDispatcher;

import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.util.Identifier;
import net.mobz.Entity.TestEntity;



public class TestRenderer extends MobEntityRenderer<TestEntity, BipedEntityModel>
{
    public TestRenderer(EntityRenderDispatcher entityRenderDispatcher)
    {
        super(entityRenderDispatcher, new EntityModel(), 1);
    }

    @Override
    public Identifier getTexture(TestEntity entity) {
       return new Identifier("mobz:textures/entity/test.png");
    }

} */

package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.IllagerEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.IllagerEntityModel;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.util.Identifier;
import net.mobz.Entity.TestEntity;

@Environment(EnvType.CLIENT)
public class TestRenderer extends IllagerEntityRenderer<TestEntity> {
   private static final Identifier SKIN = new Identifier("mobz:textures/entity/test.png");

   public TestRenderer(EntityRenderDispatcher entityRenderDispatcher) {
      super(entityRenderDispatcher, new IllagerEntityModel(0.0F, 0.0F, 64, 64), 0.5F);
      this.addFeature(new HeldItemFeatureRenderer(this));
   }

   public Identifier getTexture(PillagerEntity pillagerEntity) {
      return SKIN;
   }

   @Override
   public Identifier getTexture(TestEntity entity) {
      return new Identifier("mobz:textures/entity/test.png");
   }
}