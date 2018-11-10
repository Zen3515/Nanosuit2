package me.Zen3515.Nanosuit2;

/*import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;*/

public class DisplaySystem {
	
	/*private boolean debugging = true;
	private void senddebugmessage(String text){
		if(debugging == true){
			if(Bukkit.getPlayer("Zen3515") != null){
				Bukkit.getPlayer("Zen3515").sendMessage(text);
			};			
		};
	}

	private Scoreboard CloakBoard;
	private Plugin Nanosuit;
	private HashMap<Player,Object> ObjectMonitorMap = new HashMap<Player,Object>();
	public HashMap<Player,Scoreboard> ScoreboardMap = new HashMap<Player,Scoreboard>();
	
	public DisplaySystem(Plugin nanosuit,Scoreboard cloakboard){
		Nanosuit = nanosuit;
		CloakBoard = cloakboard;
	}
	
	public Scoreboard getPlayerScoreboard(Player player){
		if(ScoreboardMap.containsKey(player)){
			return ScoreboardMap.get(player);
		}
		else{
		    Scoreboard b = Bukkit.getScoreboardManager().getNewScoreboard();
		    ScoreboardMap.put(player, b);
		    return b;
		}
	}
	
	private Objective GetObjMonitor(Player player,Scoreboard b){
		if(!ObjectMonitorMap.containsKey(player)){
			Objective monitorobj = b.registerNewObjective(player.getName() + "'s Status", "dummy");
			return monitorobj;
		}
		else{
			return CloakBoard.getObjective(player.getName() + "'s Status");
		}
	}
	
	public void StartUpDateTaskFor(Player player){
		Scoreboard PlayerScoreboard = getPlayerScoreboard(player);
		Objective monitorobj = GetObjMonitor(player,PlayerScoreboard);
		monitorobj.setDisplaySlot(DisplaySlot.SIDEBAR);
		monitorobj.setDisplayName("Status");
		Score monitorobjScore = monitorobj.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Energy:"));
		monitorobjScore.setScore(100);
		player.setScoreboard(PlayerScoreboard);
		senddebugmessage("StartUpDateTaskFor " + player.getName() + " run");
	}*/
	
}
