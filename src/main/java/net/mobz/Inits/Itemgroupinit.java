package net.mobz.Inits;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Itemgroupinit {

    public static ItemGroup EGGZ_GROUP = FabricItemGroupBuilder.build(new Identifier("mobz", "glomodegg"),
            () -> new ItemStack(Iteminit.SHOWEGG));

    public static final ItemGroup MOBZ_GROUP = FabricItemGroupBuilder.create(new Identifier("mobz", "glomod"))
            .icon(() -> new ItemStack(SwordItems.ArmoredSword)).appendItems(stacks -> {
                stacks.add(new ItemStack(SwordItems.ArmoredSword));
                stacks.add(new ItemStack(SwordItems.PoisonSword));
                stacks.add(new ItemStack(SwordItems.FrozenSword));
                stacks.add(new ItemStack(SwordItems.WitherSword));
                stacks.add(new ItemStack(SwordItems.VSword));
                stacks.add(new ItemStack(SwordItems.BossSword));
                stacks.add(new ItemStack(SwordItems.Sword));
                stacks.add(ItemStack.EMPTY);
                stacks.add(ItemStack.EMPTY);
                stacks.add(new ItemStack(SwordItems.Axe));
                stacks.add(new ItemStack(Iteminit.SHIELD));
                stacks.add(new ItemStack(Iteminit.SBOW));
                stacks.add(new ItemStack(Iteminit.PILLAGERSTAFF));
                stacks.add(ItemStack.EMPTY);
                stacks.add(ItemStack.EMPTY);
                stacks.add(ItemStack.EMPTY);
                stacks.add(ItemStack.EMPTY);
                stacks.add(ItemStack.EMPTY);
                stacks.add(new ItemStack(ArmorItems.boss_helmet));
                stacks.add(new ItemStack(ArmorItems.boss_chestplate));
                stacks.add(new ItemStack(ArmorItems.boss_leggings));
                stacks.add(new ItemStack(ArmorItems.boss_boots));
                stacks.add(ItemStack.EMPTY);
                stacks.add(new ItemStack(ArmorItems.life_helmet));
                stacks.add(new ItemStack(ArmorItems.life_chestplate));
                stacks.add(new ItemStack(ArmorItems.life_leggings));
                stacks.add(new ItemStack(ArmorItems.life_boots));
                stacks.add(new ItemStack(ArmorItems.amat_helmet));
                stacks.add(new ItemStack(ArmorItems.amat_chestplate));
                stacks.add(new ItemStack(ArmorItems.amat_leggings));
                stacks.add(new ItemStack(ArmorItems.amat_boots));
                stacks.add(ItemStack.EMPTY);
                stacks.add(ItemStack.EMPTY);
                stacks.add(ItemStack.EMPTY);
                stacks.add(new ItemStack(ArmorItems.speed_boots));
                stacks.add(new ItemStack(ArmorItems.speed2_boots));
                stacks.add(new ItemStack(Iteminit.ROTTENFLESH));
                stacks.add(new ItemStack(Iteminit.BEARLEATHER));
                stacks.add(new ItemStack(Iteminit.WITHERMEAL));
                stacks.add(new ItemStack(Iteminit.REDD));
                stacks.add(new ItemStack(Iteminit.WEIRDINGOT));
                stacks.add(new ItemStack(Iteminit.HARDENEDMETAL));
                stacks.add(new ItemStack(Iteminit.BOSSBARREN));
                stacks.add(ItemStack.EMPTY);
                stacks.add(ItemStack.EMPTY);
                stacks.add(new ItemStack(Blockinit.TOTEM_BASE));
                stacks.add(new ItemStack(Blockinit.TOTEM_MIDDLE));
                stacks.add(new ItemStack(Blockinit.TOTEM_TOP));
                stacks.add(ItemStack.EMPTY);
                stacks.add(ItemStack.EMPTY);
                stacks.add(ItemStack.EMPTY);
                stacks.add(ItemStack.EMPTY);
                stacks.add(new ItemStack(Blockinit.ENDERHEADER));
                stacks.add(new ItemStack(Blockinit.BOSSTROPHY));
                stacks.add(new ItemStack(Iteminit.MEDIVEAL_DISC));
                stacks.add(new ItemStack(Iteminit.MEDIVEAL_DISC2));
                stacks.add(new ItemStack(Iteminit.ORB));
                stacks.add(new ItemStack(Iteminit.ORB2));
                stacks.add(new ItemStack(Iteminit.WHITEBAG));
                stacks.add(ItemStack.EMPTY);
                stacks.add(ItemStack.EMPTY);
                stacks.add(ItemStack.EMPTY);
                stacks.add(new ItemStack(SwordItems.Debuger));

            }).build();

    public static void init() {

    }

}