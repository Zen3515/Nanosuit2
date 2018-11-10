package me.Zen3515.Nanosuit2;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class CloakSystem {
	
	public Scoreboard CloakBoard;
	//private DisplaySystem DisplaySystemManager;
	
	//TODO to add seeing energy register new object in CloakBoard & show airstorm cooldown time
	
	public CloakSystem(Plugin plugin,Scoreboard board/*,DisplaySystem DS*/) {
        // Initialize
		CloakBoard = board;
		//DisplaySystemManager = DS;
    }
	
	public boolean isCloak(Player player){
		if(player.hasPotionEffect(PotionEffectType.INVISIBILITY)){
			return true;
		}
		return false;
	}
	
	public void Cloak(Player player){
		Team playerteam = getplayerteam(player);
		if(!playerteam.getPlayers().contains(player)){
			playerteam.addPlayer(player);
			playerteam.setCanSeeFriendlyInvisibles(true);
		}
		player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 15));
		//TODO set to emty display name player.setDisplayName("");
	}
	
	public void DeCloak(Player player){
		player.removePotionEffect(PotionEffectType.INVISIBILITY);
		//player.setScoreboard(DisplaySystemManager.getPlayerScoreboard(player));
	}
	
	public void setCloak(Player player,Boolean b){
		if(b){
			Cloak(player);
			player.setScoreboard(CloakBoard);
		}
		else{
			DeCloak(player);
		}
	}
		
	/**
	 * Allow player1 to see player2
	 * @param player1 - notcloak
	 * @param player2 - cloaking
	 */
	public void Letplayer1seeplayer2(Player player1,Player player2){
		Team player2team = getplayerteam(player2);
		if(!player2team.getPlayers().contains(player1)){
			player2team.addPlayer(player1);
		}
	}
	
	/**
	 * Stop player1 to see player2
	 * @param player1 - notcloak
	 * @param player2 - cloaking
	 */
	public void Stopplayer1seeplayer2(Player player1,Player player2){
		Team player2team = getplayerteam(player2);
		if(player2team.getPlayers().contains(player1)){
			player2team.removePlayer(player1);
		}
	}
	
	/**
	 * Check if player1 can see player2
	 * @param player1 - player to check
	 * @param player2 - cloaking player
	 */
	public boolean Canplayer1seeplayer2(Player player1, Player player2){
		Team player2team = getplayerteam(player2);
		if(player2team.getPlayers().contains(player1)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public Team getplayerteam(Player player){
		String Teamname = player.getName() + "_Cloak";
		Team playerteam = null;
		if(CloakBoard.getTeam(Teamname) != null){
			playerteam = CloakBoard.getTeam(Teamname);
		}
		else{
			playerteam = CloakBoard.registerNewTeam(Teamname);
		}
		playerteam.setCanSeeFriendlyInvisibles(true);
		return playerteam;
	}

}
