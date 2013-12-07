package me.conarnar.extradrops;

import java.util.Random;

import org.bukkit.plugin.java.JavaPlugin;

public class ExtraDrops extends JavaPlugin {
	public Random rand = new Random();
	
	public void onEnable() {
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new ExtraDropsListener(this), this);
	}
	
	/**
	 * Random number generator to determine whether something will happen.
	 * @param odds - The chance that this will return true.
	 * @return Whether the randomly generated number is less than "odds".
	 * @throws IllegalArgumentException If odds is not between 0 and 1.
	 */
	public boolean chance(double odds) {
		if (odds < 0 || odds > 1) {
			throw new IllegalArgumentException("odds must be between 0 and 1");
		}
		
		return rand.nextDouble() < odds;
	}
}
