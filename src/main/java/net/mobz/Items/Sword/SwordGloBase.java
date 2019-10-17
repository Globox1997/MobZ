package net.mobz.Items.Sword;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.mobz.glomod;

public class SwordGloBase extends SwordItem {
    public SwordGloBase(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, 1, -2.4f, new Item.Settings().group(glomod.MOBZ_GROUP));
    }
}
