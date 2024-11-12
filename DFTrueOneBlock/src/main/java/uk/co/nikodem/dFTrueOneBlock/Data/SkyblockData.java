package uk.co.nikodem.dFTrueOneBlock.Data;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import uk.co.nikodem.dFTrueOneBlock.DFTrueOneBlock;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SkyblockData {
    public List<SkyblockPlayer> skyblockPlayers;
    public List<SkyblockWorld> skyblockWorlds;
    public List<SkyblockSession> skyblockSessions;

    public final DFTrueOneBlock plugin;

    public SkyblockData(DFTrueOneBlock plugin) {
        this.plugin = plugin;
    }

    public void initialiseSkyblockPlayers() {
        skyblockPlayers = new ArrayList<>();
        List<SkyblockPlayer> data = plugin.saveData.getSkyblockPlayers();
        if (data != null) this.skyblockPlayers = data;
    }

    public void initialiseSkyblockWorlds() {
        skyblockWorlds = new ArrayList<>();
        List<SkyblockWorld> data = plugin.saveData.getSkyblockWorlds();
        if (data != null) this.skyblockWorlds = data;
    }

    public void initialiseSkyblockSessions() {
        skyblockSessions = new ArrayList<>();
    }

    public void saveSkyblockPlayer(@NotNull SkyblockPlayer skyblockPlayer) {
        plugin.saveData.saveSkyblockPlayerToFile(skyblockPlayer);
        int foundPlayerIndex = findMatchingSkyblockPlayer(skyblockPlayer);
        if (foundPlayerIndex <= -1) {
            skyblockPlayers.add(skyblockPlayer);
        } else {
            skyblockPlayers.set(foundPlayerIndex, skyblockPlayer);
        }
    }

    public void saveSkyblockWorld(@NotNull SkyblockWorld skyblockWorld) {
        plugin.saveData.saveSkyblockWorldToFile(skyblockWorld);
        int foundPlayerIndex = findMatchingSkyblockWorld(skyblockWorld);
        if (foundPlayerIndex <= -1) {
            skyblockWorlds.add(skyblockWorld);
        } else {
            skyblockWorlds.set(foundPlayerIndex, skyblockWorld);
        }

        SkyblockPlayer skyblockPlayer = getSkyblockPlayerFromUUID(skyblockWorld.getOwner().getUniqueId(), true);
        if (skyblockWorld.getWorldId() == 1) skyblockPlayer.setWorld1(skyblockWorld);
        if (skyblockWorld.getWorldId() == 2) skyblockPlayer.setWorld2(skyblockWorld);
        if (skyblockWorld.getWorldId() == 3) skyblockPlayer.setWorld3(skyblockWorld);
        saveSkyblockPlayer(skyblockPlayer);
    }

    public int findMatchingSkyblockPlayer(@NotNull SkyblockPlayer skyblockPlayer) {
        String uuid = skyblockPlayer.getUniqueId();
        for (int i = 0; i < skyblockPlayers.size(); i++) {
            SkyblockPlayer sbplr = skyblockPlayers.get(i);
            if (Objects.equals(sbplr.getUniqueId(), uuid)) return i;
        }
        return -1;
    }

    public int findMatchingSkyblockWorld(@NotNull SkyblockWorld skyblockWorld) {
        String realid = skyblockWorld.getRealId();
        for (int i = 0; i < skyblockWorlds.size(); i++) {
            SkyblockWorld sbwrld = skyblockWorlds.get(i);
            if (Objects.equals(sbwrld.getRealId(), realid)) return i;
        }
        return -1;
    }

    @Nullable
    public SkyblockWorld getSkyblockWorldPlayerIsIn(Player plr) {
        World wrld = plr.getWorld();
        return getSkyblockWorldFromRealID(wrld.getName());
    }

    @Nullable
    public SkyblockPlayer getSkyblockPlayerFromUUID(String uuid) {
        SkyblockPlayer result = null;
        if (skyblockPlayers == null) return result;
        if (skyblockPlayers.isEmpty()) return result;
        for (SkyblockPlayer skyblockPlayer : skyblockPlayers) {
            if (Objects.equals(skyblockPlayer.getUniqueId(), uuid)) {
                result = skyblockPlayer;
                break;
            }
        }
        return result;
    }

    public SkyblockPlayer getSkyblockPlayerFromUUID(String uuid, boolean createIfNull) {
        SkyblockPlayer skyblockPlayer = getSkyblockPlayerFromUUID(uuid);
        if (skyblockPlayer == null && createIfNull) {
            return createSkyblockPlayer(uuid);
        }
        return skyblockPlayer;
    }

    public SkyblockPlayer createSkyblockPlayer(String uuid) {
        SkyblockPlayer newSkyblockPlayer = new SkyblockPlayer(uuid);
        skyblockPlayers.add(newSkyblockPlayer);
        return newSkyblockPlayer;
    }

    @Nullable
    public SkyblockWorld getSkyblockWorldFromRealID(String realid, boolean loadIfNotLoaded) {
        SkyblockWorld result = null;
        if (skyblockWorlds == null) return tryToLoadSkyblockWorld(realid);;
        if (skyblockWorlds.isEmpty()) return tryToLoadSkyblockWorld(realid);;
        for (SkyblockWorld skyblockWorld : skyblockWorlds) {
            if (Objects.equals(skyblockWorld.getRealId(), realid)) {
                result = skyblockWorld;
                break;
            }
        }
        if (loadIfNotLoaded && result == null) {
            // not loaded, attempt to load
            result = tryToLoadSkyblockWorld(realid);
            if (result != null) skyblockWorlds.add(result);
        }
        return result;
    }

    @Nullable
    public SkyblockWorld tryToLoadSkyblockWorld(String realid) {
        return plugin.saveData.loadSkyblockWorldFromFile("skyblockworlds."+realid);
    }

    @Nullable
    public SkyblockWorld getSkyblockWorldFromRealID(String realid) {
        return getSkyblockWorldFromRealID(realid, false);
    }

    public SkyblockWorld tryToCreateSkyblockWorld(SkyblockPlayer skyblockPlayer, byte worldNumber, String worldName, Gamemode gamemode, WorldIcon worldIcon) {
        SkyblockWorld newWorld = new SkyblockWorld(skyblockPlayer, worldNumber, gamemode);
        newWorld.setWorldIcon(worldIcon);
        newWorld.setName(worldName);

        SkyblockWorldMember ownerMember = new SkyblockWorldMember(skyblockPlayer.getUniqueId());
        ownerMember.setToOwner();

        newWorld.registerMember(ownerMember);

        saveSkyblockWorld(newWorld);

        return newWorld;
    }

    public void moveSkyblockWorld(SkyblockPlayer skyblockPlayer, byte worldId, byte newWorldId) {
        SkyblockWorld skyblockWorld = getSkyblockWorldFromRealID(skyblockPlayer.getUniqueId()+"--"+worldId);
        SkyblockWorld nullWorld = getSkyblockWorldFromRealID(skyblockPlayer.getUniqueId()+"--"+newWorldId);

        if (nullWorld != null) {
            swapSkyblockWorlds(skyblockPlayer, worldId, newWorldId);
            return;
        }

        if (skyblockWorld == null) {
            return;
        }

        if (worldId == 1) {
            skyblockPlayer.removeWorld1();
        } else if (worldId == 2) {
            skyblockPlayer.removeWorld2();
        } else if (worldId == 3) {
            skyblockPlayer.removeWorld3();
        }

        if (newWorldId == 1) {
            skyblockPlayer.setWorld1(skyblockWorld);
        } else if (newWorldId == 2) {
            skyblockPlayer.setWorld2(skyblockWorld);
        } else if (newWorldId == 3) {
            skyblockPlayer.setWorld3(skyblockWorld);
        }

        skyblockWorld.setWorldId(worldId);
    }

    public void swapSkyblockWorlds(SkyblockPlayer skyblockPlayer, byte worldId, byte swappedWorldId) {
        SkyblockWorld worlda = getSkyblockWorldFromRealID(skyblockPlayer.getUniqueId()+"--"+worldId);
        SkyblockWorld worldb = getSkyblockWorldFromRealID(skyblockPlayer.getUniqueId()+"--"+swappedWorldId);

        if (worlda == null || worldb == null) {
            return;
        }

        if (worldId == 1) {
            skyblockPlayer.setWorld1(worldb);
        } else if (worldId == 2) {
            skyblockPlayer.setWorld2(worldb);
        } else if (worldId == 3) {
            skyblockPlayer.setWorld3(worldb);
        }

        if (swappedWorldId == 1) {
            skyblockPlayer.setWorld1(worlda);
        } else if (swappedWorldId == 2) {
            skyblockPlayer.setWorld2(worlda);
        } else if (swappedWorldId == 3) {
            skyblockPlayer.setWorld3(worlda);
        }

        worlda.setWorldId(swappedWorldId);
        worldb.setWorldId(worldId);
    }

    public void deleteSkyblockWorld(SkyblockWorld skyblockWorld) {
        SkyblockPlayer skyblockPlayer = getSkyblockPlayerFromUUID(skyblockWorld.getOwner().getUniqueId());
        if (skyblockPlayer == null) return;
        if (skyblockWorld.getWorldId() == 1) {
            skyblockPlayer.removeWorld1();
            plugin.saveData.removeWorldLink(skyblockPlayer, skyblockWorld);
        }
        if (skyblockWorld.getWorldId() == 2) {
            skyblockPlayer.removeWorld2();
            plugin.saveData.removeWorldLink(skyblockPlayer, skyblockWorld);
        }
        if (skyblockWorld.getWorldId() == 3) {
            skyblockPlayer.removeWorld3();
            plugin.saveData.removeWorldLink(skyblockPlayer, skyblockWorld);
        }
        skyblockWorlds.remove(skyblockWorld);
        plugin.saveData.deleteWorldData(skyblockWorld);
    }

    public void deleteSkyblockPlayer(SkyblockPlayer skyblockPlayer) {
        SkyblockWorld world1 = getSkyblockWorldFromRealID(skyblockPlayer.getWorld1());
        SkyblockWorld world2 = getSkyblockWorldFromRealID(skyblockPlayer.getWorld2());
        SkyblockWorld world3 = getSkyblockWorldFromRealID(skyblockPlayer.getWorld3());
        if (world1 != null) deleteSkyblockWorld(world1);
        if (world2 != null) deleteSkyblockWorld(world2);
        if (world3 != null) deleteSkyblockWorld(world3);
        skyblockPlayers.remove(skyblockPlayer);
        plugin.saveData.deletePlayerData(skyblockPlayer);
    }
}
