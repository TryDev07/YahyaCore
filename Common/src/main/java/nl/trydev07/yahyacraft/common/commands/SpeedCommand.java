package nl.trydev07.yahyacraft.common.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import nl.trydev07.yahyacraft.common.utils.Util;
import org.bukkit.entity.Player;

@CommandAlias("speed")
public class SpeedCommand extends BaseCommand {

    @Default
    @CommandPermission("yahyacraft.core.speed")
    public void run(Player player, String[] args) {
        if (args.length > 0) {
            float i = Float.parseFloat(args[0]);
            if (i > 10) {
                if (player.isFlying()) {
                    player.setFlySpeed(1F);
                    player.sendMessage(Util.coloredMessage("&aFlying speed has been set to &710"));
                } else {
                    player.setWalkSpeed(1F);
                    player.sendMessage(Util.coloredMessage("&aWalking speed has been set to &710"));
                }
            } else {
                if (player.isFlying()) {
                    player.setFlySpeed(i / 10);
                    player.sendMessage(Util.coloredMessage("&aFlying speed has been set to &7" + i));
                } else {
                    player.setWalkSpeed(i / 10);
                    player.sendMessage(Util.coloredMessage("&aWalking speed has been set to &7" + i));
                }
            }
        } else {
            player.sendMessage(Util.coloredMessage("&cUsage /speed <amount> &7: max amount is 10"));
        }

    }
}
