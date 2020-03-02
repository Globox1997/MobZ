
package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.SpiderEntityRenderer;
import net.minecraft.client.render.entity.feature.SpiderEyesFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.mobz.Entity.TSpider;

@Environment(EnvType.CLIENT)
public class TSpiderRenderer extends SpiderEntityRenderer<TSpider> {

   public TSpiderRenderer(EntityRenderDispatcher dispatcher) {
      super(dispatcher);
      this.addFeature(new SpiderEyesFeatureRenderer(this));
   }

   protected void scale(TSpider caveSpiderEntity, MatrixStack matrixStack, float f) {
      matrixStack.scale(0.1F, 0.1F, 0.1F);
   }

   @Override
   public Identifier getTexture(TSpider TSpiderl) {
      return new Identifier("mobz:textures/entity/tspider.png");
   }

}
