package uk.co.nikodem.dFLobbyPlugin;

import org.bukkit.plugin.java.JavaPlugin;
import uk.co.nikodem.dFLobbyPlugin.Commands.*;
import uk.co.nikodem.dFLobbyPlugin.Events.OnJoin;
import uk.co.nikodem.dFLobbyPlugin.Events.OnLeave;
import uk.co.nikodem.dFLobbyPlugin.Handlers.BungeeUtils;

import java.util.Objects;

public final class DFLobbyPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new OnLeave(), this);
        getServer().getPluginManager().registerEvents(new OnJoin(), this);

        BungeeUtils bu = new BungeeUtils(this);
        bu.initiateBungeeCordChannel();

        Objects.requireNonNull(getCommand("dansmp")).setExecutor(new DanSMP(bu));
        Objects.requireNonNull(getCommand("smp")).setExecutor(new SMP(bu));
        Objects.requireNonNull(getCommand("skyblock")).setExecutor(new Skyblock(bu));
        Objects.requireNonNull(getCommand("testserver")).setExecutor(new TestPlr(bu));
        Objects.requireNonNull(getCommand("modded")).setExecutor(new Modded(bu));
        Objects.requireNonNull(getCommand("kit")).setExecutor(new Kit());
        Objects.requireNonNull(getCommand("clr")).setExecutor(new Clr());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
