package com.leo.lobby;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LobbyCommand implements CommandExecutor{

	private Main plugin;
	
	public LobbyCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg2, String[] args) {
		if (!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if (command.getName().equalsIgnoreCase("lobby")) {
			plugin.getLobby().teleport(player);
		}
		return false;
	}
	
}
