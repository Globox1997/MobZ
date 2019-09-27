package net.mobz.Renderer.Model;

import org.lwjgl.opengl.GL11;

/*

    public ModelRenderer rightarm;
    public ModelRenderer rightleg;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer leftarm;
    public ModelRenderer leftleg;
    public ModelRenderer headbox;

    public SmallModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.leftleg = new ModelRenderer(this, 40, 24);
        this.leftleg.mirror = true;
        this.leftleg.setRotationPoint(1.6F, 15.7F, 0.1F);
        this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.rightleg = new ModelRenderer(this, 0, 16);
        this.rightleg.setRotationPoint(-1.6F, 15.7F, 0.1F);
        this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.head.addBox(-4.0F, -7.0F, -4.0F, 8, 8, 8, 0.0F);
        this.leftarm = new ModelRenderer(this, 40, 16);
        this.leftarm.mirror = true;
        this.leftarm.setRotationPoint(4.4F, 7.4F, 0.0F);
        this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(leftarm, -1.3962634015954636F, 0.10000736613927509F, -0.10000736613927509F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.headbox = new ModelRenderer(this, 32, 0);
        this.headbox.setRotationPoint(0.0F, 4.5F, 0.0F);
        this.headbox.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.rightarm = new ModelRenderer(this, 40, 16);
        this.rightarm.setRotationPoint(-4.4F, 7.2F, 0.0F);
        this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(rightarm, -1.3962634015954636F, -0.10000736613927509F, 0.10000736613927509F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.leftleg.offsetX, this.leftleg.offsetY, this.leftleg.offsetZ);
        GlStateManager.translate(this.leftleg.rotationPointX * f5, this.leftleg.rotationPointY * f5, this.leftleg.rotationPointZ * f5);
        GlStateManager.scale(0.8D, 0.7D, 0.7D);
        GlStateManager.translate(-this.leftleg.offsetX, -this.leftleg.offsetY, -this.leftleg.offsetZ);
        GlStateManager.translate(-this.leftleg.rotationPointX * f5, -this.leftleg.rotationPointY * f5, -this.leftleg.rotationPointZ * f5);
        this.leftleg.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.rightleg.offsetX, this.rightleg.offsetY, this.rightleg.offsetZ);
        GlStateManager.translate(this.rightleg.rotationPointX * f5, this.rightleg.rotationPointY * f5, this.rightleg.rotationPointZ * f5);
        GlStateManager.scale(0.8D, 0.7D, 0.7D);
        GlStateManager.translate(-this.rightleg.offsetX, -this.rightleg.offsetY, -this.rightleg.offsetZ);
        GlStateManager.translate(-this.rightleg.rotationPointX * f5, -this.rightleg.rotationPointY * f5, -this.rightleg.rotationPointZ * f5);
        this.rightleg.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.head.offsetX, this.head.offsetY, this.head.offsetZ);
        GlStateManager.translate(this.head.rotationPointX * f5, this.head.rotationPointY * f5, this.head.rotationPointZ * f5);
        GlStateManager.scale(0.9D, 0.9D, 0.9D);
        GlStateManager.translate(-this.head.offsetX, -this.head.offsetY, -this.head.offsetZ);
        GlStateManager.translate(-this.head.rotationPointX * f5, -this.head.rotationPointY * f5, -this.head.rotationPointZ * f5);
        this.head.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.leftarm.offsetX, this.leftarm.offsetY, this.leftarm.offsetZ);
        GlStateManager.translate(this.leftarm.rotationPointX * f5, this.leftarm.rotationPointY * f5, this.leftarm.rotationPointZ * f5);
        GlStateManager.scale(0.7D, 0.7D, 0.7D);
        GlStateManager.translate(-this.leftarm.offsetX, -this.leftarm.offsetY, -this.leftarm.offsetZ);
        GlStateManager.translate(-this.leftarm.rotationPointX * f5, -this.leftarm.rotationPointY * f5, -this.leftarm.rotationPointZ * f5);
        this.leftarm.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.body.offsetX, this.body.offsetY, this.body.offsetZ);
        GlStateManager.translate(this.body.rotationPointX * f5, this.body.rotationPointY * f5, this.body.rotationPointZ * f5);
        GlStateManager.scale(0.9D, 0.9D, 0.9D);
        GlStateManager.translate(-this.body.offsetX, -this.body.offsetY, -this.body.offsetZ);
        GlStateManager.translate(-this.body.rotationPointX * f5, -this.body.rotationPointY * f5, -this.body.rotationPointZ * f5);
        this.body.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.headbox.offsetX, this.headbox.offsetY, this.headbox.offsetZ);
        GlStateManager.translate(this.headbox.rotationPointX * f5, this.headbox.rotationPointY * f5, this.headbox.rotationPointZ * f5);
        GlStateManager.scale(0.8D, 0.8D, 0.8D);
        GlStateManager.translate(-this.headbox.offsetX, -this.headbox.offsetY, -this.headbox.offsetZ);
        GlStateManager.translate(-this.headbox.rotationPointX * f5, -this.headbox.rotationPointY * f5, -this.headbox.rotationPointZ * f5);
        this.headbox.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.rightarm.offsetX, this.rightarm.offsetY, this.rightarm.offsetZ);
        GlStateManager.translate(this.rightarm.rotationPointX * f5, this.rightarm.rotationPointY * f5, this.rightarm.rotationPointZ * f5);
        GlStateManager.scale(0.7D, 0.7D, 0.7D);
        GlStateManager.translate(-this.rightarm.offsetX, -this.rightarm.offsetY, -this.rightarm.offsetZ);
        GlStateManager.translate(-this.rightarm.rotationPointX * f5, -this.rightarm.rotationPointY * f5, -this.rightarm.rotationPointZ * f5);
        this.rightarm.render(f5);
        GlStateManager.popMatrix();
    }


    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
} */

