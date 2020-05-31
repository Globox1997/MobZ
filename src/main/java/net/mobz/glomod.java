package net.mobz;

import net.fabricmc.api.ModInitializer;
import net.mobz.Inits.*;

public class glomod implements ModInitializer {

        @Override
        public void onInitialize() {
                Entityinit.init();
                ArmorItems.init();
                Blockinit.init();
                Configinit.init();
                Itemgroupinit.init();
                Iteminit.init();
                Lootinit.init();
                Soundinit.init();
                SwordItems.init();
                SpawnInit.init();
                Worldinit.init();
        }
}

// You are LOVED!!!
// Jesus loves you unconditionally!