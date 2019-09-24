package net.mobz.Renderer.Model;

import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EndermanEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class EnderEye<T extends LivingEntity> extends FeatureRenderer<T, EndermanEntityModel<T>> {
   private static final Identifier SKIN = new Identifier("mobz:textures/entity/endereyes.png");

   public EnderEye(FeatureRendererContext<T, EndermanEntityModel<T>> featureRendererContext_1) {
      super(featureRendererContext_1);
   }

   public void render(T livingEntity_1, float float_1, float float_2, float float_3, float float_4, float float_5, float float_6, float float_7) {
      this.bindTexture(SKIN);
      GlStateManager.enableBlend();
      GlStateManager.disableAlphaTest();
      GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
      GlStateManager.disableLighting();
      GlStateManager.depthMask(!livingEntity_1.isInvisible());
      int int_1 = '\uf0f0';
      int int_2 = '\uf0f0';
      
      GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, 61680.0F, 0.0F);
      GlStateManager.enableLighting();
      GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      GameRenderer gameRenderer_1 = MinecraftClient.getInstance().gameRenderer;
      gameRenderer_1.setFogBlack(true);
      ((EndermanEntityModel)this.getModel()).method_17088(livingEntity_1, float_1, float_2, float_4, float_5, float_6, float_7);
      gameRenderer_1.setFogBlack(false);
      this.applyLightmapCoordinates(livingEntity_1);
      GlStateManager.depthMask(true);
      GlStateManager.disableBlend();
      GlStateManager.enableAlphaTest();
   }

   public boolean hasHurtOverlay() {
      return false;
   }


}
