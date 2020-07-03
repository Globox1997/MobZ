package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.SlimeOverlayFeatureRenderer;
import net.minecraft.client.render.entity.model.SlimeEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class SlimoRenderer extends MobEntityRenderer<SlimeEntity, SlimeEntityModel<SlimeEntity>> {
   private static final Identifier SKIN = new Identifier("mobz:textures/entity/grassslime.png");

   public SlimoRenderer(EntityRenderDispatcher entityRenderDispatcher) {
      super(entityRenderDispatcher, new SlimeEntityModel<>(16), 0.25F);
      this.addFeature(new SlimeOverlayFeatureRenderer<>(this));
   }

   @Override
   public void render(SlimeEntity slimeEntity, float f, float g, MatrixStack matrixStack,
         VertexConsumerProvider vertexConsumerProvider, int i) {
      this.shadowRadius = 0.25F * (float) slimeEntity.getSize();
      super.render((SlimeEntity) slimeEntity, f, g, matrixStack, vertexConsumerProvider, i);
   }

   @Override
   protected void scale(SlimeEntity slimeEntity, MatrixStack matrixStack, float f) {
      matrixStack.scale(0.999F, 0.999F, 0.999F);
      matrixStack.translate(0.0D, 0.0010000000474974513D, 0.0D);
      float h = (float) slimeEntity.getSize();
      float i = MathHelper.lerp(f, slimeEntity.lastStretch, slimeEntity.stretch) / (h * 0.5F + 1.0F);
      float j = 1.0F / (i + 1.0F);
      matrixStack.scale(j * h, 1.0F / j * h, j * h);
   }

   @Override
   public Identifier getTexture(SlimeEntity slimeEntity) {
      return SKIN;
   }
}
