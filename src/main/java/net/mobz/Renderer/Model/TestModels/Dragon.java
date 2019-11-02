package net.mobz.Renderer.Model.TestModels;

import com.mojang.blaze3d.platform.GlStateManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Cuboid;

import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.util.math.MathHelper;
import net.mobz.Entity.TestEntity;

@Environment(EnvType.CLIENT)
public class Dragon extends EntityModel<TestEntity> {
   private final Cuboid head;
   private final Cuboid neck;
   private final Cuboid jaw;
   private final Cuboid body;
   private final Cuboid rearLeg;
   private final Cuboid frontLeg;
   private final Cuboid rearLegTip;
   private final Cuboid frontLegTip;
   private final Cuboid rearFoot;
   private final Cuboid frontFoot;
   private final Cuboid wing;
   private final Cuboid wingTip;
   private float delta;

   public Dragon(float float_1) {
      this.textureWidth = 256;
      this.textureHeight = 256;
      float float_2 = -16.0F;
      this.head = new Cuboid(this, "head");
      this.head.addBox("upperlip", -6.0F, -1.0F, -24.0F, 12, 5, 16, float_1, 176, 44);
      this.head.addBox("upperhead", -8.0F, -8.0F, -10.0F, 16, 16, 16, float_1, 112, 30);
      this.head.mirror = true;
      this.head.addBox("scale", -5.0F, -12.0F, -4.0F, 2, 4, 6, float_1, 0, 0);
      this.head.addBox("nostril", -5.0F, -3.0F, -22.0F, 2, 2, 4, float_1, 112, 0);
      this.head.mirror = false;
      this.head.addBox("scale", 3.0F, -12.0F, -4.0F, 2, 4, 6, float_1, 0, 0);
      this.head.addBox("nostril", 3.0F, -3.0F, -22.0F, 2, 2, 4, float_1, 112, 0);
      this.jaw = new Cuboid(this, "jaw");
      this.jaw.setRotationPoint(0.0F, 4.0F, -8.0F);
      this.jaw.addBox("jaw", -6.0F, 0.0F, -16.0F, 12, 4, 16, float_1, 176, 65);
      this.head.addChild(this.jaw);
      this.neck = new Cuboid(this, "neck");
      this.neck.addBox("box", -5.0F, -5.0F, -5.0F, 10, 10, 10, float_1, 192, 104);
      this.neck.addBox("scale", -1.0F, -9.0F, -3.0F, 2, 4, 6, float_1, 48, 0);
      this.body = new Cuboid(this, "body");
      this.body.setRotationPoint(0.0F, 4.0F, 8.0F);
      this.body.addBox("body", -12.0F, 0.0F, -16.0F, 24, 24, 64, float_1, 0, 0);
      this.body.addBox("scale", -1.0F, -6.0F, -10.0F, 2, 6, 12, float_1, 220, 53);
      this.body.addBox("scale", -1.0F, -6.0F, 10.0F, 2, 6, 12, float_1, 220, 53);
      this.body.addBox("scale", -1.0F, -6.0F, 30.0F, 2, 6, 12, float_1, 220, 53);
      this.wing = new Cuboid(this, "wing");
      this.wing.setRotationPoint(-12.0F, 5.0F, 2.0F);
      this.wing.addBox("bone", -56.0F, -4.0F, -4.0F, 56, 8, 8, float_1, 112, 88);
      this.wing.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56, float_1, -56, 88);
      this.wingTip = new Cuboid(this, "wingtip");
      this.wingTip.setRotationPoint(-56.0F, 0.0F, 0.0F);
      this.wingTip.addBox("bone", -56.0F, -2.0F, -2.0F, 56, 4, 4, float_1, 112, 136);
      this.wingTip.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56, float_1, -56, 144);
      this.wing.addChild(this.wingTip);
      this.frontLeg = new Cuboid(this, "frontleg");
      this.frontLeg.setRotationPoint(-12.0F, 20.0F, 2.0F);
      this.frontLeg.addBox("main", -4.0F, -4.0F, -4.0F, 8, 24, 8, float_1, 112, 104);
      this.frontLegTip = new Cuboid(this, "frontlegtip");
      this.frontLegTip.setRotationPoint(0.0F, 20.0F, -1.0F);
      this.frontLegTip.addBox("main", -3.0F, -1.0F, -3.0F, 6, 24, 6, float_1, 226, 138);
      this.frontLeg.addChild(this.frontLegTip);
      this.frontFoot = new Cuboid(this, "frontfoot");
      this.frontFoot.setRotationPoint(0.0F, 23.0F, 0.0F);
      this.frontFoot.addBox("main", -4.0F, 0.0F, -12.0F, 8, 4, 16, float_1, 144, 104);
      this.frontLegTip.addChild(this.frontFoot);
      this.rearLeg = new Cuboid(this, "rearleg");
      this.rearLeg.setRotationPoint(-16.0F, 16.0F, 42.0F);
      this.rearLeg.addBox("main", -8.0F, -4.0F, -8.0F, 16, 32, 16, float_1, 0, 0);
      this.rearLegTip = new Cuboid(this, "rearlegtip");
      this.rearLegTip.setRotationPoint(0.0F, 32.0F, -4.0F);
      this.rearLegTip.addBox("main", -6.0F, -2.0F, 0.0F, 12, 32, 12, float_1, 196, 0);
      this.rearLeg.addChild(this.rearLegTip);
      this.rearFoot = new Cuboid(this, "rearfoot");
      this.rearFoot.setRotationPoint(0.0F, 31.0F, 4.0F);
      this.rearFoot.addBox("main", -9.0F, 0.0F, -20.0F, 18, 6, 24, float_1, 112, 0);
      this.rearLegTip.addChild(this.rearFoot);
   }

   public void method_17136(EnderDragonEntity enderDragonEntity_1, float float_1, float float_2, float float_3) {
      this.delta = float_3;
   }

   public void method_17137(EnderDragonEntity enderDragonEntity_1, float float_1, float float_2, float float_3, float float_4, float float_5, float float_6) {
      GlStateManager.pushMatrix();
      float float_7 = MathHelper.lerp(this.delta, enderDragonEntity_1.field_7019, enderDragonEntity_1.field_7030);
      this.jaw.pitch = (float)(Math.sin((double)(float_7 * 6.2831855F)) + 1.0D) * 0.2F;
      float float_8 = (float)(Math.sin((double)(float_7 * 6.2831855F - 1.0F)) + 1.0D);
      float_8 = (float_8 * float_8 + float_8 * 2.0F) * 0.05F;
      GlStateManager.translatef(0.0F, float_8 - 2.0F, -3.0F);
      GlStateManager.rotatef(float_8 * 2.0F, 1.0F, 0.0F, 0.0F);
      float float_9 = 0.0F;
      float float_10 = 20.0F;
      float float_11 = -12.0F;
      float float_12 = 1.5F;
      double[] doubles_1 = enderDragonEntity_1.method_6817(6, this.delta);
      float float_13 = this.updateRotations(enderDragonEntity_1.method_6817(5, this.delta)[0] - enderDragonEntity_1.method_6817(10, this.delta)[0]);
      float float_14 = this.updateRotations(enderDragonEntity_1.method_6817(5, this.delta)[0] + (double)(float_13 / 2.0F));
      float float_15 = float_7 * 6.2831855F;

      float float_17;
      for(int int_1 = 0; int_1 < 5; ++int_1) {
         double[] doubles_2 = enderDragonEntity_1.method_6817(5 - int_1, this.delta);
         float_17 = (float)Math.cos((double)((float)int_1 * 0.45F + float_15)) * 0.15F;
         this.neck.yaw = this.updateRotations(doubles_2[0] - doubles_1[0]) * 0.017453292F * 1.5F;
         this.neck.pitch = float_17 + enderDragonEntity_1.method_6823(int_1, doubles_1, doubles_2) * 0.017453292F * 1.5F * 5.0F;
         this.neck.roll = -this.updateRotations(doubles_2[0] - (double)float_14) * 0.017453292F * 1.5F;
         this.neck.rotationPointY = float_10;
         this.neck.rotationPointZ = float_11;
         this.neck.rotationPointX = float_9;
         float_10 = (float)((double)float_10 + Math.sin((double)this.neck.pitch) * 10.0D);
         float_11 = (float)((double)float_11 - Math.cos((double)this.neck.yaw) * Math.cos((double)this.neck.pitch) * 10.0D);
         float_9 = (float)((double)float_9 - Math.sin((double)this.neck.yaw) * Math.cos((double)this.neck.pitch) * 10.0D);
         this.neck.render(float_6);
      }

      this.head.rotationPointY = float_10;
      this.head.rotationPointZ = float_11;
      this.head.rotationPointX = float_9;
      double[] doubles_3 = enderDragonEntity_1.method_6817(0, this.delta);
      this.head.yaw = this.updateRotations(doubles_3[0] - doubles_1[0]) * 0.017453292F;
      this.head.pitch = this.updateRotations((double)enderDragonEntity_1.method_6823(6, doubles_1, doubles_3)) * 0.017453292F * 1.5F * 5.0F;
      this.head.roll = -this.updateRotations(doubles_3[0] - (double)float_14) * 0.017453292F;
      this.head.render(float_6);
      GlStateManager.pushMatrix();
      GlStateManager.translatef(0.0F, 1.0F, 0.0F);
      GlStateManager.rotatef(-float_13 * 1.5F, 0.0F, 0.0F, 1.0F);
      GlStateManager.translatef(0.0F, -1.0F, 0.0F);
      this.body.roll = 0.0F;
      this.body.render(float_6);

      for(int int_2 = 0; int_2 < 2; ++int_2) {
         GlStateManager.enableCull();
         float_17 = float_7 * 6.2831855F;
         this.wing.pitch = 0.125F - (float)Math.cos((double)float_17) * 0.2F;
         this.wing.yaw = 0.25F;
         this.wing.roll = (float)(Math.sin((double)float_17) + 0.125D) * 0.8F;
         this.wingTip.roll = -((float)(Math.sin((double)(float_17 + 2.0F)) + 0.5D)) * 0.75F;
         this.rearLeg.pitch = 1.0F + float_8 * 0.1F;
         this.rearLegTip.pitch = 0.5F + float_8 * 0.1F;
         this.rearFoot.pitch = 0.75F + float_8 * 0.1F;
         this.frontLeg.pitch = 1.3F + float_8 * 0.1F;
         this.frontLegTip.pitch = -0.5F - float_8 * 0.1F;
         this.frontFoot.pitch = 0.75F + float_8 * 0.1F;
         this.wing.render(float_6);
         this.frontLeg.render(float_6);
         this.rearLeg.render(float_6);
         GlStateManager.scalef(-1.0F, 1.0F, 1.0F);
         if (int_2 == 0) {
            GlStateManager.cullFace(GlStateManager.FaceSides.FRONT);
         }
      }

      GlStateManager.popMatrix();
      GlStateManager.cullFace(GlStateManager.FaceSides.BACK);
      GlStateManager.disableCull();
      float float_18 = -((float)Math.sin((double)(float_7 * 6.2831855F))) * 0.0F;
      float_15 = float_7 * 6.2831855F;
      float_10 = 10.0F;
      float_11 = 60.0F;
      float_9 = 0.0F;
      doubles_1 = enderDragonEntity_1.method_6817(11, this.delta);

      for(int int_3 = 0; int_3 < 12; ++int_3) {
         doubles_3 = enderDragonEntity_1.method_6817(12 + int_3, this.delta);
         float_18 = (float)((double)float_18 + Math.sin((double)((float)int_3 * 0.45F + float_15)) * 0.05000000074505806D);
         this.neck.yaw = (this.updateRotations(doubles_3[0] - doubles_1[0]) * 1.5F + 180.0F) * 0.017453292F;
         this.neck.pitch = float_18 + (float)(doubles_3[1] - doubles_1[1]) * 0.017453292F * 1.5F * 5.0F;
         this.neck.roll = this.updateRotations(doubles_3[0] - (double)float_14) * 0.017453292F * 1.5F;
         this.neck.rotationPointY = float_10;
         this.neck.rotationPointZ = float_11;
         this.neck.rotationPointX = float_9;
         float_10 = (float)((double)float_10 + Math.sin((double)this.neck.pitch) * 10.0D);
         float_11 = (float)((double)float_11 - Math.cos((double)this.neck.yaw) * Math.cos((double)this.neck.pitch) * 10.0D);
         float_9 = (float)((double)float_9 - Math.sin((double)this.neck.yaw) * Math.cos((double)this.neck.pitch) * 10.0D);
         this.neck.render(float_6);
      }

      GlStateManager.popMatrix();
   }

   private float updateRotations(double double_1) {
      while(double_1 >= 180.0D) {
         double_1 -= 360.0D;
      }

      while(double_1 < -180.0D) {
         double_1 += 360.0D;
      }

      return (float)double_1;
   }

}
