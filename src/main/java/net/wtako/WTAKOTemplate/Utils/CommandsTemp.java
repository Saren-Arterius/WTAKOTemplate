package net.wtako.WTAKOTemplate.Utils;

import net.wtako.WTAKOTemplate.Main;
import net.wtako.WTAKOTemplate.Commands.Temp.ArgHelp;
import net.wtako.WTAKOTemplate.Commands.Temp.ArgReload;
import net.wtako.WTAKOTemplate.Commands.Temp.SubArgExample;

public enum CommandsTemp implements BaseCommands {

    MAIN_COMMAND(Lang.HELP_HELP.toString(), ArgHelp.class, Main.artifactId + ".use"),
    H(Lang.HELP_HELP.toString(), ArgHelp.class, Main.artifactId + ".use"),
    HELP(Lang.HELP_HELP.toString(), ArgHelp.class, Main.artifactId + ".use"),
    EXAMPLE(Lang.HELP_EXAMPLE.toString(), SubArgExample.class, Main.artifactId + ".use"),
    RELOAD(Lang.HELP_RELOAD.toString(), ArgReload.class, Main.artifactId + ".reload");

    private String   helpMessage;
    private Class<?> targetClass;
    private String   permission;

    private CommandsTemp(String helpMessage, Class<?> targetClass, String permission) {
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
