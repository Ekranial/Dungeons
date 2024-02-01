package lycoris.dungeons.commands;

import lycoris.dungeons.utils.StoreYaml;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;

import static lycoris.dungeons.utils.StoreYaml.StoreData;

public class SavePlayersData implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!commandSender.getName().equals("Ekran1al") && !commandSender.getName().equals("CONSOLE")) {
            return false;
        }

        try {
            StoreData();
            commandSender.sendMessage("Data saved!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
