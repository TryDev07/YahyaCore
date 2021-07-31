package nl.trydev07.yahyacraft.yahyacore.settings;


import nl.trydev07.yahyacraft.common.utils.ConfigFile;
import nl.trydev07.yahyacraft.common.utils.Logger;
import nl.trydev07.yahyacraft.yahyacore.YahyaCore;

import java.util.HashMap;

public class YahyaCoreSettings {

    private static HashMap<YahyaCoreSetting, Object> values = new HashMap<>();

    public static void load() {
        ConfigFile file = YahyaCore.getInstance().getResources().getSettings();
        values = new HashMap<>();

        for (YahyaCoreSetting setting : YahyaCoreSetting.values()) {
            if (file.contains(setting.getPath())) {
                Object value = file.get(setting.getPath());

                if (value == null || !value.getClass().equals(setting.getDefaultValue().getClass())) {
                    values.put(setting, setting.getDefaultValue());
                    Logger.error("Error while loading setting (" + setting.name() + "). The given value must be a " + setting.getDefaultValue().getClass().getSimpleName().toLowerCase() + ".");
                } else {
                    values.put(setting, value);
                }
            } else {
                values.put(setting, setting.getDefaultValue());
            }
        }
    }

    public static boolean reload() {
        try {
            ConfigFile file = YahyaCore.getInstance().getResources().getSettings();
            file.load();
            load();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean reload(YahyaCoreSetting... settings) {
        try {
            reload();
            ConfigFile file = YahyaCore.getInstance().getResources().getSettings();

            for (YahyaCoreSetting setting : settings) {
                if (file.contains(setting.getPath())) {
                    Object value = file.get(setting.getPath());

                    if (value == null || !value.getClass().equals(setting.getDefaultValue().getClass())) {
                        values.put(setting, setting.getDefaultValue());
                        Logger.error("Error while loading setting (" + setting.name() + "). The given value must be a " + setting.getDefaultValue().getClass().getSimpleName().toLowerCase() + ".");
                    } else {
                        values.put(setting, value);
                    }
                } else {
                    values.put(setting, setting.getDefaultValue());
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Object getSetting(YahyaCoreSetting setting) {
        return values.getOrDefault(setting, setting.getDefaultValue());
    }

    public static boolean setSetting(YahyaCoreSetting setting, String input) {
        Object value = null;
        try {
            if (setting.getDefaultValue().getClass().equals(Boolean.class)) {
                value = Boolean.parseBoolean(input);
            } else if (setting.getDefaultValue().getClass().equals(Integer.class)) {
                value = Integer.parseInt(input);
            } else if (setting.getDefaultValue().getClass().equals(Double.class)) {
                value = Double.parseDouble(input);
            } else if (setting.getDefaultValue().getClass().equals(String.class)) {
                value = String.valueOf(input);
            }
        } catch (Exception exception) {
            value = null;
        }

        if (value == null) return false;
        return setSetting(setting, value);
    }

    public static boolean setSetting(YahyaCoreSetting setting, Object value) {
        if (value == null || !value.getClass().equals(setting.getDefaultValue().getClass())) return false;
        values.remove(setting);
        values.put(setting, value);
        ConfigFile file = YahyaCore.getInstance().getResources().getSettings();
        file.set(setting.getPath(), value);
        save();
        return true;
    }

    private static void save() {
        try {
            ConfigFile file = YahyaCore.getInstance().getResources().getSettings();
            file.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
