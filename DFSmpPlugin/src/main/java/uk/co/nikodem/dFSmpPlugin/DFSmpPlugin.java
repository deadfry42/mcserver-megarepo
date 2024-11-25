package uk.co.nikodem.dFSmpPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.*;

import uk.co.nikodem.dFSmpPlugin.Content.Commands.*;
import uk.co.nikodem.dFSmpPlugin.Content.Events.*;
import uk.co.nikodem.dFSmpPlugin.Content.Recipes.CustomItemRecipes;
import uk.co.nikodem.dFSmpPlugin.Content.Recipes.VanillaRecipes;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.*;

import org.bukkit.scheduler.BukkitScheduler;

import java.util.Objects;

public final class DFSmpPlugin extends JavaPlugin {

    public final BungeeUtils bu = new BungeeUtils(this);

    public final VanillaRecipes vr = new VanillaRecipes(this);
    public final CustomItemRecipes cir = new CustomItemRecipes(this);

    @Override
    public void onEnable() {
        // Plugin startup logic

        initConfig();

        initHandlers();

        initRecipes();

        initCustomItems();

        initCommands();

        initCombatLoggingEvents();

        initBungeeChannel();

        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.runTaskTimer(this, () -> {
            // runs every second
            for(Player plr : Bukkit.getOnlinePlayers()){
                if (!CombatLoggingManager.playerInCombat(plr) && CombatLoggingManager.getPlayerCombatTimestamp(plr) > 0 && !BasicModeManager.basicMode) {
                    plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2You are no longer in combat!"));
                    CombatLoggingManager.playerRemoveCombatLog(plr);
                }
                SetBonuses.ApplySetBonuses(plr);
            }
        }, 0, 20);
    }

    public void initConfig() {
        getConfig().addDefault("basicMode", false);
        getConfig().addDefault("combatlogtime", 30);
        saveConfig();
    }

    public void initHandlers() {
        AntiSpamManager.init(this);
        CombatLoggingManager.init(this);
        BasicModeManager.initBasicMode(this);
    }

    public void initRecipes() {
        getServer().getPluginManager().registerEvents(new OnJoin(this), this);
    }

    public void initCustomItems() {
        getServer().getPluginManager().registerEvents(new ItemUse(), this);
        getServer().getPluginManager().registerEvents(new BreakBlock(), this);
        getServer().getPluginManager().registerEvents(new DragonEggPrevention(), this);
        getServer().getPluginManager().registerEvents(new PlaceBlock(), this);
        getServer().getPluginManager().registerEvents(new HungerChange(), this);
        getServer().getPluginManager().registerEvents(new OnWear(this), this);
        // getServer().getPluginManager().registerEvents(new SmithingTable(this), this);
    }

    public void initCommands() {
        Objects.requireNonNull(getCommand("lobby")).setExecutor(new LobbyCommand(this, bu));
        Objects.requireNonNull(getCommand("bin")).setExecutor(new BinCommand());
    }

    public void initCombatLoggingEvents() {
        getServer().getPluginManager().registerEvents(new OnHit(this), this);
        getServer().getPluginManager().registerEvents(new OnDeath(this), this);
        getServer().getPluginManager().registerEvents(new OnLeave(this), this);

        getServer().getPluginManager().registerEvents(new ExecuteCommand(), this);
    }

    public void initBungeeChannel() {
        bu.initiateBungeeCordChannel();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        saveConfig();
    }
}
