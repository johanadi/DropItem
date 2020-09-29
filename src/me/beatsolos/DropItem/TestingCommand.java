package me.beatsolos.DropItem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestingCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if(p.isOp()) {
                DropItem x = new DropItem();

                x.onTimer(p);
            }
        }

        return true;
    }
}
