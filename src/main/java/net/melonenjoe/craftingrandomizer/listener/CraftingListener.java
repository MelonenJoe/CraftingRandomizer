package net.melonenjoe.craftingrandomizer.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import java.util.Random;

public class CraftingListener implements Listener {

    public ItemStack getRandomItemStack() {

        Random random = new Random();

        Material[] randomMaterial = Material.values();

        return new ItemStack(randomMaterial[random.nextInt(1170) + 1], 1);

    }

    @EventHandler
    public void onCraft(CraftItemEvent event) {

        event.getInventory().setResult(getRandomItemStack());

    }

}
