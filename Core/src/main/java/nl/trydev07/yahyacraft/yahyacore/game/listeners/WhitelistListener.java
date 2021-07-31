package nl.trydev07.yahyacraft.yahyacore.game.listeners;

import nl.trydev07.yahyacraft.yahyacore.YahyaCore;
import nl.trydev07.yahyacraft.yahyacore.settings.YahyaCoreSetting;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class WhitelistListener implements Listener {

    @EventHandler
    public void on(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        if (YahyaCoreSetting.WHITELIST.getBoolean()) {
            System.out.println(player.hasPermission("yahyacraft.whitelist"));
            System.out.println(YahyaCore.getInstance().getServer().hasWhitelist());
            player.setWhitelisted(player.hasPermission("yahyacraft.whitelist"));
            System.out.println(player.isWhitelisted());
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void on(PlayerJoinEvent event) {
        event.setJoinMessage(null);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void on(PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }
}
