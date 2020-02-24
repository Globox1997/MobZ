/*package net.mobz.Renderer;

import net.mobz.Entity.*;
//import net.mobz.Renderer.Model.EnderEye;
import net.fabricmc.api.Environment;

import java.util.Random;

import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EndermanEntityModel;
import net.minecraft.client.render.entity.EnderRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class EnderRenderer extends MobEntityRenderer<EnderEntity, EndermanEntityModel<EnderEntity>> {
    private final Random random = new Random();

    public EnderRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new EndermanEntityModel(0.0F), 0.5F);
        // this.addFeature(new EnderEye(this));

    }

    public Identifier getTexture(EnderEntity enderEntity) {
        return new Identifier("mobz:textures/entity/ender.png");
    }
    /*
     * public void method_3911(EndermanEntity endermanEntity_1, double double_1,
     * double double_2, double double_3, float float_1, float float_2) { BlockState
     * blockState_1 = endermanEntity_1.getCarriedBlock();
     * EndermanEntityModel<EndermanEntity> endermanEntityModel_1 =
     * (EndermanEntityModel)this.getModel(); endermanEntityModel_1.carryingBlock =
     * blockState_1 != null; endermanEntityModel_1.angry =
     * endermanEntity_1.isAngry(); if (endermanEntity_1.isAngry()) { double double_4
     * = 0.02D; double_1 += this.random.nextGaussian() * 0.02D; double_3 +=
     * this.random.nextGaussian() * 0.02D; }
     * 
     * super.method_4072((EnderEntity) endermanEntity_1, double_1, double_2,
     * double_3, float_1, float_2); }
     */
//} */
package net.mobz.Renderer;

import java.util.Random;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.EndermanBlockFeatureRenderer;
import net.minecraft.client.render.entity.feature.EndermanEyesFeatureRenderer;
import net.minecraft.client.render.entity.model.EndermanEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

@Environment(EnvType.CLIENT)
public class EnderRenderer extends MobEntityRenderer<EndermanEntity, EndermanEntityModel<EndermanEntity>> {
   private static final Identifier SKIN = new Identifier("mobz:textures/entity/ender.png");
   private final Random random = new Random();

   public EnderRenderer(EntityRenderDispatcher entityRenderDispatcher) {
      super(entityRenderDispatcher, new EndermanEntityModel(0.0F), 0.5F);
      this.addFeature(new EndermanEyesFeatureRenderer(this));
      this.addFeature(new EndermanBlockFeatureRenderer(this));
   }

   public void render(EndermanEntity endermanEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
      BlockState blockState = endermanEntity.getCarriedBlock();
      EndermanEntityModel<EndermanEntity> endermanEntityModel = (EndermanEntityModel)this.getModel();
      endermanEntityModel.carryingBlock = blockState != null;
      endermanEntityModel.angry = endermanEntity.isAngry();
      super.render((EndermanEntity) endermanEntity, f, g, matrixStack, vertexConsumerProvider, i);
   }

   public Vec3d getPositionOffset(EndermanEntity endermanEntity, float f) {
      if (endermanEntity.isAngry()) {
         double d = 0.02D;
         return new Vec3d(this.random.nextGaussian() * 0.02D, 0.0D, this.random.nextGaussian() * 0.02D);
      } else {
         return super.getPositionOffset(endermanEntity, f);
      }
   }

   public Identifier getTexture(EndermanEntity endermanEntity) {
      return SKIN;
   }
}
