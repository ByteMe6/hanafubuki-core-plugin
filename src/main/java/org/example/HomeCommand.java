package org.example;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.boss.BarColor;

public class HomeCommand implements CommandExecutor {

    private final Main plugin;

    public HomeCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player player)) return true;

        Location home = player.getRespawnLocation();

        if (home == null) {
            player.sendMessage("§cУ вас нет точки возрождения!");
            return true;
        }

        TeleportEffects.start(
                player,
                plugin,
                home,
                "Телепортация домой",
                BarColor.BLUE
        );

        return true;
    }
}