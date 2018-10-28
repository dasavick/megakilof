package pl.daffit.megakilof;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import pl.daffit.megakilof.command.DajkilofaCommand;
import pl.daffit.megakilof.command.MegakilofCommand;
import pl.daffit.megakilof.listener.InventoryClickListener;

import java.util.Collections;

public class MegaKilofPlugin extends JavaPlugin {

    private Inventory megaInventory;
    private ItemStack megaKilof;

    public Inventory getMegaInventory() {
        return megaInventory;
    }

    public ItemStack getMegaKilof() {
        return megaKilof;
    }

    @Override
    public void onEnable() {

        // mega kilof
        megaInventory = Bukkit.createInventory(null, 27, ChatColor.translateAlternateColorCodes('&', "&a&lCRAF&f&lTING"));
        megaInventory.setItem(3, new ItemStack(Material.DIAMOND_BLOCK));
        megaInventory.setItem(4, new ItemStack(Material.DIAMOND_BLOCK));
        megaInventory.setItem(5, new ItemStack(Material.DIAMOND_BLOCK));
        megaInventory.setItem(13, new ItemStack(Material.STICK));
        megaInventory.setItem(22, new ItemStack(Material.STICK));

        // mega kilof
        this.megaKilof = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta megaMeta = this.megaKilof.getItemMeta();
        megaMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lMEGA &f&lKILOF"));
        megaMeta.setLore(Collections.singletonList("Kilof Zostal Stworzony z kos z csgo"));
        megaMeta.addEnchant(Enchantment.DIG_SPEED, 10, true);
        megaMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
        megaMeta.addEnchant(Enchantment.DURABILITY, 10, true);
        this.megaKilof.setItemMeta(megaMeta);
        
        // mega kilof
        ShapedRecipe megaRecipe = new ShapedRecipe(megaKilof).shape("DDD", "ASA", "ASA");
        megaRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
        megaRecipe.setIngredient('A', Material.AIR);
        megaRecipe.setIngredient('S', Material.STICK);
        this.getServer().addRecipe(megaRecipe);

        // mega kilof
        this.getCommand("megakilof").setExecutor(new MegakilofCommand(this));
        this.getCommand("dajkilofa").setExecutor(new DajkilofaCommand(this));

        // mega kilof
        this.getServer().getPluginManager().registerEvents(new InventoryClickListener(this), this);
    }
}
