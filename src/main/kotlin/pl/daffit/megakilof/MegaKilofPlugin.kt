package pl.daffit.megakilof

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.plugin.java.JavaPlugin
import pl.daffit.megakilof.command.DajkilofaCommand
import pl.daffit.megakilof.command.MegakilofCommand
import java.util.*

class MegaKilofPlugin : JavaPlugin(), Listener {

    var megaInventory: Inventory? = null
        private set
    var megaItem: ItemStack? = null
        private set

    override fun onEnable() {

        // create mega inventory
        this.megaInventory = Bukkit.createInventory(null, 27, MEGA_GUI_TITLE)
        this.megaInventory!!.setItem(3, ItemStack(Material.DIAMOND_BLOCK))
        this.megaInventory!!.setItem(4, ItemStack(Material.DIAMOND_BLOCK))
        this.megaInventory!!.setItem(5, ItemStack(Material.DIAMOND_BLOCK))
        this.megaInventory!!.setItem(13, ItemStack(Material.STICK))
        this.megaInventory!!.setItem(22, ItemStack(Material.STICK))

        // create mega item
        this.megaItem = ItemStack(Material.DIAMOND_PICKAXE)
        val megaMeta = this.megaItem!!.itemMeta
        megaMeta.displayName = MEGA_ITEM_NAME
        megaMeta.lore = MEGA_ITEM_LORE
        megaMeta.addEnchant(Enchantment.DIG_SPEED, 10, true)
        megaMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true)
        megaMeta.addEnchant(Enchantment.DURABILITY, 10, true)
        this.megaItem!!.itemMeta = megaMeta

        // register recipes
        val megaRecipe = ShapedRecipe(this.megaItem!!).shape("DDD", "ASA", "ASA")
        megaRecipe.setIngredient('D', Material.DIAMOND_BLOCK)
        megaRecipe.setIngredient('A', Material.AIR)
        megaRecipe.setIngredient('S', Material.STICK)
        this.server.addRecipe(megaRecipe)

        // register commands
        this.getCommand("megakilof").executor = MegakilofCommand(this)
        this.getCommand("dajkilofa").executor = DajkilofaCommand()

        // register events
        this.server.pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun onInventoryClickEvent(megaEvent: InventoryClickEvent) {

        if (megaEvent.rawSlot != megaEvent.slot) {
            return
        }

        if (MEGA_GUI_TITLE != megaEvent.clickedInventory.name) {
            return
        }

        megaEvent.isCancelled = true
    }

    companion object {
        val MEGA_GUI_TITLE = ChatColor.translateAlternateColorCodes('&', "&a&lCRAF&f&lTING")
        val MEGA_ITEM_NAME = ChatColor.translateAlternateColorCodes('&', "&a&lMEGA &f&lKILOF")
        val MEGA_ITEM_LORE = Collections.unmodifiableList(listOf("Kilof Zostal Stworzony z kos z csgo"))
        val CONSOLE_DENY_MESSAGE = ChatColor.translateAlternateColorCodes('&', "&cKonsola Nie Moze Kilofa")
        val PERMISSION_DENY_MESSAGE = ChatColor.translateAlternateColorCodes('&', "&cKomenda Tylko Dla Adminow")
        val ADMIN_PERMISSION = "KILOF.ADMIN"
    }
}
