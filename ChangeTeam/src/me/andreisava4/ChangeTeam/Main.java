package me.andreisava4.ChangeTeam;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {
	
	
	public Inventory inv;
	
	 
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		createInv();

	}

	@Override
	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("changeteam")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You cannot change teams, console!");
				return true;
			}
			Player player = (Player) sender;
			// open the GUI
			player.openInventory(inv);
			return true;
		}
		return false;
	}

	@EventHandler()
	public void onClick(InventoryClickEvent event) {
		if (!event.getInventory().equals(inv))
			return;
		if (event.getCurrentItem() == null) return;
		if (event.getCurrentItem().getItemMeta() == null) return;
		if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
		
		event.setCancelled(true);
		
		Player player = (Player) event.getWhoClicked();
		
		if (event.getSlot() == 0 && event.getCurrentItem().getType() == Material.BLUE_CONCRETE) {
			// blue team
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.BLUE);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team!");
		}
		if (event.getSlot() == 1 && event.getCurrentItem().getType() == Material.RED_CONCRETE) {
			// red team
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.RED);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team!");
		}
		if (event.getSlot() == 2 && event.getCurrentItem().getType() == Material.GREEN_CONCRETE) {
			// green team
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.GREEN);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team!");
		}
		if (event.getSlot() == 3 && event.getCurrentItem().getType() == Material.ORANGE_CONCRETE) {
			// orange team
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.ORANGE);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team!");
		}
		if (event.getSlot() == 4 && event.getCurrentItem().getType() == Material.PURPLE_CONCRETE) {
			// purple team
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.PURPLE);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team!");
		}
		if (event.getSlot() == 5 && event.getCurrentItem().getType() == Material.CYAN_CONCRETE) {
			// cyan team
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.AQUA);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team!");
		}
		if (event.getSlot() == 6 && event.getCurrentItem().getType() == Material.BLACK_CONCRETE) {
			// black team
			ItemStack[] armor = player.getEquipment().getArmorContents();
			armor = changeColor(armor, Color.BLACK);
			player.getEquipment().setArmorContents(armor);
			player.sendMessage(ChatColor.GOLD + "You changed your team!");
		}
		if (event.getSlot() == 8) {
			// blue team
			player.closeInventory();
		}
		
		return;
		
		
	}
	
	public ItemStack[] changeColor(ItemStack[] a, Color color) {
		for (ItemStack item: a) {
			try {
				if (item.getType() == Material.LEATHER_BOOTS || item.getType() == Material.LEATHER_CHESTPLATE || 
						item.getType() == Material.LEATHER_LEGGINGS || item.getType() == Material.LEATHER_HELMET) {
				LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
				meta.setColor(color);
				item.setItemMeta(meta);
				
				
			}
					} catch (Exception e) {
						// do nothing
					}
		}
		
		return a;
	}
	
	
	
	
	
	
	public void createInv() {
		
		inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "" + ChatColor.BOLD + "Select team");
		
		ItemStack item = new ItemStack(Material.BLUE_CONCRETE);
		ItemMeta meta = item.getItemMeta();
		
		//Blue team
		meta.setDisplayName(ChatColor.DARK_BLUE + "Blue team");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Click to join team!");
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(0, item);
		
		//Red team
		item.setType(Material.RED_CONCRETE);
		meta.setDisplayName(ChatColor.DARK_RED + "Red team");
		item.setItemMeta(meta);
		inv.setItem(1, item);
		
		//Green team
		item.setType(Material.GREEN_CONCRETE);
		meta.setDisplayName(ChatColor.DARK_GREEN + "Green team");
		item.setItemMeta(meta);
		inv.setItem(2, item);
		
		//Orange team
		item.setType(Material.ORANGE_CONCRETE);
		meta.setDisplayName(ChatColor.GOLD + "Orange team");
		item.setItemMeta(meta);
		inv.setItem(3, item);
		
		//purple team
		item.setType(Material.PURPLE_CONCRETE);
		meta.setDisplayName(ChatColor.DARK_PURPLE+ "Purple team");
		item.setItemMeta(meta);
		inv.setItem(4, item);
		
		//cyan team
		item.setType(Material.CYAN_CONCRETE);
		meta.setDisplayName(ChatColor.AQUA + "Cyan team");
		item.setItemMeta(meta);
		inv.setItem(5, item);
		
		//black team
		item.setType(Material.BLACK_CONCRETE);
		meta.setDisplayName(ChatColor.DARK_GRAY + "Black team");
		item.setItemMeta(meta);
		inv.setItem(6, item);
		
		//close button
		item.setType(Material.BARRIER);
		meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close menu");
		lore.clear();
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(8, item);
	}
	
	
}


















