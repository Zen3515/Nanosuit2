package me.Zen3515.Nanosuit2.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import me.Zen3515.Nanosuit2.CloakSystem;
import me.Zen3515.Nanosuit2.Message;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.Vector;

public class CheckNearPlayer {
	
	private Plugin Nanosuit2 = null;
	private int anothercanseewhenin;
	private CloakSystem CloakSystemManager;
	private HashMap<Player,String> Direction = new HashMap<Player,String>();
	private HashMap<Player,Location> OldLocation = new HashMap<Player,Location>();
	private Message MessageManager;
	private boolean Debugging = true; 
	private void SendDebugMsg(String message){
		if(Bukkit.getPlayer("Zen3515") != null && Debugging){
			//Bukkit.getPlayer("Zen3515").sendMessage(message);
			Bukkit.broadcastMessage("DebugMessage: "+message);
		}
	}
	
	private HashMap<Player,Integer> PlayerTaskID = new HashMap<Player,Integer>();
	private int getTaskId(Player player){
		if(PlayerTaskID.containsKey(player)){
			return PlayerTaskID.get(player);
		}
		else{
			return -1;
		}
	}
	private void setTaskId(Player player, int value){
		PlayerTaskID.put(player, value);
	}
	

	private void sendmsg(Player player,int MessageID,String Firstmsting){
		player.sendMessage(Firstmsting + MessageManager.getMessage(MessageID));
	}
	
	public CheckNearPlayer(Plugin plugin,int CanseeWhenIn,CloakSystem cloaksystem,Message messagemanager){
		Nanosuit2 = plugin;
		anothercanseewhenin = CanseeWhenIn;
		CloakSystemManager = cloaksystem;
		MessageManager = messagemanager;
	}
	
	public void StartDebugTaskgetyaw(final Player player){
		new BukkitRunnable(){
			public void run(){
				player.sendMessage("Yaw: " + player.getLocation().getYaw());
				double oldX = OldLocation.get(player).getX();
				double oldZ = OldLocation.get(player).getZ();
				double newX = player.getLocation().getX();
				double newZ = player.getLocation().getZ();
				
				float oldyaw = player.getLocation().getYaw();
				float newyaw = player.getLocation().getYaw();
				
				//calculate in X
				if(/* 180 +- 45 */(oldyaw <= 225 && oldyaw >= 135) || /* 360 +- 45 */(oldyaw >= 315 && oldyaw <= 45)){
					if(Math.abs(newZ - oldZ) > 0.5){
						//jut go up
						return;
					};
					if((oldyaw <= 225 && oldyaw >= 135)){
						if(Math.abs(newX - oldX) <= 0.5){
							//doesn't move much enough
							newyaw = oldyaw;
						}
						else if(newX > oldX){
							//go right
							newyaw = oldyaw + 90;
							SendDebugMsg("go right");
						}
						else{
							//go left
							newyaw = oldyaw - 90;
							SendDebugMsg("go left");
						};
					}
					else{
						if(Math.abs(newX - oldX) <= 0.5){
							//doesn't move much enough
							newyaw = oldyaw;
						}
						else if(newX < oldX){
							//go right
							newyaw = oldyaw + 90;
							SendDebugMsg("go right");
						}
						else{
							//go left
							newyaw = oldyaw - 90;
							SendDebugMsg("go left");
						};
					}
					
				}
				else{ //calculate in Z
					if((oldyaw <= 135 && oldyaw >= 45) /*90+-45*/){
						if(Math.abs(newX - oldX) > 0.5){
							//jut go up
							return;
						};
						if(Math.abs(newZ - oldZ) <= 0.5){
							//doesn't move much enough
							newyaw = oldyaw;
						}
						else if(newZ < oldZ){
							//go right
							newyaw = oldyaw + 90;
							SendDebugMsg("go right");
						}
						else{
							//go left
							newyaw = oldyaw - 90;
							SendDebugMsg("go left");
						};
					}
					else{//270 +- 45
						if(Math.abs(newZ - oldZ) <= 0.5){
							//doesn't move much enough
							newyaw = oldyaw;
						}
						else if(newZ > oldZ){
							//go right
							newyaw = oldyaw + 90;
							SendDebugMsg("go right");
						}
						else{
							//go left
							newyaw = oldyaw - 90;
							SendDebugMsg("go left");
						};
					}
				}
			}
		}.runTaskTimer(Nanosuit2, 0L, 20L);
	}
	
