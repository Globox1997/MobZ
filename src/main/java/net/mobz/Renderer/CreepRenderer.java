package net.mobz.Renderer;

import net.mobz.Entity.*;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CreepRenderer extends MobEntityRenderer<CreepEntity, CreeperEntityModel<CreepEntity>> {
    public CreepRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new CreeperEntityModel<>(), 0.5F);
        
    }
    

    @Override
    protected Identifier getTexture(CreepEntity creepEntity) {
        return new Identifier("mobz:textures/entity/creep.png");
    }
}