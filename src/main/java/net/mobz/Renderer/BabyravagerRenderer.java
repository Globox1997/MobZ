package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.RavagerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BabyravagerRenderer extends MobEntityRenderer<RavagerEntity, RavagerEntityModel> {
  private static final Identifier SKIN = new Identifier("mobz:textures/entity/ravo.png");

  public BabyravagerRenderer(EntityRenderDispatcher entityRenderDispatcher) {
    super(entityRenderDispatcher, new RavagerEntityModel(), 0.4F);
  }

  @Override
  public Identifier getTexture(RavagerEntity ravagerEntity) {
    return SKIN;
  }

  @Override
  protected void scale(RavagerEntity vexEntity, MatrixStack matrixStack, float f) {
    matrixStack.scale(0.4F, 0.4F, 0.4F);
  }
}
