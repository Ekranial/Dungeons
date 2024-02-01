package lycoris.dungeons.utils;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.codehaus.plexus.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Objects;

public class RemoveDungeon {

    public static void RemoveDg(String world_name, Player player, Location tp_loc) throws IOException {
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();

        RegionManager regions = container.get(BukkitAdapter.adapt(Objects.requireNonNull(Bukkit.getWorld(world_name))));
        assert regions != null;
        regions.removeRegion(world_name);

        player.teleport(tp_loc);
        Bukkit.unloadWorld(world_name, true);
        FileUtils.deleteDirectory(new File(FileSystems.getDefault().getPath("./dungeon_1_" + player.getName()).toUri()));
    }

}
