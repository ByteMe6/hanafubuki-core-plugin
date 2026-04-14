package org.example.plugin;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import net.dv8tion.jda.api.JDA;
import org.example.bot.BotListener;


public class MessageEater implements Listener {

    public MessageEater(JDA jda){
        this.jda = jda;
    }

    private JDA jda;

    // будет кушать сообщения из чата майнкарфта
    @EventHandler
        public void onPlayerChat(AsyncChatEvent event) {
            String playerNickname = event.getPlayer().getName();
            String plainMsg = PlainTextComponentSerializer.plainText().serialize(event.message());
            // [nickname] message
            String formattedDiscordMsg = String.format("[%s] %s", playerNickname, plainMsg);

            BotListener.sendMessage(formattedDiscordMsg, jda);
        }
}

