package me.Zen3515.Nanosuit2;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import me.Zen3515.Nanosuit2.listeners.CheckNearPlayer;
import me.Zen3515.Nanosuit2.listeners.UndropableListener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;/*
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftBlaze;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftCaveSpider;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftCreeper;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftEnderDragon;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftEnderman;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftGhast;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftGiant;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftIronGolem;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftMagmaCube;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftPigZombie;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftSilverfish;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftSkeleton;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftSlime;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftSnowman;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftSpider;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftWitch;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftWither;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftWolf;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftZombie;*/
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftBlaze;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftCaveSpider;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftCreeper;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftEnderDragon;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftEnderman;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftGhast;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftGiant;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftIronGolem;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftMagmaCube;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPigZombie;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftSilverfish;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftSkeleton;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftSlime;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftSnowman;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftSpider;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftWitch;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftWither;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftWolf;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftZombie;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.Vector;
import me.Zen3515.Nanosuit2.listeners.AirStorm;


public class Nanosuit2Main extends JavaPlugin implements Listener {

	private boolean debugging = true;
	
	//TODO RESOURCEPACK
	//player.setResourcePack("https://dl.dropboxusercontent.com/u/110637043/Nanosuit/NanosuitPack%20-%201.7.2.zip");
	
//{{ Define Config
	public boolean TimesPressShiftWarringBool = false;
	public int TimesPressShiftWarring = 5;
	public int anothercanseewhenin = 15;
	public int Maximumplayer = 20;
	public int NowHavePlayer = 0;
	public Sound CloakEngaged = Sound.VILLAGER_HAGGLE;
	public Sound MaximumArmor = Sound.VILLAGER_HAGGLE;
	public Sound MaximumPower = Sound.VILLAGER_HAGGLE;
	public boolean WillPlaySoundCloak = false;
	public boolean WillPlaySoundArmor = false;
	public boolean WillPlaySoundPower = false;
	public float CloakVolume = 1F;
	public float ArmorVolume = 1F;
	public float PowerVolume = 1F;
	public int ArmorEnchantLevel = 100;
	public int PowerEnchantLevel = 100;
	public int ArmorColor = 0x2D2D2D;
	public int PowerColor = 0xFF0000;
	public long playSoundDelaied = 18L;
	public int ThePredatorBowEnchantLevel = 100;
	public int AirStormCooldownTime = 30;
	public float AirStormVolume = 1F;
	public float NanovisionEnableVolume = 1F;
	public float NanovisionDisableVolume = 1F;
	public Sound AirStorm = Sound.VILLAGER_HAGGLE;
	public Sound NanoVisionEnable = Sound.VILLAGER_HAGGLE;
	public Sound NanoVisionDisable = Sound.VILLAGER_HAGGLE;
	public boolean WillPlaySoundAirStorm = false;
	public boolean WillPlaySoundNVEnable = false;
	public boolean WillPlaySoundNVDisable = false;
	public boolean CanUseAirStormConfig = false;
//}}
	
	public FixedMetadataValue ArrowFixedMetadataValue = new FixedMetadataValue(this, "NanoArrow");
	public FixedMetadataValue ArrowActivatedFixedMetadataValue = new FixedMetadataValue(this, "Activated");
	private String StringArrowFixedMetadataValue = ("["+ArrowFixedMetadataValue.toString()+"]");
	private String StringArrowActivatedFixedMetadataValue = ("["+ArrowActivatedFixedMetadataValue.toString()+"]");
	//public static CloakFactory CloakManager;
	public static Nanosuit2Main plugin;
	private final double UseableConfigVersion = 1.3;
	public Logger logger = this.getLogger();
	public Scoreboard Cloakboard;
	public static CloakSystem CloakSystemManager;
	public static CheckNearPlayer CheckNearPlayerManager;
	public static DataClass DataManager;
	public static Message MessageManager;
	//public static DisplaySystem DisplaySystemManager;

