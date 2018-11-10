package me.Zen3515.Nanosuit2.listeners;

import me.Zen3515.Nanosuit2.DataClass;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class AirStorm {
	private Plugin Nanosuit;
	private DataClass DataManager;
	private Player player;
	private int CEX = 0;
	private boolean debugging = false;
	
	private void senddebugmessage(String text){
		if(debugging == true){
			if(Bukkit.getPlayer("Zen3515") != null){
				Bukkit.getPlayer("Zen3515").sendMessage(text);
			};			
		};
	}
	
	public AirStorm(Plugin nanosuit,Player player2,DataClass datamanager){
		Nanosuit = nanosuit;
		player = player2;
		DataManager = datamanager;
		
		new BukkitRunnable(){
			@Override
		    public void run(){
				try{
					Location loc = new Location(player.getWorld(),player.getLocation().getX(),player.getLocation().getY()-1,player.getLocation().getZ());
					if(player.getWorld().getBlockAt(loc).getType().equals(Material.AIR)){
						senddebugmessage("do");
						player.setVelocity(new Vector(0D,-10D,0D));
					}
					else{
						CreateExplosion();
						this.cancel();
					}
				}
				catch (IllegalStateException e){
					this.cancel();
				}			
			}
		}.runTaskTimer(Nanosuit, 0L, 2L);
		
	}
	
	private void CreateExplosion(){
		senddebugmessage(ChatColor.GREEN + "Createexplosion");
		final double x = player.getLocation().getX();
		final double y = player.getLocation().getY();
		final double z = player.getLocation().getZ();
		final Location Starairstormlocation = player.getLocation();
		final Vector nullvector = new Vector(0D,0D,0D);
		
		new BukkitRunnable(){
			@Override
		    public void run(){
				CEX++;
				if(CEX >= 5){
					this.cancel();
					senddebugmessage(ChatColor.RED + "cancel();");
				}
				switch (CEX){
				case 1:
					player.getWorld().createExplosion(x, 	y, z, 	7F, false, false);
					player.getWorld().createExplosion(x+3, 	y, z, 	2F, false, false);
					player.getWorld().createExplosion(x-3, 	y, z, 	2F, false, false);
					player.getWorld().createExplosion(x, 	y, z+3, 2F, false, false);
					player.getWorld().createExplosion(x, 	y, z-3, 2F, false, false);
					player.getWorld().createExplosion(x+3, 	y+3, z, 	2F, false, false);
					player.getWorld().createExplosion(x-3, 	y+3, z, 	2F, false, false);
					player.getWorld().createExplosion(x, 	y+3, z+3, 2F, false, false);
					player.getWorld().createExplosion(x, 	y+3, z-3, 2F, false, false);
					player.teleport(Starairstormlocation);
					player.setVelocity(nullvector);
					break;
				case 2:
					player.setVelocity(nullvector);
					player.getWorld().createExplosion(x+4, 	y, z, 	2F, false, false);
					player.getWorld().createExplosion(x-4, 	y, z, 	2F, false, false);
					player.getWorld().createExplosion(x, 	y, z+4, 2F, false, false);
					player.getWorld().createExplosion(x, 	y, z-4, 2F, false, false);
					player.setVelocity(nullvector);
					break;
				case 3:
					player.setVelocity(nullvector);
					player.getWorld().createExplosion(x+5, 	y, z, 	2F, false, false);
					player.getWorld().createExplosion(x-5, 	y, z, 	2F, false, false);
					player.getWorld().createExplosion(x, 	y, z+5, 2F, false, false);
					player.getWorld().createExplosion(x, 	y, z-5, 2F, false, false);
					player.setVelocity(nullvector);
					break;
				case 4:
					player.setVelocity(nullvector);
					player.getWorld().createExplosion(x+6, 	y, z, 	2F, false, false);
					player.getWorld().createExplosion(x-6, 	y, z, 	2F, false, false);
					player.getWorld().createExplosion(x, 	y, z+6, 2F, false, false);
					player.getWorld().createExplosion(x, 	y, z-6, 2F, false, false);
					player.setVelocity(nullvector);
				case 5:
					player.setVelocity(nullvector);
					player.getWorld().createExplosion(x+7, 	y, z, 	2F, false, false);
					player.getWorld().createExplosion(x-7, 	y, z, 	2F, false, false);
					player.getWorld().createExplosion(x, 	y, z+7, 2F, false, false);
					player.getWorld().createExplosion(x, 	y, z-7, 2F, false, false);
					player.setVelocity(nullvector);

					player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
					DataManager.setCurrenceMode(player,"armor");
					DataManager.setCanAirStorm(player,false);
					
					this.cancel();
					break;
				}
			}
		}.runTaskTimer(Nanosuit, 0L, 2L);

	}

}
