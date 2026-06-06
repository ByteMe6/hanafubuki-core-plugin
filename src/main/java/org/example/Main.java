package org.example;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("home").setExecutor(new HomeCommand(this));

        getCommand("tpa").setExecutor(new TpaCommand(this));
        getCommand("tpaaccept").setExecutor(new TpaAcceptCommand(this));
        getCommand("tpadeny").setExecutor(new TpaDenyCommand(this));

        getLogger().info("Plugin enabled");
    }
}