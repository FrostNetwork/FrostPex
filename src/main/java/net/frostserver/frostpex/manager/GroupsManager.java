package net.frostserver.frostpex.manager;

import com.google.common.collect.Lists;
import net.frostserver.frostpex.FrostPermissions;
import net.frostserver.frostpex.groups.Group;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;

public abstract class GroupsManager extends ArrayList<Group> {

    public void writeFromConfig() {
        FrostPermissions.getInstance().getConfig().getConfigurationSection("groups");
    }

    public static GroupsManager init() {
        return ((GroupsManager) new ArrayList<Group>());
    }

}
