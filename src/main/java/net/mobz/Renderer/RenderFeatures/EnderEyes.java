package net.mobz.Renderer.RenderFeatures;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EndermanEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class EnderEyes<T extends LivingEntity> extends EyesFeatureRenderer<T, EndermanEntityModel<T>> {
  private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier("mobz:textures/entity/endereyes.png"));

  public EnderEyes(FeatureRendererContext<T, EndermanEntityModel<T>> context) {
    super(context);
  }

  public RenderLayer getEyesTexture() {
    return SKIN;
  }
}
