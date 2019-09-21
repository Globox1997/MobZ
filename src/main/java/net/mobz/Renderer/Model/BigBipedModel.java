package net.mobz.Renderer.Model;

/*
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class BigBipedModel<T extends LivingEntity> extends EntityModel<T> implements ModelWithArms, ModelWithHead {
   public Cuboid head;
   public Cuboid headwear;
   public Cuboid body;
   public Cuboid rightArm;
   public Cuboid leftArm;
   public Cuboid rightLeg;
   public Cuboid leftLeg;
   public BigBipedModel.ArmPose leftArmPose;
   public BigBipedModel.ArmPose rightArmPose;
   public boolean isSneaking;
   public float field_3396;
   private float field_3393;

   public BigBipedModel() {
      this(0.0F);
   }

   public BigBipedModel(float float_1) {
      this(float_1, 0.0F, 64, 32);
   }

   public BigBipedModel(float float_1, float float_2, int int_1, int int_2) {
      this.leftArmPose = BigBipedModel.ArmPose.EMPTY;
      this.rightArmPose = BigBipedModel.ArmPose.EMPTY;
      this.textureWidth = int_1;
      this.textureHeight = int_2;
      this.head = new Cuboid(this, 0, 0);
      this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, float_1);
      this.head.setRotationPoint(0.0F, 0.0F + float_2, 0.0F);
      this.headwear = new Cuboid(this, 32, 0);
      this.headwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, float_1 + 0.5F);
      this.headwear.setRotationPoint(0.0F, 0.0F + float_2, 0.0F);
      this.body = new Cuboid(this, 16, 16);
      this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, float_1);
      this.body.setRotationPoint(0.0F, 0.0F + float_2, 0.0F);
      this.rightArm = new Cuboid(this, 40, 16);
      this.rightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, float_1);
      this.rightArm.setRotationPoint(-5.0F, 2.0F + float_2, 0.0F);
      this.leftArm = new Cuboid(this, 40, 16);
      this.leftArm.mirror = true;
      this.leftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, float_1);
      this.leftArm.setRotationPoint(5.0F, 2.0F + float_2, 0.0F);
      this.rightLeg = new Cuboid(this, 0, 16);
      this.rightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, float_1);
      this.rightLeg.setRotationPoint(-1.9F, 12.0F + float_2, 0.0F);
      this.leftLeg = new Cuboid(this, 0, 16);
      this.leftLeg.mirror = true;
      this.leftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, float_1);
      this.leftLeg.setRotationPoint(1.9F, 12.0F + float_2, 0.0F);
   }



   public void method_17086(T livingEntity_1, float float_1, float float_2, float float_3) {
      this.field_3396 = livingEntity_1.method_6024(float_3);
      this.field_3393 = (float)livingEntity_1.getItemUseTime();
      super.animateModel(livingEntity_1, float_1, float_2, float_3);
   }

   public void method_17087(T livingEntity_1, float float_1, float float_2, float float_3, float float_4, float float_5, float float_6) {
      boolean boolean_1 = livingEntity_1.method_6003() > 4;
      boolean boolean_2 = livingEntity_1.isInSwimmingPose();
      this.head.yaw = float_4 * 0.017453292F;
      if (boolean_1) {
         this.head.pitch = -0.7853982F;
      } else if (this.field_3396 > 0.0F) {
         if (boolean_2) {
            this.head.pitch = this.method_2804(this.head.pitch, -0.7853982F, this.field_3396);
         } else {
            this.head.pitch = this.method_2804(this.head.pitch, float_5 * 0.017453292F, this.field_3396);
         }
      } else {
         this.head.pitch = float_5 * 0.017453292F;
      }

      this.body.yaw = 0.0F;
      this.rightArm.rotationPointZ = 0.0F;
      this.rightArm.rotationPointX = -5.0F;
      this.leftArm.rotationPointZ = 0.0F;
      this.leftArm.rotationPointX = 5.0F;
      float float_7 = 1.0F;
      if (boolean_1) {
         float_7 = (float)livingEntity_1.getVelocity().lengthSquared();
         float_7 /= 0.2F;
         float_7 *= float_7 * float_7;
      }

      if (float_7 < 1.0F) {
         float_7 = 1.0F;
      }

      this.rightArm.pitch = MathHelper.cos(float_1 * 0.6662F + 3.1415927F) * 2.0F * float_2 * 0.5F / float_7;
      this.leftArm.pitch = MathHelper.cos(float_1 * 0.6662F) * 2.0F * float_2 * 0.5F / float_7;
      this.rightArm.roll = 0.0F;
      this.leftArm.roll = 0.0F;
      this.rightLeg.pitch = MathHelper.cos(float_1 * 0.6662F) * 1.4F * float_2 / float_7;
      this.leftLeg.pitch = MathHelper.cos(float_1 * 0.6662F + 3.1415927F) * 1.4F * float_2 / float_7;
      this.rightLeg.yaw = 0.0F;
      this.leftLeg.yaw = 0.0F;
      this.rightLeg.roll = 0.0F;
      this.leftLeg.roll = 0.0F;
      Cuboid var10000;
      if (this.isRiding) {
         var10000 = this.rightArm;
         var10000.pitch += -0.62831855F;
         var10000 = this.leftArm;
         var10000.pitch += -0.62831855F;
         this.rightLeg.pitch = -1.4137167F;
         this.rightLeg.yaw = 0.31415927F;
         this.rightLeg.roll = 0.07853982F;
         this.leftLeg.pitch = -1.4137167F;
         this.leftLeg.yaw = -0.31415927F;
         this.leftLeg.roll = -0.07853982F;
      }

      this.rightArm.yaw = 0.0F;
      this.rightArm.roll = 0.0F;
      switch(this.leftArmPose) {
      case EMPTY:
         this.leftArm.yaw = 0.0F;
         break;
      case BLOCK:
         this.leftArm.pitch = this.leftArm.pitch * 0.5F - 0.9424779F;
         this.leftArm.yaw = 0.5235988F;
         break;
      case ITEM:
         this.leftArm.pitch = this.leftArm.pitch * 0.5F - 0.31415927F;
         this.leftArm.yaw = 0.0F;
      }

      switch(this.rightArmPose) {
      case EMPTY:
         this.rightArm.yaw = 0.0F;
         break;
      case BLOCK:
         this.rightArm.pitch = this.rightArm.pitch * 0.5F - 0.9424779F;
         this.rightArm.yaw = -0.5235988F;
         break;
      case ITEM:
         this.rightArm.pitch = this.rightArm.pitch * 0.5F - 0.31415927F;
         this.rightArm.yaw = 0.0F;
         break;
      case THROW_SPEAR:
         this.rightArm.pitch = this.rightArm.pitch * 0.5F - 3.1415927F;
         this.rightArm.yaw = 0.0F;
      }

      if (this.leftArmPose == BigBipedModel.ArmPose.THROW_SPEAR && this.rightArmPose != BigBipedModel.ArmPose.BLOCK && this.rightArmPose != BigBipedModel.ArmPose.THROW_SPEAR && this.rightArmPose != BigBipedModel.ArmPose.BOW_AND_ARROW) {
         this.leftArm.pitch = this.leftArm.pitch * 0.5F - 3.1415927F;
         this.leftArm.yaw = 0.0F;
      }

      float float_15;
      float float_17;
      float float_19;
      if (this.handSwingProgress > 0.0F) {
         Arm arm_1 = this.getPreferredArm(livingEntity_1);
         Cuboid cuboid_1 = this.getArm(arm_1);
         float_15 = this.handSwingProgress;
         this.body.yaw = MathHelper.sin(MathHelper.sqrt(float_15) * 6.2831855F) * 0.2F;
         if (arm_1 == Arm.LEFT) {
            var10000 = this.body;
            var10000.yaw *= -1.0F;
         }

         this.rightArm.rotationPointZ = MathHelper.sin(this.body.yaw) * 5.0F;
         this.rightArm.rotationPointX = -MathHelper.cos(this.body.yaw) * 5.0F;
         this.leftArm.rotationPointZ = -MathHelper.sin(this.body.yaw) * 5.0F;
         this.leftArm.rotationPointX = MathHelper.cos(this.body.yaw) * 5.0F;
         var10000 = this.rightArm;
         var10000.yaw += this.body.yaw;
         var10000 = this.leftArm;
         var10000.yaw += this.body.yaw;
         var10000 = this.leftArm;
         var10000.pitch += this.body.yaw;
         float_15 = 1.0F - this.handSwingProgress;
         float_15 *= float_15;
         float_15 *= float_15;
         float_15 = 1.0F - float_15;
         float_17 = MathHelper.sin(float_15 * 3.1415927F);
         float_19 = MathHelper.sin(this.handSwingProgress * 3.1415927F) * -(this.head.pitch - 0.7F) * 0.75F;
         cuboid_1.pitch = (float)((double)cuboid_1.pitch - ((double)float_17 * 1.2D + (double)float_19));
         cuboid_1.yaw += this.body.yaw * 2.0F;
         cuboid_1.roll += MathHelper.sin(this.handSwingProgress * 3.1415927F) * -0.4F;
      }

      if (this.isSneaking) {
         this.body.pitch = 0.5F;
         var10000 = this.rightArm;
         var10000.pitch += 0.4F;
         var10000 = this.leftArm;
         var10000.pitch += 0.4F;
         this.rightLeg.rotationPointZ = 4.0F;
         this.leftLeg.rotationPointZ = 4.0F;
         this.rightLeg.rotationPointY = 9.0F;
         this.leftLeg.rotationPointY = 9.0F;
         this.head.rotationPointY = 1.0F;
      } else {
         this.body.pitch = 0.0F;
         this.rightLeg.rotationPointZ = 0.1F;
         this.leftLeg.rotationPointZ = 0.1F;
         this.rightLeg.rotationPointY = 12.0F;
         this.leftLeg.rotationPointY = 12.0F;
         this.head.rotationPointY = 0.0F;
      }

      var10000 = this.rightArm;
      var10000.roll += MathHelper.cos(float_3 * 0.09F) * 0.05F + 0.05F;
      var10000 = this.leftArm;
      var10000.roll -= MathHelper.cos(float_3 * 0.09F) * 0.05F + 0.05F;
      var10000 = this.rightArm;
      var10000.pitch += MathHelper.sin(float_3 * 0.067F) * 0.05F;
      var10000 = this.leftArm;
      var10000.pitch -= MathHelper.sin(float_3 * 0.067F) * 0.05F;
      if (this.rightArmPose == BigBipedModel.ArmPose.BOW_AND_ARROW) {
         this.rightArm.yaw = -0.1F + this.head.yaw;
         this.leftArm.yaw = 0.1F + this.head.yaw + 0.4F;
         this.rightArm.pitch = -1.5707964F + this.head.pitch;
         this.leftArm.pitch = -1.5707964F + this.head.pitch;
      } else if (this.leftArmPose == BigBipedModel.ArmPose.BOW_AND_ARROW && this.rightArmPose != BigBipedModel.ArmPose.THROW_SPEAR && this.rightArmPose != BigBipedModel.ArmPose.BLOCK) {
         this.rightArm.yaw = -0.1F + this.head.yaw - 0.4F;
         this.leftArm.yaw = 0.1F + this.head.yaw;
         this.rightArm.pitch = -1.5707964F + this.head.pitch;
         this.leftArm.pitch = -1.5707964F + this.head.pitch;
      }

      float float_11 = (float)CrossbowItem.getPullTime(livingEntity_1.getActiveItem());
      float float_14;
      if (this.rightArmPose == BigBipedModel.ArmPose.CROSSBOW_CHARGE) {
         this.rightArm.yaw = -0.8F;
         this.rightArm.pitch = -0.97079635F;
         this.leftArm.pitch = -0.97079635F;
         float_14 = MathHelper.clamp(this.field_3393, 0.0F, float_11);
         this.leftArm.yaw = MathHelper.lerp(float_14 / float_11, 0.4F, 0.85F);
         this.leftArm.pitch = MathHelper.lerp(float_14 / float_11, this.leftArm.pitch, -1.5707964F);
      } else if (this.leftArmPose == BigBipedModel.ArmPose.CROSSBOW_CHARGE) {
         this.leftArm.yaw = 0.8F;
         this.rightArm.pitch = -0.97079635F;
         this.leftArm.pitch = -0.97079635F;
         float_14 = MathHelper.clamp(this.field_3393, 0.0F, float_11);
         this.rightArm.yaw = MathHelper.lerp(float_14 / float_11, -0.4F, -0.85F);
         this.rightArm.pitch = MathHelper.lerp(float_14 / float_11, this.rightArm.pitch, -1.5707964F);
      }

      if (this.rightArmPose == BigBipedModel.ArmPose.CROSSBOW_HOLD && this.handSwingProgress <= 0.0F) {
         this.rightArm.yaw = -0.3F + this.head.yaw;
         this.leftArm.yaw = 0.6F + this.head.yaw;
         this.rightArm.pitch = -1.5707964F + this.head.pitch + 0.1F;
         this.leftArm.pitch = -1.5F + this.head.pitch;
      } else if (this.leftArmPose == BigBipedModel.ArmPose.CROSSBOW_HOLD) {
         this.rightArm.yaw = -0.6F + this.head.yaw;
         this.leftArm.yaw = 0.3F + this.head.yaw;
         this.rightArm.pitch = -1.5F + this.head.pitch;
         this.leftArm.pitch = -1.5707964F + this.head.pitch + 0.1F;
      }

      if (this.field_3396 > 0.0F) {
         float_14 = float_1 % 26.0F;
         float_15 = this.handSwingProgress > 0.0F ? 0.0F : this.field_3396;
         if (float_14 < 14.0F) {
            this.leftArm.pitch = this.method_2804(this.leftArm.pitch, 0.0F, this.field_3396);
            this.rightArm.pitch = MathHelper.lerp(float_15, this.rightArm.pitch, 0.0F);
            this.leftArm.yaw = this.method_2804(this.leftArm.yaw, 3.1415927F, this.field_3396);
            this.rightArm.yaw = MathHelper.lerp(float_15, this.rightArm.yaw, 3.1415927F);
            this.leftArm.roll = this.method_2804(this.leftArm.roll, 3.1415927F + 1.8707964F * this.method_2807(float_14) / this.method_2807(14.0F), this.field_3396);
            this.rightArm.roll = MathHelper.lerp(float_15, this.rightArm.roll, 3.1415927F - 1.8707964F * this.method_2807(float_14) / this.method_2807(14.0F));
         } else if (float_14 >= 14.0F && float_14 < 22.0F) {
            float_17 = (float_14 - 14.0F) / 8.0F;
            this.leftArm.pitch = this.method_2804(this.leftArm.pitch, 1.5707964F * float_17, this.field_3396);
            this.rightArm.pitch = MathHelper.lerp(float_15, this.rightArm.pitch, 1.5707964F * float_17);
            this.leftArm.yaw = this.method_2804(this.leftArm.yaw, 3.1415927F, this.field_3396);
            this.rightArm.yaw = MathHelper.lerp(float_15, this.rightArm.yaw, 3.1415927F);
            this.leftArm.roll = this.method_2804(this.leftArm.roll, 5.012389F - 1.8707964F * float_17, this.field_3396);
            this.rightArm.roll = MathHelper.lerp(float_15, this.rightArm.roll, 1.2707963F + 1.8707964F * float_17);
         } else if (float_14 >= 22.0F && float_14 < 26.0F) {
            float_17 = (float_14 - 22.0F) / 4.0F;
            this.leftArm.pitch = this.method_2804(this.leftArm.pitch, 1.5707964F - 1.5707964F * float_17, this.field_3396);
            this.rightArm.pitch = MathHelper.lerp(float_15, this.rightArm.pitch, 1.5707964F - 1.5707964F * float_17);
            this.leftArm.yaw = this.method_2804(this.leftArm.yaw, 3.1415927F, this.field_3396);
            this.rightArm.yaw = MathHelper.lerp(float_15, this.rightArm.yaw, 3.1415927F);
            this.leftArm.roll = this.method_2804(this.leftArm.roll, 3.1415927F, this.field_3396);
            this.rightArm.roll = MathHelper.lerp(float_15, this.rightArm.roll, 3.1415927F);
         }

         float_17 = 0.3F;
         float_19 = 0.33333334F;
         this.leftLeg.pitch = MathHelper.lerp(this.field_3396, this.leftLeg.pitch, 0.3F * MathHelper.cos(float_1 * 0.33333334F + 3.1415927F));
         this.rightLeg.pitch = MathHelper.lerp(this.field_3396, this.rightLeg.pitch, 0.3F * MathHelper.cos(float_1 * 0.33333334F));
      }

      this.headwear.copyRotation(this.head);
   }

   protected float method_2804(float float_1, float float_2, float float_3) {
      float float_4 = (float_2 - float_1) % 6.2831855F;
      if (float_4 < -3.1415927F) {
         float_4 += 6.2831855F;
      }

      if (float_4 >= 3.1415927F) {
         float_4 -= 6.2831855F;
      }

      return float_1 + float_3 * float_4;
   }

   private float method_2807(float float_1) {
      return -65.0F * float_1 + float_1 * float_1;
   }

   public void setAttributes(BigBipedModel<T> BigBipedModel_1) {
      super.copyStateTo(BigBipedModel_1);
      BigBipedModel_1.leftArmPose = this.leftArmPose;
      BigBipedModel_1.rightArmPose = this.rightArmPose;
      BigBipedModel_1.isSneaking = this.isSneaking;
   }

   public void setVisible(boolean boolean_1) {
      this.head.visible = boolean_1;
      this.headwear.visible = boolean_1;
      this.body.visible = boolean_1;
      this.rightArm.visible = boolean_1;
      this.leftArm.visible = boolean_1;
      this.rightLeg.visible = boolean_1;
      this.leftLeg.visible = boolean_1;
   }

   public void setArmAngle(float float_1, Arm arm_1) {
      this.getArm(arm_1).applyTransform(float_1);
   }

   protected Cuboid getArm(Arm arm_1) {
      return arm_1 == Arm.LEFT ? this.leftArm : this.rightArm;
   }

   public Cuboid getHead() {
      return this.head;
   }

   protected Arm getPreferredArm(T livingEntity_1) {
      Arm arm_1 = livingEntity_1.getMainArm();
      return livingEntity_1.preferredHand == Hand.MAIN_HAND ? arm_1 : arm_1.getOpposite();
   }

   @Environment(EnvType.CLIENT)
   public static enum ArmPose {
      EMPTY,
      ITEM,
      BLOCK,
      BOW_AND_ARROW,
      THROW_SPEAR,
      CROSSBOW_CHARGE,
      CROSSBOW_HOLD;
   }
}
*/

