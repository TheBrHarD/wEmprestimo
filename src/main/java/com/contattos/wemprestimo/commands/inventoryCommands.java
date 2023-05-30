package com.contattos.wemprestimo.commands;

import com.contattos.wemprestimo.inventories.inventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class inventoryCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cEste comando só pode ser executado por jogadores!");
            return true;
        }
        Player p = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("shop")){
            inventory.open(p);
        }
        return false;
    }
}
