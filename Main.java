package com.craftilandia.itemsguns;


import java.util.ArrayList;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
public class Main extends JavaPlugin implements Listener{
	ArrayList<String> droped = new ArrayList<String>();
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
//e.getItemDrop().getLocation().getBlock().getRelative(0, -1, 0).setTypeIdAndData(35, (byte) 14, true);
				e.getItemDrop().getLocation().getBlock().getRelative(0, -1, 0).setTypeIdAndData(152, (byte) 1, true);
				e.getItemDrop().getLocation().getBlock().setTypeIdAndData(46, (byte) 1, true);
				ItemStack casco = new ItemStack(Material.LEATHER_HELMET,1);
				LeatherArmorMeta lam = (LeatherArmorMeta)casco.getItemMeta();
				lam.setColor(Color.fromRGB(23, 0, 144));
				casco.setItemMeta(lam);
				
				e.getPlayer().getEquipment().setHelmet(casco);
			}},25);}}
