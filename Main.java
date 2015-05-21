package com.craftilandia.itemsguns;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
public class Main extends JavaPlugin implements Listener{
	@Override
	public void onEnable() {getServer().getPluginManager().registerEvents(this, this);}
	@EventHandler
	public void disparo(final PlayerDropItemEvent e){
		Vector v = e.getPlayer().getLocation().getDirection();
        e.getItemDrop().setVelocity(v.multiply(1));
        getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				ItemStack bala1 = new ItemStack(Material.DIAMOND_BLOCK);
				if(e.getItemDrop().getItemStack().isSimilar(bala1)){
					e.getItemDrop().getLocation().getBlock().getRelative(0, -1, 0).setTypeIdAndData(35, (byte) 11, true);
					//e.getItemDrop().getLocation().getBlock().getRelative(0, -1, 0).setTypeIdAndData(152, (byte) 1, true);
					//e.getItemDrop().getLocation().getBlock().setTypeIdAndData(46, (byte) 1, true);
					ItemStack casco = new ItemStack(Material.LEATHER_HELMET,1);
					LeatherArmorMeta ccasco = (LeatherArmorMeta)casco.getItemMeta();
					ccasco.setColor(Color.fromRGB(23, 0, 144));
					casco.setItemMeta(ccasco);

					ItemStack peto = new ItemStack(Material.LEATHER_CHESTPLATE,1);
					LeatherArmorMeta cpeto = (LeatherArmorMeta)peto.getItemMeta();
					cpeto.setColor(Color.fromRGB(23, 0, 144));
					peto.setItemMeta(cpeto);
					for(Entity mob : e.getItemDrop().getNearbyEntities(2.0D, 2.0D, 2.0D))
			    	{
						if(mob instanceof Zombie || mob instanceof Player){
						    ((LivingEntity) mob).getEquipment().setHelmet(casco);
						    ((LivingEntity) mob).getEquipment().setChestplate(peto);
						    mob.setFireTicks(60);
						    //add potion effects
						}
			    	}}
				ItemStack bala2 = new ItemStack(Material.REDSTONE_BLOCK);
				if(e.getItemDrop().getItemStack().isSimilar(bala2)){
					e.getItemDrop().getLocation().getBlock().getRelative(0, -1, 0).setTypeIdAndData(35, (byte) 14, true);
					//e.getItemDrop().getLocation().getBlock().getRelative(0, -1, 0).setTypeIdAndData(152, (byte) 1, true);
					//e.getItemDrop().getLocation().getBlock().setTypeIdAndData(46, (byte) 1, true);
					ItemStack casco = new ItemStack(Material.LEATHER_HELMET,1);
					LeatherArmorMeta ccasco = (LeatherArmorMeta)casco.getItemMeta();
					ccasco.setColor(Color.fromRGB(233, 0, 14));
					casco.setItemMeta(ccasco);
					ItemStack peto = new ItemStack(Material.LEATHER_CHESTPLATE,1);
					LeatherArmorMeta cpeto = (LeatherArmorMeta)peto.getItemMeta();
					cpeto.setColor(Color.fromRGB(233, 0, 14));
					peto.setItemMeta(cpeto);
					for(Entity mob : e.getItemDrop().getNearbyEntities(2.0D, 2.0D, 2.0D))
			    	{
						if(mob instanceof Zombie || mob instanceof Player){
						    ((LivingEntity) mob).getEquipment().setHelmet(casco);
						    ((LivingEntity) mob).getEquipment().setChestplate(peto);
						    mob.setFireTicks(60);
						}
			    	}}
					
				
				
			}},25);}}
