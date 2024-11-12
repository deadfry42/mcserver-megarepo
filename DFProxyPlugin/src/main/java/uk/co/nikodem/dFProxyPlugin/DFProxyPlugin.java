package uk.co.nikodem.dFProxyPlugin;

import com.google.inject.Inject;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.ServerConnectedEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.geysermc.geyser.api.GeyserApi;
import org.slf4j.Logger;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;

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
    private final File dataFolder;
    private final File file;
    private final String name;

    private GeyserApi geyser;

    @Inject
    public DFProxyPlugin(ProxyServer server, Logger logger, @DataDirectory Path dataFolder) {
        this.name = this.getClass().getAnnotation(Plugin.class).name();
        this.server = server;
        this.logger = logger;
        this.dataFolder = new File(dataFolder.toFile().getParentFile(), this.getClass().getAnnotation(Plugin.class).name());

        try {
            this.file = new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
        } catch(final URISyntaxException ex) {
            throw new RuntimeException(ex);
        }

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
    public void onPlayerJoin(ServerConnectedEvent event) {
        // i put the initialisation of geyser here to make sure geyser is fully loaded first lol
        if (this.geyser == null) this.geyser = GeyserApi.api();
        if (event.getPreviousServer().isEmpty()) {
            Player plr = event.getPlayer();
            if (geyser.isBedrockPlayer(plr.getUniqueId())) {
                Component msg1 = Component.text("Welcome to the server!")
                        .color(TextColor.color(0x03989e));
                Component msg2 = Component.text("Please note that you're playing on Bedrock, rather than Java.")
                        .color(TextColor.color(0xB2482D));
                Component msg3 = Component.text("This could mean that certain things won't work as well as it would on Java.")
                        .color(TextColor.color(0xB22D23));
                Component msg4 = Component.text("Some known caveats are: no custom textures, no voice chat support.")
                        .color(TextColor.color(0xB22824));
                plr.sendMessage(msg1);
                plr.sendMessage(msg2);
                plr.sendMessage(msg3);
                plr.sendMessage(msg4);
                return;
            }
            Component msg1 = Component.text("Welcome to the server!")
                    .color(TextColor.color(0x03989e));
            Component msg2 = Component.text("Remember that the simple voice chat is recommended for the best experience!")
                    .color(TextColor.color(0x5d782e));
            Component msg3 = Component.text("You can find the mod at https://modrinth.com/plugin/simple-voice-chat")
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