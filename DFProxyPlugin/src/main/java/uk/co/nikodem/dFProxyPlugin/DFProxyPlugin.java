package uk.co.nikodem.dFProxyPlugin;

import com.google.inject.Inject;
import com.velocitypowered.api.event.connection.DisconnectEvent;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.ServerConnectedEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.PluginContainer;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.dvs.versioning.BasicVersioning;
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings;
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings;
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings;
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.geysermc.geyser.api.GeyserApi;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;

@Plugin(id = "dfproxyplugin",
        name = "DFProxyPlugin",
        version = "1.0-SNAPSHOT",
        authors = {"deadfry42"},
        dependencies = {
                @Dependency(id = "geyser"),
                @Dependency(id = "floodgate")
        }
)
public class DFProxyPlugin {
    private final ProxyServer server;
    private final Logger logger;
//    public final File dataFolder;
//    public final File file;
    public final YamlDocument logs;
    private final String name;

    public GeyserApi geyser;

    @Inject
    public DFProxyPlugin(ProxyServer server, Logger logger, @DataDirectory Path dataFolder) {
        this.name = this.getClass().getAnnotation(Plugin.class).name();
        this.server = server;
        this.logger = logger;
//        this.dataFolder = new File(dataFolder.toFile().getParentFile(), this.getClass().getAnnotation(Plugin.class).name());

        try {
//            this.file = new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
            this.logs = YamlDocument.create(new File(dataFolder.toFile(), "logs.yml"),
                    Objects.requireNonNull(getClass().getResourceAsStream("/logs.yml")),
                    GeneralSettings.DEFAULT,
                    LoaderSettings.builder()
                            .setAutoUpdate(true)
                            .build(),
                    DumperSettings.DEFAULT,
                    UpdaterSettings.builder()
                            .setVersioning(new BasicVersioning("logs-version"))
                            .setOptionSorting(UpdaterSettings.OptionSorting.SORT_BY_DEFAULTS)
                            .build());

            logs.update();
            logs.save();
        } catch (final IOException e) {
            logger.error("Error creating logs! Shutting down..");
            Optional<PluginContainer> container = server.getPluginManager().getPlugin("dfproxyplugin");
            container.ifPresent(pluginContainer -> pluginContainer.getExecutorService().shutdown());
            throw new RuntimeException(e);
        }

        LoginAttempt.plugin = this;
        FileLogging.plugin = this;

        this.onLoad();
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        this.onEnable();
    }

    @Subscribe
    public void onProxyShutdown(ProxyShutdownEvent event) {
        this.onDisable();
    }

    @Subscribe
    public void onPlayerDisconnect(DisconnectEvent event) {
        if (this.geyser == null) this.geyser = GeyserApi.api();
        Player plr = event.getPlayer();
        DisconnectEvent.LoginStatus status = event.getLoginStatus();

        if (status != DisconnectEvent.LoginStatus.PRE_SERVER_JOIN) return;

        LoginAttempt login = new LoginAttempt(plr, status);
        System.out.println(login.stringify());
    }

    @Subscribe
    public void onPlayerJoin(ServerConnectedEvent event) {
        // i put the initialisation of geyser here to make sure geyser is fully loaded first lol
        if (this.geyser == null) this.geyser = GeyserApi.api();
        if (event.getPreviousServer().isEmpty()) {
            Player plr = event.getPlayer();

            LoginAttempt login = new LoginAttempt(plr, DisconnectEvent.LoginStatus.SUCCESSFUL_LOGIN);
            System.out.println(login.stringify());

            if (geyser.isBedrockPlayer(plr.getUniqueId())) {
                Component msg1 = Component.text("Welcome to the server!")
                        .color(TextColor.color(0x03989e));
                Component msg2 = Component.text("Please note that you're playing on Bedrock, which is supported but doesn't work as well as Java.")
                        .color(TextColor.color(0xB2482D));
                Component msg3 = Component.text("If you encounter any issues, or want to stay up to date, join the discord server!")
                        .color(TextColor.color(0xB22D23));
                Component msg4 = Component.text("You can find the discord server at https://discord.gg/SpukTa6jBf")
                        .color(TextColor.color(0xB22824));
                plr.sendMessage(msg1);
                plr.sendMessage(msg2);
                plr.sendMessage(msg3);
                plr.sendMessage(msg4);
                return;
            }
            Component msg1 = Component.text("Welcome to the server!")
                    .color(TextColor.color(0x03989e));
            Component msg2 = Component.text("You can join the discord server to keep updated with the server's updates!")
                    .color(TextColor.color(0x5d782e));
            Component msg3 = Component.text("You can find the discord server at https://discord.gg/SpukTa6jBf")
                    .color(TextColor.color(0x588163));
            plr.sendMessage(msg1);
            plr.sendMessage(msg2);
            plr.sendMessage(msg3);
        }
    }

    public void onLoad() {
//        System.out.println("Loaded plugin "+this.name);
    }

    public void onEnable() {

    }

    public void onDisable() {
//        System.out.println("Deloaded plugin "+this.name);
    }
}