import com.mojang.blaze3d.platform.GlStateManager;
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
public class SmallModel<T extends LivingEntity> extends EntityModel<T> implements ModelWithArms {

    public Cuboid head;
    public Cuboid headbox;
    public Cuboid body;
    public Cuboid rightarm;
    public Cuboid leftarm;
    public Cuboid rightleg;
    public Cuboid leftleg;

    public boolean isSneaking;
    public float field_3396;
    private float field_3393;

    public SmallModel() {
        this(0.0F);
    }

    public SmallModel(float float_1) {
        this(float_1, 0.0F, 64, 32);
    }

    public SmallModel(float float_1, float float_2, int int_1, int int_2) {

        this.textureWidth = int_1;
        this.textureHeight = int_2;
        this.head = new Cuboid(this, 0, 0);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, float_1);
        this.head.setRotationPoint(0.0F, 0.0F + float_2, 0.0F);
        this.headbox = new Cuboid(this, 32, 0);
        this.headbox.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, float_1 + 0.5F);
        this.headbox.setRotationPoint(0.0F, 0.0F + float_2, 0.0F);
        this.body = new Cuboid(this, 16, 16);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, float_1);
        this.body.setRotationPoint(0.0F, 0.0F + float_2, 0.0F);
        this.rightarm = new Cuboid(this, 40, 16);
        this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, float_1);
        this.rightarm.setRotationPoint(-5.0F, 2.0F + float_2, 0.0F);
        this.leftarm = new Cuboid(this, 40, 16);
        this.leftarm.mirror = true;
        this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, float_1);
        this.leftarm.setRotationPoint(5.0F, 2.0F + float_2, 0.0F);
        this.rightleg = new Cuboid(this, 0, 16);
        this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, float_1);
        this.rightleg.setRotationPoint(-1.9F, 12.0F + float_2, 0.0F);
        this.leftleg = new Cuboid(this, 0, 16);
        this.leftleg.mirror = true;
        this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, float_1);
        this.leftleg.setRotationPoint(1.9F, 12.0F + float_2, 0.0F);
    }

    public void method_17088(T livingEntity_1, float float_1, float float_2, float float_3, float float_4,
            float float_5, float float_6) {
        this.method_17087(livingEntity_1, float_1, float_2, float_3, float_4, float_5, float_6);
        GlStateManager.pushMatrix();
        if (this.isChild) {
            float float_7 = 2.0F;
            GlStateManager.scalef(0.75F, 0.75F, 0.75F);
            GlStateManager.translatef(0.0F, 16.0F * float_6, 0.0F);
            this.head.render(float_6);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scalef(0.5F, 0.5F, 0.5F);
            GlStateManager.translatef(0.0F, 24.0F * float_6, 0.0F);
            this.body.render(float_6);
            this.rightarm.render(float_6);
            this.leftarm.render(float_6);
            this.rightleg.render(float_6);
            this.leftleg.render(float_6);
            this.headbox.render(float_6);
        } else {
            if (livingEntity_1.isInSneakingPose()) {
                GlStateManager.translatef(0.0F, 0.2F, 0.0F);
            }

            this.head.render(float_6);
            this.body.render(float_6);
            this.rightarm.render(float_6);
            this.leftarm.render(float_6);
            this.rightleg.render(float_6);
            this.leftleg.render(float_6);
            this.headbox.render(float_6);
        }

        GlStateManager.popMatrix();
    }

    public void method_17086(T livingEntity_1, float float_1, float float_2, float float_3) {
        this.field_3396 = livingEntity_1.method_6024(float_3);
        this.field_3393 = (float) livingEntity_1.getItemUseTime();
        super.animateModel(livingEntity_1, float_1, float_2, float_3);
    }

    public void method_17087(T livingEntity_1, float float_1, float float_2, float float_3, float float_4,
            float float_5, float float_6) {
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
        this.rightarm.rotationPointZ = 0.0F;
        this.rightarm.rotationPointX = -5.0F;
        this.leftarm.rotationPointZ = 0.0F;
        this.leftarm.rotationPointX = 5.0F;
        float float_7 = 1.0F;
        if (boolean_1) {
            float_7 = (float) livingEntity_1.getVelocity().lengthSquared();
            float_7 /= 0.2F;
            float_7 *= float_7 * float_7;
        }

        if (float_7 < 1.0F) {
            float_7 = 1.0F;
        }

        this.rightarm.pitch = MathHelper.cos(float_1 * 0.6662F + 3.1415927F) * 2.0F * float_2 * 0.5F / float_7;
        this.leftarm.pitch = MathHelper.cos(float_1 * 0.6662F) * 2.0F * float_2 * 0.5F / float_7;
        this.rightarm.roll = 0.0F;
        this.leftarm.roll = 0.0F;
        this.rightleg.pitch = MathHelper.cos(float_1 * 0.6662F) * 1.4F * float_2 / float_7;
        this.leftleg.pitch = MathHelper.cos(float_1 * 0.6662F + 3.1415927F) * 1.4F * float_2 / float_7;
        this.rightleg.yaw = 0.0F;
        this.leftleg.yaw = 0.0F;
        this.rightleg.roll = 0.0F;
        this.leftleg.roll = 0.0F;
        Cuboid var10000;
        if (this.isRiding) {
            var10000 = this.rightarm;
            var10000.pitch += -0.62831855F;
            var10000 = this.leftarm;
            var10000.pitch += -0.62831855F;
            this.rightleg.pitch = -1.4137167F;
            this.rightleg.yaw = 0.31415927F;
            this.rightleg.roll = 0.07853982F;
            this.leftleg.pitch = -1.4137167F;
            this.leftleg.yaw = -0.31415927F;
            this.leftleg.roll = -0.07853982F;
        }
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

    @Override
    public void setArmAngle(float var1, Arm var2) {
        // TODO Auto-generated method stub

    }
}