
package net.mobz.Config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name = "mobz")
@Config.Gui.Background("minecraft:textures/block/spruce_planks.png")

public class configz implements ConfigData {

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
    public boolean OvergrownSkeleton = true;
    public boolean PigmanSpawn = true;
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
    @Comment("Be carefull with this option! Multiplicator must be >0")
    public double LifeMultiplicatorMob = 1.0;
    public double DamageMultiplicatorMob = 1.0;

} 