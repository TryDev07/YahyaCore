package nl.trydev07.yahyacraft.lobby.game.listener;

import nl.trydev07.yahyacraft.common.utils.Util;
import nl.trydev07.yahyacraft.lobby.Lobby;
import nl.trydev07.yahyacraft.lobby.settings.LobbySetting;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class UserListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Lobby.getInstance().getUserHandler().save(event.getPlayer().getUniqueId());
        event.setQuitMessage(null);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        /*if(player.getUniqueId().toString().equals("7a0b40ff-f3b2-491a-991f-2d879f58de5a")){
            player.kickPlayer(Util.coloredMessage("\n&aHou jij het maar lekker bij discord.\n&cDe gadgets heb je nice fixed btw!\n"));
        }*/
        if(LobbySetting.WHITELIST.getBoolean()) {
            if (!player.hasPermission("YahyaCraft.lobby.Whitelist")) {
                player.kickPlayer(Util.coloredMessage("&4Server is currently under maintenance"));
            }
        }

        Lobby.getInstance().getUserHandler().load(player.getUniqueId());
        player.teleport(Lobby.getInstance().getLocationsHandler().getLocationsCache().getSpawnLocation());
        event.setJoinMessage(null);

    }
}
