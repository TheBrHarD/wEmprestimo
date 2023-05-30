package com.contattos.wemprestimo.inventories;

import com.contattos.wemprestimo.api.newItens;
import com.contattos.wemprestimo.api.shopAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class inventoryBlocos implements Listener {
    public static void open1(Player p) {
        Inventory inv = Bukkit.createInventory(null, 6 * 9, "Loja de Blocos - [1]");

        shopAPI.compra(p, newItens.add(Material.STONE, "§ePedra", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.STONE, "§eGranito", 1), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.STONE, "§eGranito Polido", 2), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.STONE, "§eDiorito", 3), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.STONE, "§eDiorito Polido", 4), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.STONE, "§eAndesito", 5), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.STONE, "§eAndesito Polido", 6), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.GRASS, "§eGrama", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.DIRT, "§eTerra", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.DIRT, "§ePodzol", 2), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.COBBLESTONE, "§ePedregulho", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.LOG, "§eCarvalho", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.LOG, "§ePinheiro", 1), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.LOG, "§eEucalipto", 2), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.LOG, "§eMadeira da Selva", 3), 100000.0, inv);

        ItemStack proxima = newItens.add(Material.ARROW, "§aPróxima página");
        ItemStack voltar = newItens.add(Material.ARROW, "§aVoltar");

        inv.setItem(49, voltar);
        inv.setItem(26, proxima);

        p.openInventory(inv);
    }
    public static void open2(Player p) {
        Inventory inv = Bukkit.createInventory(null, 6 * 9, "Loja de Blocos - [2]");

        shopAPI.compra(p, newItens.add(Material.LOG_2, "§eAcácia", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.LOG_2, "§eCarvalho Escuro", 1), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.LEAVES, "§eFolha", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.GLASS, "§eVidro", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.SAND, "§eAreia", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.SAND, "§eAreia Vermelha", 1), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.WOOL, "§eLã", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.BRICK, "§eTijolo", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.BOOKSHELF, "§eEstante", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.MOSSY_COBBLESTONE, "§ePedra com Musgo", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.ICE, "§eGelo", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.PACKED_ICE, "§eGelo Compactado", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.CLAY, "§eArgila", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.NETHERRACK, "§eRocha do Nether", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.GLOWSTONE, "§ePedra Luminosa", 0), 100000.0, inv);

        ItemStack voltar = newItens.add(Material.ARROW, "§aVoltar");
        ItemStack proxima = newItens.add(Material.ARROW, "§aPróxima página");
        ItemStack anterior = newItens.add(Material.ARROW, "§aPágina anterior");


        inv.setItem(49, voltar);
        inv.setItem(18, anterior);
        inv.setItem(26, proxima);

        p.openInventory(inv);
    }

    public static void open3(Player p) {
        Inventory inv = Bukkit.createInventory(null, 6 * 9, "Loja de Blocos - [3]");

        shopAPI.compra(p, newItens.add(Material.SMOOTH_BRICK, "§eTijolo de Pedra", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.SMOOTH_BRICK, "§eTijolo de Pedra Talhado", 3), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.MYCEL, "§eMicélio", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.NETHER_BRICK, "§eTijolo do Nether", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.ENDER_STONE, "§ePedra do Fim", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.QUARTZ_BLOCK, "§eQuartzo", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.QUARTZ_BLOCK, "§eQuartzo Talhado", 1), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.QUARTZ_BLOCK, "§ePilar de Quartzo", 2), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.PRISMARINE, "§ePrismarinho", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.PRISMARINE, "§eTijolo de Prismarinho", 1), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.PRISMARINE, "§ePrismarinho Escuro", 2), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.SEA_LANTERN, "§eLanterna do Mar", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.HAY_BLOCK, "§eFardo de Feno", 0), 100000.0, inv);
        shopAPI.compra(p, newItens.add(Material.RED_SANDSTONE, "§eArenito Vermelho", 0), 100000.0, inv);

        ItemStack voltar = newItens.add(Material.ARROW, "§aVoltar");
        ItemStack anterior = newItens.add(Material.ARROW, "§aPágina anterior");


        inv.setItem(49, voltar);
        inv.setItem(18, anterior);

        p.openInventory(inv);
    }
}