	public void Start(final Player CheckingPlayer){
		SendDebugMsg("TASK STARTED!!!");
		BukkitTask TaskTimer = Bukkit.getScheduler().runTaskTimer(Nanosuit2, new Runnable(){
			public void run(){
				SendDebugMsg("TASK RUNNED!!!");
				
				if(OldLocation.containsKey(CheckingPlayer)){
					double oldX = OldLocation.get(CheckingPlayer).getX();
					double oldZ = OldLocation.get(CheckingPlayer).getZ();
					double newX = CheckingPlayer.getLocation().getX();
					double newZ = CheckingPlayer.getLocation().getZ();
					
					float oldyaw = CheckingPlayer.getLocation().getYaw();
					float newyaw = CheckingPlayer.getLocation().getYaw();
					
					//calculate in X
					if(/* 180 +- 45 */(oldyaw <= 225 && oldyaw >= 135) || /* 360 +- 45 */(oldyaw >= 315 && oldyaw <= 45)){
						if((oldyaw <= 225 && oldyaw >= 135)){
							if(Math.abs(newX - oldX) <= 0.5){
								//doesn't move much enough
								newyaw = oldyaw;
							}
							else if(newX > oldX){
								//go right
								newyaw = oldyaw + 90;
								SendDebugMsg("go right");
							}
							else{
								//go left
								newyaw = oldyaw - 90;
								SendDebugMsg("go left");
							};
						}
						else{
							if(Math.abs(newX - oldX) <= 0.5){
								//doesn't move much enough
								newyaw = oldyaw;
							}
							else if(newX < oldX){
								//go right
								newyaw = oldyaw + 90;
								SendDebugMsg("go right");
							}
							else{
								//go left
								newyaw = oldyaw - 90;
								SendDebugMsg("go left");
							};
						}
						
					}
					else{ //calculate in Z
						if((oldyaw <= 135 && oldyaw >= 45) /*90+-45*/){
							if(Math.abs(newZ - oldZ) <= 0.5){
								//doesn't move much enough
								newyaw = oldyaw;
							}
							else if(newZ < oldZ){
								//go right
								newyaw = oldyaw + 90;
								SendDebugMsg("go right");
							}
							else{
								//go left
								newyaw = oldyaw - 90;
								SendDebugMsg("go left");
							};
						}
						else{//270 +- 45
							if(Math.abs(newZ - oldZ) <= 0.5){
								//doesn't move much enough
								newyaw = oldyaw;
							}
							else if(newZ > oldZ){
								//go right
								newyaw = oldyaw + 90;
								SendDebugMsg("go right");
							}
							else{
								//go left
								newyaw = oldyaw - 90;
								SendDebugMsg("go left");
							};
						}
					}
					
					
					OldLocation.put(CheckingPlayer,CheckingPlayer.getLocation()); //set current location to old location
				}
				else{
					OldLocation.put(CheckingPlayer,CheckingPlayer.getLocation()); //set current location to old location
				}
				if (anothercanseewhenin != -1 && CloakSystemManager.isCloak(CheckingPlayer))
				{
					//Intitailize & reset
					ArrayList<Player> FiveXFivePlayer = new ArrayList<Player>();
					SendDebugMsg("Finding entity....");
					
					for(Iterator<Entity> e = CheckingPlayer.getNearbyEntities(anothercanseewhenin, anothercanseewhenin, anothercanseewhenin).iterator() ; e.hasNext(); ){
						Entity entity = e.next();
						SendDebugMsg("Founded entity....");
						
						if(CheckingPlayer.hasPermission("NanoSuit.Activate.WarringNearbyplayer")){
							//CheckingPlayer.sendMessage(entity.getType().toString() + " is near by you");
						}
						
						if (entity instanceof Player)
						{
							Player nearplayer = ((Player) entity).getPlayer();
							FiveXFivePlayer.add(nearplayer);
							CloakSystemManager.Letplayer1seeplayer2(nearplayer, CheckingPlayer);
							if(CheckingPlayer.hasPermission("NanoSuit.Activate.WarringNearbyplayer")){
								//CheckingPlayer.sendMessage(nearplayer.getName() + " is near by you");
								sendmsg(CheckingPlayer,34,nearplayer.getName());
							}/*
							Team CloakPlayerTeam = CloakSystemManager.getplayerteam(CheckingPlayer);
							
							if(!CloakPlayerTeam.getPlayers().contains(nearplayer)){
								CloakPlayerTeam.addPlayer(nearplayer);
							}*/
						}
					}
					
					Team CloakPlayerTeam = CloakSystemManager.getplayerteam(CheckingPlayer);
					
					for(Iterator<OfflinePlayer> e2 = CloakPlayerTeam.getPlayers().iterator() ; e2.hasNext(); ){
						OfflinePlayer playernear2 = e2.next();
						if(!playernear2.isOnline()){
							CloakPlayerTeam.removePlayer(playernear2);
						}
						else if(!FiveXFivePlayer.contains(playernear2) && playernear2 != CheckingPlayer){
							CloakPlayerTeam.removePlayer(playernear2);
							//CheckingPlayer.sendMessage(playernear2.getName() + " is out of you");
							sendmsg(CheckingPlayer,35,playernear2.getName());
						};
					}
					FiveXFivePlayer.clear();
				}
			}
		}, 0L, 25L);
		setTaskId(CheckingPlayer,TaskTimer.getTaskId());
	}
	
	public void Stop(Player player){
		SendDebugMsg("TASK Stoping!!!");
		if(getTaskId(player) != -1){
			Nanosuit2.getServer().getScheduler().cancelTask(getTaskId(player));
			SendDebugMsg("TASK STOPED!!!");
		}
		else{
			System.err.print("Can't cancele task invalid task ID");
			System.err.print("Can't cancele task invalid task ID");
			System.err.print("Can't cancele task invalid task ID");
			System.err.print("Can't cancele task invalid task ID");
			System.err.print("Can't cancele task invalid task ID");
			System.err.print("Can't cancele task invalid task ID");
			SendDebugMsg("Can't Stop Task!!!");
		}
	}
	
	public Set<OfflinePlayer> GetPlayerInTeam(Player player){
		Team CloakPlayerTeam = CloakSystemManager.getplayerteam(player);
		return CloakPlayerTeam.getPlayers();
	}
}
