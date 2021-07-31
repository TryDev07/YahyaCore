package nl.trydev07.yahyacraft.common.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import nl.trydev07.yahyacraft.common.utils.Util;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

@CommandAlias("gamemode")
public class GamemodeCommand extends BaseCommand {

    @Default
    @CommandPermission("yahyacraft.core.gamemode")
    public void run(Player player) {
        player.sendMessage(Util.coloredMessage("&cusage: /gamemode <Survival,Creative,Adventure,Spectator>"));
    }

    @CommandAlias("gmc|gm1")
    @Subcommand("Creative")
    @CommandPermission("yahyacraft.core.gamemode.creative")
    public void creative(Player player) {
        player.setGameMode(GameMode.CREATIVE);
        player.sendMessage(Util.coloredMessage("&aChanged your gamemode to Creative"));
    }

    @CommandAlias("gms|gm0")
    @Subcommand("survival")
    @CommandPermission("yahyacraft.core.gamemode.survival")
    public void survival(Player player) {
        player.setGameMode(GameMode.SURVIVAL);
        player.sendMessage(Util.coloredMessage("&aChanged your gamemode to Survival"));
    }

    @CommandAlias("gma|gm2")
    @Subcommand("adventure")
    @CommandPermission("yahyacraft.core.gamemode.adventure")
    public void adventure(Player player) {
        player.setGameMode(GameMode.ADVENTURE);
        player.sendMessage(Util.coloredMessage("&aChanged your gamemode to Adventure"));
    }

    @CommandAlias("gmsp|gm3")
    @Subcommand("spectator")
    @CommandPermission("yahyacraft.gamemode.spectator")
    public void spectator(Player player) {
        player.setGameMode(GameMode.SPECTATOR);
        player.sendMessage(Util.coloredMessage("&aChanged your gamemode to Spectator"));
    }

}
