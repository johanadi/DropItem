package me.beatsolos.DropItem;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class DropItem implements Listener {

    //there has to be an overall timer that randomly selects a time 1 minute - 3 minutes,
    // and once the timer is up, a random item in ur inventory shall drop.

    @EventHandler
    public void onTimer(Player p) { //this is assuming the timer will trigger this plugin

        ItemStack[] i = p.getInventory().getContents();
        //select a random item within this inventory, not including nulls

        //check if inventory empty
        boolean empty = true;
        for(ItemStack item : p.getInventory().getContents())
        {
            if(item != null)
                empty = false;
        }

        //drop random item
        int random_int = 0;
        do {
            random_int = (int) (Math.random() * (p.getInventory().getContents().length));

        }while (p.getInventory().getItem(random_int) == null && !empty);

        if(p.getInventory().getItem(random_int) != null && p.getInventory().getContents().length > 0) {
            ItemStack item = i[random_int];

            p.getWorld().dropItemNaturally(p.getLocation(), item);
            if(random_int == 40) { // 40 is index of offhand
                p.getInventory().setItemInOffHand(null);
            } else {
                p.getInventory().remove(item);
            }
        }
    }

}
