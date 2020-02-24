package net.mobz.Renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.RavagerEntityModel;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class TestRenderer extends MobEntityRenderer<RavagerEntity, RavagerEntityModel> {
   private static final Identifier SKIN = new Identifier("mobz:textures/entity/test.png");

   public TestRenderer(EntityRenderDispatcher entityRenderDispatcher) {
      super(entityRenderDispatcher, new RavagerEntityModel(), 1.1F);
   }

   public Identifier getTexture(RavagerEntity ravagerEntity) {
      return SKIN;
   }
}
