package net.wtako.WTAKOTemplate.Commands.Temp.Example;

import org.bukkit.command.CommandSender;

public class ArgHi {

    public ArgHi(CommandSender sender, String[] args) {
        sender.sendMessage("Hi! This is a subcommand 'hi' of 'example'.");
    }
}
