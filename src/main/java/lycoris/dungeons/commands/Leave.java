package lycoris.dungeons.commands;

import lycoris.dungeons.utils.RemoveDungeon;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import static lycoris.dungeons.Dungeons.dungeon_passing;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class Leave implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        try {
            if (Bukkit.getPlayer(commandSender.getName()).getWorld().getName().equals("dungeon_1_" + commandSender.getName())) {
                dungeon_passing.remove(Bukkit.getPlayer(commandSender.getName()));
                RemoveDungeon.RemoveDg("dungeon_1_" + commandSender.getName(), Bukkit.getPlayer(commandSender.getName()), new Location(Bukkit.getWorld("world"), 1053.5, 96, 1190.5, 108.3f, 1.3f));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
