package net.mobz;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
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