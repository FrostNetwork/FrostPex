package net.frostserver.frostpex;

import com.google.common.eventbus.EventBus;
import lombok.Getter;
import net.frostserver.frostpex.event.plugin.base.PluginDisableEvent;
import net.frostserver.frostpex.event.plugin.base.PluginEnableEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class FrostPermissions extends JavaPlugin {

    @Getter private static FrostPermissions instance;

    @Getter private EventBus eventBus;

    @Override
    public void onEnable() {
        FrostPermissions.instance = this;

        this.eventBus = new EventBus();
        this.eventBus.register(this);

        PluginEnableEvent e = new PluginEnableEvent();
        this.eventBus.post(e);
        if(e.isCancelled()) {
            FrostPermissions.disable();
            return;
        }

        Bukkit.getConsoleSender().sendMessage(FrostPermissions.getPrefix() + "Plugin abilitato!");
    }

    @Override
    public void onDisable() {
        PluginDisableEvent e = new PluginDisableEvent();
        this.eventBus.post(e);
        if(e.isCancelled()) {
            FrostPermissions.enable();
            return;
        }

        Bukkit.getConsoleSender().sendMessage(FrostPermissions.getPrefix() + "Plugin disabilitato!");
    }

    public static void enable() {
        Bukkit.getPluginManager().enablePlugin(FrostPermissions.getInstance());
    }

    public static void disable() {
        Bukkit.getPluginManager().disablePlugin(FrostPermissions.getInstance());
    }

    public static void reload() {
        FrostPermissions.disable();
        FrostPermissions.enable();
    }

    public static String getPrefix() {
        return ChatColor.AQUA + "[FrostPex] " + ChatColor.RESET;
    }
}
