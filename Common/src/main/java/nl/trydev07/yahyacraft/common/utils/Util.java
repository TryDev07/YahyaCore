package nl.trydev07.yahyacraft.common.utils;

import net.md_5.bungee.api.ChatColor;

public class Util {

    public static String coloredMessage(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
