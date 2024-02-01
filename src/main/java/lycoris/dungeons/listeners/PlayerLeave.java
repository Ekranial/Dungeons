package lycoris.dungeons.listeners;

import lycoris.dungeons.utils.RemoveDungeon;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;;

import java.io.FileNotFoundException;
import java.io.IOException;

import static lycoris.dungeons.Dungeons.dungeon_passing;
import static lycoris.dungeons.utils.StoreYaml.StoreData;

public class PlayerLeave implements Listener {

    @EventHandler
    public static void onPLayerLeave(PlayerQuitEvent event) throws IOException {

        if (event.getPlayer().getWorld().getName().equals("dungeon_1_" + event.getPlayer().getName())) {
            dungeon_passing.remove(event.getPlayer().getWorld().getName());


            RemoveDungeon.RemoveDg("dungeon_1_" + event.getPlayer().getName(), event.getPlayer(), new Location(Bukkit.getWorld("world"), 1053.5, 96, 1190.5, 108.3f, 1.3f));
        }
    }
}
