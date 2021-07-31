package nl.trydev07.yahyacraft.lobby.game.listener;

import nl.trydev07.yahyacraft.lobby.data.User;
import nl.trydev07.yahyacraft.lobby.game.handlers.UserHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class BuildModeListener implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        User user = UserHandler.getUserCache(event.getPlayer().getUniqueId());
        if (!user.isBuildMode()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(BlockPlaceEvent event) {
        User user = UserHandler.getUserCache(event.getPlayer().getUniqueId());
        if (!user.isBuildMode()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        User user = UserHandler.getUserCache(event.getPlayer().getUniqueId());
        if (!user.isBuildMode()) {
            event.setCancelled(true);
        }
    }
}
