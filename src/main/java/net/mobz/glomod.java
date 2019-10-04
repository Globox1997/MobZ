package net.mobz;

import net.mobz.Entity.*;
import net.mobz.Items.*;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.sound.SoundEvent;

public class glomod implements ModInitializer {

        public static final EntityType<TankEntity> TANK = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, TankEntity::new).size(EntityDimensions.fixed(0.6F, 1.95F))
                        .build();
        public static final EntityType<FastEntity> FAST = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, FastEntity::new).size(EntityDimensions.fixed(0.6F, 1.95F))
                        .build();
        public static final EntityType<TestEntity> TEST = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, TestEntity::new).size(EntityDimensions.fixed(0.6F, 1.95F))
                        .build();
        public static final EntityType<ArmoredEntity> ARMORED = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, ArmoredEntity::new).size(EntityDimensions.fixed(0.6F, 1.95F))
                        .build();
        public static final EntityType<BossEntity> BOSS = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, BossEntity::new).setImmuneToFire()
                        .size(EntityDimensions.fixed(0.6F, 1.95F)).build();
        public static final EntityType<CreepEntity> CREEP = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, CreepEntity::new).size(EntityDimensions.fixed(0.6F, 1.7F))
                        .build();
        public static final EntityType<CripEntity> CRIP = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, CripEntity::new).size(EntityDimensions.fixed(0.6F, 1.7F))
                        .build();
        public static final EntityType<EnderEntity> ENDER = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, EnderEntity::new).size(EntityDimensions.fixed(0.6F, 2.9F))
                        .build();
        public static final EntityType<EnderZombieEntity> ENDERZOMBIE = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, EnderZombieEntity::new)
                        .size(EntityDimensions.fixed(0.6F, 1.95F)).build();
        public static final EntityType<SpiEntity> SPI = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, SpiEntity::new).size(EntityDimensions.fixed(1.4F, 0.9F))
                        .build();
        public static final EntityType<SpoEntity> SPO = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, SpoEntity::new).size(EntityDimensions.fixed(1.4F, 0.9F))
                        .build();
        public static final EntityType<PigmanEntity> PIG = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, PigmanEntity::new).size(EntityDimensions.fixed(0.6F, 1.95F))
                        .build();
        public static final EntityType<LavaGolem> LAVAGOLEM = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, LavaGolem::new).size(EntityDimensions.fixed(1.4F, 2.7F))
                        .build();
        public static final EntityType<IceGolem> ICEGOLEM = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, IceGolem::new).size(EntityDimensions.fixed(1.4F, 2.7F)).build();
        public static final EntityType<skeli1> SKELI1 = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, skeli1::new).setImmuneToFire()
                        .size(EntityDimensions.fixed(0.6F, 1.99F)).build();
        public static final EntityType<skeli2> SKELI2 = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, skeli2::new).setImmuneToFire()
                        .size(EntityDimensions.fixed(0.6F, 1.99F)).build();
        public static final EntityType<skeli3> SKELI3 = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, skeli3::new).size(EntityDimensions.fixed(0.6F, 1.99F)).build();
        public static final EntityType<ArcherEntity> ARCHERENTITY = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, ArcherEntity::new).size(EntityDimensions.fixed(0.6F, 1.8F))
                        .build();
        public static final EntityType<Archer2Entity> ARCHER2ENTITY = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, Archer2Entity::new).size(EntityDimensions.fixed(0.6F, 1.8F))
                        .build();
        public static final EntityType<BigBossEntity> BIGBOSSENTITY = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, BigBossEntity::new).size(EntityDimensions.fixed(1.2F, 3.9F))
                        .build();
        public static final EntityType<KnightEntity> KNIGHTENTITY = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, KnightEntity::new).size(EntityDimensions.fixed(0.6F, 1.8F))
                        .build();
        public static final EntityType<Knight2Entity> KNIGHT2ENTITY = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, Knight2Entity::new).size(EntityDimensions.fixed(0.6F, 1.8F))
                        .build();
        public static final EntityType<MageEntity> MAGEENTITY = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, MageEntity::new).size(EntityDimensions.fixed(0.6F, 1.95F))
                        .build();
        public static final EntityType<Mage2Entity> MAGE2ENTITY = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, Mage2Entity::new).size(EntityDimensions.fixed(0.6F, 1.95F))
                        .build();
        public static final EntityType<SmallZombie> SMALLZOMBIE = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, SmallZombie::new).size(EntityDimensions.fixed(0.6F, 1.95F))
                        .build();
        public static final EntityType<FullIronEntity> FULLIRONENTITY = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, FullIronEntity::new).size(EntityDimensions.fixed(0.6F, 1.8F))
                        .build();
        public static final EntityType<FrostEntity> FROSTENTITY = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, FrostEntity::new).size(EntityDimensions.fixed(0.6F, 1.8F))
                        .build();
        public static final EntityType<Dog> DOG = FabricEntityTypeBuilder.create(EntityCategory.MONSTER, Dog::new)
                        .size(EntityDimensions.fixed(0.6F, 0.85F)).build();
        public static final EntityType<StoneGolem> STONEGOLEM = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, StoneGolem::new).size(EntityDimensions.fixed(1.4F, 2.7F))
                        .build();
        public static final EntityType<Illusioner> ILLUSIONER = FabricEntityTypeBuilder
                        .create(EntityCategory.MONSTER, Illusioner::new).size(EntityDimensions.fixed(0.6F, 1.95F))
                        .build();

        public static final EntityType<Try> TRY = FabricEntityTypeBuilder.create(EntityCategory.MONSTER, Try::new)
                        .size(EntityDimensions.fixed(0.6F, 1.95F)).build();

        public static final Identifier AMBIENTTANK = new Identifier("mobz:ambienttank");
        public static SoundEvent AMBIENTTANKEVENT = new SoundEvent(AMBIENTTANK);
        public static final Identifier DEATHTANK = new Identifier("mobz:deathtank");
        public static SoundEvent DEATHTANKEVENT = new SoundEvent(DEATHTANK);
        public static final Identifier HURTTANK = new Identifier("mobz:hurttank");
        public static SoundEvent HURTTANKEVENT = new SoundEvent(HURTTANK);
        public static final Identifier STEPTANK = new Identifier("mobz:steptank");
        public static SoundEvent STEPTANKEVENT = new SoundEvent(STEPTANK);
        public static final Identifier DEATHCREEP = new Identifier("mobz:creepdeath");
        public static SoundEvent DEATHCREEPEVENT = new SoundEvent(DEATHCREEP);
        public static final Identifier SAYCREEP = new Identifier("mobz:creepsay");
        public static SoundEvent SAYCREEPEVENT = new SoundEvent(SAYCREEP);
        public static final Identifier DEATHCRIP = new Identifier("mobz:cripdeath");
        public static SoundEvent DEATHCRIPEVENT = new SoundEvent(DEATHCRIP);
        public static final Identifier SAYCRIP = new Identifier("mobz:cripsay");
        public static SoundEvent SAYCRIPEVENT = new SoundEvent(SAYCRIP);
        public static final Identifier SAYPIG = new Identifier("mobz:pigsay");
        public static SoundEvent SAYPIGEVENT = new SoundEvent(SAYPIG);
        public static final Identifier HURTPIG = new Identifier("mobz:pighurt");
        public static SoundEvent HURTPIGEVENT = new SoundEvent(HURTPIG);
        public static final Identifier DEATHPIG = new Identifier("mobz:pigdeath");
        public static SoundEvent DEATHPIGEVENT = new SoundEvent(DEATHPIG);
        public static final Identifier DEATHEND = new Identifier("mobz:enddeath");
        public static SoundEvent DEATHENDEVENT = new SoundEvent(DEATHEND);
        public static final Identifier ENDHURT = new Identifier("mobz:endhurt");
        public static SoundEvent ENDHURTEVENT = new SoundEvent(ENDHURT);
        public static final Identifier SAYEND = new Identifier("mobz:endsay");
        public static SoundEvent SAYENDEVENT = new SoundEvent(SAYEND);
        public static final Identifier SAYSPEED = new Identifier("mobz:speedsay");
        public static SoundEvent SAYSPEEDEVENT = new SoundEvent(SAYSPEED);
        public static final Identifier STEPSPEED = new Identifier("mobz:speedstep");
        public static SoundEvent STEPSPEEDEVENT = new SoundEvent(STEPSPEED);
        public static final Identifier GOLEMHIT = new Identifier("mobz:golemhit");
        public static SoundEvent GOLEMHITEVENT = new SoundEvent(GOLEMHIT);
        public static final Identifier GOLEMWALK = new Identifier("mobz:golemwalk");
        public static SoundEvent GOLEMWALKEVENT = new SoundEvent(GOLEMWALK);
        public static final Identifier GOLEMDEATH = new Identifier("mobz:golemdeath");
        public static SoundEvent GOLEMDEATHEVENT = new SoundEvent(GOLEMDEATH);
        public static final Identifier SKELIDEATH = new Identifier("mobz:skelideath");
        public static SoundEvent SKELIDEATHEVENT = new SoundEvent(SKELIDEATH);
        public static final Identifier SKELADEATH = new Identifier("mobz:skeladeath");
        public static SoundEvent SKELADEATHEVENT = new SoundEvent(SKELADEATH);
        public static final Identifier SKELIHURT = new Identifier("mobz:skelihurt");
        public static SoundEvent SKELIHURTEVENT = new SoundEvent(SKELIHURT);
        public static final Identifier SKELAHURT = new Identifier("mobz:skelahurt");
        public static SoundEvent SKELAHURTEVENT = new SoundEvent(SKELAHURT);
        public static final Identifier SKELISAY = new Identifier("mobz:skelisay");
        public static SoundEvent SKELISAYEVENT = new SoundEvent(SKELISAY);
        public static final Identifier SKELASAY = new Identifier("mobz:skelasay");
        public static SoundEvent SKELASAYEVENT = new SoundEvent(SKELASAY);
        public static final Identifier SKELISTEP = new Identifier("mobz:skelistep");
        public static SoundEvent SKELISTEPEVENT = new SoundEvent(SKELISTEP);
        public static final Identifier SKELASTEP = new Identifier("mobz:skelastep");
        public static SoundEvent SKELASTEPEVENT = new SoundEvent(SKELASTEP);
        public static final Identifier NOTHING = new Identifier("mobz:nothing");
        public static SoundEvent NOTHINGEVENT = new SoundEvent(NOTHING);
        public static final Identifier ANGRYBATTLEHORN = new Identifier("mobz:angrybattlehorn");
        public static SoundEvent ANGRYBATTLEHORNEVENT = new SoundEvent(ANGRYBATTLEHORN);
        public static final Identifier MEDIVEALSOUND = new Identifier("mobz:medivealsound");
        public static SoundEvent MEDIVEALSOUNDEVENT = new SoundEvent(MEDIVEALSOUND);
        public static final Identifier MEDIVEALSOUND2 = new Identifier("mobz:medivealsound2");
        public static SoundEvent MEDIVEALSOUND2EVENT = new SoundEvent(MEDIVEALSOUND2);
        public static final Identifier EVADEATH = new Identifier("mobz:evadeath");
        public static SoundEvent EVADEATHEVENT = new SoundEvent(EVADEATH);
        public static final Identifier EVAHURT = new Identifier("mobz:evahurt");
        public static SoundEvent EVAHURTEVENT = new SoundEvent(EVAHURT);
        public static final Identifier EVAIDLE = new Identifier("mobz:evaidle");
        public static SoundEvent EVAIDLEEVENT = new SoundEvent(EVAIDLE);
        public static final Identifier EVEDEATH = new Identifier("mobz:evedeath");
        public static SoundEvent EVEDEATHEVENT = new SoundEvent(EVEDEATH);
        public static final Identifier EVEHURT = new Identifier("mobz:evehurt");
        public static SoundEvent EVEHURTEVENT = new SoundEvent(EVEHURT);
        public static final Identifier EVEIDLE = new Identifier("mobz:eveidle");
        public static SoundEvent EVEIDLEEVENT = new SoundEvent(EVEIDLE);

        public static final Identifier ILLUIDLE = new Identifier("mobz:illuidle");
        public static SoundEvent ILLUIDLEEVENT = new SoundEvent(ILLUIDLE);
        public static final Identifier ILLUDEATH = new Identifier("mobz:illudeath");
        public static SoundEvent ILLUDEATHEVENT = new SoundEvent(ILLUDEATH);
        public static final Identifier ILLUHURT = new Identifier("mobz:illuhurt");
        public static SoundEvent ILLUHURTEVENT = new SoundEvent(ILLUHURT);

        public static final String MOD_ID = "mobz";

        public static final BossIngot BOSSBARREN = new BossIngot(new Item.Settings().group(glomod.MOBZ_GROUP));
        public static final MedivealDisc MEDIVEAL_DISC = new MedivealDisc(1, MEDIVEALSOUNDEVENT,
                        new Item.Settings().maxCount(1).group(glomod.MOBZ_GROUP));
        public static final MedivealDisc2 MEDIVEAL_DISC2 = new MedivealDisc2(1, MEDIVEALSOUND2EVENT,
                        new Item.Settings().maxCount(1).group(glomod.MOBZ_GROUP));

        public static final ItemGroup MOBZ_GROUP = FabricItemGroupBuilder.create(new Identifier("mobz", "glomod"))
                        .icon(() -> new ItemStack(SwordItems.ArmoredSword)).appendItems(stacks -> {
                                stacks.add(new ItemStack(SwordItems.ArmoredSword));
                                stacks.add(new ItemStack(SwordItems.BossSword));
                                stacks.add(new ItemStack(BossArmorItems.boss_helmet));
                                stacks.add(new ItemStack(BossArmorItems.boss_chestplate));
                                stacks.add(new ItemStack(BossArmorItems.boss_leggings));
                                stacks.add(new ItemStack(BossArmorItems.boss_boots));
                                stacks.add(new ItemStack(glomod.BOSSBARREN));
                                stacks.add(new ItemStack(glomod.MEDIVEAL_DISC));
                                stacks.add(new ItemStack(glomod.MEDIVEAL_DISC2));

                        }).build();

        @Override
        public void onInitialize() {
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

                Registry.register(Registry.ENTITY_TYPE, new Identifier("mobz", "try_entity"), TRY);

                Registry.register(Registry.SOUND_EVENT, glomod.AMBIENTTANK, AMBIENTTANKEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.DEATHTANK, DEATHTANKEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.HURTTANK, HURTTANKEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.STEPTANK, STEPTANKEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.DEATHCREEP, DEATHCREEPEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.SAYCREEP, SAYCREEPEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.DEATHCRIP, DEATHCRIPEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.SAYCRIP, SAYCRIPEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.SAYPIG, SAYPIGEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.HURTPIG, HURTPIGEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.DEATHPIG, DEATHPIGEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.DEATHEND, DEATHENDEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.ENDHURT, ENDHURTEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.SAYEND, SAYENDEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.SAYSPEED, SAYSPEEDEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.STEPSPEED, STEPSPEEDEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.GOLEMDEATH, GOLEMDEATHEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.GOLEMHIT, GOLEMHITEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.GOLEMWALK, GOLEMWALKEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.SKELADEATH, SKELADEATHEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.SKELAHURT, SKELAHURTEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.SKELASAY, SKELASAYEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.SKELASTEP, SKELASTEPEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.SKELIDEATH, SKELIDEATHEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.SKELIHURT, SKELIHURTEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.SKELISAY, SKELISAYEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.SKELISTEP, SKELISTEPEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.NOTHING, NOTHINGEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.ANGRYBATTLEHORN, ANGRYBATTLEHORNEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.MEDIVEALSOUND, MEDIVEALSOUNDEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.MEDIVEALSOUND2, MEDIVEALSOUND2EVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.EVADEATH, EVADEATHEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.EVAHURT, EVAHURTEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.EVAIDLE, EVAIDLEEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.EVEDEATH, EVEDEATHEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.EVEHURT, EVEHURTEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.EVEIDLE, EVEIDLEEVENT);

                Registry.register(Registry.SOUND_EVENT, glomod.ILLUIDLE, ILLUIDLEEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.ILLUDEATH, ILLUDEATHEVENT);
                Registry.register(Registry.SOUND_EVENT, glomod.ILLUHURT, ILLUHURTEVENT);

                Registry.register(Registry.ITEM, new Identifier("mobz", "medivealdisc"), MEDIVEAL_DISC);
                Registry.register(Registry.ITEM, new Identifier("mobz", "medivealdisc2"), MEDIVEAL_DISC2);
                Registry.register(Registry.ITEM, new Identifier("mobz", "boss_ingot"), BOSSBARREN);

                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_tank"), new SpawnEggItem(TANK, 5055902,
                                2507798, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_fast"), new SpawnEggItem(FAST, 6109639,
                                2968097, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_test"),
                                new SpawnEggItem(TEST, 0, 0, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_armored"), new SpawnEggItem(ARMORED,
                                1397590, 3165729, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_boss"), new SpawnEggItem(BOSS, 1181988,
                                3560490, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_creep"), new SpawnEggItem(CREEP, 4897722,
                                0, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_crip"), new SpawnEggItem(CRIP, 10250793,
                                0, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_ender"), new SpawnEggItem(ENDER, 7884109,
                                2167558, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_enderzombie"), new SpawnEggItem(
                                ENDERZOMBIE, 656405, 3876927, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_spi"), new SpawnEggItem(SPI, 3291714,
                                960680, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_spo"), new SpawnEggItem(SPO, 4864065,
                                10817192, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_pig"), new SpawnEggItem(PIG, 9856837,
                                3169838, new Item.Settings().maxCount(64).group(glomod.MOBZ_GROUP)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_lavagolem"), new SpawnEggItem(LAVAGOLEM,
                                7806478, 16652145, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_icegolem"), new SpawnEggItem(ICEGOLEM,
                                7499112, 1572516, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_skeli1"), new SpawnEggItem(SKELI1,
                                5066061, 3932162, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_skeli2"), new SpawnEggItem(SKELI2,
                                5263682, 11534, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_skeli3"), new SpawnEggItem(SKELI3,
                                4801614, 5121582, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_archer"), new SpawnEggItem(ARCHERENTITY,
                                2123875, 1117987, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_archer2"),
                                new SpawnEggItem(ARCHER2ENTITY, 2123813, 1117987,
                                                new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_bigboss"), new SpawnEggItem(
                                BIGBOSSENTITY, 667182, 984607, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_fulliron"),
                                new SpawnEggItem(FULLIRONENTITY, 888205, 4800672,
                                                new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_knight"), new SpawnEggItem(KNIGHTENTITY,
                                7165479, 7678221, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_knight2"),
                                new SpawnEggItem(KNIGHT2ENTITY, 8881541, 4797474,
                                                new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_mage"), new SpawnEggItem(MAGEENTITY,
                                5128776, 12342593, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_mage2"), new SpawnEggItem(MAGE2ENTITY,
                                4211261, 2375449, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_smallzombie"), new SpawnEggItem(
                                SMALLZOMBIE, 3222535, 1116191, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_frost"), new SpawnEggItem(FROSTENTITY,
                                8709375, 86111, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_dog"), new SpawnEggItem(DOG, 7734790,
                                12550144, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_stonegolem"), new SpawnEggItem(
                                STONEGOLEM, 10197915, 6654258, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_illusioner"), new SpawnEggItem(
                                ILLUSIONER, 6376248, 4344910, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));

                Registry.register(Registry.ITEM, new Identifier("mobz", "spawn_try"), new SpawnEggItem(TRY, 15720703, 0,
                                new Item.Settings().maxCount(64).group(ItemGroup.MISC)));

                SwordItems.init();
                BossArmorItems.init();

        }

}

// You are LOVED!!!
// Jesus loves you unconditional!