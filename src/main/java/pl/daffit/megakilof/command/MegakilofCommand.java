package pl.daffit.megakilof.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.daffit.megakilof.MegaKilofPlugin;

public class MegakilofCommand implements CommandExecutor {

    private final MegaKilofPlugin mega;

    public MegakilofCommand(MegaKilofPlugin mega) {
        this.mega = mega;
    }

    @Override
    public boolean onCommand(CommandSender mega, Command kilof, String jest, String[] megaa) {

        if (!(mega instanceof Player)) {
            mega.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cKonsola Nie Moze Kilofa"));
            return true;
        }

        ((Player) mega).openInventory(this.mega.getMegaInventory());
        return true;
    }
}
