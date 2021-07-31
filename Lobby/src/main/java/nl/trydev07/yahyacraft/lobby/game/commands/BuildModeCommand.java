package nl.trydev07.yahyacraft.lobby.game.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import nl.trydev07.yahyacraft.common.utils.Util;
import nl.trydev07.yahyacraft.lobby.data.User;
import nl.trydev07.yahyacraft.lobby.game.handlers.UserHandler;
import org.bukkit.entity.Player;

@CommandAlias("buildmode")
public class BuildModeCommand extends BaseCommand {

    @Default
    @CommandPermission("yahyacraft.lobby.buildmode")
    public void run(Player player){
        User user = UserHandler.getUserCache(player.getUniqueId());
        if(user.isBuildMode()) {
            player.sendMessage(Util.coloredMessage("&aYou disabled buildmode"));
            user.setBuildMode(false);
        }else{
            player.sendMessage(Util.coloredMessage("&aYou enabled buildmode"));
            user.setBuildMode(true);
        }
    }
}
