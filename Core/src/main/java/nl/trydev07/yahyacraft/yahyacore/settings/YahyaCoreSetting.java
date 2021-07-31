package nl.trydev07.yahyacraft.yahyacore.settings;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum YahyaCoreSetting {

    WHITELIST("settings.whitelist", false),
    PROXIMITY_CHAT("settings.proximity_chat", false),
    PROXIMITY_CHAT_DISTANCE("settings.proximity_chat_distance", 50);

    private String path;
    private Object defaultValue;

    private Object getValue() {
        return YahyaCoreSettings.getSetting(this);
    }

    public String getString() {
        return YahyaCoreSettings.getSetting(this).toString();
    }

    public boolean getBoolean() {
        return Boolean.parseBoolean(getString());
    }

    public int getInteger() {
        return Integer.parseInt(getString());
    }
}
