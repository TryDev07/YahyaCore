package nl.trydev07.yahyacraft.lobby.settings;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LobbySetting {

    WHITELIST("settings.whitelist", false);

    private String path;
    private Object defaultValue;

    private Object getValue() {
        return LobbySettings.getSetting(this);
    }

    public String getString() {
        return LobbySettings.getSetting(this).toString();
    }

    public boolean getBoolean() {
        return Boolean.parseBoolean(getString());
    }

    public int getInteger() {
        return Integer.parseInt(getString());
    }
}
