package lycoris.dungeons.listeners;

import lycoris.dungeons.utils.InvTools;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.block.ShulkerBox;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import java.io.IOException;

import static java.util.Objects.requireNonNull;

public class ChestClick implements Listener {

    @EventHandler
    public static void onChestClick(PlayerInteractEvent event) throws IOException {
        try {
            if (event.getPlayer().getName().equals("Ekran1al")) {
                ShulkerBox chest = (ShulkerBox) event.getClickedBlock().getState();
                Inventory inv = chest.getInventory();

                System.out.println(InvTools.toBase64(inv));
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
