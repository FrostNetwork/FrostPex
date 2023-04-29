package net.frostserver.frostpex.manager;

import com.google.common.collect.Lists;
import lombok.Getter;
import net.frostserver.frostpex.FrostPermissions;
import net.frostserver.frostpex.groups.Group;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;

public abstract class GroupsManager extends ArrayList<Group> {

    public void writeFromConfig() {
        FrostPermissions.getInstance().getConfig().getConfigurationSection("groups").getKeys(false).forEach(g -> {
            ConfigurationSection section = FrostPermissions.getInstance().getConfig().getConfigurationSection("groups." + g);

            this.add(new Group(
                    g,
                    section.getString("name"),
                    section.getString("prefix"),
                    section.getString("color"),
                    section.getBoolean("default")
            ));
        });
    }

    public Group getDefault() {
        return this.stream().filter(Group::isDefault).findFirst().orElse(null);
    }

    public static GroupsManager init() {
        return ((GroupsManager) new ArrayList<Group>());
    }

}
