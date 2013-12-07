package me.conarnar.baddrops;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class BadDropsListener implements Listener {
	private final BadDrops plugin;
	
	public BadDropsListener(BadDrops drops) {
		plugin = drops;
	}
	
	/**
	 * Listens for EntityDeathEvent to know every time a mob dies.
	 * @param evt - The event to listen for.
	 */
	@EventHandler
	public void onEntityDeath(EntityDeathEvent evt) {
		if (plugin.chance(plugin.odds)) {
			
		}
	}
}
