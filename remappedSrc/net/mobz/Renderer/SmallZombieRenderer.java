package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.ZombieBaseEntityRenderer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.mobz.Entity.SmallZombie;

@Environment(EnvType.CLIENT)
public class SmallZombieRenderer extends ZombieBaseEntityRenderer<SmallZombie, ZombieEntityModel<SmallZombie>> {
   public SmallZombieRenderer(EntityRenderDispatcher dispatcher) {
      super(dispatcher, new ZombieEntityModel<>(0.0F, false), new ZombieEntityModel<>(0.5F, true),
            new ZombieEntityModel<>(0.5F, true));
   }

   @Override
   protected void scale(SmallZombie smallZombie, MatrixStack matrixStack, float f) {
      matrixStack.scale(0.5F, 0.5F, 0.5F);
   }

   @Override
   public Identifier getTexture(SmallZombie stone) {
      return new Identifier("mobz:textures/entity/smallzombie.png");
   }

}
