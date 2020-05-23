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
  private int dryingNumber = 0;

  public Sacrificeknife(Settings settings) {
    super(settings);
    this.addPropertyGetter(new Identifier("blood1"), (stack, world, entity) -> {
      if (bloodCounter < 1000 && bloodCounter > 600 && dryingNumber == 1) {
        return 0.11F;
      }
      return 0F;
    });
    this.addPropertyGetter(new Identifier("blood2"), (stack, world, entity) -> {
      if (bloodCounter < 2000 && bloodCounter >= 1400 && dryingNumber == 2) {
        return 0.22F;
      }
      return 0F;
    });
    this.addPropertyGetter(new Identifier("blood3"), (stack, world, entity) -> {
      if (bloodCounter < 3000 && bloodCounter >= 2000 && dryingNumber == 3) {
        return 0.33F;
      }
      return 0F;
    });
    this.addPropertyGetter(new Identifier("blood4"), (stack, world, entity) -> {
      if (bloodCounter > 3000 && dryingNumber == 4) {
        return 0.44F;
      }
      return 0F;
    });
    this.addPropertyGetter(new Identifier("blood1dry1"), (stack, world, entity) -> {
      if (bloodCounter <= 600 && bloodCounter > 300 && dryingNumber == 1) {
        return 0.15F;
      }
      return 0F;
    });
    this.addPropertyGetter(new Identifier("blood1dry2"), (stack, world, entity) -> {
      if (bloodCounter <= 300 && bloodCounter > 0 && dryingNumber == 1) {
        return 0.19F;
      }
      return 0F;
    });
    this.addPropertyGetter(new Identifier("blood2dry1"), (stack, world, entity) -> {
      if (bloodCounter <= 1400 && bloodCounter > 600 && dryingNumber == 2) {
        return 0.25F;
      }
      return 0F;
    });
    this.addPropertyGetter(new Identifier("blood2dry2"), (stack, world, entity) -> {
      if (bloodCounter <= 600 && bloodCounter > 0 && dryingNumber == 2) {
        return 0.29F;
      }
      return 0F;
    });
    this.addPropertyGetter(new Identifier("blood3dry1"), (stack, world, entity) -> {
      if (bloodCounter <= 2000 && bloodCounter > 1000 && dryingNumber == 3) {
        return 0.35F;
      }
      return 0F;
    });
    this.addPropertyGetter(new Identifier("blood3dry2"), (stack, world, entity) -> {
      if (bloodCounter <= 1000 && bloodCounter > 0 && dryingNumber == 3) {
        return 0.39F;
      }
      return 0F;
    });
    this.addPropertyGetter(new Identifier("blood4dry1"), (stack, world, entity) -> {
      if (bloodCounter <= 3000 && bloodCounter > 1500 && dryingNumber == 4) {
        return 0.45F;
      }
      return 0F;
    });
    this.addPropertyGetter(new Identifier("blood4dry2"), (stack, world, entity) -> {
      if (bloodCounter <= 1500 && bloodCounter > 0 && dryingNumber == 4) {
        return 0.49F;
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
    if (!world.isClient) {
      user.damage(DamageSource.MAGIC, 2F);
      if (dryingNumber < 4) {
        dryingNumber = dryingNumber + 1;
      }
      if (bloodCounter < 5000) {
        bloodCounter = bloodCounter + 950;
      }
      return TypedActionResult.success(itemStack);
    } else
      return TypedActionResult.success(itemStack);
  }

  @Override
  public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
    if (!world.isClient) {
      if (bloodCounter > 0) {
        bloodCounter--;
      }
      if (bloodCounter == 0) {
        dryingNumber = 0;
      }
    }
  }

  @Override
  public ActionResult useOnBlock(ItemUsageContext context) {
    World world = context.getWorld();
    BlockPos pos = context.getBlockPos();
    PlayerEntity player = context.getPlayer();
    BlockState state = context.getWorld().getBlockState(context.getBlockPos());
    BlockState stateUp = context.getWorld().getBlockState(context.getBlockPos().up());
    BlockState stateDown = context.getWorld().getBlockState(context.getBlockPos().down());
    if (state.getBlock() == Blockinit.TOTEM_MIDDLE) {
      if (stateUp.getBlock() == Blockinit.TOTEM_TOP && stateDown.getBlock() == Blockinit.TOTEM_BASE) {
        if (AutoConfig.getConfigHolder(configz.class).getConfig().PillagerBossSpawn) {
          if (bloodCounter > 3000) {
            if (Blockinit.TOTEMMIDDLEENTITY.get(world, pos).startTimer == false) {
              world.playSound(player, pos, SoundEvents.ENTITY_WITHER_SPAWN, SoundCategory.HOSTILE, 1F, 1F);
              Blockinit.TOTEMMIDDLEENTITY.get(world, pos).startTimer = true;
              return ActionResult.SUCCESS;
            } else {
              return ActionResult.PASS;
            }
          } else {
            player.addChatMessage(new TranslatableText("text.mobz.sacrificeknifeblood"), true);
            return ActionResult.PASS;
          }
        } else {
          player.addChatMessage(new TranslatableText("text.mobz.pillagerspawnable"), true);
          return ActionResult.PASS;
        }
      } else {
        player.addChatMessage(new TranslatableText("text.mobz.pillagermissing"), true);
        return ActionResult.PASS;
      }
    } else {
      return ActionResult.PASS;
    }
  }
}
