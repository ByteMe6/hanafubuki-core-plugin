package org.example;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.boss.BarColor;

public class TpaAcceptCommand implements CommandExecutor {

    private final Main plugin;

    public TpaAcceptCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player target)) return true;

        var req = TeleportRequestManager.requests.get(target);
        if (req == null) return true;

        Player from = req.from;

        TeleportRequestManager.requests.remove(target);

        from.sendMessage("§aПринято");
        target.sendMessage("§aВы приняли запрос");

        TeleportEffects.start(
                from,
                plugin,
                target.getLocation(),
                "TPA к игроку",
                BarColor.GREEN
        );

        return true;
    }
}