package net.wtako.WTAKOTemplate.Commands.Temp;

import net.wtako.WTAKOTemplate.Utils.CommandHelper;
import net.wtako.WTAKOTemplate.Utils.CommandsTemp;

import org.bukkit.command.CommandSender;

public class ArgHelp {

    public ArgHelp(final CommandSender sender, String[] args) {
        CommandHelper.sendHelp(sender, CommandsTemp.values(), "");
    }
}
