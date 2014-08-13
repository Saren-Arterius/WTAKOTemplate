package net.wtako.WTAKOTemplate.Commands;

import net.wtako.WTAKOTemplate.Commands.Temp.ArgHelp;
import net.wtako.WTAKOTemplate.Commands.Temp.ArgReload;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandTemp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")) {
                new ArgHelp(sender);
                return true;
            } else if (args[0].equalsIgnoreCase("reload")) {
                new ArgReload(sender);
                return true;
            }
        }
        return false;
    }
}
