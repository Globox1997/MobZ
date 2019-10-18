package net.mobz;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.EntityRendererRegistry;
import net.minecraft.entity.EntityType;
import net.mobz.Entity.Archer2Entity;
import net.mobz.Entity.ArcherEntity;
import net.mobz.Entity.ArmoredEntity;
import net.mobz.Entity.BigBossEntity;
import net.mobz.Entity.Blackbear;
import net.mobz.Entity.Boar;
import net.mobz.Entity.Boar2;
import net.mobz.Entity.Boar3;
import net.mobz.Entity.BossEntity;
import net.mobz.Entity.Brownbear;
import net.mobz.Entity.CreepEntity;
import net.mobz.Entity.CripEntity;
import net.mobz.Entity.Dog;
import net.mobz.Entity.DwarfEntity;
import net.mobz.Entity.EnderEntity;
import net.mobz.Entity.EnderZombieEntity;
import net.mobz.Entity.FastEntity;
import net.mobz.Entity.FrostEntity;
import net.mobz.Entity.FullIronEntity;
import net.mobz.Entity.GChicken;
import net.mobz.Entity.IceGolem;
import net.mobz.Entity.Illusioner;
import net.mobz.Entity.Knight2Entity;
import net.mobz.Entity.KnightEntity;
import net.mobz.Entity.LavaGolem;
import net.mobz.Entity.Mage2Entity;
import net.mobz.Entity.MageEntity;
import net.mobz.Entity.PigmanEntity;
import net.mobz.Entity.SmallZombie;
import net.mobz.Entity.SpiEntity;
import net.mobz.Entity.SpiSmall;
import net.mobz.Entity.SpoEntity;
import net.mobz.Entity.StoneGolem;
import net.mobz.Entity.TankEntity;
import net.mobz.Entity.TestEntity;
import net.mobz.Entity.Try;
import net.mobz.Entity.skeli1;
import net.mobz.Entity.skeli2;
import net.mobz.Entity.skeli3;
import net.mobz.Renderer.Archer2Renderer;
import net.mobz.Renderer.ArcherRenderer;
import net.mobz.Renderer.ArmoredRenderer;
import net.mobz.Renderer.BigBossRenderer;
import net.mobz.Renderer.BlackbearRenderer;
import net.mobz.Renderer.Boar2Renderer;
import net.mobz.Renderer.Boar3Renderer;
import net.mobz.Renderer.BoarRenderer;
import net.mobz.Renderer.BossRenderer;
import net.mobz.Renderer.BrownbearRenderer;
import net.mobz.Renderer.CreepRenderer;
import net.mobz.Renderer.CripRenderer;
import net.mobz.Renderer.DogRenderer;
import net.mobz.Renderer.DwarfEntityRenderer;
import net.mobz.Renderer.EnderRenderer;
import net.mobz.Renderer.EnderZombieRenderer;
import net.mobz.Renderer.FastRenderer;
import net.mobz.Renderer.FrostRenderer;
import net.mobz.Renderer.FullIronRenderer;
import net.mobz.Renderer.GChickenRenderer;
import net.mobz.Renderer.IceGolemRenderer;
import net.mobz.Renderer.IllusionerRenderer;
import net.mobz.Renderer.Knight2Renderer;
import net.mobz.Renderer.KnightRenderer;
import net.mobz.Renderer.LavaGolemRenderer;
import net.mobz.Renderer.Mage2Renderer;
import net.mobz.Renderer.MageRenderer;
import net.mobz.Renderer.PigmanRenderer;
import net.mobz.Renderer.SmallZombieRenderer;
import net.mobz.Renderer.SpiRenderer;
import net.mobz.Renderer.SpiSmallRenderer;
import net.mobz.Renderer.SpoRenderer;
import net.mobz.Renderer.StoneGolemRenderer;
import net.mobz.Renderer.TankRenderer;
import net.mobz.Renderer.TestRenderer;
import net.mobz.Renderer.TryRenderer;
import net.mobz.Renderer.skeli1renderer;
import net.mobz.Renderer.skeli2renderer;
import net.mobz.Renderer.skeli3renderer;

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

                EntityRendererRegistry.INSTANCE.register(Try.class,
                                (dispatcher, context) -> new TryRenderer(dispatcher));

        }

}