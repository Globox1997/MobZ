package net.mobz.Inits;

import java.util.function.Predicate;

import com.google.common.base.Preconditions;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.mobz.Config.configz;

//To use experimental APIs
@SuppressWarnings("deprecation")
public class SpawnInit {
	public static void addSpawn(Predicate<BiomeSelectionContext> biomeSelector, SpawnGroup spawnGroup,
			SpawnSettings.SpawnEntry se) {
		// See constructor of SpawnSettings.SpawnEntry for context
		Preconditions.checkArgument(se.type.getSpawnGroup() != SpawnGroup.MISC,
				"Cannot add spawns for entities with spawnGroup=MISC since they'd be replaced by pigs.");

		// We need the entity type to be registered or we cannot deduce an ID otherwisea
		Identifier id = Registry.ENTITY_TYPE.getId(se.type);
		Preconditions.checkState(id != Registry.ENTITY_TYPE.getDefaultId(), "Unregistered entity type: %s", se.type);

		BiomeModifications.create(id).add(ModificationPhase.ADDITIONS, biomeSelector, context -> {
			context.getSpawnSettings().addSpawn(spawnGroup, se);
		});
	}

	private static void normalspawn() {
		Predicate<BiomeSelectionContext> biomeSelector = (context) -> {
			Biome.Category category = context.getBiome().getCategory();
			return category != Biome.Category.NETHER && category != Biome.Category.THEEND
					&& category != Biome.Category.ICY && category != Biome.Category.OCEAN
					&& category != Biome.Category.MUSHROOM && category != Biome.Category.EXTREME_HILLS
					&& category != Biome.Category.MESA && category != Biome.Category.DESERT;
		};

		addSpawn(biomeSelector, Entityinit.ARCHERENTITY.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.ARCHERENTITY, Configinit.CONFIGZ.BowmanSpawnRate, 1, 2));
		addSpawn(biomeSelector, Entityinit.ARMORED.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.ARMORED, Configinit.CONFIGZ.ArmoredZombieSpawnRate, 1, 2));
		addSpawn(biomeSelector, Entityinit.DWARFENTITY.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.DWARFENTITY, Configinit.CONFIGZ.DwarfSpawnRate, 1, 1));
		addSpawn(biomeSelector, Entityinit.FAST.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.FAST, Configinit.CONFIGZ.SpeedyZombieSpawnRate, 2, 3));
		addSpawn(biomeSelector, Entityinit.FULLIRONENTITY.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.FULLIRONENTITY, Configinit.CONFIGZ.SteveSpawnRate, 1, 1));
		addSpawn(biomeSelector, Entityinit.KNIGHT2ENTITY.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.KNIGHT2ENTITY, Configinit.CONFIGZ.WarriorSpawnRate, 1, 2));
		addSpawn(biomeSelector, Entityinit.KNIGHTENTITY.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.KNIGHTENTITY, Configinit.CONFIGZ.TemplarSpawnRate, 1, 1));
		addSpawn(biomeSelector, Entityinit.MAGE2ENTITY.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.MAGE2ENTITY, Configinit.CONFIGZ.ZombieMageSpawnRate, 1, 1));
		addSpawn(biomeSelector, Entityinit.SKELI2.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.SKELI2, Configinit.CONFIGZ.OvergrownSkeletonSpawnRate, 2, 4));
		addSpawn(biomeSelector, Entityinit.SKELI4.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.SKELI4, Configinit.CONFIGZ.LostSkeletonSpawnRate, 2, 2));
		addSpawn(biomeSelector, Entityinit.SLIMO.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.SLIMO, Configinit.CONFIGZ.GrassSlimeSpawnRate, 1, 1));
		addSpawn(biomeSelector, Entityinit.SPI.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.SPI, Configinit.CONFIGZ.BlueSpiderSpawnRate, 2, 3));
		addSpawn(biomeSelector, Entityinit.SPO.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.SPO, Configinit.CONFIGZ.PurpleSpiderSpawnRate, 1, 4));
		addSpawn(biomeSelector, Entityinit.TSPIDER.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.TSPIDER, Configinit.CONFIGZ.TinySpiderSpawnRate, 1, 1));
		addSpawn(biomeSelector, Entityinit.TANK.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.TANK, Configinit.CONFIGZ.TankSpawnRate, 1, 2));

		if (AutoConfig.getConfigHolder(configz.class).getConfig().WildBoarSpawn) {
			addSpawn(biomeSelector, Entityinit.BOAR.getSpawnGroup(),
					new SpawnSettings.SpawnEntry(Entityinit.BOAR, Configinit.CONFIGZ.WildBoarSpawnRate, 2, 4));
		}
		if (AutoConfig.getConfigHolder(configz.class).getConfig().DirtyBoarSpawn) {
			addSpawn(biomeSelector, Entityinit.BOAR3.getSpawnGroup(),
					new SpawnSettings.SpawnEntry(Entityinit.BOAR3, Configinit.CONFIGZ.DirtyBoarSpawnRate, 1, 3));
		}
		if (AutoConfig.getConfigHolder(configz.class).getConfig().BrownBearSpawn) {
			addSpawn(biomeSelector, Entityinit.BROWNBEAR.getSpawnGroup(),
					new SpawnSettings.SpawnEntry(Entityinit.BROWNBEAR, Configinit.CONFIGZ.BrownBearSpawnRate, 2, 3));
		}
		if (AutoConfig.getConfigHolder(configz.class).getConfig().AlexSpawn) {
			addSpawn(biomeSelector, Entityinit.FRIEND.getSpawnGroup(),
					new SpawnSettings.SpawnEntry(Entityinit.FRIEND, Configinit.CONFIGZ.AlexSpawnRate, 1, 1));
		}
		if (AutoConfig.getConfigHolder(configz.class).getConfig().GoldenChickenSpawn) {
			addSpawn(biomeSelector, Entityinit.GCHICKEN.getSpawnGroup(),
					new SpawnSettings.SpawnEntry(Entityinit.GCHICKEN, Configinit.CONFIGZ.GoldenChickenSpawnRate, 1, 2));
		}
		if (AutoConfig.getConfigHolder(configz.class).getConfig().FioraSpawn) {
			addSpawn(biomeSelector, Entityinit.KNIGHT4ENTITY.getSpawnGroup(),
					new SpawnSettings.SpawnEntry(Entityinit.KNIGHT4ENTITY, Configinit.CONFIGZ.FioraSpawnRate, 1, 1));
		}
	}

	private static void icespawn() {
		Predicate<BiomeSelectionContext> biomeSelector = (
				context) -> context.getBiome().getCategory() == Biome.Category.ICY;

		addSpawn(biomeSelector, Entityinit.CREEP.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.CREEP, Configinit.CONFIGZ.FrostCreeperSpawnRate, 1, 3));
		addSpawn(biomeSelector, Entityinit.FROSTENTITY.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.FROSTENTITY, Configinit.CONFIGZ.FrostBlazeSpawnRate, 1, 3));
		addSpawn(biomeSelector, Entityinit.ICEGOLEM.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.ICEGOLEM, Configinit.CONFIGZ.IceGolemSpawnRate, 1, 1));
		if (AutoConfig.getConfigHolder(configz.class).getConfig().BoarSpawn) {
			addSpawn(biomeSelector, Entityinit.BOAR2.getSpawnGroup(),
					new SpawnSettings.SpawnEntry(Entityinit.BOAR2, Configinit.CONFIGZ.BoarSpawnRate, 2, 3));
		}

		if (AutoConfig.getConfigHolder(configz.class).getConfig().BlackBearSpawn) {
			addSpawn(biomeSelector, Entityinit.BLACKBEAR.getSpawnGroup(),
					new SpawnSettings.SpawnEntry(Entityinit.BLACKBEAR, Configinit.CONFIGZ.BlackBearSpawnRate, 1, 2));
		}
	}

	private static void netherspawn() {
		Predicate<BiomeSelectionContext> biomeSelector = (
				context) -> context.getBiome().getCategory() == Biome.Category.NETHER;

		addSpawn(biomeSelector, Entityinit.DOG.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.DOG, Configinit.CONFIGZ.NetherWolfSpawnRate, 1, 3));
		addSpawn(biomeSelector, Entityinit.LAVAGOLEM.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.LAVAGOLEM, Configinit.CONFIGZ.LavaGolemSpawnRate, 1, 1));
		addSpawn(biomeSelector, Entityinit.PIG.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.PIG, Configinit.CONFIGZ.PigmanSpawnRate, 2, 3));
		addSpawn(biomeSelector, Entityinit.SKELI3.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.SKELI3, Configinit.CONFIGZ.NetherSkeletonSpawnRate, 1, 2));
		addSpawn(biomeSelector, Entityinit.WITHENTITY.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.WITHENTITY, Configinit.CONFIGZ.WitherBlazeSpawnRate, 1, 3));
		addSpawn(biomeSelector, Entityinit.SCREEPER.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.SCREEPER, Configinit.CONFIGZ.SoulCreeperSpawnRate, 1, 2));
	}

	private static void endspawn() {
		Predicate<BiomeSelectionContext> biomeSelector = (
				context) -> context.getBiome().getCategory() == Biome.Category.THEEND;

		addSpawn(biomeSelector, Entityinit.ENDER.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.ENDER, Configinit.CONFIGZ.EndermanSpawnRate, 1, 3));
		addSpawn(biomeSelector, Entityinit.ENDERZOMBIE.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.ENDERZOMBIE, Configinit.CONFIGZ.EnderzombieSpawnRate, 1, 3));
		addSpawn(biomeSelector, Entityinit.KNIGHT3ENTITY.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.KNIGHT3ENTITY, Configinit.CONFIGZ.EnderKnightSpawnRate, 1, 1));
	}

	private static void bossspawn() {
		Predicate<BiomeSelectionContext> biomeSelector = (
				context) -> {
			return context.getBiome().getCategory() == Biome.Category.MESA;
		};

		addSpawn(biomeSelector, Entityinit.BIGBOSSENTITY.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.BIGBOSSENTITY, Configinit.CONFIGZ.BigBossSpawnRate, 1, 1));
		addSpawn(biomeSelector, Entityinit.ARCHER2ENTITY.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.ARCHER2ENTITY, Configinit.CONFIGZ.ArcherSpawnRate, 1, 2));
		addSpawn(biomeSelector, Entityinit.BOSS.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.BOSS, Configinit.CONFIGZ.BossZombieSpawnRate, 1, 1));
		addSpawn(biomeSelector, Entityinit.ILLUSIONER.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.ILLUSIONER, Configinit.CONFIGZ.IllusionerSpawnRate, 1, 1));
		addSpawn(biomeSelector, Entityinit.KNIGHT5ENTITY.getSpawnGroup(), new SpawnSettings.SpawnEntry(
				Entityinit.KNIGHT5ENTITY, Configinit.CONFIGZ.LordofDarknessSpawnRate, 1, 1));
		addSpawn(biomeSelector, Entityinit.MAGEENTITY.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.MAGEENTITY, Configinit.CONFIGZ.SpiderMageSpawnRate, 1, 1));
		addSpawn(biomeSelector, Entityinit.SKELI1.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.SKELI1, Configinit.CONFIGZ.BossSkeletonSpawnRate, 1, 1));
	}

	private static void rockyspawn() {
		Predicate<BiomeSelectionContext> biomeSelector = (
				context) -> context.getBiome().getCategory() == Biome.Category.EXTREME_HILLS;

		addSpawn(biomeSelector, Entityinit.STONEGOLEM.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.STONEGOLEM, Configinit.CONFIGZ.StoneGolemSpawnRate, 1, 1));

	}

	private static void junglespawn() {
		Predicate<BiomeSelectionContext> biomeSelector = (
				context) -> context.getBiome().getCategory() == Biome.Category.JUNGLE;

		addSpawn(biomeSelector, Entityinit.CRIP.getSpawnGroup(),
				new SpawnSettings.SpawnEntry(Entityinit.CRIP, Configinit.CONFIGZ.CookieCreeperSpawnRate, 1, 2));

	}

	public static void init() {
		normalspawn();
		icespawn();
		netherspawn();
		endspawn();
		bossspawn();
		rockyspawn();
		junglespawn();

		// TODO: Check, maybe we no longer need this!
		// Listen for other biomes being registered
		// RegistryEntryAddedCallback.event(BuiltinRegistries.BIOME).register((i, identifier, biome) -> SpawnInit.normalspawn());
	}
}
