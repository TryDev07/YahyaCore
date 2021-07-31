package nl.trydev07.yahyacraft.common.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import nl.trydev07.yahyacraft.common.utils.Util;
import org.bukkit.entity.Player;

@CommandAlias("Fly")
public class FlyCommand extends BaseCommand {

    @Default
    @CommandPermission("yahyacraft.core.fly")
    public void run(Player player) {
        if (player.isFlying()) {
            player.setAllowFlight(false);
            player.setFlying(false);
            player.sendMessage(Util.coloredMessage("&aYou disabled fly"));
        } else {
            player.setAllowFlight(true);
            player.setFlying(true);
            player.sendMessage(Util.coloredMessage("&aYou enabled fly"));
        }
    }
}