	/**
	 * send debugging message, if debugging set to true will send message
	 * @param text - text to send
	 */
	private void senddebugmessage(String text){
		if(debugging == true){
			if(Bukkit.getPlayer("Zen3515") != null){
				Bukkit.getPlayer("Zen3515").sendMessage(text);
			};			
		};
	}
	private void sendmsg(Player player,int MessageID){
		player.sendMessage(MessageManager.getMessage(MessageID));
	}
	private void sendmsg(Player player,int MessageID,ChatColor color){
		player.sendMessage(color + MessageManager.getMessage(MessageID));
	}
	private void sendmsg(Player player,int MessageID,String laststring){
		player.sendMessage(MessageManager.getMessage(MessageID) + laststring);
	}
	
//{{ Overriding
	@Override
	public void onEnable() {
		//intitalize Class
		logger = this.getLogger();
		Cloakboard = Bukkit.getScoreboardManager().getNewScoreboard();
		//DisplaySystemManager = new DisplaySystem((Plugin)this,Cloakboard);
		CloakSystemManager = new CloakSystem((Plugin) this,Cloakboard);
		MessageManager = new Message((Plugin) this, this.getConfig().getString("UseLanguage").toUpperCase());
		CheckNearPlayerManager = new CheckNearPlayer((Plugin) this, anothercanseewhenin, CloakSystemManager,MessageManager);
		DataManager = new DataClass((Plugin) this,CloakSystemManager);
		//DisplaySystemManager.StartUpDateTaskFor(Bukkit.getPlayer("Zen3515"));
		
		//CloakManager = new CloakFactory((Plugin) this);
		/*
		Scoreboard board = Bukkit.getServer().getScoreboardManager().getMainScoreboard();
		UsedNanosuitPeople = board.getTeam("UsedSuitPeople");
		if (UsedNanosuitPeople == null) {
			UsedNanosuitPeople = board.registerNewTeam("UsedSuitPeople");
        }
		if (anothercanseewhenin == -1){
			UsedNanosuitPeople.setCanSeeFriendlyInvisibles(true);
		}*/
		this.saveDefaultConfig();
		if(this.getConfig() != null) {
			if(this.getConfig().getDouble("VersionOfConfig") != UseableConfigVersion){
				//this.getConfig().options().copyDefaults(true);
				saveConfig();
				System.err.print("[Nanosuit2] Config file has been update to version " + String.valueOf(UseableConfigVersion));
				System.err.print("You may have to modify your config agin");
			}
		}
		else
		{
			System.err.print("There was a little bug, if this is the first time load this plugin Ignore this message");
		}
		DataManager.CreateMapForOnlinePlayer();
		GetAllConFigData();
		getServer().getPluginManager().registerEvents(this, this);
		//LoadPeoPleWhoUseNanosuit();
		DataManager.GetAllDataFromStorageForAllOnlinePlayer();
		//CloakManager.LoadArrayList();
		try {
			File Usepeopletxt = new File(getDataFolder() + "//UsedPeople.txt");
			if(!Usepeopletxt.exists()){
				Usepeopletxt.createNewFile();
			}
			NowHavePlayer = DataManager.count(getDataFolder() + "//UsedPeople.txt");
			DataManager.LoadPeoPleWhoUseNanosuit();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error*****************************************AT 166");
		}
		
		
		
		
		
		
		
		/**
		 * TODO must be delete
		 */
		CheckNearPlayerManager.StartDebugTaskgetyaw(Bukkit.getPlayer("Zen3515"));
		
		
		
		
		
		
		
		this.logger.info(this.getDescription().getName() + " Version " + this.getDescription().getVersion() + " Has Been Enabled!");
	}
	@Override
	public void onDisable() {
		//UsedNanosuitPeople.unregister();
		DataManager.SaveMapForOnlinePlayer();
		DataManager.SaveAllDataToStorageForAllOnlinePlayer();
		//SaveUsedNanosuitPeopleList();
		//CloakManager.saveArrayList();
		DataManager.SaveUsedNanosuitPeopleList();
		Bukkit.getScheduler().cancelTasks(this);
		this.logger.info(this.getDescription().getName() + " Version " + this.getDescription().getVersion() + " Has Been Disabled!");
	}
//}}

//{{ Listener
	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
	public void onPlayerJoin(PlayerJoinEvent e){
		 Player player = e.getPlayer();
		 //CreateAllMap(player);
		 if(DataManager.isaddtoUseNanosuitListOnJoinOnlyyyyyyyyyyyy(player)){
			 CheckNearPlayerManager.Start(player);
		 }
		 DataManager.addtoUseNanosuitListOnJoin(player);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
	public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent e) {
	    Player player = e.getPlayer();
	    if (player.hasPermission("NanoSuit.Activate.Cloak")){
	    	if (DataManager.isSuitEnable(player)){
	    		if (!CanUseAirStormConfig){
	    			return;
	    		}
	    		if (DataManager.CanAirStorm(player)){
	    	    	if (DataManager.CheckAsd(player) != 3){
	    	    		senddebugmessage("Case ASD: !=3");
		    	    	ActivateAirStorm(player);
		    	    	DataManager.SetAsd(player, 3);
			    		senddebugmessage("ASD: 3");
			    	}
			    	else {
			    		DataManager.SetAsd(player, 0);
			    		senddebugmessage("ASD: 0");
			    	}
	    	    	return;
	    	    }
	    	    else if (isAirStorm(player)){
	    	    	return;
	    	    };
	    	    if(!player.isOnGround()){
	    	    	return;
	    	    }
	    	    if(DataManager.CheckAsd(player) == 3){
	    	    	senddebugmessage("Case SD: 3");
	    	    	return;
	    	    }
			    if (CloakSystemManager.isCloak(player) == false && DataManager.Checksd(player) != 3){
			    	senddebugmessage("CASE SD: !=3 & Not cloaking");
			    	InstanceIgnoreMe(player);
			    	ActivatCloakMode(player);
			    	if(player.getItemInHand() != null){
		    			ItemStack ItiH = player.getItemInHand();
		    			int i = getFirstEmtySlot(player);
		    			if (i != -1){
			    			player.getInventory().setItem(i, ItiH);
			    			player.setItemInHand(null);
			    			ItiH = null;
		    			}
		    			else{ 
		    				player.getInventory().addItem(ItiH);
		    				player.updateInventory();
		    			}
		    		}
			    	DataManager.Setsd(player, 1);
		    		senddebugmessage("SD: 1");
		    	}
		    	else if (CloakSystemManager.isCloak(player) && DataManager.Checksd(player) != 1){
		    		senddebugmessage("CASE SD: !=1");
		    		if (!WillPlaySoundCloak){
		    			sendmsg(player,19);
					}
		    		ActivatArmorMode(player);
		    		removethisItemnameFormInventory(player,ChatColor.RED + "PredatorBow");
		    		if(player.getItemInHand() != null){
		    			ItemStack ItiH = player.getItemInHand();
		    			int i = getFirstEmtySlot(player);
		    			if (i != -1){
			    			player.getInventory().setItem(i, ItiH);
			    			ItiH = null;
		    			}
		    			else{ 
		    				player.getInventory().addItem(ItiH);
		    				player.updateInventory();
		    			}
		    		}
		    		player.getInventory().setItemInHand(GetPredatorBow(ThePredatorBowEnchantLevel));
		    		DataManager.Setsd(player, 3);
		    		senddebugmessage("Set SD to: 3");
		    	}
		    	else if (DataManager.Checksd(player) == 3 ){
		    		senddebugmessage("CASE SD: 3");
		    		DataManager.Setsd(player, 0);
		    		senddebugmessage("Set SD to: 0");
		    	}
		    	else {
		    		senddebugmessage("CASE SD: else");
		    		DataManager.Setsd(player, 0);
		    		senddebugmessage("Set SD to: 0");
		    	}
			}
	    };
	    if ((DataManager.CheckTimesPressShift(player) >= TimesPressShiftWarring) && TimesPressShiftWarringBool && !DataManager.isSuitEnable(player))
    	{
	    	player.sendMessage("To activate Nanosuit type /nanosuit");
	    	DataManager.ResetTimesPressShift(player);
    	}
    	else if (TimesPressShiftWarringBool)
    	{
    		DataManager.AddTimesPressShift(player);
    	};
	    return;
	}

	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
	public void onPlayerToggleSprintEvent(PlayerToggleSprintEvent event){
		Player player = event.getPlayer();
		if(player.hasPermission("NanoSuit.Activate.MaximumPower"))
		{
			if (player.isSprinting() == false)
			{ 	
				if (DataManager.isSuitEnable(player) && DataManager.getCurrenceMode(player) == "power")
				{
					player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 11));
				}
			}
			else
			{
				if (DataManager.isSuitEnable(player) && DataManager.getCurrenceMode(player) == "power")
				{
					player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 7));
				}
			}
		};
		if(player.hasPermission("NanoSuit.Activate.Slide")){
			
			if (player.isSprinting() == false){ 
				final Player player2 = player;
				new BukkitRunnable(){
					public void run(){
						player2.setAllowFlight(true);
						player2.setFlying(true);
						
						player2.setVelocity(player2.getLocation().getDirection().multiply(2));
						senddebugmessage("sliding X: " + player2.getLocation().getDirection().multiply(2).getX() + " Z: " + player2.getLocation().getDirection().multiply(2).getZ());
						
						player2.setAllowFlight(false);
						player2.setFlying(false);
						this.cancel();
					}
				}.runTaskLater((Plugin) this, 2L);
			}
		}
	}
	
	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
	public void onPlayerMoveEvent(PlayerMoveEvent event){
		Player movedplayer = event.getPlayer();
		if(!DataManager.isSuitEnable(movedplayer)){
			return;
		}
		if(movedplayer.hasPermission("NanoSuit.Activate")){
			if(movedplayer.getFoodLevel() < 20)
			{
				movedplayer.setFoodLevel(20);
			};
			if(movedplayer.hasPermission("NanoSuit.Activate.AirStorm") || movedplayer.hasPermission("NanoSuit.Activate.MaximumPower")){
				//TODO Detect jump
				if(event.getTo().getY() - event.getFrom().getY() >= 1){
					//jump more hight
					//movedplayer.setVelocity(new Vector(movedplayer.getVelocity().getX(),movedplayer.getVelocity().getY()*((double) 1.5),movedplayer.getVelocity().getY()));
					//TODO jump more long
					if(movedplayer.isSprinting() && movedplayer.hasPermission("NanoSuit.Activate.MaximumPower.SprintJumpBoost")){
						final Player movedplayerforsprintboost = movedplayer;
						new BukkitRunnable(){
							public void run(){
								movedplayerforsprintboost.setVelocity(new Vector(movedplayerforsprintboost.getVelocity().getX()*((double) 1.5), movedplayerforsprintboost.getVelocity().getY() ,movedplayerforsprintboost.getVelocity().getZ()*((double) 1.5)));
								senddebugmessage("Jump boosting " + "X: " + (movedplayerforsprintboost.getVelocity().getX()) + " Y: " + movedplayerforsprintboost.getVelocity().getY() + " Z: " + (movedplayerforsprintboost.getVelocity().getZ()));
								this.cancel();
							}
						}.runTaskLater((Plugin) this, 5L);
					}
					else{
						//movedplayer.setVelocity(new Vector(movedplayer.getVelocity().getX()*((double) 7), movedplayer.getVelocity().getY() ,movedplayer.getVelocity().getZ()*((double) 7)));
					}
					
					//if doesn't firsttime
					if(!DataManager.isPutOnFormJumping(movedplayer)){
						//set start hight
						DataManager.SetJumpFrom(movedplayer, movedplayer.getLocation().getY());
					}
					else{
						if(movedplayer.getLocation().getY() - DataManager.GetJumpFrom(movedplayer) >= 5){
							DataManager.setCanAirStorm(movedplayer,true);
						}
						else{
							DataManager.setCanAirStorm(movedplayer,false);
						}
					}
					
					
				}
				else if(!movedplayer.getWorld().getBlockAt(new Location(movedplayer.getWorld() , movedplayer.getLocation().getX() , movedplayer.getLocation().getY() - 1 , movedplayer.getLocation().getZ() )).getType().equals(Material.AIR)){
					DataManager.ClearJumpMap(movedplayer);
					DataManager.setCanAirStorm(movedplayer,false);
				};
			}
		};
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
    public void onEntityDamageEvent(EntityDamageEvent event){
        if(event.getEntity() instanceof Player && event.getCause() == DamageCause.FALL){
        	Player player = (Player) event.getEntity();
        	if(player.hasPermission("NanoSuit.Activate") && DataManager.isSuitEnable(player)){
                event.setCancelled(true);
        	}
        }
        else if(event.getEntity() instanceof Player && (event.getCause().equals(DamageCause.POISON) || event.getCause().equals(DamageCause.PROJECTILE))){
        	if(DataManager.getCurrenceMode((Player)event.getEntity()) == "armor"){
            	event.setDamage(event.getDamage()*2);
        	}
        }
    }
	
	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
	public void onPlayerQuitEvent(PlayerQuitEvent event){
		Player player = event.getPlayer();
		if (DataManager.isSuitEnable(player))
		{
			DataManager.SaveAllPlayerDataToStorage(player);
			player.saveData();
		}
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerDropEvent(PlayerDropItemEvent event){
		Player player = event.getPlayer();
		if (!event.getItemDrop().getItemStack().getItemMeta().hasLore())
		{
			return;
		}
		if (DataManager.isSuitEnable(player) && player.hasPermission("NanoSuit.Activate.MaximumPower")
		&& event.getItemDrop().getItemStack().getItemMeta().getLore().equals(GetPredatorBow(ThePredatorBowEnchantLevel).getItemMeta().getLore()))
		{
			event.setCancelled(true);
			if (DataManager.getCurrenceMode(player).contains("cloak") || DataManager.getCurrenceMode(player).contains("armor"))
			{
				ActivatPowerMode(player);
			}
			else if (DataManager.getCurrenceMode(player).contains("power"))
			{
				ActivatArmorMode(player);
			}
			else
			{
				System.err.print("Critical Error please contact Zen3515");
			}
			UndropableListener AfterDropevent = new UndropableListener((Plugin)this,player, ChatColor.RED + "PredatorBow",ThePredatorBowEnchantLevel);
			Bukkit.getServer().getPluginManager().callEvent(AfterDropevent);
			return;
			
		}
	}
		
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerInteractEvent(PlayerInteractEvent event){
		Action playeraction = event.getAction();
		Player player = event.getPlayer();
		if(!player.getItemInHand().hasItemMeta()){
			return;
		}
		if(!player.getItemInHand().getItemMeta().hasLore()){
			return;
		}
		if(DataManager.isSuitEnable(player) && player.getItemInHand().getItemMeta().getLore().equals(GetPredatorBow(ThePredatorBowEnchantLevel).getItemMeta().getLore())) {
			String CurrentArrow = DataManager.getCurrentArrow(player);
			if(playeraction.equals(Action.LEFT_CLICK_AIR) || playeraction.equals(Action.LEFT_CLICK_BLOCK)){
				event.setCancelled(true);
				ItemStack ItemInHand = player.getItemInHand();
				if(ItemInHand.getDurability() != ItemInHand.getType().getMaxDurability()){
					ItemInHand.setDurability(Short.MIN_VALUE);
				}
				switch (CurrentArrow){
				case"Carbon-Impact":
					DataManager.setCurrentArrow(player,"Electro");
					break;
				case"Electro":
					DataManager.setCurrentArrow(player,"Super-thermite");
					break;
				case"Super-thermite":
					DataManager.setCurrentArrow(player,"Airburst Fragmentation");
					break;
				case"Airburst Fragmentation":
					DataManager.setCurrentArrow(player,"Carbon-Impact");
					break;
				}
			}
			else if(playeraction.equals(Action.RIGHT_CLICK_AIR) || playeraction.equals(Action.RIGHT_CLICK_BLOCK)){
				ItemStack ItemInHand = player.getItemInHand();
				if(ItemInHand.getDurability() != ItemInHand.getType().getMaxDurability()){
					ItemInHand.setDurability(Short.MIN_VALUE);
				}
				DataManager.setAimming(player,true);
				switch ((int)DataManager.CheckCurrentAimmingAction(player)){
				case 1:
					player.setWalkSpeed((float) 0.70);
					break;
				case 0:
					final Player player2 = player;
					new BukkitRunnable(){
						public void run(){
							player2.setWalkSpeed((float)-0.15);
						}
					}.runTaskLater((Plugin) this, 3L);
					break;
				case 2:
					player.setWalkSpeed((float) 0.2);
					break;
				}
			}
		}
		//switch playeraction
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onProjectileLaunchEvent(ProjectileLaunchEvent event){
		if(event.getEntity() instanceof Arrow){
			Arrow arrow = (Arrow)event.getEntity();
			if(arrow.getShooter() instanceof Player){
				Player playerShoother = (Player)arrow.getShooter();
				if(/*isSuitEnable(playerShoother) && (isPlayerHeldPredatorBow(playerShoother) is check suit)*/ 
					playerShoother.hasPermission("NanoSuit.Activate.PredatorBow.Aiming") && isPlayerHeldPredatorBow(playerShoother)){
					if(DataManager.isAimming(playerShoother)){
						DataManager.setAimming(playerShoother,false);
						playerShoother.setWalkSpeed((float) 0.2);
					};
				}; //Don't use else if à¾ÃÒÐÇèÒ àÃÒµéÍ§äÁèãËéâ»Ãà¨ç¡ä·´ìä´éÍÍ¡ä»
				if(isPlayerHeldPredatorBow(playerShoother)){
					//event.setCancelled(true);
					Vector velocity = arrow.getVelocity().multiply(DataManager.getArrowWeight(playerShoother));
					arrow.setVelocity(velocity);
					arrow.setMetadata("NanoArrow", ArrowFixedMetadataValue);
				} 
			}
		}
	}
	
	@EventHandler(priority = EventPriority.LOW)
	public void onArrowHit(ProjectileHitEvent event){
		if(event.getEntity() instanceof Arrow){
		    final Arrow arrow = (Arrow) event.getEntity();
		    if (!(arrow.getShooter() instanceof Player)){
		    	return;
		    }
		    Player playerShooter = (Player)arrow.getShooter();
		    if (!DataManager.isSuitEnable(playerShooter)){
		    	return;
		    }
		    if(isNanoArrowActivated(arrow) || !isNanoArrow(arrow)){
		    	//not Nanoarrow
		    	return;
		    }	
		    switch (DataManager.getCurrentArrow(playerShooter)){
		    case"Carbon-Impact":
		    	arrow.remove();
		    	break;
		    case"Electro":
		    	arrow.remove();
		    	break;
		    case"Super-thermite":
		    	if(isNanoArrowActivated(arrow)){
			    	return;
			    }
		    	final Location Hitlocation = event.getEntity().getLocation();
		    	new BukkitRunnable(){
		    			public void run(){
		    				if(isNanoArrowActivated(arrow)){
						    	return;
						    }
		    				arrow.setMetadata("NanoArrow", ArrowActivatedFixedMetadataValue);
		    				senddebugmessage("Arrow Task is run");
		    				Hitlocation.getWorld().createExplosion(	Hitlocation.getX(), 
		    						Hitlocation.getY() + 1,
		    						Hitlocation.getZ(), 
		    						3F, false, false);
		    						arrow.remove();
		    				this.cancel();
		    			}
		    		}.runTaskLater((Plugin) this, 60L);
		    	break;
		    case"Airburst Fragmentation":
		    	if(isNanoArrowActivated(arrow)){
			    	return;
			    }
		    	Location Hitlocation2 = event.getEntity().getLocation();
		    	Hitlocation2.getWorld().createExplosion(	Hitlocation2.getX(), 
		    												Hitlocation2.getY(),
		    												Hitlocation2.getZ(), 
		    												3F, false, false);
		    	arrow.remove();
				break;
		    }
		}
	}
	
	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
	public void onEntityTargetLivingEntity(EntityTargetLivingEntityEvent event){
		if (event.getTarget() instanceof Player)
	    {
			Player player = (Player)event.getTarget();
	    	if (player.hasPermission("NanoSuit.Activate.Cloak.MobIgnore") && DataManager.isSuitEnable(player) && DataManager.getCurrenceMode(player) == "cloak")
	    	{
	    		event.setCancelled(true);
	    		return;
	    	}
	    };
		if(event.getEntity() instanceof Spider){
			CraftSpider spider = (CraftSpider)event.getEntity();
			spider.setTarget(null);
			spider.getHandle().setGoalTarget(null);
		}
		else if(event.getEntity() instanceof CaveSpider){
			CraftCaveSpider spider = (CraftCaveSpider)event.getEntity();
			spider.setTarget(null);
			spider.getHandle().setGoalTarget(null);
		}
		else if(event.getEntity() instanceof Enderman){
			CraftEnderman Enderman = (CraftEnderman)event.getEntity();
			Enderman.setTarget(null);
			Enderman.getHandle().setGoalTarget(null);
		}
	}  
	
	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
	private void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event){
		// {{ Repair Armor path
		if(event.getEntity() instanceof Player)
        {
			Player player = (Player)event.getEntity();
			if(DataManager.isSuitEnable(player) && player.getInventory().getArmorContents() != null && DataManager.getCurrenceMode(player) != "airstorm"){
				ItemStack[] Armorcontent = player.getInventory().getArmorContents();
				for(int i = 0; i < Armorcontent.length; i++)
	            {
					Armorcontent[i].setDurability((short)(-Armorcontent[i].getType().getMaxDurability()));
	            }
			}
			else if(DataManager.getCurrenceMode(player) == "airstorm"){
				event.setCancelled(true);
			}
        }
		if(event.getDamager() instanceof Player){
			Player player = (Player)event.getDamager();
			if(!DataManager.isSuitEnable(player)){
				return;
			}
			ItemStack ItemInHand = player.getItemInHand();
			if(ItemInHand.getDurability() != ItemInHand.getType().getMaxDurability()){
				ItemInHand.setDurability(Short.MIN_VALUE);
			}
		}
		// }}

		Player HitPlayer = null;
		Creature HitCreature = null;
		if(event.getEntity() instanceof Player){
			HitPlayer = (Player)event.getEntity();
		}
		else if(event.getEntity() instanceof Creature){
			HitCreature = (Creature)event.getEntity();
		}
		else{
			return;
		}
		if(event.getDamager() instanceof Arrow){
			Arrow arrow = (Arrow)event.getDamager();
			if(isNanoArrow(arrow)){
				Player PlayerShooter = (Player)arrow.getShooter(); //whatever livingenitity can't shoot nanoarrow
				switch (DataManager.getCurrentArrow(PlayerShooter)){
				case"Carbon-Impact":
					//arrow.setMetadata("NanoArrow", ArrowActivatedFixedMetadataValue);
					//arrow.remove();
					break;
				case"Electro":
					arrow.setMetadata("NanoArrow", ArrowActivatedFixedMetadataValue);
					if (HitPlayer != null){
						HitPlayer.addPotionEffect(new PotionEffect(PotionEffectType.POISON ,250 , 20));
					}
					else if (HitCreature != null){
						HitCreature.addPotionEffect(new PotionEffect(PotionEffectType.POISON ,Integer.MAX_VALUE , 10));
					}
					arrow.remove();
					break;
				case"Super-thermite":
					final Arrow arrow2 = arrow;
					arrow.setMetadata("NanoArrow", ArrowActivatedFixedMetadataValue);
					if (HitPlayer != null){
						final Player Hitedplayer2 = HitPlayer;
						
						new BukkitRunnable(){
			    			public void run(){
			    				senddebugmessage("Arrow Task is run");
			    				Hitedplayer2.getWorld().createExplosion(	Hitedplayer2.getLocation().getX(), 
			    															Hitedplayer2.getLocation().getY() + 1,
			    															Hitedplayer2.getLocation().getZ(), 
			    															3F, false, false);
			    				arrow2.remove();
			    				arrow2.setMetadata("NanoArrow", ArrowActivatedFixedMetadataValue);
			    				this.cancel();
			    			}
			    		}.runTaskLater((Plugin) this, 60L);
					}
					else if (HitCreature != null){
						final Creature HittedCreatured2 = HitCreature;						
						new BukkitRunnable(){
			    			public void run(){
			    				senddebugmessage("Arrow Task is run");
			    				HittedCreatured2.getWorld().createExplosion(	HittedCreatured2.getLocation().getX(), 
			    																HittedCreatured2.getLocation().getY() + 1,
			    																HittedCreatured2.getLocation().getZ(), 
			    																3F, false, false);
			    				arrow2.remove();
			    				arrow2.setMetadata("NanoArrow", ArrowActivatedFixedMetadataValue);
			    				this.cancel();
			    			}
			    		}.runTaskLater((Plugin) this, 60L);
					}
					break;
				case"Airburst Fragmentation":
					break;
				}
			}
			else{
				return;
			}
		}
		
	}
	
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
	private void onPlayerPickupItemEvent(PlayerPickupItemEvent event){
		if(event.getItem() instanceof Arrow){
			Arrow arrow = (Arrow)event.getItem();
			if(isNanoArrow(arrow)){
				event.setCancelled(true);
				event.getPlayer().sendMessage("you can't pic up Nano arrow");
				return;
			}
		}
		else{
			return;
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerDeathEvent(PlayerDeathEvent event){
		if(!DataManager.isSuitEnable(event.getEntity())){
			return;
		}
		for(Iterator<ItemStack> Temstackiterator = event.getDrops().iterator() ; Temstackiterator.hasNext() ; ){
			ItemStack CheckingItem = Temstackiterator.next();
			if(isItemstackcomefromNanosuit(CheckingItem,event.getEntity())){
				Temstackiterator.remove();
			}
		}
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerRespawnEvent(PlayerRespawnEvent event){
		if(!DataManager.isSuitEnable(event.getPlayer())){
			return;
		}
		ChangeLoreNanoArrow(event.getPlayer(),DataManager.getCurrentArrow(event.getPlayer()));
		event.getPlayer().setItemInHand(GetPredatorBow(ThePredatorBowEnchantLevel));
		switch(DataManager.getCurrenceMode(event.getPlayer())){
		case"power":
			ActivatPowerMode(event.getPlayer());
			WearTheSuit(event.getPlayer(),PowerColor,PowerEnchantLevel);
			break;
		case"cloak":
			ActivatCloakMode(event.getPlayer());
			CloakSystemManager.setCloak(event.getPlayer(), true);
			break;
		case"armor":
			ActivatArmorMode(event.getPlayer());
			break;
		}
	}
//}}
	
// {{ CommandsManager ————————————————————————————————————————————————————————————————————————————————————————————————————————————————
	@Override
    public boolean onCommand(final CommandSender sender, Command command, String CommandLable, String[] args){
		Player player = null;
		 
        if(sender instanceof Player) {
            player = (Player) sender;
        }
        
        if(CommandLable.equalsIgnoreCase("nanosuit") || CommandLable.equalsIgnoreCase("suit")){
        	if (sender instanceof Player)
        	{
        		if((args.length <= 0 || args[0] == null || args[0].isEmpty() ) && player.hasPermission("NanoSuit.Activate"))
    			{
    				if (NowHavePlayer > Maximumplayer)
    				{
    					sendmsg(player,30);
    					return true;
    				}
    				if (!DataManager.isSuitEnable(player))
    				{
    					ActivateSuit(player);
    					DataManager.addtoUseNanosuitList(player);
    					return true;
    				}
    				else
    				{
    					if(CloakSystemManager.isCloak(player))
    					{
    						//removeGhostbutstillcanseeplayer(player);
    						CloakSystemManager.setCloak(player, false);
    					};
    					if (DataManager.issaveArmor(player))
    					{
    						player.getInventory().setArmorContents(DataManager.getsaveArmmor(player));
    					}
    					else 
    					{
    						removesuit(player);
    					}
    					DataManager.SetSuitEnable(player, false);
    					player.setHealthScale(20);
    					DataManager.RemoveAllMap(player);
    					DataManager.ResetTimesPressShift(player);
    					removethisItemnameFormInventory(player,ChatColor.RED + "PredatorBow");
    					removethisItemnameFormInventory(player,ChatColor.RED + "NanoArrow");
    					removeAllPotionEffect(player);
    					player.removePotionEffect(PotionEffectType.NIGHT_VISION);
    					DataManager.RemoveFormWhoUseNanosuitList(player);
    					removeAllPlayerFile(player);
    					DataManager.CreateMapEachPermission(player);
    					CheckNearPlayerManager.Stop(player);
    					sendmsg(player,18,ChatColor.RED);
    					return true;
    				}
    			}
    			else if(args[0].equalsIgnoreCase("reload") && player.hasPermission("NanoSuit.Reload"))
    			{
    				this.reloadConfig();
    				GetAllConFigData();
    				player.sendMessage(ChatColor.DARK_BLUE + "Configuration file reloaded");
    				player.sendMessage("Playe sound delaied for: " + playSoundDelaied);
    				return true;
    			}
    			else if(args[0].equalsIgnoreCase("RestoreDefaultConfig") && player.hasPermission("NanoSuit.RestoreDefaultConfig"))
    			{
    				//this.getConfig().options().copyDefaults(true);
    				saveConfig();
    				System.err.print("[Nanosuit] Restored Default Config");
    				return true;
    			}
    			else if(args[0].equalsIgnoreCase("help") && player.hasPermission("NanoSuit.Help"))
    			{
    				player.sendMessage("/nanosuit or /suit to activate Nanosuit");
    				player.sendMessage("/nanosuit reload to reload config");
    				player.sendMessage("/nanosuit restoredefaultconfig to restore default config");
    				player.sendMessage("/nanosuit nanovision or /nanosuit nv or /nanosuit n to activate Nano Vision");
    				return true;
    			}
    			else if(args[0].equalsIgnoreCase("NanoVision") || args[0].equalsIgnoreCase("NV") || args[0].equalsIgnoreCase("n") && player.hasPermission("NanoSuit.Activate.Nanovision"))
    			{
    				if (!(sender instanceof Player)) 
    				{
    					sender.sendMessage("This command can only be run by a player.");
    					return true;
    				};
    				if (player.hasPermission("NanoSuit.Activate.NanoVision"))
    				{
    					if (!DataManager.isSuitEnable(player)){
    						sendmsg(player,21);
    						return false;
    					}
    					if(!player.hasPotionEffect(PotionEffectType.NIGHT_VISION)){
    						if(!WillPlaySoundNVEnable){
    							sendmsg(player,22);
    			    		}
    			    		else{
    			    			playsound(player,NanoVisionEnable,NanovisionEnableVolume);
    			    			
    			    		}
    						player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 30));
    						//TODO Nightvision will see
    						return true;
    					}
    					else
    					{
    						if(!WillPlaySoundNVDisable){
    							sendmsg(player,23);
    			    		}
    			    		else{
    			    			playsound(player,NanoVisionDisable,NanovisionDisableVolume);
    			    		}
    						player.removePotionEffect(PotionEffectType.NIGHT_VISION);
    						if(!CloakSystemManager.isCloak(player)){
    							//TODO Stop NightVision can see
    						}
    						return true;
    					}
    				}
    				else
    				{
    					return false;
    				}
    			}
    			else if (args[0].equalsIgnoreCase("CheckConfig")){
    				DisplayConfig(sender);
    			}
    			else if (args[0].equalsIgnoreCase("CheckMyVariable")){
    				DataManager.Displayvaiable(player);
    			}
    			else if (args[0].equalsIgnoreCase("Aiming") && player.hasPermission("NanoSuit.Activate.PredatorBow.Aiming")){
    				try{
	    				if(args[1].length() == 1){
	    					if(args[1].equalsIgnoreCase("0") || args[1].equalsIgnoreCase("1") || args[1].equalsIgnoreCase("2")){
	    						DataManager.ChangeCurrentAimmingAction(player,Integer.parseInt(args[1]));
		    					//player.sendMessage("Your aiming action has been change to " + args[1]);
		    					sendmsg(player,3,args[1]);
		    					return true;
	    					}
	    					else{
	    						sendmsg(player,1);
	    						//player.sendMessage("Aiming action must be 0 or 1 or 2");
	    						sendmsg(player,4);
	    						//player.sendMessage("0 - zoom");
	    						sendmsg(player,5);
	    						//player.sendMessage("1 - move fast");
	    						sendmsg(player,6);
	    						//player.sendMessage("2 - nothing");
	    						return true;
	    					}
	    				}
	    				else{
    						sendmsg(player,1);
    						sendmsg(player,2);
    						sendmsg(player,4);
    						sendmsg(player,5);
    						sendmsg(player,6);
							return true;
	    				}
    				}
    				catch (ArrayIndexOutOfBoundsException e){
    					sendmsg(player,1);
						sendmsg(player,2);
						sendmsg(player,4);
						sendmsg(player,5);
						sendmsg(player,6);
    				}
    				return true;
    			}
    			else if (args[0].equalsIgnoreCase("Getplayerinteam") || args[0].equalsIgnoreCase("getTeam")){
    				try {
    					Player player1554 = Bukkit.getPlayer(args[1]); 
    					for(Iterator<OfflinePlayer> e = CheckNearPlayerManager.GetPlayerInTeam(player1554).iterator();e.hasNext();){
    						sender.sendMessage(e.next().getName());
        				}
    				}
    				catch (ArrayIndexOutOfBoundsException ex){
    					for(Iterator<OfflinePlayer> e = CheckNearPlayerManager.GetPlayerInTeam((Player)sender).iterator();e.hasNext();){
    						sender.sendMessage(e.next().getName());
        				}
    				}
    				return true;
    			}
    			else if ((args[0].equalsIgnoreCase("ArrowWeight") || args[0].equalsIgnoreCase("aw") && player.hasPermission("NanoSuit.Activate.PredatorBow.ArrowWeight") )){
    				try{
    					if(args[1].equalsIgnoreCase("0")){
    						DataManager.changeArrowWeight(player, (double) 1.0 );
    					}
    					else if(args[1].equalsIgnoreCase("1")){
    						DataManager.changeArrowWeight(player, (double) 0.5 );
    					}
    					else if(args[1].equalsIgnoreCase("2")){
    						DataManager.changeArrowWeight(player, (double) 1.5 );
    					}
    					else if(args[1].equalsIgnoreCase("3")){
    						DataManager.changeArrowWeight(player, (double) 2.0 );
    					}
    					else if(args[1].equalsIgnoreCase("4")){
    						DataManager.changeArrowWeight(player, (double) 2.5 );
    					}
    					else{
    						sendmsg(player,7);
    						sendmsg(player,9);
    						sendmsg(player,10);
    						sendmsg(player,11);
    						sendmsg(player,12);
    						sendmsg(player,13);
        					/*player.sendMessage("Arrow has only 5 weight(0-4)");
        					player.sendMessage("0: normal weight");
        					player.sendMessage("1: heavy weight");
        					player.sendMessage("2: light weight");
        					player.sendMessage("3: lighter weight");
        					player.sendMessage("4: lightest weight");*/
    						return true;
    					}
    					//player.sendMessage("Your arrow is now weight " + args[1]);
    					sendmsg(player,8,args[1]);
    					return true;
    				}
    				catch(ArrayIndexOutOfBoundsException e){
						sendmsg(player,7);
						sendmsg(player,9);
						sendmsg(player,10);
						sendmsg(player,11);
						sendmsg(player,12);
						sendmsg(player,13);
    					return true;
    				}
    			}
    			else
    			{
    				//player.sendMessage(ChatColor.GOLD + "/nanosuit or /suit to wear suit");
    				return false;
    			}
    		}
        	else //not player
        	{
        		if(args[0].equalsIgnoreCase("reload"))
				{
        			this.reloadConfig();
        			GetAllConFigData();
					sender.sendMessage(ChatColor.DARK_BLUE + "Config file reloaded");
					sender.sendMessage("Playe sound delaied for: " + playSoundDelaied);
					return true;
				}
        		else if (args[0].equalsIgnoreCase("CheckConfig")){
        			DisplayConfig(sender);
    			}
				else
				{
					sender.sendMessage("This command can only be run by a player.");
					return false;
				}
        	}
        	
        }
        else if(CommandLable.equalsIgnoreCase("setsuit") || CommandLable.equalsIgnoreCase("setnanosuit")){
			try{
				if (args[0].length() >= 1)
				{
					if (sender instanceof Player)
					{
						if (!sender.hasPermission("NanoSuit.Setsuit"))
						{
							return true;
						};
					};
					Player TargetPlayer = Bukkit.getServer().getPlayer(args[0]);
					if (TargetPlayer != null)
					{
						if (NowHavePlayer > Maximumplayer)
						{
							sender.sendMessage("Maximum player reached");
							sendmsg(TargetPlayer,30);
							//TargetPlayer.sendMessage("You can't use Nanosuit now, Maximum player reached");
							return true;
						}
						if (!DataManager.isSuitEnable(TargetPlayer))
						{
							DataManager.addtoUseNanosuitList(TargetPlayer);
							ActivateSuit(TargetPlayer);
							return true;
						}
						else
						{
							if(CloakSystemManager.isCloak(TargetPlayer))
							{
								CloakSystemManager.setCloak(TargetPlayer, false);
							};
							if (DataManager.issaveArmor(TargetPlayer))
							{
								TargetPlayer.getInventory().setArmorContents(DataManager.getsaveArmmor(TargetPlayer));
							}
							else 
							{
								removesuit(TargetPlayer);
							}
							DataManager.SetSuitEnable(TargetPlayer, false);
							TargetPlayer.setHealthScale(20);
							DataManager.RemoveAllMap(TargetPlayer);
							DataManager.ResetTimesPressShift(TargetPlayer);
							removeAllPotionEffect(TargetPlayer);
							removethisItemnameFormInventory(TargetPlayer,ChatColor.RED + "PredatorBow");
	    					removethisItemnameFormInventory(TargetPlayer,ChatColor.RED + "NanoArrow");
	    					DataManager.RemoveFormWhoUseNanosuitList(TargetPlayer);
	    					removeAllPlayerFile(TargetPlayer);
	    					DataManager.CreateMapEachPermission(TargetPlayer);
	    					CheckNearPlayerManager.Stop(TargetPlayer);
							//TargetPlayer.sendMessage(ChatColor.RED + "Taken your Nanosuit");
							sendmsg(TargetPlayer,18,ChatColor.RED);
							return true;
						}
					}
					else
					{
						if (!(sender instanceof Player))
						{
							System.err.print("[Nanosuit] Can't activate Nanosuit for " + args[0] +", Player is offline or not avilable");
						}
						else
						{
							sender.sendMessage("[Nanosuit] Can't activate Nanosuit for " + args[0] +", Player is offline or not avilable");
						}
						return true;
					}
				}
				else
				{
					System.err.print("Target player can't be emty");
					return true;
				}
			}
			catch (ArrayIndexOutOfBoundsException e){
				if (sender instanceof Player)
				{
					sender.sendMessage("Target player can't be emty");
				}
				else {
					System.err.print("[Nanosuit] Target player can't be emty");
				}
				System.err.print("[Nanosuit] Command 'setsuit' has been excute from: " + sender.getName());
				return true;
			}
		}
        return false;
	}
// }}
		
// {{ MethodManager ——————————————————————————————————————————————————————————————————————————————————————————————————————————————————
	
	//{{ Suit Manager
	private void ActivatArmorMode(Player player){
		if (WillPlaySoundArmor)
		{
			playsound(player,MaximumArmor,ArmorVolume);
		}
		else
		{
			//player.sendMessage(ChatColor.RED + "Maximum Armmor");
			sendmsg(player,15,ChatColor.RED);
		}
		CloakSystemManager.setCloak(player, false);
		WearTheSuit(player,ArmorColor,ArmorEnchantLevel);
		removeAllPotionEffect(player);
		player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 15));
		player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 15));
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 1));
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 4));
		//player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, Integer.MAX_VALUE, 15));
		//player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE, 15));
		player.setHealthScale(40);
		DataManager.setCurrenceMode(player,"armor");
	}
	private void ActivatPowerMode(Player player){
		CloakSystemManager.setCloak(player, false);
		//player.sendMessage("anothercanseewhenin = " + String.valueOf(anothercanseewhenin));
		if (!player.hasPotionEffect(PotionEffectType.SPEED))
    	{
			if (WillPlaySoundPower)
			{
				playsound(player,MaximumPower,PowerVolume);
			}
			else
			{
				player.sendMessage(ChatColor.GREEN + "Maximum power");
			}
			removeAllPotionEffect(player);
			WearTheSuit(player,PowerColor,PowerEnchantLevel);
			player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 12));
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 7));
			player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 15));
			player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 15));
			player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 2));
			player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 15));
    	};
    	DataManager.setCurrenceMode(player,"power");
	}
	private void ActivatCloakMode(Player player){
		if (WillPlaySoundCloak)
		{
			playsound(player,CloakEngaged,CloakVolume);
		}
		else
		{
			player.sendMessage(ChatColor.GREEN + "Cloak engaged");
		}
		removeAllPotionEffect(player);
		player.setFireTicks(0);
		RemoveArrow(player);
		removesuit(player);
		player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 15));
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 2));
		CloakSystemManager.setCloak(player, true);
		DataManager.setCurrenceMode(player,"cloak");
		if (player.hasPermission("NanoSuit.Activate.Cloak.MobIgnore")){
			InstanceIgnoreMe(player);
		}
		removethisItemnameFormInventory(player,ChatColor.RED + "PredatorBow");
		player.getInventory().setItem(getfirstEmtyExceptThisSlot(player,player.getInventory().getHeldItemSlot()), GetPredatorBow(ThePredatorBowEnchantLevel));
	}
	private void ActivateSuit(Player player){

		if (getFirstEmtySlot(player) != -1)
		{
			player.getInventory().setItem(getFirstEmtySlot(player) , GetNanoArrow());
		}
		else
		{
			player.sendMessage("All slot is full");
			return;
		}
		NowHavePlayer += 1;
		DataManager.CreateMapEachPermission(player);
		DataManager.saveArmmor(player, player.getInventory().getArmorContents());
		ActivatArmorMode(player);
		DataManager.SetSuitEnable(player, true);
		player.sendMessage(ChatColor.GREEN + "Nanosuit activated!");
		player.setItemInHand(GetPredatorBow(ThePredatorBowEnchantLevel));
		DataManager.setCurrentArrow(player,"Carbon-Impact");
		//TODO Addplayerteam
		String Teamname = player.getName() + "_Cloak";
		Team playerteam = null;
		if(Cloakboard.getTeam(Teamname) != null){
			playerteam = Cloakboard.getTeam(Teamname);
		}
		else{
			playerteam = Cloakboard.registerNewTeam(Teamname);
		}
		playerteam.addPlayer(player);
		playerteam.setCanSeeFriendlyInvisibles(true);
		CheckNearPlayerManager.Start(player);		
	}
	private void WearTheSuit(Player player, int i,int enchantlevel){
		//helmet
		ItemStack suitHelmet = new ItemStack(Material.LEATHER_HELMET);
		ColorizeAndEnchant(suitHelmet,i, enchantlevel, "NanoHelmet");
		player.getInventory().setHelmet(suitHelmet);
		//Chestplate
		ItemStack suitChestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
		ColorizeAndEnchant(suitChestplate,i, enchantlevel, "NanoChestplate");
		player.getInventory().setChestplate(suitChestplate);
		//Leggings
		ItemStack suitLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
		ColorizeAndEnchant(suitLeggings,i, enchantlevel, "NanoLeggings");
		player.getInventory().setLeggings(suitLeggings);
		//Boots
		ItemStack suitBoots = new ItemStack(Material.LEATHER_BOOTS);
		ColorizeAndEnchant(suitBoots,i, enchantlevel, "NanoBoots");
		player.getInventory().setBoots(suitBoots);
	}
	private void removesuit(Player player){
		player.getInventory().setArmorContents(null);
	}
	private boolean isAirStorm(Player player){
		if(DataManager.getCurrenceMode(player)=="airstorm")
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	private void ActivateAirStorm(Player player){
		if(!player.hasPermission("NanoSuit.Activate.AirStorm")){
			return;
		}
		int cooldownTime = AirStormCooldownTime; // Get number of seconds from wherever you want
        if(DataManager.isPutOnAirStormCoolDown(player) && !player.hasPermission("NanoSuit.Activate.AirStorm.BypassCooldown")) {
            long secondsLeft = ((DataManager.getCooldowntime(player)/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
            if(secondsLeft>0) {
                // Still cooling down
            	player.sendMessage("Air Storm has been cooling down for "+ secondsLeft +" seconds!");
            }
            else{
            	DataManager.setCoolDownTime(player, System.currentTimeMillis()); 
            	AirStormimg(player);
            }
        }
        else { 
        	DataManager.setCoolDownTime(player, System.currentTimeMillis());
        	AirStormimg(player);
        }
		return;
	}
	private void AirStormimg(Player player){
		//set to armor
		CloakSystemManager.setCloak(player, false);
		WearTheSuit(player,ArmorColor,ArmorEnchantLevel);
		removeAllPotionEffect(player);
		player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 15));
		player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 15));
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 1));
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 200));
		//player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, Integer.MAX_VALUE, 15));
		//player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE, 15));
		player.setHealthScale(40);
		DataManager.setCurrenceMode(player,"airstorm");
		player.setVelocity(new Vector(0D,-10D,0D));
		new AirStorm((Plugin)this,player,DataManager);;	
		if(!WillPlaySoundAirStorm){
			player.sendMessage("Air Storm");
		}
		else{
			playsound(player,AirStorm,AirStormVolume);
		}
	}
	//}}
	
	//{{ General Function
	private boolean isItemstackcomefromNanosuit(ItemStack itemstack, Player player){
		if(!itemstack.hasItemMeta()){
			return false;
		}
		if(!itemstack.getItemMeta().hasLore()){
			return false;
		}
		if(!itemstack.getItemMeta().hasDisplayName()){
			return false;
		}
		List<String> itemLore = itemstack.getItemMeta().getLore();
		List<String> lorenanosuit = Arrays.asList("Nanosuit(Also known as Nano-Muscle Suits) 2.0 By CryNet" ,
				"Reverse- engineered from captured Ceph technology ",
				"the suit's CryFibril can be programmed for a variety of purposes",
				"(Such as hardening to absorb more damage, ",
				"muscle augmentation, or invisibility)",
				"There are 3 mode avilable", 
				"1.Cloak Mode which make you look transprent(Ativate by press shift)", 
				"2.Speed and Power Mode this mode will make you faster",
				"and high jumping(Activate by press Q when hold 'ThePredatorBow')",
				"3.Armor Mode(This is default mode)");
		//PredatorBow
		if(itemLore.equals(GetPredatorBow(ThePredatorBowEnchantLevel).getItemMeta().getLore())){
			return true;
		}
		//Nanoarrow
		else if(itemstack.getItemMeta().getDisplayName().equals(ChatColor.RED + "NanoArrow")){
			if(itemLore.contains((DataManager.getCurrentArrow(player)))){
				return true;
			}
			else{
				return false;
			}
		}
		//Armor
		else if(itemLore.equals(lorenanosuit)){
			return true;
		}
		else{
			return false;
		}
	}
	private boolean isPlayerHeldPredatorBow(Player player){
		if(!DataManager.isSuitEnable(player)){
			return false;
		}
		if(player.getItemInHand() != null){
			if(player.getItemInHand().hasItemMeta()){
				if(player.getItemInHand().getItemMeta().hasLore()){
					if(player.getItemInHand().getItemMeta().getLore().equals(GetPredatorBow(ThePredatorBowEnchantLevel).getItemMeta().getLore())){
						return true;
					};
					return false;
				};
				return false;
			};
			return false;
		};
		return false;
	}
	private boolean isNanoArrow(Arrow arrow){
		if(arrow.getMetadata("NanoArrow").toString().equals(StringArrowFixedMetadataValue) || arrow.getMetadata("NanoArrow").toString().equals(StringArrowActivatedFixedMetadataValue) ){
			return true;
		}
		else{
			return false;
		}
	}
	private boolean isNanoArrowActivated(Arrow arrow){
		if(arrow.getMetadata("NanoArrow").toString().equals(StringArrowActivatedFixedMetadataValue)){
			return true;
		}
		else{
			return false;
		}
	}
	private void RemoveArrow(Player player){
		((CraftPlayer) player).getHandle().getDataWatcher().watch(9,(byte) 0);
	}
	private ItemStack GetPredatorBow(int o){
		ItemStack i = new ItemStack(Material.BOW);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "PredatorBow");
		List<String> lorenanosuit = Arrays.asList(	ChatColor.RED +			"The Predator Bow has 4 arrow types:" ,
													ChatColor.DARK_GREEN + 	"Carbon-Impact arrow: The basic arrow for the bow," ,
													ChatColor.DARK_GREEN + "will remove after hit target." ,
													ChatColor.DARK_PURPLE +	"Electro arrow:  When shot at an enemy," ,
													ChatColor.DARK_PURPLE + "it electrocutes/stuns them." ,
													ChatColor.BLUE + 		"Super-thermite arrow: It will create",
													ChatColor.BLUE + 		"a small explode after 3.3 seconds" ,
													ChatColor.DARK_BLUE + 	"Airburst Fragmentation arrow:" ,
													ChatColor.DARK_BLUE + 	"instantly create explosion");
		meta.setLore(lorenanosuit);
		i.setItemMeta(meta);
		i.addUnsafeEnchantment(Enchantment.DURABILITY, o);
		i.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, o);
		i.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 10);
		i.addUnsafeEnchantment(Enchantment.WATER_WORKER, o);
		i.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 9);
		return i;
	}
	private ItemStack GetNanoArrow(){
		ItemStack NanoArrow = new ItemStack(Material.ARROW);
		ItemMeta meta = NanoArrow.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "NanoArrow");
		List<String> loreARROW = Arrays.asList("Carbon-Impact");
		meta.setLore(loreARROW);
		NanoArrow.setItemMeta(meta);
		return NanoArrow;
	}
	private void ChangeLoreNanoArrow(Player player,String lore){
		removethisItemnameFormInventory(player,ChatColor.RED + "NanoArrow");
		ItemStack NanoArrow = GetNanoArrow();
		ItemMeta meta = NanoArrow.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "NanoArrow");
		List<String> loreARROW = Arrays.asList(lore);
		meta.setLore(loreARROW);
		NanoArrow.setItemMeta(meta);
		player.getInventory().setItem(getFirstEmtySlot(player) , NanoArrow);
	}
	private void removethisItemnameFormInventory(Player player,String s){
		//player.sendMessage("Removing " + s);
		for(int i = 0; i <= 35; i++)
		{
			if (player.getInventory().getItem(i) != null)
			{
				//player.sendMessage("1Check at : " + String.valueOf(i) + " Found "+ player.getInventory().getItem(i).getItemMeta().getDisplayName());
				if(player.getInventory().getItem(i).getItemMeta().getDisplayName() != null 
				&& player.getInventory().getItem(i).getItemMeta().getDisplayName().contains(s))
				{
					//player.sendMessage("2Removing At = " + String.valueOf(i));
					player.getInventory().clear(i);
				}
			}
		}
	}
	private void removeAllPotionEffect(Player player){
		for (PotionEffect effect : player.getActivePotionEffects())	{
			if 	(	!(effect.getType().equals(PotionEffectType.NIGHT_VISION))
				&& 	!(effect.getType().equals(PotionEffectType.POISON))
				&& 	!(effect.getType().equals(PotionEffectType.CONFUSION))
				&& 	!(effect.getType().equals(PotionEffectType.HARM))
				&& 	!(effect.getType().equals(PotionEffectType.HUNGER))
				&& 	!(effect.getType().equals(PotionEffectType.SLOW))
				&& 	!(effect.getType().equals(PotionEffectType.SLOW_DIGGING))
				&& 	!(effect.getType().equals(PotionEffectType.WEAKNESS))
				&& 	!(effect.getType().equals(PotionEffectType.BLINDNESS))){
				player.removePotionEffect(effect.getType());
			}
		}
	}
	private static ItemStack colorize(ItemStack item, int rgb,String Disname){
		  LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		  meta.setColor(Color.fromRGB(rgb));
		  meta.setDisplayName(Disname);
		  List<String> lorenanosuit = Arrays.asList("Nanosuit(Also known as Nano-Muscle Suits) 2.0 By CryNet" ,
				  									"Reverse- engineered from captured Ceph technology ",
				  									"the suit's CryFibril can be programmed for a variety of purposes",
				  									"(Such as hardening to absorb more damage, ",
				  									"muscle augmentation, or invisibility)",
				  									"There are 3 mode avilable", 
				  									"1.Cloak Mode which make you look transprent(Ativate by press shift)", 
				  									"2.Speed and Power Mode this mode will make you faster",
				  									"and high jumping(Activate by press Q when hold 'ThePredatorBow')",
				  									"3.Armor Mode(This is default mode)");
		  meta.setLore(lorenanosuit);
		  item.setItemMeta(meta);
		  return item;
		}
	private ItemStack ColorizeAndEnchant(ItemStack i, int rgb,int o,String ItemName){
		/*i.addUnsafeEnchantment(Enchantment.DURABILITY, o);
		i.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, o);
		i.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, o);
		i.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, o);
		i.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, o);
		i.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, o);
		i.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, o);*/
		colorize(i, rgb,ItemName);
		
		return i;
	}
	private void playsound(Player player,Sound s,Float soundvolume){
		if(((player.getWorld().getTime() - DataManager.GetPlaySoundStartTime(player)) >= playSoundDelaied || (player.getWorld().getTime() - DataManager.GetPlaySoundStartTime(player) <= 0L)) && DataManager.GetPlaySoundStartTime(player) != null)
		{
			DataManager.StartPlaySound(player,s,soundvolume);
			return;
		}
		else
		{
			return;
		}
	}
	private int getFirstEmtySlot(Player player){
		for (int i = 9 ; i <= 36 ; i++)	{
			if(player.getInventory().getItem(i) == null){
				return i;
			}
		}
		return -1;
	}
	private int getfirstEmtyExceptThisSlot(Player player,int i){
		for (int o = 0 ; o <= 36 ; o++)	{
			if(player.getInventory().getItem(o) == null && o != i){
				return o;
			}
		}
		return -1;
	}
	private void InstanceIgnoreMe(Player player){
		for(Iterator<Entity> e = player.getNearbyEntities(15, 15, 15).iterator() ; e.hasNext(); )
		{
			Entity entity = e.next();
			if (entity instanceof Creature)
			{
				Creature mob = (Creature)entity;
				if (mob.getTarget() == player)
				{
					//player.sendMessage("Making mob ignore");
					SetTargetnullfor(mob);
				}
			}
		}
	}
	private void SetTargetnullfor(Entity mob){
		if(mob.getType() == EntityType.SNOWMAN){
			CraftSnowman snow = (CraftSnowman) mob;
			snow.getHandle().setGoalTarget(null);
		}
		else if(mob.getType() == EntityType.BLAZE){
			CraftBlaze blaze = (CraftBlaze) mob;
			blaze.getHandle().setGoalTarget(null);
		}
		else if(mob.getType() == EntityType.CAVE_SPIDER){
			CraftCaveSpider cavespider = (CraftCaveSpider) mob;
			cavespider.getHandle().setGoalTarget(null);
		}
		else if(mob.getType() == EntityType.CREEPER){
			CraftCreeper creeper = (CraftCreeper) mob;
			creeper.getHandle().setGoalTarget(null);
		}
		else if(mob.getType() == EntityType.ENDER_DRAGON){
			CraftEnderDragon mob2 = (CraftEnderDragon) mob;
			mob2.getHandle().setGoalTarget(null);
		}
		else if(mob.getType() == EntityType.ENDERMAN){
			CraftEnderman mob2 = (CraftEnderman) mob;
			mob2.getHandle().setGoalTarget(null);
		}
		else if(mob.getType() == EntityType.GHAST){
			CraftGhast mob2 = (CraftGhast) mob;
			mob2.getHandle().setGoalTarget(null);
		}
		else if(mob.getType() == EntityType.GIANT){
			CraftGiant mob2 = (CraftGiant) mob;
			mob2.getHandle().setGoalTarget(null);
		}
		else if(mob.getType() == EntityType.IRON_GOLEM){
			CraftIronGolem mob2 = (CraftIronGolem) mob;
			mob2.getHandle().setGoalTarget(null);
		}
		else if(mob.getType() == EntityType.MAGMA_CUBE){
			CraftMagmaCube mob2 = (CraftMagmaCube) mob;
			mob2.getHandle().setGoalTarget(null);
		}
		else if(mob.getType() == EntityType.PIG_ZOMBIE){
			CraftPigZombie mob2 = (CraftPigZombie) mob;
			mob2.getHandle().setGoalTarget(null);
		}
		else if(mob.getType() == EntityType.SILVERFISH){
			CraftSilverfish mob2 = (CraftSilverfish) mob;
			mob2.getHandle().setGoalTarget(null);
		}
		else if(mob.getType() == EntityType.SKELETON){
			CraftSkeleton mob2 = (CraftSkeleton) mob;
			mob2.getHandle().setGoalTarget(null);
		}
		else if(mob.getType() == EntityType.SLIME){
			CraftSlime mob2 = (CraftSlime) mob;
			mob2.getHandle().setGoalTarget(null);
		}
		else if(mob.getType() == EntityType.SPIDER){
			CraftSpider mob2 = (CraftSpider) mob;
			mob2.getHandle().setGoalTarget(null);
		}
		else if(mob.getType() == EntityType.WITCH){
			CraftWitch mob2 = (CraftWitch) mob;
			mob2.getHandle().setGoalTarget(null);
		}
		else if(mob.getType() == EntityType.WITHER){
			CraftWither mob2 = (CraftWither) mob;
			mob2.getHandle().setGoalTarget(null);
		}
		else if(mob.getType() == EntityType.WOLF){
			CraftWolf mob2 = (CraftWolf) mob;
			mob2.getHandle().setGoalTarget(null);
		}
		else if(mob.getType() == EntityType.ZOMBIE){
			CraftZombie mob2 = (CraftZombie) mob;
			mob2.getHandle().setGoalTarget(null);
		}
	}
	private void removeAllPlayerFile(Player player){
		File SaveArmordotyml = new File(getDataFolder() + "/Data/" + player.getName() + ".yml");
		File playerdata = new File(getDataFolder() + "/Data/" + player.getName() + ".txt");
		if(SaveArmordotyml.exists()){
			SaveArmordotyml.delete();
		};
		if(playerdata.exists()){
			playerdata.delete();
		};
	}
	//}}
	
