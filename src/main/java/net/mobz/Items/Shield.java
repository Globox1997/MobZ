package net.mobz.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ShieldItem;


import net.mobz.glomod;

public class Shield extends ShieldItem {
    public Shield(Settings settings) {
        super(new Item.Settings().group(glomod.MOBZ_GROUP));
    }

}
