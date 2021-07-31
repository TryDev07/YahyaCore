package nl.trydev07.yahyacraft.yahyacore.storage;

import lombok.Getter;
import nl.trydev07.yahyacraft.common.utils.ConfigFile;
import nl.trydev07.yahyacraft.yahyacore.YahyaCore;

public class Resources {

    private final YahyaCore plugin;
    @Getter ConfigFile settings;

    public Resources(YahyaCore plugin) {
        this.plugin = plugin;
        this.settings = new ConfigFile(this.plugin, "settings.yml");
    }

    public void load() {
        this.settings.load();
    }


    public void save() {
        this.settings.save();
    }
}
