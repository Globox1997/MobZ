package net.mobz.Inits;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.ConfigHolder;
import me.sargunvohra.mcmods.autoconfig1u.serializer.DummyConfigSerializer;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import me.sargunvohra.mcmods.autoconfig1u.serializer.PartitioningSerializer;
import net.mobz.Config.configz;

@SuppressWarnings("unused")
public class Configinit {
    public static configz CONFIGZ = AutoConfig.register(configz.class, JanksonConfigSerializer::new).getConfig();

    public static void init() {

        AutoConfig.getConfigHolder(configz.class).getConfig();

    }
}