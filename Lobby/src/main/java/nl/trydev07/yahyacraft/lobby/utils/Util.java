package nl.trydev07.yahyacraft.lobby.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import nl.trydev07.yahyacraft.lobby.Lobby;
import org.bukkit.Location;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.UUID;
import java.util.logging.Level;

public class Util {


    public static void log(String msg) {
        Lobby.getInstance().getLogger().log(Level.WARNING, nl.trydev07.yahyacraft.common.utils.Util.coloredMessage(msg));
    }

    public static String getOfflinePlayerOld(String playerName) {
        try {
            URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + playerName);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            JsonObject parser = new JsonParser().parse(reader).getAsJsonObject();
            if (parser == null) return "Invalid Player";
            return parser.get("id").getAsString();
        } catch (IOException exception) {
            log("IOException in getOfflinePlayer");
        }
        return "";
    }

    public static UUID getOfflinePlayer(String playerName) {
        try {
            URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + playerName);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            JsonObject parser = new JsonParser().parse(reader).getAsJsonObject();
            if (parser == null) return null;
            String uuid = parser.get("id").getAsString();
            StringBuilder stringBuilder = new StringBuilder(uuid);
            int[] inserts = {8, 13, 18, 23};
            Arrays.stream(inserts).forEach(insert -> stringBuilder.insert(insert, "-"));
            return UUID.fromString(stringBuilder.toString());
        } catch (IOException exception) {
           log("IOException in getOfflinePlayer");
        }
        return null;
    }

    public static boolean moveBlock(Location from, Location to){
        return from.getBlockY() != to.getBlockY() || from.getBlockZ() != to.getBlockZ() || from.getBlockX() != to.getBlockX();
    }

    public static Location blockLocation(Location location){
        return new Location(location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ(),0,0);
    }
}
