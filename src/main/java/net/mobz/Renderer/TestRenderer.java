package net.mobz.Renderer;

import com.mojang.blaze3d.platform.GlStateManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.GuiLighting;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.EnderDragonDeathFeatureRenderer;
import net.minecraft.client.render.entity.feature.EnderDragonEyesFeatureRenderer;
import net.minecraft.client.render.entity.model.DragonEntityModel;
import net.minecraft.client.render.entity.EnderDragonEntityRenderer;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.mobz.Entity.TestEntity;
import net.mobz.Renderer.Model.TestModels.Dragon;

@Environment(EnvType.CLIENT)
public class TestRenderer extends MobEntityRenderer<TestEntity, Dragon> {
   public static final Identifier CRYSTAL_BEAM = new Identifier("textures/entity/end_crystal/end_crystal_beam.png");
   private static final Identifier EXPLOSION_TEX = new Identifier("textures/entity/enderdragon/dragon_exploding.png");
   private static final Identifier SKIN = new Identifier("mobz:textures/entity/test.png");

   public TestRenderer(EntityRenderDispatcher dispatcher) {
      super(dispatcher, new Dragon(0.0F), 0.5F);

      
   }



   public static void renderCrystalBeam(double double_1, double double_2, double double_3, float float_1, double double_4, double double_5, double double_6, int int_1, double double_7, double double_8, double double_9) {
      float float_2 = (float)(double_7 - double_4);
      float float_3 = (float)(double_8 - 1.0D - double_5);
      float float_4 = (float)(double_9 - double_6);
      float float_5 = MathHelper.sqrt(float_2 * float_2 + float_4 * float_4);
      float float_6 = MathHelper.sqrt(float_2 * float_2 + float_3 * float_3 + float_4 * float_4);
      GlStateManager.pushMatrix();
      GlStateManager.translatef((float)double_1, (float)double_2 + 2.0F, (float)double_3);
      GlStateManager.rotatef((float)(-Math.atan2((double)float_4, (double)float_2)) * 57.295776F - 90.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.rotatef((float)(-Math.atan2((double)float_5, (double)float_3)) * 57.295776F - 90.0F, 1.0F, 0.0F, 0.0F);
      Tessellator tessellator_1 = Tessellator.getInstance();
      BufferBuilder bufferBuilder_1 = tessellator_1.getBufferBuilder();
      GuiLighting.disable();
      GlStateManager.disableCull();
      GlStateManager.shadeModel(7425);
      float float_7 = 0.0F - ((float)int_1 + float_1) * 0.01F;
      float float_8 = MathHelper.sqrt(float_2 * float_2 + float_3 * float_3 + float_4 * float_4) / 32.0F - ((float)int_1 + float_1) * 0.01F;
      bufferBuilder_1.begin(5, VertexFormats.POSITION_UV_COLOR);
   

      for(int int_3 = 0; int_3 <= 8; ++int_3) {
         float float_9 = MathHelper.sin((float)(int_3 % 8) * 6.2831855F / 8.0F) * 0.75F;
         float float_10 = MathHelper.cos((float)(int_3 % 8) * 6.2831855F / 8.0F) * 0.75F;
         float float_11 = (float)(int_3 % 8) / 8.0F;
         bufferBuilder_1.vertex((double)(float_9 * 0.2F), (double)(float_10 * 0.2F), 0.0D).texture((double)float_11, (double)float_7).color(0, 0, 0, 255).next();
         bufferBuilder_1.vertex((double)float_9, (double)float_10, (double)float_6).texture((double)float_11, (double)float_8).color(255, 255, 255, 255).next();
      }

      tessellator_1.draw();
      GlStateManager.enableCull();
      GlStateManager.shadeModel(7424);
      GuiLighting.enable();
      GlStateManager.popMatrix();
   }

   protected Identifier method_3914(TestEntity TestEntity_1) {
      return SKIN;
   }

   @Override
   protected Identifier getTexture(TestEntity ttt) {
       // TODO Auto-generated method stub
       return new Identifier("mobz:textures/entity/test.png");
   }
}
