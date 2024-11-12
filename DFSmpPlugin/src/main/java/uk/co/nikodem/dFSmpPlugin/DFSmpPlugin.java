package uk.co.nikodem.dFSmpPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import uk.co.nikodem.dFSmpPlugin.Content.Commands.*;
import uk.co.nikodem.dFSmpPlugin.Content.Events.*;
import uk.co.nikodem.dFSmpPlugin.Content.Utils.*;

import org.bukkit.scheduler.BukkitScheduler;

import java.util.Objects;

public final class DFSmpPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getConfig().addDefault("basicMode", false);
        getConfig().addDefault("combatlogtime", 30);
        saveConfig();

        AntiSpamManager.init(this);
        CombatLoggingManager.init(this);

        // basic mode manager, for things like skyblock
        BasicModeManager.initBasicMode(this);

        // create custom recipes
        new RecipeCreator(this);

        // discover those recipes on join
        getServer().getPluginManager().registerEvents(new OnJoin(), this);

        // block certain commands when in combat
        getServer().getPluginManager().registerEvents(new ExecuteCommand(), this);

        // custom item usage
        getServer().getPluginManager().registerEvents(new ItemUse(), this);
        getServer().getPluginManager().registerEvents(new BreakBlock(), this);
        getServer().getPluginManager().registerEvents(new DragonEggPrevention(), this);
        getServer().getPluginManager().registerEvents(new PlaceBlock(), this);
        // getServer().getPluginManager().registerEvents(new SmithingTable(this), this);

        // combat logging
        getServer().getPluginManager().registerEvents(new OnHit(this), this);
        getServer().getPluginManager().registerEvents(new OnDeath(this), this);
        getServer().getPluginManager().registerEvents(new OnLeave(this), this);

        BungeeUtils bu = new BungeeUtils(this);
        bu.initiateBungeeCordChannel();

        Objects.requireNonNull(getCommand("lobby")).setExecutor(new LobbyCommand(this, bu));
        Objects.requireNonNull(getCommand("bin")).setExecutor(new BinCommand());

        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.runTaskTimer(this, () -> {
            // runs every second
            for(Player plr : Bukkit.getOnlinePlayers()){
                if (!CombatLoggingManager.playerInCombat(plr) && CombatLoggingManager.getPlayerCombatTimestamp(plr) > 0 && !BasicModeManager.basicMode) {
                    plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2You are no longer in combat!"));
                    CombatLoggingManager.playerRemoveCombatLog(plr);
                }
                if (
                        CustomItemManager.IsItem(Objects.requireNonNull(plr.getInventory().getItem(EquipmentSlot.HEAD)), CustomItemManager.createCalciteHelmet())
                        && CustomItemManager.IsItem(Objects.requireNonNull(plr.getInventory().getItem(EquipmentSlot.CHEST)), CustomItemManager.createCalciteChestplate())
                        && CustomItemManager.IsItem(Objects.requireNonNull(plr.getInventory().getItem(EquipmentSlot.LEGS)), CustomItemManager.createCalciteLeggings())
                        && CustomItemManager.IsItem(Objects.requireNonNull(plr.getInventory().getItem(EquipmentSlot.FEET)), CustomItemManager.createCalciteBoots())
                ) {
                    plr.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 25, 1, true, false));
                }
            }
        }, 0, 20);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        saveConfig();
    }
}
