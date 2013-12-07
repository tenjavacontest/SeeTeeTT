package me.conarnar.extradrops;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
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
	@SuppressWarnings("deprecation")
	@EventHandler()
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
				// TODO
				break;
			case CREEPER:
				TNTPrimed tnt = evt.getEntity().getWorld().spawn(evt.getEntity().getEyeLocation(), TNTPrimed.class);
				tnt.setIsIncendiary(true);
				break;
			case ENDERMAN:
				evt.getEntity().getWorld().spawn(evt.getEntity().getLocation(), EnderCrystal.class);
				MaterialData data3;
				if ((data3 = ((Enderman) evt.getEntity()).getCarriedMaterial()) != null) {
					evt.getEntity().getWorld().spawnFallingBlock(evt.getEntity().getEyeLocation(), data3.getItemType(), data3.getData()).setVelocity(evt.getEntity().getEyeLocation().getDirection());
				}
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
				if(((MagmaCube) evt.getEntity()).getSize() == 1) evt.getEntity().getWorld().spawnFallingBlock(evt.getEntity().getEyeLocation(), Material.FIRE, (byte) 0).setDropItem(false);
				else evt.getEntity().getWorld().spawnFallingBlock(evt.getEntity().getEyeLocation(), Material.LAVA, (byte) 127).setDropItem(false);
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
				Zombie zombie = evt.getEntity().getWorld().spawn(evt.getEntity().getLocation(), Zombie.class);
				Pig pig = evt.getEntity().getWorld().spawn(evt.getEntity().getLocation(), Pig.class);
				PigZombie pz = (PigZombie) evt.getEntity();
				zombie.setBaby(pz.isBaby());
				if (pz.isBaby()) pig.setBaby();
				else pig.setAdult();
				pig.setMaxHealth(1);
				zombie.setMaxHealth(1);
				zombie.setVillager(pz.isVillager());
				EntityEquipment ze = zombie.getEquipment();
				EntityEquipment pe = pz.getEquipment();
				ze.setArmorContents(pe.getArmorContents());
				ze.setItemInHand(pe.getItemInHand());
				ze.setBootsDropChance(pe.getBootsDropChance());
				ze.setLeggingsDropChance(pe.getLeggingsDropChance());
				ze.setChestplateDropChance(pe.getChestplateDropChance());
				ze.setHelmetDropChance(pe.getHelmetDropChance());
				pig.setFireTicks(pz.getFireTicks());
				zombie.setFireTicks(pz.getFireTicks());
				pig.setVelocity(pz.getVelocity());
				zombie.setVelocity(pz.getVelocity());
				pig.setTarget(pz.getTarget());
				zombie.setTarget(pz.getTarget());
				for (PotionEffect effect: pz.getActivePotionEffects()) {
					pig.addPotionEffect(effect);
					zombie.addPotionEffect(effect);
				}
				
				break;
			case SHEEP:
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
				evt.getEntity().getWorld().spawnFallingBlock(evt.getEntity().getEyeLocation(), Material.SKULL, (byte) 2);
				break;
			default:
				break;
			}
		}
	}
}
