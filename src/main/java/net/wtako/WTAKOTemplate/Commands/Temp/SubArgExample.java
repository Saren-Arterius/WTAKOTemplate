package net.wtako.WTAKOTemplate.Commands.Temp;

import java.lang.reflect.InvocationTargetException;

import net.wtako.WTAKOTemplate.Main;
import net.wtako.WTAKOTemplate.Commands.Temp.Example.ArgHi;
import net.wtako.WTAKOTemplate.Utils.BaseCommands;
import net.wtako.WTAKOTemplate.Utils.CommandsTemp;
import net.wtako.WTAKOTemplate.Utils.Lang;

import org.bukkit.command.CommandSender;

public class SubArgExample {

    public enum SubCommands implements BaseCommands {
        MAIN_COMMAND(Lang.HELP_EXAMPLE.toString(), SubArgExample.class, Main.artifactId + ".use"),
        HI(Lang.HELP_EXAMPLE_HI.toString(), ArgHi.class, Main.artifactId + ".use");

        private String   helpMessage;
        private Class<?> targetClass;
        private String   permission;

        private SubCommands(String helpMessage, Class<?> targetClass, String permission) {
            this.helpMessage = helpMessage;
            this.targetClass = targetClass;
            this.permission = permission;
        }

        @Override
        public String getHelpMessage() {
            return helpMessage;
        }

        @Override
        public Class<?> getTargetClass() {
            return targetClass;
        }

        @Override
        public String getRequiredPermission() {
            return permission;
        }
    }

    public SubArgExample(final CommandSender sender, String[] args) {
        if (args.length < 2 || !callCommand(sender, args, args[1])) {
            CommandsTemp.sendHelp(sender, SubCommands.values(), args[0]);
        }
    }

    public boolean callCommand(CommandSender sender, String[] args, String targetCommandName) {
        try {
            final SubCommands targetCommand = SubCommands.valueOf(targetCommandName.toUpperCase().replace("-", "_"));
            if (targetCommand == SubCommands.MAIN_COMMAND) {
                return false;
            }
            if (!sender.hasPermission(targetCommand.getRequiredPermission())) {
                sender.sendMessage(Lang.NO_PERMISSION_COMMAND.toString());
                return true;
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
