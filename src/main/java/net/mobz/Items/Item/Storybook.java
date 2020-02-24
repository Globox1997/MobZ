/*package net.mobz.Items.Item;

import java.util.List;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LecternBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.WritableBookItem;
import net.minecraft.item.WrittenBookItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.stat.Stats;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.Texts;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ChatUtil;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.mobz.Entity.Nullable;

public class Storybook extends Item {
   public Storybook(Item.Settings settings) {
      super(settings);
   }

   public static boolean isValid(@Nullable CompoundTag tag) {
      if (!WritableBookItem.isValid(tag)) {
         return false;
      } else if (!tag.contains("title", 8)) {
         return false;
      } else {
         String string = tag.getString("title");
         return string.length() > 32 ? false : tag.contains("author", 8);
      }
   } 


   public static int getPageCount(ItemStack stack) {
      /*CompoundTag compoundTag = stack.getTag();
      return compoundTag != null ? compoundTag.getList("pages", 8).size() : 0; 
      return 8;
   }

   public Text getName(ItemStack stack) {
    //  if (stack.hasTag()) {
         CompoundTag compoundTag = stack.getTag();
         String string = compoundTag.getString("Story Book");
        // if (!ChatUtil.isEmpty(string)) {
      //      return new LiteralText(string);
       //  }
    //  }

      return super.getName(stack);
   } 

   @Environment(EnvType.CLIENT)


   public ActionResult useOnBlock(ItemUsageContext context) {
      World world = context.getWorld();
      BlockPos blockPos = context.getBlockPos();
      BlockState blockState = world.getBlockState(blockPos);
      if (blockState.getBlock() == Blocks.LECTERN) {
         return LecternBlock.putBookIfAbsent(world, blockPos, blockState, context.getStack()) ? ActionResult.SUCCESS : ActionResult.PASS;
      } else {
         return ActionResult.PASS;
      }
   }

   public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
      ItemStack itemStack = user.getStackInHand(hand);
      user.openEditBookScreen(itemStack, hand);
      user.incrementStat(Stats.USED.getOrCreateStat(this));
      return TypedActionResult.success(itemStack);
   }


   public static boolean resolve(ItemStack book, @Nullable ServerCommandSource commandSource, @Nullable PlayerEntity player) {
      CompoundTag compoundTag = book.getTag();

            ListTag listTag = compoundTag.getList("pages", 8);

        //    for(int i = 0; i < listTag.size(); ++i) {
              // String string = listTag.getString(i);
               String string = "ok";
      
               Object text2;
               try {
                  Text text = Text.Serializer.fromLenientJson(string);
                  text2 = Texts.parse(commandSource, text, player, 0);
               } catch (Exception var9) {
                  text2 = new LiteralText("string");
               }

              listTag.set(1, (Tag)StringTag.of(Text.Serializer.toJson((Text)text2)));
       //     }

       
            compoundTag.put("pages", listTag);
            return true;
         }
      
      
   

   public boolean hasEnchantmentGlint(ItemStack stack) {
      return false;
   }
}
*/