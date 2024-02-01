package lycoris.dungeons.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static lycoris.dungeons.Dungeons.player_levels;

public class MyLvl implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            return false;
        }

        if (!player_levels.containsKey(commandSender.getName())) {
            commandSender.sendMessage("Уровень: 0");
            commandSender.sendMessage("Опыт: 0");
        } else {
            commandSender.sendMessage("Уровень: " + player_levels.get(commandSender.getName()).get("lvl"));
            commandSender.sendMessage("Опыт: " + player_levels.get(commandSender.getName()).get("xp"));
        }

        return false;
    }
}
