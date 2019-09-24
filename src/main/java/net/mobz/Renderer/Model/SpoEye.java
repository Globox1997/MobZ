package net.mobz.Renderer.Model;

import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SpoEye<T extends Entity, M extends SpiderEntityModel<T>> extends FeatureRenderer<T, M> {
   private static final Identifier SKIN = new Identifier("mobz:textures/entity/spoeyes.png");

   public SpoEye(FeatureRendererContext<T, M> featureRendererContext_1) {
      super(featureRendererContext_1);
   }

   public void render(T entity_1, float float_1, float float_2, float float_3, float float_4, float float_5, float float_6, float float_7) {
      this.bindTexture(SKIN);
      GlStateManager.enableBlend();
      GlStateManager.disableAlphaTest();
      GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
      if (entity_1.isInvisible()) {
         GlStateManager.depthMask(false);
      } else {
         GlStateManager.depthMask(true);
      }

      int int_1 = '\uf0f0';
      int int_2 = int_1 % 65536;
      int int_3 = int_1 / 65536;
      GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, (float)int_2, (float)int_3);
      GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      GameRenderer gameRenderer_1 = MinecraftClient.getInstance().gameRenderer;
      gameRenderer_1.setFogBlack(true);
      ((SpiderEntityModel)this.getModel()).render(entity_1, float_1, float_2, float_4, float_5, float_6, float_7);
      gameRenderer_1.setFogBlack(false);
      int int_4 = entity_1.getLightmapCoordinates();
      int_2 = int_1 % 65536;
      int_3 = int_1 / 65536;
      GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, (float)int_2, (float)int_3);
      this.applyLightmapCoordinates(entity_1);
      GlStateManager.depthMask(true);
      GlStateManager.disableBlend();
      GlStateManager.enableAlphaTest();
   }

   public boolean hasHurtOverlay() {
      return false;
   }
}
