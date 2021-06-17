package com.leo.lobby;

import org.bukkit.ChatColor;

public class Utils {

	public static String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('§', message);
	}
	
	public static String colorizeConfig(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}
