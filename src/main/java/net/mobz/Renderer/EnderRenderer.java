package net.mobz.Renderer;

import net.mobz.Entity.*;
import net.mobz.Renderer.Model.EnderEye;
import net.fabricmc.api.Environment;

import java.util.Random;

import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.entity.model.EndermanEntityModel;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class EnderRenderer extends MobEntityRenderer <EnderEntity, EndermanEntityModel<EnderEntity>> {
    private final Random random = new Random();

    public EnderRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher,new EndermanEntityModel(0.0F), 0.5F);
        this.addFeature(new EnderEye(this));
  
    }

    protected Identifier getTexture(EnderEntity enderEntity) {
        return new Identifier("mobz:textures/entity/ender.png");
    }

    public void method_3911(EndermanEntity endermanEntity_1, double double_1, double double_2, double double_3, float float_1, float float_2) {
        BlockState blockState_1 = endermanEntity_1.getCarriedBlock();
        EndermanEntityModel<EndermanEntity> endermanEntityModel_1 = (EndermanEntityModel)this.getModel();
        endermanEntityModel_1.carryingBlock = blockState_1 != null;
        endermanEntityModel_1.angry = endermanEntity_1.isAngry();
        if (endermanEntity_1.isAngry()) {
           double double_4 = 0.02D;
           double_1 += this.random.nextGaussian() * 0.02D;
           double_3 += this.random.nextGaussian() * 0.02D;
        }
  
        super.method_4072((EnderEntity) endermanEntity_1, double_1, double_2, double_3, float_1, float_2);
     }
}