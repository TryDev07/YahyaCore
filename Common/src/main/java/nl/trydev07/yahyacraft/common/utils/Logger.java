package nl.trydev07.yahyacraft.common.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Logger {

    private static final String CONSOLE_PREFIX = ChatColor.BLUE + "[YahyaCraftLobby] ";

    public static void info(String message) {
        Bukkit.getConsoleSender().sendMessage(CONSOLE_PREFIX + ChatColor.GRAY + message);
    }

    public static void warning(String message) {
        Bukkit.getConsoleSender().sendMessage(CONSOLE_PREFIX + ChatColor.YELLOW + message);
    }

    public static void error(String message) {
        Bukkit.getConsoleSender().sendMessage(CONSOLE_PREFIX + ChatColor.RED + message);
    }
}
