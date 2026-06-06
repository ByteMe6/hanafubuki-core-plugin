package org.example;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class TpaDenyCommand implements CommandExecutor {

    private final Main plugin;

    public TpaDenyCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player target)) return true;

        var req = TeleportRequestManager.requests.get(target);
        if (req == null) return true;

        Player from = req.from;

        TeleportRequestManager.requests.remove(target);

        from.sendMessage("§cИгрок отклонил запрос");

        return true;
    }
}