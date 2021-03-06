package net.minefs.dmtk;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Lmao extends JavaPlugin {
	
	Map<String, String> map = new ConcurrentHashMap<>();
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Listener() {
			@EventHandler
			public void onClick(InventoryClickEvent e) {
				Inventory inv = e.getClickedInventory();

				if (inv.getHolder() != null && inv.getHolder() instanceof GuiInventory)
					((GuiInventory) inv.getHolder()).onClick(e);
			}
		}, this);

		Bukkit.getScheduler().runTaskAsynchronously(this, () -> {
			Bukkit.broadcast("khang cho de", null);
		});
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			KhangSucVat gui = new KhangSucVat(0);
			p.openInventory(gui.getInventory());
		}
		return true;
	}
}
