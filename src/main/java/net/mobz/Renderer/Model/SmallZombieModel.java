package net.mobz.Renderer.Model;





import com.mojang.blaze3d.platform.GlStateManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Arm;

@Environment(EnvType.CLIENT)
public class SmallZombieModel<T extends LivingEntity> extends BipedEntityModel<T> {

   public final Cuboid field_178723_h;
   public final Cuboid field_178721_j;
   public final Cuboid field_78116_c;
   public final Cuboid field_78115_e;
   public final Cuboid field_178724_i;
   public final Cuboid field_178722_k;
   public final Cuboid field_178720_f;

   public SmallZombieModel(float float_1, boolean boolean_1) {
      super(float_1, 0.0F, 64, 64);

      this.textureWidth = 64;
      this.textureHeight = 64;
      this.field_178723_h = new Cuboid(this, 0, 0);
      this.field_178723_h.setRotationPoint(-4.4F, 7.2F, 0.0F);
      this.field_178723_h.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.field_178723_h.setRotationPoint(-1.3962634015954636F, -0.10000736613927509F, 0.10000736613927509F);
      this.field_178722_k = new Cuboid(this, 40, 24);
      this.field_178722_k.mirror = true;
      this.field_178722_k.setRotationPoint(1.6F, 15.7F, 0.1F);
      this.field_178722_k.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.field_78115_e = new Cuboid(this, 0, 16);
      this.field_78115_e.setRotationPoint(0.0F, 5.0F, 0.0F);
      this.field_78115_e.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
      this.field_178721_j = new Cuboid(this, 16, 0);
      this.field_178721_j.setRotationPoint(-1.6F, 15.7F, 0.1F);
      this.field_178721_j.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
      this.field_178724_i = new Cuboid(this, 24, 24);
      this.field_178724_i.mirror = true;
      this.field_178724_i.setRotationPoint(4.4F, 7.4F, 0.0F);
      this.field_178724_i.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
      this.field_178724_i.setRotationPoint(-1.3962634015954636F, 0.10000736613927509F, -0.10000736613927509F);
      this.field_78116_c = new Cuboid(this, 24, 8);
      this.field_78116_c.setRotationPoint(0.0F, 4.0F, 0.0F);
      this.field_78116_c.addBox(-4.0F, -7.0F, -4.0F, 8, 8, 8, 0.0F);
      this.field_178720_f = new Cuboid(this, 0, 32);
      this.field_178720_f.setRotationPoint(0.0F, 4.5F, 0.0F);
      this.field_178720_f.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
   }

