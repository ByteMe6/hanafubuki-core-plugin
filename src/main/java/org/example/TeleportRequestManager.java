package org.example;

import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;

public class TeleportRequestManager {

    public static class Request {
        public Player from;
        public Player to;

        public Request(Player from, Player to) {
            this.from = from;
            this.to = to;
        }
    }

    public static Map<Player, Request> requests = new HashMap<>();
}