package net.mobz;

import net.fabricmc.api.ModInitializer;
import net.mobz.Inits.*;

public class glomod implements ModInitializer {

        public static String MODID = "mobz";

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