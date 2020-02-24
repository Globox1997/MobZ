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
   private static final Identifier WILD_SKIN = new Identifier("mobz:textures/entity/dog.png");
   private static final Identifier TAMED_SKIN = new Identifier("mobz:textures/entity/dog.png");
   private static final Identifier ANGRY_SKIN = new Identifier("mobz:textures/entity/dogangry.png");

   public DogRenderer(EntityRenderDispatcher entityRenderDispatcher) {
      super(entityRenderDispatcher, new WolfEntityModel(), 0.5F);
   }

   protected float getAnimationProgress(WolfEntity wolfEntity, float f) {
      return wolfEntity.method_6714();
   }


   public Identifier getTexture(WolfEntity wolfEntity) {
      if (wolfEntity.isTamed()) {
         return TAMED_SKIN;
      } else {
         return wolfEntity.isAngry() ? ANGRY_SKIN : WILD_SKIN;
      }
   }
}
