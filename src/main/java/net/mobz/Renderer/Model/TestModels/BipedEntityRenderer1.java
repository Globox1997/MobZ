package net.mobz.Renderer.Model.TestModels;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.ElytraFeatureRenderer;
import net.minecraft.client.render.entity.feature.HeadFeatureRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BipedEntityRenderer1<T extends MobEntity, M extends BipedModel<T>> extends MobEntityRenderer<T, M> {
   private static final Identifier SKIN = new Identifier("textures/entity/steve.png");

   public BipedEntityRenderer1(EntityRenderDispatcher entityRenderDispatcher_1, M bipedEntityModel_1, float float_1) {
      super(entityRenderDispatcher_1, bipedEntityModel_1, float_1);
      this.addFeature(new HeadFeatureRenderer(this));
      this.addFeature(new ElytraFeatureRenderer(this));
      this.addFeature(new HeldItemFeatureRenderer(this));
   }

   protected Identifier method_3982(T mobEntity_1) {
      return SKIN;
   }

    @Override
    protected Identifier getTexture(T var1) {
        // TODO Auto-generated method stub
        return null;
    }
}
