package nl.trydev07.yahyacraft.common.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import nl.trydev07.yahyacraft.common.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Objects;


public class TeleportCommand extends BaseCommand {

    @Default
    @CommandAlias("teleport|tp")
    @CommandPermission("yahyacraft.core.teleport")
    @CommandCompletion("@players")
    public void teleport(Player player, String[] args) {
        if (args.length > 0) {
            if (Bukkit.getPlayer(args[0]) == null)
                player.sendMessage(Util.coloredMessage("&aCould not find player &7" + args[1]));
            player.teleport(Objects.requireNonNull(Bukkit.getPlayer(args[0])));
            player.sendMessage(Util.coloredMessage("&aYou teleported to &7" + Objects.requireNonNull(Bukkit.getPlayer(args[0])).getName()));
        } else
            player.sendMessage(Util.coloredMessage("&cUsage: /teleport <playername>"));
    }

    @Default
    @CommandAlias("teleporthere|tphere")
    @CommandPermission("yahyacraft.core.tphere")
    @CommandCompletion("@players")
    public void tphere(Player player, String[] args) {

        if (args.length > 0) {
            if (Bukkit.getPlayer(args[0]) == null)
                player.sendMessage(Util.coloredMessage("&aCould not find player &7" + args[1]));
            Objects.requireNonNull(Bukkit.getPlayer(args[0])).teleport(player);
            player.sendMessage(Util.coloredMessage("&aYou teleported &7" + Objects.requireNonNull(Bukkit.getPlayer(args[0])).getName() + " &ato yourself"));
        } else
            player.sendMessage(Util.coloredMessage("&cUsage: /tphere <playername>"));
    }

    @Default
    @CommandAlias("tpall")
    @CommandPermission("yahyacraft.core.tpall")
    @CommandCompletion("@players")
    public void tpall(Player player, String[] args) {
        if (args.length > 0) {
            Bukkit.getServer().getOnlinePlayers().forEach(onlinePlayer -> onlinePlayer.teleport(Objects.requireNonNull(Bukkit.getPlayer(args[0]))));
            player.sendMessage(Util.coloredMessage("&aYou teleported everyone to &7" + args[0]));
        } else {
            Bukkit.getServer().getOnlinePlayers().forEach(onlinePlayer -> onlinePlayer.teleport(player));
            player.sendMessage(Util.coloredMessage("&aYou teleported everyone to yourself"));
        }
    }
}
