
package net.mobz.Config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;
import me.sargunvohra.mcmods.autoconfig1u.serializer.PartitioningSerializer;

@SuppressWarnings("unused")
@Config(name = "mobz")
@Config.Gui.Background("minecraft:textures/block/oak_planks.png")
public class configz implements ConfigData {

    @ConfigEntry.Category("spawnsetting")
    @ConfigEntry.Gui.PrefixText

    public boolean AlexSpawn = true;
    public boolean ArcherSpawn = true;
    public boolean ArmoredZombieSpawn = true;
    public boolean BigBossSpawn = true;
    public boolean BlackBearSpawn = true;
    public boolean BlueSpiderSpawn = true;
    public boolean BoarSpawn = true;
    public boolean BossSkeletonSpawn = true;
    public boolean BossZombieSpawn = true;
    public boolean BowmanSpawn = true;
    public boolean BrownBearSpawn = true;
    public boolean CookieCreeperSpawn = true;
    public boolean DirtyBoarSpawn = true;
    public boolean DwarfSpawn = true;
    public boolean EnderKnightSpawn = true;
    public boolean EndermanSpawn = true;
    public boolean EnderzombieSpawn = true;
    public boolean FioraSpawn = true;
    public boolean FrostBlazeSpawn = true;
    public boolean FrostCreeperSpawn = true;
    public boolean GoldenChickenSpawn = true;
    public boolean GrassSlimeSpawn = true;
    public boolean IceGolemSpawn = true;
    public boolean IllusionerSpawn = true;
    public boolean LavaGolemSpawn = true;
    public boolean LordofDarknessSpawn = true;
    public boolean LostSkeletonSpawn = true;
    public boolean NetherSkeletonSpawn = true;
    public boolean NetherWolfSpawn = true;
    public boolean OvergrownSkeletonSpawn = true;
    public boolean PigmanSpawn = true;
    public boolean PillagerBossSpawn = true;
    public boolean PurpleSpiderSpawn = true;
    public boolean SpeedyZombieSpawn = true;
    public boolean SpiderMageSpawn = true;
    public boolean SteveSpawn = true;
    public boolean StoneGolemSpawn = true;
    public boolean TankSpawn = true;
    public boolean TemplarSpawn = true;
    public boolean TinySpiderSpawn = true;
    public boolean WarriorSpawn = true;
    public boolean WildBoarSpawn = true;
    public boolean WithenderSpawn = true;
    public boolean WitherBlazeSpawn = true;
    public boolean ZombieMageSpawn = true;

    @ConfigEntry.Category("lifesetting")
    @ConfigEntry.Gui.PrefixText

    public double AlexLife = 30D;
    public double ArcherLife = 32D;
    public double ArmoredZombieLife = 20D;
    public double BigBossLife = 400D;
    public double BlueSpiderLife = 24D;
    public double BossSkeletonLife = 60D;
    public double BossZombieLife = 400D;
    public double BowmanLife = 32D;
    public double CookieCreeperLife = 24D;
    public double DwarfLife = 70D;
    public double EnderKnightLife = 48D;
    public double EndermanLife = 46D;
    public double EnderzombieLife = 20D;
    public double FioraLife = 30D;
    public double FrostBlazeLife = 26D;
    public double FrostCreeperLife = 18D;
    public double IceGolemLife = 52D;
    public double IllusionerLife = 16D;
    public double LavaGolemLife = 48D;
    public double LordofDarknessLife = 72D;
    public double LostSkeletonLife = 20D;
    public double NetherSkeletonLife = 28D;
    public double NetherWolfLife = 20D;
    public double OvergrownSkeletonLife = 26D;
    public double PigmanLife = 24D;
    public double PillagerBossLife = 300D;
    public double PurpleSpiderLife = 26D;
    public double SpeedyZombieLife = 15D;
    public double SpiderMageLife = 32D;
    public double SteveLife = 32D;
    public double StoneGolemLife = 64D;
    public double TankLife = 56D;
    public double TemplarLife = 34D;
    public double TinySpiderLife = 1D;
    public double WarriorLife = 48D;
    public double WithenderLife = 400D;
    public double WitherBlazeLife = 26D;
    public double ZombieMageLife = 28D;

    @Comment("Be carefull with this setting! Multiplicator must be > 0!")
    public double LifeMultiplicatorMob = 1.0D;

    @ConfigEntry.Category("damagesetting")
    @ConfigEntry.Gui.PrefixText

