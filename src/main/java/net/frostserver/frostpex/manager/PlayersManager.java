package net.frostserver.frostpex.manager;

import net.frostserver.frostpex.FrostPermissions;
import net.frostserver.frostpex.groups.Group;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;

public abstract class PlayersManager extends ArrayList<Group> {

    public void writeFromConfig() {
        FrostPermissions.getInstance().getConfig().getConfigurationSection("users").getKeys(false).forEach(u -> {
            ConfigurationSection section = FrostPermissions.getInstance().getConfig().getConfigurationSection("users." + u);
        });
    }

    public Group getDefault() {
        return this.stream().filter(Group::isDefault).findFirst().orElse(null);
    }

    public static PlayersManager init() {
        return ((PlayersManager) new ArrayList<Group>());
    }

}
