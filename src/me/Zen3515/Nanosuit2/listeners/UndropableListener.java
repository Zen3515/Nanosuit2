package me.Zen3515.Nanosuit2.listeners;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class UndropableListener  extends Event{

	private static final HandlerList handlers = new HandlerList();
	public UndropableListener(final Plugin plugin,final Player player,final String s,final int o) {
		
		new BukkitRunnable(){
		    public void run(){
		    	for(int i = 0; i <= 35; i++){
					if (player.getInventory().getItem(i) != null)
					{
						//player.sendMessage("1Check at : " + String.valueOf(i) + " Found " + player.getInventory().getItem(i).getItemMeta().getDisplayName());
						if(player.getInventory().getItem(i).getItemMeta().getDisplayName() != null 
						&& player.getInventory().getItem(i).getItemMeta().getDisplayName().contains(s))
						{
							//player.sendMessage("2Removing At = " + String.valueOf(i));
							player.getInventory().clear(i);
						}
					}
				}
				player.setItemInHand(GetPredatorBow(o));
				this.cancel();
			}
		}.runTaskLater(plugin, 1L);
	}

	public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
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
}
