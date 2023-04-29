package net.frostserver.frostpex.player;

import lombok.Getter;
import net.frostserver.frostpex.FrostPermissions;
import net.frostserver.frostpex.groups.Group;
import net.frostserver.frostpex.manager.GroupsManager;
import org.bukkit.entity.Player;

public abstract class PexedPlayer implements Player {

    @Getter private Group group;

    public PexedPlayer setGroup(Group group) {
        this.group = group;
        return this;
    }

    public static PexedPlayer fromPlayer(Player player, Group group) {
        return ((PexedPlayer) player)
                .setGroup(
                        group
                );
    }

    public static PexedPlayer fromPlayer(Player player) {
        return PexedPlayer.fromPlayer(player, FrostPermissions.getInstance().getGroupsManager().getDefault());
    }

}
