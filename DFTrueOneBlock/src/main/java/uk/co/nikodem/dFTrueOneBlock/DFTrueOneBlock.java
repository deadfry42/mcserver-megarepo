package uk.co.nikodem.dFTrueOneBlock;

import com.infernalsuite.aswm.api.AdvancedSlimePaperAPI;
import com.infernalsuite.aswm.api.loaders.SlimeLoader;
import com.infernalsuite.aswm.loaders.file.FileLoader;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.nikodem.dFTrueOneBlock.Commands.*;
import uk.co.nikodem.dFTrueOneBlock.Data.SaveData;
import uk.co.nikodem.dFTrueOneBlock.Data.SkyblockData;
import uk.co.nikodem.dFTrueOneBlock.Events.OnChat;
import uk.co.nikodem.dFTrueOneBlock.Events.OnJoin;
import uk.co.nikodem.dFTrueOneBlock.Gameplay.ProgressionRecipes;
import uk.co.nikodem.dFTrueOneBlock.Menus.GuiHandler;
import uk.co.nikodem.dFTrueOneBlock.WorldManagement.WorldData;

import java.io.File;
import java.util.Objects;

public final class DFTrueOneBlock extends JavaPlugin {
    public AdvancedSlimePaperAPI asp = AdvancedSlimePaperAPI.instance();
    public SlimeLoader aspl;
    public final SaveData saveData = new SaveData(this);
    public final SkyblockData skyblockData = new SkyblockData(this);
    public final ProgressionRecipes progressionRecipes = new ProgressionRecipes(this);
    public final GuiHandler mm = new GuiHandler(this);
    public final WorldData wd = new WorldData(this);

    @Override
    public void onEnable() {
        // Plugin startup logic

        aspl = new FileLoader(new File("slime_worlds"));

        LoadSkyblockData();
        RegisterEvents();
        RegisterCommands();
    }

    public void RegisterEvents() {
        getServer().getPluginManager().registerEvents(new OnJoin(this), this);
        getServer().getPluginManager().registerEvents(new OnChat(this), this);
        getServer().getPluginManager().registerEvents(mm, this);
    }

    public void RegisterCommands() {
        Objects.requireNonNull(getCommand("menu")).setExecutor(new Menu(this));
        Objects.requireNonNull(getCommand("create")).setExecutor(new Create(this));
        Objects.requireNonNull(getCommand("worlds")).setExecutor(new Worlds(this));
    }

    public void LoadSkyblockData() {
        skyblockData.initialiseSkyblockPlayers();
        skyblockData.initialiseSkyblockWorlds();
        skyblockData.initialiseSkyblockSessions();
    }

    public void DiscoverRecipes(Player plr) {
        progressionRecipes.discoverRecipes(plr);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
