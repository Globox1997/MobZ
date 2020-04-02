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

  public static void init() {

    Registry.register(Registry.ITEM, new Identifier("mobz", "enderheader"),
        new BlockItem(ENDERHEADER, new Item.Settings()));
    Registry.register(Registry.BLOCK, new Identifier("mobz", "enderheader"), ENDERHEADER);

  }
}