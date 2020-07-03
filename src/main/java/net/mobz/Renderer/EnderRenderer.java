package net.mobz.Renderer;

import java.util.Random;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.EndermanBlockFeatureRenderer;
import net.minecraft.client.render.entity.model.EndermanEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.mobz.Renderer.RenderFeatures.EnderEyes;

@Environment(EnvType.CLIENT)
public class EnderRenderer extends MobEntityRenderer<EndermanEntity, EndermanEntityModel<EndermanEntity>> {
   private static final Identifier SKIN = new Identifier("mobz:textures/entity/ender.png");
   private final Random random = new Random();

   public EnderRenderer(EntityRenderDispatcher entityRenderDispatcher) {
      super(entityRenderDispatcher, new EndermanEntityModel<>(0.0F), 0.5F);
      this.addFeature(new EnderEyes<>(this));
      this.addFeature(new EndermanBlockFeatureRenderer(this));
   }

   @Override
   public void render(EndermanEntity endermanEntity, float f, float g, MatrixStack matrixStack,
         VertexConsumerProvider vertexConsumerProvider, int i) {
      BlockState blockState = endermanEntity.getCarriedBlock();
      EndermanEntityModel<EndermanEntity> endermanEntityModel = this.getModel();
      endermanEntityModel.carryingBlock = blockState != null;
      endermanEntityModel.angry = endermanEntity.isAngry();
      super.render((EndermanEntity) endermanEntity, f, g, matrixStack, vertexConsumerProvider, i);
   }

   @Override
   public Vec3d getPositionOffset(EndermanEntity endermanEntity, float f) {
      if (endermanEntity.isAngry()) {
         return new Vec3d(this.random.nextGaussian() * 0.02D, 0.0D, this.random.nextGaussian() * 0.02D);
      } else {
         return super.getPositionOffset(endermanEntity, f);
      }
   }

   public Identifier getTexture(EndermanEntity endermanEntity) {
      return SKIN;
   }
}
