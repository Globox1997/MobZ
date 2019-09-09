package net.mobz;

import net.mobz.Entity.*;
import net.mobz.Items.*;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundEvent;

public class glomod implements ModInitializer {

    public static final EntityType<TankEntity> TANK = FabricEntityTypeBuilder
            .create(EntityCategory.MONSTER, TankEntity::new).size(EntityDimensions.fixed(0.6F, 1.95F)).build();
    public static final EntityType<FastEntity> FAST = FabricEntityTypeBuilder
            .create(EntityCategory.MONSTER, FastEntity::new).size(EntityDimensions.fixed(0.6F, 1.95F)).build();
    public static final EntityType<TestEntity> TEST = FabricEntityTypeBuilder
            .create(EntityCategory.MONSTER, TestEntity::new).size(EntityDimensions.fixed(0.6F, 1.95F)).build();
    public static final EntityType<ArmoredEntity> ARMORED = FabricEntityTypeBuilder
            .create(EntityCategory.MONSTER, ArmoredEntity::new).size(EntityDimensions.fixed(0.6F, 1.95F)).build();
    public static final EntityType<BossEntity> BOSS = FabricEntityTypeBuilder
            .create(EntityCategory.MONSTER, BossEntity::new).setImmuneToFire().size(EntityDimensions.fixed(0.6F, 1.95F))
            .build();
    public static final EntityType<CreepEntity> CREEP = FabricEntityTypeBuilder
            .create(EntityCategory.MONSTER, CreepEntity::new).size(EntityDimensions.fixed(0.6F, 1.7F)).build();
    public static final EntityType<CripEntity> CRIP = FabricEntityTypeBuilder
            .create(EntityCategory.MONSTER, CripEntity::new).size(EntityDimensions.fixed(0.6F, 1.7F)).build();
    public static final EntityType<EnderEntity> ENDER = FabricEntityTypeBuilder
            .create(EntityCategory.MONSTER, EnderEntity::new).size(EntityDimensions.fixed(0.6F, 2.9F)).build();
    public static final EntityType<EnderZombieEntity> ENDERZOMBIE = FabricEntityTypeBuilder
            .create(EntityCategory.MONSTER, EnderZombieEntity::new).size(EntityDimensions.fixed(0.6F, 1.95F)).build();
    public static final EntityType<SpiEntity> SPI = FabricEntityTypeBuilder
            .create(EntityCategory.MONSTER, SpiEntity::new).size(EntityDimensions.fixed(1.4F, 0.9F)).build();
    public static final EntityType<SpoEntity> SPO = FabricEntityTypeBuilder
            .create(EntityCategory.MONSTER, SpoEntity::new).size(EntityDimensions.fixed(1.4F, 0.9F)).build();
    public static final BossIngot BOSSBARREN = new BossIngot(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final EntityType<PigmanEntity> PIG = FabricEntityTypeBuilder
            .create(EntityCategory.MONSTER, PigmanEntity::new).size(EntityDimensions.fixed(0.6F, 1.95F)).build();
    public static final EntityType<LavaGolem> LAVAGOLEM = FabricEntityTypeBuilder
            .create(EntityCategory.MONSTER, LavaGolem::new).size(EntityDimensions.fixed(1.4F, 2.7F)).build();
    public static final EntityType<IceGolem> ICEGOLEM = FabricEntityTypeBuilder
            .create(EntityCategory.MONSTER, IceGolem::new).size(EntityDimensions.fixed(1.4F, 2.7F)).build();
    public static final EntityType<skeli1> SKELI1 = FabricEntityTypeBuilder.create(EntityCategory.MONSTER, skeli1::new)
            .setImmuneToFire().size(EntityDimensions.fixed(0.6F, 1.99F)).build();
    public static final EntityType<skeli2> SKELI2 = FabricEntityTypeBuilder.create(EntityCategory.MONSTER, skeli2::new)
            .setImmuneToFire().size(EntityDimensions.fixed(0.6F, 1.99F)).build();
    public static final EntityType<skeli3> SKELI3 = FabricEntityTypeBuilder.create(EntityCategory.MONSTER, skeli3::new)
            .size(EntityDimensions.fixed(0.6F, 1.99F)).build();

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

        Registry.register(Registry.ITEM, new Identifier("mobz", "boss_ingot"), BOSSBARREN);

        SwordItems.init();
        BossArmorItems.init();
    }

}

// You are LOVED!!!
// Jesus loves you unconditional!