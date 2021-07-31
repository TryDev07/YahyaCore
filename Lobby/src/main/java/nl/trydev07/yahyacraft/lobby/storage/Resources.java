package nl.trydev07.yahyacraft.lobby.storage;


import lombok.Getter;
import nl.trydev07.yahyacraft.common.utils.ConfigFile;
import nl.trydev07.yahyacraft.lobby.Lobby;

public class Resources {

    private final Lobby plugin;
    @Getter ConfigFile settings;
    @Getter ConfigFile locations;

    public Resources(Lobby plugin) {
        this.plugin = plugin;
        this.settings = new ConfigFile(this.plugin, "settings.yml");
        this.locations = new ConfigFile(this.plugin, "locations.yml", false);
    }

    public void load() {
        this.settings.load();
        this.locations.load();
    }

    public void save() {
        this.settings.save();
    }
}
