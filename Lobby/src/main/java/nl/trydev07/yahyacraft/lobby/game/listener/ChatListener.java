package nl.trydev07.yahyacraft.lobby.game.listener;

import nl.trydev07.yahyacraft.common.utils.Util;
import nl.trydev07.yahyacraft.lobby.Lobby;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if (event.getPlayer().hasPermission("yahyacraft.core.chatcolored")) {
            String chat_format = Util.coloredMessage(Lobby.getChat().getPlayerPrefix(event.getPlayer()) + event.getPlayer().getName() + Lobby.getChat().getPlayerSuffix(event.getPlayer()) + " : " + event.getMessage());
            event.setFormat(chat_format);
        } else {
            String chat_format = Util.coloredMessage(Lobby.getChat().getPlayerPrefix(event.getPlayer()) + event.getPlayer().getName() + Lobby.getChat().getPlayerSuffix(event.getPlayer()) + " : ") + event.getMessage();
            event.setFormat(chat_format);
        }
    }
}
