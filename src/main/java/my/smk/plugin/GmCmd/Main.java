package my.smk.plugin.GmCmd;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	public final Logger log = Logger.getLogger("Minecraft");
	public String PluginName = getDescription().getName();
	public String ChatPrefix = ChatColor.YELLOW + "[" + ChatColor.GREEN + PluginName + ChatColor.YELLOW + "] " + ChatColor.WHITE;
	public String ErroPrefix = ChatColor.WHITE + "[" + ChatColor.RED + PluginName + ChatColor.WHITE + "] " + ChatColor.WHITE;

	public void onEnable() {
	}

	public void onDisable() {
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("gm")) {// gm”½“]cmd
			if (sender instanceof Player) {
				if ((sender.hasPermission("GmCmd")) || (sender.isOp())) {
					Player player = (Player) sender;
					GameMode gm = player.getGameMode();
					if (gm == GameMode.CREATIVE) {
						player.setGameMode(GameMode.SURVIVAL);
					} else if (gm == GameMode.SURVIVAL) {
						player.setGameMode(GameMode.CREATIVE);
					} else {
						player.setGameMode(GameMode.CREATIVE);
					}
					return true;
				} else {
					sender.sendMessage(this.ErroPrefix + "You don't have permission to use gm command!");
				}
			} else {
				sender.sendMessage("You have to use it in the game.(Player)");
			}
		}
		if (cmd.getName().equalsIgnoreCase("gm0") || cmd.getName().equalsIgnoreCase("gm1") || cmd.getName().equalsIgnoreCase("gm2")
				|| cmd.getName().equalsIgnoreCase("gm3")) {
			if (sender instanceof Player) {
				if ((sender.hasPermission("GmCmd")) || (sender.isOp())) {
					Player player = (Player) sender;
					GameMode gm = player.getGameMode();
					if (cmd.getName().equalsIgnoreCase("gm0")) {
						gm = GameMode.SURVIVAL;
					}
					if (cmd.getName().equalsIgnoreCase("gm1")) {
						gm = GameMode.CREATIVE;
					}
					if (cmd.getName().equalsIgnoreCase("gm2")) {
						gm = GameMode.ADVENTURE;
					}
					if (cmd.getName().equalsIgnoreCase("gm3")) {
						gm = GameMode.SPECTATOR;
					}
					player.setGameMode(gm);
					return true;
				} else {
					sender.sendMessage(this.ErroPrefix + "You don't have permission to use gm command!");
				}
			} else {
				sender.sendMessage("You have to use it in the game.(Player)");
			}
		}
		return false;
	}
}
