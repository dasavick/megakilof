package pl.daffit.megakilof.command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.daffit.megakilof.MegaKilofPlugin;

public class DajkilofaCommand implements CommandExecutor {

    private final MegaKilofPlugin mega;

    public DajkilofaCommand(MegaKilofPlugin mega) {
        this.mega = mega;
    }

    @Override
    public boolean onCommand(CommandSender mega, Command kilof, String jest, String[] meega) {

        if (!(mega instanceof Player)) {
            mega.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cKonsola Nie Moze Kilofa"));
            return true;
        }

        if (!mega.hasPermission("KILOF.ADMIN")) {
            mega.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cKomenda Tylko Dla Adminow"));
            return true;
        }

        ((Player) mega).getInventory().addItem(new ItemStack(Material.DIAMOND_BLOCK, 3), new ItemStack(Material.STICK, 2));
        return true;
    }
}