// }}
	
// {{ ConfigPart —————————————————————————————————————————————————————————————————————————————————————————————————————————————————————
	public void GetAllConFigData(){
		try 
		{
			TimesPressShiftWarring = this.getConfig().getInt("Enable-Press-Shift-help.Times-Press-Shift-Before-helping-player")*2;
			TimesPressShiftWarring = TimesPressShiftWarring - 1;
			TimesPressShiftWarringBool = this.getConfig().getBoolean("Enable-Press-Shift-help.Enable");
			ArmorEnchantLevel = this.getConfig().getInt("Nanosuit-Config.Mode.Armor.Enchant-Level");
			PowerEnchantLevel = this.getConfig().getInt("Nanosuit-Config.Mode.Power.Enchant-Level");
			anothercanseewhenin = this.getConfig().getInt("Nanosuit-Config.other-player-will-see-cloak-people-when-in-range");
			Maximumplayer = this.getConfig().getInt("Nanosuit-Config.maxplayer-can-activate-Nanosuit-per-time");
			CloakEngaged = checksoundformconfig("cloak");
			MaximumArmor = checksoundformconfig("armor");
			MaximumPower = checksoundformconfig("power");
			WillPlaySoundCloak = this.getConfig().getBoolean("Nanosuit-Config.Mode.Cloak.Sound.Enable");
			WillPlaySoundArmor = this.getConfig().getBoolean("Nanosuit-Config.Mode.Armor.Sound.Enable");
			WillPlaySoundPower = this.getConfig().getBoolean("Nanosuit-Config.Mode.Power.Sound.Enable");
			CloakVolume = Float.valueOf(this.getConfig().getString("Nanosuit-Config.Mode.Cloak.Sound.Volume"));
			ArmorVolume = Float.valueOf(this.getConfig().getString("Nanosuit-Config.Mode.Armor.Sound.Volume"));
			PowerVolume = Float.valueOf(this.getConfig().getString("Nanosuit-Config.Mode.Power.Sound.Volume"));
			ArmorColor = this.getConfig().getInt("Nanosuit-Config.Mode.Armor.Color");
			PowerColor = this.getConfig().getInt("Nanosuit-Config.Mode.Power.Color");
			playSoundDelaied = this.getConfig().getLong("Nanosuit-Config.Time-delay-before-playing-sound");
			ThePredatorBowEnchantLevel = this.getConfig().getInt("Nanosuit-Config.Enchant-ThePredatorBow-Level");
			AirStormCooldownTime = this.getConfig().getInt("Nanosuit-Config.Utility.AirStorm.Cooldown-Time");
			AirStormVolume = Float.valueOf(this.getConfig().getString("Nanosuit-Config.Utility.AirStorm.SoundVolume"));
			NanovisionEnableVolume = Float.valueOf(this.getConfig().getString("Nanosuit-Config.Utility.Nanovision.Enablesound.Volume"));
			NanovisionDisableVolume = Float.valueOf(this.getConfig().getString("Nanosuit-Config.Utility.Nanovision.Disablesound.Volume"));
			AirStorm = checksoundformconfig("airstorm");
			NanoVisionEnable = checksoundformconfig("nvenable");
			NanoVisionDisable = checksoundformconfig("nvdisable");
			WillPlaySoundAirStorm = this.getConfig().getBoolean("Nanosuit-Config.Utility.AirStorm.PlaySound");
			WillPlaySoundNVEnable = this.getConfig().getBoolean("Nanosuit-Config.Utility.Nanovision.Enablesound.Enable");
			WillPlaySoundNVDisable = this.getConfig().getBoolean("Nanosuit-Config.Utility.Nanovision.Disablesound.Enable");
			CanUseAirStormConfig = this.getConfig().getBoolean("Nanosuit-Config.Utility.AirStorm.Enable");
		}
		catch (Exception e)
		{
			System.err.print("[Nanosuit] Configfile error******************************");
		}
	}
	private void DisplayConfig(CommandSender sender){
		sender.sendMessage("/////////////START//////////////");
		sender.sendMessage("TimesPressShiftWarring: " + TimesPressShiftWarring);
		sender.sendMessage("TimesPressShiftWarringBool: " + TimesPressShiftWarringBool);
		sender.sendMessage("ArmorEnchantLevel: " + ArmorEnchantLevel);
		sender.sendMessage("PowerEnchantLevel: " + PowerEnchantLevel);
		sender.sendMessage("anothercanseewhenin: " + anothercanseewhenin);
		sender.sendMessage("Maximumplayer: " + Maximumplayer);
		sender.sendMessage("WillPlaySoundCloak: " + WillPlaySoundCloak);
		sender.sendMessage("WillPlaySoundArmor: " + WillPlaySoundArmor);
		sender.sendMessage("WillPlaySoundPower: " + WillPlaySoundPower);
		sender.sendMessage("CloakVolume: " + CloakVolume);
		sender.sendMessage("ArmorVolume: " + ArmorVolume);
		sender.sendMessage("PowerVolume: " + PowerVolume);
		sender.sendMessage("ArmorColor: " + ArmorColor);
		sender.sendMessage("PowerColor: " + PowerColor);
		sender.sendMessage("playSoundDelaied: " + playSoundDelaied);
		sender.sendMessage("ThePredatorBowEnchantLevel: " + ThePredatorBowEnchantLevel);
		sender.sendMessage("AirStormCooldownTime: " + AirStormCooldownTime);
		sender.sendMessage("AirStormVolume: " + AirStormVolume);
		sender.sendMessage("WillPlaySoundAirStorm: " + WillPlaySoundAirStorm);
		sender.sendMessage("WillPlaySoundNVEnable: " + WillPlaySoundNVEnable);
		sender.sendMessage("WillPlaySoundNVDisable: " + WillPlaySoundNVDisable);
		sender.sendMessage("CanUseAirStormConfig: " + CanUseAirStormConfig);
		sender.sendMessage("CloakEngaged: " + CloakEngaged);
		sender.sendMessage("MaximumArmor: " + MaximumArmor);
		sender.sendMessage("MaximumPower: " + MaximumPower);
		sender.sendMessage("AirStorm: " + AirStorm);
		sender.sendMessage("NanoVisionEnable: " + NanoVisionEnable);
		sender.sendMessage("NanoVisionDisable: " + NanoVisionDisable);
		sender.sendMessage("/////////////END//////////////");
	}
	private Sound checksoundformconfig(String s){
		if (s.toLowerCase() == "cloak"){
			String soundtemp = this.getConfig().getString("Nanosuit-Config.Mode.Cloak.Sound.Play-This-Sound");
			logger.info("For cloak sound is: " + soundtemp);
			return Sound.valueOf(soundtemp.toUpperCase());
		}
		else if (s.toLowerCase() == "armor"){
			String soundtemp = this.getConfig().getString("Nanosuit-Config.Mode.Armor.Sound.Play-This-Sound");
			logger.info("For armor sound is: " + soundtemp);
			return Sound.valueOf(soundtemp.toUpperCase());
		}
		else if (s.toLowerCase() == "power"){
			String soundtemp = this.getConfig().getString("Nanosuit-Config.Mode.Power.Sound.Play-This-Sound");
			logger.info("For power sound is: " + soundtemp);
			return Sound.valueOf(soundtemp.toUpperCase());
		}
		else if (s.toLowerCase() == "airstorm"){
			String soundtemp = this.getConfig().getString("Nanosuit-Config.Utility.AirStorm.Play-This-Sound");
			logger.info("For Air Storm sound is: " + soundtemp);
			return Sound.valueOf(soundtemp.toUpperCase());
		}
		else if (s.toLowerCase() == "nvenable"){
			String soundtemp = this.getConfig().getString("Nanosuit-Config.Utility.Nanovision.Enablesound.Play-This-Sound");
			logger.info("For enable Nanovision sound is: " + soundtemp);
			return Sound.valueOf(soundtemp.toUpperCase());
		}
		else if (s.toLowerCase() == "nvdisable"){
			String soundtemp = this.getConfig().getString("Nanosuit-Config.Utility.Nanovision.Disablesound.Player-This-Sound");
			logger.info("For disable Nanovision sound is: " + soundtemp);
			return Sound.valueOf(soundtemp.toUpperCase());
		}
		else{
			return Sound.VILLAGER_HAGGLE;
		}
	}
// }}
		
}
