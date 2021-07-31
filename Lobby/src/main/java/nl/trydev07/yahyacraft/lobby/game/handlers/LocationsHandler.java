package nl.trydev07.yahyacraft.lobby.game.handlers;

import lombok.Getter;
import nl.trydev07.yahyacraft.common.utils.ConfigFile;
import nl.trydev07.yahyacraft.common.utils.LocationUtil;
import nl.trydev07.yahyacraft.common.utils.Logger;
import nl.trydev07.yahyacraft.lobby.Lobby;
import nl.trydev07.yahyacraft.lobby.data.Locations;

import java.util.Objects;

public class LocationsHandler {

    @Getter Locations locationsCache;

    public LocationsHandler() {
        locationsCache = new Locations();
    }

    public void load() {
        try {
            ConfigFile configFile = Lobby.getInstance().getResources().getLocations();
            if (configFile == null) configFile.load();
            locationsCache.setSpawnLocation(LocationUtil.deserializeLocation(Objects.requireNonNull(configFile.getString("SpawnPoint"))));
            locationsCache.setJumpads(LocationUtil.deserializeLocationList(configFile.getStringList("Jumpads")));
        } catch (Exception exception) {
            Logger.error("Error while loading the locations: " + exception.getMessage());
        }
    }

    public void save() {
        try {
            ConfigFile configFile = Lobby.getInstance().getResources().getLocations();
            configFile.set("SpawnPoint", LocationUtil.serializeLocation(locationsCache.getSpawnLocation()));
            configFile.set("Jumpads", LocationUtil.serializeLocationList(locationsCache.getJumpads()));
            configFile.save();
        } catch (Exception exception) {
            Logger.error("Error while saving the locations: " + exception.getMessage());
        }
    }
}
