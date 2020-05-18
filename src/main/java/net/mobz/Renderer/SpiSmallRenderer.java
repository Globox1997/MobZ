
package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.SpiderEntityRenderer;
import net.minecraft.client.render.entity.feature.SpiderEyesFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.mobz.Entity.SpiSmall;

@Environment(EnvType.CLIENT)
public class SpiSmallRenderer extends SpiderEntityRenderer<SpiSmall> {

   public SpiSmallRenderer(EntityRenderDispatcher dispatcher) {
      super(dispatcher);
      this.shadowSize *= 0.7F;
      this.addFeature(new SpiderEyesFeatureRenderer<>(this));
   }

   @Override
   protected void scale(SpiSmall caveSpiderEntity, MatrixStack matrixStack, float f) {
      matrixStack.scale(0.7F, 0.7F, 0.7F);
   }

   @Override
   public Identifier getTexture(SpiSmall SpiSmalll) {
      return new Identifier("mobz:textures/entity/spismall.png");
   }

}
