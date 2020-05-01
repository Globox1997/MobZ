package net.mobz.Inits;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.mobz.Items.Head.*;
import net.mobz.Items.Item.*;

public class Iteminit {

    public static final BossIngot BOSSBARREN = new BossIngot(new Item.Settings());
    public static final WeirdIngot WEIRDINGOT = new WeirdIngot(new Item.Settings().maxCount(1));
    public static final HardenedMetal HARDENEDMETAL = new HardenedMetal(new Item.Settings().maxCount(64));
    public static final MedivealDisc MEDIVEAL_DISC = new MedivealDisc(1, Soundinit.MEDIVEALSOUNDEVENT,
            new Item.Settings().maxCount(1));
    public static final MedivealDisc2 MEDIVEAL_DISC2 = new MedivealDisc2(0, Soundinit.MEDIVEALSOUND2EVENT,
            new Item.Settings().maxCount(1));
    public static final Shield SHIELD = new Shield(new Item.Settings().maxCount(1));
    public static final Rottenflesh ROTTENFLESH = new Rottenflesh();
    public static final Redd REDD = new Redd(new Item.Settings());
    public static final Withermeal WITHERMEAL = new Withermeal(new Item.Settings());
    public static final Bearleather BEARLEATHER = new Bearleather(new Item.Settings());
    public static final Sbow SBOW = new Sbow(new Item.Settings().maxCount(1));
    public static final Orb ORB = new Orb(new Item.Settings().maxCount(1));
    public static final Whitebag WHITEBAG = new Whitebag(new Item.Settings().maxCount(1));
    public static final Orb2 ORB2 = new Orb2(new Item.Settings().maxCount(1));
    public static final Showegg SHOWEGG = new Showegg(new Item.Settings().maxCount(1));
    public static final Archerhead ARCHERHEAD = new Archerhead(new Item.Settings().maxCount(1));
    public static final Bosshead BOSSHEAD = new Bosshead(new Item.Settings().maxCount(1));
    public static final Dwarfhead DWARFHEAD = new Dwarfhead(new Item.Settings().maxCount(1));
    public static final Fasthead FASTHEAD = new Fasthead(new Item.Settings().maxCount(1));
    public static final Knight2entityhead KNIGHT2ENTITYHEAD = new Knight2entityhead(new Item.Settings().maxCount(1));
    public static final Knight5entityhead KNIGHT5ENTITYHEAD = new Knight5entityhead(new Item.Settings().maxCount(1));
    public static final Lavagolemhead LAVAGOLEMHEAD = new Lavagolemhead(new Item.Settings().maxCount(1));
    public static final Mageentityhead MAGEENTITYHEAD = new Mageentityhead(new Item.Settings().maxCount(1));
    public static final Spohead SPOHEAD = new Spohead(new Item.Settings().maxCount(1));
    public static final Starthead STARTHEAD = new Starthead(new Item.Settings().maxCount(1));
    public static final Withenderhead WITHENDERHEAD = new Withenderhead(new Item.Settings().maxCount(1));
    public static final Blazehead BLAZEHEAD = new Blazehead(new Item.Settings().maxCount(1));
    public static final Creephead CREEPHEAD = new Creephead(new Item.Settings().maxCount(1));
    public static final Enderhead ENDERHEAD = new Enderhead(new Item.Settings().maxCount(1));
    public static final Friendhead FRIENDHEAD = new Friendhead(new Item.Settings().maxCount(1));
    public static final Golemhead GOLEMHEAD = new Golemhead(new Item.Settings().maxCount(1));
    public static final Skelihead1 SKELIHEAD1 = new Skelihead1(new Item.Settings().maxCount(1));
    public static final Skelihead2 SKELIHEAD2 = new Skelihead2(new Item.Settings().maxCount(1));
    public static final Skelihead3 SKELIHEAD3 = new Skelihead3(new Item.Settings().maxCount(1));
    public static final Criphead CRIPHEAD = new Criphead(new Item.Settings().maxCount(1));
    public static final Enderknighthead ENDERKNIGHTHEAD = new Enderknighthead(new Item.Settings().maxCount(1));
    public static final Enderzombiehead ENDERZOMBIEHEAD = new Enderzombiehead(new Item.Settings().maxCount(1));
    public static final Fiorahead FIORAHEAD = new Fiorahead(new Item.Settings().maxCount(1));
    public static final Icegolemhead ICEGOLEMHEAD = new Icegolemhead(new Item.Settings().maxCount(1));
    public static final Knightentityhead KNIGHTENTITYHEAD = new Knightentityhead(new Item.Settings().maxCount(1));
    public static final Skelihead4 SKELIHEAD4 = new Skelihead4(new Item.Settings().maxCount(1));
    public static final Spihead SPIHEAD = new Spihead(new Item.Settings().maxCount(1));
    public static final Stevehead STEVEHEAD = new Stevehead(new Item.Settings().maxCount(1));
    public static final Witherblazehead WITHERBLAZEHEAD = new Witherblazehead(new Item.Settings().maxCount(1));
    public static final Pillagerbosshead PILLAGERBOSSHEAD = new Pillagerbosshead(new Item.Settings().maxCount(1));
    public static final Pillagerstaff PILLAGERSTAFF = new Pillagerstaff(new Item.Settings().maxCount(1));

