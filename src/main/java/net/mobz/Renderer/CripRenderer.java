package net.mobz.Renderer;

import net.mobz.Entity.*;
import net.mobz.Renderer.Model.CreeperCharge;

import com.mojang.blaze3d.platform.GlStateManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class CripRenderer extends MobEntityRenderer<CripEntity, CreeperEntityModel<CripEntity>> {

    public CripRenderer(EntityRenderDispatcher entityRenderDispatcher_1) {
        super(entityRenderDispatcher_1, new CreeperEntityModel(), 0.5F);
        this.addFeature(new CreeperCharge(this));
    }

    protected void method_3900(CripEntity CripEntity_1, float float_1) {
        float float_2 = CripEntity_1.getClientFuseTime(float_1);
        float float_3 = 1.0F + MathHelper.sin(float_2 * 100.0F) * float_2 * 0.01F;
        float_2 = MathHelper.clamp(float_2, 0.0F, 1.0F);
        float_2 *= float_2;
        float_2 *= float_2;
        float float_4 = (1.0F + float_2 * 0.4F) * float_3;
        float float_5 = (1.0F + float_2 * 0.1F) / float_3;
        GlStateManager.scalef(float_4, float_5, float_4);
    }

    protected int method_3898(CripEntity CripEntity_1, float float_1, float float_2) {
        float float_3 = CripEntity_1.getClientFuseTime(float_2);
        if ((int) (float_3 * 10.0F) % 2 == 0) {
            return 0;
        } else {
            int int_1 = (int) (float_3 * 0.2F * 255.0F);
            int_1 = MathHelper.clamp(int_1, 0, 255);
            return int_1 << 24 | 822083583;
        }
    }

    @Override
    protected Identifier getTexture(CripEntity cripEntity) {
        return new Identifier("mobz:textures/entity/crip.png");
    }

}
