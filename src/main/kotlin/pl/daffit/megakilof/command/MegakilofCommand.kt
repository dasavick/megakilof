package pl.daffit.megakilof.command

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import pl.daffit.megakilof.MegaKilofPlugin

class MegakilofCommand(private val megaPlugin: MegaKilofPlugin) : CommandExecutor {

    override fun onCommand(megaSender: CommandSender, megaCommand: Command, megaLabel: String, megaArguments: Array<String>): Boolean {

        if (megaSender !is Player) {
            megaSender.sendMessage(MegaKilofPlugin.CONSOLE_DENY_MESSAGE)
            return true
        }

        megaSender.openInventory(this.megaPlugin.megaInventory)
        return true
    }
}
