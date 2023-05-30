package com.contattos.wemprestimo.inventories;

import com.contattos.wemprestimo.api.newItens;
import com.contattos.wemprestimo.api.shopAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class inventory implements Listener {

    public static void open(Player p) {
        Inventory inv = Bukkit.createInventory(null, 4 * 9, "Loja de itens");

        ItemStack blocos = newItens.add(Material.STONE, "§aBlocos",
                new String[]{
                        "§7Use os blocos mais elaborados para",
                        "§7fazer o melhor terreno em questão",
                        "§7de beleza.",
                        "",
                        "§aClique para acessar."
                });
        ItemStack decoracoes = newItens.add(Material.RED_ROSE, "§aDecorações",
                new String[]{
                        "§7Decore seu terreno e harmonize",
                        "§7o ambiente.",
                        "",
                        "§aClique para acessar."
                });
        ItemStack utilidades = newItens.add(Material.ENDER_CHEST, "§aUtilidades",
                new String[]{
                        "§7Preguiçosos adoram está categoria,",
                        "§7tudo pronto na mão.",
                        "",
                        "§aClique para acessar."
                });
        ItemStack plantacoes = newItens.add(Material.SUGAR_CANE, "§aPlantações",
                new String[]{
                        "§7Seja ja um fazendeiro em seu terreno",
                        "§7e faça diversas plantações.",
                        "",
                        "§aClique para acessar."
                });
        ItemStack geradores = newItens.add(Material.MOB_SPAWNER, "§aGeradores",
                new String[]{
                        "§7Faça mobs nascerem do além e mate",
                        "§7para ganhar coins e recompensas.",
                        "",
                        "§aClique para acessar."
                });
        ItemStack combate = newItens.add(Material.DIAMOND_SWORD, "§aCombate",
                new String[]{
                        "§7Bora matar geral?",
                        "§7Compre os melhores itens para PVP.",
                        "",
                        "§aClique para acessar."
                });
        ItemStack ferramentas = newItens.add(Material.DIAMOND_PICKAXE, "§aFerramentas",
                new String[]{
                        "§7Utilize as ferramentas mais poderosas",
                        "§7para auxiliar você neste jornada.",
                        "",
                        "§aClique para acessar."
                });

        inv.setItem(11, blocos);
        inv.setItem(12, decoracoes);
        inv.setItem(13, utilidades);
        inv.setItem(14, plantacoes);
        inv.setItem(15, geradores);
        inv.setItem(21, combate);
        inv.setItem(23, ferramentas);

        p.openInventory(inv);
    }
    @EventHandler
    public void onShop(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player p)) {
            return;
        }

        if (e.getInventory().getTitle().equalsIgnoreCase("Loja de itens")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) return;
            if (e.getCurrentItem().getType() == Material.AIR) return;
            if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;

            if (e.getRawSlot() == e.getSlot() && e.getInventory().getTitle()
                    .equalsIgnoreCase("Loja de itens")) {
                ItemStack item = e.getCurrentItem();
                shopAPI.compraEvento(p, item);
                switch (e.getSlot()) {
                    case 11:
                        inventoryBlocos.open1(p);
                        break;
                    case 12:
                        //inventoryDecoracoes.open1(p);
                        break;
                    case 13:
                        //inventoryUtilidades.open1(p);
                        break;
                    case 14:
                        //inventoryGeradores.open1(p);
                        break;
                    case 15:
                        //inventoryPlantacoes.open1(p);
                        break;
                    case 21:
                        //inventoryCombate.open1(p);
                        break;
                    case 23:
                        inventoryFerramentas.open1(p);
                        break;
                    default:
                }
            }
        }
    }
}