    public static void init() {

        Registry.register(Registry.ITEM, new Identifier("mobz", "medivealdisc"), MEDIVEAL_DISC);
        Registry.register(Registry.ITEM, new Identifier("mobz", "medivealdisc2"), MEDIVEAL_DISC2);
        Registry.register(Registry.ITEM, new Identifier("mobz", "boss_ingot"), BOSSBARREN);
        Registry.register(Registry.ITEM, new Identifier("mobz", "weird_ingot"), WEIRDINGOT);
        Registry.register(Registry.ITEM, new Identifier("mobz", "hardenedmetal_ingot"), HARDENEDMETAL);
        Registry.register(Registry.ITEM, new Identifier("mobz", "shield"), SHIELD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "rottenflesh"), ROTTENFLESH);
        Registry.register(Registry.ITEM, new Identifier("mobz", "redd"), REDD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "withermeal"), WITHERMEAL);
        Registry.register(Registry.ITEM, new Identifier("mobz", "bearleather"), BEARLEATHER);
        Registry.register(Registry.ITEM, new Identifier("mobz", "sbow"), SBOW);
        Registry.register(Registry.ITEM, new Identifier("mobz", "orb"), ORB);
        Registry.register(Registry.ITEM, new Identifier("mobz", "whitebag"), WHITEBAG);
        Registry.register(Registry.ITEM, new Identifier("mobz", "orb2"), ORB2);
        Registry.register(Registry.ITEM, new Identifier("mobz", "showegg"), SHOWEGG);
        Registry.register(Registry.ITEM, new Identifier("mobz", "archerhead"), ARCHERHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "bosshead"), BOSSHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "dwarfhead"), DWARFHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "fasthead"), FASTHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "knight2entityhead"), KNIGHT2ENTITYHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "knight5entityhead"), KNIGHT5ENTITYHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "lavagolemhead"), LAVAGOLEMHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "mageentityhead"), MAGEENTITYHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "spohead"), SPOHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "starthead"), STARTHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "withenderhead"), WITHENDERHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "blazehead"), BLAZEHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "creephead"), CREEPHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "enderhead"), ENDERHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "friendhead"), FRIENDHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "golemhead"), GOLEMHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "skelihead1"), SKELIHEAD1);
        Registry.register(Registry.ITEM, new Identifier("mobz", "skelihead2"), SKELIHEAD2);
        Registry.register(Registry.ITEM, new Identifier("mobz", "skelihead3"), SKELIHEAD3);
        Registry.register(Registry.ITEM, new Identifier("mobz", "criphead"), CRIPHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "enderknighthead"), ENDERKNIGHTHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "enderzombiehead"), ENDERZOMBIEHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "fiorahead"), FIORAHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "icegolemhead"), ICEGOLEMHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "knightentityhead"), KNIGHTENTITYHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "skelihead4"), SKELIHEAD4);
        Registry.register(Registry.ITEM, new Identifier("mobz", "spihead"), SPIHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "stevehead"), STEVEHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "witherblazehead"), WITHERBLAZEHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "pillagerbosshead"), PILLAGERBOSSHEAD);
        Registry.register(Registry.ITEM, new Identifier("mobz", "pillagerstaff"), PILLAGERSTAFF);

    }

}