package net.wtako.WTAKOTemplate.Commands.Temp;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import net.wtako.WTAKOTemplate.Main;
import net.wtako.WTAKOTemplate.Utils.Lang;
import net.wtako.WTAKOTemplate.Utils.PluginCommand;

import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

public class ArgHelp {

    public ArgHelp(final CommandSender sender, String[] args) {
        new BukkitRunnable() {
            @Override
            public void run() {
                final ArrayList<String> messages = new ArrayList<String>();
                messages.add(Main.getInstance().getName() + " v" + Main.getInstance().getProperty("version"));
                messages.add("Author: " + Main.getInstance().getProperty("author"));
                final HashMap<String, ArrayList<String>> commandHelps = new HashMap<String, ArrayList<String>>();
                for (final PluginCommand command: PluginCommand.values()) {
                    if (command.name().equalsIgnoreCase("MAIN_COMMAND")) {
                        continue;
                    }
                    boolean hasHelpMessage = false;
                    for (final Entry<String, ArrayList<String>> entry: commandHelps.entrySet()) {
                        if (entry.getKey().equalsIgnoreCase(command.getHelpMessage())) {

                            entry.getValue().add(command.name().toLowerCase());
                            hasHelpMessage = true;
                            break;
                        }
                    }
                    if (!hasHelpMessage) {
                        final ArrayList<String> commandList = new ArrayList<String>();
                        commandList.add(command.name().toLowerCase());
                        commandHelps.put(command.getHelpMessage(), commandList);
                    }
                }
                for (final Entry<String, ArrayList<String>> entry: commandHelps.entrySet()) {
                    String displayCommands = "";
                    int counter = 0;
                    for (final String displayCommand: entry.getValue()) {
                        displayCommands += displayCommand;
                        counter++;
                        if (counter < entry.getValue().size()) {
                            displayCommands += Lang.COMMAND_HELP_SEPERATOR;
                        }
                    }
                    messages.add(MessageFormat.format(entry.getKey(), displayCommands));
                }
                sender.sendMessage(messages.toArray(new String[messages.size()]));
            }
        }.runTaskAsynchronously(Main.getInstance());
    }

}