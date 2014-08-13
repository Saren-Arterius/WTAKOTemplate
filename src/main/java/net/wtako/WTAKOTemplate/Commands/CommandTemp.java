package net.wtako.WTAKOTemplate.Commands;

import java.lang.reflect.InvocationTargetException;

import net.wtako.WTAKOTemplate.Utils.PluginCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandTemp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length >= 1) {
            return callCommand(sender, args, args[0]);
        }
        return callCommand(sender, args, "MAIN_COMMAND");
    }

    public boolean callCommand(CommandSender sender, String[] args, String targetCommandName) {
        try {
            final PluginCommand targetCommand = PluginCommand.valueOf(targetCommandName.toUpperCase());
            if (targetCommand == null) {
                return false;
            }
            targetCommand.getTargetClass().getDeclaredConstructor(CommandSender.class, String[].class)
                    .newInstance(sender, args);
            return true;
        } catch (final IllegalArgumentException e) {
            return false;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
            return false;
        }
    }
}
