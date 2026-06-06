package org.example.plugin;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Teleportation {

    public void teleport(Player player, Location location) {
        player.teleport(location);
        player.sendMessage("§aТелепорт выполнен!");
    }
}