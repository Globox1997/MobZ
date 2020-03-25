package net.mobz;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;
import net.mobz.Config.configz;
import net.mobz.Inits.Entityinit;
import net.mobz.Renderer.*;

public class client implements ClientModInitializer {

        public static EntityType<?> entityType;

        @Override
        public void onInitializeClient() {

                AutoConfig.getGuiRegistry(configz.class);

                EntityRendererRegistry.INSTANCE.register(Entityinit.TANK,
                                (dispatcher, context) -> new TankRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.FAST,
                                (dispatcher, context) -> new FastRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.TEST,
                                (dispatcher, context) -> new TestRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.ARMORED,
                                (dispatcher, context) -> new ArmoredRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.BOSS,
                                (dispatcher, context) -> new BossRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.CREEP,
                                (dispatcher, context) -> new CreepRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.CRIP,
                                (dispatcher, context) -> new CripRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.ENDER,
                                (dispatcher, context) -> new EnderRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.ENDERZOMBIE,
                                (dispatcher, context) -> new EnderZombieRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.SPI,
                                (dispatcher, context) -> new SpiRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.SPO,
                                (dispatcher, context) -> new SpoRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.PIG,
                                (dispatcher, context) -> new PigmanRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.ICEGOLEM,
                                (dispatcher, context) -> new IceGolemRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.LAVAGOLEM,
                                (dispatcher, context) -> new LavaGolemRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.SKELI1,
                                (dispatcher, context) -> new skeli1renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.SKELI2,
                                (dispatcher, context) -> new skeli2renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.SKELI3,
                                (dispatcher, context) -> new skeli3renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.ARCHERENTITY,
                                (dispatcher, context) -> new ArcherRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.ARCHER2ENTITY,
                                (dispatcher, context) -> new Archer2Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.BIGBOSSENTITY,
                                (dispatcher, context) -> new BigBossRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.KNIGHTENTITY,
                                (dispatcher, context) -> new KnightRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.KNIGHT2ENTITY,
                                (dispatcher, context) -> new Knight2Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.MAGEENTITY,
                                (dispatcher, context) -> new MageRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.MAGE2ENTITY,
                                (dispatcher, context) -> new Mage2Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.SMALLZOMBIE,
                                (dispatcher, context) -> new SmallZombieRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.FULLIRONENTITY,
                                (dispatcher, context) -> new FullIronRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.FROSTENTITY,
                                (dispatcher, context) -> new FrostRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.DOG,
                                (dispatcher, context) -> new DogRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.STONEGOLEM,
                                (dispatcher, context) -> new StoneGolemRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.ILLUSIONER,
                                (dispatcher, context) -> new IllusionerRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.DWARFENTITY,
                                (dispatcher, context) -> new DwarfEntityRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.SPISMALL,
                                (dispatcher, context) -> new SpiSmallRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.BLACKBEAR,
                                (dispatcher, context) -> new BlackbearRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.BROWNBEAR,
                                (dispatcher, context) -> new BrownbearRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.GCHICKEN,
                                (dispatcher, context) -> new GChickenRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.BOAR,
                                (dispatcher, context) -> new BoarRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.BOAR2,
                                (dispatcher, context) -> new Boar2Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.BOAR3,
                                (dispatcher, context) -> new Boar3Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.FRIEND,
                                (dispatcher, context) -> new FriendRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.KNIGHT3ENTITY,
                                (dispatcher, context) -> new Knight3Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.KNIGHT4ENTITY,
                                (dispatcher, context) -> new Knight4Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.KNIGHT5ENTITY,
                                (dispatcher, context) -> new Knight5Renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.WITHENTITY,
                                (dispatcher, context) -> new WithRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.SKELI4,
                                (dispatcher, context) -> new skeli4renderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.WITHENDER,
                                (dispatcher, context) -> new WithenderRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.SLIMO,
                                (dispatcher, context) -> new SlimoRenderer(dispatcher));
                EntityRendererRegistry.INSTANCE.register(Entityinit.TSPIDER,
                                (dispatcher, context) -> new TSpiderRenderer(dispatcher));

        }

}