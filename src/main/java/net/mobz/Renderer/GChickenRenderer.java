package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.ChickenEntityModel;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class GChickenRenderer extends MobEntityRenderer<ChickenEntity, ChickenEntityModel<ChickenEntity>> {
   private static final Identifier SKIN = new Identifier("mobz:textures/entity/gchicken.png");

   public GChickenRenderer(EntityRenderDispatcher entityRenderDispatcher) {
      super(entityRenderDispatcher, new ChickenEntityModel(), 0.3F);
   }

   public Identifier getTexture(ChickenEntity chickenEntity) {
      return SKIN;
   }

   protected float getAnimationProgress(ChickenEntity chickenEntity, float f) {
      float g = MathHelper.lerp(f, chickenEntity.field_6736, chickenEntity.field_6741);
      float h = MathHelper.lerp(f, chickenEntity.field_6738, chickenEntity.field_6743);
      return (MathHelper.sin(g) + 1.0F) * h;
   }
}

