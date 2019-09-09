package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class EnderZombieRenderer extends BipedEntityRenderer<EnderZombieEntity, ZombieEntityModel<EnderZombieEntity>> {

    public EnderZombieRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new ZombieEntityModel<>(), 0.5F);

    }
    
    @Override
    protected Identifier getTexture(EnderZombieEntity enderZombieEntity) {
        return new Identifier("mobz:textures/entity/enderzombie.png");
    }

}