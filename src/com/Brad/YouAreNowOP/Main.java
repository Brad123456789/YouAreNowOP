package com.Brad.YouAreNowOP;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
public class Main extends JavaPlugin{	
	@Override
	public void onEnable()	{
    this.getCommand("deop").setExecutor(new Deop());
	getLogger().info("Custom YouAreNowOP Plugin by Brad **LOADED** Sucessfully!");
	}
	@Override
	public void onDisable()	{
	getLogger().info("Custom YouAreNowOP Plugin by Brad **UNLOADED** Sucessfully!");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Logger log = Bukkit.getLogger();
		log = Bukkit.getLogger();
	    if(cmd.getName().equalsIgnoreCase("op")) {
	    	if(sender instanceof ConsoleCommandSender) {
	    		if(args.length != 1) {      
	                log.warning("Usage: /op <Player>"); }
	        	else {
	            Player player1 = this.getServer().getPlayer(args[0]);	 
                Bukkit.getServer().broadcast(ChatColor.GRAY + "" + ChatColor.ITALIC + "Server: Opped: " + Bukkit.getServer().getPlayer(args[0]).getName(), Server.BROADCAST_CHANNEL_ADMINISTRATIVE); 
	            player1.sendMessage(ChatColor.YELLOW + "You are now op!");
	            player1.setOp(true);    
	            log.info("Sucessfully opped " + Bukkit.getServer().getPlayer(args[0]).getName());  }
	        } else{
	        	if(args.length == 0) {
	            	sender.sendMessage(ChatColor.RED + "Usage: /op <Player>");
	        	} else if(args.length == 1) {
	                Player target = Bukkit.getPlayer(args[0]);
	                Bukkit.getServer().broadcast(ChatColor.GRAY + "" + ChatColor.ITALIC + sender.getName() + ": Opped: " + Bukkit.getPlayer(args[0]).getName(), Server.BROADCAST_CHANNEL_ADMINISTRATIVE); 
	            	//sender.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "Opped: " + Bukkit.getPlayer(args[0]).getName());
	            	target.sendMessage(ChatColor.YELLOW + "You are now op!");
	                target.setOp(true);
	        }
	    }
	    }
		return true;
	}
}