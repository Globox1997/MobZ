package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.model.VexEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class TestRenderer extends BipedEntityRenderer<VexEntity, VexEntityModel> {
   private static final Identifier TEXTURE = new Identifier("mobz:textures/entity/test.png");
   private static final Identifier CHARGING_TEXTURE = new Identifier("mobz:textures/entity/test.png");

   public TestRenderer(EntityRenderDispatcher entityRenderDispatcher) {
      super(entityRenderDispatcher, new VexEntityModel(), 0.3F);
   }

   @Override
   protected int getBlockLight(VexEntity vexEntity, float f) {
      return 15;
   }

   @Override
   public Identifier getTexture(VexEntity vexEntity) {
      return vexEntity.isCharging() ? CHARGING_TEXTURE : TEXTURE;
   }

   @Override
   protected void scale(VexEntity vexEntity, MatrixStack matrixStack, float f) {
      matrixStack.scale(0.4F, 0.4F, 0.4F);
   }
}
