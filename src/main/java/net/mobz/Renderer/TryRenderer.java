
/* package net.mobz.Renderer;

import net.mobz.Entity.*;
import net.mobz.Renderer.Model.TestModels.*;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import net.minecraft.client.render.entity.model.TryModel;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.TryRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class TryRenderer extends MobEntityRenderer<Try, TryModel<Try>> {

    public TryRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new TryModel(0), 0.5F);
    }

    @Override
    protected Identifier getTexture(Try trye) {
        return new Identifier("mobz:textures/entity/grassslime.png");
    }

}
*/

package net.mobz.Renderer;

import com.mojang.blaze3d.platform.GlStateManager;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.SlimeOverlayFeatureRenderer;
import net.minecraft.client.render.entity.model.SlimeEntityModel;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.mobz.Entity.Try;

@Environment(EnvType.CLIENT)
public class TryRenderer extends MobEntityRenderer<Try, SlimeEntityModel<Try>> {
   private static final Identifier SKIN = new Identifier("mobz:textures/entity/grassslime.png");

   public TryRenderer(EntityRenderDispatcher entityRenderDispatcher_1) {
      super(entityRenderDispatcher_1, new SlimeEntityModel(16), 0.25F);
      this.addFeature(new SlimeOverlayFeatureRenderer(this));
   }

   public void method_4117(Try Try_1, double double_1, double double_2, double double_3, float float_1, float float_2) {
      this.field_4673 = 0.25F * (float)Try_1.getSize();
      super.method_4072(Try_1, double_1, double_2, double_3, float_1, float_2);
   }

   protected void method_4118(Try Try_1, float float_1) {
      float float_2 = 0.999F;
      GlStateManager.scalef(0.999F, 0.999F, 0.999F);
      float float_3 = (float)Try_1.getSize();
      float float_4 = MathHelper.lerp(float_1, Try_1.lastStretch, Try_1.stretch) / (float_3 * 0.5F + 1.0F);
      float float_5 = 1.0F / (float_4 + 1.0F);
      GlStateManager.scalef(float_5 * float_3, 1.0F / float_5 * float_3, float_5 * float_3);
   }

   protected Identifier method_4116(Try Try_1) {
      return SKIN;
   }

    @Override
    protected Identifier getTexture(Try var1) {
        // TODO Auto-generated method stub
        return new Identifier("mobz:textures/entity/grassslime.png");
    }
}
