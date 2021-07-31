package nl.trydev07.yahyacraft.lobby.game.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import nl.trydev07.yahyacraft.common.utils.Util;
import nl.trydev07.yahyacraft.lobby.Lobby;
import org.bukkit.entity.Player;

public class SpawnCommand extends BaseCommand {

    @CommandAlias("setspawn")
    @Default
    @CommandPermission("yahyacraft.lobby.setspawn")
    public void setspawn(Player player){
        Lobby.getInstance().getLocationsHandler().getLocationsCache().setSpawnLocation(player.getLocation());
        player.sendMessage(Util.coloredMessage("&aThe spawn location has been set to your current location"));
    }

    @CommandAlias("spawn")
    @Default
    public void spawn(Player player){
        player.teleport(Lobby.getInstance().getLocationsHandler().getLocationsCache().getSpawnLocation());
    }
}
