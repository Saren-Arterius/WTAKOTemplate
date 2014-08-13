package net.wtako.WTAKOTemplate.Commands.Temp;

import net.wtako.WTAKOTemplate.Main;
import net.wtako.WTAKOTemplate.Utils.Lang;

import org.bukkit.command.CommandSender;

public class ArgHelp {

    public ArgHelp(CommandSender sender) {
        sender.sendMessage(Main.getInstance().getName() + " v" + Main.getInstance().getProperty("version"));
        sender.sendMessage("Author: " + Main.getInstance().getProperty("author"));
        sender.sendMessage(Lang.HELP_RELOAD.toString());
    }

}
