package net.mobz.Inits;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.mobz.Blocks.*;

public class Blockinit {

  public static final Enderheader ENDERHEADER = new Enderheader(FabricBlockSettings.copy(Blocks.ZOMBIE_HEAD).build());
  public static final TotemBase TOTEM_BASE = new TotemBase(FabricBlockSettings.copy(Blocks.OAK_LOG).build());
  public static final TotemMiddle TOTEM_MIDDLE = new TotemMiddle(FabricBlockSettings.copy(Blocks.OAK_LOG).build());
  public static final TotemTop TOTEM_TOP = new TotemTop(FabricBlockSettings.copy(Blocks.OAK_LOG).build());
  public static final Bosstrophy BOSSTROPHY = new Bosstrophy(FabricBlockSettings.copy(Blocks.ZOMBIE_HEAD).build());

  public static void init() {

    Registry.register(Registry.ITEM, new Identifier("mobz", "enderheader"),
        new BlockItem(ENDERHEADER, new Item.Settings()));
    Registry.register(Registry.BLOCK, new Identifier("mobz", "enderheader"), ENDERHEADER);
    Registry.register(Registry.ITEM, new Identifier("mobz", "totembase"),
        new BlockItem(TOTEM_BASE, new Item.Settings()));
    Registry.register(Registry.BLOCK, new Identifier("mobz", "totembase"), TOTEM_BASE);
    Registry.register(Registry.ITEM, new Identifier("mobz", "totemmiddle"),
        new BlockItem(TOTEM_MIDDLE, new Item.Settings()));
    Registry.register(Registry.BLOCK, new Identifier("mobz", "totemmiddle"), TOTEM_MIDDLE);
    Registry.register(Registry.ITEM, new Identifier("mobz", "totemtop"), new BlockItem(TOTEM_TOP, new Item.Settings()));
    Registry.register(Registry.BLOCK, new Identifier("mobz", "totemtop"), TOTEM_TOP);
    Registry.register(Registry.ITEM, new Identifier("mobz", "bosstrophy"),
        new BlockItem(BOSSTROPHY, new Item.Settings()));
    Registry.register(Registry.BLOCK, new Identifier("mobz", "bosstrophy"), BOSSTROPHY);

  }
}