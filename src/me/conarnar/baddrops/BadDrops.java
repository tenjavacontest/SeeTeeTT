package me.conarnar.baddrops;

import java.util.Random;

import org.bukkit.plugin.java.JavaPlugin;

public class BadDrops extends JavaPlugin {
	private Random rand = new Random();
	public double odds;
	
	public void onEnable() {
		// registering listener
		getServer().getPluginManager().registerEvents(new BadDropsListener(this), this);
		
		// getting config
		odds = getConfig().getDouble("odds", 0.06);
		
		// checking if the value given for the config is valid
		if (odds < 0) odds = 0;
		else if (odds > 1) odds = 1;
		
		// saving to config the value of odds
		// if it wasn't given, or there was no config file, this will create one
		getConfig().set("odds", odds);
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
