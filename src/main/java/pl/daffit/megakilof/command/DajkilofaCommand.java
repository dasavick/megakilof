package pl.daffit.megakilof.command;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import pl.daffit.megakilof.MegaKilofPlugin;

public class DajkilofaCommand implements CommandExecutor {

    public DajkilofaCommand(MegaKilofPlugin megaPlugin) {
    }

    @Override
    public boolean onCommand(CommandSender megaSender, Command megaCommand, String megaLabel, String[] megaArguments) {

        if (!(megaSender instanceof Player)) {
            megaSender.sendMessage(MegaKilofPlugin.CONSOLE_DENY_MESSAGE);
            return true;
        }

        if (!megaSender.hasPermission(MegaKilofPlugin.ADMIN_PERMISSION)) {
            megaSender.sendMessage(MegaKilofPlugin.PERMISSION_DENY_MESSAGE);
            return true;
        }

        Player player = ((Player) megaSender);
        PlayerInventory inventory = player.getInventory();
        inventory.addItem(new ItemStack(Material.DIAMOND_BLOCK, 3), new ItemStack(Material.STICK, 2));

        return true;
    }
}
