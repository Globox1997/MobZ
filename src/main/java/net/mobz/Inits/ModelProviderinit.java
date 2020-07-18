package net.mobz.Inits;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModelProviderinit {

  public static void init() {
    FabricModelPredicateProviderRegistry.register(Iteminit.SBOW, new Identifier("pull"), (stack, world, entity) -> {
      if (entity == null) {
        return 0.0F;
      } else {
        return entity.getActiveItem() != stack ? 0.0F
            : (float) (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0F;
      }
    });
    FabricModelPredicateProviderRegistry.register(Iteminit.SBOW, new Identifier("pulling"), (stack, world, entity) -> {
      return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;
    });
    FabricModelPredicateProviderRegistry.register(Iteminit.SACRIFICEKNIFE, new Identifier("blood1"),
        (stack, world, entity) -> {
          if (Iteminit.SACRIFICEKNIFE.bloodCounter < 1000 && Iteminit.SACRIFICEKNIFE.bloodCounter > 600
              && Iteminit.SACRIFICEKNIFE.dryingNumber == 1) {
            return 0.11F;
          }
          return 0F;
        });
    FabricModelPredicateProviderRegistry.register(Iteminit.SACRIFICEKNIFE, new Identifier("blood2"),
        (stack, world, entity) -> {
          if (Iteminit.SACRIFICEKNIFE.bloodCounter < 2000 && Iteminit.SACRIFICEKNIFE.bloodCounter >= 1400
              && Iteminit.SACRIFICEKNIFE.dryingNumber == 2) {
            return 0.22F;
          }
          return 0F;
        });
    FabricModelPredicateProviderRegistry.register(Iteminit.SACRIFICEKNIFE, new Identifier("blood3"),
        (stack, world, entity) -> {
          if (Iteminit.SACRIFICEKNIFE.bloodCounter < 3000 && Iteminit.SACRIFICEKNIFE.bloodCounter >= 2000
              && Iteminit.SACRIFICEKNIFE.dryingNumber == 3) {
            return 0.33F;
          }
          return 0F;
        });
    FabricModelPredicateProviderRegistry.register(Iteminit.SACRIFICEKNIFE, new Identifier("blood4"),
        (stack, world, entity) -> {
          if (Iteminit.SACRIFICEKNIFE.bloodCounter > 3000 && Iteminit.SACRIFICEKNIFE.dryingNumber == 4) {
            return 0.44F;
          }
          return 0F;
        });
    FabricModelPredicateProviderRegistry.register(Iteminit.SACRIFICEKNIFE, new Identifier("blood1dry1"),
        (stack, world, entity) -> {
          if (Iteminit.SACRIFICEKNIFE.bloodCounter <= 600 && Iteminit.SACRIFICEKNIFE.bloodCounter > 300
              && Iteminit.SACRIFICEKNIFE.dryingNumber == 1) {
            return 0.15F;
          }
          return 0F;
        });
    FabricModelPredicateProviderRegistry.register(Iteminit.SACRIFICEKNIFE, new Identifier("blood1dry2"),
        (stack, world, entity) -> {
          if (Iteminit.SACRIFICEKNIFE.bloodCounter <= 300 && Iteminit.SACRIFICEKNIFE.bloodCounter > 0
              && Iteminit.SACRIFICEKNIFE.dryingNumber == 1) {
            return 0.19F;
          }
          return 0F;
        });
    FabricModelPredicateProviderRegistry.register(Iteminit.SACRIFICEKNIFE, new Identifier("blood2dry1"),
        (stack, world, entity) -> {
          if (Iteminit.SACRIFICEKNIFE.bloodCounter <= 1400 && Iteminit.SACRIFICEKNIFE.bloodCounter > 600
              && Iteminit.SACRIFICEKNIFE.dryingNumber == 2) {
            return 0.25F;
          }
          return 0F;
        });
    FabricModelPredicateProviderRegistry.register(Iteminit.SACRIFICEKNIFE, new Identifier("blood2dry2"),
        (stack, world, entity) -> {
          if (Iteminit.SACRIFICEKNIFE.bloodCounter <= 600 && Iteminit.SACRIFICEKNIFE.bloodCounter > 0
              && Iteminit.SACRIFICEKNIFE.dryingNumber == 2) {
            return 0.29F;
          }
          return 0F;
        });
    FabricModelPredicateProviderRegistry.register(Iteminit.SACRIFICEKNIFE, new Identifier("blood3dry1"),
        (stack, world, entity) -> {
          if (Iteminit.SACRIFICEKNIFE.bloodCounter <= 2000 && Iteminit.SACRIFICEKNIFE.bloodCounter > 1000
              && Iteminit.SACRIFICEKNIFE.dryingNumber == 3) {
            return 0.35F;
          }
          return 0F;
        });
    FabricModelPredicateProviderRegistry.register(Iteminit.SACRIFICEKNIFE, new Identifier("blood3dry2"),
        (stack, world, entity) -> {
          if (Iteminit.SACRIFICEKNIFE.bloodCounter <= 1000 && Iteminit.SACRIFICEKNIFE.bloodCounter > 0
              && Iteminit.SACRIFICEKNIFE.dryingNumber == 3) {
            return 0.39F;
          }
          return 0F;
        });
    FabricModelPredicateProviderRegistry.register(Iteminit.SACRIFICEKNIFE, new Identifier("blood4dry1"),
        (stack, world, entity) -> {
          if (Iteminit.SACRIFICEKNIFE.bloodCounter <= 3000 && Iteminit.SACRIFICEKNIFE.bloodCounter > 1500
              && Iteminit.SACRIFICEKNIFE.dryingNumber == 4) {
            return 0.45F;
          }
          return 0F;
        });
    FabricModelPredicateProviderRegistry.register(Iteminit.SACRIFICEKNIFE, new Identifier("blood4dry2"),
        (stack, world, entity) -> {
          if (Iteminit.SACRIFICEKNIFE.bloodCounter <= 1500 && Iteminit.SACRIFICEKNIFE.bloodCounter > 0
              && Iteminit.SACRIFICEKNIFE.dryingNumber == 4) {
            return 0.49F;
          }
          return 0F;
        });
  }

}