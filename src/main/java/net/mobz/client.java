package net.mobz;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.entity.EntityType;
import net.mobz.Inits.ModelProviderinit;
import net.mobz.Inits.Renderinit;

public class client implements ClientModInitializer {

        public static EntityType<?> entityType;

        @Override
        public void onInitializeClient() {
                ModelProviderinit.init();
                Renderinit.init();
        }

}