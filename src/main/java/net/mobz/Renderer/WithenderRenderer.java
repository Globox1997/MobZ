package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.WitherEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.mobz.Entity.Withender;

@Environment(EnvType.CLIENT)
public class WithenderRenderer extends MobEntityRenderer<Withender, WitherEntityModel<Withender>> {
   private static final Identifier INVINCIBLE_SKIN = new Identifier("textures/entity/wither/wither_invulnerable.png");
   private static final Identifier SKIN = new Identifier("textures/entity/wither/wither.png");

   public WithenderRenderer(EntityRenderDispatcher entityRenderDispatcher_1) {
      super(entityRenderDispatcher_1, new WitherEntityModel<>(0.0F), 1.0F);

   }

   public Identifier method_4153(Withender witherEntity_1) {
      int int_1 = witherEntity_1.getInvulnerableTimer();
      return int_1 > 0 && (int_1 > 80 || int_1 / 5 % 2 != 1) ? INVINCIBLE_SKIN : SKIN;
   }

   protected void method_4152(Withender witherEntity_1, MatrixStack matrixStack_1, float float_1) {
      float float_2 = 2.0F;
      int int_1 = witherEntity_1.getInvulnerableTimer();
      if (int_1 > 0) {
         float_2 -= ((float) int_1 - float_1) / 220.0F * 0.5F;
      }

      matrixStack_1.scale(float_2, float_2, float_2);
   }

   @Override
   public Identifier getTexture(Withender witho) {
      return new Identifier("mobz:textures/entity/wither.png");
   }

}
