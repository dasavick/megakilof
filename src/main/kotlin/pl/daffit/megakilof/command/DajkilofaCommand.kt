package pl.daffit.megakilof.command

import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import pl.daffit.megakilof.MegaKilofPlugin

class DajkilofaCommand : CommandExecutor {

    override fun onCommand(megaSender: CommandSender, megaCommand: Command, megaLabel: String, megaArguments: Array<String>): Boolean {

        if (megaSender !is Player) {
            megaSender.sendMessage(MegaKilofPlugin.CONSOLE_DENY_MESSAGE)
            return true
        }

        if (!megaSender.hasPermission(MegaKilofPlugin.ADMIN_PERMISSION)) {
            megaSender.sendMessage(MegaKilofPlugin.PERMISSION_DENY_MESSAGE)
            return true
        }

        val inventory = megaSender.inventory
        inventory.addItem(ItemStack(Material.DIAMOND_BLOCK, 3), ItemStack(Material.STICK, 2))

        return true
    }
}