   public void method_17088(T livingEntity_1, float float_1, float float_2, float float_3, float float_4, float float_5, float float_6) {
      super.method_17088(livingEntity_1, float_1, float_2, float_3, float_4, float_5, float_6);
      GlStateManager.pushMatrix();
      if (this.isChild) {
         float float_7 = 2.0F;
         GlStateManager.scalef(0.5F, 0.5F, 0.5F);
         GlStateManager.translatef(0.0F, 24.0F * float_6, 0.0F);
         this.field_178723_h.render(float_6);
         this.field_178721_j.render(float_6);
         this.field_78116_c.render(float_6);
         this.field_78115_e.render(float_6);
         this.field_178724_i.render(float_6);
      } else {
         if (livingEntity_1.isInSneakingPose()) {
            GlStateManager.translatef(0.0F, 0.2F, 0.0F);
         }

         this.field_178723_h.render(float_6);
         this.field_178721_j.render(float_6);
         this.field_78116_c.render(float_6);
         this.field_78115_e.render(float_6);
         this.field_178724_i.render(float_6);
      }

      GlStateManager.popMatrix();
   }


/*
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
/*
   
   @Override
   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
       GlStateManager.pushMatrix();
       GlStateManager.translate(this.field_178723_h.offsetX, this.field_178723_h.offsetY, this.field_178723_h.offsetZ);
       GlStateManager.translate(this.field_178723_h.rotationPointX * f5, this.field_178723_h.rotationPointY * f5, this.field_178723_h.rotationPointZ * f5);
       GlStateManager.scale(0.7D, 0.7D, 0.7D);
       GlStateManager.translate(-this.field_178723_h.offsetX, -this.field_178723_h.offsetY, -this.field_178723_h.offsetZ);
       GlStateManager.translate(-this.field_178723_h.rotationPointX * f5, -this.field_178723_h.rotationPointY * f5, -this.field_178723_h.rotationPointZ * f5);
       this.field_178723_h.render(f5);
       GlStateManager.popMatrix();
       GlStateManager.pushMatrix();
       GlStateManager.translate(this.field_178722_k.offsetX, this.field_178722_k.offsetY, this.field_178722_k.offsetZ);
       GlStateManager.translate(this.field_178722_k.rotationPointX * f5, this.field_178722_k.rotationPointY * f5, this.field_178722_k.rotationPointZ * f5);
       GlStateManager.scale(0.8D, 0.7D, 0.7D);
       GlStateManager.translate(-this.field_178722_k.offsetX, -this.field_178722_k.offsetY, -this.field_178722_k.offsetZ);
       GlStateManager.translate(-this.field_178722_k.rotationPointX * f5, -this.field_178722_k.rotationPointY * f5, -this.field_178722_k.rotationPointZ * f5);
       this.field_178722_k.render(f5);
       GlStateManager.popMatrix();
       GlStateManager.pushMatrix();
       GlStateManager.translate(this.field_78115_e.offsetX, this.field_78115_e.offsetY, this.field_78115_e.offsetZ);
       GlStateManager.translate(this.field_78115_e.rotationPointX * f5, this.field_78115_e.rotationPointY * f5, this.field_78115_e.rotationPointZ * f5);
       GlStateManager.scale(0.9D, 0.9D, 0.9D);
       GlStateManager.translate(-this.field_78115_e.offsetX, -this.field_78115_e.offsetY, -this.field_78115_e.offsetZ);
       GlStateManager.translate(-this.field_78115_e.rotationPointX * f5, -this.field_78115_e.rotationPointY * f5, -this.field_78115_e.rotationPointZ * f5);
       this.field_78115_e.render(f5);
       GlStateManager.popMatrix();
       GlStateManager.pushMatrix();
       GlStateManager.translate(this.field_178721_j.offsetX, this.field_178721_j.offsetY, this.field_178721_j.offsetZ);
       GlStateManager.translate(this.field_178721_j.rotationPointX * f5, this.field_178721_j.rotationPointY * f5, this.field_178721_j.rotationPointZ * f5);
       GlStateManager.scale(0.8D, 0.7D, 0.7D);
       GlStateManager.translate(-this.field_178721_j.offsetX, -this.field_178721_j.offsetY, -this.field_178721_j.offsetZ);
       GlStateManager.translate(-this.field_178721_j.rotationPointX * f5, -this.field_178721_j.rotationPointY * f5, -this.field_178721_j.rotationPointZ * f5);
       this.field_178721_j.render(f5);
       GlStateManager.popMatrix();
       GlStateManager.pushMatrix();
       GlStateManager.translate(this.field_178724_i.offsetX, this.field_178724_i.offsetY, this.field_178724_i.offsetZ);
       GlStateManager.translate(this.field_178724_i.rotationPointX * f5, this.field_178724_i.rotationPointY * f5, this.field_178724_i.rotationPointZ * f5);
       GlStateManager.scale(0.7D, 0.7D, 0.7D);
       GlStateManager.translate(-this.field_178724_i.offsetX, -this.field_178724_i.offsetY, -this.field_178724_i.offsetZ);
       GlStateManager.translate(-this.field_178724_i.rotationPointX * f5, -this.field_178724_i.rotationPointY * f5, -this.field_178724_i.rotationPointZ * f5);
       this.field_178724_i.render(f5);
       GlStateManager.popMatrix();
       GlStateManager.pushMatrix();
       GlStateManager.translate(this.field_78116_c.offsetX, this.field_78116_c.offsetY, this.field_78116_c.offsetZ);
       GlStateManager.translate(this.field_78116_c.rotationPointX * f5, this.field_78116_c.rotationPointY * f5, this.field_78116_c.rotationPointZ * f5);
       GlStateManager.scale(0.9D, 0.9D, 0.9D);
       GlStateManager.translate(-this.field_78116_c.offsetX, -this.field_78116_c.offsetY, -this.field_78116_c.offsetZ);
       GlStateManager.translate(-this.field_78116_c.rotationPointX * f5, -this.field_78116_c.rotationPointY * f5, -this.field_78116_c.rotationPointZ * f5);
       this.field_78116_c.render(f5);
       GlStateManager.popMatrix();
       GlStateManager.pushMatrix();
       GlStateManager.translate(this.field_178720_f.offsetX, this.field_178720_f.offsetY, this.field_178720_f.offsetZ);
       GlStateManager.translate(this.field_178720_f.rotationPointX * f5, this.field_178720_f.rotationPointY * f5, this.field_178720_f.rotationPointZ * f5);
       GlStateManager.scale(0.8D, 0.8D, 0.8D);
       GlStateManager.translate(-this.field_178720_f.offsetX, -this.field_178720_f.offsetY, -this.field_178720_f.offsetZ);
       GlStateManager.translate(-this.field_178720_f.rotationPointX * f5, -this.field_178720_f.rotationPointY * f5, -this.field_178720_f.rotationPointZ * f5);
       this.field_178720_f.render(f5);
       GlStateManager.popMatrix();
   }


} */


}
