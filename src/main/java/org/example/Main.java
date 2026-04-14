package org.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.example.bot.BotListener;
import org.example.plugin.MessageEater;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private JDA jda;

    @Override
    public void onEnable() {
        String token = Settings.getToken();

        try {
            jda = JDABuilder.createDefault(token)
                    .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                    .addEventListeners(new BotListener())
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        getServer().getPluginManager().registerEvents(new MessageEater(jda), this);

        getLogger().info("Плагин и Бот успешно запущены!");
    }

    @Override
    public void onDisable() {
        if (jda != null) {
            jda.shutdownNow();
        }
    }
}