package nl.trydev07.yahyacraft.yahyacore;

import co.aikar.commands.PaperCommandManager;
import lombok.Getter;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;
import nl.trydev07.yahyacraft.common.commands.*;
import nl.trydev07.yahyacraft.yahyacore.game.listeners.ChatListener;
import nl.trydev07.yahyacraft.yahyacore.game.listeners.WhitelistListener;
import nl.trydev07.yahyacraft.yahyacore.storage.Resources;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class YahyaCore extends JavaPlugin {

    @Getter static YahyaCore instance;
    @Getter static Permission perms = null;
    @Getter static Chat chat = null;
    @Getter private Resources resources;

    @Override
    public void onEnable() {
        setupPermissions();
        setupChat();
        instance = this;
        this.resources = new Resources(this);

        this.resources.load();
        YahyaCoreSettings.load();

        PaperCommandManager manager = new PaperCommandManager(this);
        manager.registerCommand(new FeedCommand());
        manager.registerCommand(new FlyCommand());
        manager.registerCommand(new GamemodeCommand());
        manager.registerCommand(new HealCommand());
        manager.registerCommand(new TeleportCommand());
        manager.registerCommand(new SpeedCommand());

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ChatListener(), this);
        pluginManager.registerEvents(new WhitelistListener(), this);


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
