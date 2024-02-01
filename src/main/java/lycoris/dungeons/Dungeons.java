package lycoris.dungeons;

import lycoris.dungeons.commands.CompleteDungeon;
import lycoris.dungeons.commands.Leave;
import lycoris.dungeons.commands.MyLvl;
import lycoris.dungeons.commands.SavePlayersData;
import lycoris.dungeons.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileNotFoundException;
import java.util.HashMap;

import static lycoris.dungeons.utils.ReadYaml.ReadData;
import static lycoris.dungeons.utils.SetLevelsXp.SetXp;
import static lycoris.dungeons.utils.StoreYaml.StoreData;

public final class Dungeons extends JavaPlugin {

    public static HashMap<String, HashMap<String, Integer>> dungeon_passing = new HashMap<>();
    public static HashMap<String, HashMap<String, Integer>> player_levels = new HashMap<>();
    public static HashMap<Integer, Integer> needed_xp = new HashMap<>();

    @Override
    public void onEnable() {

        SetXp();

        try {
            ReadData();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        for (World world : Bukkit.getWorlds()) {
            world.setDifficulty(Difficulty.HARD);
        }

        this.getCommand("leavedungeon").setExecutor(new Leave());
        this.getCommand("completedungeon").setExecutor(new CompleteDungeon());
        this.getCommand("savedata").setExecutor(new SavePlayersData());
        this.getCommand("mylvl").setExecutor(new MyLvl());

//        Bukkit.getPluginManager().registerEvents(new ChestClick(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeath(), this);
        Bukkit.getPluginManager().registerEvents(new NpcClick(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerLeave(), this);
        Bukkit.getPluginManager().registerEvents(new MobKill(), this);
    }

    @Override
    public void onDisable() {
        try {
            StoreData();
            System.out.println("DATA SAVED SUCCESFULLY!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
