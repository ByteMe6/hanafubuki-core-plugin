package org.example.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.example.Settings;

public class BotListener extends ListenerAdapter {

    private static final long CHANNEL_ID = Settings.getChannelId();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        if (event.getChannel().getIdLong() != CHANNEL_ID) return;

//        String discordName = event.getAuthor().getName();
        String discordName = event.getMember() != null ? event.getMember().getEffectiveName() : event.getAuthor().getEffectiveName();
        String message = event.getMessage().getContentRaw();

//        if (message.equalsIgnoreCase("!ping")) {
//            event.getChannel().sendMessage("Pong!").queue();
//            return;
//        }

        Component minecraftMessage = Component.text("(D) ", NamedTextColor.GRAY)
                .append(Component.text("[" + discordName + "] ", NamedTextColor.BLUE))
                .append(Component.text(message, NamedTextColor.WHITE));

        Bukkit.broadcast(minecraftMessage);
    }

    public static void sendMessage(String msg, JDA jda) {
        TextChannel channel = jda.getTextChannelById(CHANNEL_ID);

        if (channel != null) {
            channel.sendMessage(msg).queue();
        } else {
            System.out.println("Channel is not found: " + CHANNEL_ID);
        }
    }
}