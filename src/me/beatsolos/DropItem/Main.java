package me.beatsolos.DropItem;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;


public class Main extends JavaPlugin implements Listener {

    public void onEnable() {
        //PluginManager pm = this.getServer().getPluginManager();
        //pm.registerEvents(new DropItem(), this);

        this.getCommand("test_command").setExecutor(new TestingCommand());

        //int random_time = (int) (Math.random() * (3 - 1)) + 1;
        
        new BukkitRunnable() {
            @Override
            public void run() {
                for(Player player : Bukkit.getOnlinePlayers()) {
                    DropItem d = new DropItem();
                    d.onTimer(player);
                }
            }
        }.runTaskTimer(this, 0, 20*30);


    }
    public void onDisable() {

    }

}
