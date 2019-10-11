package net.mobz.Renderer;

import net.mobz.Entity.*;

import com.mojang.blaze3d.platform.GlStateManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.WolfEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class DogRenderer extends MobEntityRenderer<Dog, WolfEntityModel<Dog>> {
    private static final Identifier WILD_SKIN = new Identifier("mobz:textures/entity/dog.png");
    private static final Identifier TAMED_SKIN = new Identifier("mobz:textures/entity/tameddog.png");
    private static final Identifier ANGRY_SKIN = new Identifier("mobz:textures/entity/angrydog.png");

    public DogRenderer(EntityRenderDispatcher entityRenderDispatcher_1) {
        super(entityRenderDispatcher_1, new WolfEntityModel(), 0.5F);

    }

    protected float method_4167(Dog Dog_1, float float_1) {
        return Dog_1.method_6714();
    }

    public void method_4166(Dog Dog_1, double double_1, double double_2, double double_3, float float_1,
            float float_2) {
        if (Dog_1.isWet()) {
            float float_3 = Dog_1.getBrightnessAtEyes() * Dog_1.getWetBrightnessMultiplier(float_2);
            GlStateManager.color3f(float_3, float_3, float_3);
        }

        super.method_4072(Dog_1, double_1, double_2, double_3, float_1, float_2);
    }

    protected Identifier method_4165(Dog Dog_1) {
        if (Dog_1.isTamed()) {
            return TAMED_SKIN;
        } else {
            return Dog_1.isAngry() ? ANGRY_SKIN : WILD_SKIN;
        }
    }

    protected Identifier getTexture(Dog dog) {
        return new Identifier("mobz:textures/entity/dog.png");
    }
}
