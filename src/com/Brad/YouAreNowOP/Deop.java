package com.Brad.YouAreNowOP;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import com.Brad.YouAreNowOP.Main;
public class Deop implements CommandExecutor {	
Main plugin;
public boolean onCommand(CommandSender sender, Command cmd, String command, String[] args) {
	Logger log = Bukkit.getLogger();
	log = Bukkit.getLogger();
        if (cmd.getName().equalsIgnoreCase("deop")) {

		if(sender instanceof ConsoleCommandSender) {
	    	if(args.length != 1) {      
	            log.warning("Usage: /deop <Player>"); }
	    	else {
	        //sender.sendMessage("You are console");
	        Player player1 = Bukkit.getServer().getPlayer(args[0]);
            Bukkit.getServer().broadcast(ChatColor.GRAY + "" + ChatColor.ITALIC + "Server: De-opped: " + Bukkit.getServer().getPlayer(args[0]).getName(), Server.BROADCAST_CHANNEL_ADMINISTRATIVE); 
	        player1.sendMessage(ChatColor.YELLOW + "You are no longer op!");
	        player1.setOp(false);       
	        log.info("Sucessfully deopped " + Bukkit.getServer().getPlayer(args[0]).getName()); 
	    	}
	    }
	    else {
	        // check if we've got args long enough for it to be a command, but also to see if we're missing some parameters that we need filled out
	        if(args.length == 0) {
	        	sender.sendMessage(ChatColor.RED + "Usage: /deop <Player>");  
	        } else if(args.length == 1) {
	            Player target = Bukkit.getPlayer(args[0]);
            	//sender.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "Deopped: " + Bukkit.getPlayer(args[0]).getName());
                Bukkit.getServer().broadcast(ChatColor.GRAY + "" + ChatColor.ITALIC + sender.getName() + ": De-opped: " + Bukkit.getPlayer(args[0]).getName(), Server.BROADCAST_CHANNEL_ADMINISTRATIVE); 
	        	target.sendMessage(ChatColor.YELLOW + "You are no longer op!");
	            target.setOp(false);            
	            } 
	    	}   	
        }
		return true;
}
}
//return (if FALSE: returns the usage of the command in the plugin.yml, if TRUE: nothing- allows you to make custom usage messages that may be more dynamic)