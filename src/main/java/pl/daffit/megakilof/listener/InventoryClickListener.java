package pl.daffit.megakilof.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.daffit.megakilof.MegaKilofPlugin;

public class InventoryClickListener implements Listener {

    private final MegaKilofPlugin mega;
    
    public InventoryClickListener(MegaKilofPlugin mega) {
        this.mega = mega;
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent mega) {

        if (mega.getRawSlot() != mega.getSlot()) {
            return;
        }

        if (!this.mega.getMegaInventory().getName().equals(mega.getClickedInventory().getName())) {
            return;
        }

        mega.setCancelled(true);
    }
}
