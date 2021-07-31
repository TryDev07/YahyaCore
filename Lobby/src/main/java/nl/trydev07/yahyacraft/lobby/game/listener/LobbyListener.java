package nl.trydev07.yahyacraft.lobby.game.listener;

import nl.trydev07.yahyacraft.lobby.Lobby;
import nl.trydev07.yahyacraft.lobby.data.Locations;
import nl.trydev07.yahyacraft.lobby.utils.Util;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import java.util.Objects;

public class LobbyListener implements Listener {

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onWeatherChange(WeatherChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onThunder(ThunderChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void damage(EntityDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Locations locationsCache = Lobby.getInstance().getLocationsHandler().getLocationsCache();
        locationsCache.getJumpads().forEach(location -> {
            if (Util.blockLocation(Objects.requireNonNull(event.getTo())).equals(location) && player.getLocation().clone().add(0,1,0).getBlock().getRelative(BlockFace.DOWN).getType() == Material.LIGHT_WEIGHTED_PRESSURE_PLATE) {
                player.setVelocity(player.getLocation().getDirection().multiply(1.5).setY(1));
            }
        });
        if (Util.moveBlock(event.getFrom(), Objects.requireNonNull(event.getTo()))) {
            if (player.getLocation().getBlockY() < 1) {
                player.teleport(Lobby.getInstance().getLocationsHandler().getLocationsCache().getSpawnLocation());
            }
        }

    }
}
