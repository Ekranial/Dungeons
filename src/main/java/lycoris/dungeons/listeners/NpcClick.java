package lycoris.dungeons.listeners;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import lycoris.dungeons.utils.MobSpawner;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.*;

import static lycoris.dungeons.Dungeons.dungeon_passing;

//import static lycoris.dungeons.Dungeons.WG;

public class NpcClick implements Listener {

    private static void copyFileStructure(File source, File target) {
        try {
            ArrayList<String> ignore = new ArrayList<>(Arrays.asList("uid.dat", "session.lock"));
            if (!ignore.contains(source.getName())) {
                if (source.isDirectory()) {
                    if (!target.exists())
                        if (!target.mkdirs())
                            throw new IOException("Couldn't create world directory!");
                    String[] files = source.list();
                    assert files != null;
                    for (String file : files) {
                        File srcFile = new File(source, file);
                        File destFile = new File(target, file);
                        copyFileStructure(srcFile, destFile);
                    }
                } else {
                    InputStream in = Files.newInputStream(source.toPath());
                    OutputStream out = Files.newOutputStream(target.toPath());
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = in.read(buffer)) > 0)
                        out.write(buffer, 0, length);
                    in.close();
                    out.close();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void copyWorld(World originalWorld, String newWorldName) {
        copyFileStructure(originalWorld.getWorldFolder(), new File(Bukkit.getWorldContainer(), newWorldName));
        new WorldCreator(newWorldName).createWorld();
    }

    @EventHandler
    public static void onNpcCLick(NPCRightClickEvent event) throws IOException {
        if (event.getNPC().getId() == 0) {
            Calendar cl = Calendar.getInstance();
            cl.setTimeZone(TimeZone.getTimeZone("UTC"));
            if ((cl.get(Calendar.MINUTE) >= 0 && cl.get(Calendar.MINUTE) < 99) || (cl.get(Calendar.MINUTE) >= 30 && (cl.get(Calendar.MINUTE) < 32))) {
                String newName = "dungeon_1_" + event.getClicker().getName();
                copyWorld(Objects.requireNonNull(Bukkit.getWorld("dungeon_1")), newName);

                Bukkit.getWorld(newName).setDifficulty(Difficulty.HARD);

                RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();

                RegionManager regions = container.get(BukkitAdapter.adapt(Objects.requireNonNull(Bukkit.getWorld(newName))));
                regions.addRegion(new ProtectedCuboidRegion(newName, BlockVector3.at(-56, 97, -20), BlockVector3.at(4, 111, 20)));

                regions.getRegion(newName).setFlag(Flags.BLOCK_BREAK, StateFlag.State.DENY);
                regions.getRegion(newName).setFlag(Flags.BLOCK_PLACE, StateFlag.State.DENY);
                regions.getRegion(newName).setFlag(Flags.CHEST_ACCESS, StateFlag.State.ALLOW);

                event.getClicker().teleport(new Location(Bukkit.getWorld(newName), 0, 100, 0, 90, 0));
                event.getClicker().sendMessage(ChatColor.GREEN + "Телепортация в данж!");

                HashMap<String, Integer> mobs = new HashMap<>();
                dungeon_passing.put(event.getClicker().getWorld().getName(), mobs);

                Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("Dungeons"), new Runnable() {
                    @Override
                    public void run() {
                        MobSpawner.dg1_1(event.getClicker());
                    }
                }, 100);

            } else {
                if (cl.get(Calendar.MINUTE) < 30) {
                    event.getClicker().sendMessage(ChatColor.RED + "Данж станет доступным через " +
                            ChatColor.GOLD + (30 - cl.get(Calendar.MINUTE)) +
                            ChatColor.RED + " мин");
                } else {
                    event.getClicker().sendMessage(ChatColor.RED + "Данж станет доступным через " +
                            ChatColor.GOLD + (60 - cl.get(Calendar.MINUTE)) +
                            ChatColor.RED + " мин");
                }
            }

        }
    }
}
