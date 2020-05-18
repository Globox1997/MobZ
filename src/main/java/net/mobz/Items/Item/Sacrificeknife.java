package net.mobz.Items.Item;

import java.util.List;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.mobz.Config.configz;
import net.mobz.Inits.Blockinit;

public class Sacrificeknife extends Item {
  private int bloodCounter = 0;

  public Sacrificeknife(Settings settings) {
    super(settings);
    this.addPropertyGetter(new Identifier("bloody"), (stack, world, entity) -> {
      if (bloodCounter > 3400) {
        return 1F;
      }
      return 0F;
    });
    this.addPropertyGetter(new Identifier("lessbloody"), (stack, world, entity) -> {
      if (bloodCounter > 0 && bloodCounter < 3400) {
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
  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
    ItemStack itemStack = user.getStackInHand(hand);
    user.damage(DamageSource.MAGIC, 2F);
    bloodCounter = bloodCounter + 800;
    return TypedActionResult.success(itemStack);
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
    BlockPos pos = context.getBlockPos();
    PlayerEntity player = context.getPlayer();
    BlockState state = context.getWorld().getBlockState(context.getBlockPos());
    if (world.isClient) {
      return ActionResult.PASS;
    } else {
      if (AutoConfig.getConfigHolder(configz.class).getConfig().PillagerBossSpawn) {
        if (state.getBlock() == Blockinit.TOTEM_MIDDLE) {
          if (bloodCounter >= 3400) {
            bloodCounter = 2500;
            world.playSound(null, pos, SoundEvents.ENTITY_WITHER_SPAWN, SoundCategory.HOSTILE, 1F, 1F);
            Blockinit.TOTEMMIDDLEENTITY.get(world, pos).startTimer = true;
            return ActionResult.SUCCESS;
          } else {
            player.addChatMessage(new TranslatableText("text.mobz.sacrificeknifeblood"), true);
            return ActionResult.PASS;
          }
        } else {
          player.addChatMessage(new TranslatableText("text.mobz.pillagermissing"), true);
          return ActionResult.PASS;
        }
      } else {
        player.addChatMessage(new TranslatableText("text.mobz.pillagerspawnable"), true);
        return ActionResult.PASS;
      }
    }
  }
}
