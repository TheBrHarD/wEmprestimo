package com.contattos.wemprestimo;

import com.contattos.wemprestimo.commands.inventoryCommands;
import com.contattos.wemprestimo.inventories.inventory;
import com.contattos.wemprestimo.inventories.inventoryBlocos;
import com.contattos.wemprestimo.inventories.inventoryFerramentas;
import com.contattos.wemprestimo.listening.eventBlocks;
import com.contattos.wemprestimo.listening.eventTools;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;
    public static Main getInstance() {
        return instance;
    }


    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Plugin inicializado com sucesso!");
        getCommand("shop").setExecutor(new inventoryCommands());
        Bukkit.getPluginManager().registerEvents(new inventory(), this);
        Bukkit.getPluginManager().registerEvents(new eventBlocks(), this);
        Bukkit.getPluginManager().registerEvents(new eventTools(), this);
    }
}
