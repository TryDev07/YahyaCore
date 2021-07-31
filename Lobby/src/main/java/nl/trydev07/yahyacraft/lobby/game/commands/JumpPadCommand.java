package nl.trydev07.yahyacraft.lobby.game.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import nl.trydev07.yahyacraft.lobby.Lobby;
import nl.trydev07.yahyacraft.lobby.data.Locations;
import nl.trydev07.yahyacraft.lobby.utils.Util;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

@CommandAlias("jumpad")
public class JumpPadCommand extends BaseCommand {


    @Default
    @CommandPermission("yahyacraft.lobby.jumpad")
    public void run(Player player){
        player.sendMessage(nl.trydev07.yahyacraft.common.utils.Util.coloredMessage("&cUsage: /jumpad add"));
    }

    @Subcommand("add")
    public void add(Player player){
        Locations locationsCache = Lobby.getInstance().getLocationsHandler().getLocationsCache();
        locationsCache.getJumpads().add(Util.blockLocation(player.getLocation()));
        Block block = player.getLocation().clone().add(0,1,0).getBlock().getRelative(BlockFace.DOWN);
        block.setType(Material.LIGHT_WEIGHTED_PRESSURE_PLATE);
        player.sendMessage(nl.trydev07.yahyacraft.common.utils.Util.coloredMessage("&aCreated a jumpad underneath you"));

    }
}
