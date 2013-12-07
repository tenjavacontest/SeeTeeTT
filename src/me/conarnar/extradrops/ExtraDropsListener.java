package me.conarnar.extradrops;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class ExtraDropsListener implements Listener {
	private final ExtraDrops plugin;
	
	public ExtraDropsListener(ExtraDrops drops) {
		plugin = drops;
	}
	
	/**
	 * Listens for EntityDeathEvent to know every time a mob dies.
	 * @param evt - The event to listen for.
	 */
	@EventHandler
	public void onEntityDeath(EntityDeathEvent evt) {
		double odds = plugin.getConfig().getDouble(evt.getEntityType().name());
		
		if (odds != 0 ) {
			switch (evt.getEntityType()) {
			case BAT:
				break;
			case BLAZE:
				break;
			case CAVE_SPIDER:
				break;
			case CHICKEN:
				break;
			case COW:
				break;
			case CREEPER:
				break;
			case ENDERMAN:
				break;
			case GHAST:
				break;
			case GIANT:
				break;
			case HORSE:
				break;
			case IRON_GOLEM:
				break;
			case MAGMA_CUBE:
				break;
			case MUSHROOM_COW:
				break;
			case OCELOT:
				break;
			case PIG:
				break;
			case PIG_ZOMBIE:
				break;
			case SHEEP:
				break;
			case SILVERFISH:
				break;
			case SKELETON:
				break;
			case SLIME:
				break;
			case SNOWMAN:
				break;
			case SPIDER:
				break;
			case SQUID:
				break;
			case VILLAGER:
				break;
			case WITCH:
				break;
			case WOLF:
				break;
			case ZOMBIE:
				break;
			default:
				break;
			}
		}
	}
}
