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
    public static final MedivealDisc2 MEDIVEAL_DISC2 = new MedivealDisc2(1, Soundinit.MEDIVEALSOUND2EVENT,
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

    }

}