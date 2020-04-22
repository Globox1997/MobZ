package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.IllagerEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.IllagerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.util.Identifier;
import net.mobz.Entity.PillagerBoss;

@Environment(EnvType.CLIENT)
public class PillagerBossRenderer extends IllagerEntityRenderer<PillagerBoss> {
   private static final Identifier SKIN = new Identifier("mobz:textures/entity/pillagerboss.png");

   public PillagerBossRenderer(EntityRenderDispatcher entityRenderDispatcher) {
      super(entityRenderDispatcher, new IllagerEntityModel<>(0.0F, 0.0F, 64, 64), 0.5F);
      this.addFeature(new HeldItemFeatureRenderer<>(this));
   }

   public Identifier getTexture(PillagerEntity pillagerEntity) {
      return SKIN;
   }

   protected void scale(PillagerBoss pilli, MatrixStack matrixStack, float f) {
      matrixStack.scale(1.3F, 1.3F, 1.3F);
   }

   @Override
   public Identifier getTexture(PillagerBoss entity) {
      return new Identifier("mobz:textures/entity/pillagerboss.png");
   }
}