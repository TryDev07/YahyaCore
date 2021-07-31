package nl.trydev07.yahyacraft.common.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationUtil {

    public static List<String> serializeLocationList(List<Location> locationList) {
        List<String> stringList = new ArrayList<>();
        locationList.forEach(loc -> {
            stringList.add(loc.getWorld().getName() + ":" + loc.getX() + ":" + loc.getY() + ":" + loc.getZ() + ":" + loc.getYaw() + ":" + loc.getPitch());
        });
        return stringList;
    }

    public static List<Location> deserializeLocationList(List<String> stringList) {
        List<Location> locationList = new ArrayList<>();
        stringList.forEach(string -> {
            String[] s = string.split(":");
            locationList.add(new Location(Bukkit.getWorld(s[0]), Double.parseDouble(s[1]), Double.parseDouble(s[2]), Double.parseDouble(s[3]), Float.parseFloat(s[4]), Float.parseFloat(s[5])));
        });
        return locationList;
    }

    public static String serializeLocation(Location location) {
        return location.getWorld().getName() + ":" + location.getX() + ":" + location.getY() + ":" + location.getZ() + ":" + location.getYaw() + ":" + location.getPitch();
    }

    public static Location deserializeLocation(String location) {
        String[] s = location.split(":");
        return new Location(Bukkit.getWorld(s[0]), Double.parseDouble(s[1]), Double.parseDouble(s[2]), Double.parseDouble(s[3]), Float.parseFloat(s[4]), Float.parseFloat(s[5]));
    }

    public static Location getLocation(Location location) {
        return new Location(location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ(), location.getYaw(), location.getPitch()).add(0.5, 0, 0.5);
    }


}
