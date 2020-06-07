package net.mobz.Items.Item;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class Withermeal extends Item {
    int particleNumber = 6;

    public Withermeal(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.mobz.withermeal.tooltip"));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        ItemStack mealitem = player.getMainHandStack();
        BlockPos pos = context.getBlockPos();
        BlockState blockState = world.getBlockState(pos);
        // if (context.getWorld().isClient) {
        // return ActionResult.PASS;
        // } else {
        if (blockState.getBlock() == Blocks.SOUL_SAND && !context.getWorld().isClient) {
            Random random = new Random();
            int randomNumber = (random.nextInt() % 2);
            if (randomNumber < 0) {
                randomNumber = randomNumber * (-1);
            }
            if (world.getBlockState(pos.east()).getBlock().equals(Blocks.SOUL_SAND) && randomNumber == 0) {
                world.setBlockState(pos.east().up(), Blocks.WITHER_ROSE.getDefaultState(), 3);
            }
            if (world.getBlockState(pos.south()).getBlock().equals(Blocks.SOUL_SAND) && randomNumber == 1) {
                world.setBlockState(pos.south().up(), Blocks.WITHER_ROSE.getDefaultState(), 3);
            }
            if (world.getBlockState(pos.north()).getBlock().equals(Blocks.SOUL_SAND) && randomNumber == 0) {
                world.setBlockState(pos.north().up(), Blocks.WITHER_ROSE.getDefaultState(), 3);
            }
            if (world.getBlockState(pos.west()).getBlock().equals(Blocks.SOUL_SAND) && randomNumber == 1) {
                world.setBlockState(pos.west().up(), Blocks.WITHER_ROSE.getDefaultState(), 3);
            }
            world.setBlockState(pos.up(), Blocks.WITHER_ROSE.getDefaultState(), 3);
            mealitem.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (((blockState.getBlock() == Blocks.SOUL_SAND || blockState.getBlock() == Blocks.FARMLAND)
                && context.getWorld().isClient)) {
            for (int i = 0; i < particleNumber; ++i) {
                double d = RANDOM.nextGaussian() * 0.02D;
                double e = RANDOM.nextGaussian() * 0.02D;
                double f = RANDOM.nextGaussian() * 0.02D;
                world.addParticle(ParticleTypes.HAPPY_VILLAGER, (double) ((float) pos.getX() + RANDOM.nextFloat()),
                        (double) pos.getY() + (double) RANDOM.nextFloat()
                                * blockState.getOutlineShape(world, pos).getMaximum(Direction.Axis.Y) + 1,
                        (double) ((float) pos.getZ() + RANDOM.nextFloat()), d, e, f);
            }
            return ActionResult.SUCCESS;
        }

        if (blockState.getBlock() == Blocks.FARMLAND && !context.getWorld().isClient) {
            if (world.getBlockState(pos.east()).getBlock().equals(Blocks.FARMLAND)) {
                world.setBlockState(pos.east(), Blocks.SOUL_SAND.getDefaultState(), 3);
            }
            if (world.getBlockState(pos.south()).getBlock().equals(Blocks.FARMLAND)) {
                world.setBlockState(pos.south(), Blocks.SOUL_SAND.getDefaultState(), 3);
            }
            if (world.getBlockState(pos.north()).getBlock().equals(Blocks.FARMLAND)) {
                world.setBlockState(pos.north(), Blocks.SOUL_SAND.getDefaultState(), 3);
            }
            if (world.getBlockState(pos.west()).getBlock().equals(Blocks.FARMLAND)) {
                world.setBlockState(pos.west(), Blocks.SOUL_SAND.getDefaultState(), 3);
            }
            world.setBlockState(pos.up(), Blocks.WITHER_ROSE.getDefaultState(), 3);
            world.setBlockState(pos, Blocks.SOUL_SAND.getDefaultState(), 3);
            mealitem.decrement(1);
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }
}