    public double AlexAttack = 5D;
    public double ArcherAttack = 6D;
    public double ArmoredZombieAttack = 7D;
    public double BigBossAttack = 9D;
    public double BlueSpiderAttack = 6D;
    public double BossZombieAttack = 10D;
    public double BowmanAttack = 8D;
    public double DwarfAttack = 7D;
    public double EnderKnightAttack = 8D;
    public double EndermanAttack = 9D;
    public double EnderzombieAttack = 5D;
    public double FioraAttack = 5D;
    public double FrostBlazeAttack = 7D;
    public double IceGolemAttack = 14D;
    public double IllusionerAttack = 7D;
    public double LavaGolemAttack = 14D;
    public double LordofDarknessAttack = 7D;
    public double LostSkeletonAttack = 5D;
    public double NetherWolfAttack = 6D;
    public double PigmanAttack = 7D;
    public double PillagerBossAttack = 12D;
    public double PurpleSpiderAttack = 5D;
    public double SpeedyZombieAttack = 4D;
    public double SpiderMageAttack = 7D;
    public double SteveAttack = 10D;
    public double StoneGolemAttack = 14D;
    public double TankAttack = 9D;
    public double TemplarAttack = 7D;
    public double TinySpiderAttack = 0D;
    public double WarriorAttack = 6D;
    public double WitherBlazeAttack = 8D;
    public double ZombieMageAttack = 7D;

    @Comment("Be carefull with this setting! Multiplicator must be > 0!")
    public double DamageMultiplicatorMob = 1.0D;

    @ConfigEntry.Category("spawnratesetting")
    @ConfigEntry.Gui.PrefixText

    public int AlexSpawnRate = 5;
    public int ArcherSpawnRate = 5;
    public int ArmoredZombieSpawnRate = 15;
    public int BigBossSpawnRate = 1;
    @Comment("Caution! Friendly Mobs Spawnrate should stay at 1!")
    public int BlackBearSpawnRate = 1;
    public int BlueSpiderSpawnRate = 20;
    @Comment("Caution! Friendly Mobs Spawnrate should stay at 1!")
    public int BoarSpawnRate = 1;
    public int BossSkeletonSpawnRate = 3;
    public int BossZombieSpawnRate = 1;
    public int BowmanSpawnRate = 5;
    @Comment("Caution! Friendly Mobs Spawnrate should stay at 1!")
    public int BrownBearSpawnRate = 1;
    public int CookieCreeperSpawnRate = 10;
    @Comment("Caution! Friendly Mobs Spawnrate should stay at 1!")
    public int DirtyBoarSpawnRate = 1;
    public int DwarfSpawnRate = 5;
    public int EnderKnightSpawnRate = 3;
    public int EndermanSpawnRate = 8;
    public int EnderzombieSpawnRate = 8;
    public int FioraSpawnRate = 5;
    public int FrostBlazeSpawnRate = 10;
    public int FrostCreeperSpawnRate = 10;
    @Comment("Caution! Friendly Mobs Spawnrate should stay at 1!")
    public int GoldenChickenSpawnRate = 1;
    @Comment("Caution! Friendly Mobs Spawnrate should stay at 1!")
    public int GrassSlimeSpawnRate = 1;
    public int IceGolemSpawnRate = 10;
    public int IllusionerSpawnRate = 5;
    public int LavaGolemSpawnRate = 10;
    public int LordofDarknessSpawnRate = 3;
    public int LostSkeletonSpawnRate = 10;
    public int NetherSkeletonSpawnRate = 6;
    public int NetherWolfSpawnRate = 5;
    public int OvergrownSkeletonSpawnRate = 15;
    public int PigmanSpawnRate = 10;
    public int PillagerBossSpawnRate = 1;
    public int PurpleSpiderSpawnRate = 15;
    public int SpeedyZombieSpawnRate = 30;
    public int SpiderMageSpawnRate = 6;
    public int SteveSpawnRate = 4;
    public int StoneGolemSpawnRate = 10;
    public int TankSpawnRate = 30;
    public int TemplarSpawnRate = 5;
    @Comment("Caution! Friendly Mobs Spawnrate should stay at 1!")
    public int TinySpiderSpawnRate = 1;
    public int WarriorSpawnRate = 7;
    @Comment("Caution! Friendly Mobs Spawnrate should stay at 1!")
    public int WildBoarSpawnRate = 1;
    public int WitherBlazeSpawnRate = 6;
    public int ZombieMageSpawnRate = 5;

}
