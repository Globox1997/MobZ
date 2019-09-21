package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)

public class SmallZombieRenderer extends BipedEntityRenderer<SmallZombie, ZombieEntityModel<SmallZombie>> {

    public SmallZombieRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new ZombieEntityModel<>(), 0.5F);

    }

    @Override
    protected Identifier getTexture(SmallZombie smallzombie) {
        return new Identifier("mobz:textures/entity/smallzombie.png");
    }

}