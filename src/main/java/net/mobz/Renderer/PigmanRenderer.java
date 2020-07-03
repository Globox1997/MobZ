package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PiglinEntityModel;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class PigmanRenderer extends BipedEntityRenderer<MobEntity, PiglinEntityModel<MobEntity>> {
   private static final Identifier TEXTURE = new Identifier("mobz:textures/entity/metalgolem.png");

   public PigmanRenderer(EntityRenderDispatcher dispatcher) {
      super(dispatcher, getPiglinModel(false), 0.5F, 1.0019531F, 1.0F, 1.0019531F);
      this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel<>(0.5F), new BipedEntityModel<>(1.02F)));
   }

   private static PiglinEntityModel<MobEntity> getPiglinModel(boolean zombified) {
      PiglinEntityModel<MobEntity> piglinEntityModel = new PiglinEntityModel<>(0.0F, 64, 64);
      if (zombified) {
         piglinEntityModel.leftEar.visible = false;
      }

      return piglinEntityModel;
   }

   @Override
   public Identifier getTexture(MobEntity mobEntity) {
      return TEXTURE;
   }

}
