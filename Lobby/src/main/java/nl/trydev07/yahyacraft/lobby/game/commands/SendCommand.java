package nl.trydev07.yahyacraft.lobby.game.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import nl.trydev07.yahyacraft.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

@CommandAlias("sendServer")
public class SendCommand extends BaseCommand {

    @Default
    @CommandPermission("yahyacraft.lobby.send")
    public void run(CommandSender sender, String[] args){
        if(sender instanceof ConsoleCommandSender){
            if(args.length > 1){
                Player player = Bukkit.getPlayer(args[0]);
                if(player == null) return;
                player.getServer().getMessenger().registerOutgoingPluginChannel(Lobby.getInstance(), args[1]);
            }
        }
    }
}
