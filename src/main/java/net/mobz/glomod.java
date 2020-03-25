package net.mobz;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.mobz.Config.*;
import net.mobz.Inits.*;

public class glomod implements ModInitializer {

        public static String MODID = "mobz";
        private static final configz CONFIGZ = AutoConfig.register(configz.class, GsonConfigSerializer::new).getConfig();

        @Override
        public void onInitialize() {
                ArmorItems.init();
                Entityinit.init();
                Itemgroupinit.init();
                Iteminit.init();
                Lootinit.init();
                Soundinit.init();
                SwordItems.init();
        }
}

// You are LOVED!!!
// Jesus loves you unconditional!