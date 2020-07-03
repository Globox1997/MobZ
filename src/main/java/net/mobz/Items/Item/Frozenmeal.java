package net.mobz.Items.Item;

import java.util.List;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidDrainable;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.RayTraceContext;

public class Frozenmeal extends Item {

  public Frozenmeal(Settings settings) {
    super(settings);
  }

  @Override
  public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
    tooltip.add(new TranslatableText("item.mobz.frozenmeal.tooltip"));
  }

  @Override
  public ActionResult useOnBlock(ItemUsageContext context) {
    World world = context.getWorld();
    PlayerEntity player = context.getPlayer();
    ItemStack handItem = player.getMainHandStack();
    BlockPos pos = context.getBlockPos();
    BlockState blockState = world.getBlockState(pos);
    HitResult hitResult = rayTrace(world, player, RayTraceContext.FluidHandling.SOURCE_ONLY);
    BlockHitResult blockHitResult = (BlockHitResult) hitResult;
    BlockPos blockPos = blockHitResult.getBlockPos();
    BlockState blockBlock = world.getBlockState(blockPos);

    if (blockBlock.getBlock() instanceof FluidDrainable && !context.getWorld().isClient) {
      world.setBlockState(blockPos, Blocks.ICE.getDefaultState(), 3);
      handItem.decrement(1);
      return ActionResult.SUCCESS;
    }
    if (((blockState.getBlock() == Blocks.WATER || blockState.getBlock() == Blocks.ICE)
        && context.getWorld().isClient)) {
      for (int i = 0; i < 16; ++i) {
        double d = RANDOM.nextGaussian() * 0.02D;
        double e = RANDOM.nextGaussian() * 0.02D;
        double f = RANDOM.nextGaussian() * 0.02D;
        world.addParticle(ParticleTypes.HAPPY_VILLAGER, (double) ((float) pos.getX() + RANDOM.nextFloat()),
            (double) pos.getY()
                + (double) RANDOM.nextFloat() * blockState.getOutlineShape(world, pos).getMax(Direction.Axis.Y),
            (double) ((float) pos.getZ() + RANDOM.nextFloat()), d, e, f);
      }
      return ActionResult.SUCCESS;
    }
    if (blockState.getBlock() == Blocks.ICE && !context.getWorld().isClient) {
      if (world.getBlockState(pos.east()).getBlock().equals(Blocks.ICE)) {
        world.setBlockState(pos.east(), Blocks.BLUE_ICE.getDefaultState(), 3);
      }
      if (world.getBlockState(pos.south()).getBlock().equals(Blocks.ICE)) {
        world.setBlockState(pos.south(), Blocks.BLUE_ICE.getDefaultState(), 3);
      }
      if (world.getBlockState(pos.north()).getBlock().equals(Blocks.ICE)) {
        world.setBlockState(pos.north(), Blocks.BLUE_ICE.getDefaultState(), 3);
      }
      if (world.getBlockState(pos.west()).getBlock().equals(Blocks.ICE)) {
        world.setBlockState(pos.west(), Blocks.BLUE_ICE.getDefaultState(), 3);
      }
      world.setBlockState(pos, Blocks.BLUE_ICE.getDefaultState(), 3);
      handItem.decrement(1);
      return ActionResult.SUCCESS;
    } else {
      return ActionResult.PASS;
    }
  }
}