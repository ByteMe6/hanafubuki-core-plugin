package org.example;

import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class TpaCommand implements CommandExecutor {

    private final Main plugin;

    public TpaCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player player)) return true;

        if (args.length < 1) {
            player.sendMessage("§c/tpa <player>");
            return true;
        }

        Player target = player.getServer().getPlayer(args[0]);

        if (target == null) {
            player.sendMessage("§cИгрок не найден");
            return true;
        }

        TeleportRequestManager.requests.put(target,
                new TeleportRequestManager.Request(player, target)
        );

        player.sendMessage("§aЗапрос отправлен");

        TextComponent msg = new TextComponent("§e" + player.getName() + " хочет телепортироваться к вам\n");

        TextComponent accept = new TextComponent("§a[ПРИНЯТЬ]");
        accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaaccept"));

        TextComponent deny = new TextComponent(" §c[ОТКЛОНИТЬ]");
        deny.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpadeny"));

        msg.addExtra(accept);
        msg.addExtra(deny);

        target.spigot().sendMessage(msg);

        return true;
    }
}