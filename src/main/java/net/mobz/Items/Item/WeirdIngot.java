package net.mobz.Items.Item;

import java.util.List;
import java.util.Random;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.mobz.Blocks.TotemMiddle;
import net.mobz.Config.configz;
import net.mobz.Entity.PillagerBoss;
import net.mobz.Inits.Blockinit;
import net.mobz.Inits.Entityinit;

public class WeirdIngot extends Item {

    public WeirdIngot(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.mobz.weird_ingot.tooltip"));
    }

    StatusEffectInstance slow = new StatusEffectInstance(StatusEffect.byRawId(2), 0, 0, false, false);

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        LivingEntity bob = (LivingEntity) entity;
        Random random = new Random();
        Random random2 = new Random();
        Random random3 = new Random();
        double z1 = (random.nextInt() % 50);
        double z2 = z1 / 100;
        double z3 = random2.nextInt() % 50;
        double z4 = z3 / 100;
        double z5 = random3.nextInt() % 180;
        double z6 = z5 / 100;
        if (selected == true) {
            bob.addStatusEffect(slow);
            world.addParticle(ParticleTypes.DRAGON_BREATH, bob.getX() + z2, bob.getY() + z6, bob.getZ() + z4, 0.0D,
                    0.0D, 0.0D);

        }

    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        ItemStack ingot = player.getMainHandStack();
        if (context.getWorld().isClient)
            return ActionResult.PASS;
        BlockState state = context.getWorld().getBlockState(context.getBlockPos());
        if (state.getBlock() == Blockinit.TOTEM_MIDDLE) {
            if (context.getWorld().getDimension().getType() == DimensionType.OVERWORLD) {
                if (TotemMiddle.isValid(context.getWorld(), context.getBlockPos(), state)) {
                    if (AutoConfig.getConfigHolder(configz.class).getConfig().PillagerBossSpawn) {
                        PillagerBoss pillager = (PillagerBoss) Entityinit.PILLAGERBOSS.create(world);
                        BlockPos oke = context.getBlockPos();
                        pillager.refreshPositionAndAngles(oke, 0.0F, 0.0F);
                        ingot.decrement(1);
                        world.spawnEntity(pillager);
                        return ActionResult.SUCCESS;
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