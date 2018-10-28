package pl.daffit.megakilof;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import pl.daffit.megakilof.command.DajkilofaCommand;
import pl.daffit.megakilof.command.MegakilofCommand;

import java.util.Collections;
import java.util.List;

public class MegaKilofPlugin extends JavaPlugin implements Listener {

    public static final String MEGA_GUI_TITLE = ChatColor.translateAlternateColorCodes('&', "&a&lCRAF&f&lTING");
    public static final String MEGA_ITEM_NAME = ChatColor.translateAlternateColorCodes('&', "&a&lMEGA &f&lKILOF");
    public static final List<String> MEGA_ITEM_LORE = Collections.unmodifiableList(Collections.singletonList("Kilof Zostal Stworzony z kos z csgo"));
    public static final String CONSOLE_DENY_MESSAGE = ChatColor.translateAlternateColorCodes('&', "&cKonsola Nie Moze Kilofa");
    public static final String PERMISSION_DENY_MESSAGE = ChatColor.translateAlternateColorCodes('&', "&cKomenda Tylko Dla Adminow");
    public static final String ADMIN_PERMISSION = "KILOF.ADMIN";

    private Inventory megaInventory;
    private ItemStack megaItem;

    public Inventory getMegaInventory() {
        return this.megaInventory;
    }

    public ItemStack getMegaItem() {
        return this.megaItem;
    }

    @Override
    public void onEnable() {

        // create mega inventory
        this.megaInventory = Bukkit.createInventory(null, 27, MEGA_GUI_TITLE);
        this.megaInventory.setItem(3, new ItemStack(Material.DIAMOND_BLOCK));
        this.megaInventory.setItem(4, new ItemStack(Material.DIAMOND_BLOCK));
        this.megaInventory.setItem(5, new ItemStack(Material.DIAMOND_BLOCK));
        this.megaInventory.setItem(13, new ItemStack(Material.STICK));
        this.megaInventory.setItem(22, new ItemStack(Material.STICK));

        // create mega item
        this.megaItem = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta megaMeta = this.megaItem.getItemMeta();
        megaMeta.setDisplayName(MEGA_ITEM_NAME);
        megaMeta.setLore(MEGA_ITEM_LORE);
        megaMeta.addEnchant(Enchantment.DIG_SPEED, 10, true);
        megaMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
        megaMeta.addEnchant(Enchantment.DURABILITY, 10, true);
        this.megaItem.setItemMeta(megaMeta);

        // register recipes
        ShapedRecipe megaRecipe = new ShapedRecipe(this.megaItem).shape("DDD", "ASA", "ASA");
        megaRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
        megaRecipe.setIngredient('A', Material.AIR);
        megaRecipe.setIngredient('S', Material.STICK);
        this.getServer().addRecipe(megaRecipe);

        // register commands
        this.getCommand("megakilof").setExecutor(new MegakilofCommand(this));
        this.getCommand("dajkilofa").setExecutor(new DajkilofaCommand(this));

        // register events
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent megaEvent) {

        if (megaEvent.getRawSlot() != megaEvent.getSlot()) {
            return;
        }

        if (!MEGA_GUI_TITLE.equals(megaEvent.getClickedInventory().getName())) {
            return;
        }

        megaEvent.setCancelled(true);
    }
}
