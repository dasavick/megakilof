package pl.daffit.megakilof.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.daffit.megakilof.MegaKilofPlugin;

public class MegakilofCommand implements CommandExecutor {

    private final MegaKilofPlugin megaPlugin;

    public MegakilofCommand(MegaKilofPlugin megaPlugin) {
        this.megaPlugin = megaPlugin;
    }

    @Override
    public boolean onCommand(CommandSender megaSender, Command megaCommand, String megaLabel, String[] megaArguments) {

        if (!(megaSender instanceof Player)) {
            megaSender.sendMessage(MegaKilofPlugin.CONSOLE_DENY_MESSAGE);
            return true;
        }

        ((Player) megaSender).openInventory(this.megaPlugin.getMegaInventory());
        return true;
    }
}
