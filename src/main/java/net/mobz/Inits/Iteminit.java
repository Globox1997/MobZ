package net.mobz.Inits;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
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

    }

}