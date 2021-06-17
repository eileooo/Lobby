package com.leo.lobby;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	private YamlConfiguration configuration;
	private Lobby lobby;
	
	public void onEnable() {
		loadConfig();
		this.lobby = new Lobby(this, this.configuration);
		getCommand("lobby").setExecutor(new LobbyCommand(this));
		Bukkit.getPluginManager().registerEvents(new Listeners(this), this);
	}
	
	private void loadConfig() {
		File file = new File(getDataFolder(), "config.yml");
		
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			saveResource("config.yml", false);
		}
		
		this.configuration = new YamlConfiguration();
		
			try {
				configuration.load(file);
			} catch (IOException | InvalidConfigurationException e) {
				e.printStackTrace();
			} 
				
	}
	
	public Lobby getLobby() {
		return lobby;
	}
	

}
