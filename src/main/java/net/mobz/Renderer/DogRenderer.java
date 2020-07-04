package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.WolfEntityModel;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class DogRenderer extends MobEntityRenderer<WolfEntity, WolfEntityModel<WolfEntity>> {
   private static final Identifier TEXTURE = new Identifier("mobz:textures/entity/dog.png");

   public DogRenderer(EntityRenderDispatcher entityRenderDispatcher) {
      super(entityRenderDispatcher, new WolfEntityModel<>(), 0.5F);
   }

   @Override
   protected float getAnimationProgress(WolfEntity wolfEntity, float f) {
      return wolfEntity.getTailAngle();
   }

   @Override
   public Identifier getTexture(WolfEntity wolfEntity) {
      return TEXTURE;
   }
}
