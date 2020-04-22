package net.mobz.Items.Item;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.mobz.Blocks.Enderheader;
import net.mobz.Entity.Withender;
import net.mobz.Inits.Blockinit;
import net.mobz.Inits.Entityinit;

public class Pillagerstaff extends Item {
    int particlecounter = 0;

    public Pillagerstaff(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.mobz.pillagerstaff.tooltip"));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        if (context.getWorld().isClient)
            return ActionResult.PASS;
        BlockState state = context.getWorld().getBlockState(context.getBlockPos());
        if (state.getBlock() == Blockinit.ENDERHEADER) {

            if (Enderheader.isValid(context.getWorld(), context.getBlockPos(), state)) {
                Withender wither = (Withender) Entityinit.WITHENDER.create(world);
                BlockPos oke = context.getBlockPos();
                wither.refreshPositionAndAngles(oke, 0.0F, 0.0F);
                world.spawnEntity(wither);
                return ActionResult.SUCCESS;
            } else {
                player.addChatMessage(new TranslatableText("text.mobz.withendermissing"), true);
            }

        }
        return ActionResult.PASS;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 600;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity) user;

            if (!world.isClient) {
                if (!playerEntity.isSneaking()) {
                    Random random = new Random();
                    Random random2 = new Random();
                    Random random3 = new Random();
                    double z1 = (random.nextInt() % 50);
                    double z2 = z1 / 100;
                    double z3 = random2.nextInt() % 50;
                    double z4 = z3 / 100;
                    double z5 = random3.nextInt() % 180;
                    double z6 = z5 / 100;
                    Vec3d vec3d_1 = playerEntity.getRotationVec(1.0F);
                    double double_3 = vec3d_1.x;
                    double double_4 = vec3d_1.y;
                    double double_5 = vec3d_1.z;
                    WitherSkullEntity skull1 = new WitherSkullEntity(world, playerEntity.getX() + vec3d_1.x,
                            playerEntity.getY() + 1.2D, playerEntity.getZ() + vec3d_1.z, double_3, double_4, double_5);
                    world.spawnEntity(skull1);
                    playerEntity.damage(DamageSource.WITHER, 2F);
                    playerEntity.playSound(SoundEvents.ENTITY_WITHER_HURT, SoundCategory.AMBIENT, 1F, 1F);
                    while (particlecounter < 20) {
                        world.addParticle(ParticleTypes.MYCELIUM, true, playerEntity.getX() + z2,
                                playerEntity.getY() + z6, playerEntity.getZ() + z4, 0D, 0D, 0D);
                        particlecounter++;
                    }
                    if (particlecounter >= 20) {
                        particlecounter = 0;
                    }
                    return TypedActionResult.success(user.getStackInHand(hand));

                } else {
                    return TypedActionResult.pass(user.getStackInHand(hand));
                }
            }
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

}