package net.mobz.Mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.world.Heightmap;
import net.mobz.Inits.Entityinit;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SpawnRestriction.class)
public class SpawnRestrictionMixin {

        @Shadow
        private static <T extends MobEntity> void register(EntityType<T> type, SpawnRestriction.Location location,
                        Heightmap.Type heightmapType, SpawnRestriction.SpawnPredicate<T> predicate) {
        }

        static {
                register(Entityinit.TANK, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                                HostileEntity::canSpawnInDark);
                register(Entityinit.FAST, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                                HostileEntity::canSpawnInDark);
                register(Entityinit.ARMORED, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.BOSS, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                                HostileEntity::canSpawnInDark);
                register(Entityinit.CREEP, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.CRIP, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                                HostileEntity::canSpawnInDark);
                register(Entityinit.ENDER, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.ENDERZOMBIE, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.SPI, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                                HostileEntity::canSpawnInDark);
                register(Entityinit.SPO, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                                HostileEntity::canSpawnInDark);
                register(Entityinit.PIG, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                                HostileEntity::canSpawnInDark);
                register(Entityinit.LAVAGOLEM, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PassiveEntity::canMobSpawn);
                register(Entityinit.ICEGOLEM, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PassiveEntity::canMobSpawn);
                register(Entityinit.SKELI1, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.SKELI2, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.SKELI3, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.SKELI4, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.ARCHERENTITY, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnIgnoreLightLevel);
                register(Entityinit.ARCHER2ENTITY, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnIgnoreLightLevel);
                register(Entityinit.BIGBOSSENTITY, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.KNIGHTENTITY, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.KNIGHT2ENTITY, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.KNIGHT3ENTITY, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.KNIGHT4ENTITY, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PassiveEntity::canMobSpawn);
                register(Entityinit.KNIGHT5ENTITY, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.MAGE2ENTITY, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.MAGEENTITY, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.FULLIRONENTITY, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.SMALLZOMBIE, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.FROSTENTITY, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.DOG, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                                PassiveEntity::canMobSpawn);
                register(Entityinit.STONEGOLEM, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PassiveEntity::canMobSpawn);
                register(Entityinit.ILLUSIONER, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.DWARFENTITY, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.SPISMALL, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.BLACKBEAR, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
                register(Entityinit.BROWNBEAR, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
                register(Entityinit.GCHICKEN, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
                register(Entityinit.BOAR, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                                AnimalEntity::isValidNaturalSpawn);
                register(Entityinit.BOAR2, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
                register(Entityinit.BOAR3, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
                register(Entityinit.FRIEND, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PassiveEntity::canMobSpawn);
                register(Entityinit.WITHENTITY, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.WITHENDER, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.SLIMO, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PassiveEntity::canMobSpawn);
                register(Entityinit.TSPIDER, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.PILLAGERBOSS, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.BABYRAVAGERENTITY, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.ISLANDKING, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.ISLANDKNIGHTNORMAL, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.ISLANDKNIGHTSPECIAL, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.ISLANDKNIGHTSPECIAL2, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.ISLANDVEXENTITY, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
                register(Entityinit.METALGOLEM, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PassiveEntity::canMobSpawn);
                register(Entityinit.SCREEPER, SpawnRestriction.Location.ON_GROUND,
                                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);

        }
}