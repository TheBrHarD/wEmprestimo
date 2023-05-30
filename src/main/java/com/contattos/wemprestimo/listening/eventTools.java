package com.contattos.wemprestimo.listening;

import com.contattos.wemprestimo.api.*;
import com.contattos.wemprestimo.inventories.inventory;
import com.contattos.wemprestimo.inventories.inventoryBlocos;
import com.redeskyller.bukkit.solaryeconomy.SolaryEconomy;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.math.BigDecimal;

public class eventTools implements Listener {
    @EventHandler
    public void onShopTools(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player p)) {
            return;
        }

        if (e.getInventory().getTitle().equalsIgnoreCase("Loja de Ferramentas - [1]")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) return;
            if (e.getCurrentItem().getType() == Material.AIR) return;
            if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
            // feito para uma verificação e sumir erro do console para a api msgError.
            if (e.getCurrentItem().getType() == Material.INK_SACK) return;

            String name = e.getCurrentItem().getItemMeta().getDisplayName();
            String msgFull = "§cSeu inventário está cheio!";

            double playerBalance = SolaryEconomy.economia.getBalance(p.getDisplayName()).doubleValue();
            double price = 100000.0;
            double missingBalance = price - playerBalance;

            ItemStack item = new ItemStack(e.getCurrentItem().getType(), 1,
                    (short) e.getCurrentItem().getDurability());
            ItemStack getBlock = new ItemStack(item.getType(), 1, (short) item.getDurability());

            if (e.getRawSlot() == e.getSlot() && e.getInventory().getTitle().equalsIgnoreCase
                    ("Loja de Ferramentas - [1]")) {
                switch (e.getSlot()) {
                    case 11, 12, 13 -> {
                        if (isInventoryFull(p)) {
                            e.setCancelled(true);
                            p.closeInventory();
                            actionBar.sendAction(p.getPlayer(), msgFull);
                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1f, 1f);
                            return;
                        }
                        if (p.hasPermission("wloja.vip")) {
                            Double valor = shopAPI.preco.get(p);
                            if (playerBalance >= (valor)) {
                                p.getInventory().addItem(getBlock);
                                p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1f, 1f);
                                actionBar.sendAction(p.getPlayer(), "§aVocê comprou §l1x " + name +
                                        "§a por §2$§f" + decimal.formatSimbolo(valor) + " " +
                                        "§acom sucesso!");
                                SolaryEconomy.economia.substractBalance(p.getDisplayName(),
                                        new BigDecimal(valor));
                            } else {
                                msgError.showErrorMessage(p.getPlayer(), e.getInventory(), e.getSlot(),
                                        "§cFalta + §2$§f" + decimal.formatSimbolo
                                                (missingBalance - missingBalance * 0.1) + "§c coins.");
                            }
                        } else {
                            if (playerBalance >= price) {
                                p.getInventory().addItem(getBlock);
                                p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1f, 1f);
                                actionBar.sendAction(p.getPlayer(), "§aVocê comprou §l1x " + name +
                                        "§a por §2$§f" + decimal.formatSimbolo(price) + " §acom sucesso!");

                                SolaryEconomy.economia.substractBalance(p.getDisplayName(), new BigDecimal(price));
                            } else {
                                msgError.showErrorMessage(p.getPlayer(), e.getInventory(), e.getSlot(),
                                        "§cFalta + §2$§f" + decimal.formatSimbolo(missingBalance) +
                                                "§c coins.");
                            }
                            return;
                        }
                    }
                    default -> {
                        if (e.getInventory().getTitle().equalsIgnoreCase("Loja de Blocos - [1]")
                                && e.getCurrentItem() != null
                                && e.getCurrentItem().getTypeId() != 0) {
                            e.setCancelled(true);
                            if (e.getSlot() == 26) {
                                inventoryBlocos.open2(p);
                                return;
                            }
                            if (e.getSlot() == 49) {
                                inventory.open(p);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean isInventoryFull(Player player) {
        Inventory inv = player.getInventory();
        int emptySlots = 0;
        for (ItemStack item : inv.getContents()) {
            if (item == null || item.getType() == Material.AIR) {
                emptySlots++;
            }
        }
        return emptySlots == 0;
    }
}
