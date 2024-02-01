package lycoris.dungeons.listeners;

import lycoris.dungeons.utils.RemoveDungeon;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.io.IOException;

import static lycoris.dungeons.Dungeons.dungeon_passing;

public class PlayerDeath implements Listener {

    @EventHandler
    public static void PlayerDead(EntityDamageEvent event) throws IOException {
        if (event.getEntity() instanceof Player player) {
            if (player.getWorld().getName().equals("dungeon_1_" + player.getName())) {

                if (player.getHealth() - event.getFinalDamage() <= 0) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "Ты умер в данже!");

                    dungeon_passing.remove(player);
                    RemoveDungeon.RemoveDg("dungeon_1_" + player.getName(), player, new Location(Bukkit.getWorld("world"), 1053.5, 96, 1190.5, 108.3f, 1.3f));
                }
            }
        }
    }
}
