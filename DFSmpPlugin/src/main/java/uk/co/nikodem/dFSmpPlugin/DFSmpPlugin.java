package uk.co.nikodem.dFSmpPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import uk.co.nikodem.dFSmpPlugin.Content.Accessories.AccessoryGUI;
import uk.co.nikodem.dFSmpPlugin.Content.Advancements.CustomAdvancements;
import uk.co.nikodem.dFSmpPlugin.Content.CustomItems.*;

import uk.co.nikodem.dFSmpPlugin.Content.Commands.*;
import uk.co.nikodem.dFSmpPlugin.Content.EventHandlers.*;
import uk.co.nikodem.dFSmpPlugin.Content.Events.*;
import uk.co.nikodem.dFSmpPlugin.Content.Recipes.AccessoryRecipes;
import uk.co.nikodem.dFSmpPlugin.Content.Recipes.CustomItemRecipes;
import uk.co.nikodem.dFSmpPlugin.Content.Recipes.VanillaRecipes;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.*;

import org.bukkit.scheduler.BukkitScheduler;

import java.util.Objects;

public final class DFSmpPlugin extends JavaPlugin {

    public final BungeeUtils bu = new BungeeUtils(this);

    public final VanillaRecipes vr = new VanillaRecipes(this);
    public final CustomItemRecipes cir = new CustomItemRecipes(this);
    public final AccessoryRecipes ar = new AccessoryRecipes(this);

    public CustomAdvancements ca;
    public ConfigManager cm;

    @Override
    public void onEnable() {
        // Plugin startup logic

        this.cm = new ConfigManager(this);

        initHandlers();

        initRecipes();

        initCustomItems();

        initCommands();

        initEventHandlers();

        initCombatLoggingEvents();

        initBungeeChannel();

        this.ca = new CustomAdvancements(this);

        BreakBlock.plugin = this;
        SetBonuses.plugin = this;
        AccessoryGUI.plugin = this;

        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.runTaskTimer(this, () -> {
            // runs every second
            for(Player plr : Bukkit.getOnlinePlayers()){
                if (!CombatLoggingManager.playerInCombat(plr) && CombatLoggingManager.getPlayerCombatTimestamp(plr) > 0 && !BasicModeManager.isBasicMode()) {
                    plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2You are no longer in combat!"));
                    CombatLoggingManager.playerRemoveCombatLog(plr);
                    if (plr.getHealth() <= 2) {
                        // one heart or less
                        if (!this.ca.BarelySurvived.isGranted(plr)) this.ca.BarelySurvived.grant(plr);
                    }
                }
                if (Bukkit.getOnlinePlayers().size() > 4) {
                    int random = (int)(Math.random() * 4096 + 1);
                    if (random == 69) {
                        if (!this.ca.FeelingWatched.isGranted(plr)) {
                            this.ca.FeelingWatched.grant(plr);
                            plr.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 20 * 10, 3));
                            plr.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 20 * 10, 3));
                            plr.setMetadata("feelingWatchedDeathMessage", new FixedMetadataValue(this, true));
                        }
                    }
                }
                SetBonuses.ApplySetBonuses(plr);
            }
        }, 0, 20);
    }

    public void initHandlers() {
        BasicModeManager.initBasicMode();
        ExtraAdvancementManager.init(this);
    }

    public void initRecipes() {
        getServer().getPluginManager().registerEvents(new OnJoin(this), this);
    }

    public void initCustomItems() {
        OnWear.plugin = this;
        // getServer().getPluginManager().registerEvents(new SmithingTable(this), this);
    }

    public void initCommands() {
        Objects.requireNonNull(getCommand("lobby")).setExecutor(new LobbyCommand(this, bu));
        Objects.requireNonNull(getCommand("bin")).setExecutor(new BinCommand());

        Objects.requireNonNull(getCommand("back")).setExecutor(new BackCommand());

        Objects.requireNonNull(getCommand("accessories")).setExecutor(new AccessoryCommand());
    }

    public void initCombatLoggingEvents() {
        getServer().getPluginManager().registerEvents(new OnHit(this), this);
        getServer().getPluginManager().registerEvents(new OnDeath(this), this);
        getServer().getPluginManager().registerEvents(new OnLeave(this), this);

        getServer().getPluginManager().registerEvents(new ExecuteCommand(), this);
    }

    public void initEventHandlers() {
        getServer().getPluginManager().registerEvents(new OnPlayerInteractEntityEvent(), this);
        getServer().getPluginManager().registerEvents(new OnBreakBlock(), this);
        getServer().getPluginManager().registerEvents(new OnHungerChange(), this);
        getServer().getPluginManager().registerEvents(new OnInventoryClick(), this);
        getServer().getPluginManager().registerEvents(new OnPlaceBlock(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerInteract(), this);

        getServer().getPluginManager().registerEvents(new OnItemDamage(), this);

        getServer().getPluginManager().registerEvents(new OnDropItem(), this);

        getServer().getPluginManager().registerEvents(new OnEntityTarget(), this);
        getServer().getPluginManager().registerEvents(new OnChat(), this);

        getServer().getPluginManager().registerEvents(new OnCraft(this), this);

//        getServer().getPluginManager().registerEvents(new DoubleJump(), this);

        getServer().getPluginManager().registerEvents(new DragonEggPrevention(), this);
        getServer().getPluginManager().registerEvents(new DragonDamaged(), this);
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
