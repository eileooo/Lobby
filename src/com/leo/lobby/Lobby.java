package com.leo.lobby;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class Lobby {
	
	private YamlConfiguration config;
	private Location location;
	private Main plugin;
	private String message;
	
	public Lobby(Main plugin, YamlConfiguration config) {
		this.config = config;
		this.plugin = plugin;

		loadLocation();
	}
	
	private void loadLocation() {
		if (config.isConfigurationSection("lobby")) {
			String worldName = config.getString("lobby.worldName");
			
			int x = config.getInt("lobby.x");
			int y = config.getInt("lobby.y");
			int z = config.getInt("lobby.z");
			
			World loadedWorld = Bukkit.createWorld(new WorldCreator(worldName));
			this.location = new Location(loadedWorld, x, y, z);
			
			Bukkit.getConsoleSender().sendMessage(Utils.colorize("§a[Lobby] Localização carregada com sucesso!"));
			
			this.message = config.getString("lobby.message");
			
		} else {
			Bukkit.getConsoleSender().sendMessage(Utils.colorize("§c[Lobby] Lobby não encontrado, criando seção."));
			config.createSection("lobby");
			config.set("lobby.worldName", "");
			config.set("lobby.message", "&aTeletransportando para o lobby...");
			config.set("lobby.x", 0);
			config.set("lobby.y", 0);
			config.set("lobby.z", 0);
			
			try {
				config.save(new File(plugin.getDataFolder(), "config.yml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void teleport(Player player) {
		player.teleport(location);
		player.sendMessage(Utils.colorizeConfig(this.message));
	}
	
	public Location getLocation() {
		return location;
	}
	
	
}
