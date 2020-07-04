package net.mobz.Renderer.RenderFeatures;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class OverlayFeature<T extends MobEntity & RangedAttackMob, M extends EntityModel<T>>
    extends FeatureRenderer<T, M> {
  private static final Identifier SKIN = new Identifier("mobz:textures/entity/skeli1_overlay.png");
  private final SkeletonEntityModel<T> model = new SkeletonEntityModel<>(0.25F, true);

  public OverlayFeature(FeatureRendererContext<T, M> featureRendererContext) {
    super(featureRendererContext);
  }

  public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T mobEntity,
      float f, float g, float h, float j, float k, float l) {
    render(this.getContextModel(), this.model, SKIN, matrixStack, vertexConsumerProvider, i, mobEntity, f, g, j, k, l,
        h, 1.0F, 1.0F, 1.0F);
  }
}
