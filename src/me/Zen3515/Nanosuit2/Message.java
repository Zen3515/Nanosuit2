package me.Zen3515.Nanosuit2;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Message {
	
	//private HashMap<Integer,String> Message = new HashMap<Integer,String>();
	private Plugin Nanosuit;
	
	private final int CurrentMaximumMessageFile = 35;
	
	private double LangVersion = 1.0;
	
	private FileConfiguration MainMessage;
	
	private FileConfiguration getDefaultFileConfiguration(){
		FileConfiguration MessageFile = new YamlConfiguration();
		
		MessageFile.set("Version", LangVersion);
		
		MessageFile.set("1", "Aiming action must be 0 or 1 or 2");
		MessageFile.set("2", "Aiming action is action when you aiming target using PredatorBow");
		MessageFile.set("3", "Your aiming action has been change to ");
		MessageFile.set("4", "0 - zoom");
		MessageFile.set("5", "1 - move fast");
		MessageFile.set("6", "2 - nothing");

		MessageFile.set("7", "Arrow has only 5 weight(0-4)");
		MessageFile.set("8", "Your arrow is now weight ");
		MessageFile.set("9", "0: normal weight");
		MessageFile.set("10", "1: heavy weight");
		MessageFile.set("11", "2: light weight");
		MessageFile.set("12", "3: lighter weight");
		MessageFile.set("13", "4: lightest weight");
		
		MessageFile.set("14", "Nanosuit activated!");
		MessageFile.set("15", "Maximum Armmor");
		MessageFile.set("16", "Maximum power");
		MessageFile.set("17", "Cloak engaged");
		MessageFile.set("18", "Taken your Nanosuit");
		MessageFile.set("19", "Cloak Disable");

		MessageFile.set("20", "This command can only be run by a player.");
		MessageFile.set("21", "You have to activated your Nanosuit first");
		MessageFile.set("22", "Nano Vision enabled");
		MessageFile.set("23", "Nano Vision disabled");
		MessageFile.set("24", "Target player can't be emty");
		MessageFile.set("25", "All slot is full");
		MessageFile.set("26", "Maximum player reached");
		MessageFile.set("27", "Configuration file reloaded");
		MessageFile.set("28", "Playe sound delaied for: ");
		MessageFile.set("29", "you can't pic up Nano arrow");
		MessageFile.set("30", "You can't use Nanosuit now, Maximum player reached");
		
		MessageFile.set("31", "Air Storm");
		MessageFile.set("32", "Air Storm has been cooling down for ");
		MessageFile.set("33", " seconds!");
		
		MessageFile.set("34", " is near by you");
		MessageFile.set("35", " is out of you");
		
		return MessageFile;
	}
	
	private void CreateDefaultYMLFile(){
		
		/*Message.put(1, "Aiming action must be 0 or 1 or 2");
		Message.put(2, "Aiming action is action when you aiming target using PredatorBow");
		Message.put(3, "Your aiming action has been change to ");
		Message.put(4, "0 - zoom");
		Message.put(5, "1 - move fast");
		Message.put(6, "2 - nothing");

		Message.put(7, "Arrow has only 5 weight(0-4)");
		Message.put(8, "Your arrow is now weight ");
		Message.put(9, "0: normal weight");
		Message.put(10, "1: heavy weight");
		Message.put(11, "2: light weight");
		Message.put(12, "3: lighter weight");
		Message.put(13, "4: lightest weight");
		
		Message.put(14, "Nanosuit activated!");
		Message.put(15, "Maximum Armmor");
		Message.put(16, "Maximum power");
		Message.put(17, "Cloak engaged");
		Message.put(18, "Taken your Nanosuit");
		Message.put(19, "Cloak Disable");

		Message.put(20, "This command can only be run by a player.");
		Message.put(21, "You have to activated your Nanosuit first");
		Message.put(22, "Nano Vision enabled");
		Message.put(23, "Nano Vision disabled");
		Message.put(24, "Target player can't be emty");
		Message.put(25, "All slot is full");
		Message.put(26, "Maximum player reached");
		Message.put(27, "Configuration file reloaded");
		Message.put(28, "Playe sound delaied for: ");
		Message.put(29, "you can't pic up Nano arrow");
		Message.put(30, "You can't use Nanosuit now, Maximum player reached");
		
		Message.put(31, "Air Storm");
		Message.put(32, "Air Storm has been cooling down for ");
		Message.put(33, " seconds!");*/
		
		try {
			
			File LangFolder = new File(Nanosuit.getDataFolder() + "/Language/");
			if(!LangFolder.exists()){
				LangFolder.mkdirs();
			}
			
			File LanguageFile = new File(Nanosuit.getDataFolder() + "/Language" + "/EN.yml");
			if(!LanguageFile.exists()){
				LanguageFile.createNewFile();
			}
			
			FileConfiguration MessageFile = getDefaultFileConfiguration();
			
			MessageFile.save(LanguageFile);
			
			MainMessage = MessageFile;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//saveHashMap(Message,(Nanosuit.getDataFolder() + "/Language" + "/EN.txt"));
	}
	
	public Message(Plugin nanosuit,String Lang){
		Nanosuit = nanosuit;
		boolean canload = LoadFileLang(Lang.toUpperCase());
		if(!canload){
			//USE EN File
			CreateDefaultYMLFile();
			System.err.print("[Nanosuit2] Can't load language file switch to EN");
			return;
		}
		else{
			if(MainMessage.getDouble("Version") < LangVersion){
				CreateDefaultYMLFile();
				System.err.print("[Nanosuit2] Can't load language file switch to EN");
				System.err.print("[Nanosuit2] Because version of file is too old*******");
				return;
			}
			else{
				Nanosuit.getLogger().info("Can load language file now language is " + Lang.toUpperCase());
				return;
			}
		}
	}
	
	/*private void saveHashMap(HashMap<Integer, String> map, String pathandfilename)
	{
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathandfilename));
			oos.writeObject(map);
			oos.flush();
			oos.close();
			//Handle I/O exceptions
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}*/
	
	public String getMessage(int MessageID){
		String Message = MainMessage.getString(String.valueOf(MessageID));
		if(!Message.isEmpty()){
			return Message;
		}
		else{
			if(MessageID >= 1 && MessageID <= CurrentMaximumMessageFile){
				System.err.print("Can't find messageid: " + MessageID + " switch to EN");
				return getDefaultFileConfiguration().getString(String.valueOf(MessageID));
			}
			else{
				return (ChatColor.RED + "Error in language file(String not found)");
			}
		}
	}

	private boolean LoadFileLang(String Lang){
		try {
			
			File LangFolder = new File(Nanosuit.getDataFolder() + "/Language/");
			if(!LangFolder.exists()){
				LangFolder.mkdirs();
			}
			
			File LanguageFile = new File(Nanosuit.getDataFolder() + "/Language/" + Lang.toUpperCase() + ".yml");
			if(!LanguageFile.exists()){
				throw new IOException("File doesn't exists");
			}
			
			FileConfiguration MessageFile = YamlConfiguration.loadConfiguration(LanguageFile);
			
			MainMessage = MessageFile;
			
			return true;
			
		} catch (IOException e) {
			return false;
		}
	}
}
