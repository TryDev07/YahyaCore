package nl.trydev07.yahyacraft.yahyacore.game.listeners;

import nl.trydev07.yahyacraft.common.utils.Util;
import nl.trydev07.yahyacraft.yahyacore.YahyaCore;
import nl.trydev07.yahyacraft.yahyacore.settings.YahyaCoreSetting;
import nl.trydev07.yahyacraft.yahyacore.settings.YahyaCoreSettings;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if (event.getPlayer().hasPermission("yahyacraft.core.chatcolored")) {
            String chat_format = Util.coloredMessage(YahyaCore.getChat().getPlayerPrefix(event.getPlayer()) + event.getPlayer().getName() + "&f : " + event.getMessage());
            if (YahyaCoreSetting.PROXIMITY_CHAT.getBoolean()) {
                event.getRecipients().forEach(player -> {
                    if (event.getPlayer().getLocation().distance(player.getLocation()) <= YahyaCoreSetting.PROXIMITY_CHAT_DISTANCE.getInteger()) {
                        player.sendMessage(chat_format);
                    }
                });
                event.getRecipients().clear();
            } else {
                event.setFormat(chat_format);
            }
        } else {
            String chat_format = Util.coloredMessage(YahyaCore.getChat().getPlayerPrefix(event.getPlayer()) + event.getPlayer().getName() + "&f : ") + event.getMessage();
            if (YahyaCoreSetting.PROXIMITY_CHAT.getBoolean()) {
                event.getRecipients().forEach(player -> {
                    if (event.getPlayer().getLocation().distance(player.getLocation()) <= YahyaCoreSetting.PROXIMITY_CHAT_DISTANCE.getInteger()) {
                        player.sendMessage(chat_format);
                    }
                });
                event.getRecipients().clear();
            } else {
                event.setFormat(chat_format);
            }
        }
    }
}