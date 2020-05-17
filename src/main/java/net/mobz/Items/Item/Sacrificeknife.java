package net.mobz.Items.Item;

import java.util.List;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.mobz.Blocks.TotemMiddle;
import net.mobz.Config.configz;
import net.mobz.Entity.PillagerBoss;
import net.mobz.Inits.Blockinit;
import net.mobz.Inits.Entityinit;

public class Sacrificeknife extends Item {
  private int bloodCounter = 0;
  private int spawnTimer;

  public Sacrificeknife(Settings settings) {
    super(settings);
    this.addPropertyGetter(new Identifier("bloody"), (stack, world, entity) -> {
      if (bloodCounter <= 120 && bloodCounter > 60) {
        return 1F;
      }
      return 0F;
    });
    this.addPropertyGetter(new Identifier("lessbloody"), (stack, world, entity) -> {
      if (bloodCounter <= 60 && bloodCounter > 0) {
        return 0.5F;
      }
      return 0F;
    });
  }

  @Override
  public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
    tooltip.add(new TranslatableText("item.mobz.sacrificeknife.tooltip"));
  }

  @Override
  public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
    if (bloodCounter > 0 && !world.isClient) {
      bloodCounter--;
    }
  }

  @Override
  public ActionResult useOnBlock(ItemUsageContext context) {
    World world = context.getWorld();
    PlayerEntity player = context.getPlayer();
    if (context.getWorld().isClient) {
      return ActionResult.PASS;
    } else {
      BlockState state = context.getWorld().getBlockState(context.getBlockPos());
      if (state.getBlock() == Blockinit.TOTEM_MIDDLE) {
        if (context.getWorld().getDimension().getType() == DimensionType.OVERWORLD) {
          if (TotemMiddle.isValid(context.getWorld(), context.getBlockPos(), state)) {
            if (AutoConfig.getConfigHolder(configz.class).getConfig().PillagerBossSpawn) {
              if (bloodCounter == 0) {
                bloodCounter = 120;
                PillagerBoss pillager = (PillagerBoss) Entityinit.PILLAGERBOSS.create(world);
                BlockPos oke = context.getBlockPos();
                pillager.refreshPositionAndAngles(oke, 0.0F, 0.0F);
                spawnTimer = (int) (world.getTime());
                world.spawnEntity(pillager);
                return ActionResult.SUCCESS;
              } else {
                player.addChatMessage(new TranslatableText("text.mobz.sacrificeknifeblood"), true);
              }
            } else {
              player.addChatMessage(new TranslatableText("text.mobz.pillagerspawnable"), true);
            }
          } else {
            player.addChatMessage(new TranslatableText("text.mobz.pillagermissing"), true);

          }
        } else {
          player.addChatMessage(new TranslatableText("text.mobz.pillagerdimension"), true);
        }
      }
      return ActionResult.PASS;
    }
  }

}