import com.mojang.blaze3d.platform.GlStateManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Arm;

@Environment(EnvType.CLIENT)
public class BigBipedModel<T extends LivingEntity> extends BipedEntityModel<T> {
   public final Cuboid leftArmOverlay;
   public final Cuboid rightArmOverlay;
   public final Cuboid leftLegOverlay;
   public final Cuboid rightLegOverlay;
   public final Cuboid bodyOverlay;
   private final Cuboid cape;
   private final Cuboid ears;
   private final boolean thinArms;

   public BigBipedModel(float float_1, boolean boolean_1) {
      super(float_1, 0.0F, 64, 64);
      this.thinArms = boolean_1;
      this.ears = new Cuboid(this, 24, 0);
      this.ears.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, float_1);
      this.cape = new Cuboid(this, 0, 0);
      this.cape.setTextureSize(64, 32);
      this.cape.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, float_1);
      if (boolean_1) {
         this.leftArm = new Cuboid(this, 32, 48);
         this.leftArm.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, float_1);
         this.leftArm.setRotationPoint(5.0F, 2.5F, 0.0F);
         this.rightArm = new Cuboid(this, 40, 16);
         this.rightArm.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, float_1);
         this.rightArm.setRotationPoint(-5.0F, 2.5F, 0.0F);
         this.leftArmOverlay = new Cuboid(this, 48, 48);
         this.leftArmOverlay.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, float_1 + 0.25F);
         this.leftArmOverlay.setRotationPoint(5.0F, 2.5F, 0.0F);
         this.rightArmOverlay = new Cuboid(this, 40, 32);
         this.rightArmOverlay.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, float_1 + 0.25F);
         this.rightArmOverlay.setRotationPoint(-5.0F, 2.5F, 10.0F);
      } else {
         this.leftArm = new Cuboid(this, 32, 48);
         this.leftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, float_1);
         this.leftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
         this.leftArmOverlay = new Cuboid(this, 48, 48);
         this.leftArmOverlay.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, float_1 + 0.25F);
         this.leftArmOverlay.setRotationPoint(5.0F, 2.0F, 0.0F);
         this.rightArmOverlay = new Cuboid(this, 40, 32);
         this.rightArmOverlay.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, float_1 + 0.25F);
         this.rightArmOverlay.setRotationPoint(-5.0F, 2.0F, 10.0F);
         
      }

      this.leftLeg = new Cuboid(this, 16, 48);
      this.leftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, float_1);
      this.leftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
      this.leftLegOverlay = new Cuboid(this, 0, 48);
      this.leftLegOverlay.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, float_1 + 0.25F);
      this.leftLegOverlay.setRotationPoint(1.9F, 12.0F, 0.0F);
      this.rightLegOverlay = new Cuboid(this, 0, 32);
      this.rightLegOverlay.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, float_1 + 0.25F);
      this.rightLegOverlay.setRotationPoint(-1.9F, 12.0F, 0.0F);
      this.bodyOverlay = new Cuboid(this, 16, 32);
      this.bodyOverlay.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, float_1 + 0.25F);
      this.bodyOverlay.setRotationPoint(0.0F, 0.0F, 0.0F);
   }

   public void method_17088(T livingEntity_1, float float_1, float float_2, float float_3, float float_4, float float_5, float float_6) {
      super.method_17088(livingEntity_1, float_1, float_2, float_3, float_4, float_5, float_6);
      GlStateManager.pushMatrix();
      if (this.isChild) {
         float float_7 = 2.0F;
         GlStateManager.scalef(0.5F, 0.5F, 0.5F);
         GlStateManager.translatef(0.0F, 24.0F * float_6, 0.0F);
         this.leftLegOverlay.render(float_6);
         this.rightLegOverlay.render(float_6);
         this.leftArmOverlay.render(float_6);
         this.rightArmOverlay.render(float_6);
         this.bodyOverlay.render(float_6);
      } else {
         if (livingEntity_1.isInSneakingPose()) {
            GlStateManager.translatef(0.0F, 0.2F, 0.0F);
         }

         this.leftLegOverlay.render(float_6);
         this.rightLegOverlay.render(float_6);
         this.leftArmOverlay.render(float_6);
         this.rightArmOverlay.render(float_6);
         this.bodyOverlay.render(float_6);
      }

      GlStateManager.popMatrix();
   }

   public void renderEars(float float_1) {
      this.ears.copyRotation(this.head);
      this.ears.rotationPointX = 0.0F;
      this.ears.rotationPointY = 0.0F;
      this.ears.render(float_1);
   }

   public void renderCape(float float_1) {
      this.cape.render(float_1);
   }

   public void method_17087(T livingEntity_1, float float_1, float float_2, float float_3, float float_4, float float_5, float float_6) {
      super.method_17087(livingEntity_1, float_1, float_2, float_3, float_4, float_5, float_6);
      this.leftLegOverlay.copyRotation(this.leftLeg);
      this.rightLegOverlay.copyRotation(this.rightLeg);
      this.leftArmOverlay.copyRotation(this.leftArm);
      this.rightArmOverlay.copyRotation(this.rightArm);
      this.bodyOverlay.copyRotation(this.body);
      if (livingEntity_1.isInSneakingPose()) {
         this.cape.rotationPointY = 2.0F;
      } else {
         this.cape.rotationPointY = 0.0F;
      }

   }

   public void setVisible(boolean boolean_1) {
      super.setVisible(boolean_1);
      this.leftArmOverlay.visible = boolean_1;
      this.rightArmOverlay.visible = boolean_1;
      this.leftLegOverlay.visible = boolean_1;
      this.rightLegOverlay.visible = boolean_1;
      this.bodyOverlay.visible = boolean_1;
      this.cape.visible = boolean_1;
      this.ears.visible = boolean_1;
   }

   public void setArmAngle(float float_1, Arm arm_1) {
      Cuboid cuboid_1 = this.getArm(arm_1);
      if (this.thinArms) {
         float float_2 = 0.5F * (float)(arm_1 == Arm.RIGHT ? 1 : -1);
         cuboid_1.rotationPointX += float_2;
         cuboid_1.applyTransform(float_1);
         cuboid_1.rotationPointX -= float_2;
      } else {
         cuboid_1.applyTransform(float_1);
      }

   }
}
// Testmodel