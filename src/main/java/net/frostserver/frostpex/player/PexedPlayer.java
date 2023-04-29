package net.frostserver.frostpex.player;

import lombok.Getter;
import net.frostserver.frostpex.groups.Group;
import org.bukkit.entity.Player;

public abstract class PexedPlayer implements Player {

    @Getter private Group group;

    public static PexedPlayer fromPlayer(Player player) {
        return ((PexedPlayer) player);
    }

}
