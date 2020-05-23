package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.IronGolemCrackFeatureRenderer;
import net.minecraft.client.render.entity.feature.IronGolemFlowerFeatureRenderer;
import net.minecraft.client.render.entity.model.IronGolemEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.util.Identifier;
import net.mobz.Renderer.RenderFeatures.GolemCrack;

@Environment(EnvType.CLIENT)
public class MetalGolemRenderer extends MobEntityRenderer<IronGolemEntity, IronGolemEntityModel<IronGolemEntity>> {
  private static final Identifier SKIN = new Identifier("mobz:textures/entity/metalgolem.png");

  public MetalGolemRenderer(EntityRenderDispatcher entityRenderDispatcher) {
    super(entityRenderDispatcher, new IronGolemEntityModel<>(), 0.7F);
    this.addFeature(new GolemCrack(this));
    this.addFeature(new IronGolemFlowerFeatureRenderer(this));
  }

  @Override
  public Identifier getTexture(IronGolemEntity lava) {
    return SKIN;
  }

  @Override
  protected void scale(IronGolemEntity golem, MatrixStack matrixStack, float f) {
    matrixStack.scale(1.15F, 1.15F, 1.15F);
  }

  @Override
  protected void setupTransforms(IronGolemEntity ironGolemEntity, MatrixStack matrixStack, float f, float g, float h) {
    super.setupTransforms(ironGolemEntity, matrixStack, f, g, h);
    if ((double) ironGolemEntity.limbDistance >= 0.01D) {
      float j = ironGolemEntity.limbAngle - ironGolemEntity.limbDistance * (1.0F - h) + 6.0F;
      float k = (Math.abs(j % 13.0F - 6.5F) - 3.25F) / 3.25F;
      matrixStack.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(6.5F * k));
    }
  }
}
