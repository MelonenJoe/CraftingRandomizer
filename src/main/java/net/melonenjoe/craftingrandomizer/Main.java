package net.melonenjoe.craftingrandomizer;

import net.melonenjoe.craftingrandomizer.command.LoveCommand;
import net.melonenjoe.craftingrandomizer.listener.CraftingListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main getPlugin() {
        return getPlugin(Main.class);
    }

    @Override
    public void onEnable() {

        Bukkit.getServer().getPluginManager().registerEvents(new CraftingListener(), this);

        this.getCommand("love").setExecutor(new LoveCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
