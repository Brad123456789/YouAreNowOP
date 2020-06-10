package com.Brad.YouAreNowOP;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
public class Main extends JavaPlugin{
	
	public static String commandarg;	
	
    ArrayList<String> OP = new ArrayList<String>(); 
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){       
        Player player = (Player) sender;     
        if(cmd.getName().equalsIgnoreCase("op")){
                if(args.length != 1){      
                    player.sendMessage(ChatColor.RED + "Usage: /op <Player>");
                }else{
                    Player target = Bukkit.getPlayer(args[0]);
                    target.sendMessage(ChatColor.YELLOW + "You are now op!");
                    target.setOp(true);
                }
            }
        return true;
    }
}
