package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PiglinEntityModel;
import net.minecraft.util.Identifier;
import net.mobz.Entity.PigmanEntity;

@Environment(EnvType.CLIENT)
public class PigmanRenderer extends BipedEntityRenderer<PigmanEntity, PiglinEntityModel<PigmanEntity>> {
   private static final Identifier TEXTURE = new Identifier("mobz:textures/entity/pigman.png");

   public PigmanRenderer(EntityRenderDispatcher dispatcher) {
      super(dispatcher, new PiglinEntityModel<>(0.0F, 64, 64), 0.5F, 1.0019531F, 1.0F, 1.0019531F);
      this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel<>(0.5F), new BipedEntityModel<>(1.02F)));
   }

   @Override
   public Identifier getTexture(PigmanEntity mobEntity) {
      return TEXTURE;
   }

}
