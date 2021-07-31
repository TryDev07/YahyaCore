package nl.trydev07.yahyacraft.common.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import nl.trydev07.yahyacraft.common.utils.Util;
import org.bukkit.entity.Player;

@CommandAlias("heal")
public class HealCommand extends BaseCommand {

    @Default
    @CommandPermission("yahyacraft.core.heal")
    public void run(Player player){
        player.setHealth(20);
        player.sendMessage(Util.coloredMessage("&aYou healed yourself"));
    }
}
