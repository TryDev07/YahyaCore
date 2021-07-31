package nl.trydev07.yahyacraft.lobby.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {

    boolean BuildMode;

    public User() {
        this.BuildMode = false;
    }
}
