package me.conarnar.extradrops;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EnderSignal;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.SmallFireball;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

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
		
		// decides whether to add the extra "drops" or not
		if (plugin.chance(odds)) {
			switch (evt.getEntityType()) {
			case BAT:
				// TODO
				break;
			case BLAZE:
				for (int i = 0; i < 10; i++) {
					evt.getEntity().launchProjectile(SmallFireball.class).setDirection(new Vector(plugin.rand.nextGaussian(), plugin.rand.nextGaussian(), plugin.rand.nextGaussian()));
				}
				break;
			case CAVE_SPIDER:
				evt.getEntity().launchProjectile(ThrownPotion.class).setItem(new ItemStack(Material.POTION, 1, (short) 16388));
				break;
			case CHICKEN:
				evt.getEntity().launchProjectile(Snowball.class);
				break;
			case COW:
				evt.getEntity().getWorld().spawnFallingBlock(evt.getEntity().getEyeLocation(), Material.WATER, (byte) 127);
				break;
			case CREEPER:
				evt.getEntity().getWorld().spawn(evt.getEntity().getEyeLocation(), TNTPrimed.class).setIsIncendiary(true);
				break;
			case ENDERMAN:
				evt.getEntity().getWorld().spawn(evt.getEntity().getEyeLocation(), EnderSignal.class);
				break;
			case GHAST:
				for (int i = 0; i < 10; i++) {
					evt.getEntity().launchProjectile(LargeFireball.class).setDirection(new Vector(plugin.rand.nextGaussian(), plugin.rand.nextGaussian(), plugin.rand.nextGaussian()));
				}
				break;
			case GIANT:
				for (int i = 0; i < 30; i++) {
					evt.getDrops().add(new ItemStack(Material.ROTTEN_FLESH));
				}
				break;
			case HORSE:
				// TODO
				break;
			case IRON_GOLEM:
				evt.getEntity().getWorld().spawnFallingBlock(evt.getEntity().getLocation(), Material.IRON_BLOCK, (byte) 0);
				evt.getEntity().getWorld().spawnFallingBlock(evt.getEntity().getEyeLocation(), Material.PUMPKIN, (byte) 0);
				break;
			case MAGMA_CUBE:
				evt.getEntity().getWorld().spawnFallingBlock(evt.getEntity().getEyeLocation(), Material.LAVA, (byte) 127);
				break;
			case MUSHROOM_COW:
				evt.getEntity().getWorld().spawnFallingBlock(evt.getEntity().getEyeLocation(), Material.RED_MUSHROOM, (byte) 0);
				break;
			case OCELOT:
				// TODO
				break;
			case PIG:
				// TODO
				break;
			case PIG_ZOMBIE:
				evt.getEntity().getWorld().spawn(evt.getEntity().getLocation(), Zombie.class);
				evt.getEntity().getWorld().spawn(evt.getEntity().getLocation(), Pig.class);
				break;
			case SHEEP:
				@SuppressWarnings("deprecation")
				byte data = ((Sheep) evt.getEntity()).getColor().getWoolData();
				evt.getEntity().getWorld().spawnFallingBlock(evt.getEntity().getEyeLocation(), Material.WOOL, data);
				break;
			case SILVERFISH:
				// TODO
				break;
			case SKELETON:
				for (int i = 0; i < 10; i++) {
					evt.getEntity().launchProjectile(Arrow.class).setVelocity(new Vector(plugin.rand.nextGaussian(), plugin.rand.nextGaussian(), plugin.rand.nextGaussian()).normalize());
				}
				break;
			case SLIME:
				// TODO
				break;
			case SNOWMAN:
				for (int i = 0; i < 10; i++) {
					evt.getEntity().launchProjectile(Snowball.class).setVelocity(new Vector(plugin.rand.nextGaussian(), plugin.rand.nextGaussian(), plugin.rand.nextGaussian()).normalize());
				}
				break;
			case SPIDER:
				evt.getEntity().launchProjectile(ThrownPotion.class).setItem(new ItemStack(Material.POTION, 1, (short) 16388));
				break;
			case SQUID:
				for (int i = 0; i < 10; i++) {
					evt.getDrops().add(new ItemStack(Material.INK_SACK));
				}
				break;
			case VILLAGER:
				// TODO
				break;
			case WITCH:
				short[] data2 = new short[] {16481, 16482, 16489, 16484};
				evt.getEntity().getWorld().spawn(evt.getEntity().getEyeLocation(), ThrownPotion.class).setItem(new ItemStack(Material.POTION, 1, data2[plugin.rand.nextInt(data2.length)]));
				break;
			case WOLF:
				// TODO
				break;
			case ZOMBIE:
				// TODO
				break;
			default:
				break;
			}
		}
	}
}
