package net.mobz;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.EntityRendererRegistry;
import net.minecraft.entity.EntityType;

import net.mobz.Entity.*;
import net.mobz.Renderer.*;


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
                EntityRendererRegistry.INSTANCE.register(SpiEntity.class,
                                (dispatcher, context) -> new SpiRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(SpoEntity.class,
                                (dispatcher, context) -> new SpoRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(PigmanEntity.class,
                                (dispatcher, context) -> new PigmanRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(IceGolem.class,
                                (dispatcher, context) -> new IceGolemRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(LavaGolem.class,
                                (dispatcher, context) -> new LavaGolemRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(skeli1.class,
                                (dispatcher, context) -> new skeli1renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(skeli2.class,
                                (dispatcher, context) -> new skeli2renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(skeli3.class,
                                (dispatcher, context) -> new skeli3renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(ArcherEntity.class,
                                (dispatcher, context) -> new ArcherRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Archer2Entity.class,
                                (dispatcher, context) -> new Archer2Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(BigBossEntity.class,
                                (dispatcher, context) -> new BigBossRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(KnightEntity.class,
                                (dispatcher, context) -> new KnightRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Knight2Entity.class,
                                (dispatcher, context) -> new Knight2Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(MageEntity.class,
                                (dispatcher, context) -> new MageRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Mage2Entity.class,
                                (dispatcher, context) -> new Mage2Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(SmallZombie.class,
                                (dispatcher, context) -> new SmallZombieRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(FullIronEntity.class,
                                (dispatcher, context) -> new FullIronRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(FrostEntity.class,
                                (dispatcher, context) -> new FrostRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Dog.class,
                                (dispatcher, context) -> new DogRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(StoneGolem.class,
                                (dispatcher, context) -> new StoneGolemRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Illusioner.class,
                                (dispatcher, context) -> new IllusionerRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(DwarfEntity.class,
                                (dispatcher, context) -> new DwarfEntityRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(SpiSmall.class,
                                (dispatcher, context) -> new SpiSmallRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Blackbear.class,
                                (dispatcher, context) -> new BlackbearRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Brownbear.class,
                                (dispatcher, context) -> new BrownbearRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(GChicken.class,
                                (dispatcher, context) -> new GChickenRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Boar.class,
                                (dispatcher, context) -> new BoarRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Boar2.class,
                                (dispatcher, context) -> new Boar2Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Boar3.class,
                                (dispatcher, context) -> new Boar3Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(FriendEntity.class,
                                (dispatcher, context) -> new FriendRenderer(dispatcher));

                EntityRendererRegistry.INSTANCE.register(Try.class,
                                (dispatcher, context) -> new TryRenderer(dispatcher));

        }

}