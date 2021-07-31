package nl.trydev07.yahyacraft.lobby;

import co.aikar.commands.PaperCommandManager;
import lombok.Getter;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;
import nl.trydev07.yahyacraft.common.commands.*;
import nl.trydev07.yahyacraft.common.utils.ConfigFile;
import nl.trydev07.yahyacraft.lobby.game.commands.SendCommand;
import nl.trydev07.yahyacraft.lobby.game.commands.SpawnCommand;
import nl.trydev07.yahyacraft.lobby.game.handlers.LocationsHandler;
import nl.trydev07.yahyacraft.lobby.game.handlers.UserHandler;
import nl.trydev07.yahyacraft.lobby.game.commands.BuildModeCommand;
import nl.trydev07.yahyacraft.lobby.game.commands.JumpPadCommand;
import nl.trydev07.yahyacraft.lobby.game.listener.*;
import nl.trydev07.yahyacraft.lobby.settings.LobbySettings;
import nl.trydev07.yahyacraft.lobby.storage.Resources;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import sun.security.krb5.Config;

public class Lobby extends JavaPlugin {

    @Getter private static Lobby instance;
    @Getter private static Permission perms = null;
    @Getter private static Chat chat = null;
    @Getter private UserHandler userHandler;
    @Getter private Resources resources;
    @Getter private LocationsHandler locationsHandler;

    @Override

    public void onEnable() {
        instance = this;
        this.userHandler = new UserHandler();
        this.resources = new Resources(this);
        this.locationsHandler = new LocationsHandler();

        this.resources.load();
        LobbySettings.load();
        setupPermissions();
        setupChat();
        this.locationsHandler.load();

        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new FeedCommand());
        manager.registerCommand(new FlyCommand());
        manager.registerCommand(new GamemodeCommand());
        manager.registerCommand(new HealCommand());
        manager.registerCommand(new TeleportCommand());
        manager.registerCommand(new BuildModeCommand());
        manager.registerCommand(new JumpPadCommand());
        manager.registerCommand(new SpawnCommand());
        manager.registerCommand(new SpeedCommand());


        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new BuildModeListener(), this);
        pluginManager.registerEvents(new UserListener(), this);
        pluginManager.registerEvents(new LobbyListener(), this);
        pluginManager.registerEvents(new ChatListener(), this);
    }

    @Override
    public void onDisable() {
        this.locationsHandler.save();
        this.resources.save();
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }
}
