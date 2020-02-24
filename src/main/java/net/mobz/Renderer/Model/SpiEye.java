package net.mobz.Renderer.Model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SpiEye<T extends Entity, M extends SpiderEntityModel<T>> extends EyesFeatureRenderer<T, M> {
   private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier("mobz:textures/entity/spieyes.png"));

   public SpiEye(FeatureRendererContext<T, M> featureRendererContext_1) {
      super(featureRendererContext_1);
   }

   public RenderLayer getEyesTexture() {
      return SKIN;
   }
}
