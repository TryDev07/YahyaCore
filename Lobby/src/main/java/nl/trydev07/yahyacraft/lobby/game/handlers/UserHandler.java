package nl.trydev07.yahyacraft.lobby.game.handlers;

import nl.trydev07.yahyacraft.common.utils.GsonUtil;
import nl.trydev07.yahyacraft.lobby.Lobby;
import nl.trydev07.yahyacraft.lobby.data.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserHandler {

    static Map<UUID, User> userCache = new HashMap<>();

    public static User getUserCache(UUID uuid) {
        userCache.putIfAbsent(uuid, new User());
        return userCache.get(uuid);
    }

    public void load(UUID uuid) {
        try {
            GsonUtil<User> gsonUtil = new GsonUtil<>(Lobby.getInstance(), "/users/" + uuid, true);
            User user = gsonUtil.load(User.class);
            userCache.put(uuid, user);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void save(UUID uuid) {
        try {
            GsonUtil<User> gsonUtil = new GsonUtil<>(Lobby.getInstance(), "/users/" + uuid, true);
            gsonUtil.save(userCache.get(uuid));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void saveAll() {
        userCache.forEach((key, value) -> {
            try {
                GsonUtil<User> gsonUtil = new GsonUtil<>(Lobby.getInstance(), "/users/" + key, true);
                gsonUtil.save(value);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
}
