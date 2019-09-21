package net.mobz.Renderer.Model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Cuboid;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.MathHelper;

/*

@Environment(EnvType.CLIENT)


    public abstract class AbstractBigBossModel<T extends HostileEntity> extends BigBipedModel<T> {
        protected AbstractBigBossModel(float float_1, float float_2, int int_1, int int_2) {
           super(float_1, float_2, int_1, int_2);
        }
     
        public void method_17791(T hostileEntity_1, float float_1, float float_2, float float_3, float float_4, float float_5, float float_6) {
           super.method_17087(hostileEntity_1, float_1, float_2, float_3, float_4, float_5, float_6);
           boolean boolean_1 = this.method_17790(hostileEntity_1);
           float float_7 = MathHelper.sin(this.handSwingProgress * 3.1415927F);
           float float_8 = MathHelper.sin((1.0F - (1.0F - this.handSwingProgress) * (1.0F - this.handSwingProgress)) * 3.1415927F);
           this.rightArm.roll = 1.0F;
           this.leftArm.roll = 0.0F;
           this.rightArm.yaw = -(0.1F - float_7 * 0.6F);
           this.leftArm.yaw = 0.1F - float_7 * 0.6F;
           float float_9 = -3.1415927F / (boolean_1 ? 1.5F : 2.25F);
           this.rightArm.pitch = float_9;
           this.leftArm.pitch = float_9;
           Cuboid var10000 = this.rightArm;
           var10000.pitch += float_7 * 1.2F - float_8 * 0.4F;
           var10000 = this.leftArm;
           var10000.pitch += float_7 * 2.2F - float_8 * 0.4F;
           var10000 = this.rightArm;
           var10000.roll += MathHelper.cos(float_3 * 0.09F) * 0.05F + 0.05F;
           var10000 = this.leftArm;
           var10000.roll -= MathHelper.cos(float_3 * 0.09F) * 0.05F + 0.05F;
           var10000 = this.rightArm;
           var10000.pitch += MathHelper.sin(float_3 * 0.067F) * 0.05F;
           var10000 = this.leftArm;
           var10000.pitch -= MathHelper.sin(float_3 * 0.067F) * 0.05F;
        }
     
        public abstract boolean method_17790(T var1);
     } */