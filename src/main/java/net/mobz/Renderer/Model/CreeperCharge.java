package net.mobz.Renderer.Model;

import com.mojang.blaze3d.platform.GlStateManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.util.Identifier;
import net.mobz.Entity.CripEntity;

@Environment(EnvType.CLIENT)
public class CreeperCharge extends FeatureRenderer<CripEntity, CreeperEntityModel<CripEntity>> {
   private static final Identifier SKIN = new Identifier("mobz:textures/entity/charge.png");
   private final CreeperEntityModel<CripEntity> model = new CreeperEntityModel(2.0F);

   public CreeperCharge(FeatureRendererContext<CripEntity, CreeperEntityModel<CripEntity>> featureRendererContext_1) {
      super(featureRendererContext_1);
   }

   public void method_4178(CripEntity CripEntity_1, float float_1, float float_2, float float_3, float float_4, float float_5, float float_6, float float_7) {
      if (CripEntity_1.isCharged()) {
         boolean boolean_1 = CripEntity_1.isInvisible();
         GlStateManager.depthMask(!boolean_1);
         this.bindTexture(SKIN);
         GlStateManager.matrixMode(5890);
         GlStateManager.loadIdentity();
         float float_8 = (float)CripEntity_1.age + float_3;
         GlStateManager.translatef(float_8 * 0.01F, float_8 * 0.01F, 0.0F);
         GlStateManager.matrixMode(5888);
         GlStateManager.enableBlend();
         float float_9 = 0.5F;
         GlStateManager.color4f(0.5F, 0.5F, 0.5F, 1.0F);
         GlStateManager.disableLighting();
         GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
         ((CreeperEntityModel)this.getModel()).copyStateTo(this.model);
         GameRenderer gameRenderer_1 = MinecraftClient.getInstance().gameRenderer;
         gameRenderer_1.setFogBlack(true);
         this.model.render(CripEntity_1, float_1, float_2, float_4, float_5, float_6, float_7);
         gameRenderer_1.setFogBlack(false);
         GlStateManager.matrixMode(5890);
         GlStateManager.loadIdentity();
         GlStateManager.matrixMode(5888);
         GlStateManager.enableLighting();
         GlStateManager.disableBlend();
         GlStateManager.depthMask(true);
      }
   }

   public boolean hasHurtOverlay() {
      return false;
   }


    public void render(CripEntity var1, float var2, float var3, float var4, float var5, float var6, float var7,
            float var8) {
        // TODO Auto-generated method stub

    }


}
