package net.wtako.WTAKOTemplate.Commands.Temp;

import net.wtako.WTAKOTemplate.Utils.Commands;
import org.bukkit.command.CommandSender;

public class ArgHelp {

    public ArgHelp(final CommandSender sender, String[] args) {
        Commands.sendHelp(sender, Commands.values(), "");
    }
}
