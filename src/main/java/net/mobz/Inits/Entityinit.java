package net.mobz.Inits;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.mobz.Entity.*;

public class Entityinit {

        public static final EntityType<TankEntity> TANK = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, TankEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.95F))
                        .build();
        public static final EntityType<FastEntity> FAST = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, FastEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.95F))
                        .build();
        public static final EntityType<TestEntity> TEST = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, TestEntity::new).fireImmune()
                        .dimensions(EntityDimensions.fixed(0.6F, 1.95F)).build();
        public static final EntityType<ArmoredEntity> ARMORED = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, ArmoredEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.95F))
                        .build();
        public static final EntityType<BossEntity> BOSS = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, BossEntity::new).fireImmune()
                        .dimensions(EntityDimensions.fixed(0.6F, 1.95F)).build();
        public static final EntityType<CreepEntity> CREEP = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, CreepEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F))
                        .build();
        public static final EntityType<CripEntity> CRIP = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, CripEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F))
                        .build();
        public static final EntityType<EnderEntity> ENDER = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, EnderEntity::new).dimensions(EntityDimensions.fixed(0.6F, 2.9F))
                        .build();
        public static final EntityType<EnderZombieEntity> ENDERZOMBIE = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, EnderZombieEntity::new)
                        .dimensions(EntityDimensions.fixed(0.6F, 1.95F)).build();
        public static final EntityType<SpiEntity> SPI = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, SpiEntity::new).dimensions(EntityDimensions.fixed(1.4F, 0.9F))
                        .build();
        public static final EntityType<SpoEntity> SPO = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, SpoEntity::new).dimensions(EntityDimensions.fixed(1.4F, 0.9F))
                        .build();
        public static final EntityType<PigmanEntity> PIG = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, PigmanEntity::new).fireImmune()
                        .dimensions(EntityDimensions.fixed(0.5F, 0.9F)).build();
        public static final EntityType<LavaGolem> LAVAGOLEM = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, LavaGolem::new).fireImmune()
                        .dimensions(EntityDimensions.fixed(1.35F, 2.6F)).build();
        public static final EntityType<IceGolem> ICEGOLEM = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, IceGolem::new).dimensions(EntityDimensions.fixed(1.54F, 3F))
                        .build();
        public static final EntityType<skeli1> SKELI1 = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, skeli1::new)
                        .fireImmune().dimensions(EntityDimensions.fixed(0.6F, 1.99F)).build();
        public static final EntityType<skeli2> SKELI2 = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, skeli2::new)
                        .fireImmune().dimensions(EntityDimensions.fixed(0.6F, 1.99F)).build();
        public static final EntityType<skeli3> SKELI3 = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, skeli3::new)
                        .dimensions(EntityDimensions.fixed(0.6F, 1.99F)).build();
        public static final EntityType<ArcherEntity> ARCHERENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, ArcherEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.99F))
                        .build();
        public static final EntityType<Archer2Entity> ARCHER2ENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, Archer2Entity::new).dimensions(EntityDimensions.fixed(0.6F, 1.99F))
                        .build();
        public static final EntityType<BigBossEntity> BIGBOSSENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, BigBossEntity::new).dimensions(EntityDimensions.fixed(1.5F, 4.875F))
                        .build();
        public static final EntityType<KnightEntity> KNIGHTENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, KnightEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.99F))
                        .build();
        public static final EntityType<Knight2Entity> KNIGHT2ENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, Knight2Entity::new).dimensions(EntityDimensions.fixed(0.6F, 1.99F))
                        .build();
        public static final EntityType<MageEntity> MAGEENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, MageEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.95F))
                        .build();
        public static final EntityType<Mage2Entity> MAGE2ENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, Mage2Entity::new).dimensions(EntityDimensions.fixed(0.6F, 1.95F))
                        .build();
        public static final EntityType<SmallZombie> SMALLZOMBIE = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, SmallZombie::new).dimensions(EntityDimensions.fixed(0.3F, 1.0F))
                        .build();
        public static final EntityType<FullIronEntity> FULLIRONENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, FullIronEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.99F))
                        .build();
        public static final EntityType<FrostEntity> FROSTENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, FrostEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.8F))
                        .build();
        public static final EntityType<Dog> DOG = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, Dog::new)
                        .fireImmune().dimensions(EntityDimensions.fixed(0.6F, 0.85F)).build();
        public static final EntityType<StoneGolem> STONEGOLEM = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, StoneGolem::new).dimensions(EntityDimensions.fixed(1.4F, 2.7F))
                        .build();
        public static final EntityType<Illusioner> ILLUSIONER = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, Illusioner::new).dimensions(EntityDimensions.fixed(0.6F, 1.95F))
                        .build();
        public static final EntityType<DwarfEntity> DWARFENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, DwarfEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.5F))
                        .build();
        public static final EntityType<SpiSmall> SPISMALL = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, SpiSmall::new).dimensions(EntityDimensions.fixed(0.7F, 0.5F))
                        .build();
        public static final EntityType<Blackbear> BLACKBEAR = FabricEntityTypeBuilder
                        .create(SpawnGroup.CREATURE, Blackbear::new).dimensions(EntityDimensions.fixed(1.25F, 1.3F))
                        .build();
        public static final EntityType<Brownbear> BROWNBEAR = FabricEntityTypeBuilder
                        .create(SpawnGroup.CREATURE, Brownbear::new).dimensions(EntityDimensions.fixed(1.3F, 1.4F))
                        .build();
        public static final EntityType<GChicken> GCHICKEN = FabricEntityTypeBuilder
                        .create(SpawnGroup.CREATURE, GChicken::new).dimensions(EntityDimensions.fixed(0.4F, 0.7F))
                        .build();
        public static final EntityType<Boar> BOAR = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, Boar::new)
                        .dimensions(EntityDimensions.fixed(0.9F, 0.9F)).build();
        public static final EntityType<Boar2> BOAR2 = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, Boar2::new)
                        .dimensions(EntityDimensions.fixed(0.9F, 0.9F)).build();
        public static final EntityType<Boar3> BOAR3 = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, Boar3::new)
                        .dimensions(EntityDimensions.fixed(0.9F, 0.9F)).build();
        public static final EntityType<FriendEntity> FRIEND = FabricEntityTypeBuilder
                        .create(SpawnGroup.CREATURE, FriendEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.99F))
                        .build();
        public static final EntityType<Knight3Entity> KNIGHT3ENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, Knight3Entity::new).dimensions(EntityDimensions.fixed(0.6F, 1.99F))
                        .build();
        public static final EntityType<Knight4Entity> KNIGHT4ENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.CREATURE, Knight4Entity::new).dimensions(EntityDimensions.fixed(0.6F, 1.99F))
                        .build();
        public static final EntityType<Knight5Entity> KNIGHT5ENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, Knight5Entity::new).dimensions(EntityDimensions.fixed(0.6F, 1.99F))
                        .build();
        public static final EntityType<WithEntity> WITHENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, WithEntity::new).fireImmune()
                        .dimensions(EntityDimensions.fixed(0.6F, 1.8F)).build();
        public static final EntityType<skeli4> SKELI4 = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, skeli4::new)
                        .dimensions(EntityDimensions.fixed(0.6F, 1.99F)).build();
        public static final EntityType<Withender> WITHENDER = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, Withender::new).fireImmune()
                        .dimensions(EntityDimensions.fixed(0.6F, 1.95F)).build();
        public static final EntityType<Slimo> SLIMO = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, Slimo::new)
                        .dimensions(EntityDimensions.fixed(0.51F, 0.51F)).build();
        public static final EntityType<TSpider> TSPIDER = FabricEntityTypeBuilder
                        .create(SpawnGroup.AMBIENT, TSpider::new).dimensions(EntityDimensions.fixed(0.2F, 0.1F))
                        .build();
        public static final EntityType<PillagerBoss> PILLAGERBOSS = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, PillagerBoss::new).dimensions(EntityDimensions.fixed(0.78F, 2.675F))
                        .build();
        public static final EntityType<BabyravagerEntity> BABYRAVAGERENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, BabyravagerEntity::new)
                        .dimensions(EntityDimensions.fixed(0.78F, 0.88F)).build();
        public static final EntityType<IslandKing> ISLANDKING = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, IslandKing::new).dimensions(EntityDimensions.fixed(0.6F, 1.99F))
                        .build();
        public static final EntityType<IslandKnightNormal> ISLANDKNIGHTNORMAL = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, IslandKnightNormal::new)
                        .dimensions(EntityDimensions.fixed(0.6F, 1.99F)).build();
        public static final EntityType<IslandKnightSpecial> ISLANDKNIGHTSPECIAL = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, IslandKnightSpecial::new)
                        .dimensions(EntityDimensions.fixed(0.6F, 1.99F)).build();
        public static final EntityType<IslandKnightSpecial2> ISLANDKNIGHTSPECIAL2 = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, IslandKnightSpecial2::new)
                        .dimensions(EntityDimensions.fixed(0.6F, 1.99F)).build();
        public static final EntityType<IslandVexEntity> ISLANDVEXENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, IslandVexEntity::new).dimensions(EntityDimensions.fixed(0.4F, 0.8F))
                        .build();
        public static final EntityType<MetalGolem> METALGOLEM = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, MetalGolem::new).dimensions(EntityDimensions.fixed(1.59F, 3F))
                        .build();
        public static final EntityType<SCreeperEntity> SCREEPER = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, SCreeperEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.7F))
                        .build();

        public static void init() {

                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "tank_entity"), TANK);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "fast_entity"), FAST);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "test_entity"), TEST);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "armored_entity"), ARMORED);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "boss_entity"), BOSS);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "creep_entity"), CREEP);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "crip_entity"), CRIP);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "ender_entity"), ENDER);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "enderzombie_entity"), ENDERZOMBIE);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "spi_entity"), SPI);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "spo_entity"), SPO);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "pigman_entity"), PIG);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "lavagolem_entity"), LAVAGOLEM);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "icegolem_entity"), ICEGOLEM);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "skeli1_entity"), SKELI1);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "skeli2_entity"), SKELI2);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "skeli3_entity"), SKELI3);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "archer_entity"), ARCHERENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "archer2_entity"), ARCHER2ENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "bigboss_entity"), BIGBOSSENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "knight_entity"), KNIGHTENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "knight2_entity"), KNIGHT2ENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "mage_entity"), MAGEENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "mage2_entity"), MAGE2ENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "smallzombie_entity"), SMALLZOMBIE);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "fulliron_entity"), FULLIRONENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "frost_entity"), FROSTENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "dog_entity"), DOG);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "stonegolem_entity"), STONEGOLEM);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "illusioner_entity"), ILLUSIONER);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "dwarf_entity"), DWARFENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "spismall_entity"), SPISMALL);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "blackbear_entity"), BLACKBEAR);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "brownbear_entity"), BROWNBEAR);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "gchicken_entity"), GCHICKEN);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "boar_entity"), BOAR);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "boar2_entity"), BOAR2);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "boar3_entity"), BOAR3);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "friend_entity"), FRIEND);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "knight3_entity"), KNIGHT3ENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "knight4_entity"), KNIGHT4ENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "knight5_entity"), KNIGHT5ENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "with_entity"), WITHENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "skeli4_entity"), SKELI4);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "slimo_entity"), SLIMO);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "withender_entity"), WITHENDER);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "tspider_entity"), TSPIDER);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "pillagerboss_entity"), PILLAGERBOSS);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "babyravager_entity"),
                                BABYRAVAGERENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "islandking_entity"), ISLANDKING);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "islandknightnormal_entity"),
                                ISLANDKNIGHTNORMAL);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "islandknightspecial_entity"),
                                ISLANDKNIGHTSPECIAL);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "islandknightspecial2_entity"),
                                ISLANDKNIGHTSPECIAL2);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "islandvex_entity"), ISLANDVEXENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "metalgolem_entity"), METALGOLEM);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "screeper_entity"), SCREEPER);
                // A
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_islandknightspecial2"),
                                new SpawnEggItem(ISLANDKNIGHTSPECIAL2, 3882305, 3161413,
                                                new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_archer2"), new SpawnEggItem(
                                ARCHER2ENTITY, 7691600, 4269851, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_armored"), new SpawnEggItem(ARMORED,
                                1397590, 3165729, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                // B
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_babyravager"),
                                new SpawnEggItem(BABYRAVAGERENTITY, 6315866, 4538432,
                                                new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_bigboss"), new SpawnEggItem(
                                BIGBOSSENTITY, 667182, 984607, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_blackbear"), new SpawnEggItem(BLACKBEAR,
                                657934, 2960685, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_spi"), new SpawnEggItem(SPI, 3291714,
                                960680, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_boar2"), new SpawnEggItem(BOAR2,
                                14601929, 2962756, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_skeli1"), new SpawnEggItem(SKELI1,
                                2697513, 4934989, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_boss"), new SpawnEggItem(BOSS, 1181988,
                                3560490, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_archer"), new SpawnEggItem(ARCHERENTITY,
                                3218704, 11711154, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_brownbear"), new SpawnEggItem(BROWNBEAR,
                                2169097, 4403731, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                // C
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_crip"), new SpawnEggItem(CRIP, 10250793,
                                0, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                // D
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_boar3"), new SpawnEggItem(BOAR3,
                                13284514, 2890508, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_dwarf"), new SpawnEggItem(DWARFENTITY,
                                5392946, 11882545, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                // E
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_knight3"), new SpawnEggItem(
                                KNIGHT3ENTITY, 1447190, 4917648, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_ender"), new SpawnEggItem(ENDER, 7884109,
                                2167558, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_enderzombie"), new SpawnEggItem(
                                ENDERZOMBIE, 656405, 3876927, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                // F
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_knight4"), new SpawnEggItem(
                                KNIGHT4ENTITY, 5308416, 16039829, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_frost"), new SpawnEggItem(FROSTENTITY,
                                8709375, 86111, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_creep"), new SpawnEggItem(CREEP, 4897722,
                                0, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                // G
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_gchicken"), new SpawnEggItem(GCHICKEN,
                                13027014, 15315221, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_slimo"), new SpawnEggItem(SLIMO,
                                16752702, 16564078, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                // H
                // I
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_icegolem"), new SpawnEggItem(ICEGOLEM,
                                7499112, 1572516, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_illusioner"), new SpawnEggItem(
                                ILLUSIONER, 2763306, 2507353, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                // J
                // K
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_friend"), new SpawnEggItem(FRIEND,
                                5132380, 7164237, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_islandking"), new SpawnEggItem(
                                ISLANDKING, 8222839, 12891527, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_islandknightnormal"),
                                new SpawnEggItem(ISLANDKNIGHTNORMAL, 3815735, 723723,
                                                new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                // L
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_lavagolem"), new SpawnEggItem(LAVAGOLEM,
                                6098704, 3039578, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_knight5"), new SpawnEggItem(
                                KNIGHT5ENTITY, 1118487, 5000017, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_skeli4"), new SpawnEggItem(SKELI4,
                                4079166, 11776947, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                // M
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_metalgolem"), new SpawnEggItem(
                                METALGOLEM, 2930848, 5197390, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                // N
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_skeli3"), new SpawnEggItem(SKELI3,
                                4801614, 5121582, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_dog"), new SpawnEggItem(DOG, 4785691,
                                6700094, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                // O
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_skeli2"), new SpawnEggItem(SKELI2,
                                5263682, 11534, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                // P
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_pig"), new SpawnEggItem(PIG, 7026980,
                                15245428, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_pillagerboss"), new SpawnEggItem(
                                PILLAGERBOSS, 4984603, 1453610, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_spo"), new SpawnEggItem(SPO, 4864065,
                                10817192, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_smallzombie"), new SpawnEggItem(
                                SMALLZOMBIE, 3222535, 1116191, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                // Q
                // R
                // S
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_screeper"), new SpawnEggItem(SCREEPER,
                                4798252, 107176, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_fast"), new SpawnEggItem(FAST, 6109639,
                                2968097, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_mage"), new SpawnEggItem(MAGEENTITY,
                                5128776, 12342593, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_islandvex"),
                                new SpawnEggItem(ISLANDVEXENTITY, 2039583, 9014412,
                                                new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_fulliron"), new SpawnEggItem(
                                FULLIRONENTITY, 888205, 4800672, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_stonegolem"), new SpawnEggItem(
                                STONEGOLEM, 10197915, 6654258, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                // T
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_tank"), new SpawnEggItem(TANK, 5055902,
                                2507798, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_knight"), new SpawnEggItem(KNIGHTENTITY,
                                5914402, 2499613, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_spismall"), new SpawnEggItem(SPISMALL,
                                3806513, 146458, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                // U
                // V
                // W
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_knight2"), new SpawnEggItem(
                                KNIGHT2ENTITY, 4464921, 2173756, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_boar"), new SpawnEggItem(BOAR, 3211264,
                                9984303, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_islandknightspecial"),
                                new SpawnEggItem(ISLANDKNIGHTSPECIAL, 2434859, 3481123,
                                                new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_withender"), new SpawnEggItem(WITHENDER,
                                1452605, 1982799, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_with"), new SpawnEggItem(WITHENTITY,
                                1841947, 8157561, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_mage2"), new SpawnEggItem(MAGE2ENTITY,
                                4211261, 2375449, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));
                // X
                // Y
                // Z
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_test"), new SpawnEggItem(TEST, 2039583,
                                9109643, new Item.Settings().group(Itemgroupinit.EGGZ_GROUP)));

                // Atributes

                FabricDefaultAttributeRegistry.register(ARCHER2ENTITY, Archer2Entity.createArcher2EntityAttributes());
                FabricDefaultAttributeRegistry.register(ARCHERENTITY, ArcherEntity.createArcherEntityAttributes());
                FabricDefaultAttributeRegistry.register(ARMORED, ArmoredEntity.createArmoredEntityAttributes());
                FabricDefaultAttributeRegistry.register(BABYRAVAGERENTITY,
                                BabyravagerEntity.createBabyravagerEntityAttributes());
                FabricDefaultAttributeRegistry.register(BIGBOSSENTITY, BigBossEntity.createBigBossEntityAttributes());
                FabricDefaultAttributeRegistry.register(BLACKBEAR, Blackbear.createBlackbearAttributes());
                FabricDefaultAttributeRegistry.register(BOAR, Boar.createBoarAttributes());
                FabricDefaultAttributeRegistry.register(BOAR2, Boar2.createBoar2Attributes());
                FabricDefaultAttributeRegistry.register(BOAR3, Boar3.createBoar3Attributes());
                FabricDefaultAttributeRegistry.register(BOSS, BossEntity.createBossEntityAttributes());
                FabricDefaultAttributeRegistry.register(BROWNBEAR, Brownbear.createBrownbearAttributes());
                FabricDefaultAttributeRegistry.register(CREEP, CreepEntity.createCreepEntityAttributes());
                FabricDefaultAttributeRegistry.register(CRIP, CripEntity.createCripEntityAttributes());
                FabricDefaultAttributeRegistry.register(DOG, Dog.createDogAttributes());
                FabricDefaultAttributeRegistry.register(DWARFENTITY, DwarfEntity.createDwarfEntityAttributes());
                FabricDefaultAttributeRegistry.register(ENDER, EnderEntity.createEnderEntityAttributes());
                FabricDefaultAttributeRegistry.register(ENDERZOMBIE,
                                EnderZombieEntity.createEnderZombieEntityAttributes());
                FabricDefaultAttributeRegistry.register(FAST, FastEntity.createFastEntityAttributes());
                FabricDefaultAttributeRegistry.register(FRIEND, FriendEntity.createFriendEntityAttributes());
                FabricDefaultAttributeRegistry.register(FROSTENTITY, FrostEntity.createFrostEntityAttributes());
                FabricDefaultAttributeRegistry.register(FULLIRONENTITY,
                                FullIronEntity.createFullIronEntityAttributes());
                FabricDefaultAttributeRegistry.register(GCHICKEN, GChicken.createGChickenAttributes());
                FabricDefaultAttributeRegistry.register(ICEGOLEM, IceGolem.createIceGolemAttributes());
                FabricDefaultAttributeRegistry.register(ILLUSIONER, Illusioner.createIllusionerAttributes());
                FabricDefaultAttributeRegistry.register(ISLANDKING, IslandKing.createIslandKingAttributes());
                FabricDefaultAttributeRegistry.register(ISLANDKNIGHTNORMAL,
                                IslandKnightNormal.createIslandKnightNormalAttributes());
                FabricDefaultAttributeRegistry.register(ISLANDKNIGHTSPECIAL,
                                IslandKnightSpecial.createIslandKnightSpecialAttributes());
                FabricDefaultAttributeRegistry.register(ISLANDKNIGHTSPECIAL2,
                                IslandKnightSpecial2.createIslandKnightSpecial2Attributes());
                FabricDefaultAttributeRegistry.register(ISLANDVEXENTITY,
                                IslandVexEntity.createIslandVexEntityAttributes());
                FabricDefaultAttributeRegistry.register(KNIGHT2ENTITY, Knight2Entity.createKnight2EntityAttributes());
                FabricDefaultAttributeRegistry.register(KNIGHT3ENTITY, Knight3Entity.createKnight3EntityAttributes());
                FabricDefaultAttributeRegistry.register(KNIGHT4ENTITY, Knight4Entity.createKnight4EntityAttributes());
                FabricDefaultAttributeRegistry.register(KNIGHT5ENTITY, Knight5Entity.createKnight5EntityAttributes());
                FabricDefaultAttributeRegistry.register(KNIGHTENTITY, KnightEntity.createKnightEntityAttributes());
                FabricDefaultAttributeRegistry.register(LAVAGOLEM, LavaGolem.createLavaGolemAttributes());
                FabricDefaultAttributeRegistry.register(MAGE2ENTITY, Mage2Entity.createMage2EntityAttributes());
                FabricDefaultAttributeRegistry.register(MAGEENTITY, MageEntity.createMageEntityAttributes());
                FabricDefaultAttributeRegistry.register(METALGOLEM, MetalGolem.createMetalGolemAttributes());
                FabricDefaultAttributeRegistry.register(PIG, PigmanEntity.createPigmanEntityAttributes());
                FabricDefaultAttributeRegistry.register(PILLAGERBOSS, PillagerBoss.createPillagerBossAttributes());
                FabricDefaultAttributeRegistry.register(SKELI1, skeli1.createskeli1Attributes());
                FabricDefaultAttributeRegistry.register(SKELI2, skeli2.createskeli2Attributes());
                FabricDefaultAttributeRegistry.register(SKELI3, skeli3.createskeli3Attributes());
                FabricDefaultAttributeRegistry.register(SKELI4, skeli4.createskeli4Attributes());
                FabricDefaultAttributeRegistry.register(SLIMO, Slimo.createSlimoAttributes());
                FabricDefaultAttributeRegistry.register(SMALLZOMBIE, SmallZombie.createSmallZombieAttributes());
                FabricDefaultAttributeRegistry.register(SPI, SpiEntity.createSpiEntityAttributes());
                FabricDefaultAttributeRegistry.register(SPISMALL, SpiSmall.createSpiSmallAttributes());
                FabricDefaultAttributeRegistry.register(SPO, SpoEntity.createSpoEntityAttributes());
                FabricDefaultAttributeRegistry.register(STONEGOLEM, StoneGolem.createStoneGolemAttributes());
                FabricDefaultAttributeRegistry.register(TANK, TankEntity.createTankEntityAttributes());
                FabricDefaultAttributeRegistry.register(TEST, TestEntity.createTestEntityAttributes());
                FabricDefaultAttributeRegistry.register(TSPIDER, TSpider.createTSpiderAttributes());
                FabricDefaultAttributeRegistry.register(WITHENDER, Withender.createWithenderAttributes());
                FabricDefaultAttributeRegistry.register(WITHENTITY, WithEntity.createWithEntityAttributes());
                FabricDefaultAttributeRegistry.register(SCREEPER, SCreeperEntity.createSCreeperEntityAttributes());

        }

}
