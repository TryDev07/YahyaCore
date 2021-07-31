package nl.trydev07.yahyacraft.lobby.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Locations {

    Location spawnLocation;
    List<Location> jumpads;

    public Locations(){
        spawnLocation = new Location(Bukkit.getWorld("world"),0,0,0);
        jumpads = new ArrayList<>();
    }
}
