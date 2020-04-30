package net.mobz.Items.Item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Withermeal extends Item {
    public Withermeal(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        ItemStack mealitem = player.getMainHandStack();
        if (context.getWorld().isClient) {
            return ActionResult.PASS;
        } else {
            BlockState state = context.getWorld().getBlockState(context.getBlockPos());
            if (state.getBlock() == Blocks.SOUL_SAND) {
                BlockPos oke = context.getBlockPos().up();
                world.setBlockState(oke, Blocks.WITHER_ROSE.getDefaultState(), 3);
                mealitem.decrement(1);
                return ActionResult.SUCCESS;
            } else {
                return ActionResult.PASS;
            }
        }
    }
}