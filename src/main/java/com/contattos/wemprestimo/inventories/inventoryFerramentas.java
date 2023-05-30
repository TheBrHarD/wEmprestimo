package com.contattos.wemprestimo.inventories;

import com.contattos.wemprestimo.api.newItens;
import com.contattos.wemprestimo.api.shopAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class inventoryFerramentas {
    public static void open1(Player p) {
        Inventory inv = Bukkit.createInventory(null, 6 * 9, "Loja de Ferramentas - [1]");

        shopAPI.compra(p, newItens.add(Material.DIAMOND_PICKAXE, "§ePicareta de Diamante", new String[]{""},
                Enchantment.DIG_SPEED, 5,
                Enchantment.LOOT_BONUS_BLOCKS, 3,
                Enchantment.DURABILITY, 3), 1.0, inv);
        shopAPI.compra(p, newItens.add(Material.DIAMOND_AXE, "§eMachado de Diamante", new String[]{""},
                Enchantment.DIG_SPEED, 5,
                Enchantment.LOOT_BONUS_BLOCKS, 3,
                Enchantment.DURABILITY, 3), 20.0, inv);
        shopAPI.compra(p, newItens.add(Material.DIAMOND_SPADE, "§ePá de Diamante", new String[]{""},
                Enchantment.DIG_SPEED, 5,
                Enchantment.LOOT_BONUS_BLOCKS, 3,
                Enchantment.DURABILITY, 3), 300.0, inv);

        p.openInventory(inv);
    }
}