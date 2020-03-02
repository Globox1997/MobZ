package net.mobz;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;

import net.mobz.Renderer.*;

public class ClientInitializier implements ClientModInitializer {

        public static EntityType<?> entityType;

        @Override
        public void onInitializeClient() {

                EntityRendererRegistry.INSTANCE.register(glomod.TANK,
                                (dispatcher, context) -> new TankRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.FAST,
                                (dispatcher, context) -> new FastRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.TEST,
                                (dispatcher, context) -> new TestRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.ARMORED,
                                (dispatcher, context) -> new ArmoredRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.BOSS,
                                (dispatcher, context) -> new BossRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.CREEP,
                                (dispatcher, context) -> new CreepRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.CRIP,
                                (dispatcher, context) -> new CripRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.ENDER,
                                (dispatcher, context) -> new EnderRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.ENDERZOMBIE,
                                (dispatcher, context) -> new EnderZombieRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.SPI,
                                (dispatcher, context) -> new SpiRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.SPO,
                                (dispatcher, context) -> new SpoRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.PIG,
                                (dispatcher, context) -> new PigmanRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.ICEGOLEM,
                                (dispatcher, context) -> new IceGolemRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.LAVAGOLEM,
                                (dispatcher, context) -> new LavaGolemRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.SKELI1,
                                (dispatcher, context) -> new skeli1renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.SKELI2,
                                (dispatcher, context) -> new skeli2renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.SKELI3,
                                (dispatcher, context) -> new skeli3renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.ARCHERENTITY,
                                (dispatcher, context) -> new ArcherRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.ARCHER2ENTITY,
                                (dispatcher, context) -> new Archer2Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.BIGBOSSENTITY,
                                (dispatcher, context) -> new BigBossRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.KNIGHTENTITY,
                                (dispatcher, context) -> new KnightRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.KNIGHT2ENTITY,
                                (dispatcher, context) -> new Knight2Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.MAGEENTITY,
                                (dispatcher, context) -> new MageRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.MAGE2ENTITY,
                                (dispatcher, context) -> new Mage2Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.SMALLZOMBIE,
                                (dispatcher, context) -> new SmallZombieRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.FULLIRONENTITY,
                                (dispatcher, context) -> new FullIronRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.FROSTENTITY,
                                (dispatcher, context) -> new FrostRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.DOG,
                                (dispatcher, context) -> new DogRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.STONEGOLEM,
                                (dispatcher, context) -> new StoneGolemRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.ILLUSIONER,
                                (dispatcher, context) -> new IllusionerRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.DWARFENTITY,
                                (dispatcher, context) -> new DwarfEntityRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.SPISMALL,
                                (dispatcher, context) -> new SpiSmallRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.BLACKBEAR,
                                (dispatcher, context) -> new BlackbearRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.BROWNBEAR,
                                (dispatcher, context) -> new BrownbearRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.GCHICKEN,
                                (dispatcher, context) -> new GChickenRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.BOAR,
                                (dispatcher, context) -> new BoarRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.BOAR2,
                                (dispatcher, context) -> new Boar2Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.BOAR3,
                                (dispatcher, context) -> new Boar3Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.FRIEND,
                                (dispatcher, context) -> new FriendRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.KNIGHT3ENTITY,
                                (dispatcher, context) -> new Knight3Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.KNIGHT4ENTITY,
                                (dispatcher, context) -> new Knight4Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.KNIGHT5ENTITY,
                                (dispatcher, context) -> new Knight5Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.WITHENTITY,
                                (dispatcher, context) -> new WithRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.SKELI4,
                                (dispatcher, context) -> new skeli4renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.WITHENDER,
                                (dispatcher, context) -> new WithenderRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.SLIMO,
                                (dispatcher, context) -> new SlimoRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(glomod.TSPIDER,
                                (dispatcher, context) -> new TSpiderRenderer(dispatcher));

        }

}