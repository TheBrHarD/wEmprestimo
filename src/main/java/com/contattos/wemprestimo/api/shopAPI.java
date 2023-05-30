package com.contattos.wemprestimo.api;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;

public class shopAPI {

    public static HashMap<Player, Double> preco = new HashMap<Player, Double>();
    public static HashMap<Player, ItemStack> loja = new HashMap<Player, ItemStack>();

    public static void compraEvento(Player p, ItemStack item) {
        shopAPI.loja.put(p, item);
        double valor = 0;
        for (String lore : item.getItemMeta().getLore()) {
            if (lore.startsWith("§6Preço: §2$§f")) {
                String debug = lore.split(" ")[1];
                debug = debug.replace("§2$§f", "");
                debug = debug.replace(".", "");
                valor = Double.parseDouble(debug);
            }
        }
        shopAPI.preco.put(p, valor);
    }

    public static void compra(Player p, ItemStack item, Double valor, Inventory inv) {
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> des = new ArrayList<>();
        des.add("");
        if (p.hasPermission("wloja.vip")) {
            des.add(" §8▶ §6Preço: §2$§f§m" + decimal.formatSimbolo(valor) + "§r §7➟ §2$§f" +
                    decimal.formatSimbolo(valor - valor * 0.1));
            des.add(" §8▶ §6Desconto: §f10%");
        } else {
            des.add(" §8▶§6Custo: §2$§f" + decimal.formatSimbolo(valor));
            des.add(" §8▶§6Desconto: §f0%");
        }
        des.add(" ");
        des.add("§aClique para comprar.");
        meta.setLore(des);
        item.setItemMeta(meta);

        for (int x = 11; x < 34; x++) {
            if (x == 16 || x == 25 || x == 34) {
                x = x + 4;
            }
            if (inv.getItem(x) == null) {
                inv.setItem(x, item);
                break;
            }
        }
    }
}