package net.mobz.Renderer.Model;

import com.mojang.blaze3d.platform.GlStateManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Cuboid;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.render.entity.model.EntityModel;

@Environment(EnvType.CLIENT)
public class GChick<T extends Entity> extends EntityModel<T> {
   private final Cuboid head;
   private final Cuboid field_3346;
   private final Cuboid field_3345;
   private final Cuboid field_3343;
   private final Cuboid field_3341;
   private final Cuboid field_3347;
   private final Cuboid field_3340;
   private final Cuboid field_3342;

   public GChick() {
      boolean int_1 = true;
      this.head = new Cuboid(this, 0, 0);
      this.head.addBox(-2.0F, -6.0F, -2.0F, 4, 6, 3, 0.0F);
      this.head.setRotationPoint(0.0F, 15.0F, -4.0F);
      this.field_3340 = new Cuboid(this, 14, 0);
      this.field_3340.addBox(-2.0F, -4.0F, -4.0F, 4, 2, 2, 0.0F);
      this.field_3340.setRotationPoint(0.0F, 15.0F, -4.0F);
      this.field_3342 = new Cuboid(this, 14, 4);
      this.field_3342.addBox(-1.0F, -2.0F, -3.0F, 2, 2, 2, 0.0F);
      this.field_3342.setRotationPoint(0.0F, 15.0F, -4.0F);
      this.field_3346 = new Cuboid(this, 0, 9);
      this.field_3346.addBox(-3.0F, -4.0F, -3.0F, 6, 8, 6, 0.0F);
      this.field_3346.setRotationPoint(0.0F, 16.0F, 0.0F);
      this.field_3345 = new Cuboid(this, 26, 0);
      this.field_3345.addBox(-1.0F, 0.0F, -3.0F, 3, 5, 3);
      this.field_3345.setRotationPoint(-2.0F, 19.0F, 1.0F);
      this.field_3343 = new Cuboid(this, 26, 0);
      this.field_3343.addBox(-1.0F, 0.0F, -3.0F, 3, 5, 3);
      this.field_3343.setRotationPoint(1.0F, 19.0F, 1.0F);
      this.field_3341 = new Cuboid(this, 24, 13);
      this.field_3341.addBox(0.0F, 0.0F, -3.0F, 1, 4, 6);
      this.field_3341.setRotationPoint(-4.0F, 13.0F, 0.0F);
      this.field_3347 = new Cuboid(this, 24, 13);
      this.field_3347.addBox(-1.0F, 0.0F, -3.0F, 1, 4, 6);
      this.field_3347.setRotationPoint(4.0F, 13.0F, 0.0F);
   }

   public void render(T entity_1, float float_1, float float_2, float float_3, float float_4, float float_5, float float_6) {
      this.setAngles(entity_1, float_1, float_2, float_3, float_4, float_5, float_6);
      if (this.isChild) {
         float float_7 = 2.0F;
         GlStateManager.pushMatrix();
         GlStateManager.translatef(0.0F, 5.0F * float_6, 2.0F * float_6);
         this.head.render(float_6);
         this.field_3340.render(float_6);
         this.field_3342.render(float_6);
         GlStateManager.popMatrix();
         GlStateManager.pushMatrix();
         GlStateManager.scalef(0.5F, 0.5F, 0.5F);
         GlStateManager.translatef(0.0F, 24.0F * float_6, 0.0F);
         this.field_3346.render(float_6);
         this.field_3345.render(float_6);
         this.field_3343.render(float_6);
         this.field_3341.render(float_6);
         this.field_3347.render(float_6);
         GlStateManager.popMatrix();
      } else {
         this.head.render(float_6);
         this.field_3340.render(float_6);
         this.field_3342.render(float_6);
         this.field_3346.render(float_6);
         this.field_3345.render(float_6);
         this.field_3343.render(float_6);
         this.field_3341.render(float_6);
         this.field_3347.render(float_6);
      }

   }

   public void setAngles(T entity_1, float float_1, float float_2, float float_3, float float_4, float float_5, float float_6) {
      float_3 = this.field_3346.roll;
      float_1 = this.field_3340.pitch;
      this.head.pitch = float_5 * 0.017453292F;
      this.head.yaw = float_4 * 0.017453292F;
      this.field_3340.pitch = this.head.pitch;
      this.field_3340.yaw = this.head.yaw;
      this.field_3342.pitch = this.head.pitch;
      this.field_3342.yaw = this.head.yaw;
      this.field_3346.pitch = 1.5707964F;
      this.field_3345.pitch = MathHelper.cos(float_1 * 0.6662F) * 1.4F * float_2;
      this.field_3343.pitch = MathHelper.cos(float_1 * 0.6662F + 3.1415927F) * 1.4F * float_2;
      this.field_3341.roll = float_3;
      this.field_3347.roll = -float_3;
   }
}
