package com.craftilandia.itemsguns;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Main extends JavaPlugin implements Listener{

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void disparo(final PlayerDropItemEvent e){
		
		Vector v = e.getPlayer().getLocation().getDirection();
        e.getItemDrop().setVelocity(v.multiply(1));
        getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
			@Override
			public void run() {
Block itemloc = e.getItemDrop().getLocation().getBlock().getRelative(0, -1, 0);
itemloc.setType(Material.WOOL);
			}
		},25);
	}
	
	
	
}
