package uk.co.nikodem.dFInhibition;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.nikodem.dFInhibition.Commands.EnableFeature;
import uk.co.nikodem.dFInhibition.Commands.PrepSMP;
import uk.co.nikodem.dFInhibition.Commands.StartSMP;
import uk.co.nikodem.dFInhibition.Commands.milestones;
import uk.co.nikodem.dFInhibition.Inhibition.InhibitManager;
import uk.co.nikodem.dFInhibition.Inhibition.Mobs;
import uk.co.nikodem.dFInhibition.Inhibition.Player;

import java.util.Objects;

public final class DFInhibition extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().addDefault("locked", true);
        getConfig().addDefault("pvp", true);
        getConfig().addDefault("nether", true);
        getConfig().addDefault("end", true);
        getConfig().addDefault("milestones.pvp", "1 day");
        getConfig().addDefault("milestones.nether", "2 days");
        getConfig().addDefault("milestones.end", "3 days");
        getConfig().options().copyDefaults(true);
        saveConfig();

        new InhibitManager(this);

        // inhibition
        getServer().getPluginManager().registerEvents(new Mobs(), this);
        getServer().getPluginManager().registerEvents(new Player(), this);

        Objects.requireNonNull(getCommand("startsmp")).setExecutor(new StartSMP(this));
        Objects.requireNonNull(getCommand("prepsmp")).setExecutor(new PrepSMP(this));
        Objects.requireNonNull(getCommand("milestones")).setExecutor(new milestones(this));

        Objects.requireNonNull(getCommand("enablepvp")).setExecutor(new EnableFeature(this, "pvp"));
        Objects.requireNonNull(getCommand("enablenether")).setExecutor(new EnableFeature(this, "nether"));
        Objects.requireNonNull(getCommand("enableend")).setExecutor(new EnableFeature(this, "end"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        saveConfig();
    }
}
