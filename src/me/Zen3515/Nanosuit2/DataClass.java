package me.Zen3515.Nanosuit2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class DataClass {
	
	private boolean debugging = false;
	private void senddebugmessage(String text){
		if(debugging == true){
			if(Bukkit.getPlayer("Zen3515") != null){
				Bukkit.getPlayer("Zen3515").sendMessage(text);
			};			
		};
	}
	
	private HashMap<Player, Integer> HashMapPlayerData = new HashMap<Player, Integer>();
	private HashMap<Player, Boolean> HashMapPlayerSuitStatus = new HashMap<Player, Boolean>();
	private HashMap<Player, ItemStack[]> HashMapPlayerSavedArmor = new HashMap<Player, ItemStack[]>();
	private HashMap<Player, Long> HashMapPlayerPlaySoundStartTime = new HashMap<Player, Long>();
	private HashMap<Player, Integer> HashMapPlayerPlayTimesPressShift = new HashMap<Player, Integer>();
	private HashMap<Player, String> HashMapPlayerCurrentMode = new HashMap<Player, String>();
	private HashMap<Player, Double> HashMapPlayerStratAirStormBlock = new HashMap<Player, Double>();
	private HashMap<Player, Boolean> HashMapPlayerAirStormAble = new HashMap<Player, Boolean>();
	private HashMap<Player, String> HashMapPlayerCurrentArrow = new HashMap<Player, String>();
	private HashMap<Player, Long> AirStormCoolDown = new HashMap<Player, Long>();
	private HashMap<Player, Integer> HashMapPlayerAirStormData = new HashMap<Player, Integer>();
	private HashMap<Player, Integer> HashMapAimmingAction = new HashMap<Player, Integer>();
	private HashMap<Player, Boolean> HashMapAimingTarget = new HashMap<Player, Boolean>();
	private HashMap<Player, Double> HashMapArrowWeight = new HashMap<Player, Double>();
	private HashMap<Player, Double> HashMapFormJumping = new HashMap<Player, Double>();
	private HashMap<Player, Boolean> HashMapisPutOnFormJumping = new HashMap<Player, Boolean>();
	
	int NowHavePlayer = 0;
	private Plugin Nanosuit;
	private CloakSystem CloakSystemManager;
	private List<String> LitsforwhouseNanosuit = null;	
	
	public DataClass(Plugin nanosuit,CloakSystem CS){
		Nanosuit = nanosuit;
		CloakSystemManager = CS;
		LitsforwhouseNanosuit = new ArrayList<String>();
	}
	public void addtoUseNanosuitList(Player player){
		if(!LitsforwhouseNanosuit.contains(player.getName())){
			LitsforwhouseNanosuit.add(player.getName());
			NowHavePlayer++;
		}
	}
	public void addtoUseNanosuitListOnJoin(Player player){
		if(LitsforwhouseNanosuit.contains(player.getName())){
			CreateMapEachPermission(player);
			getDataOfPlayerFromStorage(player);
			NowHavePlayer++;
		}
	}
	public boolean isaddtoUseNanosuitListOnJoinOnlyyyyyyyyyyyy(Player player){
		if(LitsforwhouseNanosuit.contains(player.getName())){
			return true;
		}
		return false;
	}
	public void RemoveFormWhoUseNanosuitList(Player player){
		if(LitsforwhouseNanosuit.contains(player.getName())){
			LitsforwhouseNanosuit.remove(player.getName());
			NowHavePlayer--;
		}
	}
	
	private void Stop(){
		HashMapPlayerData.clear();
		HashMapPlayerData = null;
		HashMapPlayerSuitStatus.clear();
		HashMapPlayerSuitStatus = null;
		HashMapPlayerAirStormData.clear();
		HashMapPlayerAirStormData = null;
		HashMapPlayerSavedArmor.clear();
		HashMapPlayerSavedArmor = null;
		HashMapPlayerPlayTimesPressShift.clear();
		HashMapPlayerPlayTimesPressShift = null;
		HashMapPlayerPlaySoundStartTime.clear();
		HashMapPlayerPlaySoundStartTime = null;
		HashMapPlayerCurrentMode.clear();
		HashMapPlayerCurrentMode = null;
		HashMapPlayerStratAirStormBlock.clear();
		HashMapPlayerStratAirStormBlock = null;
		HashMapPlayerAirStormAble.clear();
		HashMapPlayerAirStormAble = null;
		HashMapPlayerCurrentArrow.clear();
		HashMapPlayerCurrentArrow = null;
		HashMapAimmingAction.clear();
		HashMapAimmingAction = null;
		HashMapAimingTarget.clear();
		HashMapAimingTarget = null;
	}
	
	public void CreateMapForOnlinePlayer(){
		for(Player player : Nanosuit.getServer().getOnlinePlayers())
		{
			player.recalculatePermissions();
			if(player.hasPermission("NanoSuit.Activate") )//&& !isSaveDataToStorage(player))
			{
				CreateMapEachPermission(player);
				NowHavePlayer += 1;
			}
			else
			{
				//player.sendMessage("I won't create map for you");
			}
		}
	}
	public void SaveMapForOnlinePlayer(){
		for(Player player : Nanosuit.getServer().getOnlinePlayers())
		{
			if(isSuitEnable(player))
			{
				SaveAllPlayerDataToStorage(player);
			}
			else
			{
				//player.sendMessage("I won't create map for you");
			}
		}
	}
	public void CreateMapEachPermission(Player player){
		if(player.hasPermission("NanoSuit.Activate")){
			HashMapPlayerCurrentMode.put(player, "human");
			HashMapPlayerPlayTimesPressShift.put(player, 0);
			HashMapPlayerPlaySoundStartTime.put(player, 0L);
			HashMapPlayerSavedArmor.put(player, null);
			HashMapPlayerSuitStatus.put(player, false);
			HashMapPlayerCurrentArrow.put(player, "Carbon-Impact");
		}
		else if(player.hasPermission("NanoSuit.Activate.Cloak")){
			HashMapPlayerData.put(player, 0);
		}
		else if(player.hasPermission("NanoSuit.Activate.WarringNearbyplayer")){
			//HashMapPlayerNearPlayer.put(player, null);
		}
		else if(player.hasPermission("NanoSuit.Activate.AirStorm")){
			HashMapPlayerAirStormData.put(player, 0);
			HashMapPlayerStratAirStormBlock.put(player, -256d);
			HashMapPlayerAirStormAble.put(player, false);
			//HashMapPlayerSendToGroundThreadNumber.put(player, -1);
		}
		else if(player.hasPermission("NanoSuit.Activate.PredatorBow.Aiming")){
			HashMapAimmingAction.put(player, (int) 2);
			HashMapAimingTarget.put(player, false);
		}
		else if(player.hasPermission("NanoSuit.Activate.PredatorBow.ArrowWeight")){
			HashMapArrowWeight.put(player, (double) 1.0);
		}
	}
	public void CreateAllMap(Player player){
		HashMapPlayerData.put(player, 0);
		HashMapPlayerAirStormData.put(player, 0);
		HashMapPlayerSuitStatus.put(player, false);
		HashMapPlayerSavedArmor.put(player, null);
		HashMapPlayerPlayTimesPressShift.put(player, 0);
		HashMapPlayerPlaySoundStartTime.put(player, 0L);
		//HashMapPlayerNearPlayer.put(player, new ArrayList<Player>());
		HashMapPlayerCurrentMode.put(player, "human");
		HashMapPlayerStratAirStormBlock.put(player, -256d);
		HashMapPlayerAirStormAble.put(player, false);
		HashMapPlayerCurrentArrow.put(player, "Carbon-Impact");
		HashMapAimmingAction.put(player, (int) 0);
		HashMapAimingTarget.put(player, false);
		//HashMapPlayerSendToGroundThreadNumber.put(player, -1);
	}
	public void RemoveAllMap(Player player){
		HashMapPlayerData.remove(player);
		HashMapPlayerSuitStatus.remove(player);
		HashMapPlayerSavedArmor.remove(player);
		HashMapPlayerPlayTimesPressShift.remove(player);
		HashMapPlayerPlaySoundStartTime.remove(player);
		//HashMapPlayerNearPlayer.remove(player);
		HashMapPlayerCurrentMode.remove(player);
		HashMapPlayerStratAirStormBlock.remove(player);
		HashMapPlayerAirStormAble.remove(player);
		HashMapPlayerCurrentArrow.remove(player);
		HashMapPlayerAirStormData.remove(player);
		HashMapAimmingAction.remove(player);
		HashMapAimingTarget.remove(player);
		//HashMapPlayerSendToGroundThreadNumber.remove(player);
	}
	
	public void Displayvaiable(Player player){
		player.sendMessage("HashMapPlayerData: " + HashMapPlayerData.get(player));
		player.sendMessage("HashMapPlayerAirStormData: " + HashMapPlayerAirStormData.get(player));
		player.sendMessage("HashMapPlayerSuitStatus: " + HashMapPlayerSuitStatus.get(player));
		player.sendMessage("HashMapPlayerPlayTimesPressShift: " + HashMapPlayerPlayTimesPressShift.get(player));
		player.sendMessage("HashMapPlayerPlaySoundStartTime: " + HashMapPlayerPlaySoundStartTime.get(player));
		//player.sendMessage("HashMapPlayerNearPlayer: " + HashMapPlayerNearPlayer.get(player));
		player.sendMessage("HashMapPlayerCurrentMode: " + HashMapPlayerCurrentMode.get(player));
		player.sendMessage("HashMapPlayerStratAirStormBlock: " + HashMapPlayerStratAirStormBlock.get(player));
		player.sendMessage("HashMapPlayerAirStormAble: " + HashMapPlayerAirStormAble.get(player));
		player.sendMessage("HashMapPlayerCurrentArrow: " + HashMapPlayerCurrentArrow.get(player));
		player.sendMessage("HashMapAimmingAction: " + HashMapAimmingAction.get(player));
		player.sendMessage("HashMapAimingTarget: " + HashMapAimingTarget.get(player));
		//player.sendMessage("HashMapPlayerSendToGroundThreadNumber: " + HashMapPlayerSendToGroundThreadNumber.get(player));
	}
	
	public boolean isPutOnFormJumping(Player player){
		if(HashMapisPutOnFormJumping.containsKey(player)){
			return true;
		}
		else{
			HashMapisPutOnFormJumping.put(player, false);
			return false;
		}
	}
	public void ClearJumpMap(Player player){
		HashMapisPutOnFormJumping.remove(player);
		HashMapisPutOnFormJumping.remove(player);
	}
	public boolean isPutOnAirStormCoolDown(Player player){
		return AirStormCoolDown.containsKey(player);
	}
	public Long getCooldowntime(Player player){
		return AirStormCoolDown.get(player);
	}
	public void setCoolDownTime(Player player, Long value){
		AirStormCoolDown.put(player, value);
	}
	
	public void SetJumpFrom(Player player,double Y){
		HashMapFormJumping.put(player, Y);
	}
	public double GetJumpFrom(Player player){
		if(HashMapFormJumping.containsKey(player)){
			return HashMapFormJumping.get(player);
		}
		return 0;
	}
	
	public double getArrowWeight(Player player){
		if(HashMapArrowWeight.containsKey(player)){
			return HashMapArrowWeight.get(player);
		}
		else{
			HashMapArrowWeight.put(player, (double) 1.0);
			return (double) 1.0;
		}
	}
	public void changeArrowWeight(Player player, double key){
		HashMapArrowWeight.put(player, key);
	}
	
	public boolean isAimming(Player player){
		if(HashMapAimingTarget.containsKey(player)){
			return HashMapAimingTarget.get(player);
		}
		else{
			HashMapAimingTarget.put(player,false);
			return false;
		}
	}
	public void setAimming(Player player, boolean isAimming){
		HashMapAimingTarget.put(player,isAimming);
	}
	
	/**
	 * Check AimmingPredatorBowAction
	 * @param player - target player
	 * @param key - 0 is Zoom, 1 is move fast
	 */
	public int CheckCurrentAimmingAction(Player player){
		if(HashMapAimmingAction.containsKey(player)){
			return HashMapAimmingAction.get(player);
		}
		else{
			HashMapAimmingAction.put(player, (int) 2);
			return 2;
		}
	}
	/**
	 * Change AimmingPredatorBowAction
	 * @param player - target player
	 * @param key - 0 is Zoom, 1 is move fast
	 */
	public void ChangeCurrentAimmingAction(Player player,int key){
		HashMapAimmingAction.put(player, key);
		senddebugmessage(ChatColor.GOLD + "change aimming to " + key);
	}
	
	/**
	 * Check what arrow does player have
	 * @param player - target player
	 * @return
	 */
	public String getCurrentArrow(Player player){
		return HashMapPlayerCurrentArrow.get(player);
	}
	/**
	 * Set Arrow mode
	 * @param player - traget player
	 * @param mode - "Carbon-Impact" , "Electro" , "Super-thermite" , "Airburst Fragmentation"
	 */
	public void setCurrentArrow(Player player,String mode){
		HashMapPlayerCurrentArrow.put(player, mode);
		switch (mode){
		case"Carbon-Impact":
			ChangeLoreNanoArrow(player,"Carbon-Impact");
			break;
		case"Electro":
			ChangeLoreNanoArrow(player,"Electro");
			break;
		case"Super-thermite":
			ChangeLoreNanoArrow(player,"Super-thermite");
			break;
		case"Airburst Fragmentation":
			ChangeLoreNanoArrow(player,"Airburst Fragmentation");
			break;
		}
		player.sendMessage("Your Arrow have been change to: " + mode);
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
	private ItemStack GetNanoArrow(){
		ItemStack NanoArrow = new ItemStack(Material.ARROW);
		ItemMeta meta = NanoArrow.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "NanoArrow");
		List<String> loreARROW = Arrays.asList("Carbon-Impact");
		meta.setLore(loreARROW);
		NanoArrow.setItemMeta(meta);
		return NanoArrow;
	}
	private int getFirstEmtySlot(Player player){
		for (int i = 9 ; i <= 36 ; i++)	{
			if(player.getInventory().getItem(i) == null){
				return i;
			}
		}
		return -1;
	}
	
	/***
	 * Check if player can Air Storm (Hight than 5 block)
	 * @param player - Target player
	 * @return
	 */
	public boolean CanAirStorm(Player player){
		if(HashMapPlayerAirStormAble.containsKey(player)){
			return HashMapPlayerAirStormAble.get(player);
		}
		else{
			HashMapPlayerAirStormAble.put(player, false);
			return false;
		}
	}
	/**
	 * Set avilable to Air Storm for specify player
	 * @param player - target player
	 * @param t - Ture or False
	 */
	public void setCanAirStorm(Player player, boolean t){
		HashMapPlayerAirStormAble.put(player,t);
	}
	
	public String getCurrenceMode(Player player){
		return HashMapPlayerCurrentMode.get(player);
	}
	public void setCurrenceMode(Player player,String mode){
		HashMapPlayerCurrentMode.put(player,mode);
	}
	
	public void StartPlaySound(Player player,Sound s , Float soundvolume){
		player.getWorld().playSound(player.getLocation(), s, soundvolume, 1);
		Long startTime = player.getWorld().getTime();
		HashMapPlayerPlaySoundStartTime.put(player, startTime);
	}
	public Long GetPlaySoundStartTime(Player player){
		if(HashMapPlayerPlaySoundStartTime.containsKey(player))
		{
			return HashMapPlayerPlaySoundStartTime.get(player);
		}
		else
		{
			HashMapPlayerPlaySoundStartTime.put(player, 0L);
			return 0L;
		}
	}	
	public int CheckTimesPressShift(Player player){
		if(HashMapPlayerPlayTimesPressShift.containsKey(player)){
			return HashMapPlayerPlayTimesPressShift.get(player);
		}
		else{
			HashMapPlayerPlayTimesPressShift.put(player, 0);
			return 0;
		}
	}
	public void AddTimesPressShift(Player player){
		HashMapPlayerPlayTimesPressShift.put(player , (CheckTimesPressShift(player) + 1));
	}
	public void ResetTimesPressShift(Player player){
		HashMapPlayerPlayTimesPressShift.put(player , 0);
	}
	
	public int Checksd(Player player){
		if (HashMapPlayerData.containsKey(player))
		{
			//player.sendMessage("We are in Checksd returning playername");
			return HashMapPlayerData.get(player);
		}
		else
		{
			//player.sendMessage("We are in Checksd else");
			HashMapPlayerData.put(player, 0);
			return 0;
		}
	}
	public void Setsd(Player player,int i){
		HashMapPlayerData.put(player, i);
	}
	
	public int CheckAsd(Player player){
		if (HashMapPlayerAirStormData.containsKey(player))
		{
			//player.sendMessage("We are in Checksd returning playername");
			return HashMapPlayerAirStormData.get(player);
		}
		else
		{
			//player.sendMessage("We are in Checksd else");
			HashMapPlayerAirStormData.put(player, 0);
			return 0;
		}
	}
	public void SetAsd(Player player,int asd){
		HashMapPlayerAirStormData.put(player, asd);
	}
	
	public boolean isSuitEnable(Player player){
		//player.sendMessage("We are in isSuitEnable");
		if (HashMapPlayerSuitStatus.containsKey(player))
		{
			return HashMapPlayerSuitStatus.get(player);
		}
		else
		{
			HashMapPlayerSuitStatus.put(player, false);
			return false;
		}
	}
	public void SetSuitEnable(Player player, boolean i){
		HashMapPlayerSuitStatus.put(player, i);
	}
	
	public void saveArmmor(Player player, ItemStack[] i){
		HashMapPlayerSavedArmor.put(player, i);
	}
	public boolean issaveArmor(Player player){
		if(HashMapPlayerSavedArmor.containsKey(player)){
			if (HashMapPlayerSavedArmor.get(player) != null){
				//Zen3515.sendMessage
				//Bukkit.broadcastMessage("We have saved your armor");
				return true;
			}
			else{
				//Zen3515.sendMessage
				//Bukkit.broadcastMessage("We doesn't save your armor 1");
				return false;
			}
		}
		else
		{
			//Zen3515.sendMessage("We doesn't save your armor 2");
			return false;
		}
	}
	public ItemStack[] getsaveArmmor(Player player){
		return HashMapPlayerSavedArmor.get(player);
	}
	
	
	
	
	// }} ———————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————	

	// {{ Storage part
		
		public void GetAllDataFromStorageForAllOnlinePlayer(){
			for(Player player : Nanosuit.getServer().getOnlinePlayers())
			{
				File playerdata = new File(Nanosuit.getDataFolder() + "/Data/" + player.getName() + ".txt");
				//Bukkit.broadcastMessage("GetAllDataFromStorageForAllOnlinePlayer for:" + player.getName());
				if(playerdata.exists()){
					getDataOfPlayerFromStorage(player);
					//Bukkit.broadcastMessage("GetAllDataFromStorageForAllOnlinePlayer222 for:" + player.getName());
				}
			}
		}
		public void SaveAllDataToStorageForAllOnlinePlayer(){
			for(Player player : Nanosuit.getServer().getOnlinePlayers())
			{
				if(isSuitEnable(player)){
					SaveAllPlayerDataToStorage(player);
				}
			}
		}
		
		public int count(String filename) throws IOException {
		    InputStream is = new BufferedInputStream(new FileInputStream(filename));
		    try {
		        byte[] c = new byte[1024];
		        int count = 0;
		        int readChars = 0;
		        boolean empty = true;
		        while ((readChars = is.read(c)) != -1) {
		            empty = false;
		            for (int i = 0; i < readChars; ++i) {
		                if (c[i] == '\n') {
		                    ++count;
		                }
		            }
		        }
		        return (count == 0 && !empty) ? 1 : count;
		    } finally {
		        is.close();
		    }
		}
		
		public void SaveUsedNanosuitPeopleList(){
			String Contend = "";
			for(Iterator<String> e = LitsforwhouseNanosuit.iterator() ; e.hasNext(); ){
				String PlayerName = e.next();
				Contend += (PlayerName + "\n" );	
			}
			File playerDataFile = new File(Nanosuit.getDataFolder() + "//UsedPeople.txt");
			if(!playerDataFile.exists()){
				try {
					playerDataFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
					System.err.println("Cant Creat UsedPeople.txt at Main: 1976");
				}
			}
			PrintStream out = null;
			try {
				out = new PrintStream(new FileOutputStream(Nanosuit.getDataFolder() + "//UsedPeople.txt"));
				out.print(Contend);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.err.println("Error UsedPeople.txt not found at Main: 1927");
			}finally{
				if (out != null) out.close();
			}
			/**
			 * STOP ALL MAP------------------------------------------------------------------------------------------------------------
			 */
			this.Stop();
		}
		public void LoadPeoPleWhoUseNanosuit(){
			LitsforwhouseNanosuit = new ArrayList<String>();
			File UsedPeopleFile = new File(Nanosuit.getDataFolder() + "//UsedPeople.txt");
			if(!UsedPeopleFile.exists()){
				try {
					UsedPeopleFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
					System.err.println("Cant Creat UsedPeople.txt at Main: 1940");
				}
			}
			try {
				LitsforwhouseNanosuit = Files.readAllLines(UsedPeopleFile.toPath(), StandardCharsets.UTF_8);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/*public boolean isSaveDataToStorage(Player player){
			File playerDataFile = new File(getDataFolder() + "//" + player.getName() + ".txt");
			if(playerDataFile.exists()){
				return true;
			}
			else{
				return false;
			}
		}*/
		
		public void SaveAllPlayerDataToStorage(Player player){
			prop = new Properties();
			if(!Nanosuit.getDataFolder().exists())
	        {
				Nanosuit.getDataFolder().mkdir();
	        }
			File Datafolder = new File(Nanosuit.getDataFolder() + "/Data/");
			if (!Datafolder.exists()){
				Datafolder.mkdir();
			}
			//System.err.println("Saving for : " + player.getName());
			setprop("SD",String.valueOf(Checksd(player))); //set SD to prop
			setprop("ASD",String.valueOf(CheckAsd(player))); //set ASD to prop
			if (issaveArmor(player)){
				ItemStack[] savearmor = getsaveArmmor(player);
				File SaveArmordotyml = new File(Nanosuit.getDataFolder() + "/Data/" + player.getName() + ".yml");
				if(!SaveArmordotyml.exists()){
					try {
						SaveArmordotyml.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				FileConfiguration SaveArmordotymlasCon = YamlConfiguration.loadConfiguration(SaveArmordotyml);
				setprop("isArmorSave","True");
				SaveArmordotymlasCon.set("Armor", savearmor);
				try {
					SaveArmordotymlasCon.save(SaveArmordotyml);
				} catch (IOException e) {
					e.printStackTrace();
					System.err.println("Can't save player armor");
				}
			}
			setprop("isSuitActivate",String.valueOf(isSuitEnable(player)));
			setprop("Currentmode",getCurrenceMode(player));
			setprop("Currentarrow", getCurrentArrow(player));
			setprop("Currentaimmingaction", String.valueOf(CheckCurrentAimmingAction(player)));
			setprop("Arrowweight",String.valueOf(getArrowWeight(player)));
			storeprop(player);
			prop.clear();
			prop = null;
		}
		
		//{{ Need cause not same class
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
		private ItemStack ColorizeAndEnchant(ItemStack i, int rgb,int o,String ItemName){
			colorize(i, rgb,ItemName);
			
			return i;
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
		//}}
		 
		public void getDataOfPlayerFromStorage(Player player){
			 prop = new Properties();
			 CreateAllMap(player);
			 //player.sendMessage("getDataOfPlayerFromStorage Has been Excuite");
			 //check if save prop
			 boolean canloadprop = loadprop(player);
			 if (canloadprop){
				 //player.sendMessage("Loading Prop");
				 // {{ GET ARMOR (check if save armor to load)
				 if(Boolean.parseBoolean(readprop("isArmorSave"))){
					 File SaveArmordotyml = new File(Nanosuit.getDataFolder() + "/Data/" + player.getName() + ".yml");
					 FileConfiguration SaveArmordotymlasCon = new YamlConfiguration(); //YamlConfiguration.loadConfiguration(SaveArmordotyml);
					 try {
						SaveArmordotymlasCon.load(SaveArmordotyml);
					} catch (IOException | InvalidConfigurationException e) {
						e.printStackTrace();
						System.err.println("Can't load player armor");
					}
					 @SuppressWarnings("unchecked")
					 List<ItemStack> SavedarmorList = (List<ItemStack>)SaveArmordotymlasCon.get("Armor");
					 ItemStack[] SavedArmor = SavedarmorList.toArray(new ItemStack[0]);
					 saveArmmor(player,SavedArmor); //—————————————————————————————————————————————————— Hash map to SavedArmor
				 }
				 else{
					 //sethashmap to null
					 saveArmmor(player,null); //—————————————————————————————————————————————————— Hash map to null
				 }
				 //}}
				 Setsd(player,Integer.parseInt(readprop("SD")));
				 SetAsd(player,Integer.parseInt(readprop("ASD")));
				 //SetSuitEnable(player,Boolean.getBoolean(readprop("isSuitActivate")));
				 SetSuitEnable(player,true);
				 setCurrenceMode(player,readprop("Currentmode"));
				 setCurrentArrow(player,readprop("Currentarrow"));
				 ChangeCurrentAimmingAction(player,Integer.parseInt(readprop("Currentaimmingaction")));
				 changeArrowWeight(player,Double.valueOf(readprop("Arrowweight")));
				 //player.sendMessage("SD: " + (readprop("SD")));
				 //player.sendMessage("ASD: " + (readprop("ASD")));
				 //player.sendMessage("isSuitEnable: " + (readprop("isSuitActivate")));
				 //player.sendMessage("CurrentMode: " + readprop("currentmode"));
				 //player.sendMessage("CurrentArrow: " + readprop("currentarrow"));
				 if(getCurrenceMode(player) == "cloak"){
					 CloakSystemManager.setCloak(player, true);
				 }
				 else if(getCurrenceMode(player) == "power"){
					 CloakSystemManager.setCloak(player, false);
					 WearTheSuit(player,Nanosuit.getConfig().getInt("Nanosuit-Config.Mode.Power.Color"),Nanosuit.getConfig().getInt("Nanosuit-Config.Mode.Power.Enchant-Level"));
					 player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 12));
					 player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 7));
					 player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 15));
					 player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 15));
					 player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 2));
					 player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 15));
				 }
				 if(player.getHealthScale() != 40){
					 player.setHealthScale(40);
				 }
			 }
			 prop.clear();
			 prop = null;
		}
		
		 public Properties prop = new Properties();
		 public boolean loadprop(Player player){
				try{
					File Datafolder = new File(Nanosuit.getDataFolder() + "/Data/");
					if (!Datafolder.exists()){
						Datafolder.mkdir();
					}
					FileInputStream proploader = new FileInputStream(Nanosuit.getDataFolder() + "/Data/" + player.getName() + ".txt");
					prop.load(proploader);
					proploader.close();
					//player.sendMessage("Your Prop Is LOADED");
					return true;
				}catch(FileNotFoundException e){
					//storeprop(player);
					System.err.println("/Data/playername.txt was not found**********can't load prop");
					return false;
				}catch(Exception e1){
					e1.printStackTrace();
				}
				return false;
			}
			
		public String readprop(String key){
			//System.out.println(prop.getProperty(key) + "\n" + "***********************reading prop method");
			return prop.getProperty(key); //getProperty returns always an string
		}
			
		public void setprop(String key, String content){
			prop.setProperty(key, content);
		}
		
		public void storeprop(Player player){
			File playerpropfile = new File(Nanosuit.getDataFolder() + "/Data/" + player.getName() + ".txt");
			if (!playerpropfile.exists()){
				try {
					File Datafolder = new File(Nanosuit.getDataFolder() + "/Data/");
					if (!Datafolder.exists()){
						Datafolder.mkdir();
					}
					playerpropfile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
					System.err.print("Can't create file at 2119");
				}
			}
			
			try{
				prop.store(new FileOutputStream(Nanosuit.getDataFolder() + "/Data/" + player.getName() + ".txt"), null); //comments can be also null
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	// }}	
	
}
