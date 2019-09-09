package net.mobz;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.EntityRendererRegistry;
import net.minecraft.entity.EntityType;

public class ClientInitializier implements ClientModInitializer {

    public static EntityType<?> entityType;

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.INSTANCE.register(TankEntity.class,
                (dispatcher, context) -> new TankRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(FastEntity.class,
                (dispatcher, context) -> new FastRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(TestEntity.class,
                (dispatcher, context) -> new TestRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(ArmoredEntity.class,
                (dispatcher, context) -> new ArmoredRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(BossEntity.class,
                (dispatcher, context) -> new BossRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(CreepEntity.class,
                (dispatcher, context) -> new CreepRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(CripEntity.class,
                (dispatcher, context) -> new CripRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(EnderEntity.class,
                (dispatcher, context) -> new EnderRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(EnderZombieEntity.class,
                (dispatcher, context) -> new EnderZombieRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(SpiEntity.class, (dispatcher, context) -> new SpiRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(SpoEntity.class, (dispatcher, context) -> new SpoRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(PigmanEntity.class,
                (dispatcher, context) -> new PigmanRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(IceGolem.class,
                (dispatcher, context) -> new IceGolemRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(LavaGolem.class,
                (dispatcher, context) -> new LavaGolemRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(skeli1.class, (dispatcher, context) -> new skeli1renderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(skeli2.class, (dispatcher, context) -> new skeli2renderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(skeli3.class, (dispatcher, context) -> new skeli3renderer(dispatcher));

        EntityRendererRegistry.INSTANCE.register(Try.class, (dispatcher, context) -> new TryRenderer(dispatcher));
    }

}